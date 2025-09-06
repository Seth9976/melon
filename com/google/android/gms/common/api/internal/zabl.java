package com.google.android.gms.common.api.internal;

import android.os.Message;

final class zabl implements BackgroundStateChangeListener {
    final GoogleApiManager zaa;

    public zabl(GoogleApiManager googleApiManager0) {
        this.zaa = googleApiManager0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.BackgroundDetector$BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        Message message0 = this.zaa.zar.obtainMessage(1, Boolean.valueOf(z));
        this.zaa.zar.sendMessage(message0);
    }
}

