package com.ys.app;

import com.ys.util.HttpRequest;
import com.ys.util.HttpClient;
import com.ys.util.NodeParser;

import javax.xml.soap.Node;

/**
 * Created by ijumper on 2017/7/1.
 */
public class Dashboard {

    public String searchWithUrl(String url) {

        String fullUrl = "http://" + Constants.ANDROID_HOST + ":" + Constants.SDK_PORT + url;
        HttpRequest client = new HttpRequest();
        System.out.println(fullUrl);
        String result = client.getResponse(fullUrl);
        System.out.println(result);
        return result;

    }

    public String getVersion() {
        String content = searchWithUrl("/ajax/version");
        String version = NodeParser.getJsonValueFromPath(content, "/core");
        System.out.println(version);
        return version;
    }

}
