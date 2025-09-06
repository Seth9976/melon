package W;

import Ac.q0;
import B1.g;
import B1.i;
import B2.o;
import Gf.m;
import Na.e;
import Ze.y;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaController.TransportControls;
import android.media.session.PlaybackState;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.media3.session.legacy.E;
import androidx.media3.session.legacy.F;
import androidx.media3.session.legacy.G;
import androidx.media3.session.legacy.J;
import androidx.media3.session.legacy.K;
import androidx.media3.session.legacy.MediaDescriptionCompat;
import androidx.media3.session.legacy.MediaSessionCompat.Token;
import androidx.media3.session.legacy.PlaybackStateCompat;
import androidx.media3.session.legacy.b;
import coil.memory.MemoryCache.Key;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.iloen.melon.net.v4x.response.DjThemeListBoardRes;
import com.iloen.melon.net.v5x.response.DjThemeListLikeTagRes;
import d5.n;
import d5.v;
import e1.u;
import e1.x;
import hb.B;
import hb.C;
import i.n.i.b.a.s.e.V6;
import ie.j;
import ie.k;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kb.D;
import kotlin.jvm.internal.q;
import org.json.JSONObject;
import r5.a;
import r5.c;
import r5.d;
import r5.f;
import va.e0;

public final class p implements y, SuccessContinuation, f {
    public Object a;
    public Object b;

    public p(int v) {
        if(v != 8) {
            super();
            ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream(0x200);
            this.a = byteArrayOutputStream0;
            this.b = new DataOutputStream(byteArrayOutputStream0);
            return;
        }
        super();
        this.a = new AtomicInteger();
        this.b = new AtomicInteger();
    }

    public p(g g0, int v) {
        this.a = g0;
        String s = "start";
        if(v != -2) {
            switch(v) {
                case -1: {
                    s = "end";
                    break;
                }
                case 0: {
                    s = "left";
                    break;
                }
                default: {
                    if(v == 1) {
                        s = "right";
                    }
                    else {
                        Log.e("CCL", "verticalAnchorIndexToAnchorName: Unknown vertical index");
                    }
                }
            }
        }
        this.b = s;
    }

    public p(Context context0, MediaSessionCompat.Token mediaSessionCompat$Token0) {
        if(mediaSessionCompat$Token0 == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.b = Collections.synchronizedSet(new HashSet());
        if(Build.VERSION.SDK_INT >= 29) {
            this.a = new F(context0, mediaSessionCompat$Token0);  // 初始化器: Landroidx/media3/session/legacy/E;-><init>(Landroid/content/Context;Landroidx/media3/session/legacy/MediaSessionCompat$Token;)V
            return;
        }
        this.a = new E(context0, mediaSessionCompat$Token0);
    }

    public p(View view0) {
        this.a = view0;
        o o0 = new o(this, 27);
        this.b = d3.g.P(k.c, o0);
    }

    public p(Map map0) {
        this.b = map0;
        this.a = new m("Java nullability annotation states").c(new q0(this, 17));
    }

    public p(we.k k0) {
        this.a = k0;
        this.b = new ConcurrentHashMap();
    }

    @Override  // r5.f
    public a a(MemoryCache.Key memoryCache$Key0) {
        c c0 = (c)((d)this.b).get(memoryCache$Key0);
        return c0 == null ? null : new a(c0.a, c0.b);
    }

    @Override  // r5.f
    public void b(MemoryCache.Key memoryCache$Key0, Bitmap bitmap0, Map map0) {
        int v = x.E(bitmap0);
        d d0 = (d)this.b;
        if(v <= d0.maxSize()) {
            d0.put(memoryCache$Key0, new c(bitmap0, map0, v));
            return;
        }
        d0.remove(memoryCache$Key0);
        ((r5.g)this.a).g(memoryCache$Key0, bitmap0, map0, v);
    }

    public void c(Nf.p p0) {
        synchronized(p0) {
        }
        Handler handler0 = (Handler)this.a;
        if(handler0 != null) {
            handler0.post(new V6(this, p0, 1));
        }
    }

    @Override  // r5.f
    public void clearMemory() {
        ((d)this.b).evictAll();
    }

    public void d(MediaDescriptionCompat mediaDescriptionCompat0, int v) {
        E e0 = (E)this.a;
        if((e0.a.getFlags() & 4L) == 0L) {
            throw new UnsupportedOperationException("This session doesn\'t support queue management operations");
        }
        Bundle bundle0 = new Bundle();
        bundle0.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", androidx.media3.session.legacy.g.a(mediaDescriptionCompat0, android.support.v4.media.MediaDescriptionCompat.CREATOR));
        bundle0.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", v);
        e0.a.sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT", bundle0, null);
    }

    public Object e(oe.c c0) {
        B b0;
        if(c0 instanceof B) {
            b0 = (B)c0;
            int v = b0.B;
            if((v & 0x80000000) == 0) {
                b0 = new B(this, c0);
            }
            else {
                b0.B = v ^ 0x80000000;
            }
        }
        else {
            b0 = new B(this, c0);
        }
        Object object0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(object0);
                try {
                    b0.B = 1;
                    object0 = ((v)this.a).H(b0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((DjThemeListBoardRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Na.d(exception0);
    }

    public Object f(oe.c c0) {
        C c1;
        if(c0 instanceof C) {
            c1 = (C)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new C(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new C(this, c0);
        }
        Object object0 = c1.r;
        ne.a a0 = ne.a.a;
        switch(c1.B) {
            case 0: {
                n.D(object0);
                try {
                    v v1 = (v)this.a;
                    String s = u.w(((e0)(((mb.k)this.b))).j());
                    c1.B = 1;
                    object0 = v1.I(s, c1);
                    if(object0 == a0) {
                        return a0;
                    label_20:
                        n.D(object0);
                    }
                    return new e(((DjThemeListLikeTagRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_20;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new Na.d(exception0);
    }

    public InputMethodManager g() {
        return (InputMethodManager)((j)this.b).getValue();
    }

    public G h() {
        MediaController.PlaybackInfo mediaController$PlaybackInfo0 = ((E)this.a).a.getPlaybackInfo();
        return mediaController$PlaybackInfo0 == null ? null : new G(mediaController$PlaybackInfo0.getPlaybackType(), new b(new androidx.media3.session.legacy.a(mediaController$PlaybackInfo0.getAudioAttributes(), 0)), mediaController$PlaybackInfo0.getVolumeControl(), mediaController$PlaybackInfo0.getMaxVolume(), mediaController$PlaybackInfo0.getCurrentVolume());
    }

    public PlaybackStateCompat i() {
        E e0 = (E)this.a;
        androidx.media3.session.legacy.f f0 = e0.e.a();
        if(f0 != null) {
            try {
                return f0.getPlaybackState();
            }
            catch(RemoteException remoteException0) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", remoteException0);
            }
        }
        PlaybackState playbackState0 = e0.a.getPlaybackState();
        return playbackState0 == null ? null : PlaybackStateCompat.a(playbackState0);
    }

    public J j() {
        MediaController.TransportControls mediaController$TransportControls0 = ((E)this.a).a.getTransportControls();
        return Build.VERSION.SDK_INT >= 29 ? new K(mediaController$TransportControls0) : new J(mediaController$TransportControls0);  // 初始化器: Landroidx/media3/session/legacy/I;-><init>(Landroid/media/session/MediaController$TransportControls;)V / 初始化器: Landroidx/media3/session/legacy/I;-><init>(Landroid/media/session/MediaController$TransportControls;)V
    }

    public void k(x1.g g0, float f, float f1) {
        int v = g0.b;
        String s = "start";
        if(v != -2) {
            switch(v) {
                case -1: {
                    s = "end";
                    break;
                }
                case 0: {
                    s = "left";
                    break;
                }
                default: {
                    if(v == 1) {
                        s = "right";
                    }
                    else {
                        Log.e("CCL", "verticalAnchorIndexToAnchorName: Unknown vertical index");
                    }
                }
            }
        }
        B1.a a0 = new B1.a(new char[0]);  // 初始化器: LB1/b;-><init>([C)V
        a0.k(i.k(g0.a.toString()));
        a0.k(i.k(s));
        a0.k(new B1.e(f));
        a0.k(new B1.e(f1));
        ((g)this.a).A(((String)this.b), a0);
    }

    public static void l(p p0, x1.g g0, float f, int v) {
        if((v & 2) != 0) {
            f = 0.0f;
        }
        p0.k(g0, f, 0.0f);
    }

    public void m(MediaDescriptionCompat mediaDescriptionCompat0) {
        E e0 = (E)this.a;
        if((e0.a.getFlags() & 4L) == 0L) {
            throw new UnsupportedOperationException("This session doesn\'t support queue management operations");
        }
        Bundle bundle0 = new Bundle();
        bundle0.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", androidx.media3.session.legacy.g.a(mediaDescriptionCompat0, android.support.v4.media.MediaDescriptionCompat.CREATOR));
        e0.a.sendCommand("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM", bundle0, null);
    }

    public com.google.firebase.messaging.u n(qf.e e0, String s) {
        q.g(e0, "name");
        String s1 = e0.b();
        q.f(s1, "asString(...)");
        return new com.google.firebase.messaging.u(this, new jf.p(s1 + s));
    }

    @Override  // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object object0) {
        FileWriter fileWriter1;
        Void void0 = (Void)object0;
        A1.g g0 = (A1.g)this.b;
        JSONObject jSONObject0 = (JSONObject)((f7.d)this.a).c.a.submit(new H7.i(this, 5)).get();
        FileWriter fileWriter0 = null;
        if(jSONObject0 != null) {
            m7.a a0 = ((D)g0.c).o(jSONObject0);
            D d0 = (D)g0.e;
            long v = a0.c;
            d0.getClass();
            if(Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", "Writing settings to cache file...", null);
            }
            try {
                jSONObject0.put("expires_at", v);
                fileWriter1 = null;
                fileWriter1 = new FileWriter(((File)d0.b));
                goto label_17;
            }
            catch(Exception exception0) {
                goto label_21;
            }
            catch(Throwable throwable0) {
            }
            e7.f.b(fileWriter0, "Failed to close settings writer.");
            throw throwable0;
            try {
                try {
                label_17:
                    fileWriter1.write(jSONObject0.toString());
                    fileWriter1.flush();
                }
                catch(Exception exception0) {
                label_21:
                    Log.e("FirebaseCrashlytics", "Failed to cache settings", exception0);
                }
            }
            catch(Throwable throwable0) {
                fileWriter0 = fileWriter1;
                e7.f.b(fileWriter0, "Failed to close settings writer.");
                throw throwable0;
            }
            e7.f.b(fileWriter1, "Failed to close settings writer.");
            A1.g.e("Loaded settings: ", jSONObject0);
            String s = ((m7.c)g0.b).f;
            SharedPreferences.Editor sharedPreferences$Editor0 = ((Context)g0.a).getSharedPreferences("com.google.firebase.crashlytics", 0).edit();
            sharedPreferences$Editor0.putString("existing_instance_identifier", s);
            sharedPreferences$Editor0.apply();
            ((AtomicReference)g0.h).set(a0);
            ((TaskCompletionSource)((AtomicReference)g0.i).get()).trySetResult(a0);
            return Tasks.forResult(null);
        }
        return Tasks.forResult(null);
    }

    @Override  // r5.f
    public void trimMemory(int v) {
        if(v >= 40) {
            this.clearMemory();
            return;
        }
        if(10 <= v && v < 20) {
            d d0 = (d)this.b;
            d0.trimToSize(d0.size() / 2);
        }
    }
}

