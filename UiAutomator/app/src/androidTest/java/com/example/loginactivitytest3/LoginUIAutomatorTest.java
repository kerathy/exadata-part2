package com.example.loginactivitytest3;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(AndroidJUnit4.class)
public class LoginUIAutomatorTest {


    private UiDevice uiDevice;
    public static final String ADD_PACKAGE_NAME = "com.example.loginactivitytest3";

    @Before
    public void startLoginActivity() {
        uiDevice = UiDevice.getInstance(getInstrumentation());

        uiDevice.pressHome();

        final String launchPackage = getLaunchPackageName();
        assertThat(launchPackage, notNullValue());
        uiDevice.wait(Until.hasObject(By.pkg(launchPackage).depth(0)), 5000);

        Context context = getApplicationContext();

        final Intent intent = context.getPackageManager().getLaunchIntentForPackage(ADD_PACKAGE_NAME);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        uiDevice.wait(Until.hasObject(By.pkg(ADD_PACKAGE_NAME).depth(0)), 5000);


    }

    private String getLaunchPackageName() {
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        PackageManager packageManager = getApplicationContext().getPackageManager();
        ResolveInfo resolveInfo = packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }

    @Test
    public void test_perform_login_click() throws UiObjectNotFoundException {
        UiObject loginButton = uiDevice.findObject(new UiSelector().text("Sign in or register").className("android.widget.Button"));

        UiObject username = uiDevice.findObject(new UiSelector().resourceId(ADD_PACKAGE_NAME+":id/username").className("android.widget.EditText"));

        UiObject password = uiDevice.findObject(new UiSelector().resourceId(ADD_PACKAGE_NAME+":id/password").className("android.widget.EditText"));

        UiObject loginResult = uiDevice.findObject(new UiSelector().resourceId(ADD_PACKAGE_NAME+":id/txtresult").className("android.widget.TextView"));

        username.setText("abc@gmail.com");
        password.setText("abcd1234");

        if (loginButton.exists() && loginButton.isEnabled()) {
            loginButton.click();
        }

        assertThat(loginResult.getText(), is(equalTo("abcd")));

    }



}
