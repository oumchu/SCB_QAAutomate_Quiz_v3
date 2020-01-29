package com.sourcey.materiallogindemo;

import android.app.Application;
//import android.test.ApplicationTestCase;

import android.os.SystemClock;

import androidx.test.espresso.Espresso;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import butterknife.OnClick;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static java.lang.Thread.sleep;


@RunWith(AndroidJUnit4ClassRunner.class)
public class TC001_Register_LoginPass {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void register() throws InterruptedException {
        onView(withId(R.id.link_signup)).perform(click());

        //Input register data
        onView(withId(R.id.input_name)).perform(typeText("oum"));
        onView(withId(R.id.input_address)).perform(typeText("Bangkok"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.input_email)).perform(typeText("chutima.rojp@gmail.com"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.input_mobile)).perform(typeText("0877605121"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.input_password)).perform(typeText("123456789"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.input_reEnterPassword)).perform(typeText("123456789"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_signup)).perform(click());
        sleep(5000);

        //Verify login success page
        onView(withText("Material Login Example")).check(matches(isDisplayed()));
        onView(withText("Hello world!")).check(matches(isDisplayed()));
        onView(withId(R.id.btn_logout)).perform(click());
    }

    @Test
    public void inputEmail_Password_Enter() throws InterruptedException {

        //Input Email and Password
        onView(withId(R.id.input_email)).perform(typeText("chutima.rojp@gmail.com"));
        onView(withId(R.id.input_password)).perform(typeText("123456789"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btn_login)).perform(click());
        sleep(5000);

        //Verify login success page
        onView(withText("Material Login Example")).check(matches(isDisplayed()));
        onView(withText("Hello world!")).check(matches(isDisplayed()));
        onView(withId(R.id.btn_logout)).check(matches(isDisplayed()));
    }


}

