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
    private static final String STEP_INITIATE_ELEMENTS = "InitiateElements";

    public List<TestCase> Excel2TestCaseList(String excelFile, String sheetName) throws Exception {
        ExcelReader excelReader = new ExcelReader(excelFile);
        List<Map<String, String>> allSteps = excelReader.readExcelData2MapList(sheetName);
        List<TestCase> allTestCases = new ArrayList<>();
        TestCase testcase = null;
        String currentCaseId = "";
        List<CaseStep> caseSteps = null;

        for (int i = 0; i < allSteps.size(); i++) {
            String caseId = allSteps.get(i).get(CASE_ID);
            String caseRunFlag = allSteps.get(i).get(CASE_RUN_FLAG);
            String caseName = allSteps.get(i).get(CASE_NAME);
            String caseDescription = allSteps.get(i).get(CASE_DESCRIPTION);
            String casePreConditionRunFlag = allSteps.get(i).get(CASE_PRE_CONDITION_RUN_FLAG);
            String casePreCondition = allSteps.get(i).get(CASE_PRE_CONDITION_CMD);

            // steps for different cases
            if (caseId != null
                    && !caseId.equalsIgnoreCase("")
                    && !caseId.equalsIgnoreCase(currentCaseId)) {
                // record new caseId
                currentCaseId = caseId;
                if (i != 0) {  // save previous testcase to list
                    // already initialized
                    if (testcase != null) {
                        testcase.setCaseSteps(caseSteps);
                    }
                    allTestCases.add(testcase);
                }

                // new case
                testcase = new TestCase();
                caseSteps = new ArrayList<>();

                testcase.setCaseId(caseId);
                testcase.setCaseName(caseName);
                testcase.setCaseDescription(caseDescription);

                if (caseRunFlag != null) {
                    if (caseRunFlag.equalsIgnoreCase("Y") || caseRunFlag.equalsIgnoreCase("Yes")) {
                        testcase.setCaseRunFlag(true);
                    } else {
                        testcase.setCaseRunFlag(false);
                    }
                }

                if (casePreConditionRunFlag != null) {
                    if (casePreConditionRunFlag.equalsIgnoreCase("Y") || casePreConditionRunFlag.equalsIgnoreCase("Yes")) {
                        testcase.setCasePreConditionRunFlag(true);
                    } else {
                        testcase.setCasePreConditionRunFlag(false);
                    }
                }
                testcase.setCasePreConditionCmd(casePreCondition);
            }

            // steps for same case
            CaseStep caseStep = new CaseStep();
            caseStep.setStepIndex(allSteps.get(i).get(STEP_INDEX));
            String stepRunFlag = allSteps.get(i).get(STEP_RUN_FLAG);
            if (stepRunFlag != null) {
                if (stepRunFlag.equalsIgnoreCase("Y") || stepRunFlag.equalsIgnoreCase("Yes")) {
                    caseStep.setStepRunFlag(true);
                } else {
                    caseStep.setStepRunFlag(false);
                }
            }

            caseStep.setStepPOClassName(allSteps.get(i).get(STEP_PO_CLASSNAME));
            caseStep.setStepPOMethodName(allSteps.get(i).get(STEP_PO_METHOD));
            caseStep.setStepPOMethodParams(allSteps.get(i).get(STEP_PO_METHOD_PARAM));
            caseStep.setRelatedElementIndicators(allSteps.get(i).get(STEP_INITIATE_ELEMENTS));

            if (caseSteps != null) {
                caseSteps.add(caseStep);
            }
        }

        // save last case to list
        if (testcase != null) {
            testcase.setCaseSteps(caseSteps);
        }
        allTestCases.add(testcase);

        String caseDataFile = excelFile.substring(excelFile.indexOf("src"));
        logger.info("Excel {} sheet {} saved to allTestCases！", caseDataFile, sheetName);
        return allTestCases;
    }

}
