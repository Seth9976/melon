package je;

import Ae.f;
import Ce.g;
import De.I;
import Q0.W0;
import U4.x;
import b3.Z;
import e.k;
import ie.m;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import jd.e3;
import kotlin.jvm.internal.q;
import y5.a;

public abstract class p extends u {
    public static ArrayList A0(Collection collection0, Iterable iterable0) {
        q.g(collection0, "<this>");
        q.g(iterable0, "elements");
        if(iterable0 instanceof Collection) {
            ArrayList arrayList0 = new ArrayList(((Collection)iterable0).size() + collection0.size());
            arrayList0.addAll(collection0);
            arrayList0.addAll(((Collection)iterable0));
            return arrayList0;
        }
        ArrayList arrayList1 = new ArrayList(collection0);
        u.U(arrayList1, iterable0);
        return arrayList1;
    }

    public static Object B0(Collection collection0, f f0) {
        q.g(collection0, "<this>");
        if(collection0.isEmpty()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        return p.h0(f0.c(collection0.size()), collection0);
    }

    public static List C0(Iterable iterable0) {
        q.g(iterable0, "<this>");
        if(iterable0 instanceof Collection && ((Collection)iterable0).size() <= 1) {
            return p.P0(iterable0);
        }
        List list0 = p.R0(iterable0);
        Collections.reverse(list0);
        return list0;
    }

    public static Object D0(Iterable iterable0) {
        q.g(iterable0, "<this>");
        if(iterable0 instanceof List) {
            return p.E0(((List)iterable0));
        }
        Iterator iterator0 = iterable0.iterator();
        if(!iterator0.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object object0 = iterator0.next();
        if(iterator0.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return object0;
    }

    public static Object E0(List list0) {
        q.g(list0, "<this>");
        switch(list0.size()) {
            case 0: {
                throw new NoSuchElementException("List is empty.");
            }
            case 1: {
                return list0.get(0);
            }
            default: {
                throw new IllegalArgumentException("List has more than one element.");
            }
        }
    }

    public static Object F0(Iterable iterable0) {
        q.g(iterable0, "<this>");
        if(iterable0 instanceof List) {
            return ((List)iterable0).size() == 1 ? ((List)iterable0).get(0) : null;
        }
        Iterator iterator0 = iterable0.iterator();
        if(!iterator0.hasNext()) {
            return null;
        }
        Object object0 = iterator0.next();
        return iterator0.hasNext() ? null : object0;
    }

    public static Object G0(List list0) {
        q.g(list0, "<this>");
        return list0.size() == 1 ? list0.get(0) : null;
    }

    public static List H0(List list0, g g0) {
        q.g(list0, "<this>");
        q.g(g0, "indices");
        return g0.isEmpty() ? w.a : p.P0(list0.subList(g0.a, g0.b + 1));
    }

    public static List I0(Iterable iterable0) {
        q.g(iterable0, "<this>");
        if(iterable0 instanceof Collection) {
            if(((Collection)iterable0).size() <= 1) {
                return p.P0(iterable0);
            }
            Object[] arr_object = ((Collection)iterable0).toArray(new Comparable[0]);
            q.g(((Comparable[])arr_object), "<this>");
            if(((Comparable[])arr_object).length > 1) {
                Arrays.sort(((Comparable[])arr_object));
            }
            return n.N(arr_object);
        }
        List list0 = p.R0(iterable0);
        t.R(list0);
        return list0;
    }

    public static List J0(Iterable iterable0, Comparator comparator0) {
        q.g(iterable0, "<this>");
        q.g(comparator0, "comparator");
        if(iterable0 instanceof Collection) {
            if(((Collection)iterable0).size() <= 1) {
                return p.P0(iterable0);
            }
            Object[] arr_object = ((Collection)iterable0).toArray(new Object[0]);
            q.g(arr_object, "<this>");
            if(arr_object.length > 1) {
                Arrays.sort(arr_object, comparator0);
            }
            return n.N(arr_object);
        }
        List list0 = p.R0(iterable0);
        t.S(list0, comparator0);
        return list0;
    }

    public static List K0(int v, Iterable iterable0) {
        q.g(iterable0, "<this>");
        if(v < 0) {
            throw new IllegalArgumentException(("Requested element count " + v + " is less than zero.").toString());
        }
        if(v == 0) {
            return w.a;
        }
        if(iterable0 instanceof Collection) {
            if(v >= ((Collection)iterable0).size()) {
                return p.P0(iterable0);
            }
            if(v == 1) {
                return k.z(p.j0(iterable0));
            }
        }
        ArrayList arrayList0 = new ArrayList(v);
        int v1 = 0;
        for(Object object0: iterable0) {
            arrayList0.add(object0);
            ++v1;
            if(v1 == v) {
                break;
            }
        }
        return k.J(arrayList0);
    }

    public static List L0(int v, List list0) {
        q.g(list0, "<this>");
        if(v < 0) {
            throw new IllegalArgumentException(("Requested element count " + v + " is less than zero.").toString());
        }
        if(v == 0) {
            return w.a;
        }
        int v1 = list0.size();
        if(v >= v1) {
            return p.P0(list0);
        }
        if(v == 1) {
            return k.z(p.s0(list0));
        }
        List list1 = new ArrayList(v);
        if(list0 instanceof RandomAccess) {
            for(int v2 = v1 - v; v2 < v1; ++v2) {
                ((ArrayList)list1).add(list0.get(v2));
            }
            return list1;
        }
        ListIterator listIterator0 = list0.listIterator(v1 - v);
        while(listIterator0.hasNext()) {
            Object object0 = listIterator0.next();
            ((ArrayList)list1).add(object0);
        }
        return list1;
    }

    public static final void M0(Iterable iterable0, AbstractCollection abstractCollection0) [...] // Inlined contents

    public static HashSet N0(Iterable iterable0) {
        q.g(iterable0, "<this>");
        HashSet hashSet0 = new HashSet(D.N(je.q.Q(12, iterable0)));
        p.M0(iterable0, hashSet0);
        return hashSet0;
    }

    public static int[] O0(Collection collection0) {
        q.g(collection0, "<this>");
        int[] arr_v = new int[collection0.size()];
        int v = 0;
        for(Object object0: collection0) {
            arr_v[v] = ((Number)object0).intValue();
            ++v;
        }
        return arr_v;
    }

    public static List P0(Iterable iterable0) {
        q.g(iterable0, "<this>");
        if(iterable0 instanceof Collection) {
            switch(((Collection)iterable0).size()) {
                case 0: {
                    return w.a;
                }
                case 1: {
                    if(iterable0 instanceof List) {
                        return k.z(((List)iterable0).get(0));
                    }
                    Object object0 = ((Collection)iterable0).iterator().next();
                    return k.z(object0);
                }
                default: {
                    return p.Q0(((Collection)iterable0));
                }
            }
        }
        return k.J(p.R0(iterable0));
    }

    public static ArrayList Q0(Collection collection0) {
        q.g(collection0, "<this>");
        return new ArrayList(collection0);
    }

    public static final List R0(Iterable iterable0) {
        q.g(iterable0, "<this>");
        if(iterable0 instanceof Collection) {
            return p.Q0(((Collection)iterable0));
        }
        List list0 = new ArrayList();
        p.M0(iterable0, ((AbstractCollection)list0));
        return list0;
    }

    public static Set S0(Iterable iterable0) {
        q.g(iterable0, "<this>");
        if(iterable0 instanceof Collection) {
            return new LinkedHashSet(((Collection)iterable0));
        }
        Set set0 = new LinkedHashSet();
        p.M0(iterable0, ((AbstractCollection)set0));
        return set0;
    }

    public static Set T0(Iterable iterable0) [...] // Inlined contents

    public static ArrayList U0(Iterable iterable0, int v, int v1) {
        q.g(iterable0, "<this>");
        if(v <= 0 || v1 <= 0) {
            throw new IllegalArgumentException((v == v1 ? "size " + v + " must be greater than zero." : "Both size " + v + " and step " + v1 + " must be greater than zero.").toString());
        }
        if(iterable0 instanceof RandomAccess && iterable0 instanceof List) {
            int v2 = ((List)iterable0).size();
            ArrayList arrayList0 = new ArrayList(v2 / v1 + (v2 % v1 == 0 ? 0 : 1));
            for(int v3 = 0; v3 >= 0 && v3 < v2; v3 += v1) {
                int v4 = v > v2 - v3 ? v2 - v3 : v;
                ArrayList arrayList1 = new ArrayList(v4);
                for(int v5 = 0; v5 < v4; ++v5) {
                    arrayList1.add(((List)iterable0).get(v5 + v3));
                }
                arrayList0.add(arrayList1);
            }
            return arrayList0;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator0 = iterable0.iterator();
        q.g(iterator0, "iterator");
        v v6 = iterator0.hasNext() ? I.P(new J(v, v1, iterator0, null)) : v.a;
        while(v6.hasNext()) {
            Object object0 = v6.next();
            arrayList2.add(((List)object0));
        }
        return arrayList2;
    }

    public static Sf.p V0(Iterable iterable0) {
        q.g(iterable0, "<this>");
        return new Sf.p(new e3(iterable0, 2), 2);
    }

    public static ArrayList W0(Iterable iterable0, Iterable iterable1) {
        q.g(iterable0, "<this>");
        q.g(iterable1, "other");
        Iterator iterator0 = iterable0.iterator();
        Iterator iterator1 = iterable1.iterator();
        ArrayList arrayList0 = new ArrayList(Math.min(je.q.Q(10, iterable0), je.q.Q(10, iterable1)));
        while(iterator0.hasNext() && iterator1.hasNext()) {
            Object object0 = iterator0.next();
            Object object1 = iterator1.next();
            arrayList0.add(new m(object0, object1));
        }
        return arrayList0;
    }

    public static final int a0(F f0, int v) {
        if(v >= 0 && v <= k.s(f0)) {
            return k.s(f0) - v;
        }
        StringBuilder stringBuilder0 = x.n(v, "Element index ", " must be in range [");
        stringBuilder0.append(new g(0, k.s(f0), 1));  // 初始化器: LCe/e;-><init>(III)V
        stringBuilder0.append("].");
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    public static final int b0(F f0, int v) {
        if(v >= 0 && v <= f0.size()) {
            return f0.size() - v;
        }
        StringBuilder stringBuilder0 = x.n(v, "Position index ", " must be in range [");
        stringBuilder0.append(new g(0, f0.size(), 1));  // 初始化器: LCe/e;-><init>(III)V
        stringBuilder0.append("].");
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    public static W0 c0(Iterable iterable0) {
        q.g(iterable0, "<this>");
        return new W0(iterable0, 7);
    }

    public static boolean d0(Iterable iterable0, Object object0) {
        q.g(iterable0, "<this>");
        if(iterable0 instanceof Collection) {
            return ((Collection)iterable0).contains(object0);
        }
        if(iterable0 instanceof List) {
            return ((List)iterable0).indexOf(object0) >= 0;
        }
        int v = 0;
        for(Object object1: iterable0) {
            if(v >= 0) {
                if(q.b(object0, object1)) {
                    return v >= 0;
                }
                ++v;
                continue;
            }
            k.O();
            throw null;
        }
        return false;
    }

    public static List e0(Iterable iterable0) {
        q.g(iterable0, "<this>");
        return p.P0(p.S0(iterable0));
    }

    public static List f0(int v, Iterable iterable0) {
        List list0;
        q.g(iterable0, "<this>");
        if(v < 0) {
            throw new IllegalArgumentException(("Requested element count " + v + " is less than zero.").toString());
        }
        if(v == 0) {
            return p.P0(iterable0);
        }
        if(iterable0 instanceof Collection) {
            int v1 = ((Collection)iterable0).size() - v;
            if(v1 <= 0) {
                return w.a;
            }
            if(v1 == 1) {
                return k.z(p.r0(iterable0));
            }
            list0 = new ArrayList(v1);
            if(iterable0 instanceof List) {
                if(iterable0 instanceof RandomAccess) {
                    int v2 = ((List)iterable0).size();
                    while(v < v2) {
                        ((ArrayList)list0).add(((List)iterable0).get(v));
                        ++v;
                    }
                    return list0;
                }
                ListIterator listIterator0 = ((List)iterable0).listIterator(v);
                while(listIterator0.hasNext()) {
                    Object object0 = listIterator0.next();
                    ((ArrayList)list0).add(object0);
                }
                return list0;
            }
        }
        else {
            list0 = new ArrayList();
        }
        int v3 = 0;
        for(Object object1: iterable0) {
            if(v3 >= v) {
                ((ArrayList)list0).add(object1);
            }
            else {
                ++v3;
            }
        }
        return k.J(list0);
    }

    public static List g0(int v, List list0) {
        q.g(list0, "<this>");
        if(v < 0) {
            throw new IllegalArgumentException(("Requested element count " + v + " is less than zero.").toString());
        }
        int v1 = list0.size() - v;
        if(v1 < 0) {
            v1 = 0;
        }
        return p.K0(v1, list0);
    }

    public static Object h0(int v, Collection collection0) {
        q.g(collection0, "<this>");
        if(collection0 instanceof List) {
            return ((List)collection0).get(v);
        }
        Bd.m m0 = new Bd.m(v, 8);
        if(collection0 instanceof List) {
            if(v >= 0 && v < ((List)collection0).size()) {
                return ((List)collection0).get(v);
            }
            m0.invoke(v);
            throw null;
        }
        if(v >= 0) {
            int v1 = 0;
            for(Object object0: collection0) {
                if(v == v1) {
                    return object0;
                }
                ++v1;
            }
            m0.invoke(v);
            throw null;
        }
        m0.invoke(v);
        throw null;
    }

    public static ArrayList i0(Iterable iterable0) {
        q.g(iterable0, "<this>");
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: iterable0) {
            if(object0 != null) {
                arrayList0.add(object0);
            }
        }
        return arrayList0;
    }

    public static Object j0(Iterable iterable0) {
        q.g(iterable0, "<this>");
        if(iterable0 instanceof List) {
            return p.k0(((List)iterable0));
        }
        Iterator iterator0 = iterable0.iterator();
        if(!iterator0.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        return iterator0.next();
    }

    public static Object k0(List list0) {
        q.g(list0, "<this>");
        if(list0.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list0.get(0);
    }

    public static Object l0(Iterable iterable0) {
        q.g(iterable0, "<this>");
        if(iterable0 instanceof List) {
            return ((List)iterable0).isEmpty() ? null : ((List)iterable0).get(0);
        }
        Iterator iterator0 = iterable0.iterator();
        return !iterator0.hasNext() ? null : iterator0.next();
    }

    public static Object m0(List list0) {
        q.g(list0, "<this>");
        return list0.isEmpty() ? null : list0.get(0);
    }

    public static Object n0(int v, List list0) {
        q.g(list0, "<this>");
        return v < 0 || v >= list0.size() ? null : list0.get(v);
    }

    public static final void o0(Iterable iterable0, Appendable appendable0, CharSequence charSequence0, CharSequence charSequence1, CharSequence charSequence2, CharSequence charSequence3, we.k k0) {
        q.g(iterable0, "<this>");
        q.g(appendable0, "buffer");
        q.g(charSequence1, "prefix");
        q.g(charSequence2, "postfix");
        appendable0.append(charSequence1);
        int v = 0;
        for(Object object0: iterable0) {
            ++v;
            if(v > 1) {
                appendable0.append(charSequence0);
            }
            a.i(appendable0, object0, k0);
        }
        appendable0.append(charSequence2);
    }

    public static void p0(Iterable iterable0, StringBuilder stringBuilder0, String s, String s1, String s2, we.k k0, int v) {
        if((v & 4) != 0) {
            s1 = "";
        }
        if((v & 8) != 0) {
            s2 = "";
        }
        if((v & 0x40) != 0) {
            k0 = null;
        }
        p.o0(iterable0, stringBuilder0, s, s1, s2, "...", k0);
    }

    public static String q0(Iterable iterable0, String s, String s1, String s2, we.k k0, int v) {
        if((v & 1) != 0) {
            s = ", ";
        }
        String s3 = (v & 2) == 0 ? s1 : "";
        if((v & 0x20) != 0) {
            k0 = null;
        }
        q.g(iterable0, "<this>");
        q.g(s3, "prefix");
        StringBuilder stringBuilder0 = new StringBuilder();
        p.o0(iterable0, stringBuilder0, s, s3, ((v & 4) == 0 ? s2 : ""), "...", k0);
        return stringBuilder0.toString();
    }

    public static Object r0(Iterable iterable0) {
        q.g(iterable0, "<this>");
        if(iterable0 instanceof List) {
            return p.s0(((List)iterable0));
        }
        Iterator iterator0 = iterable0.iterator();
        if(!iterator0.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object object0;
        for(object0 = iterator0.next(); iterator0.hasNext(); object0 = iterator0.next()) {
        }
        return object0;
    }

    public static Object s0(List list0) {
        q.g(list0, "<this>");
        if(list0.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list0.get(k.s(list0));
    }

    public static Object t0(List list0) {
        q.g(list0, "<this>");
        return list0.isEmpty() ? null : Z.h(1, list0);
    }

    public static Comparable u0(AbstractCollection abstractCollection0) {
        Iterator iterator0 = abstractCollection0.iterator();
        if(!iterator0.hasNext()) {
            return null;
        }
        Object object0 = iterator0.next();
        Comparable comparable0 = (Comparable)object0;
        while(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            Comparable comparable1 = (Comparable)object1;
            if(comparable0.compareTo(comparable1) < 0) {
                comparable0 = comparable1;
            }
        }
        return comparable0;
    }

    public static Comparable v0(AbstractCollection abstractCollection0) {
        Iterator iterator0 = abstractCollection0.iterator();
        if(!iterator0.hasNext()) {
            return null;
        }
        Object object0 = iterator0.next();
        Comparable comparable0 = (Comparable)object0;
        while(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            Comparable comparable1 = (Comparable)object1;
            if(comparable0.compareTo(comparable1) > 0) {
                comparable0 = comparable1;
            }
        }
        return comparable0;
    }

    public static ArrayList w0(Iterable iterable0, Object object0) {
        q.g(iterable0, "<this>");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
        boolean z = false;
        for(Object object1: iterable0) {
            boolean z1 = true;
            if(!z && q.b(object1, object0)) {
                z = true;
                z1 = false;
            }
            if(z1) {
                arrayList0.add(object1);
            }
        }
        return arrayList0;
    }

    public static ArrayList x0(Iterable iterable0, Iterable iterable1) {
        q.g(iterable0, "<this>");
        if(iterable0 instanceof Collection) {
            return p.A0(((Collection)iterable0), iterable1);
        }
        ArrayList arrayList0 = new ArrayList();
        u.U(arrayList0, iterable0);
        u.U(arrayList0, iterable1);
        return arrayList0;
    }

    public static ArrayList y0(Iterable iterable0, Object object0) {
        if(iterable0 instanceof Collection) {
            return p.z0(object0, ((Collection)iterable0));
        }
        ArrayList arrayList0 = new ArrayList();
        u.U(arrayList0, iterable0);
        arrayList0.add(object0);
        return arrayList0;
    }

    public static ArrayList z0(Object object0, Collection collection0) {
        q.g(collection0, "<this>");
        ArrayList arrayList0 = new ArrayList(collection0.size() + 1);
        arrayList0.addAll(collection0);
        arrayList0.add(object0);
        return arrayList0;
    }
}

