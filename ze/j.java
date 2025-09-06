package Ze;

import ie.m;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import je.C;
import qf.b;
import qf.c;
import qf.h;

public abstract class j {
    public static final LinkedHashMap a;
    public static final Map b;

    static {
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        j.a = linkedHashMap0;
        ArrayList arrayList0 = j.a(new String[]{"java.util.ArrayList", "java.util.LinkedList"});
        j.b(h.A, arrayList0);
        ArrayList arrayList1 = j.a(new String[]{"java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"});
        j.b(h.B, arrayList1);
        ArrayList arrayList2 = j.a(new String[]{"java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"});
        j.b(h.C, arrayList2);
        c c0 = new c("java.util.function.Function");
        j.b(new b(c0.b(), c0.a.f()), j.a(new String[]{"java.util.function.UnaryOperator"}));
        c c1 = new c("java.util.function.BiFunction");
        j.b(new b(c1.b(), c1.a.f()), j.a(new String[]{"java.util.function.BinaryOperator"}));
        ArrayList arrayList3 = new ArrayList(linkedHashMap0.size());
        for(Object object0: linkedHashMap0.entrySet()) {
            b b0 = (b)((Map.Entry)object0).getKey();
            b b1 = (b)((Map.Entry)object0).getValue();
            arrayList3.add(new m(b0.a(), b1.a()));
        }
        j.b = C.Y(arrayList3);
    }

    public static ArrayList a(String[] arr_s) {
        ArrayList arrayList0 = new ArrayList(arr_s.length);
        for(int v = 0; v < arr_s.length; ++v) {
            c c0 = new c(arr_s[v]);
            arrayList0.add(new b(c0.b(), c0.a.f()));
        }
        return arrayList0;
    }

    public static void b(b b0, ArrayList arrayList0) {
        for(Object object0: arrayList0) {
            b b1 = (b)object0;
            j.a.put(object0, b0);
        }
    }
}

