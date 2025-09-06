package com.google.android.gms.cast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class zzao extends BroadcastReceiver {
    private zzao() {
        throw null;
    }

    public zzao(zzap zzap0) {
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        if("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT".equals(intent0.getAction())) {
            CastRemoteDisplayLocalService.stopService();
            return;
        }
        if("com.google.android.gms.cast.remote_display.ACTION_SESSION_ENDED".equals(intent0.getAction())) {
            CastRemoteDisplayLocalService.zzr(false);
        }
    }
}

