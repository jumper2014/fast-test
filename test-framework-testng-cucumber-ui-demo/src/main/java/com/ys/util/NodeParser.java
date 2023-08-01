package com.ys.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.lang.reflect.Array;


/**
 * Created by ijumper on 15/11/3.
 */
public class NodeParser {


    /*
    public String getRecorderValues(String body) {
        String records = getNodeValue(body, "/records");
        return records;

    }
    */

    public static String getNodeValue(String body, String nodePath) {
        return getJsonValueFromPath(body, nodePath);
    }

    public static String getJsonValue(String body, String nodePath) {
        return getJsonValueFromPath(body, nodePath);
    }

    public static String getJsonValueFromPath(String body, String path) {
        // remove first "/"
        if (path.substring(0, 1).equals("/")) {
            path = path.substring(1);
        }
        String [] pathArray = path.split("/");

        for( String str: pathArray) {
            JSONObject jsonObj = JSONObject.fromObject(body);
            body = jsonObj.get(str).toString();
            //System.out.println(str);
        }
        return body;
    }





    public static void main(String[] args) {
        String body = "{ \"employees\": { \"firstName\":\"Bill\" , \"lastName\":\"Gates\" }}";
        String testStr = "{\"firstName\":\"Bill\",\"lastName\":\"Gates\"}";
        //System.out.println(NodeParser.getJsonValue(body, "employees"));
        System.out.println(getJsonValueFromPath(body, "/employees/firstName"));
    }



}
