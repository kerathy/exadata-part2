package com.example.loginactivitytest3;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.loginactivitytest3.ui.login.LoginActivity;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
//import static android.support.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class LoginActivityEndToEndTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void test_login_success_scenario() {
        onView(withId(R.id.username)).perform(typeText("testgmail@gmail.com"));
        onView(withId(R.id.password)).perform(typeText("testpassword"));
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.txt_login_result)).check(matches(withText("Login Success")));
//        onView(withId(R.id.txt_login_result)).check(matches(withText("Login Failed")));

    }

}
