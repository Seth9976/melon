package androidx.media3.exoplayer;

import android.graphics.Matrix;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import b3.p0;
import d3.g;
import e3.t;
import i3.e;
import i3.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import k3.j;
import s3.C;
import s3.Y;
import s3.r;
import wa.a;
import z6.d;
import z6.f;
import z6.i;
import z6.o;
import z6.q;
import z6.x;

public final class a0 {
    public boolean a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final Object g;
    public final Object h;
    public final Object i;
    public final Object j;
    public Object k;
    public Object l;

    public a0() {
        this.b = new x[4];
        this.c = new Matrix[4];
        this.d = new Matrix[4];
        this.e = new PointF();
        this.f = new Path();
        this.g = new Path();
        this.h = new x();
        this.i = new float[2];
        this.j = new float[2];
        this.k = new Path();
        this.l = new Path();
        this.a = true;
        for(int v = 0; v < 4; ++v) {
            ((x[])this.b)[v] = new x();
            ((Matrix[])this.c)[v] = new Matrix();
            ((Matrix[])this.d)[v] = new Matrix();
        }
    }

    public a0(H h0, e e0, t t0, l l0) {
        this.b = l0;
        this.g = h0;
        this.k = new Y();
        this.d = new IdentityHashMap();
        this.e = new HashMap();
        this.c = new ArrayList();
        this.i = e0;
        this.j = t0;
        this.f = new HashMap();
        this.h = new HashSet();
    }

    public p0 a(int v, ArrayList arrayList0, Y y0) {
        ArrayList arrayList1 = (ArrayList)this.c;
        if(!arrayList0.isEmpty()) {
            this.k = y0;
            for(int v1 = v; v1 < arrayList0.size() + v; ++v1) {
                Z z0 = (Z)arrayList0.get(v1 - v);
                if(v1 > 0) {
                    Z z1 = (Z)arrayList1.get(v1 - 1);
                    int v2 = z1.d;
                    z0.d = z1.a.o.e.o() + v2;
                }
                else {
                    z0.d = 0;
                }
                z0.e = false;
                z0.c.clear();
                int v3 = z0.a.o.e.o();
                for(int v4 = v1; v4 < arrayList1.size(); ++v4) {
                    Z z2 = (Z)arrayList1.get(v4);
                    z2.d += v3;
                }
                arrayList1.add(v1, z0);
                ((HashMap)this.e).put(z0.b, z0);
                if(this.a) {
                    this.g(z0);
                    if(((IdentityHashMap)this.d).isEmpty()) {
                        ((HashSet)this.h).add(z0);
                    }
                    else {
                        androidx.media3.exoplayer.Y y1 = (androidx.media3.exoplayer.Y)((HashMap)this.f).get(z0);
                        if(y1 != null) {
                            y1.a.c(y1.b);
                        }
                    }
                }
            }
        }
        return this.c();
    }

    public void b(o o0, float f, RectF rectF0, a a0, Path path0) {
        f f4;
        int v1;
        g g0;
        d d0;
        Matrix[] arr_matrix = (Matrix[])this.d;
        float[] arr_f = (float[])this.i;
        x[] arr_x = (x[])this.b;
        Matrix[] arr_matrix1 = (Matrix[])this.c;
        path0.rewind();
        Path path1 = (Path)this.f;
        path1.rewind();
        Path path2 = (Path)this.g;
        path2.rewind();
        path2.addRect(rectF0, Path.Direction.CW);
        for(int v = 0; v < 4; v = v1) {
            PointF pointF0 = (PointF)this.e;
            switch(v) {
                case 1: {
                    d0 = o0.g;
                    break;
                }
                case 2: {
                    d0 = o0.h;
                    break;
                }
                default: {
                    d0 = v == 3 ? o0.e : o0.f;
                }
            }
            switch(v) {
                case 1: {
                    g0 = o0.c;
                    break;
                }
                case 2: {
                    g0 = o0.d;
                    break;
                }
                case 3: {
                    g0 = o0.a;
                    break;
                }
                default: {
                    g0 = o0.b;
                }
            }
            x x0 = arr_x[v];
            g0.getClass();
            g0.L(x0, f, d0.a(rectF0));
            float f1 = (float)((v + 1) % 4 * 90);
            arr_matrix1[v].reset();
            switch(v) {
                case 1: {
                    v1 = 2;
                    pointF0.set(rectF0.right, rectF0.bottom);
                    break;
                }
                case 2: {
                    v1 = 3;
                    pointF0.set(rectF0.left, rectF0.bottom);
                    break;
                }
                case 3: {
                    v1 = 4;
                    pointF0.set(rectF0.left, rectF0.top);
                    break;
                }
                default: {
                    v1 = v + 1;
                    pointF0.set(rectF0.right, rectF0.top);
                }
            }
            arr_matrix1[v].setTranslate(pointF0.x, pointF0.y);
            arr_matrix1[v].preRotate(f1);
            x x1 = arr_x[v];
            arr_f[0] = x1.c;
            arr_f[1] = x1.d;
            arr_matrix1[v].mapPoints(arr_f);
            arr_matrix[v].reset();
            arr_matrix[v].setTranslate(arr_f[0], arr_f[1]);
            arr_matrix[v].preRotate(f1);
        }
        for(int v2 = 0; v2 < 4; ++v2) {
            x x2 = arr_x[v2];
            arr_f[0] = x2.a;
            arr_f[1] = x2.b;
            arr_matrix1[v2].mapPoints(arr_f);
            if(v2 == 0) {
                path0.moveTo(arr_f[0], arr_f[1]);
            }
            else {
                path0.lineTo(arr_f[0], arr_f[1]);
            }
            arr_x[v2].c(arr_matrix1[v2], path0);
            if(a0 != null) {
                x x3 = arr_x[v2];
                Matrix matrix0 = arr_matrix1[v2];
                x3.getClass();
                ((i)a0.a).d.set(v2, false);
                x3.b(x3.f);
                Matrix matrix1 = new Matrix(matrix0);
                ((i)a0.a).b[v2] = new q(new ArrayList(x3.h), matrix1);
            }
            Path path3 = (Path)this.k;
            x x4 = (x)this.h;
            int v3 = (v2 + 1) % 4;
            x x5 = arr_x[v2];
            arr_f[0] = x5.c;
            arr_f[1] = x5.d;
            arr_matrix1[v2].mapPoints(arr_f);
            x x6 = arr_x[v3];
            ((float[])this.j)[0] = x6.a;
            ((float[])this.j)[1] = x6.b;
            arr_matrix1[v3].mapPoints(((float[])this.j));
            float f2 = Math.max(((float)Math.hypot(arr_f[0] - ((float[])this.j)[0], arr_f[1] - ((float[])this.j)[1])) - 0.001f, 0.0f);
            x x7 = arr_x[v2];
            arr_f[0] = x7.c;
            arr_f[1] = x7.d;
            arr_matrix1[v2].mapPoints(arr_f);
            float f3 = v2 == 1 || v2 == 3 ? Math.abs(rectF0.centerX() - arr_f[0]) : Math.abs(rectF0.centerY() - arr_f[1]);
            x4.e(0.0f, 0.0f, 270.0f, 0.0f);
            switch(v2) {
                case 1: {
                    f4 = o0.k;
                    break;
                }
                case 2: {
                    f4 = o0.l;
                    break;
                }
                case 3: {
                    f4 = o0.i;
                    break;
                }
                default: {
                    f4 = o0.j;
                }
            }
            f4.l(f2, f3, f, x4);
            path3.reset();
            x4.c(arr_matrix[v2], path3);
            if(!this.a || !f4.d() && !this.f(path3, v2) && !this.f(path3, v3)) {
                x4.c(arr_matrix[v2], path0);
            }
            else {
                path3.op(path3, path2, Path.Op.DIFFERENCE);
                arr_f[0] = x4.a;
                arr_f[1] = x4.b;
                arr_matrix[v2].mapPoints(arr_f);
                path1.moveTo(arr_f[0], arr_f[1]);
                x4.c(arr_matrix[v2], path1);
            }
            if(a0 != null) {
                Matrix matrix2 = arr_matrix[v2];
                ((i)a0.a).d.set(v2 + 4, false);
                x4.b(x4.f);
                Matrix matrix3 = new Matrix(matrix2);
                ((i)a0.a).c[v2] = new q(new ArrayList(x4.h), matrix3);
            }
        }
        path0.close();
        path1.close();
        if(!path1.isEmpty()) {
            path0.op(path1, Path.Op.UNION);
        }
    }

    public p0 c() {
        ArrayList arrayList0 = (ArrayList)this.c;
        if(arrayList0.isEmpty()) {
            return p0.a;
        }
        int v1 = 0;
        for(int v = 0; v < arrayList0.size(); ++v) {
            Z z0 = (Z)arrayList0.get(v);
            z0.d = v1;
            v1 += z0.a.o.e.o();
        }
        return new g0(arrayList0, ((Y)this.k));
    }

    public void d() {
        Iterator iterator0 = ((HashSet)this.h).iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            Z z0 = (Z)object0;
            if(z0.c.isEmpty()) {
                androidx.media3.exoplayer.Y y0 = (androidx.media3.exoplayer.Y)((HashMap)this.f).get(z0);
                if(y0 != null) {
                    y0.a.c(y0.b);
                }
                iterator0.remove();
            }
        }
    }

    public void e(Z z0) {
        if(z0.e && z0.c.isEmpty()) {
            androidx.media3.exoplayer.Y y0 = (androidx.media3.exoplayer.Y)((HashMap)this.f).remove(z0);
            y0.getClass();
            y0.a.o(y0.b);
            y0.a.r(y0.c);
            y0.a.q(y0.c);
            ((HashSet)this.h).remove(z0);
        }
    }

    public boolean f(Path path0, int v) {
        Path path1 = (Path)this.l;
        path1.reset();
        ((x[])this.b)[v].c(((Matrix[])this.c)[v], path1);
        RectF rectF0 = new RectF();
        path0.computeBounds(rectF0, true);
        path1.computeBounds(rectF0, true);
        path0.op(path1, Path.Op.INTERSECT);
        path0.computeBounds(rectF0, true);
        return !rectF0.isEmpty() || rectF0.width() > 1.0f && rectF0.height() > 1.0f;
    }

    public void g(Z z0) {
        Q q0 = new Q(this);
        X x0 = new X(this, z0);
        androidx.media3.exoplayer.Y y0 = new androidx.media3.exoplayer.Y(z0.a, q0, x0);
        ((HashMap)this.f).put(z0, y0);
        Handler handler0 = new Handler(e3.x.u(), null);
        z0.a.getClass();
        z0.a.c.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList0 = (CopyOnWriteArrayList)z0.a.c.c;
        C c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
        c0.a = handler0;
        c0.b = x0;
        copyOnWriteArrayList0.add(c0);
        Handler handler1 = new Handler(e3.x.u(), null);
        z0.a.d.getClass();
        j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j0.a = handler1;
        j0.b = x0;
        z0.a.d.c.add(j0);
        z0.a.k(q0, ((g3.x)this.l), ((l)this.b));
    }

    public void h(s3.x x0) {
        Z z0 = (Z)((IdentityHashMap)this.d).remove(x0);
        z0.getClass();
        z0.a.n(x0);
        z0.c.remove(((r)x0).a);
        if(!((IdentityHashMap)this.d).isEmpty()) {
            this.d();
        }
        this.e(z0);
    }

    public void i(int v, int v1) {
        ArrayList arrayList0 = (ArrayList)this.c;
        for(int v2 = v1 - 1; v2 >= v; --v2) {
            Z z0 = (Z)arrayList0.remove(v2);
            ((HashMap)this.e).remove(z0.b);
            int v3 = -z0.a.o.e.o();
            for(int v4 = v2; v4 < arrayList0.size(); ++v4) {
                Z z1 = (Z)arrayList0.get(v4);
                z1.d += v3;
            }
            z0.e = true;
            if(this.a) {
                this.e(z0);
            }
        }
    }
}

