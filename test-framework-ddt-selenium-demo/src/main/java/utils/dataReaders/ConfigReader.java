package utils.dataReaders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.Properties;

public class ConfigReader {
    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);
    private static final String configFolder = System.getProperty("user.dir") + "/config/";
    private static final String pageCfgFileName = configFolder + "page.properties";
    private static final String testClassCfgFileName = configFolder + "testclass.properties";
    private static final String envCfgFileName = configFolder + "env.properties";
    private static final String settingFileName = configFolder + "setting.properties";
    private static final String browserCfgFileName = configFolder + "browser.properties";

    public static String getPageClassName(String pageName) throws Exception {
        InputStream inputStream = new BufferedInputStream(new FileInputStream(pageCfgFileName));
        Properties prop = new Properties();
        String pageObjectClassName = null;
        try {
            prop.load(inputStream);
            pageObjectClassName = prop.getProperty(pageName);
            if (pageObjectClassName == null) {
                pageObjectClassName = pageName;
                logger.info("页面关键字{}在配置文件中未配置，尝试直接使用", pageName);
            } else {
                logger.info("已读出{}在配置文件中Java类是：{}", pageName, pageObjectClassName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
        }
        return pageObjectClassName;
    }

    /**
     * 从Config文件中读出pageObjClassName
     *
     * @param testClassName
     * @return
     * @throws Exception
     */
    public static String getTestCassClassName(String testClassName) throws Exception {
        // 通过输入缓冲流进行读取配置文件
        InputStream inputStream = new BufferedInputStream(new FileInputStream(new File(testClassCfgFileName)));
        Properties prop = new Properties();
        String pageObjectClassName = null;
        try {
            prop.load(inputStream);
            pageObjectClassName = prop.getProperty(testClassName);
            if (pageObjectClassName == null) {
                pageObjectClassName = testClassName;
                logger.info("页面关键字{}在配置文件中未配置，尝试直接使用", testClassName);
            } else {
                logger.info("已读出{}在配置文件中Java类是：{}", testClassName, pageObjectClassName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
        }
        return pageObjectClassName;
    }

    /**
     * 从Config文件中读出特定环境下配置的属性信息
     *
     * @param keyName
     * @return
     * @throws Exception
     */
    public static String getEnvProperty(String keyName) throws Exception {
        // 通过输入缓冲流进行读取配置文件
        InputStream inputStream = new BufferedInputStream(new FileInputStream(new File(envCfgFileName)));
        Properties prop = new Properties();
        String value = null;
        try {
            prop.load(inputStream);

            value = prop.getProperty(keyName);
            if (value == null) {
                value = keyName;
                logger.info("{}在配置文件未配置，直接使用", keyName);
            } else {
                logger.info("已读出{}在配置文件中的值为：{}", keyName, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
        }
        return value;
    }

    /**
     * 从Config文件中读出全局配置信息
     *
     * @param keyName
     * @return
     * @throws Exception
     */
    public static String getSettingProp(String keyName) throws Exception {
        // 通过输入缓冲流进行读取配置文件
        InputStream inputStream = new BufferedInputStream(new FileInputStream(settingFileName));
        Properties prop = new Properties();
        String value = null;
        try {
            prop.load(inputStream);
            value = prop.getProperty(keyName);
            if (value == null) {
                value = keyName;
                logger.info("{}在配置文件未配置，直接使用", keyName);
            } else {
                logger.info("已读出{}在配置文件中的值为：{}", keyName, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
        }
        return value;
    }

    /**
     * 从Config文件中读出浏览器配置信息
     *
     * @param keyName
     * @return
     * @throws Exception
     */
    public static String getBrowserProp(String keyName) throws Exception {
        // 通过输入缓冲流进行读取配置文件
        InputStream inputStream = new BufferedInputStream(new FileInputStream(browserCfgFileName));
        Properties prop = new Properties();
        String value = null;
        try {
            prop.load(inputStream);
            value = prop.getProperty(keyName);
            if (value == null) {
                value = keyName;
                logger.info("{}在配置文件未配置，直接使用", keyName);
            } else {
                logger.info("已读出{}在配置文件中的值为：{}", keyName, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
        }
        return value;
    }

    public static String getCfgProperty(String fileName, String KeyName) throws Exception {
        String value = null;
        // 通过输入缓冲流进行读取配置文件
        String cfgFileName = configFolder + fileName;
        InputStream inputStream = new BufferedInputStream(new FileInputStream(cfgFileName));
        Properties prop = new Properties();
        try {
            prop.load(inputStream);
            value = prop.getProperty(KeyName);
            if (value == null) {
                value = KeyName;
                logger.info("{}在配置文件未配置，直接使用", KeyName);
            } else {
                logger.info("已读出{}在配置文件中的值为：{}", KeyName, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
        }
        return value;
    }
}
