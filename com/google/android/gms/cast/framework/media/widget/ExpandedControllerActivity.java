package com.google.android.gms.cast.framework.media.widget;

import android.annotation.TargetApi;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.cast.AdBreakClipInfo;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R.attr;
import com.google.android.gms.cast.framework.R.drawable;
import com.google.android.gms.cast.framework.R.id;
import com.google.android.gms.cast.framework.R.layout;
import com.google.android.gms.cast.framework.R.string;
import com.google.android.gms.cast.framework.R.style;
import com.google.android.gms.cast.framework.R.styleable;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.internal.zzb;
import com.google.android.gms.cast.framework.media.internal.zzv;
import com.google.android.gms.cast.framework.media.uicontroller.UIMediaController;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzdd;
import com.google.android.gms.internal.cast.zzde;
import com.google.android.gms.internal.cast.zzdf;
import com.google.android.gms.internal.cast.zzdg;
import com.google.android.gms.internal.cast.zzp;
import com.google.android.gms.internal.cast.zzpb;
import java.util.Timer;

public abstract class ExpandedControllerActivity extends AppCompatActivity implements ControlButtonsContainer {
    private ImageView zzA;
    private int[] zzB;
    private final ImageView[] zzC;
    private View zzD;
    private View zzE;
    private ImageView zzF;
    private TextView zzG;
    private TextView zzH;
    private TextView zzI;
    private TextView zzJ;
    private UIMediaController zzK;
    private SessionManager zzL;
    private Listener zzM;
    private boolean zzN;
    private Timer zzO;
    private String zzP;
    final SessionManagerListener zza;
    final com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener zzb;
    zzb zzc;
    boolean zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
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
    private TextView zzw;
    private SeekBar zzx;
    private CastSeekBar zzy;
    private ImageView zzz;

    public ExpandedControllerActivity() {
        this.zza = new zzo(this, null);
        this.zzb = new zzn(this, null);
        this.zzC = new ImageView[4];
    }

    @Override  // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    public final ImageView getButtonImageViewAt(int v) {
        return this.zzC[v];
    }

    @Override  // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    public final int getButtonSlotCount() {
        return 4;
    }

    @Override  // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    public final int getButtonTypeAt(int v) {
        return this.zzB[v];
    }

    @Deprecated
    public SeekBar getSeekBar() {
        return this.zzx;
    }

    public TextView getStatusTextView() {
        return this.zzw;
    }

    @Override  // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    public UIMediaController getUIMediaController() {
        return this.zzK;
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        SessionManager sessionManager0 = CastContext.getSharedInstance(this).getSessionManager();
        this.zzL = sessionManager0;
        if(sessionManager0.getCurrentCastSession() == null) {
            this.finish();
        }
        UIMediaController uIMediaController0 = new UIMediaController(this);
        this.zzK = uIMediaController0;
        uIMediaController0.setPostRemoteMediaClientListener(this.zzb);
        this.setContentView(layout.cast_expanded_controller_activity);
        TypedArray typedArray0 = this.obtainStyledAttributes(new int[]{0x7F040537});  // attr:selectableItemBackgroundBorderless
        this.zze = typedArray0.getResourceId(0, 0);
        typedArray0.recycle();
        TypedArray typedArray1 = this.obtainStyledAttributes(null, styleable.CastExpandedController, attr.castExpandedControllerStyle, style.CastExpandedController);
        this.zzs = typedArray1.getResourceId(styleable.CastExpandedController_castButtonColor, 0);
        this.zzf = typedArray1.getResourceId(styleable.CastExpandedController_castPlayButtonDrawable, 0);
        this.zzg = typedArray1.getResourceId(styleable.CastExpandedController_castPauseButtonDrawable, 0);
        this.zzh = typedArray1.getResourceId(styleable.CastExpandedController_castStopButtonDrawable, 0);
        this.zzi = typedArray1.getResourceId(styleable.CastExpandedController_castSkipPreviousButtonDrawable, 0);
        this.zzj = typedArray1.getResourceId(styleable.CastExpandedController_castSkipNextButtonDrawable, 0);
        this.zzk = typedArray1.getResourceId(styleable.CastExpandedController_castRewind30ButtonDrawable, 0);
        this.zzl = typedArray1.getResourceId(styleable.CastExpandedController_castForward30ButtonDrawable, 0);
        this.zzm = typedArray1.getResourceId(styleable.CastExpandedController_castMuteToggleButtonDrawable, 0);
        this.zzn = typedArray1.getResourceId(styleable.CastExpandedController_castClosedCaptionsButtonDrawable, 0);
        int v = typedArray1.getResourceId(styleable.CastExpandedController_castControlButtons, 0);
        if(v == 0) {
            this.zzB = new int[]{id.cast_button_type_empty, id.cast_button_type_empty, id.cast_button_type_empty, id.cast_button_type_empty};
        }
        else {
            TypedArray typedArray2 = this.getResources().obtainTypedArray(v);
            Preconditions.checkArgument(typedArray2.length() == 4);
            this.zzB = new int[typedArray2.length()];
            for(int v1 = 0; v1 < typedArray2.length(); ++v1) {
                int[] arr_v = this.zzB;
                arr_v[v1] = typedArray2.getResourceId(v1, 0);
            }
            typedArray2.recycle();
        }
        this.zzr = typedArray1.getColor(styleable.CastExpandedController_castExpandedControllerLoadingIndicatorColor, 0);
        int v2 = typedArray1.getResourceId(styleable.CastExpandedController_castAdLabelColor, 0);
        this.zzo = this.getResources().getColor(v2);
        int v3 = typedArray1.getResourceId(styleable.CastExpandedController_castAdInProgressTextColor, 0);
        this.zzp = this.getResources().getColor(v3);
        int v4 = typedArray1.getResourceId(styleable.CastExpandedController_castAdLabelTextColor, 0);
        this.zzq = this.getResources().getColor(v4);
        this.zzt = typedArray1.getResourceId(styleable.CastExpandedController_castAdLabelTextAppearance, 0);
        this.zzu = typedArray1.getResourceId(styleable.CastExpandedController_castAdInProgressLabelTextAppearance, 0);
        this.zzv = typedArray1.getResourceId(styleable.CastExpandedController_castAdInProgressText, 0);
        int v5 = typedArray1.getResourceId(styleable.CastExpandedController_castDefaultAdPosterUrl, 0);
        if(v5 != 0) {
            this.zzP = this.getApplicationContext().getResources().getString(v5);
        }
        typedArray1.recycle();
        View view0 = this.findViewById(id.expanded_controller_layout);
        UIMediaController uIMediaController1 = this.zzK;
        this.zzz = (ImageView)view0.findViewById(id.background_image_view);
        this.zzA = (ImageView)view0.findViewById(id.blurred_background_image_view);
        View view1 = view0.findViewById(id.background_place_holder_image_view);
        DisplayMetrics displayMetrics0 = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics0);
        uIMediaController1.zzb(this.zzz, new ImageHints(4, displayMetrics0.widthPixels, displayMetrics0.heightPixels), view1, new zzm(this, null));
        this.zzw = (TextView)view0.findViewById(id.status_text);
        ProgressBar progressBar0 = (ProgressBar)view0.findViewById(id.loading_indicator);
        Drawable drawable0 = progressBar0.getIndeterminateDrawable();
        int v6 = this.zzr;
        if(v6 != 0) {
            drawable0.setColorFilter(v6, PorterDuff.Mode.SRC_IN);
        }
        uIMediaController1.bindViewToLoadingIndicator(progressBar0);
        TextView textView0 = (TextView)view0.findViewById(id.start_text);
        TextView textView1 = (TextView)view0.findViewById(id.end_text);
        this.zzx = (SeekBar)view0.findViewById(id.seek_bar);
        CastSeekBar castSeekBar0 = (CastSeekBar)view0.findViewById(id.cast_seek_bar);
        this.zzy = castSeekBar0;
        uIMediaController1.bindSeekBar(castSeekBar0, 1000L);
        uIMediaController1.bindViewToUIController(textView0, new zzdf(textView0, uIMediaController1.zza()));
        uIMediaController1.bindViewToUIController(textView1, new zzdd(textView1, uIMediaController1.zza()));
        View view2 = view0.findViewById(id.live_indicators);
        uIMediaController1.bindViewToUIController(view2, new zzde(view2, uIMediaController1.zza()));
        RelativeLayout relativeLayout0 = (RelativeLayout)view0.findViewById(id.tooltip_container);
        zzdg zzdg0 = new zzdg(relativeLayout0, this.zzy, uIMediaController1.zza());
        uIMediaController1.bindViewToUIController(relativeLayout0, zzdg0);
        uIMediaController1.zzf(zzdg0);
        this.zzC[0] = (ImageView)view0.findViewById(id.button_0);
        this.zzC[1] = (ImageView)view0.findViewById(id.button_1);
        this.zzC[2] = (ImageView)view0.findViewById(id.button_2);
        this.zzC[3] = (ImageView)view0.findViewById(id.button_3);
        this.zzl(view0, id.button_0, this.zzB[0], uIMediaController1);
        this.zzl(view0, id.button_1, this.zzB[1], uIMediaController1);
        this.zzl(view0, id.button_play_pause_toggle, id.cast_button_type_play_pause_toggle, uIMediaController1);
        this.zzl(view0, id.button_2, this.zzB[2], uIMediaController1);
        this.zzl(view0, id.button_3, this.zzB[3], uIMediaController1);
        View view3 = this.findViewById(id.ad_container);
        this.zzD = view3;
        this.zzF = (ImageView)view3.findViewById(id.ad_image_view);
        this.zzE = this.zzD.findViewById(id.ad_background_image_view);
        TextView textView2 = (TextView)this.zzD.findViewById(id.ad_label);
        this.zzH = textView2;
        textView2.setTextColor(this.zzq);
        this.zzH.setBackgroundColor(this.zzo);
        this.zzG = (TextView)this.zzD.findViewById(id.ad_in_progress_label);
        this.zzJ = (TextView)this.findViewById(id.ad_skip_text);
        TextView textView3 = (TextView)this.findViewById(id.ad_skip_button);
        this.zzI = textView3;
        textView3.setOnClickListener(new zzi(this));
        this.setSupportActionBar(((Toolbar)this.findViewById(id.toolbar)));
        a a0 = this.getSupportActionBar();
        if(a0 != null) {
            a0.n(true);
            a0.o(drawable.quantum_ic_keyboard_arrow_down_white_36);
        }
        this.zzn();
        this.zzo();
        if(this.zzG != null && this.zzv != 0) {
            this.zzG.setTextAppearance(this.zzu);
            this.zzG.setTextColor(this.zzp);
            this.zzG.setText(this.zzv);
        }
        zzb zzb0 = new zzb(this.getApplicationContext(), new ImageHints(-1, this.zzF.getWidth(), this.zzF.getHeight()));
        this.zzc = zzb0;
        zzb0.zzc(new zzh(this));
        zzp.zzd(zzpb.zzc);
    }

    @Override  // androidx.appcompat.app.AppCompatActivity
    public void onDestroy() {
        this.zzc.zza();
        UIMediaController uIMediaController0 = this.zzK;
        if(uIMediaController0 != null) {
            uIMediaController0.setPostRemoteMediaClientListener(null);
            this.zzK.dispose();
        }
        super.onDestroy();
    }

    @Override  // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem0) {
        if(menuItem0.getItemId() == 0x102002C) {
            this.finish();
        }
        return true;
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onPause() {
        SessionManager sessionManager0 = this.zzL;
        if(sessionManager0 == null) {
            return;
        }
        CastSession castSession0 = sessionManager0.getCurrentCastSession();
        Listener cast$Listener0 = this.zzM;
        if(cast$Listener0 != null && castSession0 != null) {
            castSession0.removeCastListener(cast$Listener0);
            this.zzM = null;
        }
        this.zzL.removeSessionManagerListener(this.zza, CastSession.class);
        super.onPause();
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onResume() {
        SessionManager sessionManager0 = this.zzL;
        if(sessionManager0 == null) {
            return;
        }
        sessionManager0.addSessionManagerListener(this.zza, CastSession.class);
        CastSession castSession0 = this.zzL.getCurrentCastSession();
        if(castSession0 == null || !castSession0.isConnected() && !castSession0.isConnecting()) {
            this.finish();
        }
        else {
            zzl zzl0 = new zzl(this);
            this.zzM = zzl0;
            castSession0.addCastListener(zzl0);
        }
        RemoteMediaClient remoteMediaClient0 = this.zzj();
        this.zzd = remoteMediaClient0 == null || !remoteMediaClient0.hasMediaSession();
        this.zzn();
        this.zzp();
        super.onResume();
    }

    @Override  // android.app.Activity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if(z) {
            int v = this.getWindow().getDecorView().getSystemUiVisibility();
            this.getWindow().getDecorView().setSystemUiVisibility(v ^ 0x1006);
            this.setImmersive(true);
        }
    }

    private final RemoteMediaClient zzj() {
        CastSession castSession0 = this.zzL.getCurrentCastSession();
        return castSession0 == null || !castSession0.isConnected() ? null : castSession0.getRemoteMediaClient();
    }

    private final void zzk(String s) {
        Uri uri0 = Uri.parse(s);
        this.zzc.zzd(uri0);
        this.zzE.setVisibility(8);
    }

    private final void zzl(View view0, int v, int v1, UIMediaController uIMediaController0) {
        ImageView imageView0 = (ImageView)view0.findViewById(v);
        if(v1 == id.cast_button_type_empty) {
            imageView0.setVisibility(4);
            return;
        }
        if(v1 == id.cast_button_type_play_pause_toggle) {
            imageView0.setBackgroundResource(this.zze);
            Drawable drawable0 = zzq.zzb(this, this.zzs, this.zzg);
            Drawable drawable1 = zzq.zzb(this, this.zzs, this.zzf);
            Drawable drawable2 = zzq.zzb(this, this.zzs, this.zzh);
            imageView0.setImageDrawable(drawable1);
            uIMediaController0.bindImageViewToPlayPauseToggle(imageView0, drawable1, drawable0, drawable2, null, false);
            return;
        }
        if(v1 == id.cast_button_type_skip_previous) {
            imageView0.setBackgroundResource(this.zze);
            imageView0.setImageDrawable(zzq.zzb(this, this.zzs, this.zzi));
            imageView0.setContentDescription(this.getResources().getString(string.cast_skip_prev));
            uIMediaController0.bindViewToSkipPrev(imageView0, 0);
            return;
        }
        if(v1 == id.cast_button_type_skip_next) {
            imageView0.setBackgroundResource(this.zze);
            imageView0.setImageDrawable(zzq.zzb(this, this.zzs, this.zzj));
            imageView0.setContentDescription(this.getResources().getString(string.cast_skip_next));
            uIMediaController0.bindViewToSkipNext(imageView0, 0);
            return;
        }
        if(v1 == id.cast_button_type_rewind_30_seconds) {
            imageView0.setBackgroundResource(this.zze);
            imageView0.setImageDrawable(zzq.zzb(this, this.zzs, this.zzk));
            imageView0.setContentDescription(this.getResources().getString(string.cast_rewind_30));
            uIMediaController0.bindViewToRewind(imageView0, 30000L);
            return;
        }
        if(v1 == id.cast_button_type_forward_30_seconds) {
            imageView0.setBackgroundResource(this.zze);
            imageView0.setImageDrawable(zzq.zzb(this, this.zzs, this.zzl));
            imageView0.setContentDescription(this.getResources().getString(string.cast_forward_30));
            uIMediaController0.bindViewToForward(imageView0, 30000L);
            return;
        }
        if(v1 == id.cast_button_type_mute_toggle) {
            imageView0.setBackgroundResource(this.zze);
            imageView0.setImageDrawable(zzq.zzb(this, this.zzs, this.zzm));
            uIMediaController0.bindImageViewToMuteToggle(imageView0);
            return;
        }
        if(v1 == id.cast_button_type_closed_caption) {
            imageView0.setBackgroundResource(this.zze);
            imageView0.setImageDrawable(zzq.zzb(this, this.zzs, this.zzn));
            uIMediaController0.bindViewToClosedCaption(imageView0);
        }
    }

    private final void zzm(RemoteMediaClient remoteMediaClient0) {
        if(!this.zzd) {
            MediaStatus mediaStatus0 = remoteMediaClient0.getMediaStatus();
            if(mediaStatus0 != null && !remoteMediaClient0.isBuffering()) {
                this.zzI.setVisibility(8);
                this.zzJ.setVisibility(8);
                AdBreakClipInfo adBreakClipInfo0 = mediaStatus0.getCurrentAdBreakClip();
                if(adBreakClipInfo0 != null && adBreakClipInfo0.getWhenSkippableInMs() != -1L) {
                    if(!this.zzN) {
                        zzk zzk0 = new zzk(this, remoteMediaClient0);
                        Timer timer0 = new Timer();
                        this.zzO = timer0;
                        timer0.scheduleAtFixedRate(zzk0, 0L, 500L);
                        this.zzN = true;
                    }
                    float f = (float)(adBreakClipInfo0.getWhenSkippableInMs() - remoteMediaClient0.getApproximateAdBreakClipPositionMs());
                    if(Float.compare(f, 0.0f) <= 0) {
                        if(this.zzN) {
                            this.zzO.cancel();
                            this.zzN = false;
                        }
                        this.zzI.setVisibility(0);
                        this.zzI.setClickable(true);
                        return;
                    }
                    this.zzJ.setVisibility(0);
                    this.zzJ.setText(this.getResources().getString(string.cast_expanded_controller_skip_ad_text, new Object[]{((int)Math.ceil(f / 1000.0f))}));
                    this.zzI.setClickable(false);
                }
            }
        }
    }

    private final void zzn() {
        CastSession castSession0 = this.zzL.getCurrentCastSession();
        if(castSession0 != null) {
            CastDevice castDevice0 = castSession0.getCastDevice();
            if(castDevice0 != null) {
                String s = castDevice0.getFriendlyName();
                if(!TextUtils.isEmpty(s)) {
                    this.zzw.setText(this.getResources().getString(string.cast_casting_to_device, new Object[]{s}));
                    return;
                }
            }
        }
        this.zzw.setText("");
    }

    private final void zzo() {
        RemoteMediaClient remoteMediaClient0 = this.zzj();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession()) {
            MediaInfo mediaInfo0 = remoteMediaClient0.getMediaInfo();
            if(mediaInfo0 != null) {
                MediaMetadata mediaMetadata0 = mediaInfo0.getMetadata();
                if(mediaMetadata0 != null) {
                    a a0 = this.getSupportActionBar();
                    if(a0 != null) {
                        a0.r(mediaMetadata0.getString("com.google.android.gms.cast.metadata.TITLE"));
                        String s = zzv.zze(mediaMetadata0);
                        if(s != null) {
                            a0.q(s);
                        }
                    }
                }
            }
        }
    }

    @TargetApi(23)
    private final void zzp() {
        String s1;
        RemoteMediaClient remoteMediaClient0 = this.zzj();
        if(remoteMediaClient0 != null) {
            String s = null;
            MediaStatus mediaStatus0 = remoteMediaClient0.getMediaStatus();
            if(mediaStatus0 != null) {
                if(mediaStatus0.isPlayingAd()) {
                    if(this.zzA.getVisibility() == 8) {
                        Drawable drawable0 = this.zzz.getDrawable();
                        if(drawable0 != null && drawable0 instanceof BitmapDrawable) {
                            Bitmap bitmap0 = ((BitmapDrawable)drawable0).getBitmap();
                            if(bitmap0 != null) {
                                Bitmap bitmap1 = zzq.zza(this, bitmap0, 0.25f, 7.5f);
                                if(bitmap1 != null) {
                                    this.zzA.setImageBitmap(bitmap1);
                                    this.zzA.setVisibility(0);
                                }
                            }
                        }
                    }
                    AdBreakClipInfo adBreakClipInfo0 = mediaStatus0.getCurrentAdBreakClip();
                    if(adBreakClipInfo0 == null) {
                        s1 = null;
                    }
                    else {
                        s = adBreakClipInfo0.getImageUrl();
                        s1 = adBreakClipInfo0.getTitle();
                    }
                    if(!TextUtils.isEmpty(s)) {
                        this.zzk(s);
                    }
                    else if(TextUtils.isEmpty(this.zzP)) {
                        this.zzG.setVisibility(0);
                        this.zzE.setVisibility(0);
                        this.zzF.setVisibility(8);
                    }
                    else {
                        this.zzk(this.zzP);
                    }
                    TextView textView0 = this.zzH;
                    if(TextUtils.isEmpty(s1)) {
                        s1 = this.getResources().getString(string.cast_ad_label);
                    }
                    textView0.setText(s1);
                    this.zzH.setTextAppearance(this.zzt);
                    this.zzD.setVisibility(0);
                    this.zzm(remoteMediaClient0);
                    return;
                }
                this.zzJ.setVisibility(8);
                this.zzI.setVisibility(8);
                this.zzD.setVisibility(8);
                this.zzA.setVisibility(8);
                this.zzA.setImageBitmap(null);
            }
        }
    }
}

