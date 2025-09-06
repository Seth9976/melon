package com.google.android.gms.internal.cast;

import android.app.Activity;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.RelativeLayout;
import com.google.android.gms.cast.framework.IntroductoryOverlay.Builder;
import com.google.android.gms.cast.framework.IntroductoryOverlay.OnOverlayDismissedListener;
import com.google.android.gms.cast.framework.IntroductoryOverlay;
import com.google.android.gms.cast.framework.R.layout;
import com.google.android.gms.cast.framework.internal.featurehighlight.HelpTextView;
import com.google.android.gms.cast.framework.internal.featurehighlight.zzh;

public final class zzas extends RelativeLayout implements IntroductoryOverlay {
    private final boolean zza;
    private Activity zzb;
    private OnOverlayDismissedListener zzc;
    private View zzd;
    private String zze;
    private boolean zzf;
    private int zzg;

    public zzas(Builder introductoryOverlay$Builder0) {
        super(introductoryOverlay$Builder0.zzb());
        this.zzb = introductoryOverlay$Builder0.zzb();
        this.zza = introductoryOverlay$Builder0.zzf();
        this.zzc = introductoryOverlay$Builder0.zzd();
        this.zzd = introductoryOverlay$Builder0.zzc();
        this.zze = introductoryOverlay$Builder0.zze();
        this.zzg = introductoryOverlay$Builder0.zza();
    }

    @Override  // com.google.android.gms.cast.framework.IntroductoryOverlay
    public final void remove() {
        if(this.zzf) {
            Activity activity0 = this.zzb;
            if(activity0 != null) {
                ((ViewGroup)activity0.getWindow().getDecorView()).removeView(this);
                this.zzd();
            }
        }
    }

    @Override  // com.google.android.gms.cast.framework.IntroductoryOverlay
    public final void show() {
        Activity activity0 = this.zzb;
        if(activity0 != null) {
            View view0 = this.zzd;
            if(view0 != null && !this.zzf) {
                AccessibilityManager accessibilityManager0 = (AccessibilityManager)activity0.getSystemService("accessibility");
                if(accessibilityManager0 == null || !accessibilityManager0.isEnabled() || !accessibilityManager0.isTouchExplorationEnabled()) {
                    if(this.zza && PreferenceManager.getDefaultSharedPreferences(activity0).getBoolean("googlecast-introOverlayShown", false)) {
                        this.zzd();
                        return;
                    }
                    zzh zzh0 = new zzh(activity0);
                    int v = this.zzg;
                    if(v != 0) {
                        zzh0.zzj(v);
                    }
                    this.addView(zzh0);
                    HelpTextView helpTextView0 = (HelpTextView)activity0.getLayoutInflater().inflate(layout.cast_help_text, zzh0, false);
                    helpTextView0.setText(this.zze, null);
                    zzh0.zzn(helpTextView0);
                    zzh0.zzi(view0, null, true, new zzar(this, activity0, zzh0));
                    this.zzf = true;
                    ((ViewGroup)activity0.getWindow().getDecorView()).addView(this);
                    zzh0.zzl(null);
                }
            }
        }
    }

    public static OnOverlayDismissedListener zza(zzas zzas0) {
        return zzas0.zzc;
    }

    public static void zzb(zzas zzas0) {
        zzas0.zzd();
    }

    private final void zzd() {
        this.removeAllViews();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzg = 0;
        this.zzf = false;
    }
}

