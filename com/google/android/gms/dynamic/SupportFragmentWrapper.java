package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.I;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public final class SupportFragmentWrapper extends Stub {
    private final I zza;

    private SupportFragmentWrapper(I i0) {
        this.zza = i0;
    }

    @KeepForSdk
    public static SupportFragmentWrapper wrap(I i0) {
        return i0 == null ? null : new SupportFragmentWrapper(i0);
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzA(IObjectWrapper iObjectWrapper0) {
        View view0 = (View)ObjectWrapper.unwrap(iObjectWrapper0);
        Preconditions.checkNotNull(view0);
        this.zza.unregisterForContextMenu(view0);
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(this.zza.getActivity());
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final Bundle zzc() {
        return this.zza.getArguments();
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final int zzd() {
        return this.zza.getId();
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper zze() {
        return SupportFragmentWrapper.wrap(this.zza.getParentFragment());
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzf() {
        return ObjectWrapper.wrap(this.zza.getResources());
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzg() {
        return this.zza.getRetainInstance();
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final String zzh() {
        return this.zza.getTag();
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper zzi() {
        return SupportFragmentWrapper.wrap(this.zza.getTargetFragment());
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final int zzj() {
        return this.zza.getTargetRequestCode();
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzk() {
        return this.zza.getUserVisibleHint();
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper zzl() {
        return ObjectWrapper.wrap(this.zza.getView());
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzm() {
        return this.zza.isAdded();
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzn() {
        return this.zza.isDetached();
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzo() {
        return this.zza.isHidden();
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzp() {
        return this.zza.isInLayout();
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzq() {
        return this.zza.isRemoving();
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzr() {
        return this.zza.isResumed();
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean zzs() {
        return this.zza.isVisible();
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzt(IObjectWrapper iObjectWrapper0) {
        View view0 = (View)ObjectWrapper.unwrap(iObjectWrapper0);
        Preconditions.checkNotNull(view0);
        this.zza.registerForContextMenu(view0);
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzu(boolean z) {
        this.zza.setHasOptionsMenu(z);
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzv(boolean z) {
        this.zza.setMenuVisibility(z);
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzw(boolean z) {
        this.zza.setRetainInstance(z);
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzx(boolean z) {
        this.zza.setUserVisibleHint(z);
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzy(Intent intent0) {
        this.zza.startActivity(intent0);
    }

    @Override  // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzz(Intent intent0, int v) {
        this.zza.startActivityForResult(intent0, v);
    }
}

