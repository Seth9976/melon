package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.location.zzaf;
import com.google.android.gms.internal.location.zzaj;

public class ActivityRecognition {
    @Deprecated
    public static final Api API;
    @Deprecated
    public static final ActivityRecognitionApi ActivityRecognitionApi;

    static {
        ActivityRecognition.API = zzaj.zzb;
        ActivityRecognition.ActivityRecognitionApi = new zzaf();
    }

    public static ActivityRecognitionClient getClient(Activity activity0) {
        return new zzaj(activity0);
    }

    public static ActivityRecognitionClient getClient(Context context0) {
        return new zzaj(context0);
    }
}

