package com.google.android.gms.cast.framework.media.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.I;
import com.google.android.gms.cast.framework.R.attr;
import com.google.android.gms.cast.framework.R.dimen;
import com.google.android.gms.cast.framework.R.drawable;
import com.google.android.gms.cast.framework.R.id;
import com.google.android.gms.cast.framework.R.layout;
import com.google.android.gms.cast.framework.R.string;
import com.google.android.gms.cast.framework.R.style;
import com.google.android.gms.cast.framework.R.styleable;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.uicontroller.UIMediaController;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzp;
import com.google.android.gms.internal.cast.zzpb;

public class MiniControllerFragment extends I implements ControlButtonsContainer {
    private Logger zza;
    private boolean zzb;
    private int zzc;
    private int zzd;
    private TextView zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int[] zzj;
    private final ImageView[] zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;
    private int zzw;
    private int zzx;
    private UIMediaController zzy;

    public MiniControllerFragment() {
        this.zzk = new ImageView[3];
    }

    @Override  // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    public final ImageView getButtonImageViewAt(int v) {
        return this.zzk[v];
    }

    @Override  // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    public final int getButtonSlotCount() {
        return 3;
    }

    @Override  // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    public final int getButtonTypeAt(int v) {
        return this.zzj[v];
    }

    @Override  // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    public UIMediaController getUIMediaController() {
        return this.zzy;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        this.zza = new Logger("MiniControllerFragment");
        UIMediaController uIMediaController0 = new UIMediaController(this.getActivity());
        this.zzy = uIMediaController0;
        View view0 = layoutInflater0.inflate(layout.cast_mini_controller, viewGroup0, false);
        view0.setVisibility(8);
        uIMediaController0.bindViewVisibilityToMediaSession(view0, 8);
        RelativeLayout relativeLayout0 = (RelativeLayout)view0.findViewById(id.container_current);
        int v = this.zzf;
        if(v != 0) {
            relativeLayout0.setBackgroundResource(v);
        }
        ImageView imageView0 = (ImageView)view0.findViewById(id.icon_view);
        TextView textView0 = (TextView)view0.findViewById(id.title_view);
        if(this.zzc != 0) {
            textView0.setTextAppearance(this.getActivity(), this.zzc);
        }
        TextView textView1 = (TextView)view0.findViewById(id.subtitle_view);
        this.zze = textView1;
        if(this.zzd != 0) {
            textView1.setTextAppearance(this.getActivity(), this.zzd);
        }
        ProgressBar progressBar0 = (ProgressBar)view0.findViewById(id.progressBar);
        if(this.zzg != 0) {
            ((LayerDrawable)progressBar0.getProgressDrawable()).setColorFilter(this.zzg, PorterDuff.Mode.SRC_IN);
        }
        uIMediaController0.bindTextViewToMetadataOfCurrentItem(textView0, "com.google.android.gms.cast.metadata.TITLE");
        uIMediaController0.bindTextViewToSmartSubtitle(this.zze);
        uIMediaController0.bindProgressBar(progressBar0);
        uIMediaController0.bindViewToLaunchExpandedController(relativeLayout0);
        if(this.zzb) {
            uIMediaController0.bindImageViewToImageOfCurrentItem(imageView0, new ImageHints(2, this.getResources().getDimensionPixelSize(dimen.cast_mini_controller_icon_width), this.getResources().getDimensionPixelSize(dimen.cast_mini_controller_icon_height)), drawable.cast_album_art_placeholder);
        }
        else {
            imageView0.setVisibility(8);
        }
        this.zzk[0] = (ImageView)relativeLayout0.findViewById(id.button_0);
        this.zzk[1] = (ImageView)relativeLayout0.findViewById(id.button_1);
        this.zzk[2] = (ImageView)relativeLayout0.findViewById(id.button_2);
        this.zza(uIMediaController0, relativeLayout0, id.button_0, 0);
        this.zza(uIMediaController0, relativeLayout0, id.button_1, 1);
        this.zza(uIMediaController0, relativeLayout0, id.button_2, 2);
        return view0;
    }

    @Override  // androidx.fragment.app.I
    public void onDestroy() {
        UIMediaController uIMediaController0 = this.zzy;
        if(uIMediaController0 != null) {
            uIMediaController0.dispose();
            this.zzy = null;
        }
        super.onDestroy();
    }

    @Override  // androidx.fragment.app.I
    public void onInflate(Context context0, AttributeSet attributeSet0, Bundle bundle0) {
        super.onInflate(context0, attributeSet0, bundle0);
        if(this.zzj == null) {
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, styleable.CastMiniController, attr.castMiniControllerStyle, style.CastMiniController);
            this.zzb = typedArray0.getBoolean(styleable.CastMiniController_castShowImageThumbnail, true);
            this.zzc = typedArray0.getResourceId(styleable.CastMiniController_castTitleTextAppearance, 0);
            this.zzd = typedArray0.getResourceId(styleable.CastMiniController_castSubtitleTextAppearance, 0);
            this.zzf = typedArray0.getResourceId(styleable.CastMiniController_castBackground, 0);
            int v1 = typedArray0.getColor(styleable.CastMiniController_castProgressBarColor, 0);
            this.zzg = v1;
            this.zzh = typedArray0.getColor(styleable.CastMiniController_castMiniControllerLoadingIndicatorColor, v1);
            this.zzi = typedArray0.getResourceId(styleable.CastMiniController_castButtonColor, 0);
            this.zzm = typedArray0.getResourceId(styleable.CastMiniController_castPlayButtonDrawable, 0);
            this.zzn = typedArray0.getResourceId(styleable.CastMiniController_castPauseButtonDrawable, 0);
            this.zzo = typedArray0.getResourceId(styleable.CastMiniController_castStopButtonDrawable, 0);
            this.zzp = typedArray0.getResourceId(styleable.CastMiniController_castPlayButtonDrawable, 0);
            this.zzq = typedArray0.getResourceId(styleable.CastMiniController_castPauseButtonDrawable, 0);
            this.zzr = typedArray0.getResourceId(styleable.CastMiniController_castStopButtonDrawable, 0);
            this.zzs = typedArray0.getResourceId(styleable.CastMiniController_castSkipPreviousButtonDrawable, 0);
            this.zzt = typedArray0.getResourceId(styleable.CastMiniController_castSkipNextButtonDrawable, 0);
            this.zzu = typedArray0.getResourceId(styleable.CastMiniController_castRewind30ButtonDrawable, 0);
            this.zzv = typedArray0.getResourceId(styleable.CastMiniController_castForward30ButtonDrawable, 0);
            this.zzw = typedArray0.getResourceId(styleable.CastMiniController_castMuteToggleButtonDrawable, 0);
            this.zzx = typedArray0.getResourceId(styleable.CastMiniController_castClosedCaptionsButtonDrawable, 0);
            int v2 = typedArray0.getResourceId(styleable.CastMiniController_castControlButtons, 0);
            if(v2 == 0) {
                Logger logger0 = this.zza;
                if(logger0 != null) {
                    logger0.w("Unable to read attribute castControlButtons.", new Object[0]);
                }
                this.zzj = new int[]{id.cast_button_type_empty, id.cast_button_type_empty, id.cast_button_type_empty};
            }
            else {
                TypedArray typedArray1 = context0.getResources().obtainTypedArray(v2);
                Preconditions.checkArgument(typedArray1.length() == 3);
                this.zzj = new int[typedArray1.length()];
                for(int v3 = 0; v3 < typedArray1.length(); ++v3) {
                    int[] arr_v = this.zzj;
                    arr_v[v3] = typedArray1.getResourceId(v3, 0);
                }
                typedArray1.recycle();
                if(this.zzb) {
                    this.zzj[0] = id.cast_button_type_empty;
                }
                this.zzl = 0;
                int[] arr_v1 = this.zzj;
                for(int v = 0; v < arr_v1.length; ++v) {
                    if(arr_v1[v] != id.cast_button_type_empty) {
                        ++this.zzl;
                    }
                }
            }
            typedArray0.recycle();
        }
        zzp.zzd(zzpb.zzd);
    }

    private final void zza(UIMediaController uIMediaController0, RelativeLayout relativeLayout0, int v, int v1) {
        View view0 = relativeLayout0.findViewById(v);
        int v2 = this.zzj[v1];
        if(v2 == id.cast_button_type_empty) {
            ((ImageView)view0).setVisibility(4);
            return;
        }
        if(v2 != id.cast_button_type_custom) {
            if(v2 == id.cast_button_type_play_pause_toggle) {
                int v3 = this.zzm;
                int v4 = this.zzn;
                int v5 = this.zzo;
                if(this.zzl == 1) {
                    v3 = this.zzp;
                    v4 = this.zzq;
                    v5 = this.zzr;
                }
                Drawable drawable0 = zzq.zzc(this.getContext(), this.zzi, v3);
                Drawable drawable1 = zzq.zzc(this.getContext(), this.zzi, v4);
                Drawable drawable2 = zzq.zzc(this.getContext(), this.zzi, v5);
                ((ImageView)view0).setImageDrawable(drawable1);
                ProgressBar progressBar0 = new ProgressBar(this.getContext());
                RelativeLayout.LayoutParams relativeLayout$LayoutParams0 = new RelativeLayout.LayoutParams(-2, -2);
                relativeLayout$LayoutParams0.addRule(8, v);
                relativeLayout$LayoutParams0.addRule(6, v);
                relativeLayout$LayoutParams0.addRule(5, v);
                relativeLayout$LayoutParams0.addRule(7, v);
                relativeLayout$LayoutParams0.addRule(15);
                progressBar0.setLayoutParams(relativeLayout$LayoutParams0);
                progressBar0.setVisibility(8);
                Drawable drawable3 = progressBar0.getIndeterminateDrawable();
                int v6 = this.zzh;
                if(v6 != 0 && drawable3 != null) {
                    drawable3.setColorFilter(v6, PorterDuff.Mode.SRC_IN);
                }
                relativeLayout0.addView(progressBar0);
                uIMediaController0.bindImageViewToPlayPauseToggle(((ImageView)view0), drawable0, drawable1, drawable2, progressBar0, true);
                return;
            }
            if(v2 == id.cast_button_type_skip_previous) {
                ((ImageView)view0).setImageDrawable(zzq.zzc(this.getContext(), this.zzi, this.zzs));
                ((ImageView)view0).setContentDescription(this.getResources().getString(string.cast_skip_prev));
                uIMediaController0.bindViewToSkipPrev(((ImageView)view0), 0);
                return;
            }
            if(v2 == id.cast_button_type_skip_next) {
                ((ImageView)view0).setImageDrawable(zzq.zzc(this.getContext(), this.zzi, this.zzt));
                ((ImageView)view0).setContentDescription(this.getResources().getString(string.cast_skip_next));
                uIMediaController0.bindViewToSkipNext(((ImageView)view0), 0);
                return;
            }
            if(v2 == id.cast_button_type_rewind_30_seconds) {
                ((ImageView)view0).setImageDrawable(zzq.zzc(this.getContext(), this.zzi, this.zzu));
                ((ImageView)view0).setContentDescription(this.getResources().getString(string.cast_rewind_30));
                uIMediaController0.bindViewToRewind(((ImageView)view0), 30000L);
                return;
            }
            if(v2 == id.cast_button_type_forward_30_seconds) {
                ((ImageView)view0).setImageDrawable(zzq.zzc(this.getContext(), this.zzi, this.zzv));
                ((ImageView)view0).setContentDescription(this.getResources().getString(string.cast_forward_30));
                uIMediaController0.bindViewToForward(((ImageView)view0), 30000L);
                return;
            }
            if(v2 == id.cast_button_type_mute_toggle) {
                ((ImageView)view0).setImageDrawable(zzq.zzc(this.getContext(), this.zzi, this.zzw));
                uIMediaController0.bindImageViewToMuteToggle(((ImageView)view0));
                return;
            }
            if(v2 == id.cast_button_type_closed_caption) {
                ((ImageView)view0).setImageDrawable(zzq.zzc(this.getContext(), this.zzi, this.zzx));
                uIMediaController0.bindViewToClosedCaption(((ImageView)view0));
            }
        }
    }
}

