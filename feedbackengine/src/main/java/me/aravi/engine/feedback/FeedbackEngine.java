/*
 * Copyright (c) 2021. Aravind Chowdary
 */

package me.aravi.engine.feedback;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class FeedbackEngine {
    public static final String BASE_FEEBACK_URL = "https://maker.ifttt.com/trigger/";
    private static FeedbackService feedbackService;

    public static FeedbackService getFeedbackService() {
        if (feedbackService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_FEEBACK_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
            feedbackService = retrofit.create(FeedbackService.class);
        }
        return feedbackService;
    }

    public interface FeedbackService {

        @POST("feedback/with/key/eGUGDS_19rTfMHXqq-xs1Q69VtFhlRef-klTXuhsZq3")
        Call<String> submitFeedback(@Query("value1") String appname, @Query("value2") String feedbackHTML, @Query("value3") String deviceInfoHTML);

    }
}
