package testcase;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class TestStep {
    private static final Logger logger = LoggerFactory.getLogger(TestStep.class);
    private String stepIndex;
    private boolean stepRunFlag;
    private String stepPOClassName;
    private String stepPOMethodName;
    private String[] stepPOMethodParams;
    private String relatedElementIndicators;

    public void setStepPOMethodParams(String stepPOMethodParamStrings){
        if(!stepPOMethodParamStrings.equals("")) {
            String[] stepPOMethodParamMap = stepPOMethodParamStrings.split(";");
            this.stepPOMethodParams = stepPOMethodParamMap;
        }
    }

}