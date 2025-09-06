package je;

import Sf.k;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import xe.a;
import xe.b;

public abstract class u extends t {
    public static void T(ArrayList arrayList0, k k0) {
        q.g(k0, "elements");
        for(Object object0: k0) {
            arrayList0.add(object0);
        }
    }

    public static void U(Collection collection0, Iterable iterable0) {
        q.g(collection0, "<this>");
        q.g(iterable0, "elements");
        if(iterable0 instanceof Collection) {
            collection0.addAll(((Collection)iterable0));
            return;
        }
        for(Object object0: iterable0) {
            collection0.add(object0);
        }
    }

    public static void V(Collection collection0, Object[] arr_object) {
        q.g(collection0, "<this>");
        q.g(arr_object, "elements");
        collection0.addAll(n.N(arr_object));
    }

    public static final boolean W(Iterable iterable0, we.k k0, boolean z) {
        boolean z1 = false;
        Iterator iterator0 = iterable0.iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            if(((Boolean)k0.invoke(object0)).booleanValue() == z) {
                iterator0.remove();
                z1 = true;
            }
        }
        return z1;
    }

    public static final boolean X(List list0, we.k k0, boolean z) {
        int v2;
        if(!(list0 instanceof RandomAccess)) {
            q.e(list0, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            if(list0 instanceof a && !(list0 instanceof b)) {
                N.i(list0, "kotlin.collections.MutableIterable");
                throw null;
            }
            return u.W(list0, k0, z);
        }
        int v = e.k.s(list0);
        if(v >= 0) {
            v2 = 0;
            for(int v1 = 0; true; ++v1) {
                Object object0 = list0.get(v1);
                if(((Boolean)k0.invoke(object0)).booleanValue() != z) {
                    if(v2 != v1) {
                        list0.set(v2, object0);
                    }
                    ++v2;
                }
                if(v1 == v) {
                    break;
                }
            }
        }
        else {
            v2 = 0;
        }
        if(v2 < list0.size()) {
            int v3 = e.k.s(list0);
            if(v2 <= v3) {
                while(true) {
                    list0.remove(v3);
                    if(v3 == v2) {
                        break;
                    }
                    --v3;
                }
            }
            return true;
        }
        return false;
    }

    public static void Y(List list0, we.k k0) {
        q.g(list0, "<this>");
        q.g(k0, "predicate");
        u.X(list0, k0, true);
    }

    public static Object Z(AbstractList abstractList0) {
        q.g(abstractList0, "<this>");
        if(abstractList0.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return abstractList0.remove(e.k.s(abstractList0));
    }
}

