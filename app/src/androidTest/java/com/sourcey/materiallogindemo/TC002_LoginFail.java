package com.sourcey.materiallogindemo;


import androidx.test.espresso.Espresso;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.startsWith;

@RunWith(AndroidJUnit4ClassRunner.class)

public class TC002_LoginFail {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void LoginFail() throws InterruptedException {
        onView(withId(R.id.input_email)).perform(typeText("chutima.rojp@gmail.com"));
        onView(withId(R.id.input_password)).perform(typeText("123456789"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_login)).perform(click());

        //Verify alert message
        onView(withId(R.id.input_password)).check(matches(hasErrorText("enter a valid email address or password")));

    }

    @Test
    public void inputInvalidEmail(){
        onView(withId(R.id.input_email)).perform(typeText("test"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_login)).perform(click());

        //Verify alert message
        onView(withId(R.id.input_email)).check(matches(hasErrorText("enter a valid email address")));
    }

    @Test
    public void inputInvalidPassword_LessThan4characters(){
        onView(withId(R.id.input_password)).perform(typeText("123"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_login)).perform(click());

        //Verify alert message
        onView(withId(R.id.input_password)).check(matches(hasErrorText("between 4 and 10 alphanumeric characters")));
    }

    @Test
    public void inputInvalidPassword_MorThan10Characters(){
        onView(withId(R.id.input_password)).perform(typeText("12345678910"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_login)).perform(click());

        //Verify alert message
        onView(withId(R.id.input_password)).check(matches(hasErrorText("between 4 and 10 alphanumeric characters")));
    }

}
