package i.n.i.b.a.s.e;

import B3.v;
import E9.t;
import Nf.p;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.util.e;
import h4.G;
import h9.d;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class sa implements Lb, T4, ud, zd {
    public final int a;
    public Object b;
    public Object c;
    public Object d;
    public static final v e;
    public static final Jd f;
    public static final Jd g;
    public static final Jd h;

    static {
        sa.e = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
        sa.f = new Jd(0, 0x8000000000000001L);
        sa.g = new Jd(2, 0x8000000000000001L);
        sa.h = new Jd(3, 0x8000000000000001L);
    }

    public sa() {
        this.a = 10;
        super();
    }

    public sa(int v, String s, ArrayList arrayList0, byte[] arr_b) {
        this.a = 3;
        super();
        this.b = s;
        this.c = arrayList0 == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(arrayList0);
        this.d = arr_b;
    }

    public sa(Gd gd0) {
        this.a = 5;
        super();
        this.b = gd0;
    }

    public sa(Y6 y60) {
        this.a = 4;
        super();
        this.c = y60;
    }

    public sa(q4 q40, u u0, r6 r60) {
        this.a = 0;
        super();
        this.b = q40;
        this.c = u0;
        this.d = r60;
    }

    public sa(ub ub0) {
        this.a = 8;
        super();
        this.d = ub0;
        this.b = new Handler();
        this.c = new tb(this, 0);
    }

    public sa(String s) {
        this.a = 6;
        super();
        ob ob0 = new ob();
        ob0.k = s;
        this.c = new u(ob0);
    }

    public sa(String s, Gd gd0) {
        this.a = 1;
        super();
        this.b = Executors.newSingleThreadExecutor(new e("ExoPlayer:Loader:" + s, 2));
    }

    public sa(ArrayDeque arrayDeque0, BufferedReader bufferedReader0) {
        this.a = 9;
        super();
        this.c = arrayDeque0;
        this.b = bufferedReader0;
    }

    public sa(ArrayList arrayList0) {
        this.a = 2;
        super();
        this.b = Collections.unmodifiableList(new ArrayList(arrayList0));
        this.c = new long[arrayList0.size() * 2];
        for(int v = 0; v < arrayList0.size(); ++v) {
            Yd yd0 = (Yd)arrayList0.get(v);
            long[] arr_v = (long[])this.c;
            arr_v[v * 2] = yd0.b;
            arr_v[v * 2 + 1] = yd0.c;
        }
        long[] arr_v1 = Arrays.copyOf(((long[])this.c), ((long[])this.c).length);
        this.d = arr_v1;
        Arrays.sort(arr_v1);
    }

    public sa(A6[] arr_a6) {
        this.a = 7;
        O o0 = new O();
        Z0 z00 = new Z0();  // 初始化器: Ljava/lang/Object;-><init>()V
        z00.c = 1.0f;
        z00.d = 1.0f;
        z00.e = y6.e;
        z00.f = y6.e;
        z00.g = y6.e;
        z00.h = y6.e;
        z00.k = A6.a;
        z00.l = A6.a.asShortBuffer();
        z00.m = A6.a;
        z00.b = -1;
        super();
        A6[] arr_a61 = new A6[arr_a6.length + 2];
        this.b = arr_a61;
        System.arraycopy(arr_a6, 0, arr_a61, 0, arr_a6.length);
        this.c = o0;
        this.d = z00;
        arr_a61[arr_a6.length] = o0;
        arr_a61[arr_a6.length + 1] = z00;
    }

    @Override  // i.n.i.b.a.s.e.T4
    public int a() {
        return ((long[])this.d).length;
    }

    @Override  // i.n.i.b.a.s.e.T4
    public int a(long v) {
        long[] arr_v = (long[])this.d;
        int v1 = L7.g(arr_v, v, false);
        return v1 >= arr_v.length ? -1 : v1;
    }

    @Override  // i.n.i.b.a.s.e.T4
    public long a(int v) {
        long[] arr_v = (long[])this.d;
        boolean z = false;
        M7.u(v >= 0);
        if(v < arr_v.length) {
            z = true;
        }
        M7.u(z);
        return arr_v[v];
    }

    @Override  // i.n.i.b.a.s.e.T4
    public List b(long v) {
        List list0 = (List)this.b;
        List list1 = new ArrayList();
        ArrayList arrayList0 = new ArrayList();
        for(int v2 = 0; v2 < list0.size(); ++v2) {
            long[] arr_v = (long[])this.c;
            if(arr_v[v2 * 2] <= v && v < arr_v[v2 * 2 + 1]) {
                Yd yd0 = (Yd)list0.get(v2);
                F3 f30 = yd0.a;
                if(f30.e == -3.402823E+38f) {
                    arrayList0.add(yd0);
                }
                else {
                    ((ArrayList)list1).add(f30);
                }
            }
        }
        Collections.sort(arrayList0, new A0(0));
        for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
            F3 f31 = ((Yd)arrayList0.get(v1)).a;
            ((ArrayList)list1).add(new F3(f31.a, f31.b, f31.c, f31.d, ((float)(-1 - v1)), 1, f31.f, f31.g, f31.h, f31.m, f31.n, f31.i, f31.j, f31.k, f31.l, f31.o, f31.p, f31.q, f31.r));
        }
        return list1;
    }

    @Override  // i.n.i.b.a.s.e.Lb
    public void b() {
        IOException iOException0 = (IOException)this.d;
        if(iOException0 != null) {
            throw iOException0;
        }
        eb eb0 = (eb)this.c;
        if(eb0 != null) {
            IOException iOException1 = eb0.d;
            if(iOException1 != null && eb0.e > eb0.b) {
                throw iOException1;
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.ud
    public void b(r6 r60, U5 u50, G g0) {
        this.d = r60;
        g0.a();
        g0.b();
        ie ie0 = u50.i(g0.d, 5);
        this.b = ie0;
        ie0.a(((u)this.c));
    }

    @Override  // i.n.i.b.a.s.e.ud
    public void c(wb wb0) {
        long v3;
        M7.G(((r6)this.d));
        long v = ((r6)this.d).c();
        if(v == 0x8000000000000001L) {
            return;
        }
        u u0 = (u)this.c;
        if(v != u0.r) {
            ob ob0 = u0.a();
            ob0.o = v;
            u u1 = new u(ob0);
            this.c = u1;
            ((ie)this.b).a(u1);
        }
        int v1 = wb0.d();
        ((ie)this.b).b(v1, wb0);
        ie ie0 = (ie)this.b;
        r6 r60 = (r6)this.d;
        synchronized(r60) {
            long v2 = r60.d;
            if(v2 == 0x8000000000000001L) {
                v3 = r60.b == 0x7FFFFFFFFFFFFFFFL ? 0x8000000000000001L : r60.b;
            }
            else {
                v3 = r60.c + v2;
            }
        }
        ie0.f(v3, 1, v1, 0, null);
    }

    @Override  // i.n.i.b.a.s.e.zd
    public W8 d(d3 d30, p p0, cd cd0, Map map0, d d0) {
        return new W8(map0, d0, d30, p0, cd0, ((Gd)this.b), ((Md)this.c), ((E4)this.d));
    }

    public long e(gb gb0, db db0, int v) {
        Looper looper0 = Looper.myLooper();
        M7.G(looper0);
        this.d = null;
        long v1 = SystemClock.elapsedRealtime();
        eb eb0 = new eb(this, looper0, gb0, db0, v, v1, 0);
        M7.J(((eb)this.c) == null);
        this.c = eb0;
        eb0.b();
        return v1;
    }

    public void f() {
        if(this.a != 0) {
            eb eb0 = (eb)this.c;
            M7.G(eb0);
            eb0.a(false);
            return;
        }
        ((q4)this.b).d(0L, 0L);
    }

    public void g(D0 d00, Uri uri0, Map map0, long v, long v1, v5 v50) {
        D2 d20 = new D2(d00, v, v1);
        this.d = d20;
        if(((q4)this.b) != null) {
            return;
        }
        q4[] arr_q4 = ((Y6)this.c).a(uri0, map0);
        boolean z = true;
        if(arr_q4.length == 1) {
            this.b = arr_q4[0];
            ((q4)this.b).g(v50);
            return;
        }
        for(int v3 = 0; v3 < arr_q4.length; ++v3) {
            q4 q40 = arr_q4[v3];
            try {
                if(q40.e(d20)) {
                    this.b = q40;
                    d20.f = 0;
                    break;
                }
            }
            catch(EOFException unused_ex) {
                M7.J(((q4)this.b) != null || d20.d == v);
                d20.f = 0;
                continue;
            }
            catch(Throwable throwable0) {
                if(((q4)this.b) == null && d20.d != v) {
                    z = false;
                }
                M7.J(z);
                d20.f = 0;
                throw throwable0;
            }
            M7.J(((q4)this.b) != null || d20.d == v);
            d20.f = 0;
        }
        if(((q4)this.b) != null) {
            ((q4)this.b).g(v50);
            return;
        }
        StringBuilder stringBuilder0 = new StringBuilder("None of the available extractors (");
        StringBuilder stringBuilder1 = new StringBuilder();
        for(int v2 = 0; v2 < arr_q4.length; ++v2) {
            stringBuilder1.append(arr_q4[v2].getClass().getSimpleName());
            if(v2 < arr_q4.length - 1) {
                stringBuilder1.append(", ");
            }
        }
        stringBuilder0.append(stringBuilder1.toString());
        stringBuilder0.append(") could read the stream.");
        uri0.getClass();
        throw new xd(stringBuilder0.toString());  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
    }

    public void h(hb hb0) {
        ExecutorService executorService0 = (ExecutorService)this.b;
        eb eb0 = (eb)this.c;
        if(eb0 != null) {
            eb0.a(true);
        }
        if(hb0 != null) {
            executorService0.execute(new t(hb0, 19));
        }
        executorService0.shutdown();
    }

    public boolean i() {
        ArrayDeque arrayDeque0 = (ArrayDeque)this.c;
        if(((String)this.d) == null) {
            if(!arrayDeque0.isEmpty()) {
                String s = (String)arrayDeque0.poll();
                s.getClass();
                this.d = s;
                return true;
            }
            while(true) {
                String s1 = ((BufferedReader)this.b).readLine();
                this.d = s1;
                if(s1 == null) {
                    break;
                }
                String s2 = s1.trim();
                this.d = s2;
                if(s2.isEmpty()) {
                    continue;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public String j() {
        if(!this.i()) {
            throw new NoSuchElementException();
        }
        String s = (String)this.d;
        this.d = null;
        return s;
    }

    public boolean k() {
        q4 q40 = (q4)this.b;
        return q40 instanceof r0 || q40 instanceof q3;
    }

    public boolean l() {
        return ((IOException)this.d) != null;
    }

    public boolean m() {
        return ((eb)this.c) != null;
    }
}

