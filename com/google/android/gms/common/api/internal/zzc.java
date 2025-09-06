package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.f;
import com.google.android.gms.internal.common.zzg;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Map;
import k8.Y;

final class zzc {
    private final Map zza;
    private int zzb;
    private Bundle zzc;

    public zzc() {
        this.zza = Collections.synchronizedMap(new f(0));  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.zzb = 0;
    }

    public final LifecycleCallback zza(String s, Class class0) {
        return (LifecycleCallback)class0.cast(this.zza.get(s));
    }

    public final void zzb(String s, LifecycleCallback lifecycleCallback0) {
        Map map0 = this.zza;
        if(map0.containsKey(s)) {
            throw new IllegalArgumentException(Y.l(new StringBuilder(String.valueOf(s).length() + 59), "LifecycleCallback with tag ", s, " already added to this fragment."));
        }
        map0.put(s, lifecycleCallback0);
        if(this.zzb > 0) {
            new zzg(Looper.getMainLooper()).post(new zzb(this, lifecycleCallback0, s));
        }
    }

    public final boolean zzc() {
        return this.zzb > 0;
    }

    public final boolean zzd() {
        return this.zzb >= 2;
    }

    public final void zze(Bundle bundle0) {
        this.zzb = 1;
        this.zzc = bundle0;
        for(Object object0: this.zza.entrySet()) {
            ((LifecycleCallback)((Map.Entry)object0).getValue()).onCreate((bundle0 == null ? null : bundle0.getBundle(((String)((Map.Entry)object0).getKey()))));
        }
    }

    public final void zzf() {
        this.zzb = 2;
        for(Object object0: this.zza.values()) {
            ((LifecycleCallback)object0).onStart();
        }
    }

    public final void zzg() {
        this.zzb = 3;
        for(Object object0: this.zza.values()) {
            ((LifecycleCallback)object0).onResume();
        }
    }

    public final void zzh(int v, int v1, Intent intent0) {
        for(Object object0: this.zza.values()) {
            ((LifecycleCallback)object0).onActivityResult(v, v1, intent0);
        }
    }

    public final void zzi(Bundle bundle0) {
        if(bundle0 != null) {
            for(Object object0: this.zza.entrySet()) {
                Bundle bundle1 = new Bundle();
                ((LifecycleCallback)((Map.Entry)object0).getValue()).onSaveInstanceState(bundle1);
                bundle0.putBundle(((String)((Map.Entry)object0).getKey()), bundle1);
            }
        }
    }

    public final void zzj() {
        this.zzb = 4;
        for(Object object0: this.zza.values()) {
            ((LifecycleCallback)object0).onStop();
        }
    }

    public final void zzk() {
        this.zzb = 5;
        for(Object object0: this.zza.values()) {
            ((LifecycleCallback)object0).onDestroy();
        }
    }

    public final void zzl(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        for(Object object0: this.zza.values()) {
            ((LifecycleCallback)object0).dump(s, fileDescriptor0, printWriter0, arr_s);
        }
    }

    public final int zzm() {
        return this.zzb;
    }

    public final Bundle zzn() {
        return this.zzc;
    }
}

