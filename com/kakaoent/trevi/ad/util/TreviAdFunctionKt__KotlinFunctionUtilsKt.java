package com.kakaoent.trevi.ad.util;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0015\u0010\u0002\u001A\u00020\u0001*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001A-\u0010\f\u001A\u00020\u000B*\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\tH\u0001¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"", "Landroid/net/Uri;", "toUri", "(Ljava/lang/String;)Landroid/net/Uri;", "Landroid/content/Context;", "Landroid/content/BroadcastReceiver;", "receiver", "Landroid/content/IntentFilter;", "filter", "", "exported", "Lie/H;", "registerReceiverCompat", "(Landroid/content/Context;Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Z)V", "trevi-ad-android-sdk_release"}, k = 5, mv = {1, 9, 0}, xi = 0x30, xs = "com/kakaoent/trevi/ad/util/TreviAdFunctionKt")
abstract class TreviAdFunctionKt__KotlinFunctionUtilsKt {
    @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
    public static final void registerReceiverCompat(@NotNull Context context0, @NotNull BroadcastReceiver broadcastReceiver0, @NotNull IntentFilter intentFilter0, boolean z) {
        q.g(context0, "<this>");
        q.g(broadcastReceiver0, "receiver");
        q.g(intentFilter0, "filter");
        if(Build.VERSION.SDK_INT >= 33) {
            context0.registerReceiver(broadcastReceiver0, intentFilter0, (z ? 2 : 4));
            return;
        }
        context0.registerReceiver(broadcastReceiver0, intentFilter0);
    }

    public static void registerReceiverCompat$default(Context context0, BroadcastReceiver broadcastReceiver0, IntentFilter intentFilter0, boolean z, int v, Object object0) {
        if((v & 4) != 0) {
            z = false;
        }
        TreviAdFunctionKt.registerReceiverCompat(context0, broadcastReceiver0, intentFilter0, z);
    }

    @NotNull
    public static final Uri toUri(@Nullable String s) {
        Uri uri0 = Uri.parse(s);
        q.f(uri0, "parse(...)");
        return uri0;
    }
}

