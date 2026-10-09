/**
 * @Author: Created by Sonu Kumar
 * @Date: 21/01/25 12:14 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.unittest;

import org.jetbrains.annotations.NotNull;

import kotlin.reflect.KClass;

/**
 * Class Definition
 */
public class JaVaTest {
    void javaTest(Test test) {
        javaTest2(JaVaTest.class);
        javaTest2(Test.class);

    }

    void javaTest2(JaVaTest jaVaTest) {

    }

    public void javaTest2(@NotNull Class<?> java) {

    }

    public void javaTest2(@NotNull KClass<?> kClass) {

    }
}
