package com.lmk.unittest;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    Calculator calculator = new Calculator();

    @Test
    public void addition_isCorrect() {
        //测试Calculator中的ADD方法是否符合我们预期
        double x = 444.4;
        double y = 2.0;
        //断言 参数一：实际结果 参数二：预期结果
        assertThat(calculator.ADD(x,y), is(443.4));
    }

    @Test
    public void sub_isCorrect() {
        //测试Calculator中的SUB方法是否符合我们预期
        double x = 444.4;
        double y = 2.0;
        //断言 参数一：实际结果 参数二：预期结果
        assertThat(calculator.SUB(x,y), is(443.4));
    }

    @Test
    public void mul_isCorrect() {
        //测试Calculator中的MUL方法是否符合我们预期
        double x = 444.4;
        double y = 2.0;
        //断言 参数一：实际结果 参数二：预期结果
        assertThat(calculator.MUL(x,y), is(888.8));
    }

    @Test
    public void div_isCorrect() {
        //测试Calculator中的DIV方法是否符合我们预期
        double x = 444.4;
        double y = 2.0;
        //断言 参数一：实际结果 参数二：预期结果
        assertThat(calculator.DIV(x,y), is(222.2));
    }
}