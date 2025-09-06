package Tf;

import e.k;
import h7.u0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;
import y5.a;

public abstract class p extends a {
    public static String a0(String s, String s1) [...] // 潜在的解密器

    public static String b0(String s) {
        return p.a0(s, "    ");
    }

    public static String c0(String s) {
        int v;
        List list0;
        q.g(s, "<this>");
        h h0 = new h(s);
        if(h0.hasNext()) {
            Object object0 = h0.next();
            if(h0.hasNext()) {
                ArrayList arrayList0 = new ArrayList();
                arrayList0.add(object0);
                while(h0.hasNext()) {
                    arrayList0.add(h0.next());
                }
                list0 = arrayList0;
            }
            else {
                list0 = k.z(object0);
            }
        }
        else {
            list0 = w.a;
        }
        ArrayList arrayList1 = new ArrayList();
        for(Object object1: list0) {
            if(!o.H0(((String)object1))) {
                arrayList1.add(object1);
            }
        }
        ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList1));
        Iterator iterator1 = arrayList1.iterator();
        while(true) {
            v = 0;
            if(!iterator1.hasNext()) {
                break;
            }
            Object object2 = iterator1.next();
            String s1 = (String)object2;
            int v1 = s1.length();
            while(true) {
                if(v < v1) {
                    if(u0.K(s1.charAt(v))) {
                        ++v;
                        continue;
                    }
                    else {
                        break;
                    }
                }
                v = -1;
                break;
            }
            if(v == -1) {
                v = s1.length();
            }
            arrayList2.add(v);
        }
        Integer integer0 = (Integer)je.p.v0(arrayList2);
        int v2 = integer0 == null ? 0 : ((int)integer0);
        int v3 = s.length();
        int v4 = k.s(list0);
        ArrayList arrayList3 = new ArrayList();
        for(Object object3: list0) {
            String s2 = null;
            if(v >= 0) {
                if(v != 0 && v != v4 || !o.H0(((String)object3))) {
                    s2 = o.x0(v2, ((String)object3));
                }
                if(s2 != null) {
                    arrayList3.add(s2);
                }
                ++v;
                continue;
            }
            k.O();
            throw null;
        }
        StringBuilder stringBuilder0 = new StringBuilder(v3);
        je.p.p0(arrayList3, stringBuilder0, "\n", null, null, null, 0x7C);
        return stringBuilder0.toString();
    }

    public static String d0(String s) {
        List list0;
        q.g(s, "<this>");
        if(o.H0("|")) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        h h0 = new h(s);
        if(h0.hasNext()) {
            Object object0 = h0.next();
            if(h0.hasNext()) {
                ArrayList arrayList0 = new ArrayList();
                arrayList0.add(object0);
                while(h0.hasNext()) {
                    arrayList0.add(h0.next());
                }
                list0 = arrayList0;
            }
            else {
                list0 = k.z(object0);
            }
        }
        else {
            list0 = w.a;
        }
        int v = s.length();
        list0.size();
        int v1 = k.s(list0);
        ArrayList arrayList1 = new ArrayList();
        int v2 = 0;
        for(Object object1: list0) {
            String s1 = null;
            if(v2 >= 0) {
                String s2 = (String)object1;
                if(v2 != 0 && v2 != v1 || !o.H0(s2)) {
                    int v3 = s2.length();
                    int v4 = 0;
                    while(true) {
                        if(v4 < v3) {
                            if(u0.K(s2.charAt(v4))) {
                                ++v4;
                                continue;
                            }
                            else {
                                break;
                            }
                        }
                        v4 = -1;
                        break;
                    }
                    if(v4 != -1 && v.q0(v4, s2, "|", false)) {
                        s1 = s2.substring(v4 + 1);
                        q.f(s1, "substring(...)");
                    }
                    if(s1 == null) {
                        s1 = s2;
                    }
                }
                if(s1 != null) {
                    arrayList1.add(s1);
                }
                ++v2;
                continue;
            }
            k.O();
            throw null;
        }
        StringBuilder stringBuilder0 = new StringBuilder(v);
        je.p.p0(arrayList1, stringBuilder0, "\n", null, null, null, 0x7C);
        return stringBuilder0.toString();
    }
}

