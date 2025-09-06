package com.iloen.melon.playback;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import o8.c;
import p9.e;

public class PhoneStatusReceiver extends BroadcastReceiver {
    @Override  // android.content.BroadcastReceiver
    public void onReceive(Context context0, Intent intent0) {
        if(intent0 != null) {
            String s = intent0.getAction();
            if(!TextUtils.isEmpty(s) && !s.equals("android.intent.action.MEDIA_MOUNTED") && !s.equals("android.intent.action.MEDIA_SCANNER_SCAN_FILE") && !s.equals("android.intent.action.MEDIA_EJECT")) {
                if(s.equals("android.intent.action.BOOT_COMPLETED")) {
                    e e0 = new e();
                    e0.a = 0;
                    e0.execute(null);
                    c.d();
                    return;
                }
                if("android.intent.action.TIMEZONE_CHANGED".equals(s)) {
                    c.d();
                }
            }
        }
    }
}

