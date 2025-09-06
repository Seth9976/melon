package androidx.recyclerview.widget;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public final class u {
    public final ArrayList a;
    public final int[] b;
    public final int[] c;
    public final s d;
    public final int e;
    public final int f;
    public final boolean g;

    public u(s s0, ArrayList arrayList0, int[] arr_v, int[] arr_v1) {
        int v7;
        this.a = arrayList0;
        this.b = arr_v;
        this.c = arr_v1;
        Arrays.fill(arr_v, 0);
        Arrays.fill(arr_v1, 0);
        this.d = s0;
        int v = s0.getOldListSize();
        this.e = v;
        int v1 = s0.getNewListSize();
        this.f = v1;
        this.g = true;
        t t0 = arrayList0.isEmpty() ? null : ((t)arrayList0.get(0));
        if(t0 == null || t0.a != 0 || t0.b != 0) {
            arrayList0.add(0, new t(0, 0, 0));
        }
        arrayList0.add(new t(v, v1, 0));
        for(Object object0: arrayList0) {
            t t1 = (t)object0;
            for(int v2 = 0; v2 < t1.c; ++v2) {
                int v3 = t1.a + v2;
                int v4 = t1.b + v2;
                int v5 = s0.areContentsTheSame(v3, v4) ? 1 : 2;
                arr_v[v3] = v4 << 4 | v5;
                arr_v1[v4] = v3 << 4 | v5;
            }
        }
        if(this.g) {
            int v6 = 0;
            for(Object object1: arrayList0) {
                while(true) {
                    v7 = ((t)object1).a;
                    if(v6 >= v7) {
                        break;
                    }
                    if(arr_v[v6] == 0) {
                        int v8 = arrayList0.size();
                        int v9 = 0;
                        int v10 = 0;
                    label_41:
                        while(v9 < v8) {
                            t t2 = (t)arrayList0.get(v9);
                            while(true) {
                                int v11 = t2.b;
                                if(v10 < v11) {
                                    if(arr_v1[v10] == 0 && s0.areItemsTheSame(v6, v10)) {
                                        int v12 = s0.areContentsTheSame(v6, v10) ? 8 : 4;
                                        arr_v[v6] = v10 << 4 | v12;
                                        arr_v1[v10] = v12 | v6 << 4;
                                        break label_41;
                                    }
                                    ++v10;
                                    continue;
                                }
                                v10 = t2.c + v11;
                                ++v9;
                                continue label_41;
                            }
                        }
                    }
                    ++v6;
                }
                v6 = ((t)object1).c + v7;
            }
        }
    }

    public final void a(a0 a00) {
        s s0;
        i i0 = a00 instanceof i ? ((i)a00) : new i(a00);
        ArrayDeque arrayDeque0 = new ArrayDeque();
        ArrayList arrayList0 = this.a;
        int v = arrayList0.size() - 1;
        int v1 = this.e;
        int v2 = this.f;
        int v3 = v1;
        while(v >= 0) {
            t t0 = (t)arrayList0.get(v);
            int v4 = t0.a;
            int v5 = t0.c;
            int v6 = t0.b;
            while(true) {
                int[] arr_v = this.b;
                s0 = this.d;
                if(v3 <= v4 + v5) {
                    break;
                }
                --v3;
                int v8 = arr_v[v3];
                if((v8 & 12) == 0) {
                    i0.i(v3, 1);
                    --v1;
                }
                else {
                    w w0 = u.b(arrayDeque0, v8 >> 4, false);
                    if(w0 == null) {
                        arrayDeque0.add(new w(v3, v1 - v3 - 1, ((boolean)1)));
                    }
                    else {
                        int v9 = v1 - w0.b - 1;
                        i0.s(v3, v9);
                        if((v8 & 4) == 0) {
                            continue;
                        }
                        i0.q(v9, 1, s0.getChangePayload(v3, v8 >> 4));
                    }
                }
            }
            while(v2 > v6 + v5) {
                --v2;
                int v10 = this.c[v2];
                if((v10 & 12) == 0) {
                    i0.e(v3, 1);
                    ++v1;
                }
                else {
                    w w1 = u.b(arrayDeque0, v10 >> 4, true);
                    if(w1 == null) {
                        arrayDeque0.add(new w(v2, v1 - v3, false));
                    }
                    else {
                        i0.s(v1 - w1.b - 1, v3);
                        if((v10 & 4) == 0) {
                            continue;
                        }
                        i0.q(v3, 1, s0.getChangePayload(v10 >> 4, v2));
                    }
                }
            }
            int v11 = v6;
            int v12 = v4;
            for(int v7 = 0; v7 < v5; ++v7) {
                if((arr_v[v12] & 15) == 2) {
                    i0.q(v12, 1, s0.getChangePayload(v12, v11));
                }
                ++v12;
                ++v11;
            }
            --v;
            v2 = v6;
            v3 = v4;
        }
        i0.a();
    }

    public static w b(ArrayDeque arrayDeque0, int v, boolean z) {
        w w0;
        Iterator iterator0 = arrayDeque0.iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            w0 = (w)object0;
            if(w0.a != v || w0.c != z) {
                continue;
            }
            iterator0.remove();
            goto label_8;
        }
        w0 = null;
    label_8:
        while(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            w w1 = (w)object1;
            if(z) {
                --w1.b;
            }
            else {
                ++w1.b;
            }
        }
        return w0;
    }
}

