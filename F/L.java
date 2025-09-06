package F;

import Ce.f;
import Ce.g;
import N0.L;
import N0.M;
import N0.N;
import N0.O;
import N0.a0;
import N0.p;
import N0.q;
import androidx.compose.runtime.O0;
import e.k;
import java.util.List;
import je.x;

public final class l implements M {
    public final r a;

    public l(r r0) {
        this.a = r0;
    }

    @Override  // N0.M
    public final int maxIntrinsicHeight(q q0, List list0, int v) {
        if(list0.isEmpty()) {
            throw new NullPointerException();
        }
        Integer integer0 = ((p)list0.get(0)).d(v);
        int v1 = k.s(list0);
        if(1 <= v1) {
            for(int v2 = 1; true; ++v2) {
                Integer integer1 = ((p)list0.get(v2)).d(v);
                if(integer1.compareTo(integer0) > 0) {
                    integer0 = integer1;
                }
                if(v2 == v1) {
                    break;
                }
            }
        }
        return integer0 == null ? 0 : ((int)integer0);
    }

    @Override  // N0.M
    public final int maxIntrinsicWidth(q q0, List list0, int v) {
        if(list0.isEmpty()) {
            throw new NullPointerException();
        }
        Integer integer0 = ((p)list0.get(0)).N(v);
        int v1 = k.s(list0);
        if(1 <= v1) {
            for(int v2 = 1; true; ++v2) {
                Integer integer1 = ((p)list0.get(v2)).N(v);
                if(integer1.compareTo(integer0) > 0) {
                    integer0 = integer1;
                }
                if(v2 == v1) {
                    break;
                }
            }
        }
        return integer0 == null ? 0 : ((int)integer0);
    }

    @Override  // N0.M
    public final N measure-3p2s80s(O o0, List list0, long v) {
        int v11;
        a0 a01;
        int v8;
        n n0;
        int v1 = list0.size();
        a0[] arr_a0 = new a0[v1];
        int v2 = list0.size();
        long v3 = 0L;
        for(int v4 = 0; true; ++v4) {
            n0 = null;
            if(v4 >= v2) {
                break;
            }
            L l0 = (L)list0.get(v4);
            Object object0 = l0.q();
            if(object0 instanceof n) {
                n0 = (n)object0;
            }
            if(n0 != null && ((Boolean)((O0)n0.a).getValue()).booleanValue()) {
                a0 a00 = l0.O(v);
                long v5 = ((long)a00.b) & 0xFFFFFFFFL | ((long)a00.a) << 0x20;
                arr_a0[v4] = a00;
                v3 = v5;
            }
        }
        int v6 = list0.size();
        for(int v7 = 0; v7 < v6; ++v7) {
            L l1 = (L)list0.get(v7);
            if(arr_a0[v7] == null) {
                arr_a0[v7] = l1.O(v);
            }
        }
        if(o0.u()) {
            v8 = (int)(v3 >> 0x20);
        }
        else {
            if(v1 == 0) {
                a01 = null;
            }
            else {
                a01 = arr_a0[0];
                if(v1 - 1 != 0) {
                    int v9 = a01 == null ? 0 : a01.a;
                    f f0 = new g(1, v1 - 1, 1).b();  // 初始化器: LCe/e;-><init>(III)V
                    while(f0.c) {
                        a0 a02 = arr_a0[f0.nextInt()];
                        int v10 = a02 == null ? 0 : a02.a;
                        if(v9 < v10) {
                            a01 = a02;
                            v9 = v10;
                        }
                    }
                }
            }
            v8 = a01 == null ? 0 : a01.a;
        }
        if(o0.u()) {
            v11 = (int)(v3 & 0xFFFFFFFFL);
        }
        else {
            if(v1 != 0) {
                n0 = arr_a0[0];
                if(v1 - 1 != 0) {
                    int v12 = n0 == null ? 0 : n0.b;
                    f f1 = new g(1, v1 - 1, 1).b();  // 初始化器: LCe/e;-><init>(III)V
                    while(f1.c) {
                        a0 a03 = arr_a0[f1.nextInt()];
                        int v13 = a03 == null ? 0 : a03.b;
                        if(v12 < v13) {
                            n0 = a03;
                            v12 = v13;
                        }
                    }
                }
            }
            v11 = n0 == null ? 0 : n0.b;
        }
        if(!o0.u()) {
            r1.l l2 = new r1.l(((long)v8) << 0x20 | ((long)v11) & 0xFFFFFFFFL);
            ((O0)this.a.b).setValue(l2);
        }
        F.k k0 = new F.k(arr_a0, this, v8, v11);
        return o0.w(v8, v11, x.a, k0);
    }

    @Override  // N0.M
    public final int minIntrinsicHeight(q q0, List list0, int v) {
        if(list0.isEmpty()) {
            throw new NullPointerException();
        }
        Integer integer0 = ((p)list0.get(0)).C(v);
        int v1 = k.s(list0);
        if(1 <= v1) {
            for(int v2 = 1; true; ++v2) {
                Integer integer1 = ((p)list0.get(v2)).C(v);
                if(integer1.compareTo(integer0) > 0) {
                    integer0 = integer1;
                }
                if(v2 == v1) {
                    break;
                }
            }
        }
        return integer0 == null ? 0 : ((int)integer0);
    }

    @Override  // N0.M
    public final int minIntrinsicWidth(q q0, List list0, int v) {
        if(list0.isEmpty()) {
            throw new NullPointerException();
        }
        Integer integer0 = ((p)list0.get(0)).L(v);
        int v1 = k.s(list0);
        if(1 <= v1) {
            for(int v2 = 1; true; ++v2) {
                Integer integer1 = ((p)list0.get(v2)).L(v);
                if(integer1.compareTo(integer0) > 0) {
                    integer0 = integer1;
                }
                if(v2 == v1) {
                    break;
                }
            }
        }
        return integer0 == null ? 0 : ((int)integer0);
    }
}

