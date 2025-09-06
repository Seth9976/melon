package com.facebook.gamingservices.cloudgaming;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;

class MediaUploadCallback implements Callback {
    private String body;
    Callback callback;
    private String payload;
    private int timeInterval;
    private String title;

    public MediaUploadCallback(String s, String s1, int v, String s2, Callback graphRequest$Callback0) {
        this.title = s;
        this.body = s1;
        this.timeInterval = v;
        this.payload = s2;
        this.callback = graphRequest$Callback0;
    }

    @Override  // com.facebook.GraphRequest$Callback
    public void onCompleted(GraphResponse graphResponse0) {
        if(graphResponse0.getError() != null) {
            throw new FacebookException(graphResponse0.getError().getErrorMessage());
        }
        String s = graphResponse0.getJSONObject().optString("id");
        AccessToken accessToken0 = AccessToken.getCurrentAccessToken();
        Bundle bundle0 = new Bundle();
        bundle0.putString("title", this.title);
        bundle0.putString("body", this.body);
        bundle0.putInt("time_interval", this.timeInterval);
        String s1 = this.payload;
        if(s1 != null) {
            bundle0.putString("payload:", s1);
        }
        bundle0.putString("media_id", s);
        new GraphRequest(accessToken0, "me/schedule_gaming_app_to_user_update", bundle0, HttpMethod.POST, this.callback).executeAsync();
    }
}

