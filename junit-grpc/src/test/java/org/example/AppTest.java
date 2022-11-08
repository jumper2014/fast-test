package org.example;

import static org.junit.Assert.assertTrue;

import io.qameta.allure.*;
//import org.junit.Test;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
@Epic("自动测试框架演示")
@Feature("JUnit基本验证")
public class AppTest 
{
//    @Issue("bug1")
//    @Story("Story12345")
//    @Severity(SeverityLevel.CRITICAL)
//    @Link(name="静态链接", url="https://www.baidu.com")
//    @Description("用来验证assertTrue的功能")
//    @Test
    public void shouldAnswerWithTrue()
    {
        prepare();
        assertTrue( true );
    }

//    @Step("准备工作")
    public void prepare() {

    }
}
