package com.google.firebase.analytics;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzfb;

public class GoogleAnalyticsServerPreviewActivity extends Activity {
    @Override  // android.app.Activity
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        zzfb.zza(this, null).zze(this.getIntent());
        this.finish();
    }
}

