package com.example.loginactivitytest3;

import android.view.View;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.loginactivitytest3.ui.login.LoginActivity;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {


    @Rule
    public IntentsTestRule<LoginActivity> loginActivityIntentTestRule = new IntentsTestRule<>(LoginActivity.class);

    @Test
    public void test() {
        LoginActivity loginActivity = loginActivityIntentTestRule.getActivity();
        View view = loginActivity.findViewById(R.id.login);

    }


}