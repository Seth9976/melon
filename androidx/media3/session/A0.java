package androidx.media3.session;

import B8.b;
import H7.c;
import H7.d;
import I6.V;
import J8.U1;
import M6.x;
import Nb.h0;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.session.MediaController;
import android.media.session.MediaSession.Token;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import androidx.activity.result.ActivityResult;
import b3.N;
import b3.O;
import b3.P;
import b3.T;
import b3.m;
import com.android.volley.Response.Listener;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.ContextChooseDialog;
import com.facebook.gamingservices.ContextCreateDialog;
import com.facebook.gamingservices.ContextSwitchDialog;
import com.facebook.gamingservices.cloudgaming.DaemonRequest.Callback;
import com.facebook.internal.ImageResponse;
import com.facebook.login.LoginClient.OnCompletedListener;
import com.facebook.login.LoginClient.Result;
import com.facebook.login.LoginFragment;
import com.facebook.login.widget.ProfilePictureView;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter;
import com.google.android.exoplayer2.trackselection.FixedTrackSelection.Factory;
import com.google.android.exoplayer2.trackselection.TrackSelection.Definition;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil.AdaptiveTrackSelectionFactory;
import com.google.android.exoplayer2.util.FlacStreamMetadata;
import com.google.android.gms.tasks.Task;
import com.iloen.melon.custom.K;
import com.iloen.melon.custom.NewChartFilterLayout;
import com.iloen.melon.fragments.detail.viewholder.PlaylistMixHolder;
import com.iloen.melon.fragments.musicmessage.MusicMessageListFragment;
import com.iloen.melon.fragments.present.PresentSongSendFragment;
import com.iloen.melon.net.v4x.response.GiftListSongGiftBoxRes;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.template.TemplateImageLoader.CaptureStateListener;
import e.a;
import e3.e;
import e3.k;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.q;

public final class a0 implements b, D0, b0, c1, e1, Listener, Callback, com.facebook.internal.ImageRequest.Callback, OnCompletedListener, com.gaa.sdk.auth.b, SeekTimestampConverter, AdaptiveTrackSelectionFactory, K, CaptureStateListener, a, e, k, y7.a {
    public final int a;
    public final Object b;

    public a0(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // e3.k
    public void a(Object object0, m m0) {
        O o0 = new O(m0);
        ((P)object0).M(((androidx.media3.common.e)this.b), o0);
    }

    @Override  // e3.e
    public void accept(Object object0) {
        ((o1)object0).setVideoSurface(((Surface)this.b));
    }

    @Override  // androidx.media3.session.b0
    public void b(Q q0) {
        i i0 = (i)this.b;
        y1 y10 = q0.e;
        v v0 = q0.a;
        if(q0.x != null) {
            e3.b.p("MCImplBase", "Cannot be notified about the connection result many times. Probably a bug or malicious app.");
            v0.release();
            return;
        }
        V v1 = i0.n;
        q0.x = i0.c;
        q0.r = i0.e;
        q0.s = i0.f;
        q0.t = i0.g;
        N n0 = Q.c0(i0.f, i0.g);
        q0.u = n0;
        q0.o = i0.k;
        q0.p = i0.l;
        q0.q = Q.u0(i0.l, i0.k, q0.r, n0);
        B7.b b0 = new B7.b(4);
        for(int v2 = 0; v2 < v1.size(); ++v2) {
            androidx.media3.session.b b1 = (androidx.media3.session.b)v1.get(v2);
            s1 s10 = b1.a;
            if(s10 != null && s10.a == 0) {
                b0.v(s10.b, b1);
            }
        }
        b0.g();
        q0.n = i0.j;
        MediaSession.Token mediaSession$Token0 = i0.m == null ? y10.a.f() : i0.m;
        if(mediaSession$Token0 != null) {
            q0.y = new MediaController(q0.d, mediaSession$Token0);
        }
        try {
            i0.c.asBinder().linkToDeath(q0.g, 0);
        }
        catch(RemoteException unused_ex) {
            v0.release();
            return;
        }
        int v3 = y10.a.getUid();
        String s = y10.a.getPackageName();
        q0.k = new y1(v3, i0.a, i0.b, s, i0.c, i0.h, mediaSession$Token0);
        v0.d0();
    }

    @Override  // com.gaa.sdk.auth.b
    public void c(com.gaa.sdk.auth.e e0, Intent intent0) {
        y5.a.X("GaaSignInClientImpl", "Background login response code: " + e0.a + ", message: " + e0.b);
        ((Z8.b)this.b).a(e0);
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelectionUtil$AdaptiveTrackSelectionFactory
    public TrackSelection createAdaptiveTrackSelection(Definition trackSelection$Definition0) {
        return this.a == 21 ? Factory.a(((Factory)this.b), trackSelection$Definition0) : com.google.android.exoplayer2.trackselection.RandomTrackSelection.Factory.a(((com.google.android.exoplayer2.trackselection.RandomTrackSelection.Factory)this.b), trackSelection$Definition0);
    }

    @Override  // androidx.media3.session.e1
    public Object e(n0 n00, w0 w00, int v) {
        Object object0 = this.b;
        switch(this.a) {
            case 3: {
                return n00.o(w00, ((V)object0));
            }
            case 5: {
                return n00.t(w00, ((d0)object0));
            }
            case 6: {
                if(!n00.l()) {
                    ((c1)object0).f(n00.t, w00);
                    f1.J0(w00, v, new w1(0));
                }
                return x.b;
            }
            default: {
                w0 w01 = n00.F(w00);
                ((h0)n00.e).getClass();
                q.g(n00.k, "session");
                q.g(w01, "controller");
                LogU.debug$default(((h0)n00.e).h, "onSetRating() rating: " + ((T)object0), null, false, 6, null);
                return com.google.firebase.b.I(new w1(-6));
            }
        }
    }

    @Override  // androidx.media3.session.c1
    public void f(o1 o10, w0 w00) {
        ((e)this.b).accept(o10);
    }

    @Override  // y7.a
    public void g(y7.b b0) {
        if(this.a != 10) {
            d d0 = ((H7.m)(((K7.a)b0.get()))).a();
            ((Set)d0.i.d).add(((b7.b)this.b));
            Task task0 = ((I7.d)d0.i.a).b();
            task0.addOnSuccessListener(((Executor)d0.i.c), new c(d0.i, task0, ((b7.b)this.b), 2));
            if(Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Registering RemoteConfig Rollouts subscriber", null);
            }
            return;
        }
        b7.a a0 = (b7.a)this.b;
        a0.getClass();
        if(Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Crashlytics native component now available.", null);
        }
        b7.a a1 = (b7.a)b0.get();
        a0.b.set(a1);
    }

    @Override  // androidx.media3.session.D0
    public void h(v0 v00, int v) {
        if(this.a != 1) {
            v00.r(v, ((u1)this.b));
            return;
        }
        v00.i(v, ((Bundle)this.b));
    }

    @Override  // e.a
    public void onActivityResult(Object object0) {
        switch(this.a) {
            case 12: {
                ((we.k)((androidx.compose.runtime.b0)this.b).getValue()).invoke(object0);
                return;
            }
            case 17: {
                LoginFragment.l(((we.k)this.b), ((ActivityResult)object0));
                return;
            }
            default: {
                MusicMessageListFragment.l0(((MusicMessageListFragment)this.b), ((ActivityResult)object0));
            }
        }
    }

    @Override  // com.iloen.melon.utils.template.TemplateImageLoader$CaptureStateListener
    public void onCaptureComplete(Bitmap bitmap0) {
        PlaylistMixHolder.b(((U1)this.b), bitmap0);
    }

    @Override  // com.iloen.melon.custom.K
    public void onClick(View view0) {
        we.k k0 = ((NewChartFilterLayout)this.b).k;
        if(k0 != null) {
            q.d(view0);
            k0.invoke(view0);
        }
    }

    @Override  // com.facebook.gamingservices.cloudgaming.DaemonRequest$Callback
    public void onCompleted(GraphResponse graphResponse0) {
        switch(this.a) {
            case 13: {
                ContextChooseDialog.a(((ContextChooseDialog)this.b), graphResponse0);
                return;
            }
            case 14: {
                ContextCreateDialog.a(((ContextCreateDialog)this.b), graphResponse0);
                return;
            }
            default: {
                ContextSwitchDialog.a(((ContextSwitchDialog)this.b), graphResponse0);
            }
        }
    }

    @Override  // com.facebook.internal.ImageRequest$Callback
    public void onCompleted(ImageResponse imageResponse0) {
        ProfilePictureView.a(((ProfilePictureView)this.b), imageResponse0);
    }

    @Override  // com.facebook.login.LoginClient$OnCompletedListener
    public void onCompleted(Result loginClient$Result0) {
        LoginFragment.m(((LoginFragment)this.b), loginClient$Result0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        PresentSongSendFragment.p0(((PresentSongSendFragment)this.b), ((GiftListSongGiftBoxRes)object0));
    }

    @Override  // com.google.android.exoplayer2.extractor.BinarySearchSeeker$SeekTimestampConverter
    public long timeUsToTargetTime(long v) {
        return ((FlacStreamMetadata)this.b).getSampleNumber(v);
    }
}

