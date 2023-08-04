package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.element.ElementInfo;
import utils.dataReaders.ExcelReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementInfoUtil {
    private static final Logger logger = LoggerFactory.getLogger(ElementInfoUtil.class);

    final String elementNameKeyWord = "Name";
    final String byTypeKeyWord = "Type";
    final String locationClueKeyWord = "Clue";
    final String actionJSKeyWord = "JavaScript";

    public Map<String, ElementInfo> Excel2ElementInfoMap(String dataFile, String allElementsSheet) throws Exception {
        ExcelReader excelReader = new ExcelReader(dataFile);
        List<Map<String, String>> elementDataMapList = excelReader.readExcelData2MapList(allElementsSheet);

        Map<String, ElementInfo> elementInfoMap = new HashMap<>();
        for (Map<String, String> elementDataMap : elementDataMapList) {
            ElementInfo elementInfo = new ElementInfo();
            for (String key : elementDataMap.keySet()) {
                String value = elementDataMap.get(key);
                if (key.endsWith(elementNameKeyWord)) {
                    elementInfo.setElementName(value);
                } else if (key.endsWith(byTypeKeyWord)) {
                    elementInfo.setType(value);
                } else if (key.endsWith(locationClueKeyWord)) {
                    elementInfo.setLocationClue(value);
                } else if (key.endsWith(actionJSKeyWord)) {
                    elementInfo.setActionJavaScript(value);
                }
            }
            elementInfoMap.put(elementInfo.getElementName(), elementInfo);
        }
        return elementInfoMap;
    }
}