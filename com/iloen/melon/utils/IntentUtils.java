package com.iloen.melon.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class IntentUtils {
    public static void sendBroadcast(Context context0, Intent intent0) {
        IntentUtils.sendBroadcast(context0, intent0, false);
    }

    @SuppressLint({"InlinedApi"})
    public static void sendBroadcast(Context context0, Intent intent0, boolean z) {
        if(z) {
            intent0.setFlags(intent0.getFlags() | 16);
        }
        else {
            intent0.setFlags(intent0.getFlags() | 0x20);
        }
        if(context0 != null) {
            context0.sendBroadcast(intent0);
        }
    }

    public static void sendMelonUri(Context context0, Uri uri0) {
        Intent intent0 = new Intent("android.intent.action.VIEW");
        intent0.setData(uri0);
        context0.sendBroadcast(intent0);
    }

    public static void setFlagsExcludeStopedPackages(Intent intent0) {
        IntentUtils.sendBroadcast(null, intent0, false);
    }
}

