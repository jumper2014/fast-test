package ui.element;

public class ElementInfo {
    //元素名称
    private String elementName;

    //元素查找方式
    private String type;

    //元素查找线索1-Location
    private String locationClue;

    //元素查找线索2-JS
    private String actionJavaScript;

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }
    public String getElementName(){
        return elementName;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }


    public void setLocationClue(String locationClue) {
        this.locationClue = locationClue;
    }
    public String getLocationClue(){
        return locationClue;
    }

    public void setActionJavaScript(String actionJavaScript) {
        this.actionJavaScript = actionJavaScript;
    }
    public String getActionJavaScript(){
        return actionJavaScript;
    }

}