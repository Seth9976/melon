package com.google.android.gms.flags.impl;

import android.content.Context;
import java.util.concurrent.Callable;

final class zze implements Callable {
    final Context zza;

    public zze(Context context0) {
        this.zza = context0;
        super();
    }

    @Override
    public final Object call() {
        return this.zza.getSharedPreferences("google_sdk_flags", 0);
    }
}

