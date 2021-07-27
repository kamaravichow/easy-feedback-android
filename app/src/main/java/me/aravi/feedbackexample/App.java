package me.aravi.feedbackexample;

import android.app.Application;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;

import me.aravi.engine.feedback.FeedbackInit;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        List<String> device = new ArrayList<>();
        device.add(Build.MANUFACTURER);
        device.add(Build.BRAND);
        device.add(Build.MODEL);
        device.add(Build.VERSION.SDK_INT + Build.VERSION.CODENAME);
        device.add(BuildConfig.VERSION_NAME);
        device.add("none");

        List<String> user = new ArrayList<>();
        user.add("id");
        user.add("email@email.com");
        user.add("name");
        user.add("time");
        user.add("aaa");

        FeedbackInit.initFeedbackEngine(this, getString(R.string.app_name), device, user);
    }
}
