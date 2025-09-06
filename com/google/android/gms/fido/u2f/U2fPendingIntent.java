package com.google.android.gms.fido.u2f;

import android.app.Activity;

@Deprecated
public interface U2fPendingIntent {
    boolean hasPendingIntent();

    void launchPendingIntent(Activity arg1, int arg2);
}

