/*
读取百度脑图文件，转换成Excel格式
实际上km文件的内在格式是json
 */

package cn.enilu.flash.api.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadJson {
    public static String requirementName;

    public static String readFile(String filepath) {
        StringBuilder sb = new StringBuilder();       // 创建字符串构建器
        try {
            FileReader fis = new FileReader(filepath);  // 创建文件输入流
            BufferedReader br = new BufferedReader(fis);
            char[] data = new char[1024];               // 创建缓冲字符数组
            int rn = 0;
            //fis.read(data)：将字符读入数组。在某个输入可用、发生 I/O 错误或者已到达流的末尾前，此方法一直阻塞。
            // 读取的字符数，如果已到达流的末尾，则返回 -1
            while ((rn = fis.read(data)) > 0) {         // 读取文件内容到字符串构建器
                String str = String.valueOf(data, 0, rn);//把数组转换成字符串
                sb.append(str);
            }
            fis.close();// 关闭输入流
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return sb.toString();
    }

    public static List<List<String>> readJson(String jsonPath) {
        // 所有用例集合
        List<List<String>> allCaseList = new ArrayList<>();
        String str = readFile(jsonPath);
        JSONObject object  = JSON.parseObject(str);
        // root node can be recognized as requirement name
        requirementName = object.getJSONObject("root").getJSONObject("data").get("text").toString();
        // System.out.println(object.getJSONObject("root").getJSONObject("data").get("text"));

        // 1级分类，用于案例组织
        JSONArray level1 = object.getJSONObject("root").getJSONArray("children");
        // System.out.println(level1.size());
        if (level1.size() > 0) {
            for (int i = 0; i < level1.size(); i++) {
//                System.out.println("level1:" + i);
                String level1Name = level1.getJSONObject(i).getJSONObject("data").get("text").toString();

                // 2级分类，用于案例组织
                JSONArray level2 = level1.getJSONObject(i).getJSONArray("children");
                if(level2.size() > 0) {
                    for (int j = 0; j < level2.size(); j++) {
                        // System.out.println("level2:" + j);
                        String level2Name = level2.getJSONObject(j).getJSONObject("data").get("text").toString();

                        // 用例层级
                        JSONArray caseList = level2.getJSONObject(j).getJSONArray("children");
                        if (caseList.size() > 0) {
                            List<String> row = new ArrayList<>();
                            for (int k = 0; k < caseList.size(); k++) {
                                // System.out.println("case:" + k);
                                String caseName = caseList.getJSONObject(k).getJSONObject("data").get("text").toString();
                                row.add(caseName);

                                // 描述层级
                                JSONArray descList = caseList.getJSONObject(k).getJSONArray("children");
                                if(descList.size() > 0) {
                                    for (int l = 0; l < descList.size(); l++) {
                                        // System.out.println("desc:" + l);
                                        String desc = descList.getJSONObject(l).getJSONObject("data").get("text").toString();
                                        row.add(desc);
                                        // System.out.println(level1Name + ":" + level2Name + ":" + caseName + ":" + desc);
                                        //System.out.println("============================================================");
                                        //System.out.println("case: " + caseName);
                                        //System.out.println("desc: " + desc);

                                        // Precodition层级
                                        JSONArray preConditionList = descList.getJSONObject(l).getJSONArray("children");
                                        if(preConditionList.size() > 0) {
                                            for(int m=0; m<preConditionList.size(); m++) {
                                                String preCondition = preConditionList.getJSONObject(m).getJSONObject("data").get("text").toString();
                                                row.add(preCondition);
                                                //System.out.println();
                                                //System.out.println("preCondition: " + preCondition);
                                            }
                                        }
                                        else {
                                            row.add("");
                                        }
                                        allCaseList.add(row);

                                        //System.out.println("*****" + row.size());
                                        // clear current case row
                                        row = new ArrayList<>();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return allCaseList;
    }

    public static void main(String[] args) {
        // just for test
        List<List<String>> allCase = readJson("C:\\git\\xmind2excel-master\\xmind\\Test.km");
        System.out.println();

    }

}
