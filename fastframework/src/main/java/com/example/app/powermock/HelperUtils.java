package com.example.app.powermock;

public class HelperUtils {
    public static boolean print(String msg) {
        System.out.println("Printing "+msg);
        return true;
    }

    private String getPrivateMethod() {
        return "Hello from the Private Method!";
    }
    public String privateMethodCaller() {
        return getPrivateMethod() + " Welcome to the Application Developer's Blog";
    }

    public final String getFinalMethod() {
        return "Hello from the Final Method!";
    }
}
