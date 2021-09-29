package com.example.loginactivitytest2;

import android.view.View;
import android.widget.Button;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.loginactivitytest2.ui.login.LoginActivity;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

//    @Rule
//    public ActivityTestRule<LoginActivity> loginActivityRule = new ActivityTestRule<>(LoginActivity.class);

    @Rule
    public IntentsTestRule<LoginActivity> loginActivityRule = new IntentsTestRule<>(LoginActivity.class);

    @Test
    public void testValidateLoginButtonText() {
        LoginActivity loginActivity = loginActivityRule.getActivity();
        View viewById = loginActivity.findViewById(R.id.login);

        Assert.assertThat(viewById, notNullValue());
        Assert.assertThat(viewById, instanceOf(Button.class));

        Button loginButton = (Button)viewById;
        Assert.assertThat(loginButton.getText().toString(), is(equalTo("Sign in or register")));
    }

}