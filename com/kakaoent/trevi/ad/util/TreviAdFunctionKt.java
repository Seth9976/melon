package com.kakaoent.trevi.ad.util;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"com/kakaoent/trevi/ad/util/TreviAdFunctionKt__KotlinFunctionUtilsKt"}, k = 4, mv = {1, 9, 0}, xi = 0x30)
public abstract class TreviAdFunctionKt {
    @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
    public static final void registerReceiverCompat(@NotNull Context context0, @NotNull BroadcastReceiver broadcastReceiver0, @NotNull IntentFilter intentFilter0, boolean z) {
        TreviAdFunctionKt__KotlinFunctionUtilsKt.registerReceiverCompat(context0, broadcastReceiver0, intentFilter0, z);
    }

    public static void registerReceiverCompat$default(Context context0, BroadcastReceiver broadcastReceiver0, IntentFilter intentFilter0, boolean z, int v, Object object0) {
        TreviAdFunctionKt__KotlinFunctionUtilsKt.registerReceiverCompat$default(context0, broadcastReceiver0, intentFilter0, z, v, object0);
    }

    @NotNull
    public static final Uri toUri(@Nullable String s) {
        return TreviAdFunctionKt__KotlinFunctionUtilsKt.toUri(s);
    }
}

