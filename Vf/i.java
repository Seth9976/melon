package vf;

import Je.k;
import Me.z;
import Pe.A;
import java.util.ArrayList;
import java.util.List;
import je.n;
import je.p;
import je.w;
import kotlin.jvm.internal.q;

public final class i {
    static {
    }

    public static b a(List list0, z z0, k k0) {
        Iterable iterable0 = p.P0(list0);
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: iterable0) {
            g g0 = i.b(null, object0);
            if(g0 != null) {
                arrayList0.add(g0);
            }
        }
        return z0 != null ? new vf.z(arrayList0, z0.d().r(k0)) : new b(arrayList0, new h(k0, 0));
    }

    public static g b(A a0, Object object0) {
        if(object0 instanceof Byte) {
            return new d(((Number)object0).byteValue());
        }
        if(object0 instanceof Short) {
            return new x(((Number)object0).shortValue());
        }
        if(object0 instanceof Integer) {
            return new l(((Number)object0).intValue());
        }
        if(object0 instanceof Long) {
            return new v(((Number)object0).longValue());
        }
        if(object0 instanceof Character) {
            ((Character)object0).getClass();
            return new e(((Character)object0));  // 初始化器: Lvf/g;-><init>(Ljava/lang/Object;)V
        }
        if(object0 instanceof Float) {
            return new c(((Number)object0).floatValue());
        }
        if(object0 instanceof Double) {
            return new c(((Number)object0).doubleValue());
        }
        if(object0 instanceof Boolean) {
            ((Boolean)object0).getClass();
            return new c(((Boolean)object0));
        }
        if(object0 instanceof String) {
            q.g(((String)object0), "value");
            return new y(((String)object0));  // 初始化器: Lvf/g;-><init>(Ljava/lang/Object;)V
        }
        List list0 = w.a;
        int v = 0;
        if(object0 instanceof byte[]) {
            q.g(((byte[])object0), "<this>");
            if(((byte[])object0).length != 0) {
                if(((byte[])object0).length != 1) {
                    list0 = new ArrayList(((byte[])object0).length);
                    while(v < ((byte[])object0).length) {
                        ((ArrayList)list0).add(((byte)((byte[])object0)[v]));
                        ++v;
                    }
                    return i.a(list0, a0, k.h);
                }
                list0 = e.k.z(((byte)((byte[])object0)[0]));
            }
            return i.a(list0, a0, k.h);
        }
        if(object0 instanceof short[]) {
            q.g(((short[])object0), "<this>");
            if(((short[])object0).length != 0) {
                if(((short[])object0).length != 1) {
                    list0 = new ArrayList(((short[])object0).length);
                    while(v < ((short[])object0).length) {
                        ((ArrayList)list0).add(((short)((short[])object0)[v]));
                        ++v;
                    }
                    return i.a(list0, a0, k.i);
                }
                list0 = e.k.z(((short)((short[])object0)[0]));
            }
            return i.a(list0, a0, k.i);
        }
        if(object0 instanceof int[]) {
            return i.a(n.y0(((int[])object0)), a0, k.j);
        }
        if(object0 instanceof long[]) {
            q.g(((long[])object0), "<this>");
            if(((long[])object0).length != 0) {
                if(((long[])object0).length != 1) {
                    list0 = new ArrayList(((long[])object0).length);
                    while(v < ((long[])object0).length) {
                        ((ArrayList)list0).add(((long)((long[])object0)[v]));
                        ++v;
                    }
                    return i.a(list0, a0, k.l);
                }
                list0 = e.k.z(((long)((long[])object0)[0]));
            }
            return i.a(list0, a0, k.l);
        }
        if(object0 instanceof char[]) {
            q.g(((char[])object0), "<this>");
            if(((char[])object0).length != 0) {
                if(((char[])object0).length != 1) {
                    list0 = new ArrayList(((char[])object0).length);
                    while(v < ((char[])object0).length) {
                        ((ArrayList)list0).add(Character.valueOf(((char[])object0)[v]));
                        ++v;
                    }
                    return i.a(list0, a0, k.g);
                }
                list0 = e.k.z(Character.valueOf(((char[])object0)[0]));
            }
            return i.a(list0, a0, k.g);
        }
        if(object0 instanceof float[]) {
            return i.a(n.x0(((float[])object0)), a0, k.k);
        }
        if(object0 instanceof double[]) {
            q.g(((double[])object0), "<this>");
            if(((double[])object0).length != 0) {
                if(((double[])object0).length != 1) {
                    list0 = new ArrayList(((double[])object0).length);
                    while(v < ((double[])object0).length) {
                        ((ArrayList)list0).add(((double)((double[])object0)[v]));
                        ++v;
                    }
                    return i.a(list0, a0, k.m);
                }
                list0 = e.k.z(((double)((double[])object0)[0]));
            }
            return i.a(list0, a0, k.m);
        }
        if(object0 instanceof boolean[]) {
            q.g(((boolean[])object0), "<this>");
            if(((boolean[])object0).length != 0) {
                if(((boolean[])object0).length != 1) {
                    list0 = new ArrayList(((boolean[])object0).length);
                    while(v < ((boolean[])object0).length) {
                        ((ArrayList)list0).add(Boolean.valueOf(((boolean[])object0)[v]));
                        ++v;
                    }
                    return i.a(list0, a0, k.f);
                }
                list0 = e.k.z(Boolean.valueOf(((boolean[])object0)[0]));
            }
            return i.a(list0, a0, k.f);
        }
        return object0 == null ? new vf.w(null) : null;  // 初始化器: Lvf/g;-><init>(Ljava/lang/Object;)V
    }
}

