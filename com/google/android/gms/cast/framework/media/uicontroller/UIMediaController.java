package com.google.android.gms.cast.framework.media.uicontroller;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.o;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.fragment.app.a;
import androidx.fragment.app.l0;
import com.google.android.gms.cast.MediaSeekOptions.Builder;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R.string;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.TracksChooserDialogFragment;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzcc;
import com.google.android.gms.internal.cast.zzcd;
import com.google.android.gms.internal.cast.zzce;
import com.google.android.gms.internal.cast.zzcg;
import com.google.android.gms.internal.cast.zzci;
import com.google.android.gms.internal.cast.zzcj;
import com.google.android.gms.internal.cast.zzck;
import com.google.android.gms.internal.cast.zzcl;
import com.google.android.gms.internal.cast.zzcm;
import com.google.android.gms.internal.cast.zzcn;
import com.google.android.gms.internal.cast.zzcp;
import com.google.android.gms.internal.cast.zzcq;
import com.google.android.gms.internal.cast.zzcr;
import com.google.android.gms.internal.cast.zzcs;
import com.google.android.gms.internal.cast.zzcu;
import com.google.android.gms.internal.cast.zzcv;
import com.google.android.gms.internal.cast.zzcw;
import com.google.android.gms.internal.cast.zzcx;
import com.google.android.gms.internal.cast.zzcy;
import com.google.android.gms.internal.cast.zzcz;
import com.google.android.gms.internal.cast.zzda;
import com.google.android.gms.internal.cast.zzdb;
import com.google.android.gms.internal.cast.zzdc;
import com.google.android.gms.internal.cast.zzp;
import com.google.android.gms.internal.cast.zzpb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

public class UIMediaController implements SessionManagerListener, Listener {
    final zza zza;
    private static final Logger zzb;
    private final Activity zzc;
    private final SessionManager zzd;
    private final Map zze;
    private final Set zzf;
    private Listener zzg;
    private RemoteMediaClient zzh;

    static {
        UIMediaController.zzb = new Logger("UIMediaController");
    }

    public UIMediaController(Activity activity0) {
        this.zze = new HashMap();
        this.zzf = new HashSet();
        this.zza = zza.zzf();
        this.zzc = activity0;
        CastContext castContext0 = CastContext.zzb(activity0);
        zzp.zzd(zzpb.zzp);
        SessionManager sessionManager0 = castContext0 == null ? null : castContext0.getSessionManager();
        this.zzd = sessionManager0;
        if(sessionManager0 != null) {
            sessionManager0.addSessionManagerListener(this, CastSession.class);
            this.zzh(sessionManager0.getCurrentCastSession());
        }
    }

    @Deprecated
    public void bindImageViewToImageOfCurrentItem(ImageView imageView0, int v, int v1) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        ImageHints imageHints0 = new ImageHints(v, 0, 0);
        this.zzl(imageView0, new zzcj(imageView0, this.zzc, imageHints0, v1, null, null));
    }

    @Deprecated
    public void bindImageViewToImageOfCurrentItem(ImageView imageView0, int v, View view0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        ImageHints imageHints0 = new ImageHints(v, 0, 0);
        this.zzl(imageView0, new zzcj(imageView0, this.zzc, imageHints0, 0, view0, null));
    }

    public void bindImageViewToImageOfCurrentItem(ImageView imageView0, ImageHints imageHints0, int v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzl(imageView0, new zzcj(imageView0, this.zzc, imageHints0, v, null, null));
    }

    public void bindImageViewToImageOfCurrentItem(ImageView imageView0, ImageHints imageHints0, View view0) {
        this.zzb(imageView0, imageHints0, view0, null);
    }

    @Deprecated
    public void bindImageViewToImageOfPreloadedItem(ImageView imageView0, int v, int v1) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        ImageHints imageHints0 = new ImageHints(v, 0, 0);
        this.zzl(imageView0, new zzcg(imageView0, this.zzc, imageHints0, v1));
    }

    public void bindImageViewToImageOfPreloadedItem(ImageView imageView0, ImageHints imageHints0, int v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzl(imageView0, new zzcg(imageView0, this.zzc, imageHints0, v));
    }

    public void bindImageViewToMuteToggle(ImageView imageView0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        imageView0.setOnClickListener(new zzb(this));
        this.zzl(imageView0, new zzcp(imageView0, this.zzc));
    }

    public void bindImageViewToPlayPauseToggle(ImageView imageView0, Drawable drawable0, Drawable drawable1, Drawable drawable2, View view0, boolean z) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzp.zzd(zzpb.zzm);
        imageView0.setOnClickListener(new zzc(this));
        this.zzl(imageView0, new zzcq(imageView0, this.zzc, drawable0, drawable1, drawable2, view0, z));
    }

    public void bindProgressBar(ProgressBar progressBar0) {
        this.bindProgressBar(progressBar0, 1000L);
    }

    public void bindProgressBar(ProgressBar progressBar0, long v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzl(progressBar0, new zzcr(progressBar0, v));
    }

    public void bindSeekBar(SeekBar seekBar0) {
        this.bindSeekBar(seekBar0, 1000L);
    }

    public void bindSeekBar(SeekBar seekBar0, long v) {
        zzp.zzd(zzpb.zzn);
        Preconditions.checkMainThread("Must be called from the main thread.");
        seekBar0.setOnSeekBarChangeListener(new zzi(this, seekBar0));
        this.zzl(seekBar0, new zzcu(seekBar0, v, this.zza));
    }

    public void bindSeekBar(CastSeekBar castSeekBar0) {
        this.bindSeekBar(castSeekBar0, 1000L);
    }

    public void bindSeekBar(CastSeekBar castSeekBar0, long v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzp.zzd(zzpb.zzn);
        castSeekBar0.zzd = new zzh(this);
        this.zzl(castSeekBar0, new zzcc(castSeekBar0, v, this.zza));
    }

    public void bindTextViewToMetadataOfCurrentItem(TextView textView0, String s) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.bindTextViewToMetadataOfCurrentItem(textView0, Collections.singletonList(s));
    }

    public void bindTextViewToMetadataOfCurrentItem(TextView textView0, List list0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzl(textView0, new zzcn(textView0, list0));
    }

    public void bindTextViewToMetadataOfPreloadedItem(TextView textView0, String s) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.bindTextViewToMetadataOfPreloadedItem(textView0, Collections.singletonList(s));
    }

    public void bindTextViewToMetadataOfPreloadedItem(TextView textView0, List list0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzl(textView0, new zzcm(textView0, list0));
    }

    public void bindTextViewToSmartSubtitle(TextView textView0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzl(textView0, new zzcx(textView0));
    }

    public void bindTextViewToStreamDuration(TextView textView0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzl(textView0, new zzcy(textView0, this.zzc.getString(string.cast_invalid_stream_duration_text), null));
    }

    public void bindTextViewToStreamDuration(TextView textView0, View view0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzl(textView0, new zzcy(textView0, this.zzc.getString(string.cast_invalid_stream_duration_text), view0));
    }

    public void bindTextViewToStreamPosition(TextView textView0, boolean z) {
        this.bindTextViewToStreamPosition(textView0, z, 1000L);
    }

    public void bindTextViewToStreamPosition(TextView textView0, boolean z, long v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzcz zzcz0 = new zzcz(textView0, v, this.zzc.getString(string.cast_invalid_stream_position_text));
        if(z) {
            this.zzf.add(zzcz0);
        }
        this.zzl(textView0, zzcz0);
    }

    public void bindViewToClosedCaption(View view0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view0.setOnClickListener(new zzk(this));
        this.zzl(view0, new zzcd(view0, this.zzc));
    }

    public void bindViewToForward(View view0, long v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view0.setOnClickListener(new zzf(this, v));
        this.zzl(view0, new zzce(view0, this.zza));
    }

    public void bindViewToLaunchExpandedController(View view0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view0.setOnClickListener(new zzj(this));
        this.zzl(view0, new zzck(view0));
    }

    public void bindViewToLoadingIndicator(View view0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzl(view0, new zzcl(view0));
    }

    public void bindViewToRewind(View view0, long v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view0.setOnClickListener(new zzg(this, v));
        this.zzl(view0, new zzcs(view0, this.zza));
    }

    public void bindViewToSkipNext(View view0, int v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view0.setOnClickListener(new zzd(this));
        this.zzl(view0, new zzcv(view0, v));
    }

    public void bindViewToSkipPrev(View view0, int v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view0.setOnClickListener(new zze(this));
        this.zzl(view0, new zzcw(view0, v));
    }

    public void bindViewToUIController(View view0, UIController uIController0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzl(view0, uIController0);
    }

    public void bindViewVisibilityToMediaSession(View view0, int v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzl(view0, new zzdc(view0, v));
    }

    public void bindViewVisibilityToPreloadingEvent(View view0, int v) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzl(view0, new zzdb(view0, v));
    }

    public void dispose() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzg();
        this.zze.clear();
        SessionManager sessionManager0 = this.zzd;
        if(sessionManager0 != null) {
            sessionManager0.removeSessionManagerListener(this, CastSession.class);
        }
        this.zzg = null;
    }

    public RemoteMediaClient getRemoteMediaClient() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzh;
    }

    @EnsuresNonNullIf(expression = {"remoteMediaClient"}, result = true)
    public boolean isActive() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzh != null;
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Listener
    public void onAdBreakStatusUpdated() {
        this.zzm();
        Listener remoteMediaClient$Listener0 = this.zzg;
        if(remoteMediaClient$Listener0 != null) {
            remoteMediaClient$Listener0.onAdBreakStatusUpdated();
        }
    }

    public void onClosedCaptionClicked(View view0) {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession()) {
            Activity activity0 = this.zzc;
            if(activity0 instanceof FragmentActivity) {
                TracksChooserDialogFragment tracksChooserDialogFragment0 = TracksChooserDialogFragment.newInstance();
                l0 l00 = ((FragmentActivity)activity0).getSupportFragmentManager();
                a a0 = o.f(l00, l00);
                I i0 = ((FragmentActivity)activity0).getSupportFragmentManager().E("TRACKS_CHOOSER_DIALOG_TAG");
                if(i0 != null) {
                    a0.f(i0);
                }
                tracksChooserDialogFragment0.show(a0, "TRACKS_CHOOSER_DIALOG_TAG");
            }
        }
    }

    public void onForwardClicked(View view0, long v) {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession()) {
            if(remoteMediaClient0.zzw()) {
                long v1 = remoteMediaClient0.getApproximateStreamPosition();
                long v2 = (long)this.zza.zzc();
                remoteMediaClient0.seek(Math.min(v1 + v, this.zza.zze() + v2));
                return;
            }
            remoteMediaClient0.seek(remoteMediaClient0.getApproximateStreamPosition() + v);
        }
    }

    public void onLaunchExpandedControllerClicked(View view0) {
        Activity activity0 = this.zzc;
        CastMediaOptions castMediaOptions0 = CastContext.getSharedInstance(activity0).getCastOptions().getCastMediaOptions();
        if(castMediaOptions0 != null && !TextUtils.isEmpty(castMediaOptions0.getExpandedControllerActivityClassName())) {
            ComponentName componentName0 = new ComponentName(activity0.getApplicationContext(), castMediaOptions0.getExpandedControllerActivityClassName());
            Intent intent0 = new Intent();
            intent0.setComponent(componentName0);
            activity0.startActivity(intent0);
        }
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Listener
    public void onMetadataUpdated() {
        this.zzm();
        Listener remoteMediaClient$Listener0 = this.zzg;
        if(remoteMediaClient$Listener0 != null) {
            remoteMediaClient$Listener0.onMetadataUpdated();
        }
    }

    public void onMuteToggleClicked(ImageView imageView0) {
        CastSession castSession0 = CastContext.getSharedInstance(this.zzc.getApplicationContext()).getSessionManager().getCurrentCastSession();
        if(castSession0 != null && castSession0.isConnected()) {
            try {
                castSession0.setMute(!castSession0.isMute());
            }
            catch(IOException | IllegalArgumentException iOException0) {
                UIMediaController.zzb.e("Unable to call CastSession.setMute(boolean).", new Object[]{iOException0});
            }
        }
    }

    public void onPlayPauseToggleClicked(ImageView imageView0) {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession()) {
            remoteMediaClient0.togglePlayback();
        }
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Listener
    public void onPreloadStatusUpdated() {
        this.zzm();
        Listener remoteMediaClient$Listener0 = this.zzg;
        if(remoteMediaClient$Listener0 != null) {
            remoteMediaClient$Listener0.onPreloadStatusUpdated();
        }
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Listener
    public void onQueueStatusUpdated() {
        this.zzm();
        Listener remoteMediaClient$Listener0 = this.zzg;
        if(remoteMediaClient$Listener0 != null) {
            remoteMediaClient$Listener0.onQueueStatusUpdated();
        }
    }

    public void onRewindClicked(View view0, long v) {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession()) {
            if(remoteMediaClient0.zzw()) {
                long v1 = remoteMediaClient0.getApproximateStreamPosition();
                long v2 = (long)this.zza.zzd();
                remoteMediaClient0.seek(Math.max(v1 - v, this.zza.zze() + v2));
                return;
            }
            remoteMediaClient0.seek(remoteMediaClient0.getApproximateStreamPosition() - v);
        }
    }

    public void onSeekBarProgressChanged(SeekBar seekBar0, int v, boolean z) {
        this.zzi(v, z);
    }

    public void onSeekBarStartTrackingTouch(SeekBar seekBar0) {
        Map map0 = this.zze;
        if(map0.containsKey(seekBar0)) {
            for(Object object0: ((List)map0.get(seekBar0))) {
                UIController uIController0 = (UIController)object0;
                if(uIController0 instanceof zzcu) {
                    ((zzcu)uIController0).zza(false);
                }
            }
        }
        this.zzj();
    }

    public void onSeekBarStopTrackingTouch(SeekBar seekBar0) {
        Map map0 = this.zze;
        if(map0.containsKey(seekBar0)) {
            for(Object object0: ((List)map0.get(seekBar0))) {
                UIController uIController0 = (UIController)object0;
                if(uIController0 instanceof zzcu) {
                    ((zzcu)uIController0).zza(true);
                }
            }
        }
        this.zzk(seekBar0.getProgress());
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Listener
    public void onSendingRemoteMediaRequest() {
        for(Object object0: this.zze.values()) {
            for(Object object1: ((List)object0)) {
                ((UIController)object1).onSendingRemoteMediaRequest();
            }
        }
        Listener remoteMediaClient$Listener0 = this.zzg;
        if(remoteMediaClient$Listener0 != null) {
            remoteMediaClient$Listener0.onSendingRemoteMediaRequest();
        }
    }

    public void onSessionEnded(CastSession castSession0, int v) {
        this.zzg();
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionEnded(Session session0, int v) {
        this.onSessionEnded(((CastSession)session0), v);
    }

    public void onSessionEnding(CastSession castSession0) {
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionEnding(Session session0) {
    }

    public void onSessionResumeFailed(CastSession castSession0, int v) {
        this.zzg();
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionResumeFailed(Session session0, int v) {
        this.onSessionResumeFailed(((CastSession)session0), v);
    }

    public void onSessionResumed(CastSession castSession0, boolean z) {
        this.zzh(castSession0);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionResumed(Session session0, boolean z) {
        this.onSessionResumed(((CastSession)session0), z);
    }

    public void onSessionResuming(CastSession castSession0, String s) {
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionResuming(Session session0, String s) {
    }

    public void onSessionStartFailed(CastSession castSession0, int v) {
        this.zzg();
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionStartFailed(Session session0, int v) {
        this.onSessionStartFailed(((CastSession)session0), v);
    }

    public void onSessionStarted(CastSession castSession0, String s) {
        this.zzh(castSession0);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionStarted(Session session0, String s) {
        this.onSessionStarted(((CastSession)session0), s);
    }

    public void onSessionStarting(CastSession castSession0) {
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionStarting(Session session0) {
    }

    public void onSessionSuspended(CastSession castSession0, int v) {
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public final void onSessionSuspended(Session session0, int v) {
    }

    public void onSkipNextClicked(View view0) {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession()) {
            remoteMediaClient0.queueNext(null);
        }
    }

    public void onSkipPrevClicked(View view0) {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession()) {
            remoteMediaClient0.queuePrev(null);
        }
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Listener
    public void onStatusUpdated() {
        this.zzm();
        Listener remoteMediaClient$Listener0 = this.zzg;
        if(remoteMediaClient$Listener0 != null) {
            remoteMediaClient$Listener0.onStatusUpdated();
        }
    }

    public void setPostRemoteMediaClientListener(Listener remoteMediaClient$Listener0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzg = remoteMediaClient$Listener0;
    }

    public final zza zza() {
        return this.zza;
    }

    public final void zzb(ImageView imageView0, ImageHints imageHints0, View view0, zzci zzci0) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzl(imageView0, new zzcj(imageView0, this.zzc, imageHints0, 0, view0, zzci0));
    }

    public final void zzc(CastSeekBar castSeekBar0, int v, boolean z) {
        this.zzi(v, z);
    }

    public final void zzd(CastSeekBar castSeekBar0) {
        this.zzj();
    }

    public final void zze(CastSeekBar castSeekBar0) {
        this.zzk(castSeekBar0.getProgress());
    }

    public final void zzf(zzda zzda0) {
        this.zzf.add(zzda0);
    }

    private final void zzg() {
        if(!this.isActive()) {
            return;
        }
        this.zza.zza = null;
        for(Object object0: this.zze.values()) {
            for(Object object1: ((List)object0)) {
                ((UIController)object1).onSessionEnded();
            }
        }
        Preconditions.checkNotNull(this.zzh);
        this.zzh.removeListener(this);
        this.zzh = null;
    }

    private final void zzh(Session session0) {
        if(!this.isActive() && session0 != null && session0.isConnected()) {
            RemoteMediaClient remoteMediaClient0 = ((CastSession)session0).getRemoteMediaClient();
            this.zzh = remoteMediaClient0;
            if(remoteMediaClient0 != null) {
                remoteMediaClient0.addListener(this);
                Preconditions.checkNotNull(this.zza);
                this.zza.zza = ((CastSession)session0).getRemoteMediaClient();
                for(Object object0: this.zze.values()) {
                    for(Object object1: ((List)object0)) {
                        ((UIController)object1).onSessionConnected(((CastSession)session0));
                    }
                }
                this.zzm();
            }
        }
    }

    private final void zzi(int v, boolean z) {
        if(z) {
            for(Object object0: this.zzf) {
                ((zzda)object0).zzb(this.zza.zze() + ((long)v));
            }
        }
    }

    private final void zzj() {
        for(Object object0: this.zzf) {
            ((zzda)object0).zza(false);
        }
    }

    private final void zzk(int v) {
        boolean z;
        Iterator iterator0 = this.zzf.iterator();
        while(true) {
            z = true;
            if(!iterator0.hasNext()) {
                break;
            }
            Object object0 = iterator0.next();
            ((zzda)object0).zza(true);
        }
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession()) {
            long v1 = this.zza.zze() + ((long)v);
            Builder mediaSeekOptions$Builder0 = new Builder();
            mediaSeekOptions$Builder0.setPosition(v1);
            if(!remoteMediaClient0.isLiveStream() || !this.zza.zzn(v1)) {
                z = false;
            }
            mediaSeekOptions$Builder0.setIsSeekToInfinite(z);
            remoteMediaClient0.seek(mediaSeekOptions$Builder0.build());
        }
    }

    private final void zzl(View view0, UIController uIController0) {
        SessionManager sessionManager0 = this.zzd;
        if(sessionManager0 != null) {
            Map map0 = this.zze;
            List list0 = (List)map0.get(view0);
            if(list0 == null) {
                list0 = new ArrayList();
                map0.put(view0, list0);
            }
            list0.add(uIController0);
            if(this.isActive()) {
                uIController0.onSessionConnected(((CastSession)Preconditions.checkNotNull(sessionManager0.getCurrentCastSession())));
                this.zzm();
            }
        }
    }

    private final void zzm() {
        for(Object object0: this.zze.values()) {
            for(Object object1: ((List)object0)) {
                ((UIController)object1).onMediaStatusUpdated();
            }
        }
    }
}

