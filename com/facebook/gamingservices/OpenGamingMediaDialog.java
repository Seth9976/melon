package com.facebook.gamingservices;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest.OnProgressCallback;
import com.facebook.GraphResponse;

public class OpenGamingMediaDialog implements OnProgressCallback {
    private Context context;
    private Callback nestedCallback;

    public OpenGamingMediaDialog(Context context0) {
        this(context0, null);
    }

    public OpenGamingMediaDialog(Context context0, Callback graphRequest$Callback0) {
        this.context = context0;
        this.nestedCallback = graphRequest$Callback0;
    }

    @Override  // com.facebook.GraphRequest$Callback
    public void onCompleted(GraphResponse graphResponse0) {
        Callback graphRequest$Callback0 = this.nestedCallback;
        if(graphRequest$Callback0 != null) {
            graphRequest$Callback0.onCompleted(graphResponse0);
        }
        if(graphResponse0 != null && graphResponse0.getError() == null) {
            String s = graphResponse0.getJSONObject().optString("id", null);
            String s1 = graphResponse0.getJSONObject().optString("video_id", null);
            if(s != null || s1 != null) {
                if(s == null) {
                    s = s1;
                }
                Intent intent0 = new Intent("android.intent.action.VIEW", Uri.parse(("https://fb.gg/me/media_asset/" + s)));
                this.context.startActivity(intent0);
            }
        }
    }

    @Override  // com.facebook.GraphRequest$OnProgressCallback
    public void onProgress(long v, long v1) {
        Callback graphRequest$Callback0 = this.nestedCallback;
        if(graphRequest$Callback0 != null && graphRequest$Callback0 instanceof OnProgressCallback) {
            ((OnProgressCallback)graphRequest$Callback0).onProgress(v, v1);
        }
    }
}

