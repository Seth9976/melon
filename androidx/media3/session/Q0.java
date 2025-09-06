package androidx.media3.session;

import A6.i;
import I6.N;
import I6.Q;
import I6.V;
import I6.p0;
import I6.w;
import M6.B;
import M6.u;
import N1.m;
import W5.e;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.graphics.drawable.IconCompat;
import androidx.media3.session.legacy.b0;
import b3.G;
import b3.S;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest.Callback;
import com.facebook.internal.ImageRequest;
import e3.x;
import ea.d;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public final class q0 implements Runnable {
    public final int a;
    public final boolean b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;

    public q0(int v, Object object0, Object object1, Object object2, Object object3, boolean z) {
        this.a = v;
        this.c = object0;
        this.d = object1;
        this.e = object2;
        this.f = object3;
        this.b = z;
        super();
    }

    public q0(ImageRequest imageRequest0, Exception exception0, boolean z, Bitmap bitmap0, Callback imageRequest$Callback0) {
        this.a = 2;
        super();
        this.c = imageRequest0;
        this.d = exception0;
        this.b = z;
        this.e = bitmap0;
        this.f = imageRequest$Callback0;
    }

    @Override
    public final void run() {
        int v17;
        DefaultMediaNotificationProvider defaultMediaNotificationProvider2;
        B b4;
        n0 n02;
        int[] arr_v3;
        int[] arr_v2;
        g1 g11;
        S s2;
        n0 n01;
        DefaultMediaNotificationProvider defaultMediaNotificationProvider1;
        int v5;
        e e2;
        switch(this.a) {
            case 0: {
                t0 t00 = (t0)this.c;
                y0 y00 = (y0)this.d;
                V v0 = (V)this.e;
                e e0 = (e)this.f;
                T3.e e1 = t00.c;
                DefaultMediaNotificationProvider defaultMediaNotificationProvider0 = (DefaultMediaNotificationProvider)t00.b;
                Context context0 = defaultMediaNotificationProvider0.a;
                String s = defaultMediaNotificationProvider0.c;
                NotificationManager notificationManager0 = defaultMediaNotificationProvider0.e;
                if(notificationManager0.getNotificationChannel(s) == null) {
                    notificationManager0.createNotificationChannel(new NotificationChannel(s, context0.getString(defaultMediaNotificationProvider0.d), 2));
                }
                w.c(4, "initialCapacity");
                Object[] arr_object = new Object[4];
                int v2 = 0;
                for(int v1 = 0; v1 < v0.size(); ++v1) {
                    b b0 = (b)v0.get(v1);
                    if(b0.a != null && b0.a.a == 0 && b0.i) {
                        b b1 = (b)v0.get(v1);
                        b1.getClass();
                        int v3 = N.f(arr_object.length, v2 + 1);
                        if(v3 > arr_object.length) {
                            arr_object = Arrays.copyOf(arr_object, v3);
                        }
                        arr_object[v2] = b1;
                        ++v2;
                    }
                }
                S s1 = y00.a();
                n0 n00 = y00.a;
                NotificationCompat.Builder notificationCompat$Builder0 = new NotificationCompat.Builder(context0, s);
                int v4 = defaultMediaNotificationProvider0.b.a == 1 ? 1001 : 101;
                g1 g10 = new g1(y00);
                b3.N n0 = s1.y();
                p0 p00 = V.l(v2, arr_object);
                boolean z = x.V(s1, n00.p);
                Q q0 = new Q(4);  // 初始化器: LI6/N;-><init>(I)V
                if(n0.a.a(new int[]{7, 6})) {
                    Bundle bundle0 = new Bundle();
                    bundle0.putInt("androidx.media3.session.command.COMPACT_VIEW_INDEX", -1);
                    e2 = e0;
                    a a0 = new a(0xE045);
                    a0.b(6);
                    a0.f = "@com.iloen.melon:string/talkback_player_prev";
                    a0.g = new Bundle(bundle0);
                    q0.a(a0.a());
                }
                else {
                    e2 = e0;
                }
                if(n0.a(1)) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putInt("androidx.media3.session.command.COMPACT_VIEW_INDEX", -1);
                    if(z) {
                        v5 = v4;
                        a a2 = new a(0xE037);
                        a2.b(1);
                        a2.g = new Bundle(bundle1);
                        a2.f = "@com.iloen.melon:string/talkback_player_play";
                        q0.a(a2.a());
                    }
                    else {
                        v5 = v4;
                        a a1 = new a(0xE034);
                        a1.b(1);
                        a1.g = new Bundle(bundle1);
                        a1.f = "@com.iloen.melon:string/talkback_player_pause";
                        q0.a(a1.a());
                    }
                }
                else {
                    v5 = v4;
                }
                if(n0.a.a(new int[]{9, 8})) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("androidx.media3.session.command.COMPACT_VIEW_INDEX", -1);
                    a a3 = new a(0xE044);
                    a3.b(8);
                    a3.g = new Bundle(bundle2);
                    a3.f = "@com.iloen.melon:string/talkback_player_next";
                    q0.a(a3.a());
                }
                for(int v6 = 0; v6 < p00.d; ++v6) {
                    b b2 = (b)p00.get(v6);
                    if(b2.a != null && b2.a.a == 0) {
                        q0.a(b2);
                    }
                }
                p0 p01 = q0.g();
                int[] arr_v = new int[3];
                int[] arr_v1 = new int[3];
                Arrays.fill(arr_v, -1);
                Arrays.fill(arr_v1, -1);
                int v7 = 0;
                int v8 = 0;
                while(v8 < p01.d) {
                    b b3 = (b)p01.get(v8);
                    s1 s10 = b3.a;
                    CharSequence charSequence0 = b3.f;
                    int v9 = b3.d;
                    int v10 = b3.b;
                    if(s10 == null) {
                        defaultMediaNotificationProvider1 = defaultMediaNotificationProvider0;
                        arr_v2 = arr_v;
                        s2 = s1;
                        n01 = n00;
                        g11 = g10;
                        e3.b.j(v10 != -1);
                        m m1 = new m(IconCompat.c(context0, v9), charSequence0, e1.e(y00, ((long)v10)));
                        notificationCompat$Builder0.b.add(m1);
                    }
                    else {
                        defaultMediaNotificationProvider1 = defaultMediaNotificationProvider0;
                        MediaSessionService mediaSessionService0 = (MediaSessionService)e1.b;
                        n01 = n00;
                        e3.b.c(s10.a == 0);
                        IconCompat iconCompat0 = IconCompat.c(mediaSessionService0, v9);
                        s2 = s1;
                        g11 = g10;
                        arr_v2 = arr_v;
                        Intent intent0 = new Intent("androidx.media3.session.CUSTOM_NOTIFICATION_ACTION");
                        intent0.setData(((f0)y00).a.b);
                        intent0.setComponent(new ComponentName(mediaSessionService0, mediaSessionService0.getClass()));
                        intent0.putExtra("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION", s10.b);
                        intent0.putExtra("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION_EXTRAS", s10.c);
                        int v11 = e1.a + 1;
                        e1.a = v11;
                        m m0 = new m(iconCompat0, charSequence0, PendingIntent.getService(mediaSessionService0, v11, intent0, 0xC000000));
                        notificationCompat$Builder0.b.add(m0);
                    }
                    if(v7 != 3) {
                        int v12 = b3.g.getInt("androidx.media3.session.command.COMPACT_VIEW_INDEX", -1);
                        if(v12 >= 0 && v12 < 3) {
                            ++v7;
                            arr_v2[v12] = v8;
                        }
                        else if(v10 == 6 || v10 == 7) {
                            arr_v1[0] = v8;
                        }
                        else {
                            switch(v10) {
                                case 1: {
                                    arr_v1[1] = v8;
                                    break;
                                }
                                case 8: 
                                case 9: {
                                    arr_v1[2] = v8;
                                }
                            }
                        }
                    }
                    ++v8;
                    defaultMediaNotificationProvider0 = defaultMediaNotificationProvider1;
                    n00 = n01;
                    s1 = s2;
                    g10 = g11;
                    arr_v = arr_v2;
                }
                if(v7 == 0) {
                    int v13 = 0;
                    for(int v14 = 0; v14 < 3; ++v14) {
                        int v15 = arr_v1[v14];
                        if(v15 != -1) {
                            arr_v[v13] = v15;
                            ++v13;
                        }
                    }
                }
                for(int v16 = 0; true; ++v16) {
                    if(v16 >= 3) {
                        arr_v3 = arr_v;
                        break;
                    }
                    if(arr_v[v16] == -1) {
                        arr_v3 = Arrays.copyOf(arr_v, v16);
                        break;
                    }
                }
                g10.e = arr_v3;
                if(s1.Y(18)) {
                    G g0 = s1.T();
                    notificationCompat$Builder0.e = NotificationCompat.Builder.b(g0.a);
                    notificationCompat$Builder0.c(g0.b);
                    n02 = n00;
                    d d0 = n02.m;
                    d0.getClass();
                    byte[] arr_b = g0.k;
                    if(arr_b == null) {
                        b4 = g0.m == null ? null : d0.p(g0.m);
                    }
                    else {
                        b4 = d0.a(arr_b);
                    }
                    if(b4 == null) {
                        v17 = v5;
                        defaultMediaNotificationProvider2 = defaultMediaNotificationProvider0;
                    }
                    else {
                        defaultMediaNotificationProvider2 = defaultMediaNotificationProvider0;
                        i i0 = defaultMediaNotificationProvider2.f;
                        if(i0 != null) {
                            i0.b = true;
                        }
                        if(b4.isDone()) {
                            try {
                                notificationCompat$Builder0.f(((Bitmap)com.google.firebase.b.D(b4)));
                            }
                            catch(CancellationException | ExecutionException cancellationException0) {
                                e3.b.D("NotificationProvider", "Failed to load bitmap: " + cancellationException0.getMessage());
                            }
                            v17 = v5;
                        }
                        else {
                            v17 = v5;
                            i i1 = new i(v17, notificationCompat$Builder0, e2);
                            defaultMediaNotificationProvider2.f = i1;
                            Objects.requireNonNull(((f0)y00).a.l);
                            androidx.media3.session.p0 p02 = new androidx.media3.session.p0(((f0)y00).a.l, 1);
                            b4.addListener(new u(0, b4, i1), p02);
                        }
                    }
                }
                else {
                    v17 = v5;
                    defaultMediaNotificationProvider2 = defaultMediaNotificationProvider0;
                    n02 = n00;
                }
                long v18 = !s1.isPlaying() || s1.isPlayingAd() || s1.Z() || s1.getPlaybackParameters().a != 1.0f ? 0x8000000000000001L : System.currentTimeMillis() - s1.getContentPosition();
                int v19 = v18 == 0x8000000000000001L ? 0 : 1;
                if(v19 == 0) {
                    v18 = 0L;
                }
                notificationCompat$Builder0.G.when = v18;
                notificationCompat$Builder0.k = v19;
                notificationCompat$Builder0.l = v19;
                notificationCompat$Builder0.E = 1;
                notificationCompat$Builder0.g = n02.u;
                notificationCompat$Builder0.G.deleteIntent = e1.e(y00, 3L);
                notificationCompat$Builder0.e(8, true);
                notificationCompat$Builder0.G.icon = defaultMediaNotificationProvider2.g;
                notificationCompat$Builder0.g(g10);
                notificationCompat$Builder0.A = 1;
                notificationCompat$Builder0.e(2, ((boolean)0));
                notificationCompat$Builder0.r = "media3_group_key";
                r0 r00 = new r0(t00, y00, new T3.e(v17, notificationCompat$Builder0.a()), this.b, 0);
                t00.e.execute(r00);
                return;
            }
            case 1: {
                O0 o00 = (O0)this.c;
                k k0 = (k)this.d;
                b0 b00 = (b0)this.e;
                g g1 = (g)this.f;
                boolean z1 = this.b;
                o00.d.remove(k0);
                boolean z2 = true;
                try {
                    MediaSessionService mediaSessionService1 = (MediaSessionService)o00.a.get();
                    if(mediaSessionService1 == null) {
                        goto label_247;
                    }
                    b1 b10 = new b1(k0, g1.b);
                    w0 w00 = new w0(b00, g1.a, g1.b, z1, b10, g1.e);
                    try {
                        f0 f00 = mediaSessionService1.f(w00);
                        if(f00 == null) {
                            goto label_247;
                        }
                        mediaSessionService1.a(f00);
                        z2 = false;
                        f00.a.g.C0(k0, w00);
                    }
                    catch(Exception exception0) {
                        e3.b.E("MSessionService", "Failed to add a session to session service", exception0);
                    }
                }
                catch(Throwable throwable0) {
                    if(z2) {
                        try {
                            k0.d();
                        }
                        catch(RemoteException unused_ex) {
                        }
                    }
                    throw throwable0;
                }
                if(z2) {
                    try {
                    label_247:
                        k0.d();
                        return;
                    }
                    catch(RemoteException unused_ex) {
                    }
                }
                return;
            }
            default: {
                ImageDownloader.a(((ImageRequest)this.c), ((Exception)this.d), this.b, ((Bitmap)this.e), ((Callback)this.f));
            }
        }
    }
}

