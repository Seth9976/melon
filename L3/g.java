package l3;

import I6.V;
import I6.p0;
import android.net.Uri;
import android.util.Pair;
import androidx.media3.common.b;
import b3.q0;
import g3.e;
import g3.f;
import g3.j;
import g3.x;
import i.n.i.b.a.s.e.kc;
import i.n.i.b.a.s.e.l6;
import i3.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kb.D;
import m3.c;
import m3.d;
import v3.o;
import ye.a;

public final class g {
    public final h a;
    public final f b;
    public final f c;
    public final l6 d;
    public final Uri[] e;
    public final b[] f;
    public final c g;
    public final q0 h;
    public final List i;
    public final D j;
    public final l k;
    public boolean l;
    public byte[] m;
    public s3.b n;
    public Uri o;
    public boolean p;
    public o q;
    public long r;
    public boolean s;

    public g(h h0, c c0, Uri[] arr_uri, b[] arr_b, D d0, x x0, l6 l60, List list0, l l0) {
        this.a = h0;
        this.g = c0;
        this.e = arr_uri;
        this.f = arr_b;
        this.d = l60;
        this.i = list0;
        this.k = l0;
        this.j = new D(4);
        this.m = e3.x.f;
        this.r = 0x8000000000000001L;
        f f0 = ((e)d0.b).createDataSource();
        this.b = f0;
        if(x0 != null) {
            f0.r(x0);
        }
        this.c = ((e)d0.b).createDataSource();
        this.h = new q0("", arr_b);
        ArrayList arrayList0 = new ArrayList();
        int v = 0;
        for(int v1 = 0; v1 < arr_uri.length; ++v1) {
            if((arr_b[v1].f & 0x4000) == 0) {
                arrayList0.add(v1);
            }
        }
        int[] arr_v = a.Y(arrayList0);
        l3.f f1 = new l3.f(this.h, arr_v);  // 初始化器: Lv3/c;-><init>(Lb3/q0;[I)V
        b b0 = this.h.d[arr_v[0]];
        while(true) {
            if(v >= f1.b) {
                v = -1;
                break;
            }
            if(f1.d[v] == b0) {
                break;
            }
            ++v;
        }
        f1.g = v;
        this.q = f1;
    }

    public final t3.c[] a(i i0, long v) {
        List list0;
        int v1 = i0 == null ? -1 : this.h.b(i0.d);
        int v2 = this.q.length();
        t3.c[] arr_c = new t3.c[v2];
        for(int v3 = 0; v3 < v2; ++v3) {
            int v4 = this.q.getIndexInTrackGroup(v3);
            Uri uri0 = this.e[v4];
            c c0 = this.g;
            if(c0.e(uri0)) {
                m3.h h0 = c0.b(uri0, false);
                h0.getClass();
                long v5 = h0.h - c0.n;
                Pair pair0 = this.c(i0, v4 != v1, h0, v5, v);
                long v6 = (long)(((Long)pair0.first));
                int v7 = (int)(((Integer)pair0.second));
                V v8 = h0.s;
                V v9 = h0.r;
                int v10 = (int)(v6 - h0.k);
                if(v10 < 0 || v9.size() < v10) {
                    list0 = p0.e;
                }
                else {
                    ArrayList arrayList0 = new ArrayList();
                    if(v10 < v9.size()) {
                        if(v7 != -1) {
                            m3.f f0 = (m3.f)v9.get(v10);
                            if(v7 == 0) {
                                arrayList0.add(f0);
                            }
                            else if(v7 < f0.m.size()) {
                                arrayList0.addAll(f0.m.subList(v7, f0.m.size()));
                            }
                            ++v10;
                        }
                        arrayList0.addAll(v9.subList(v10, v9.size()));
                        v7 = 0;
                    }
                    if(h0.n != 0x8000000000000001L) {
                        if(v7 == -1) {
                            v7 = 0;
                        }
                        if(v7 < v8.size()) {
                            arrayList0.addAll(v8.subList(v7, v8.size()));
                        }
                    }
                    list0 = Collections.unmodifiableList(arrayList0);
                }
                arr_c[v3] = new l3.e(v5, list0);
            }
            else {
                arr_c[v3] = t3.c.R;
            }
        }
        return arr_c;
    }

    public final int b(i i0) {
        int v = i0.o;
        if(v != -1) {
            int v1 = this.h.b(i0.d);
            m3.h h0 = this.g.b(this.e[v1], false);
            h0.getClass();
            V v2 = h0.r;
            int v3 = (int)(i0.j - h0.k);
            if(v3 >= 0) {
                V v4 = v3 >= v2.size() ? h0.s : ((m3.f)v2.get(v3)).m;
                if(v < v4.size()) {
                    d d0 = (d)v4.get(v);
                    if(d0.m) {
                        return 0;
                    }
                    return Objects.equals(Uri.parse(e3.b.z(h0.a, d0.a)), i0.b.a) ? 1 : 2;
                }
                return 2;
            }
        }
        return 1;
    }

    public final Pair c(i i0, boolean z, m3.h h0, long v, long v1) {
        boolean z1 = true;
        int v2 = -1;
        if(i0 != null) {
            long v3 = i0.j;
            int v4 = i0.o;
            if(!z) {
                if(i0.H) {
                    if(v4 == -1) {
                        v3 = v3 == -1L ? -1L : v3 + 1L;
                    }
                    Long long0 = v3;
                    if(v4 != -1) {
                        v2 = v4 + 1;
                    }
                    return new Pair(long0, v2);
                }
                return new Pair(v3, v4);
            }
        }
        V v5 = h0.s;
        long v6 = h0.k;
        V v7 = h0.r;
        long v8 = i0 == null || this.p ? v1 : i0.g;
        if(!h0.o && v8 >= v + h0.u) {
            return new Pair(((long)(v6 + ((long)v7.size()))), -1);
        }
        long v9 = v8 - v;
        Long long1 = v9;
        if(this.g.m && i0 != null) {
            z1 = false;
        }
        int v11 = e3.x.c(v7, long1, z1);
        long v12 = ((long)v11) + v6;
        if(v11 >= 0) {
            m3.f f0 = (m3.f)v7.get(v11);
            V v13 = v9 >= f0.e + f0.c ? v5 : f0.m;
            for(int v10 = 0; v10 < v13.size(); ++v10) {
                d d0 = (d)v13.get(v10);
                if(v9 < d0.e + d0.c) {
                    if(!d0.l) {
                        break;
                    }
                    return v13 == v5 ? new Pair(((long)(v12 + 1L)), v10) : new Pair(v12, v10);
                }
            }
        }
        return new Pair(v12, -1);
    }

    public final l3.d d(Uri uri0, int v, boolean z) {
        if(uri0 == null) {
            return null;
        }
        D d0 = this.j;
        byte[] arr_b = (byte[])((kc)d0.b).remove(uri0);
        if(arr_b != null) {
            byte[] arr_b1 = (byte[])((kc)d0.b).put(uri0, arr_b);
            return null;
        }
        j j0 = new j(uri0, 1, null, Collections.EMPTY_MAP, 0L, -1L, null, 1);
        b b0 = this.f[v];
        int v1 = this.q.getSelectionReason();
        Object object0 = this.q.getSelectionData();
        byte[] arr_b2 = this.m;
        l3.d d1 = new l3.d(this.c, j0, 3, b0, v1, object0, 0x8000000000000001L, 0x8000000000000001L);  // 初始化器: Lt3/a;-><init>(Lg3/f;Lg3/j;ILandroidx/media3/common/b;ILjava/lang/Object;JJ)V
        if(arr_b2 == null) {
            arr_b2 = e3.x.f;
        }
        d1.j = arr_b2;
        return d1;
    }
}

