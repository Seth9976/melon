package androidx.media3.session;

import D5.a;
import E9.m;
import I6.J;
import I6.V;
import M6.B;
import M6.H;
import M6.h;
import M6.u;
import M6.w;
import Nb.C;
import Nb.D;
import Nb.G;
import Nb.K;
import Nb.L;
import Nb.M;
import Nb.N;
import Nb.O;
import Nb.P;
import Nb.T;
import Nb.U;
import Nb.Y;
import Nb.h0;
import P0.c0;
import Pb.g;
import Pb.j;
import Pb.s;
import Tf.o;
import Tf.v;
import Vb.o0;
import W.p;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.session.MediaSession.Token;
import android.media.session.MediaSession;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import androidx.lifecycle.b;
import androidx.media3.session.legacy.PlaybackStateCompat;
import androidx.media3.session.legacy.Q;
import b3.E;
import b3.F;
import b3.S;
import b3.t;
import b3.y;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.fragments.settings.alarm.AlarmPermissionHelper.Companion;
import com.iloen.melon.fragments.settings.alarm.AlarmPermissionHelper;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.image.ImageUtils;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import e.k;
import e1.n;
import e3.x;
import ea.d;
import i.n.i.b.a.s.e.M3;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kc.i;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.guava.ListenableFutureKt;
import o8.c;
import ob.z;
import r8.f;
import va.e;

public final class n0 {
    public boolean A;
    public final V B;
    public final V C;
    public Bundle D;
    public final f0 E;
    public final e0 F;
    public final J G;
    public final J H;
    public final int I;
    public static final w1 J;
    public final Object a;
    public final Uri b;
    public final B0 c;
    public final m d;
    public final e0 e;
    public final Context f;
    public final f1 g;
    public final N0 h;
    public final String i;
    public final y1 j;
    public final f0 k;
    public final Handler l;
    public final d m;
    public final A0 n;
    public final Handler o;
    public final boolean p;
    public final boolean q;
    public final V r;
    public k1 s;
    public o1 t;
    public final PendingIntent u;
    public C0 v;
    public b w;
    public k0 x;
    public boolean y;
    public final long z;

    static {
        n0.J = new w1(1);
    }

    public n0(f0 f00, Context context0, S s0, PendingIntent pendingIntent0, V v0, V v1, V v2, e0 e00, Bundle bundle0, Bundle bundle1, d d0) {
        this.a = new Object();
        e3.b.u("MediaSessionImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.5.1] [" + x.e + "]");
        this.k = f00;
        this.f = context0;
        this.i = "";
        this.u = pendingIntent0;
        this.B = v0;
        this.C = v1;
        this.r = v2;
        this.e = e00;
        this.D = bundle1;
        this.m = d0;
        this.p = true;
        this.q = true;
        f1 f10 = new f1(this);
        this.g = f10;
        this.o = new Handler(Looper.getMainLooper());
        Looper looper0 = s0.getApplicationLooper();
        Handler handler0 = new Handler(looper0);
        this.l = handler0;
        this.s = k1.F;
        this.c = new B0(this, looper0);
        this.d = new m(this, looper0);
        Uri uri0 = new Uri.Builder().scheme("androidx.media3.session.n0").appendPath("").appendPath("17550908").build();
        this.b = uri0;
        N0 n00 = new N0(this, uri0, handler0, bundle0);
        this.h = n00;
        MediaSession.Token mediaSession$Token0 = (MediaSession.Token)((Q)n00.k.a).c.b;
        this.j = new y1(Process.myUid(), 1005001300, 4, "com.iloen.melon", f10, bundle0, mediaSession$Token0);
        o1 o10 = new o1(s0);  // 初始化器: Lb3/f;-><init>(Lb3/S;)V
        o10.e = v0;
        o10.f = v1;
        o10.g = u0.e;
        o10.h = u0.f;
        o10.d = bundle1;
        this.t = o10;
        x.P(handler0, new A3.m(21, this, o10));
        this.z = 3000L;
        this.n = new A0(this, 2);
        x.P(handler0, new A0(this, 3));
        this.E = f00;
        this.F = e00;
        this.I = 1;
        this.G = new J();
        this.H = new J();
    }

    public final B A(w0 w00, List list0, int v, long v1) {
        List list3;
        List list2;
        boolean z3;
        B b0;
        w0 w01 = this.F(w00);
        h0 h00 = (h0)this.e;
        h00.getClass();
        i i0 = h00.c;
        Service service0 = h00.a;
        CoroutineScope coroutineScope0 = h00.b;
        q.g(this.k, "session");
        q.g(w01, "controller");
        q.g(list0, "mediaItems");
        LogU.debug$default(h00.h, "onSetMediaItems() mediaItems: " + list0, null, false, 6, null);
        LogU.debug$default(h00.h, "onSetMediaItems() startIndex: " + v + ", startPositionMs: " + v1, null, false, 6, null);
        if(list0.isEmpty()) {
            Throwable throwable0 = new Throwable("MediaItem is empty");
            b0 = new w();  // 初始化器: Ljava/lang/Object;-><init>()V
            ((h)b0).l(throwable0);
        }
        else {
            String s = ((E)list0.get(0)).a;
            q.f(s, "mediaId");
            Uri uri0 = ((E)list0.get(0)).f.a;
            String s1 = ((E)list0.get(0)).f.b;
            Bundle bundle0 = ((E)list0.get(0)).f.c;
            if(s.length() == 0 && uri0 == null && (s1 == null || s1.length() == 0)) {
                Throwable throwable1 = new Throwable("no mediaId, no requestMetadata.mediaUri, no requestMetadata.searchQuery");
                b0 = new w();  // 初始化器: Ljava/lang/Object;-><init>()V
                ((h)b0).l(throwable1);
            }
            else if(uri0 != null) {
                z z0 = h00.d;
                Qb.z z1 = z0.e;
                if(q.b(Uri.EMPTY, uri0)) {
                    LogU.debug$default(h00.h, "playFromUri() uri is invalid", null, false, 6, null);
                }
                else {
                    String s2 = uri0.getAuthority();
                    String s3 = uri0.getHost();
                    String s4 = uri0.getPath();
                    String s5 = uri0.getSchemeSpecificPart();
                    StringBuilder stringBuilder0 = new StringBuilder("playFromUri() uri:");
                    stringBuilder0.append(uri0);
                    stringBuilder0.append(", a:");
                    stringBuilder0.append(s2);
                    stringBuilder0.append(", h:");
                    A7.d.u(stringBuilder0, s3, ", p:", s4, ", ssp:");
                    stringBuilder0.append(s5);
                    LogU.debug$default(h00.h, stringBuilder0.toString(), null, false, 6, null);
                    String s6 = e.b("playFromUri() ssp : ", uri0.getSchemeSpecificPart());
                    LogU.debug$default(h00.h, s6, null, false, 6, null);
                    int v2 = "melonappsvc".equalsIgnoreCase(uri0.getScheme()) ? f.c.match(uri0) : -1;
                    String s7 = e.b(" >> menuId: ", uri0.getQueryParameter("menuid"));
                    LogU.info$default(h00.h, s7, null, false, 6, null);
                    f.d(uri0);
                    ToastManager.debug(("MediaSession: " + uri0));
                    switch(v2) {
                        case 0x74: {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new Nb.S(h00, uri0, null), 3, null);
                            break;
                        }
                        case 0x8FD: {
                            LogU.debug$default(h00.h, "PLAY_CONTROL_PLAY", null, false, 6, null);
                            z0.u();
                            break;
                        }
                        case 0x8FE: {
                            LogU.debug$default(h00.h, "PLAY_CONTROL_PAUSE", null, false, 6, null);
                            z0.s();
                            break;
                        }
                        case 0x8FF: {
                            PlaylistId playlistId0 = ((com.melon.playlist.b)i0).t();
                            int v3 = playlistId0 == null ? 0 : !n.k(playlistId0);
                            if(v3 == 0) {
                                boolean z2 = q.b(uri0.getQueryParameter("forced"), "Y");
                                LogU.debug$default(h00.h, "PLAY_CONTROL_PREV : " + z2, null, false, 6, null);
                                z1.t(z2);
                            }
                            break;
                        }
                        case 0x900: {
                            PlaylistId playlistId1 = ((com.melon.playlist.b)i0).t();
                            int v4 = playlistId1 == null ? 0 : !n.k(playlistId1);
                            if(v4 == 0) {
                                LogU.debug$default(h00.h, "PLAY_CONTROL_NEXT", null, false, 6, null);
                                z1.q();
                            }
                            break;
                        }
                        case 0x901: {
                            LogU.debug$default(h00.h, "PLAY_CONTROL_MODE", null, false, 6, null);
                            Set set0 = uri0.getQueryParameterNames();
                            if(set0.contains("releaseRepeat") && "Y".equals(uri0.getQueryParameter("releaseRepeat"))) {
                                LogU.warn$default(h00.h, "PLAY_CONTROL / RELEASE_SECTIONREPEAT", null, false, 6, null);
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new T(h00, null), 3, null);
                            }
                            if(set0.contains("shuffle")) {
                                String s8 = uri0.getQueryParameter("shuffle");
                                if(s8 == null || s8.length() == 0) {
                                    LogU.warn$default(h00.h, "PLAY_CONTROL_MODE_SHUFFLE - no value", null, false, 6, null);
                                }
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new U(h00, s8, null), 3, null);
                            }
                            else if(set0.contains("repeat")) {
                                String s9 = uri0.getQueryParameter("repeat");
                                if(s9 == null || s9.length() == 0) {
                                    LogU.warn$default(h00.h, "PLAY_CONTROL_MODE_REPEAT - no value", null, false, 6, null);
                                }
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new Nb.V(h00, s9, null), 3, null);
                            }
                            break;
                        }
                        case 0x903: {
                            LogU.debug$default(h00.h, "PLAY_CONTROL_REPLAY", null, false, 6, null);
                            LogU.info$default(z1.h, "replay()", null, false, 6, null);
                            z1.f(new Qb.q(z1, null));
                            break;
                        }
                        case 3008: {
                            if(Companion.canScheduleExactAlarms$default(AlarmPermissionHelper.Companion, service0, null, null, 6, null)) {
                                String s10 = uri0.getQueryParameter("mode");
                                if("ON".equalsIgnoreCase(s10)) {
                                    int v5 = ProtocolUtils.parseInt(uri0.getQueryParameter("time"), -1);
                                    if(v5 > 0) {
                                        c.g(service0, v5, true);
                                    }
                                }
                                else if("OFF".equalsIgnoreCase(s10)) {
                                    c.g(service0, -1, false);
                                }
                            }
                            break;
                        }
                        case 9100: {
                            String s11 = uri0.getQueryParameter("ref");
                            LogU.debug$default(h00.h, "isNeedPocCheck() : " + s11, null, false, 6, null);
                            if(s11 == null) {
                                z3 = false;
                            }
                            else {
                                List list1 = k.z("W605");
                                Locale locale0 = Locale.getDefault();
                                q.f(locale0, "getDefault(...)");
                                String s12 = s11.toUpperCase(locale0);
                                q.f(s12, "toUpperCase(...)");
                                z3 = list1.contains(s12);
                            }
                            if(!z3) {
                                LogU.debug$default(h00.h, "no need for reference check : " + s11, null, false, 6, null);
                                h00.h(uri0);
                            }
                            else if("W605".equals(s11)) {
                                String s13 = uri0.getQueryParameter("appuserid");
                                if(s13 == null || s13.length() == 0) {
                                    LogU.debug$default(h00.h, "bixbyAppUserId is null", null, false, 6, null);
                                    h00.h(uri0);
                                }
                                else {
                                    LogU.debug$default(h00.h, "bixbyAppUserId : " + s13, null, false, 6, null);
                                    Nb.J j0 = new Nb.J(h00, s13, uri0, null);
                                    BuildersKt__Builders_commonKt.launch$default(h00.i, null, null, j0, 3, null);
                                }
                            }
                        }
                    }
                }
                b0 = com.google.firebase.b.H();
            }
            else if(s1 != null && s1.length() != 0) {
                P p0 = new P(bundle0, h00, s1, null);
                ListenableFutureKt.future$default(h00.i, null, null, p0, 3, null);
                b0 = com.google.firebase.b.H();
            }
            else if(v.r0(s, "[PLAY][HOME]", false)) {
                Pattern pattern0 = Pattern.compile("/");
                q.f(pattern0, "compile(...)");
                o.P0(0);
                Matcher matcher0 = pattern0.matcher(s);
                if(matcher0.find()) {
                    ArrayList arrayList0 = new ArrayList(10);
                    int v6 = 0;
                    do {
                        v6 = androidx.appcompat.app.o.c(matcher0, s, v6, arrayList0);
                    }
                    while(matcher0.find());
                    androidx.appcompat.app.o.w(v6, s, arrayList0);
                    list2 = arrayList0;
                }
                else {
                    list2 = k.z(s.toString());
                }
                ArrayList arrayList1 = E9.h.W(list2);
                LogU.debug$default(Nb.f.a, "getApiUrlForPlayHome() splits: " + arrayList1, null, false, 6, null);
                String s14 = URLDecoder.decode(((String)list2.get(1)), "utf-8");
                q.f(s14, "decode(...)");
                LogU.debug$default(h00.h, "onSetMediaItems() PLAY_HOME apiUrl: " + s14, null, false, 6, null);
                O o0 = new O(h00, s14, null);
                ListenableFutureKt.future$default(h00.i, null, null, o0, 3, null);
                b0 = com.google.firebase.b.H();
            }
            else if(v.r0(s, "[PLAY][DETAIL]", false)) {
                Pattern pattern1 = Pattern.compile("/");
                q.f(pattern1, "compile(...)");
                o.P0(0);
                Matcher matcher1 = pattern1.matcher(s);
                if(matcher1.find()) {
                    ArrayList arrayList2 = new ArrayList(10);
                    int v7 = 0;
                    do {
                        v7 = androidx.appcompat.app.o.c(matcher1, s, v7, arrayList2);
                    }
                    while(matcher1.find());
                    androidx.appcompat.app.o.w(v7, s, arrayList2);
                    list3 = arrayList2;
                }
                else {
                    list3 = k.z(s.toString());
                }
                ArrayList arrayList3 = E9.h.W(list3);
                LogU.debug$default(Nb.f.a, "getApiUrlForPlayDetail() splits: " + arrayList3, null, false, 6, null);
                String s15 = URLDecoder.decode(((String)list3.get(1)), "utf-8");
                q.f(s15, "decode(...)");
                LogU.debug$default(h00.h, "onSetMediaItems() PLAY_DETAIL apiUrl: " + s15, null, false, 6, null);
                N n0 = new N(h00, s15, null);
                ListenableFutureKt.future$default(h00.i, null, null, n0, 3, null);
                b0 = com.google.firebase.b.H();
            }
            else if(v.r0(s, "[PLAY][MIXUP]", false)) {
                LogU.debug$default(h00.h, "onSetMediaItems() PLAY_MIXUP", null, false, 6, null);
                L l0 = new L(h00, s, null);
                ListenableFutureKt.future$default(h00.i, null, null, l0, 3, null);
                b0 = com.google.firebase.b.H();
            }
            else if(v.r0(s, "[PLAY][PLAYLIST]", false)) {
                LogU.debug$default(h00.h, "onSetMediaItems() PLAY_PLAYLIST", null, false, 6, null);
                M m0 = new M(h00, s, null);
                b0 = ListenableFutureKt.future$default(h00.i, null, null, m0, 3, null);
            }
            else {
                if(v.r0(s, "[PLAY][DRAWER]", false)) {
                    LogU.debug$default(h00.h, "onSetMediaItems() PLAY_DRAWER", null, false, 6, null);
                    K k0 = new K(h00, s, null);
                    ListenableFutureKt.future$default(h00.i, null, null, k0, 3, null);
                }
                b0 = com.google.firebase.b.H();
            }
        }
        e3.b.h(b0, "Callback.onSetMediaItems must return a non-null future");
        return b0;
    }

    public final M6.x B(w0 w00, String s, b3.T t0) {
        w0 w01 = this.F(w00);
        ((h0)this.e).getClass();
        q.g(this.k, "session");
        q.g(w01, "controller");
        q.g(s, "mediaId");
        LogU.debug$default(((h0)this.e).h, "onSetRating() mediaId: " + s + ", rating: " + t0, null, false, 6, null);
        return com.google.firebase.b.I(new w1(-6));
    }

    public final M6.x C(w0 w00, String s, d0 d00) {
        w00.d.getClass();
        this.H.h(w00.d, s);
        this.G.h(s, w00);
        w0 w01 = this.F(w00);
        ((h0)this.F).getClass();
        q.g(this.E, "session");
        q.g(w01, "browser");
        q.g(s, "parentId");
        LogU.debug$default(((h0)this.F).h, "onSubscribe() parentId: " + s, null, false, 6, null);
        LogU.debug$default(((h0)this.F).h, "onSubscribe() params: " + d00, null, false, 6, null);
        M6.x x0 = com.google.firebase.b.I(new r(0, SystemClock.elapsedRealtime(), null, null, null, 1));
        x0.addListener(new a(9, s, this, x0, w00), new l0(this, 1));
        return x0;
    }

    public final M6.x D(w0 w00, String s) {
        w0 w01 = this.F(w00);
        ((h0)this.F).getClass();
        q.g(this.E, "session");
        q.g(w01, "browser");
        q.g(s, "parentId");
        LogU.debug$default(((h0)this.F).h, "onUnsubscribe() parentId: " + s, null, false, 6, null);
        M6.x x0 = com.google.firebase.b.I(new r(0, SystemClock.elapsedRealtime(), null, null, null, 1));
        x0.addListener(new I7.k(this, w00, s, 14), new l0(this, 0));
        return x0;
    }

    public final void E() {
        synchronized(F.class) {
        }
        e3.b.u("MediaSessionImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.5.1] [" + x.e + "] [" + "media3.common" + "]");
        synchronized(this.a) {
            if(this.y) {
                return;
            }
            this.y = true;
        }
        m m0 = this.d;
        I7.k k0 = (I7.k)m0.b;
        if(k0 != null) {
            m0.removeCallbacks(k0);
            m0.b = null;
        }
        this.l.removeCallbacksAndMessages(null);
        try {
            A0 a00 = new A0(this, 1);
            x.P(this.l, a00);
        }
        catch(Exception exception0) {
            e3.b.E("MediaSessionImpl", "Exception thrown while closing", exception0);
        }
        n0 n00 = this.h.g;
        androidx.media3.session.legacy.V v0 = this.h.k;
        androidx.appcompat.app.z z0 = this.h.l;
        if(z0 != null) {
            n00.f.unregisterReceiver(z0);
        }
        Q q0 = (Q)v0.a;
        MediaSession mediaSession0 = q0.a;
        q0.f.kill();
        if(Build.VERSION.SDK_INT == 27) {
            try {
                Field field0 = mediaSession0.getClass().getDeclaredField("mCallback");
                field0.setAccessible(true);
                Handler handler0 = (Handler)field0.get(mediaSession0);
                if(handler0 != null) {
                    handler0.removeCallbacksAndMessages(null);
                }
            }
            catch(Exception exception1) {
                Log.w("MediaSessionCompat", "Exception happened while accessing MediaSession.mCallback.", exception1);
            }
        }
        mediaSession0.setCallback(null);
        q0.b.a.set(null);
        mediaSession0.release();
        f1 f10 = this.g;
        for(Object object1: f10.c.k()) {
            v0 v00 = ((w0)object1).d;
            if(v00 != null) {
                try {
                    v00.d();
                }
                catch(RemoteException unused_ex) {
                }
            }
        }
        for(Object object2: f10.d) {
            v0 v01 = ((w0)object2).d;
            if(v01 != null) {
                try {
                    v01.d();
                }
                catch(RemoteException unused_ex) {
                }
            }
        }
    }

    public final w0 F(w0 w00) {
        if(this.A && n0.m(w00)) {
            w00 = this.g();
            w00.getClass();
        }
        return w00;
    }

    public final void G() {
        Handler handler0 = this.l;
        A0 a00 = this.n;
        handler0.removeCallbacks(a00);
        if(this.q) {
            long v = this.z;
            if(v > 0L && (this.t.isPlaying() || this.t.isLoading())) {
                handler0.postDelayed(a00, v);
            }
        }
    }

    public static Object H(Future future0) {
        e3.b.j(future0.isDone());
        try {
            return future0.get();
        }
        catch(CancellationException | ExecutionException | InterruptedException exception0) {
            e3.b.E("MediaSessionImpl", "Library operation failed", exception0);
            return null;
        }
    }

    public final void I() {
        if(Looper.myLooper() != this.l.getLooper()) {
            throw new IllegalStateException("Player callback method is called from a wrong thread. See javadoc of MediaSession for details.");
        }
    }

    public static void J(int v, r r0) {
        if(r0.a == 0) {
            V v1 = (V)r0.c;
            v1.getClass();
            if(v1.size() > v) {
                throw new IllegalStateException("Invalid size=" + v1.size() + ", pageSize=" + v);
            }
        }
    }

    public static void a(n0 n00, Runnable runnable0) {
        x.P(n00.l, runnable0);
    }

    public final boolean b(KeyEvent keyEvent0, boolean z) {
        androidx.media3.session.d d0;
        w0 w00 = this.k.a.g();
        w00.getClass();
        int v = keyEvent0.getKeyCode();
    alab1:
        switch(v) {
            case 0x4F: 
            case 85: {
                if(z) {
                    v = 87;
                }
            label_7:
                switch(v) {
                    case 85: {
                        d0 = this.t.getPlayWhenReady() ? new androidx.media3.session.d(this, w00, 6) : new androidx.media3.session.d(this, w00, 7);
                        break alab1;
                    }
                    case 86: {
                        d0 = new androidx.media3.session.d(this, w00, 5);
                        break alab1;
                    }
                    case 87: {
                        d0 = new androidx.media3.session.d(this, w00, 1);
                        break alab1;
                    }
                    case 88: {
                        d0 = new androidx.media3.session.d(this, w00, 2);
                        break alab1;
                    }
                    case 89: {
                        d0 = new androidx.media3.session.d(this, w00, 4);
                        break alab1;
                    }
                    case 90: {
                        d0 = new androidx.media3.session.d(this, w00, 3);
                        break alab1;
                    }
                    default: {
                        return false;
                    }
                }
            }
            case 0x7E: {
                d0 = new androidx.media3.session.d(this, w00, 8);
                break;
            }
            case 0x7F: {
                d0 = new androidx.media3.session.d(this, w00, 9);
                break;
            }
            case 0x110: {
                d0 = new androidx.media3.session.d(this, w00, 1);
                break;
            }
            case 273: {
                d0 = new androidx.media3.session.d(this, w00, 2);
                break;
            }
            default: {
                goto label_7;
            }
        }
        I7.k k0 = new I7.k(this, d0, w00, 16);
        x.P(this.l, k0);
        return true;
    }

    public final void c(w0 w00, D0 d00) {
        int v;
        f1 f10;
        try {
            f10 = this.g;
            c0 c00 = f10.c.n(w00);
            if(c00 != null) {
                v = c00.r();
                goto label_7;
            }
            else if(this.j(w00)) {
                v = 0;
            label_7:
                v0 v00 = w00.d;
                if(v00 != null) {
                    d00.h(v00, v);
                    return;
                }
            }
            return;
        }
        catch(DeadObjectException unused_ex) {
        }
        catch(RemoteException remoteException0) {
            e3.b.E("MediaSessionImpl", "Exception in " + w00.toString(), remoteException0);
            return;
        }
        f10.c.w(w00);
    }

    public final void d(D0 d00) {
        V v0 = this.g.c.k();
        for(int v1 = 0; v1 < v0.size(); ++v1) {
            this.c(((w0)v0.get(v1)), d00);
        }
        try {
            d00.h(this.h.i, 0);
        }
        catch(RemoteException remoteException0) {
            e3.b.q("MediaSessionImpl", "Exception in using media1 API", remoteException0);
        }
        k0 k00 = this.f();
        if(k00 != null) {
            try {
                d00.h(k00.m, 0);
            }
            catch(RemoteException remoteException1) {
                e3.b.q("MediaSessionImpl", "Exception in using media1 API", remoteException1);
            }
        }
    }

    public final ArrayList e() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.addAll(this.g.c.k());
        N0 n00 = this.h;
        if(this.A) {
            V v0 = n00.f.k();
            for(int v1 = 0; v1 < v0.size(); ++v1) {
                w0 w00 = (w0)v0.get(v1);
                if(!n0.m(w00)) {
                    arrayList0.add(w00);
                }
            }
        }
        else {
            arrayList0.addAll(n00.f.k());
        }
        k0 k00 = this.f();
        if(k00 != null) {
            arrayList0.addAll(k00.l.k());
        }
        return arrayList0;
    }

    public final k0 f() {
        synchronized(this.a) {
        }
        return this.x;
    }

    public final w0 g() {
        V v0 = this.g.c.k();
        for(int v1 = 0; v1 < v0.size(); ++v1) {
            w0 w00 = (w0)v0.get(v1);
            if(this.k(w00)) {
                return w00;
            }
        }
        return null;
    }

    public final void h(b3.N n0) {
        this.c.a(false, false);
        this.d(new Z(n0));
        try {
            this.h.i.h();
        }
        catch(RemoteException remoteException0) {
            e3.b.q("MediaSessionImpl", "Exception in using media1 API", remoteException0);
        }
    }

    public final void i(w0 w00, boolean z) {
        if(this.v()) {
            boolean z1 = this.t.Y(16) && this.t.W() != null;
            boolean z2 = this.t.Y(0x1F) || this.t.Y(20);
            w0 w01 = this.F(w00);
            SparseBooleanArray sparseBooleanArray0 = new SparseBooleanArray();
            e3.b.j(((boolean)1));
            sparseBooleanArray0.append(1, true);
            e3.b.j(((boolean)1));
            b3.N n0 = new b3.N(new b3.m(sparseBooleanArray0));
            if(!z1 && z2) {
                B b0 = ((h0)this.e).g(this.k, w01);
                e3.b.h(b0, "Callback.onPlaybackResumption must return a non-null future");
                J0.h h0 = new J0.h(this, w01, z, n0);
                l0 l00 = new l0(this, 2);
                b0.addListener(new u(0, b0, h0), l00);
                return;
            }
            if(!z1) {
                e3.b.D("MediaSessionImpl", "Play requested without current MediaItem, but playback resumption prevented by missing available commands");
            }
            x.E(this.t);
            if(z) {
                this.x(w01);
            }
        }
    }

    public final boolean j(w0 w00) {
        if(!this.g.c.s(w00) && !this.h.f.s(w00)) {
            k0 k00 = this.f();
            return k00 != null && k00.l.s(w00);
        }
        return true;
    }

    // 去混淆评级： 低(20)
    public final boolean k(w0 w00) {
        return Objects.equals(w00.a(), "com.iloen.melon") && w00.b != 0 && new Bundle(w00.e).getBoolean("androidx.media3.session.MediaNotificationManager", false);
    }

    public final boolean l() {
        synchronized(this.a) {
        }
        return this.y;
    }

    public static boolean m(w0 w00) {
        return w00 != null && w00.b == 0 && Objects.equals(w00.a(), "com.android.systemui");
    }

    public final void n(w0 w00, r r0) {
        int v = r0.a;
        int v1 = this.I;
        if(v1 != 0 && w00.b == 0) {
            o1 o10 = this.t;
            d0 d00 = r0.e;
            u1 u10 = r0.f;
            N0 n00 = this.h;
            if(v == -105 || v == -102) {
                int v2 = androidx.media3.session.q.h(v);
                if(o10.c == null || o10.c.c != v2) {
                    String s = u10 == null ? "no error message provided" : u10.b;
                    Bundle bundle0 = Bundle.EMPTY;
                    if(d00 == null) {
                    label_17:
                        if(u10 != null) {
                            bundle0 = u10.c;
                        }
                    }
                    else {
                        Bundle bundle1 = d00.a;
                        if(bundle1.containsKey("android.media.extras.ERROR_RESOLUTION_ACTION_INTENT")) {
                            bundle0 = bundle1;
                            goto label_19;
                        }
                        goto label_17;
                    }
                label_19:
                    o10.c = new A6.i(v1 == 1, v2, s, bundle0);
                    PlaybackStateCompat playbackStateCompat0 = o10.k0();
                    n00.k.w(playbackStateCompat0);
                    return;
                }
            }
            if(v == 0) {
                o1 o11 = this.t;
                if(o11.c != null) {
                    o11.c = null;
                    PlaybackStateCompat playbackStateCompat1 = o11.k0();
                    n00.k.w(playbackStateCompat1);
                }
            }
        }
    }

    public final B o(w0 w00, List list0) {
        w0 w01 = this.F(w00);
        ((h0)this.e).getClass();
        q.g(this.k, "session");
        q.g(w01, "controller");
        q.g(list0, "mediaItems");
        LogU.debug$default(((h0)this.e).h, "onAddMediaItems() mediaItems: " + list0, null, false, 6, null);
        for(Object object0: list0) {
            if(((E)object0).b == null) {
                UnsupportedOperationException unsupportedOperationException0 = new UnsupportedOperationException();
                B b0 = new w();  // 初始化器: Ljava/lang/Object;-><init>()V
                ((h)b0).l(unsupportedOperationException0);
                return b0;
            }
            if(false) {
                break;
            }
        }
        return com.google.firebase.b.I(list0);
    }

    public final u0 p(w0 w00) {
        V v0 = null;
        if(this.A && n0.m(w00)) {
            t1 t10 = this.t.g;
            t10.getClass();
            b3.N n0 = this.t.h;
            n0.getClass();
            V v1 = this.t.e;
            V v2 = v1 == null ? null : V.p(v1);
            V v3 = this.t.f;
            if(v3 != null) {
                v0 = V.p(v3);
            }
            return new u0(t10, n0, v2, v0);
        }
        h0 h00 = (h0)this.e;
        h00.getClass();
        q.g(this.k, "session");
        n0 n00 = this.k.a;
        Nb.q q0 = new Nb.q(this.k, w00, h00, 1);
        boolean z = false;
        LogConstantsKt.buildDebug$default(h00.h, false, q0, 1, null);
        if(this.k.b(w00)) {
            G g0 = new G(h00, null);
            BuildersKt__Builders_commonKt.launch$default(h00.i, null, null, g0, 3, null);
        }
        b3.N n1 = u0.f;
        t1 t11 = h00.m;
        t11.getClass();
        V v4 = V.p(je.w.a);
        u0 u00 = new u0(t11, n1, v4, null);
        if(this.k(w00)) {
            this.A = true;
            o1 o10 = this.t;
            if(v4 == null) {
                v4 = n00.B;
            }
            o10.e = v4;
            o10.f = n00.C;
            if(o10.h.a(17) != n1.a(17)) {
                z = true;
            }
            o1 o11 = this.t;
            o11.g = t11;
            o11.h = n1;
            N0 n01 = this.h;
            if(z) {
                I0 i00 = new I0(n01, o11, 1);
                x.P(n01.g.l, i00);
                return u00;
            }
            n01.L(o11);
        }
        return u00;
    }

    public final B q(w0 w00, s1 s10, Bundle bundle0) {
        B b0;
        Object object1;
        Object object0 = null;
        w0 w01 = this.F(w00);
        h0 h00 = (h0)this.e;
        h00.getClass();
        CoroutineScope coroutineScope0 = h00.b;
        f0 f00 = this.k;
        q.g(f00, "session");
        q.g(w01, "controller");
        q.g(bundle0, "args");
        LogU.debug$default(h00.h, "onCustomCommand() customCommand: " + s10, null, false, 6, null);
        LogU.debug$default(h00.h, "onCustomCommand() args: " + bundle0, null, false, 6, null);
        Pb.f.a.getClass();
        Iterator iterator0 = Pb.e.b.iterator();
        while(true) {
            object1 = null;
            if(!iterator0.hasNext()) {
                break;
            }
            Object object2 = iterator0.next();
            if(q.b(((Pb.f)object2).getAction(), s10.b)) {
                object0 = object2;
                break;
            }
        }
        String s = ((Pb.f)object0) == null ? null : Cb.i.o(((Pb.f)object0));
        LogU.info$default(h00.h, "onCustomCommand() command: " + s, null, false, 6, null);
        if(((Pb.f)object0) == null) {
            b0 = com.google.firebase.b.I(new w1(-6));
        }
        else {
            LogU logU0 = h00.h;
            LogU.debug$default(logU0, "handleCustomCommand() customCommand: " + ((Pb.f)object0), null, false, 6, null);
            if(((Pb.f)object0) instanceof j) {
                LogConstantsKt.infoOnlyDebugMode(logU0, "handleMelonPlayerCommand() " + Cb.i.o(((j)(((Pb.f)object0)))));
                S s1 = f00.a();
                n0 n00 = f00.a;
                o0 o00 = s1 instanceof o0 ? ((o0)s1) : null;
                if(o00 == null) {
                    b0 = com.google.firebase.b.I(new w1(-6));
                }
                else if(((j)(((Pb.f)object0))) instanceof g) {
                    LogConstantsKt.infoOnlyDebugMode(o00.e1(), "acquireAndPlay()");
                    E e0 = o00.W();
                    if(e0 == null) {
                        LogU.warn$default(o00.e1(), "acquireAndPlay() currentMediaItem is null.", null, false, 6, null);
                    }
                    else {
                        Bundle bundle1 = e0.d.I;
                        if(bundle1 != null) {
                            bundle1.putBoolean("acquireOwnership", true);
                        }
                        o00.prepare();
                        o00.setPlayWhenReady(true);
                    }
                    b0 = com.google.firebase.b.I(new w1(0));
                    e3.b.h(b0, "Callback.onCustomCommandOnHandler must return non-null future");
                    return b0;
                }
                else if(((j)(((Pb.f)object0))) instanceof Pb.i) {
                    o00.o1();
                    b0 = com.google.firebase.b.I(new w1(0));
                }
                else {
                    if(!(((j)(((Pb.f)object0))) instanceof Pb.h)) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    for(Object object3: n00.e()) {
                        if(f00.b(((w0)object3))) {
                            object1 = object3;
                            break;
                        }
                        if(false) {
                            break;
                        }
                    }
                    if(((w0)object1) != null) {
                        int v = ((w0)object1).b;
                        u1 u10 = new u1(-104, "중복 스트리밍 알림");
                        if(v == 0 || ((w0)object1).c >= 4) {
                            if(n00.k(((w0)object1)) || v == 0) {
                                try {
                                    n00.h.i.r(0, u10);
                                }
                                catch(RemoteException remoteException0) {
                                    e3.b.q("MediaSessionImpl", "Exception in using media1 API", remoteException0);
                                }
                            }
                            else {
                                n00.c(((w0)object1), new a0(u10, 2));
                            }
                        }
                    }
                    b0 = com.google.firebase.b.I(new w1(0));
                }
            }
            else if(((Pb.f)object0) instanceof Pb.k) {
                Mc.q q0 = h00.n;
                LogConstantsKt.infoOnlyDebugMode(logU0, "handleMelonPlayerCommand() " + Cb.i.o(((Pb.k)(((Pb.f)object0)))));
                if(((Pb.k)(((Pb.f)object0))) instanceof Pb.o) {
                    b0 = ye.a.B(coroutineScope0, q0, new Nb.B(((Pb.k)(((Pb.f)object0))), h00, null), 3);
                }
                else if(((Pb.k)(((Pb.f)object0))) instanceof s) {
                    b0 = ye.a.B(coroutineScope0, q0, new C(((Pb.k)(((Pb.f)object0))), h00, null), 3);
                }
                else {
                    if(!(((Pb.k)(((Pb.f)object0))) instanceof Pb.d)) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    S s2 = f00.a();
                    o0 o01 = s2 instanceof o0 ? ((o0)s2) : null;
                    if(o01 == null) {
                        b0 = com.google.firebase.b.I(new w1(-6));
                    }
                    else if(((Pb.d)(((Pb.k)(((Pb.f)object0))))) instanceof Pb.b) {
                        b0 = ye.a.B(coroutineScope0, q0, new D(((Pb.k)(((Pb.f)object0))), bundle0, o01, null), 3);
                    }
                    else if(((Pb.d)(((Pb.k)(((Pb.f)object0))))) instanceof Pb.c) {
                        b0 = ye.a.B(coroutineScope0, q0, new Nb.E(((Pb.k)(((Pb.f)object0))), bundle0, o01, null), 3);
                    }
                    else {
                        if(!(((Pb.d)(((Pb.k)(((Pb.f)object0))))) instanceof Pb.a)) {
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                        b0 = ye.a.B(coroutineScope0, q0, new Nb.F(o01, ((Pb.k)(((Pb.f)object0))), null), 3);
                    }
                }
            }
            else {
                b0 = com.google.firebase.b.I(new w1(-6));
            }
        }
        e3.b.h(b0, "Callback.onCustomCommandOnHandler must return non-null future");
        return b0;
    }

    public final B r(w0 w00, String s, int v, int v1, d0 d00) {
        B b2;
        w0 w01;
        boolean z = Objects.equals(s, "androidx.media3.session.recent.root");
        f0 f00 = this.E;
        e0 e00 = this.F;
        if(z) {
            if(this.h.m != null) {
                if(this.t.getPlaybackState() == 1) {
                    B b0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                    if(this.A) {
                        w01 = this.g();
                        w01.getClass();
                    }
                    else {
                        w01 = w00;
                    }
                    B b1 = ((h0)e00).g(f00, w01);
                    b1.addListener(new u(0, b1, new x9.b(b0, d00)), M6.s.a);
                    return b0;
                }
                t t0 = new t();
                b3.x x0 = new b3.x();
                androidx.media3.common.c c0 = new androidx.media3.common.c();
                c0.q = Boolean.FALSE;
                c0.r = Boolean.TRUE;
                b3.G g0 = new b3.G(c0);
                return com.google.firebase.b.I(r.c(V.t(new E("androidx.media3.session.recent.item", new b3.v(t0), null, new y(x0), g0, b3.B.d)), d00));  // 初始化器: Lb3/u;-><init>(Lb3/t;)V
            }
            return com.google.firebase.b.I(r.b(-6));
        }
        w0 w02 = this.F(w00);
        h0 h00 = (h0)e00;
        h00.getClass();
        q.g(f00, "session");
        q.g(w02, "browser");
        q.g(s, "parentId");
        StringBuilder stringBuilder0 = androidx.appcompat.app.o.u(v, "onGetChildren() parentId: ", s, ", page: ", ", pageSize: ");
        stringBuilder0.append(v1);
        LogU.debug$default(h00.h, stringBuilder0.toString(), null, false, 6, null);
        LogU.debug$default(h00.h, "onGetChildren() params: " + d00, null, false, 6, null);
        if("[ROOT_ID]".equals(s)) {
            LogU.debug$default(h00.h, "getRoot()", null, false, 6, null);
            ArrayList arrayList0 = new ArrayList();
            q.f("홈", "getString(...)");
            arrayList0.add(Nb.f.a("홈", "[TAB][HOME]", false, true, 20, null, ImageUtils.getResourceUri(0x7F080434), 0x17E0));  // drawable:ic_etc_auto_tabbar_home
            q.f("재생목록", "getString(...)");
            arrayList0.add(Nb.f.a("재생목록", "[TAB][PLAYLIST]", false, true, 24, null, ImageUtils.getResourceUri(0x7F080436), 0x17E0));  // drawable:ic_etc_auto_tabbar_playlist
            if(((va.e0)va.o.a()).m()) {
                q.f("음악서랍", "getString(...)");
                arrayList0.add(Nb.f.a("음악서랍", "[TAB][DRAWER]", false, true, 20, null, ImageUtils.getResourceUri(0x7F080435), 0x17E0));  // drawable:ic_etc_auto_tabbar_library
            }
            b2 = com.google.firebase.b.I(r.c(arrayList0, d00));
        }
        else if("[TAB][HOME]".equals(s)) {
            LogU.debug$default(h00.h, "getHome()", null, false, 6, null);
            Nb.u u0 = new Nb.u(h00, d00, null);
            b2 = ListenableFutureKt.future$default(h00.i, null, null, u0, 3, null);
        }
        else if("[TAB][PLAYLIST]".equals(s)) {
            LogU.debug$default(h00.h, "getPlaylist()", null, false, 6, null);
            Nb.y y0 = new Nb.y(h00, d00, null);
            b2 = ListenableFutureKt.future$default(h00.i, null, null, y0, 3, null);
        }
        else if("[TAB][DRAWER]".equals(s)) {
            LogU.debug$default(h00.h, "getDrawer()", null, false, 6, null);
            Nb.t t1 = new Nb.t(h00, d00, null);
            b2 = ListenableFutureKt.future$default(h00.i, null, null, t1, 3, null);
        }
        else if(v.r0(s, "[LIST][HOME]", false)) {
            LogU.debug$default(h00.h, "getListForHome() parentId: " + s, null, false, 6, null);
            Nb.w w0 = new Nb.w(s, h00, d00, null);
            b2 = ListenableFutureKt.future$default(h00.i, null, null, w0, 3, null);
        }
        else if(v.r0(s, "[LIST][MIXUP]", false)) {
            LogU.debug$default(h00.h, "getListForMixup() parentId: " + s, null, false, 6, null);
            Nb.x x1 = new Nb.x(s, h00, d00, null);
            b2 = ListenableFutureKt.future$default(h00.i, null, null, x1, 3, null);
        }
        else if(v.r0(s, "[LIST][DRAWER]", false)) {
            LogU.debug$default(h00.h, "getListForDrawer() parentId: " + s, null, false, 6, null);
            Nb.v v2 = new Nb.v(s, h00, d00, null);
            b2 = ListenableFutureKt.future$default(h00.i, null, null, v2, 3, null);
        }
        else {
            b2 = com.google.firebase.b.I(r.b(-6));
        }
        b2.addListener(new Kc.g(this, b2, w00, v1, 2), new l0(this, 0));
        return b2;
    }

    public final M6.x s(w0 w00, String s) {
        w0 w01 = this.F(w00);
        ((h0)this.F).getClass();
        q.g(this.E, "session");
        q.g(w01, "browser");
        q.g(s, "mediaId");
        LogU.debug$default(((h0)this.F).h, "onGetItem() mediaId: " + s, null, false, 6, null);
        M6.x x0 = com.google.firebase.b.I(r.b(-6));
        x0.addListener(new m0(this, x0, w00, 0), new l0(this, 0));
        return x0;
    }

    public final M6.x t(w0 w00, d0 d00) {
        if(d00 != null && d00.b && n0.m(w00)) {
            if(this.h.m != null) {
                t t0 = new t();
                b3.x x0 = new b3.x();
                androidx.media3.common.c c0 = new androidx.media3.common.c();
                c0.q = Boolean.TRUE;
                c0.r = Boolean.FALSE;
                b3.G g0 = new b3.G(c0);
                E e0 = new E("androidx.media3.session.recent.root", new b3.v(t0), null, new y(x0), g0, b3.B.d);  // 初始化器: Lb3/u;-><init>(Lb3/t;)V
                r.d(e0);
                return com.google.firebase.b.I(new r(0, SystemClock.elapsedRealtime(), d00, null, e0, 2));
            }
            return com.google.firebase.b.I(r.b(-6));
        }
        w0 w01 = this.F(w00);
        ((h0)this.F).getClass();
        q.g(this.E, "session");
        q.g(w01, "browser");
        LogU.debug$default(((h0)this.F).h, "onGetLibraryRoot()", null, false, 6, null);
        E e1 = Nb.f.a("ROOT", "[ROOT_ID]", false, true, 20, null, null, 0x1FE0);
        r.d(e1);
        return com.google.firebase.b.I(new r(0, SystemClock.elapsedRealtime(), ((h0)this.F).j, null, e1, 2));
    }

    public final boolean u(w0 w00, Intent intent0) {
        boolean z1;
        String s;
        Bundle bundle0 = intent0.getExtras();
        I7.k k0 = null;
        KeyEvent keyEvent0 = bundle0 == null || !bundle0.containsKey("android.intent.extra.KEY_EVENT") ? null : ((KeyEvent)bundle0.getParcelable("android.intent.extra.KEY_EVENT"));
        ComponentName componentName0 = intent0.getComponent();
        if(Objects.equals(intent0.getAction(), "android.intent.action.MEDIA_BUTTON")) {
            Context context0 = this.f;
            if((componentName0 == null || Objects.equals(componentName0.getPackageName(), "com.iloen.melon")) && keyEvent0 != null && keyEvent0.getAction() == 0) {
                this.I();
                h0 h00 = (h0)this.e;
                h00.getClass();
                f0 f00 = this.k;
                q.g(f00, "session");
                int v = w00.b;
                KeyEvent keyEvent1 = (KeyEvent)U4.F.w(intent0, "android.intent.extra.KEY_EVENT", KeyEvent.class);
                if(keyEvent1 == null) {
                    s = "Unknown";
                }
                else {
                    s = KeyEvent.keyCodeToString(keyEvent1.getKeyCode());
                    if(s == null) {
                        s = "Unknown";
                    }
                }
                jc.j.c(("onMediaButtonEvent() " + s + ", " + w00.a()));
                Mc.y y0 = new Mc.y(keyEvent1, h00, w00, f00);
                LogConstantsKt.buildDebug$default(h00.h, false, y0, 1, null);
                MelonAppBase.Companion.getClass();
                if(MelonSettingInfo.isBlockedAutoPlayByExternal(k8.t.a().getContext()) && f00.a().getCurrentTimeline().p() && (keyEvent1 != null && keyEvent1.getKeyCode() == 0x7E || keyEvent1 != null && keyEvent1.getKeyCode() == 85) && (!q.b(w00.a(), "com.iloen.melon") || f00.b(w00) || f00.a.k(w00))) {
                    LogU.debug$default(h00.h, "need to stop process: BT 자동실행 중지, ", null, false, 6, null);
                    return true;
                }
                int v1 = keyEvent0.getKeyCode();
                boolean z = context0.getPackageManager().hasSystemFeature("android.software.leanback");
                m m0 = this.d;
                if(v1 != 0x4F && v1 != 85) {
                    I7.k k1 = (I7.k)m0.b;
                    if(k1 != null) {
                        m0.removeCallbacks(k1);
                        I7.k k2 = (I7.k)m0.b;
                        m0.b = null;
                        k0 = k2;
                    }
                    if(k0 != null) {
                        x.P(m0, k0);
                    }
                    z1 = false;
                }
                else if(z || v != 0 || keyEvent0.getRepeatCount() != 0) {
                    I7.k k5 = (I7.k)m0.b;
                    if(k5 != null) {
                        m0.removeCallbacks(k5);
                        I7.k k6 = (I7.k)m0.b;
                        m0.b = null;
                        k0 = k6;
                    }
                    if(k0 != null) {
                        x.P(m0, k0);
                    }
                    z1 = false;
                }
                else {
                    I7.k k3 = (I7.k)m0.b;
                    if(k3 != null) {
                        m0.removeCallbacks(k3);
                        m0.b = null;
                        z1 = true;
                        goto label_61;
                    }
                    I7.k k4 = new I7.k(m0, w00, keyEvent0, 17);
                    m0.b = k4;
                    m0.postDelayed(k4, 300L);
                    return true;
                }
            label_61:
                if(this.A) {
                    return this.b(keyEvent0, z1);
                }
                N0 n00 = this.h;
                if((v1 == 0x4F || v1 == 85) && z1) {
                    n00.y();
                    return true;
                }
                if(v != 0) {
                    ((androidx.media3.session.legacy.E)((p)n00.k.b).a).a.dispatchMediaButtonEvent(keyEvent0);
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean v() {
        if(Looper.myLooper() != Looper.getMainLooper()) {
            H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
            A3.m m0 = new A3.m(20, this, h0);
            this.o.post(m0);
            try {
                return ((Boolean)h0.get()).booleanValue();
            }
            catch(InterruptedException | ExecutionException interruptedException0) {
                throw new IllegalStateException(interruptedException0);
            }
        }
        b b0 = this.w;
        if(b0 != null) {
            MediaSessionService mediaSessionService0 = (MediaSessionService)b0.b;
        }
        return true;
    }

    public final void w(w0 w00, int v) {
        w0 w01 = this.F(w00);
        ((h0)this.e).getClass();
        q.g(this.k, "session");
        q.g(w01, "controller");
        jc.j.c(("onPlayerCommandRequest() " + U4.F.Z(v) + ", " + w01.a()));
        C8.e e0 = new C8.e(v, ((h0)this.e), this.k, w01);
        LogConstantsKt.buildDebug$default(((h0)this.e).h, false, e0, 1, null);
    }

    public final void x(w0 w00) {
        this.F(w00);
        this.e.getClass();
    }

    public final void y(w0 w00) {
        if(this.A && n0.m(w00)) {
            return;
        }
        h0 h00 = (h0)this.e;
        h00.getClass();
        CoroutineScope coroutineScope0 = h00.b;
        f0 f00 = this.k;
        q.g(f00, "session");
        LogU.debug$default(h00.h, "onPostConnect()", null, false, 6, null);
        LogU.debug$default(h00.h, "startCollectLogin", null, false, 6, null);
        Job job0 = h00.k;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        h00.k = BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new Y(h00, f00, null), 3, null);
        LogU.debug$default(h00.h, "startCollectMelonPlaylist", null, false, 6, null);
        Job job1 = h00.l;
        if(job1 != null) {
            DefaultImpls.cancel$default(job1, null, 1, null);
        }
        h00.l = BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new Nb.f0(h00, f00, null), 3, null);
    }

    public final M6.x z(w0 w00, String s, d0 d00) {
        w0 w01 = this.F(w00);
        ((h0)this.F).getClass();
        q.g(this.E, "session");
        q.g(w01, "browser");
        q.g(s, "query");
        LogU.debug$default(((h0)this.F).h, "onSearch() query: " + s, null, false, 6, null);
        LogU.debug$default(((h0)this.F).h, "onSearch() params: " + d00, null, false, 6, null);
        M6.x x0 = com.google.firebase.b.I(r.b(-6));
        x0.addListener(new m0(this, x0, w00, 1), new l0(this, 0));
        return x0;
    }
}

