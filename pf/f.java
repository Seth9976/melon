package pf;

import Sf.b;
import Sf.p;
import Tf.v;
import e.k;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import je.A;
import je.D;
import je.q;
import je.y;
import of.h;
import of.i;
import of.j;
import rf.d;

public final class f implements nf.f {
    public final String[] a;
    public final Set b;
    public final ArrayList c;
    public static final List d;

    // 去混淆评级： 中等(137)
    static {
        List list0 = k.A(new String[]{"kotlin/Any", "kotlin/Nothing", "kotlin/Unit", "kotlin/Throwable", "kotlin/Number", "kotlin/Byte", "kotlin/Double", "kotlin/Float", "kotlin/Int", "kotlin/Long", "kotlin/Short", "kotlin/Boolean", "kotlin/Char", "kotlin/CharSequence", "kotlin/String", "kotlin/Comparable", "kotlin/Enum", "kotlin/Array", "kotlin/ByteArray", "kotlin/DoubleArray", "kotlin/FloatArray", "kotlin/IntArray", "kotlin/LongArray", "kotlin/ShortArray", "kotlin/BooleanArray", "kotlin/CharArray", "kotlin/Cloneable", "kotlin/Annotation", "kotlin/collections/Iterable", "kotlin/collections/MutableIterable", "kotlin/collections/Collection", "kotlin/collections/MutableCollection", "kotlin/collections/List", "kotlin/collections/MutableList", "kotlin/collections/Set", "kotlin/collections/MutableSet", "kotlin/collections/Map", "kotlin/collections/MutableMap", "kotlin/collections/Map.Entry", "kotlin/collections/MutableMap.MutableEntry", "kotlin/collections/Iterator", "kotlin/collections/MutableIterator", "kotlin/collections/ListIterator", "kotlin/collections/MutableListIterator"});
        f.d = list0;
        p p0 = je.p.V0(list0);
        int v = D.N(q.Q(10, p0));
        if(v < 16) {
            v = 16;
        }
        LinkedHashMap linkedHashMap0 = new LinkedHashMap(v);
        Iterator iterator0 = p0.iterator();
        while(((b)iterator0).b.hasNext()) {
            A a0 = (A)((b)iterator0).next();
            linkedHashMap0.put(((String)a0.b), a0.a);
        }
    }

    public f(j j0, String[] arr_s) {
        kotlin.jvm.internal.q.g(arr_s, "strings");
        List list0 = j0.c;
        Set set0 = list0.isEmpty() ? y.a : je.p.T0(list0);
        List list1 = j0.b;
        kotlin.jvm.internal.q.f(list1, "getRecordList(...)");
        ArrayList arrayList0 = new ArrayList();
        arrayList0.ensureCapacity(list1.size());
        for(Object object0: list1) {
            i i0 = (i)object0;
            int v = i0.c;
            for(int v1 = 0; v1 < v; ++v1) {
                arrayList0.add(i0);
            }
        }
        arrayList0.trimToSize();
        super();
        this.a = arr_s;
        this.b = set0;
        this.c = arrayList0;
    }

    @Override  // nf.f
    public final boolean c(int v) {
        return this.b.contains(v);
    }

    @Override  // nf.f
    public final String e(int v) {
        return this.getString(v);
    }

    @Override  // nf.f
    public final String getString(int v) {
        String s;
        i i0 = (i)this.c.get(v);
        int v1 = i0.b;
        if((v1 & 4) == 4) {
            Object object0 = i0.e;
            if(object0 instanceof String) {
                s = (String)object0;
            }
            else {
                String s1 = ((d)object0).r();
                if(((d)object0).i()) {
                    i0.e = s1;
                }
                s = s1;
            }
        }
        else if((v1 & 2) == 2) {
            List list0 = f.d;
            int v2 = i0.d;
            s = v2 < 0 || v2 >= list0.size() ? this.a[v] : ((String)list0.get(v2));
        }
        else {
            s = this.a[v];
        }
        if(i0.g.size() >= 2) {
            List list1 = i0.g;
            kotlin.jvm.internal.q.d(list1);
            Integer integer0 = (Integer)list1.get(0);
            Integer integer1 = (Integer)list1.get(1);
            if(((int)integer0) >= 0 && ((int)integer0) <= ((int)integer1) && ((int)integer1) <= s.length()) {
                s = s.substring(((int)integer0), ((int)integer1));
                kotlin.jvm.internal.q.f(s, "substring(...)");
            }
        }
        if(i0.i.size() >= 2) {
            List list2 = i0.i;
            kotlin.jvm.internal.q.d(list2);
            Integer integer2 = (Integer)list2.get(0);
            Integer integer3 = (Integer)list2.get(1);
            kotlin.jvm.internal.q.d(s);
            s = v.o0(s, ((char)(((int)integer2))), ((char)(((int)integer3))));
        }
        int v3 = (i0.f == null ? h.b : i0.f).ordinal();
        if(v3 != 0) {
            switch(v3) {
                case 1: {
                    kotlin.jvm.internal.q.d(s);
                    s = v.o0(s, '$', '.');
                    break;
                }
                case 2: {
                    if(s.length() >= 2) {
                        s = s.substring(1, s.length() - 1);
                        kotlin.jvm.internal.q.f(s, "substring(...)");
                    }
                    s = v.o0(s, '$', '.');
                    break;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
        kotlin.jvm.internal.q.d(s);
        return s;
    }
}

