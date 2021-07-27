package me.aravi.engine.feedback;

import android.app.Application;

import java.util.List;

public class FeedbackInit {

    /**
     * make sure to initialise this before you execute it
     * device info has 5 items [manufacturer, brand, chipset, android version, app version, applogs]
     * userinfo has 4 items [authid, email, name, using app timestamp, other info]
     * @param application
     * @param appname
     * @param deviceInfo
     * @param userinfo
     * @return
     */
    public static void initFeedbackEngine(Application application, String appname, List<String> deviceInfo, List<String> userinfo){
        FeedbackPersist persist = FeedbackPersist.getInstance(application);
        persist.saveAppName(appname);
        persist.saveDeviceInfo("" +
                "<p></p>\n" +
                "<p><b>Device Information :</b></p>\n" +
                "<p>Manufacturer : " + deviceInfo.get(0) +  "</p>\n" +
                "<p>Brand : " + deviceInfo.get(1) +" </p>\n" +
                "<p>Chipset : " + deviceInfo.get(2) + "</p>\n" +
                "<p>Android Version : " + deviceInfo.get(3) + "</p>\n" +
                "<p>App Version : " + deviceInfo.get(4) + "</p>\n" +
                "<p>App Logs :</p>\n" +
                "<p>\n" +
                "    <i><span style=\"font-size: x-small;\">" + deviceInfo.get(5) +"</span></i>\n" +
                "</p>\n" +
                "<p><br /></p>"
        );

        persist.saveUserInfo("<div><b>Userinfo :</b></div>\n" +
                "<div>\n" +
                "    <b><br /></b>\n" +
                "</div>\n" +
                "<div><b>AuthID: " + userinfo.get(0) +  "</b></div>\n" +
                "<div><b>Email : " + userinfo.get(1) + "</b></div>\n" +
                "<div><b>Name : " + userinfo.get(2) +"</b></div>\n" +
                "<div><b>Using App Since : " + userinfo.get(3) + " </b></div>\n" +
                "<div><b>Other Info : " + userinfo.get(4) +"</b></div>\n" +
                "<div><span></span></div>");

    }
}
