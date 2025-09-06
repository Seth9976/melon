package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.fragment.app.a;
import androidx.fragment.app.l0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class zzd extends I implements LifecycleFragment {
    private static final WeakHashMap zza;
    private final zzc zzb;

    static {
        zzd.zza = new WeakHashMap();
    }

    public zzd() {
        this.zzb = new zzc();
    }

    @Override  // com.google.android.gms.common.api.internal.LifecycleFragment
    public final void addCallback(String s, LifecycleCallback lifecycleCallback0) {
        this.zzb.zzb(s, lifecycleCallback0);
    }

    @Override  // androidx.fragment.app.I
    public final void dump(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        super.dump(s, fileDescriptor0, printWriter0, arr_s);
        this.zzb.zzl(s, fileDescriptor0, printWriter0, arr_s);
    }

    @Override  // com.google.android.gms.common.api.internal.LifecycleFragment
    public final LifecycleCallback getCallbackOrNull(String s, Class class0) {
        return this.zzb.zza(s, class0);
    }

    @Override  // com.google.android.gms.common.api.internal.LifecycleFragment
    public final Activity getLifecycleActivity() {
        return this.getActivity();
    }

    @Override  // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isCreated() {
        return this.zzb.zzc();
    }

    @Override  // com.google.android.gms.common.api.internal.LifecycleFragment
    public final boolean isStarted() {
        return this.zzb.zzd();
    }

    @Override  // androidx.fragment.app.I
    public final void onActivityResult(int v, int v1, Intent intent0) {
        super.onActivityResult(v, v1, intent0);
        this.zzb.zzh(v, v1, intent0);
    }

    @Override  // androidx.fragment.app.I
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.zzb.zze(bundle0);
    }

    @Override  // androidx.fragment.app.I
    public final void onDestroy() {
        super.onDestroy();
        this.zzb.zzk();
    }

    @Override  // androidx.fragment.app.I
    public final void onResume() {
        super.onResume();
        this.zzb.zzg();
    }

    @Override  // androidx.fragment.app.I
    public final void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        this.zzb.zzi(bundle0);
    }

    @Override  // androidx.fragment.app.I
    public final void onStart() {
        super.onStart();
        this.zzb.zzf();
    }

    @Override  // androidx.fragment.app.I
    public final void onStop() {
        super.onStop();
        this.zzb.zzj();
    }

    public static zzd zza(FragmentActivity fragmentActivity0) {
        zzd zzd1;
        l0 l00 = fragmentActivity0.getSupportFragmentManager();
        WeakHashMap weakHashMap0 = zzd.zza;
        WeakReference weakReference0 = (WeakReference)weakHashMap0.get(fragmentActivity0);
        if(weakReference0 != null) {
            zzd zzd0 = (zzd)weakReference0.get();
            if(zzd0 != null) {
                return zzd0;
            }
        }
        try {
            zzd1 = (zzd)l00.E("SLifecycleFragmentImpl");
        }
        catch(ClassCastException classCastException0) {
            throw new IllegalStateException("Fragment with tag SLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", classCastException0);
        }
        if(zzd1 == null || zzd1.isRemoving()) {
            zzd1 = new zzd();
            a a0 = new a(l00);
            a0.e(0, zzd1, "SLifecycleFragmentImpl", 1);
            a0.l(true, true);
        }
        weakHashMap0.put(fragmentActivity0, new WeakReference(zzd1));
        return zzd1;
    }
}

