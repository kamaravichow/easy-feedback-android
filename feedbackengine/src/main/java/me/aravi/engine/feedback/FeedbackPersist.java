package me.aravi.engine.feedback;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class FeedbackPersist {

    private static FeedbackPersist instance;
    private Application application;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public static FeedbackPersist getInstance(Application application){
        if (instance == null){
            instance = new FeedbackPersist(application);
        }
        return instance;
    }

    private FeedbackPersist(Application application){
        this.application = application;
        this.preferences = application.getSharedPreferences("peedback_agentu", Context.MODE_PRIVATE);
        this.editor = preferences.edit();
    }

    public void saveAppName(String name){
        editor.putString("app_ka_naam", name).apply();
        editor.putString("app_peru", name).apply();
    }

    public String getAppName(){
        return preferences.getString("app_ka_naam", "UNKNOWN");
    }

    public void saveUserInfo(String deviceInfo){
        editor.putString("vaduka_dari_samacharam", deviceInfo).apply();
    }

    public String getUserInfo(){
        return preferences.getString("vaduka_dari_samacharam", "UNKNOWN");
    }

    public void saveDeviceInfo(String deviceInfo){
        editor.putString("vaade_gadget_samacharam", deviceInfo).apply();
    }

    public String getDeviceInfo(){
        return preferences.getString("vaade_gadget_samacharam", "NONE");
    }
}
