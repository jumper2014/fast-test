package utils;

import caseentities.CaseStep;
import caseentities.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.dataReaders.ExcelReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestCasesUtil {
    private static final Logger logger = LoggerFactory.getLogger(TestCasesUtil.class);

    private static final String CASE_ID = "CaseId";
    private static final String CASE_RUN_FLAG = "CaseRunFlag";
    private static final String CASE_NAME = "CaseName";
    private static final String CASE_DESCRIPTION = "CaseDescription";
    private static final String CASE_PRE_CONDITION_RUN_FLAG = "PreConditionRunFlag";
    private static final String CASE_PRE_CONDITION_CMD = "PreConditionCmd";

    private static final String STEP_INDEX = "StepIndex";
    private static final String STEP_RUN_FLAG = "StepRunFlag";
    private static final String STEP_PO_CLASSNAME = "PageObjClassName";
    private static final String STEP_PO_METHOD = "PageObjMethod";
    private static final String STEP_PO_METHOD_PARAM = "MethodParams";
    private static final String STEP_RETURN_OBJECT_CLASSNAME = "ReturnObjClassName";
    private static final String STEP_INITIATE_ELEMENTS = "InitiateElements";

    public List<TestCase> Excel2TestCaseList(String excelFile, String sheetName) throws Exception{
        ExcelReader excelReader = new ExcelReader(excelFile);
        List<Map<String, String>> dataList = excelReader.readExcelData2MapList(sheetName);
        List<TestCase> testCases = new ArrayList<>();
        TestCase oneTestCase = null;
        String currentCaseId = "";
        List<CaseStep> caseStepList = null;

        for(int i = 0; i < dataList.size(); i++){
            String caseId = dataList.get(i).get(CASE_ID);
            String caseRunFlag = dataList.get(i).get(CASE_RUN_FLAG);
            String caseName = dataList.get(i).get(CASE_NAME);
            String caseDescription = dataList.get(i).get(CASE_DESCRIPTION);
            String casePreConditionRunFlag = dataList.get(i).get(CASE_PRE_CONDITION_RUN_FLAG);
            String casePreCondition = dataList.get(i).get(CASE_PRE_CONDITION_CMD);

            if (caseId!= null && !caseId.equalsIgnoreCase("") && !caseId.equalsIgnoreCase(currentCaseId)){
                currentCaseId = caseId;
                if(i != 0) {  //非第一次读到Case信息，将已读到的信息放入Case列表
                    //把现有收集到的Case对象和StepList放到testCases列表中；
                    if(oneTestCase != null) {
                        oneTestCase.setCaseStepList(caseStepList);
                    }
                    testCases.add(oneTestCase);

                    //清空待再次放数据
                    caseStepList = null;
                    oneTestCase = null;
                }

                //新建一个Case对象
                oneTestCase = new TestCase();
                caseStepList = new ArrayList<>();

                oneTestCase.setCaseId(caseId);
                if(caseRunFlag != null) {
                    if (caseRunFlag.equalsIgnoreCase("Y") || caseRunFlag.equalsIgnoreCase("Yes")) {
                        oneTestCase.setCaseRunFlag(true);
                    } else {
                        oneTestCase.setCaseRunFlag(false);
                    }
                }
                oneTestCase.setCaseName(caseName);
                oneTestCase.setCaseDescription(caseDescription);

                if(casePreConditionRunFlag != null) {
                    if (casePreConditionRunFlag.equalsIgnoreCase("Y") || casePreConditionRunFlag.equalsIgnoreCase("Yes")) {
                        oneTestCase.setCasePreConditionRunFlag(true);
                    } else {
                        oneTestCase.setCasePreConditionRunFlag(false);
                    }
                }
                oneTestCase.setCasePreConditionCmd(casePreCondition);
            }

            CaseStep caseStep = new CaseStep();
            //取CaseStep相关的信息，放入CaseStep对象中
            String stepIndex = dataList.get(i).get(STEP_INDEX);
            caseStep.setStepIndex(stepIndex);
            String stepRunFlag = dataList.get(i).get(STEP_RUN_FLAG);
            if(stepRunFlag != null) {
                if (stepRunFlag.equalsIgnoreCase("Y") || stepRunFlag.equalsIgnoreCase("Yes")) {
                    caseStep.setStepRunFlag(true);
                } else {
                    caseStep.setStepRunFlag(false);
                }
            }

            String pageObjName = dataList.get(i).get(STEP_PO_CLASSNAME);
            caseStep.setStepPOClassName(pageObjName);

            String pageObjMethod = dataList.get(i).get(STEP_PO_METHOD);
            caseStep.setStepPOMethodName(pageObjMethod);

            String methodParams = dataList.get(i).get(STEP_PO_METHOD_PARAM);
            caseStep.setStepPOMethodParams(methodParams);

            String relatedElements =dataList.get(i).get(STEP_INITIATE_ELEMENTS);
            caseStep.setRelatedElementIndicators(relatedElements);

            if(caseStepList != null) {
                caseStepList.add(caseStep);
            }
        }

        //把现有收集到的Case对象和StepList放到testCases列表中；
        if(oneTestCase != null) {
            oneTestCase.setCaseStepList(caseStepList);
        }
        testCases.add(oneTestCase);

        String caseDataFile = excelFile.substring(excelFile.indexOf("src"));
        logger.info("Excel文件{}工作表{}的数据已整理到TestCase对象和CaseStep对象列表中！", caseDataFile, sheetName);

        //清空临时List
        caseStepList = null;
        oneTestCase = null;

        return testCases;
    }

}
