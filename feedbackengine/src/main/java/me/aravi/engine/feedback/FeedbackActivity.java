package me.aravi.engine.feedback;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import me.aravi.engine.feedback.databinding.ActivityFeedbackBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedbackActivity extends AppCompatActivity {

    private ActivityFeedbackBinding mBinding;
    private FeedbackPersist feedbackPersist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityFeedbackBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        feedbackPersist = FeedbackPersist.getInstance(getApplication());

        mBinding.submitFeedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.submitFeedbackButton.setVisibility(View.INVISIBLE);
                mBinding.feedbackEditText.setEnabled(false);
                String formattedFeedback = "<div>\n" +
                        "    <span><!--more--></span><b><br /></b>\n" +
                        "</div>\n" +
                        "<p><u>User Feedback:</u></p>\n" +
                        "<h4 style=\"text-align: left;\"><u>" + mBinding.feedbackEditText.getText().toString() + "</u></h4>\n" +
                        "<p>\n" +
                        "    <b><span></span></b><span></span>\n" +
                        "</p>";
                submit(formattedFeedback);
            }
        });

    }


    private void submit(String formattedFeedback){
        Call<String> submitCall = FeedbackEngine.getFeedbackService().submitFeedback(feedbackPersist.getAppName(),feedbackPersist.getUserInfo() + formattedFeedback, feedbackPersist.getDeviceInfo());
        submitCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                mBinding.submitFeedbackButton.setVisibility(View.VISIBLE);
                mBinding.feedbackEditText.clearComposingText();
                mBinding.feedbackEditText.setEnabled(true);
                mBinding.response.setText("Feedback successfully submitted");
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                mBinding.response.setText("Failed : " + t.getMessage());
                mBinding.feedbackEditText.setEnabled(true);
                mBinding.submitFeedbackButton.setVisibility(View.VISIBLE);

            }
        });
    }
}