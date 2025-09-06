package q1;

import A1.f;
import N0.S;
import P0.A0;
import P0.I;
import P0.d0;
import P0.j0;
import P0.q0;
import P0.v;
import Tf.l;
import Tf.n;
import Tf.o;
import h7.u0;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import je.p;
import je.u;
import je.w;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import q0.a;
import q0.b;
import r1.k;

public abstract class h {
    public static final k a;
    public static final n b;
    public static final n c;

    static {
        h.a = new k(0, 0, 0, 0);
        h.b = new n("(\\d+)|([,])|([*])|([:])|L|(P\\([^)]*\\))|(C(\\(([^)]*)\\))?)|@");
        h.c = new n("(\\d+)|,|[!P()]|:([^,!)]+)");
    }

    public static final Field a(Class class0, String s) {
        Field field0;
        Field[] arr_field = class0.getDeclaredFields();
        for(int v = 0; true; ++v) {
            field0 = null;
            if(v >= arr_field.length) {
                break;
            }
            Field field1 = arr_field[v];
            if(q.b(field1.getName(), s)) {
                field0 = field1;
                break;
            }
        }
        if(field0 != null) {
            field0.setAccessible(true);
            return field0;
        }
        return null;
    }

    public static final c b(a a0) {
        b b0 = (b)p.l0(a0.d());
        return b0 != null ? h.c(b0, null) : q1.b.h;
    }

    public static final c c(b b0, i i0) {
        List list6;
        List list5;
        int v28;
        List list4;
        ArrayList arrayList9;
        List list3;
        j j2;
        String s14;
        Object object15;
        Field field3;
        int v26;
        ArrayList arrayList8;
        int v25;
        int v24;
        Object object12;
        Object object9;
        String s12;
        k k6;
        j j1;
        ArrayList arrayList7;
        j j0;
        k k2;
        List list2;
        Object object5;
        List list1;
        Object object4;
        boolean z;
        i i1;
        String s9;
        int v15;
        int v10;
        q1.k k1;
        int v5;
        int v4;
        Integer integer2;
        Integer integer1;
        Integer integer0;
        int v3;
        Object object1;
        Object object0 = b0.getKey();
        String s = b0.b();
        w w0 = w.a;
        if(s == null) {
        label_163:
            i1 = null;
        }
        else {
            String s1 = null;
            H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
            h0.a = n.a(h.b, s);
            ArrayList arrayList0 = new ArrayList();
            String s2 = null;
            int v = -1;
            List list0 = null;
            int v1 = 0;
            int v2 = 0;
            while(true) {
                object1 = h0.a;
                if(object1 == null) {
                    goto label_151;
                }
                Tf.k k0 = ((l)object1).c;
                if(k0.a(1) != null || h.e(((l)object1), "@")) {
                    try {
                        l l0 = (l)h0.a;
                        if(l0 != null && l0.c.a(1) != null) {
                            String s3 = (String)((Tf.j)l0.a()).get(1);
                            try {
                                v3 = Integer.parseInt(s3);
                            }
                            catch(NumberFormatException unused_ex) {
                                throw new g();  // 初始化器: Ljava/lang/Exception;-><init>()V
                            }
                            integer0 = (int)(v3 + 1);
                            l0 = h.k(h0);
                        }
                        else {
                            integer0 = null;
                        }
                        if(l0 == null || !h.e(l0, "@")) {
                            integer1 = null;
                            integer2 = null;
                            goto label_49;
                        }
                        else {
                            l l1 = h.k(h0);
                            if(l1 != null && l1.c.a(1) != null) {
                                String s4 = (String)((Tf.j)l1.a()).get(1);
                                try {
                                    v4 = Integer.parseInt(s4);
                                }
                                catch(NumberFormatException unused_ex) {
                                    throw new g();  // 初始化器: Ljava/lang/Exception;-><init>()V
                                }
                                integer2 = v4;
                                l l2 = h.k(h0);
                                if(l2 == null || !h.e(l2, "L")) {
                                    integer1 = null;
                                    goto label_49;
                                }
                                else {
                                    l l3 = h.k(h0);
                                    if(l3 != null && l3.c.a(1) != null) {
                                        String s5 = (String)((Tf.j)l3.a()).get(1);
                                        try {
                                            v5 = Integer.parseInt(s5);
                                        }
                                        catch(NumberFormatException unused_ex) {
                                            throw new g();  // 初始化器: Ljava/lang/Exception;-><init>()V
                                        }
                                        integer1 = v5;
                                    label_49:
                                        if(integer0 != null && integer2 != null && integer1 != null) {
                                            k1 = new q1.k(integer0, integer2, integer1);
                                            goto label_53;
                                        }
                                    }
                                }
                            }
                        }
                    label_52:
                        k1 = null;
                    }
                    catch(g unused_ex) {
                        goto label_52;
                    }
                label_53:
                    if(k1 != null) {
                        arrayList0.add(k1);
                    }
                    goto label_134;
                }
                if(h.e(((l)object1), "C")) {
                    if(v1 != 0) {
                        v2 = 1;
                    }
                    h.k(h0);
                }
                else if(k0.a(6) == null) {
                    goto label_68;
                }
                else {
                    if(v1 != 0) {
                        v2 = 1;
                    }
                    s2 = (String)((Tf.j)((l)object1).a()).get(8);
                    h.k(h0);
                }
                v1 = 1;
                goto label_134;
            label_68:
                if(k0.a(5) != null) {
                    String s6 = h.d(((l)object1));
                    H h1 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                    h1.a = n.a(h.c, s6);
                    ArrayList arrayList1 = e.k.C(new Integer[]{0, 1, 2, 3});
                    int v6 = arrayList1.size() - 1;
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        h.f(h1, "P");
                        h.f(h1, "(");
                        while(!h.i(h1, ")")) {
                            if(h.i(h1, "!")) {
                                h.j(h1);
                                int v11 = h.h(h1);
                                int v12 = arrayList2.size() + v11 - v6;
                                if(v12 > 0) {
                                    if(v12 < 4) {
                                        v12 = 4;
                                    }
                                    for(int v13 = 0; v13 < v12; ++v13) {
                                        arrayList1.add(((int)(v13 + v6 + 1)));
                                    }
                                    v6 += v12;
                                }
                                for(int v14 = 0; v14 < v11; ++v14) {
                                    arrayList2.add(new e(((Number)p.k0(arrayList1)).intValue(), null));
                                    arrayList1.remove(0);
                                }
                            }
                            else if(h.i(h1, ",")) {
                                h.j(h1);
                            }
                            else {
                                int v7 = h.h(h1);
                                l l4 = (l)h1.a;
                                arrayList2.add(new e(v7, (l4 == null || l4.c.a(2) == null ? null : h.g(h1))));
                                int v8 = v7 - v6;
                                if(v8 > 0) {
                                    if(v8 < 4) {
                                        v8 = 4;
                                    }
                                    for(int v9 = 0; v9 < v8; ++v9) {
                                        arrayList1.add(((int)(v9 + v6 + 1)));
                                    }
                                    v10 = v7;
                                    v6 += v8;
                                }
                                else {
                                    v10 = v7;
                                }
                                arrayList1.remove(Integer.valueOf(v10));
                            }
                        }
                        h.f(h1, ")");
                        while(arrayList1.size() > 0) {
                            arrayList2.add(new e(((Number)p.k0(arrayList1)).intValue(), null));
                            arrayList1.remove(0);
                        }
                    }
                    catch(g | NumberFormatException unused_ex) {
                        list0 = w0;
                        goto label_133;
                    }
                    list0 = arrayList2;
                    goto label_133;
                }
                if(h.e(((l)object1), "*")) {
                    v = arrayList0.size();
                    h.k(h0);
                    goto label_134;
                }
                else if(h.e(((l)object1), ",")) {
                label_133:
                    h.k(h0);
                label_134:
                    if(((l)object1).equals(h0.a)) {
                        goto label_163;
                    }
                    else {
                        continue;
                    }
                }
                else {
                    break;
                }
                goto label_164;
            }
            if(k0.a(4) == null) {
                v15 = -1;
                goto label_152;
            label_151:
                v15 = -1;
            }
            else {
                String s7 = s.substring(((l)object1).b().b + 1);
                q.f(s7, "substring(...)");
                String s8 = o.Z0(s7, "#", "");
                if(s8.length() > 0) {
                    s7 = o.V0(s7, P4.a.K(0, s7.length() - s8.length() - 1));
                    try {
                        u0.l(36);
                        v15 = Integer.parseInt(s8, 36);
                    }
                    catch(NumberFormatException unused_ex) {
                        try {
                            throw new g();  // 初始化器: Ljava/lang/Exception;-><init>()V
                        }
                        catch(NumberFormatException unused_ex) {
                            goto label_146;
                        }
                    }
                }
                else {
                label_146:
                    v15 = -1;
                }
                s1 = s7;
            }
        label_152:
            if(s1 != null) {
                s9 = s1;
            }
            else if(i0 != null) {
                s9 = i0.b;
            }
            else {
                s9 = null;
            }
            if(s1 == null && i0 != null) {
                v15 = i0.c;
            }
            i1 = new i(s2, s9, v15, arrayList0, v, list0, ((boolean)v1), ((boolean)v2));
        }
    label_164:
        Object object2 = b0.getNode();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        u.U(arrayList3, b0.getData());
        for(Object object3: b0.d()) {
            arrayList4.add(h.c(((b)object3), i1));
        }
        if(object2 instanceof I) {
            d0 d00 = ((I)object2).b0;
            A0 a00 = (A0)d00.e;
            g0.e e0 = (g0.e)d00.g;
            if(e0 == null) {
                z = true;
                object4 = object2;
                list1 = w0;
            }
            else {
                g0.e e1 = new g0.e(new S[e0.c]);
                r0.p p0 = (r0.p)d00.f;
                int v16 = 0;
                while(p0 != null && p0 != a00) {
                    j0 j00 = p0.getCoordinator$ui_release();
                    if(j00 == null) {
                        throw new IllegalArgumentException("getModifierInfo called on node with no coordinator");
                    }
                    q0 q00 = j00.b0;
                    q0 q01 = ((v)d00.c).b0;
                    r0.p p1 = p0.getChild$ui_release();
                    if(p1 == a00) {
                        object5 = object2;
                        if(p0.getCoordinator$ui_release() != p1.getCoordinator$ui_release()) {
                            goto label_197;
                        }
                    }
                    else {
                        object5 = object2;
                    }
                    q01 = null;
                label_197:
                    if(q00 == null) {
                        q00 = q01;
                    }
                    e1.b(new S(((r0.q)e0.a[v16]), j00, q00));
                    p0 = p0.getChild$ui_release();
                    ++v16;
                    object2 = object5;
                }
                z = true;
                object4 = object2;
                list1 = e1.f();
            }
            list2 = list1;
        }
        else {
            z = false;
            object4 = object2;
            list2 = w0;
        }
        if(z) {
            v v17 = (v)((I)object4).b0.c;
            if(!((I)object4).H() || !v17.h()) {
                k2 = new k(0, 0, ((I)object4).c0.p.a, ((I)object4).c0.p.b);
            }
            else {
                long v18 = v17.D(0L);
                long v19 = v17.c;
                int v20 = ye.a.V(Float.intBitsToFloat(((int)(v18 >> 0x20))));
                int v21 = ye.a.V(Float.intBitsToFloat(((int)(v18 & 0xFFFFFFFFL))));
                k2 = new k(v20, v21, ((int)(v19 >> 0x20)) + v20, ((int)(v19 & 0xFFFFFFFFL)) + v21);
            }
        }
        else {
            k2 = h.a;
            if(!arrayList4.isEmpty()) {
                ArrayList arrayList5 = new ArrayList(je.q.Q(10, arrayList4));
                for(Object object6: arrayList4) {
                    arrayList5.add(((c)object6).e);
                }
                Iterator iterator2 = arrayList5.iterator();
                if(!iterator2.hasNext()) {
                    throw new UnsupportedOperationException("Empty collection can\'t be reduced.");
                }
                k k3 = iterator2.next();
                while(iterator2.hasNext()) {
                    Object object7 = iterator2.next();
                    k k4 = (k)object7;
                    if(!q.b(k4, k2)) {
                        if(!q.b(k3, k2)) {
                            k4 = new k(Math.min(k4.a, k3.a), Math.min(k4.b, k3.b), Math.max(k4.c, k3.c), Math.max(k4.d, k3.d));
                        }
                        k3 = k4;
                    }
                }
                k2 = k3;
            }
        }
        if(i1 == null || i1.g != 1 || i0 == null) {
            arrayList7 = arrayList3;
            j1 = null;
        }
        else {
            ArrayList arrayList6 = i0.d;
            if(i0.h >= arrayList6.size()) {
                int v22 = i0.e;
                if(v22 >= 0) {
                    i0.h = v22;
                }
            }
            if(i0.h < arrayList6.size()) {
                int v23 = i0.h;
                i0.h = v23 + 1;
                q1.k k5 = (q1.k)arrayList6.get(v23);
                j0 = new j(((int)k5.a), ((int)k5.b), ((int)k5.c), i0.c, i0.b);
            }
            else {
                j0 = null;
            }
            arrayList7 = arrayList3;
            j1 = j0;
        }
        if(object4 != null) {
            return new d(object0, object4, k2, arrayList7, list2, arrayList4);
        }
        Object object8 = object0;
        String s10 = i1 == null ? null : i1.a;
        String s11 = i1 == null ? null : i1.a;
        if(s11 == null || s11.length() == 0 || k2.d - k2.b <= 0 && k2.c - k2.a <= 0) {
            k6 = k2;
            s12 = s10;
            object9 = null;
        }
        else {
            k6 = k2;
            s12 = s10;
            object9 = b0.e();
        }
        if(!arrayList7.isEmpty()) {
            Object object10 = null;
            for(Object object11: arrayList7) {
                if(object11 != null && Tf.v.i0(object11.getClass().getName(), ".RecomposeScopeImpl", false)) {
                    object10 = object11;
                    break;
                }
            }
            if(object10 != null) {
                try {
                    Field field0 = h.a(object10.getClass(), "block");
                    if(field0 != null) {
                        object12 = field0.get(object10);
                        if(object12 != null) {
                            Class class0 = object12.getClass();
                            Field field1 = h.a(class0, "$$default");
                            Field field2 = h.a(class0, "$$changed");
                            if(field1 == null) {
                                v24 = 0;
                            }
                            else {
                                Object object13 = field1.get(object12);
                                q.e(object13, "null cannot be cast to non-null type kotlin.Int");
                                v24 = (int)(((Integer)object13));
                            }
                            if(field2 == null) {
                                v25 = 0;
                            }
                            else {
                                Object object14 = field2.get(object12);
                                q.e(object14, "null cannot be cast to non-null type kotlin.Int");
                                v25 = (int)(((Integer)object14));
                            }
                            Field[] arr_field = class0.getDeclaredFields();
                            arrayList8 = new ArrayList();
                            v26 = 0;
                            while(true) {
                            label_307:
                                if(v26 >= arr_field.length) {
                                    goto label_320;
                                }
                                field3 = arr_field[v26];
                                object15 = object8;
                                goto label_310;
                            }
                        }
                    }
                }
                catch(Throwable unused_ex) {
                }
                object15 = object8;
                s14 = s12;
                j2 = j1;
                return new q1.a(object15, s14, k6, j2, object9, w0, arrayList7, arrayList4);
                try {
                label_310:
                    String s13 = field3.getName();
                    s14 = s12;
                    j2 = j1;
                }
                catch(Throwable unused_ex) {
                    s14 = s12;
                    j2 = j1;
                    return new q1.a(object15, s14, k6, j2, object9, w0, arrayList7, arrayList4);
                }
                try {
                    if(Tf.v.r0(s13, "$", false) && !Tf.v.r0(field3.getName(), "$$", false) && !Tf.v.r0(field3.getName(), "$jacoco", false)) {
                        arrayList8.add(field3);
                    }
                    ++v26;
                    s12 = s14;
                    j1 = j2;
                    object8 = object15;
                    goto label_307;
                label_320:
                    object15 = object8;
                    s14 = s12;
                    j2 = j1;
                    list3 = p.J0(arrayList8, new f(15));
                    arrayList9 = new ArrayList();
                    if(i1 == null) {
                        list4 = w0;
                    }
                    else {
                        list4 = i1.f;
                        if(list4 == null) {
                            list4 = w0;
                        }
                    }
                    int v27 = list3.size();
                    v28 = 0;
                    while(true) {
                    label_333:
                        if(v28 >= v27) {
                            return new q1.a(object15, s14, k6, j2, object9, arrayList9, arrayList7, arrayList4);
                        }
                        e e2 = v28 >= list4.size() ? new e(v28, null) : ((e)list4.get(v28));
                        if(e2.a < list3.size()) {
                            Field field4 = (Field)list3.get(e2.a);
                            field4.setAccessible(true);
                            Object object16 = field4.get(object12);
                            boolean z1 = (1 << v28 & v24) != 0;
                            int v29 = v28 * 3 + 1;
                            int v30 = (7 << v29 & v25) >> v29;
                            list5 = list3;
                            list6 = list4;
                            String s15 = field4.getName().substring(1);
                            q.f(s15, "substring(...)");
                            arrayList9.add(new q1.f(s15, object16, z1, (v30 & 3) == 3, (v30 & 3) == 0 && !z1, e2.b, (v30 & 4) == 0));
                        }
                        else {
                            list5 = list3;
                            list6 = list4;
                        }
                        break;
                    }
                }
                catch(Throwable unused_ex) {
                    return new q1.a(object15, s14, k6, j2, object9, w0, arrayList7, arrayList4);
                }
                ++v28;
                list3 = list5;
                list4 = list6;
                goto label_333;
            }
        }
        try {
            object15 = object8;
        }
        catch(Throwable unused_ex) {
            object15 = object8;
            s14 = s12;
            j2 = j1;
            return new q1.a(object15, s14, k6, j2, object9, w0, arrayList7, arrayList4);
        }
        s14 = s12;
        j2 = j1;
        return new q1.a(object15, s14, k6, j2, object9, w0, arrayList7, arrayList4);
    }

    public static final String d(l l0) {
        return (String)((Tf.j)l0.a()).get(0);
    }

    public static final boolean e(l l0, String s) {
        return q.b(h.d(l0), s);
    }

    public static final void f(H h0, String s) {
        l l0 = (l)h0.a;
        if(l0 == null || !q.b(h.d(l0), s)) {
            throw new g();  // 初始化器: Ljava/lang/Exception;-><init>()V
        }
        h.j(h0);
    }

    public static final String g(H h0) {
        l l0 = (l)h0.a;
        if(l0 == null || l0.c.a(2) == null) {
            throw new g();  // 初始化器: Ljava/lang/Exception;-><init>()V
        }
        h.j(h0);
        String s = h.d(l0).substring(1);
        q.f(s, "substring(...)");
        if(Tf.v.r0(s, "c#", false)) {
            String s1 = s.substring(2);
            q.f(s1, "substring(...)");
            return "androidx.compose." + s1;
        }
        return s;
    }

    public static final int h(H h0) {
        l l0 = (l)h0.a;
        if(l0 != null && l0.c.a(1) != null) {
            h.j(h0);
            String s = h.d(l0);
            try {
                return Integer.parseInt(s);
            }
            catch(NumberFormatException unused_ex) {
                throw new g();  // 初始化器: Ljava/lang/Exception;-><init>()V
            }
        }
        throw new g();  // 初始化器: Ljava/lang/Exception;-><init>()V
    }

    public static final boolean i(H h0, String s) {
        l l0 = (l)h0.a;
        return l0 == null || q.b(h.d(l0), s);
    }

    public static final void j(H h0) {
        l l0 = (l)h0.a;
        if(l0 != null) {
            h0.a = l0.c();
        }
        l l1 = (l)h0.a;
    }

    public static final l k(H h0) {
        l l0 = (l)h0.a;
        if(l0 != null) {
            h0.a = l0.c();
        }
        return (l)h0.a;
    }
}

