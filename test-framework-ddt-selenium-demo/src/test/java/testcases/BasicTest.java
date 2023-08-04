package testcases;

import caseentities.CaseStep;
import caseentities.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.TestNG;
import ui.page.BasePage;
import utils.TestCasesUtil;
import utils.dataReaders.ConfigReader;
import java.lang.reflect.Method;
import java.util.List;

public class BasicTest {
    private static final Logger logger = LoggerFactory.getLogger(BasicTest.class);
    protected static final String caseDataFolder = System.getProperty("user.dir") + "/src/test/data/cases/";


    public Object runTestCase(String testCaseFile, String testCaseSheet, String testCaseName, Object initialPageObj) throws Exception {
        Object pageObjNeedClose = initialPageObj;
        TestCasesUtil testCasesUtil = new TestCasesUtil();
        List<TestCase> testCases = testCasesUtil.Excel2TestCaseList(testCaseFile, testCaseSheet);
        String caseDataFile = testCaseFile.substring(testCaseFile.indexOf("src"));

        logger.info("Excel文件{}工作表{}中测试用例数量为：{}个", caseDataFile, testCaseSheet, testCases.size());
        boolean caseFound = false;
        for (TestCase testCase: testCases) {
            String testCaseId = testCase.getCaseId();


            //找到匹配的CaseIndex, 读取Step信息，按步骤进行操作
            if (testCaseId.equalsIgnoreCase(testCaseName)) {
                caseFound = true;
                if (testCase.isCaseRunFlag()) {
                    logger.info("找到Case名为{}的用例，准备读取执行步骤相关信息", testCaseName);

                    //检查是否配置了预跑的Case, 配置格式："Run case <XXXTest;YYYTest>"
                    boolean testCasePreConditionRunFlag = testCase.isCasePreConditionRunFlag();
                    String testCasePreConditionCmd = testCase.getCasePreConditionCmd();

                    if(testCasePreConditionRunFlag){//设置了需要执行前置条件列的命令
                        if (testCasePreConditionCmd != null && testCasePreConditionCmd.toUpperCase().startsWith("RUN CASE")){
                            String preRunTestClazzes = testCasePreConditionCmd.substring(testCasePreConditionCmd.indexOf("<")+1, testCasePreConditionCmd.lastIndexOf(">"));
                            logger.info("【需要预跑的Test Cases】: {}" , preRunTestClazzes);//IRDAddPageTest.testAddIRD_CHANNEL_POS

                            int grpIndex = testCasePreConditionCmd.indexOf("@groups:");
                            String groups = "";
                            if(grpIndex != -1) {//存在Group标签
                                groups = testCasePreConditionCmd.substring(grpIndex + 8);
                            }
                            logger.info("【需要预跑Test Cases 标记的Groups】: {}", groups);
                            TestNG tng = new TestNG();
                            if(preRunTestClazzes.contains(";")){
                                String[]  prTCs = preRunTestClazzes.split(";");

                                Class[] preTestClazz;
                                preTestClazz = new Class[prTCs.length];
                                for(int pi = 0; pi< prTCs.length; pi ++){
                                    String preClazz = ConfigReader.getTestCassClassName(prTCs[pi]);
                                    preTestClazz[pi] = Class.forName(preClazz);
                                }
                                tng.setTestClasses(preTestClazz);
                            }else{
                                String preClazz = ConfigReader.getTestCassClassName(preRunTestClazzes);
                                tng.setTestClasses(new Class[]{Class.forName(preClazz)});
                            }
                            if(!groups.equals("")) {
                                tng.setGroups(groups);
                            }
                            tng.run();
                        }else{
                            logger.error("前置条件Flag设置为True，但Run PreCondition Cmd列中Command不符合合适RUN CASE<XXXTest>!!!!");
                        }//以上是预跑Case的代码，现阶段只支持Run XXXTest中所有Case
                    }else{
                        logger.info("前置条件Flag设置为False，不需要Run PreCondition Cmd列中的Test Case");
                    }

                    List<CaseStep> caseSteps = testCase.getCaseStepList();
                    logger.info("找到用例{}的执行步骤数为：{}步", testCaseName, caseSteps.size());

                    Object previousStepReturnObj = null;
                    Object existingPageObject = null;

                    for (int j = 0; j < caseSteps.size(); j++) {
                        CaseStep caseStep = caseSteps.get(j);

                        //如果Case中Step要Run，取到所有操作需要的信息
                        if (caseStep.isStepRunFlag()) {
                            Object pageObj = null;
                            Class<?> pageObjClass = null;

                            String pageName = caseStep.getStepPOClassName(); //从Excel表中获取到PO Class名称

                            String stepMethodName = caseStep.getStepPOMethodName();//从Excel表中获取到Method名称
                            caseStep.getStepPOMethodParams();

                            //用objClassName来判断引用上一步返回的对象，还是重新Initiate一个新对象进行操作
                            if (pageName.startsWith("%")){//从外部传的参数中取PO对象，或者从上一个步骤中接受PO对象
                                 if (existingPageObject == null && initialPageObj != null) {
                                    logger.info("正在处理步骤{}，需要引用参数传入的对象", (j + 1));
                                    pageObj = initialPageObj;
                                    pageObjClass = initialPageObj.getClass();
                                    logger.info("引用参数传入的对象，class名称为{}", pageObjClass.toString());
                                } else if (existingPageObject != null) {
                                     logger.info("正在处理步骤{}，需要前一步骤中使用的Page对象或返回的Page对象", (j + 1));
                                     pageObj = existingPageObject;
                                     pageObjClass = existingPageObject.getClass();
                                     logger.info("引用前一步骤的Page对象，class名称为{}", pageObjClass.toString());
                                 } else {
                                     logger.info("测试用例参数配置错误，请检查是否初始化页面对象作为参数传入，或上一步是否有对象可引用！");
                                 }
                            } else {
                                logger.info("正在处理步骤{}，不需要接收上一步返回的对象", (j+ 1));
                                //读取配置的页面Class名称，并通过类名获取PO类的字节码对象
                                String pageObjClassName = ConfigReader.getPageClassName(pageName);
                                pageObjClass = Class.forName(pageObjClassName);

                            }

                            String[] stepPOMethodParamStrings = caseStep.getStepPOMethodParams();

                            logger.info("Excel配置CaseStep：{}，Object：{}，Method：{}，参数个数：{}个",
                                    caseStep.getStepIndex(), pageObjClass != null ? pageObjClass.toString(): null, stepMethodName,
                                    stepPOMethodParamStrings != null ? stepPOMethodParamStrings.length : 0);

                            Object[] stepArguments = new Object[]{};
                            Class[] argsClass = new Class[]{};

                            if (stepPOMethodParamStrings != null) {
                                int paramLength = stepPOMethodParamStrings.length;
                                argsClass = new Class[paramLength]; //invoke方法中需要用到的类型
                                stepArguments = new Object[paramLength];

                                for (int x = 0; x < paramLength; x++) {
                                    String stepPOMethodParamString = stepPOMethodParamStrings[x];
                                    if (stepPOMethodParamString != null && stepPOMethodParamString.startsWith("%POFromPrevStep") ){
                                        //设置动态参数，如果配置时以%POFromPrevStep开始，则用上一步骤的返回值进行替换
                                        argsClass[x] = BasePage.class; //替换参数类型为PageObject
                                        stepArguments[x] = existingPageObject;
                                        logger.info("替换参数，第{}个参数替换为页面对象{}", (x + 1), existingPageObject != null? existingPageObject.toString() :"");
                                    }else{
                                        argsClass[x] = String.class;
                                        if (stepPOMethodParamString != null && stepPOMethodParamString.contains("%") && stepPOMethodParamString.contains("ReturnValue") && previousStepReturnObj != null) {
                                            //设置动态参数，如果配置时以%开始，则用上一步骤的返回值进行替换
                                            stepArguments[x] = previousStepReturnObj.toString();
                                            logger.info("替换参数，第{}个参数替换为{}", (x + 1), previousStepReturnObj != null? previousStepReturnObj.toString():"");
                                        } else if (("\"\"").equals(stepPOMethodParamString)) {
                                            //如果参数为空，Case中使用""代表，代码中进行替换
                                            stepArguments[x] = "";
                                            logger.info("替换参数，第{}个参数替换为空", (x + 1));
                                        }else{
                                            stepArguments[x] = stepPOMethodParamString;
                                        }
                                    }
                                }
                            }

                            //动态调用Object的方法
                            Object returnObj = null;
                            try {
                                if(pageObjClass != null) {
                                    Method stepMethod = pageObjClass.getMethod(stepMethodName, argsClass);
                                    logger.info("动态调用PO的方法 {}", stepMethod == null? "Null": stepMethod.toString());
                                    returnObj = stepMethod.invoke(pageObjClass.cast(pageObj), stepArguments);
                                }
                            }catch (Exception e){
                                    logger.error("按Case配置调用页面方法{}时出错，出错信息{}", stepMethodName, e.getMessage());
                                    e.printStackTrace();
                                    throw e;
                            }

                            // boolean poChanged = false;
                            if (returnObj != null) {//如果有返回值，则设置到上一个步骤返回对象中，给下一步使用
                                logger.info("步骤{}调用方法的返回类型为{}", (j+ 1), returnObj.getClass());
                                if (returnObj.getClass().toString().endsWith("Page")) {
                                    logger.info("更新使用中的PageObject对象为{}", returnObj.getClass());
                                    existingPageObject = returnObj;
                                    // poChanged = true;
                                }
                                previousStepReturnObj = returnObj;
                            }

                            //执行方法后，如果是InquiryPage等待1秒钟；可能页面数据需要刷新，比如数据查询, 不管页面对象是否改变
                            if(existingPageObject!= null && existingPageObject.getClass().toString().endsWith("InquiryPage") ){//&& poChanged
                                int waitSecond = 1;
                                logger.info("等待{}秒钟，页面数据可能需要刷新", waitSecond);
                                Thread.sleep(waitSecond * 1000);
                            }

                            pageObjNeedClose = existingPageObject;//把当前页面对象赋给参数，以备最后测试结束后关闭页面
                        }else{
                            logger.info("执行步骤{}的RunFlag设置为No，忽略执行该步骤！", caseStep.getStepIndex());
                        }
                    }
                }else{
                    logger.info("【Case Ignored】找到Case名为{}的用例, 但Case RunFlag设置为No，忽略执行该用例下的所有步骤，直接返回Case执行完毕信息！", testCaseName);
                    pageObjNeedClose = initialPageObj;
                }
            }
        }

        if(!caseFound){
            logger.error("未在Excel中找到Case名为{}的用例，请检查配置信息!!!", testCaseName);
            throw new Exception("Case名未在Excel中正确配置！");
        }

        return pageObjNeedClose;
    }
}