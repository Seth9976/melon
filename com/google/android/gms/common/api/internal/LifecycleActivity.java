package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public class LifecycleActivity {
    private final Object zza;

    public LifecycleActivity(Activity activity0) {
        Preconditions.checkNotNull(activity0, "Activity must not be null");
        this.zza = activity0;
    }

    @KeepForSdk
    @Deprecated
    public LifecycleActivity(ContextWrapper contextWrapper0) {
        throw new UnsupportedOperationException();
    }

    public final boolean zza() {
        return this.zza instanceof FragmentActivity;
    }

    public final boolean zzb() {
        return this.zza instanceof Activity;
    }

    public final Activity zzc() {
        return (Activity)this.zza;
    }

    public final FragmentActivity zzd() {
        return (FragmentActivity)this.zza;
    }
}

