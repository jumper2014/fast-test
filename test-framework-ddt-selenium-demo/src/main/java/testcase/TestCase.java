package testcase;

import lombok.Data;
import java.util.List;

@Data
public class TestCase {
    private String caseId;
    private boolean caseRunFlag;
    private String caseName;
    private String caseDescription;
    private boolean casePreConditionRunFlag;
    private String casePreConditionCmd;
    private List<TestStep> testSteps;
}
