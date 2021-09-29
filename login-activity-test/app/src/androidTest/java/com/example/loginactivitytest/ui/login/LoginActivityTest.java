package com.example.loginactivitytest.ui.login;

import android.widget.Button;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.example.loginactivitytest.R;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    //https://stackoverflow.com/questions/43064681/what-is-the-difference-between-activitytestrule-and-intenttestrule

    @Rule
    public IntentsTestRule<LoginActivity> loginActivityRule = new IntentsTestRule<>(LoginActivity.class);

    @Test
    public void test_loginButton_shouldHaveValidText() {
        LoginActivity loginActivity = loginActivityRule.getActivity();
        Assert.assertNotNull(loginActivity);

        Button loginButton = loginActivity.findViewById(R.id.login);
        Assert.assertNotNull(loginButton);

        Assert.assertEquals(loginButton.getText().toString(), "Botton Text");
    }
}