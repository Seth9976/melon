package com.google.android.gms.internal.cast;

import E9.t;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.mediarouter.media.MediaTransferReceiver;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.SessionTransferCallback;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import l4.G;
import l4.H;
import l4.O;
import l4.Q;
import l4.S;
import l4.T;
import l4.a;
import l4.e;
import l4.h;
import l4.o;

public final class zzbf extends zzal {
    private static final Logger zza;
    private final Q zzb;
    private final CastOptions zzc;
    private final Map zzd;
    private zzbn zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;

    static {
        zzbf.zza = new Logger("MediaRouterProxy");
    }

    public zzbf(Context context0, Q q0, CastOptions castOptions0, zzn zzn0) {
        this.zzd = new HashMap();
        this.zzb = q0;
        this.zzc = castOptions0;
        if(Build.VERSION.SDK_INT < 33) {
            return;
        }
        zzbf.zza.d("Set up MediaRouterParams based on module flag and CastOptions for Android T or above", new Object[0]);
        this.zze = new zzbn(castOptions0);
        Intent intent0 = new Intent(context0, MediaTransferReceiver.class);
        intent0.setPackage("com.iloen.melon");
        this.zzf = !context0.getPackageManager().queryBroadcastReceivers(intent0, 0).isEmpty();
        this.zzg = true;
        zzn0.zza(new String[]{"com.google.android.gms.cast.FLAG_OUTPUT_SWITCHER_ENABLED"}).addOnCompleteListener((Task task0) -> {
            boolean z = true;
            if(task0.isSuccessful()) {
                Bundle bundle0 = (Bundle)task0.getResult();
                int v = bundle0 == null || !bundle0.containsKey("com.google.android.gms.cast.FLAG_OUTPUT_SWITCHER_ENABLED") ? 0 : 1;
                zzbf.zza.d("The module-to-client output switcher flag %s", new Object[]{(1 == v ? "existed" : "not existed")});
                if(v != 0) {
                    this.zzg = bundle0.getBoolean("com.google.android.gms.cast.FLAG_OUTPUT_SWITCHER_ENABLED");
                }
            }
            boolean z1 = this.zzg;
            if(this.zzb != null) {
                CastOptions castOptions0 = this.zzc;
                if(castOptions0 != null) {
                    boolean z2 = castOptions0.zzg();
                    boolean z3 = castOptions0.zze();
                    boolean z4 = z1 && castOptions0.zzi();
                    S s0 = new S();  // 初始化器: Ljava/lang/Object;-><init>()V
                    int v1 = Build.VERSION.SDK_INT;
                    s0.a = v1 >= 30;
                    if(v1 >= 30) {
                        s0.a = z4;
                    }
                    if(v1 >= 30) {
                        s0.c = z2;
                    }
                    if(v1 >= 30) {
                        s0.b = z3;
                    }
                    boolean z5 = castOptions0.zzf();
                    if(v1 >= 30) {
                        s0.d = z5;
                    }
                    T t0 = new T(s0);
                    Q.b();
                    h h0 = Q.c();
                    T t1 = h0.v;
                    h0.v = t0;
                    if(h0.h()) {
                        if(h0.s == null) {
                            a a0 = new a(h0);
                            o o0 = new o(h0.h, a0);
                            h0.s = o0;
                            h0.a(o0, true);
                            h0.n();
                        }
                        h0.s.r = t0.d;
                        h0.s.i();
                        h0.c.a = t0.d;
                        ((Handler)h0.c.e).post(((t)h0.c.i));
                        if((t1 != null && t1.c) != t0.c) {
                            o o1 = h0.s;
                            o1.e = h0.B;
                            if(!o1.f) {
                                o1.f = true;
                                o1.c.sendEmptyMessage(2);
                            }
                        }
                    }
                    else {
                        o o2 = h0.s;
                        if(o2 != null) {
                            h0.k(o2);
                            h0.s = null;
                            ((Handler)h0.c.e).post(((t)h0.c.i));
                        }
                    }
                    h0.a.b(0x301, t0);
                    zzbf.zza.i("media transfer = %b, session transfer = %b, transfer to local = %b, in-app output switcher = %b", new Object[]{Boolean.valueOf(this.zzf), Boolean.valueOf(z4), Boolean.valueOf(z2), Boolean.valueOf(z3)});
                    zzbn zzbn0 = this.zze;
                    if(zzbn0 != null) {
                        if(!this.zzf || !z4) {
                            z = false;
                        }
                        zzbn0.zzm(z);
                    }
                    if(this.zzf && z4) {
                        zzp.zzd(zzpb.zzJ);
                    }
                    if(z2) {
                        zzp.zzd(zzpb.zzK);
                    }
                }
            }
        });
    }

    @Override  // com.google.android.gms.internal.cast.zzam
    public final Bundle zzb(String s) {
        this.zzb.getClass();
        for(Object object0: Q.f()) {
            O o0 = (O)object0;
            if(o0.c.equals(s)) {
                return o0.s;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    @Override  // com.google.android.gms.internal.cast.zzam
    public final String zzc() {
        this.zzb.getClass();
        return Q.g().c;
    }

    @Override  // com.google.android.gms.internal.cast.zzam
    public final void zzd(Bundle bundle0, int v) {
        G g0 = G.b(bundle0);
        if(g0 == null) {
            return;
        }
        if(Looper.myLooper() == Looper.getMainLooper()) {
            this.zzx(g0, v);
            return;
        }
        new zzet(Looper.getMainLooper()).post(() -> synchronized(this.zzd) {
            this.zzx(g0, v);
        });
    }

    @Override  // com.google.android.gms.internal.cast.zzam
    public final void zze(Bundle bundle0, zzao zzao0) {
        G g0 = G.b(bundle0);
        if(g0 == null) {
            return;
        }
        Map map0 = this.zzd;
        if(!map0.containsKey(g0)) {
            map0.put(g0, new HashSet());
        }
        ((Set)map0.get(g0)).add(new zzat(zzao0, this, this.zze));
    }

    @Override  // com.google.android.gms.internal.cast.zzam
    public final void zzf() {
        Map map0 = this.zzd;
        for(Object object0: map0.values()) {
            for(Object object1: ((Set)object0)) {
                this.zzb.j(((H)object1));
            }
        }
        map0.clear();
    }

    @Override  // com.google.android.gms.internal.cast.zzam
    public final void zzg(Bundle bundle0) {
        G g0 = G.b(bundle0);
        if(g0 == null) {
            return;
        }
        if(Looper.myLooper() == Looper.getMainLooper()) {
            this.zzy(g0);
            return;
        }
        new zzet(Looper.getMainLooper()).post(() -> this.zzy(g0));
    }

    @Override  // com.google.android.gms.internal.cast.zzam
    public final void zzh() {
        this.zzb.getClass();
        Q.b();
        O o0 = Q.c().w;
        if(o0 == null) {
            throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
        }
        o0.l(true);
    }

    @Override  // com.google.android.gms.internal.cast.zzam
    public final void zzi(String s) {
        Logger logger0 = zzbf.zza;
        logger0.d("select route with routeId = %s", new Object[]{s});
        this.zzb.getClass();
        for(Object object0: Q.f()) {
            O o0 = (O)object0;
            if(o0.c.equals(s)) {
                logger0.d("media route is found and selected", new Object[0]);
                o0.l(true);
                return;
            }
            if(false) {
                break;
            }
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzam
    public final void zzj(int v) {
        this.zzb.getClass();
        Q.l(v);
    }

    @Override  // com.google.android.gms.internal.cast.zzam
    public final boolean zzk() {
        this.zzb.getClass();
        Q.b();
        O o0 = Q.c().x;
        return o0 != null && Q.g().c.equals(o0.c);
    }

    @Override  // com.google.android.gms.internal.cast.zzam
    public final boolean zzl() {
        this.zzb.getClass();
        Q.b();
        O o0 = Q.c().w;
        if(o0 == null) {
            throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
        }
        return Q.g().c.equals(o0.c);
    }

    @Override  // com.google.android.gms.internal.cast.zzam
    public final boolean zzm(Bundle bundle0, int v) {
        G g0 = G.b(bundle0);
        if(g0 == null) {
            return false;
        }
        this.zzb.getClass();
        return Q.i(g0, v);
    }

    public final zzbn zzn() {
        return this.zze;
    }

    // 检测为 Lambda 实现
    public static void zzo(zzbf zzbf0, G g0, int v) [...]

    // 检测为 Lambda 实现
    public static void zzp(zzbf zzbf0, Task task0) [...]

    // 检测为 Lambda 实现
    public static void zzq(zzbf zzbf0, G g0) [...]

    public final void zzr(SessionTransferCallback sessionTransferCallback0) {
        zzbn zzbn0 = this.zze;
        if(zzbn0 != null) {
            zzbn0.zzl(sessionTransferCallback0);
            zzbb zzbb0 = new zzbb(((zzbn)Preconditions.checkNotNull(this.zze)));
            this.zzb.getClass();
            Q.b();
            Q.c().f = zzbb0;
        }
    }

    public final void zzs(SessionTransferCallback sessionTransferCallback0) {
        zzbn zzbn0 = this.zze;
        if(zzbn0 != null) {
            zzbn0.zzn(sessionTransferCallback0);
            this.zzb.getClass();
            Q.b();
            Q.c().f = null;
        }
    }

    public final void zzt(MediaSessionCompat mediaSessionCompat0) {
        this.zzb.getClass();
        Q.b();
        h h0 = Q.c();
        h0.E = mediaSessionCompat0;
        e e0 = mediaSessionCompat0 == null ? null : new e(h0, mediaSessionCompat0);
        e e1 = h0.D;
        if(e1 != null) {
            e1.a();
        }
        h0.D = e0;
        if(e0 != null) {
            h0.o();
        }
    }

    public final void zzu(boolean z) {
        this.zzh = z;
    }

    public final boolean zzv() {
        return this.zzh;
    }

    // 去混淆评级： 低(30)
    public final boolean zzw() {
        return this.zzf && this.zzg && (this.zzc != null && this.zzc.zzi());
    }

    private final void zzx(G g0, int v) {
        Set set0 = (Set)this.zzd.get(g0);
        if(set0 != null) {
            for(Object object0: set0) {
                this.zzb.a(g0, ((H)object0), v);
            }
        }
    }

    private final void zzy(G g0) {
        Set set0 = (Set)this.zzd.get(g0);
        if(set0 != null) {
            for(Object object0: set0) {
                this.zzb.j(((H)object0));
            }
        }
    }
}

