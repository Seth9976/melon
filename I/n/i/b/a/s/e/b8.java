package i.n.i.b.a.s.e;

import Bb.e;
import Nf.p;
import U4.x;
import android.media.MediaDrm.MediaDrmStateException;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.media3.session.legacy.C;
import e3.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class B8 implements b1 {
    public int A;
    public static final Pattern B;
    public static final Pattern C;
    public static final Ma[] D;
    public final List a;
    public final h5 b;
    public final l9 c;
    public final l9 d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final HashMap h;
    public HashMap i;
    public final wt j;
    public final f k;
    public final p l;
    public final String m;
    public final S7 n;
    public final UUID o;
    public final e p;
    public int q;
    public int r;
    public HandlerThread s;
    public C t;
    public J4 u;
    public a1 v;
    public byte[] w;
    public byte[] x;
    public f5 y;
    public g5 z;

    static {
        B8.B = Pattern.compile("([0-9]+)\\|(.+)");
        B8.C = Pattern.compile(".*DRM vendor-defined error: (-?[0-9]+).*");
        B8.D = new Ma[]{new Ma(15)};
    }

    public B8(UUID uUID0, h5 h50, l9 l90, l9 l91, List list0, int v, boolean z, boolean z1, byte[] arr_b, wt wt0, HashMap hashMap0, S7 s70, Looper looper0, p p0, String s) {
        this.A = 1;
        if(v == 1 || v == 3) {
            arr_b.getClass();
        }
        this.o = uUID0;
        this.c = l90;
        this.d = l91;
        this.b = h50;
        this.e = v;
        this.f = z;
        this.g = z1;
        if(arr_b == null) {
            list0.getClass();
            this.a = Collections.unmodifiableList(list0);
        }
        else {
            this.x = arr_b;
            this.a = null;
        }
        this.j = wt0;
        this.h = hashMap0;
        this.n = s70;
        this.k = new f(1);
        this.l = p0;
        this.m = s;
        this.i = new HashMap();
        this.q = 2;
        this.p = new e(this, looper0, 11);
    }

    @Override  // i.n.i.b.a.s.e.b1
    public final void a(X1 x10) {
        M7.J(this.r > 0);
        int v = this.r - 1;
        this.r = v;
        if(v == 0) {
            this.q = 0;
            this.p.removeCallbacksAndMessages(null);
            C c0 = this.t;
            synchronized(c0) {
                c0.removeCallbacksAndMessages(null);
                c0.b = true;
            }
            this.t = null;
            this.s.quit();
            this.s = null;
            this.u = null;
            this.v = null;
            this.y = null;
            this.z = null;
            byte[] arr_b = this.w;
            if(arr_b != null) {
                this.b.i(arr_b);
                this.w = null;
            }
        }
        if(x10 != null) {
            f f0 = this.k;
            synchronized(f0.b) {
                Integer integer0 = (Integer)f0.c.get(x10);
                if(integer0 != null) {
                    ArrayList arrayList0 = new ArrayList(f0.e);
                    arrayList0.remove(x10);
                    f0.e = Collections.unmodifiableList(arrayList0);
                    if(((int)integer0) == 1) {
                        f0.c.remove(x10);
                        HashSet hashSet0 = new HashSet(f0.d);
                        hashSet0.remove(x10);
                        f0.d = Collections.unmodifiableSet(hashSet0);
                    }
                    else {
                        f0.c.put(x10, ((int)(((int)integer0) - 1)));
                    }
                }
            }
            if(this.k.b(x10) == 0) {
                x10.g();
            }
        }
        int v3 = this.r;
        B9 b90 = this.d.a;
        if(v3 == 1 && b90.i != 0x8000000000000001L) {
            b90.m.add(this);
            Handler handler0 = b90.t;
            handler0.getClass();
            handler0.postAtTime(new u9(this, 1), this, SystemClock.uptimeMillis() + b90.i);
            return;
        }
        if(v3 == 0) {
            b90.j.remove(this);
            if(b90.q == this) {
                b90.q = null;
            }
            if(b90.r == this) {
                b90.r = null;
            }
            if(b90.k.size() > 1 && b90.k.get(0) == this) {
                B8 b80 = (B8)b90.k.get(1);
                g5 g50 = b80.b.c();
                b80.z = g50;
                C c1 = b80.t;
                g50.getClass();
                c1.a(0, g50, true);
            }
            b90.k.remove(this);
            if(b90.i != 0x8000000000000001L) {
                Handler handler1 = b90.t;
                handler1.getClass();
                handler1.removeCallbacksAndMessages(this);
                b90.m.remove(this);
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.b1
    public final boolean a() {
        return this.f;
    }

    @Override  // i.n.i.b.a.s.e.b1
    public final J4 b() {
        return this.u;
    }

    @Override  // i.n.i.b.a.s.e.b1
    public final void b(X1 x10) {
        f f0 = this.k;
        boolean z = false;
        M7.J(this.r >= 0);
        if(x10 != null) {
            synchronized(f0.b) {
                ArrayList arrayList0 = new ArrayList(f0.e);
                arrayList0.add(x10);
                f0.e = Collections.unmodifiableList(arrayList0);
                Integer integer0 = (Integer)f0.c.get(x10);
                if(integer0 == null) {
                    HashSet hashSet0 = new HashSet(f0.d);
                    hashSet0.add(x10);
                    f0.d = Collections.unmodifiableSet(hashSet0);
                }
                f0.c.put(x10, ((int)(integer0 == null ? 1 : ((int)integer0) + 1)));
            }
        }
        int v1 = this.r + 1;
        this.r = v1;
        if(v1 == 1) {
            if(this.q == 2) {
                z = true;
            }
            M7.J(z);
            HandlerThread handlerThread0 = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.s = handlerThread0;
            handlerThread0.start();
            this.t = new C(this, this.s.getLooper(), 1);
            if(this.g(true)) {
                this.d(true);
            }
        }
        else if(x10 != null && this.j() && f0.b(x10) == 1) {
            x10.b(this.q);
        }
        B9 b90 = this.d.a;
        if(b90.i != 0x8000000000000001L) {
            b90.m.remove(this);
            Handler handler0 = b90.t;
            handler0.getClass();
            handler0.removeCallbacksAndMessages(this);
        }
    }

    @Override  // i.n.i.b.a.s.e.b1
    public final int c() {
        return this.q;
    }

    public final void c(Exception exception0, B2 b20) {
        this.v = new a1(exception0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V
        M7.H("IbisDrmSession", "DRM session error", exception0);
        try {
            this.n.h(exception0);
        }
        catch(Exception exception1) {
            exception1.printStackTrace();
        }
        for(Object object0: this.k.a()) {
            ((X1)object0).d(exception0, b20);
        }
        if(this.q != 4) {
            this.q = 1;
        }
    }

    public final void d(boolean z) {
        long v1;
        if(!this.g) {
            byte[] arr_b = this.w;
            int v = this.e;
            switch(v) {
                case 0: 
                case 1: {
                    if(this.x == null) {
                        this.A = 1;
                        this.t.a(1, new Object(), false);
                        return;
                    }
                    if(this.q == 4 || this.k()) {
                        try {
                            v1 = this.i();
                        }
                        catch(Exception exception0) {
                            this.c(exception0, null);
                            return;
                        }
                        if(v == 0 && v1 <= 60L) {
                            Log.d("IbisDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + v1);
                            this.A = 2;
                            this.t.a(1, new Object(), false);
                            return;
                        }
                        if(v1 <= 0L) {
                            this.c(new v7(), null);  // 初始化器: Ljava/lang/Exception;-><init>()V
                            return;
                        }
                        this.q = 4;
                        for(Object object0: this.k.a()) {
                            ((X1)object0).h(this.o);
                        }
                        return;
                    }
                    break;
                }
                case 2: {
                    if(this.x == null || this.k()) {
                        this.e(arr_b, 2, z);
                        return;
                    }
                    break;
                }
                default: {
                    if(v == 3) {
                        this.x.getClass();
                        this.w.getClass();
                        if(this.k()) {
                            this.e(this.x, 3, z);
                        }
                    }
                }
            }
        }
    }

    public final void e(byte[] arr_b, int v, boolean z) {
        try {
            if(v == 1 || v == 2) {
                for(Object object0: this.k.a()) {
                    ((X1)object0).e(this.o);
                }
            }
            f5 f50 = this.b.f(arr_b, this.a, v, this.i);
            this.y = f50;
            C c0 = this.t;
            f50.getClass();
            c0.a(2, f50, z);
        }
        catch(Exception exception0) {
            if(exception0 instanceof NotProvisionedException) {
                this.c.a(this);
                return;
            }
            this.c(exception0, null);
        }
    }

    @Override  // i.n.i.b.a.s.e.b1
    public final boolean e() {
        try {
            return this.i() <= 0L;
        }
        catch(Exception exception0) {
            M7.M(exception0, "IbisDrmSession", "Failed to get license duration remaining: " + exception0);
            return true;
        }
    }

    public final void f(Exception exception0) {
        Exception exception2;
        Exception exception1;
        Pair pair0;
        B2 b20 = null;
        if(exception0 instanceof NotProvisionedException) {
            this.c.a(this);
            return;
        }
        if(exception0 instanceof y8) {
            y8 y80 = (y8)exception0;
            Ma[] arr_ma = B8.D;
            int v = 0;
            while(true) {
                if(v >= arr_ma.length) {
                    pair0 = new Pair(y80, y80.a);
                    break;
                }
                arr_ma[v].getClass();
                B2 b21 = y80.a;
                if(b4.d.equals(this.o) && b21.a == 401) {
                    try {
                        Matcher matcher0 = B8.B.matcher(new String(b21.c, b9.c));
                        if(matcher0.matches()) {
                            String s = matcher0.group(1);
                            s.getClass();
                            int v1 = Integer.parseInt(s);
                            String s1 = matcher0.group(2);
                            s1.getClass();
                            if(v1 == 102 && s1.contains("ACCESS_DENIED")) {
                                pair0 = new Pair(new v8(-100903, y80), b21);
                                goto label_25;
                            }
                        }
                    }
                    catch(NumberFormatException | NullPointerException numberFormatException0) {
                        Log.w("IbisDrmSession", "invalid response body format, " + numberFormatException0);
                    }
                }
                pair0 = null;
            label_25:
                if(pair0 != null) {
                    break;
                }
                ++v;
            }
            exception1 = (Exception)pair0.first;
            b20 = (B2)pair0.second;
        }
        else if(L7.a < 21 || !(exception0 instanceof MediaDrm.MediaDrmStateException)) {
            exception1 = new w8(exception0);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/Throwable;)V
        }
        else {
            try {
                exception2 = new w8(exception0);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/Throwable;)V
            }
            catch(NumberFormatException | NullPointerException numberFormatException1) {
                Log.w("IbisDrmSession", "failed to handle exception message, " + numberFormatException1);
                exception1 = exception0;
                this.c(exception1, b20);
                return;
            }
            if(exception2.getMessage() != null) {
                try {
                    Matcher matcher1 = B8.C.matcher(exception2.getMessage());
                    if(matcher1.matches()) {
                        String s2 = matcher1.group(1);
                        s2.getClass();
                        int v2 = Integer.parseInt(s2);
                        if(v2 > -2500 || v2 < 0xFFFFF449) {
                            goto label_53;
                        }
                        else {
                            exception1 = new v8(v2 - 100000, exception0);
                        }
                    }
                    else {
                        goto label_55;
                    }
                }
                catch(NumberFormatException | NullPointerException numberFormatException2) {
                    Log.w("IbisDrmSession", "failed to handle exception message, " + numberFormatException2);
                    exception1 = exception2;
                }
                this.c(exception1, b20);
                return;
            label_53:
                exception1 = exception2;
                this.c(exception1, b20);
                return;
            }
        label_55:
            exception1 = exception2;
        }
        this.c(exception1, b20);
    }

    @Override  // i.n.i.b.a.s.e.b1
    public final UUID g() {
        return this.o;
    }

    public final boolean g(boolean z) {
        h5 h50 = this.b;
        if(this.j()) {
            return true;
        }
        try {
            byte[] arr_b = h50.b();
            this.w = arr_b;
            this.u = h50.d(arr_b);
            this.q = 3;
            for(Object object0: this.k.a()) {
                ((X1)object0).b(3);
            }
            this.w.getClass();
            return true;
        }
        catch(NotProvisionedException notProvisionedException0) {
            if(z) {
                this.c.a(this);
                return false;
            }
            this.c(notProvisionedException0, null);
            return false;
        }
        catch(Exception exception0) {
            this.c(exception0, null);
            return false;
        }
    }

    @Override  // i.n.i.b.a.s.e.b1
    public final a1 h() {
        return this.q == 1 ? this.v : null;
    }

    public final long i() {
        long v2;
        long v1;
        Pair pair0;
        if(!b4.d.equals(this.o)) {
            return 0x7FFFFFFFFFFFFFFFL;
        }
        int v = 0;
        while(true) {
            try {
                pair0 = null;
                Map map0 = this.w == null ? null : this.b.h(this.w);
                if(map0 == null) {
                    break;
                }
                try {
                    v1 = 0x8000000000000001L;
                    String s = (String)map0.get("LicenseDurationRemaining");
                    v2 = 0x8000000000000001L;
                    if(s != null) {
                        v2 = Long.parseLong(s);
                    }
                }
                catch(NumberFormatException unused_ex) {
                }
                Long long0 = v2;
                try {
                    String s1 = (String)map0.get("PlaybackDurationRemaining");
                    if(s1 != null) {
                        v1 = Long.parseLong(s1);
                    }
                }
                catch(NumberFormatException unused_ex) {
                }
                pair0 = new Pair(long0, v1);
                break;
            }
            catch(Exception exception0) {
                ++v;
                long v3 = v >= 3 ? -1L : ((long)v) * 100L;
                if(v3 < 0L) {
                    throw exception0;
                }
                try {
                    Thread.sleep(v3);
                }
                catch(InterruptedException unused_ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        pair0.getClass();
        return Math.min(((long)(((Long)pair0.first))), ((long)(((Long)pair0.second))));
    }

    public final boolean j() {
        return this.q == 3 || this.q == 4;
    }

    public final boolean k() {
        try {
            this.b.b(this.w, this.x);
            return true;
        }
        catch(Exception exception0) {
            M7.H("IbisDrmSession", "Error trying to restore keys.", exception0);
            this.c(exception0, null);
            return false;
        }
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DrmSession(ibis, ref=");
        stringBuilder0.append(this.r);
        stringBuilder0.append(", sid=");
        if(this.w == null) {
            return x.m(stringBuilder0, "null", ")");
        }
        StringBuilder stringBuilder1 = new StringBuilder();
        byte[] arr_b = this.w;
        char[] arr_c = new char[arr_b.length];
        for(int v1 = 0; v1 < arr_b.length; ++v1) {
            char c = (char)arr_b[v1];
            if(c < 0x20 || c > 0x7E) {
                c = '.';
            }
            arr_c[v1] = c;
        }
        stringBuilder1.append(new String(arr_c));
        stringBuilder1.append("[");
        byte[] arr_b1 = this.w;
        char[] arr_c1 = Ja.B;
        char[] arr_c2 = new char[arr_b1.length * 2];
        for(int v = 0; v < arr_b1.length; ++v) {
            int v2 = arr_b1[v];
            arr_c2[v * 2] = arr_c1[(v2 & 0xFF) >>> 4];
            arr_c2[v * 2 + 1] = arr_c1[v2 & 15];
        }
        stringBuilder1.append(new String(arr_c2));
        stringBuilder1.append("]");
        return x.m(stringBuilder0, stringBuilder1.toString(), ")");
    }
}

