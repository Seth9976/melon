package com.google.android.gms.cast.framework.media.widget;

import android.os.Bundle;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

final class zzf extends View.AccessibilityDelegate {
    final CastSeekBar zza;

    public zzf(CastSeekBar castSeekBar0, zzg zzg0) {
        this.zza = castSeekBar0;
        super();
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final void onInitializeAccessibilityEvent(View view0, AccessibilityEvent accessibilityEvent0) {
        super.onInitializeAccessibilityEvent(view0, accessibilityEvent0);
        accessibilityEvent0.setClassName("android.widget.SeekBar");
        accessibilityEvent0.setItemCount(this.zza.zza.zzb);
        accessibilityEvent0.setCurrentItemIndex(this.zza.getProgress());
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
        accessibilityNodeInfo0.setClassName("android.widget.SeekBar");
        if(view0.isEnabled()) {
            accessibilityNodeInfo0.addAction(0x1000);
            accessibilityNodeInfo0.addAction(0x2000);
        }
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
        if(!view0.isEnabled()) {
            return false;
        }
        if(super.performAccessibilityAction(view0, v, bundle0)) {
            return true;
        }
        if(v == 0x1000 || v == 0x2000) {
            this.zza.zzi();
            this.zza.zzh(this.zza.getProgress() + (v == 0x2000 ? -(this.zza.zza.zzb / 20) : this.zza.zza.zzb / 20));
            this.zza.zzj();
        }
        return false;
    }
}

