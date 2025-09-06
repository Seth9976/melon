package com.google.android.gms.fido.fido2;

import android.app.Activity;

@Deprecated
public interface Fido2PendingIntent {
    boolean hasPendingIntent();

    void launchPendingIntent(Activity arg1, int arg2);
}

