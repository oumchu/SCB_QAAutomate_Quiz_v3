package com.sourcey.materiallogindemo;


import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
public class TC003_VerifyPageRedirect {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void AlreadyMember_RedirectToLoginPage(){
        onView(withId(R.id.link_signup)).perform(click());
        onView(withId(R.id.link_login)).perform(scrollTo(), click());

        //Verify link redirect to login page
        onView(withId(R.id.input_email)).check(matches(isDisplayed()));
        onView(withId(R.id.input_password)).check(matches(isDisplayed()));
    }

}
