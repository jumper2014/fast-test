package com.example.framework;

import com.example.App;
import com.example.framework.util.FileExtractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.lang.reflect.Method;

/**
 * 1. Test case management by TestNG methods: beforeSuite/afterSuite, beforeClass/afterClass, setup/tearDown
 * 2. Common method used to clean web drivers/sftp/database/TestNG runtime copy files
 * 3. There is not any configuration initialized at BeforeSuite phase, that is limitation of SpringBootTest framework
 * 4. Failure handling
 */
@Listeners(TestListener.class)
@SpringBootTest(classes = App.class )
public class BaseTest extends AbstractTestNGSpringContextTests {
    /*
    AbstractTestNGSpringContextTests：测试类只有继承了该类才能拥有注入实例能力，否则注入报错
    AbstractTransactionalTestNGSpringContextTests：测试类继承该类后拥有注入实例能力，同时拥有事务控制能力
     */
    private static final Logger baseTestLogger = LoggerFactory.getLogger(BaseTest.class);

    public BaseTest() {
        TestReport.initReport();
    }

    /**
     * Called in TestNG BeforeSuite
     */
    public void initTestSuite() {
        baseTestLogger.info("[BeforeSuite] ......");
        TestReport.cleanTestResult();
    }

    /**
     * Called in TestNG AfterSuite
     *
     */
    public void cleanTestSuite(String envName) {
        baseTestLogger.info("[AfterSuite] envName: {}", envName);
        FileExtractor.deleteTestNGFiles();
    }

    /**
     * Called in TestNG BeforeClass
     */
    public void beforeTestClass() {
        baseTestLogger.info("[BeforeClass] ......");
    }

    /**
     * Called in TestNG AfterClass
     */
    public void cleanTestClass() {
        baseTestLogger.info("[AfterClass] ......");
    }

    /**
     * Called in TestNG BeforeMethod
     *
     * @param method getName()返回的是虚拟机里面的class的表示，而getCanonicalName()返回的是更容易理解的表示。其实对于大部分class来说这两个方法没有什么不同的。
     *               但是对于array或内部类来说是有区别的。
     *               另外，类加载（虚拟机加载）的时候需要类的名字是getName。
     */
    public void initTestMethod(Method method) {
        baseTestLogger.info("[BeforeMethod] ......");
        TestReport.startTest(getClass().getCanonicalName() + "." + method.getName());
    }

    /**
     * Called in TestNG AfterMethod
     *
     */
    public void cleanTestMethod(ITestResult result) {
        baseTestLogger.info("[AfterMethod] ......");
        TestReport.updateTest();
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        initTestSuite();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception {
        super.springTestContextPrepareTestInstance();
        beforeTestClass();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() throws Exception {
        super.springTestContextAfterTestClass();
        cleanTestClass();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) throws Exception {
        super.springTestContextBeforeTestMethod(method);
        initTestMethod(method);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result, Method method) throws Exception {
        super.springTestContextAfterTestMethod(method);
        cleanTestMethod(result);
    }
}
