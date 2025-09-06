package com.google.android.gms.cast.framework;

import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import androidx.mediarouter.app.MediaRouteButton;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzas;
import com.google.android.gms.internal.cast.zzp;
import com.google.android.gms.internal.cast.zzpb;

public interface IntroductoryOverlay {
    public static class Builder {
        private final Activity zza;
        private final View zzb;
        private int zzc;
        private String zzd;
        private OnOverlayDismissedListener zze;
        private boolean zzf;

        public Builder(Activity activity0, MenuItem menuItem0) {
            this.zza = (Activity)Preconditions.checkNotNull(activity0);
            this.zzb = ((MenuItem)Preconditions.checkNotNull(menuItem0)).getActionView();
        }

        public Builder(Activity activity0, MediaRouteButton mediaRouteButton0) {
            this.zza = (Activity)Preconditions.checkNotNull(activity0);
            this.zzb = (View)Preconditions.checkNotNull(mediaRouteButton0);
        }

        public IntroductoryOverlay build() {
            zzp.zzd(zzpb.zzs);
            return new zzas(this);
        }

        public Builder setButtonText(int v) {
            this.zza.getResources().getString(v);
            return this;
        }

        public Builder setButtonText(String s) {
            return this;
        }

        public Builder setFocusRadius(float f) {
            return this;
        }

        public Builder setFocusRadiusId(int v) {
            this.zza.getResources().getDimension(v);
            return this;
        }

        public Builder setOnOverlayDismissedListener(OnOverlayDismissedListener introductoryOverlay$OnOverlayDismissedListener0) {
            this.zze = introductoryOverlay$OnOverlayDismissedListener0;
            return this;
        }

        public Builder setOverlayColor(int v) {
            this.zzc = this.zza.getResources().getColor(v);
            return this;
        }

        public Builder setSingleTime() {
            this.zzf = true;
            return this;
        }

        public Builder setTitleText(int v) {
            this.zzd = this.zza.getResources().getString(v);
            return this;
        }

        public Builder setTitleText(String s) {
            this.zzd = s;
            return this;
        }

        public final int zza() {
            return this.zzc;
        }

        public final Activity zzb() {
            return this.zza;
        }

        public final View zzc() {
            return this.zzb;
        }

        public final OnOverlayDismissedListener zzd() {
            return this.zze;
        }

        public final String zze() {
            return this.zzd;
        }

        public final boolean zzf() {
            return this.zzf;
        }
    }

    public interface OnOverlayDismissedListener {
        void onOverlayDismissed();
    }

    void remove();

    void show();
}

