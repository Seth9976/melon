package gc;

import Bf.a;
import Cb.i;
import Dd.J;
import H8.g;
import Hd.F0;
import L8.l;
import L8.s;
import Nb.v0;
import Nb.z0;
import Tf.v;
import android.database.Cursor;
import android.net.Uri;
import androidx.appcompat.app.o;
import b3.E;
import b3.K;
import b3.P;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.S0;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import k8.Y;
import k8.t;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;

public final class e extends a implements P {
    public final s b;
    public final LogU c;
    public final AtomicReference d;
    public final AtomicBoolean e;
    public final AtomicBoolean f;
    public boolean g;
    public final v0 h;

    public e(S0 s00, s s0) {
        q.g(s0, "controller");
        super(s00);
        this.b = s0;
        this.c = Companion.create$default(LogU.Companion, "DlnaPlayer", false, Category.Playback, 2, null);
        s0.e = new d(this, s00);
        this.d = new AtomicReference(E.g);
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.h = v0.b;
    }

    @Override  // Bf.a
    public final E X0() {
        Object object0 = this.d.get();
        q.f(object0, "get(...)");
        return (E)object0;
    }

    @Override  // Bf.a
    public final long Y0() {
        return (long)this.b.h;
    }

    @Override  // Bf.a
    public final z0 a1() {
        return this.h;
    }

    @Override  // Bf.a
    public final long b1() {
        return (long)this.b.g;
    }

    @Override  // Bf.a
    public final void j1() {
        s s0 = this.b;
        LogU.info$default(s0.d, "pause() state: " + s0.f, null, false, 6, null);
        switch(s0.f.ordinal()) {
            case 1: 
            case 3: 
            case 5: {
                g g0 = new g(24);
                L8.g g1 = new L8.g(s0, 4);
                kg.d d0 = s0.a.i;
                if(d0 == null) {
                    LogU.Companion.e("MediaRenderer", "pause() - Pause is not supported");
                    return;
                }
                Map map0 = Collections.singletonMap("InstanceID", "0");
                q.f(map0, "singletonMap(...)");
                M8.a.a(d0, map0, g0, g1);
                return;
            }
            default: {
                LogU.warn$default(s0.d, "pause() - Command(pause) skipped in state : " + s0.f, null, false, 6, null);
            }
        }
    }

    @Override  // b3.P
    public final void k0(K k0) {
        q.g(k0, "error");
        ((S0)this.a).e0(this, k0, "DlnaPlayer Error");
    }

    @Override  // Bf.a
    public final void k1() {
        s s0 = this.b;
        LogU.info$default(s0.d, "play() state: " + s0.f, null, false, 6, null);
        switch(s0.f.ordinal()) {
            case 0: 
            case 1: 
            case 3: {
                L8.g g0 = new L8.g(s0, 5);
                L8.g g1 = new L8.g(s0, 6);
                M8.a.a(s0.a.f, ((Map)s0.a.n), g0, g1);
                return;
            }
            default: {
                LogU.warn$default(s0.d, "play() - Command(play) skipped in state : " + s0.f, null, false, 6, null);
            }
        }
    }

    @Override  // Bf.a
    public final void l1() {
        LogU.info$default(this.b.d, "release()", null, false, 6, null);
        M8.a.c(this.b.a);
        this.b.e();
    }

    @Override  // Bf.a
    public final void m1(long v) {
        String s = o.p("seekTo() isSeeking : ", this.f.get());
        LogU.debug$default(this.c, s, null, false, 6, null);
        if(this.f.compareAndSet(false, true)) {
            LogU.debug$default(this.c, va.e.a(v, "seekTo() positionMs : "), null, false, 6, null);
            s s1 = this.b;
            c c0 = new c(this, 0);
            c c1 = new c(this, 1);
            LogU.info$default(s1.d, "seekTo() - position : " + ((int)v) + ", [" + s1.f.name() + "]", null, false, 6, null);
            switch(s1.f.ordinal()) {
                case 0: 
                case 1: {
                    F0 f00 = new F0(s1, ((int)v), c0, 2);
                    J j0 = new J(24, s1, c1);
                    kg.d d0 = s1.a.h;
                    d0.getClass();
                    kg.g g0 = (kg.g)d0.e.get("Unit");
                    if(g0 == null) {
                        LogU.Companion.e("MediaRenderer", "seek() - No unit argument");
                        return;
                    }
                    HashMap hashMap0 = new HashMap();
                    hashMap0.put("InstanceID", "0");
                    ArrayList arrayList0 = g0.c.c;
                    boolean z = false;
                    if(arrayList0.contains("REL_TIME")) {
                        z = true;
                        String s2 = (String)hashMap0.put("Unit", "REL_TIME");
                    }
                    else if(arrayList0.contains("ABS_TIME")) {
                        z = true;
                        String s3 = (String)hashMap0.put("Unit", "ABS_TIME");
                    }
                    if(z) {
                        hashMap0.put("Target", String.format(Locale.US, "%01d:%02d:%02d", Arrays.copyOf(new Object[]{((long)(((long)(((int)v))) / M8.a.q)), ((long)(((long)(((int)v))) / M8.a.p % 60L)), ((long)(((long)(((int)v))) / M8.a.o % 60L))}, 3)));
                        M8.a.a(d0, hashMap0, f00, j0);
                        return;
                    }
                    LogU.Companion.e("MediaRenderer", "seek() - No supported unit");
                    break;
                }
                default: {
                    LogU.warn$default(s1.d, "seekTo() - Command(seekTo) skipped in state : " + s1.f, null, false, 6, null);
                }
            }
        }
    }

    @Override  // Bf.a
    public final void n1(Uri uri0, E e0, hc.s s0) {
        q.g(uri0, "uri");
        q.g(e0, "mediaItem");
        this.d.set(e0);
        boolean z = true;
        this.e.set(true);
        boolean z1 = false;
        this.f.set(false);
        if(s0 instanceof hc.q) {
            s s1 = ((hc.q)s0).a;
            s1.getClass();
            String s2 = uri0.getScheme();
            if(s2 != null) {
                switch(s2) {
                    case "content": 
                    case "file": {
                        String s3 = uri0.getScheme();
                        if(s3 != null) {
                            switch(s3) {
                                case "content": {
                                    Cursor cursor0 = i.n(Y.a(MelonAppBase.Companion), uri0, null, null, null, 30);
                                    if(cursor0 != null) {
                                        try {
                                            if(cursor0.getCount() <= 0) {
                                                z = false;
                                            }
                                        }
                                        catch(Throwable throwable0) {
                                            d8.d.l(cursor0, throwable0);
                                            throw throwable0;
                                        }
                                        cursor0.close();
                                        z1 = z;
                                    }
                                    break;
                                }
                                case "file": {
                                    String s4 = uri0.getPath();
                                    if(s4 != null) {
                                        z1 = new File(s4).exists();
                                    }
                                }
                            }
                        }
                        if(!z1) {
                            Exception exception0 = new Exception("local uri exception");
                            ((Ub.o)s1.c).a("Not found local file.", exception0);
                            return;
                        }
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(s1.p), null, null, new l(s1, uri0, ((hc.q)s0), null), 3, null);
                        return;
                    }
                }
            }
            String s5 = uri0.toString();
            q.f(s5, "toString(...)");
            MelonAppBase.Companion.getClass();
            s1.f(v.p0(s5, t.a().getHostAddress(), ((hc.q)s0).b.f), ((hc.q)s0), new L8.g(s1, 9), new L8.g(s1, 0));
        }
    }

    @Override  // Bf.a
    public final void o1(float f) {
        s.h(this.b, ((int)f));
    }

    @Override  // Bf.a
    public final void p1() {
        this.d.set(E.g);
        s s0 = this.b;
        LogU.info$default(s0.d, "stop() state: " + s0.f, null, false, 6, null);
        if(EnumSet.of(M8.g.f).contains(s0.f)) {
            LogU.debug$default(s0.d, "stop() - Command(stop) skipped in state : " + s0.f, null, false, 6, null);
            return;
        }
        L8.g g0 = new L8.g(s0, 1);
        L8.g g1 = new L8.g(s0, 2);
        Map map0 = Collections.singletonMap("InstanceID", "0");
        q.f(map0, "singletonMap(...)");
        M8.a.a(s0.a.g, map0, g0, g1);
    }
}

