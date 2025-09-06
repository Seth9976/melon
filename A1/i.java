package a1;

import P4.a;
import java.util.ArrayList;
import java.util.List;

public abstract class i {
    public static final g a;

    static {
        i.a = new g("");
    }

    public static final List a(g g0, int v, int v1, h h0) {
        if(v != v1) {
            List list0 = g0.a;
            if(list0 != null) {
                if(v == 0 && v1 >= g0.b.length()) {
                    if(h0 == null) {
                        return list0;
                    }
                    List list1 = new ArrayList(list0.size());
                    int v3 = list0.size();
                    for(int v2 = 0; v2 < v3; ++v2) {
                        Object object0 = list0.get(v2);
                        if(((Boolean)h0.invoke(((e)object0).a)).booleanValue()) {
                            ((ArrayList)list1).add(object0);
                        }
                    }
                    return list1;
                }
                List list2 = new ArrayList(list0.size());
                int v4 = list0.size();
                for(int v5 = 0; v5 < v4; ++v5) {
                    e e0 = (e)list0.get(v5);
                    if((h0 == null ? true : ((Boolean)h0.invoke(e0.a)).booleanValue()) && i.b(v, v1, e0.b, e0.c)) {
                        int v6 = a.j(e0.b, v, v1);
                        int v7 = a.j(e0.c, v, v1);
                        ((ArrayList)list2).add(new e(e0.d, v6 - v, v7 - v, ((b)e0.a)));
                    }
                }
                return list2;
            }
        }
        return null;
    }

    // 去混淆评级： 低(30)
    public static final boolean b(int v, int v1, int v2, int v3) {
        return (v >= v3 ? 0 : 1) & (v2 >= v1 ? 0 : 1) | ((v == v1 ? 1 : 0) | (v2 == v3 ? 1 : 0)) & (v == v2 ? 1 : 0);
    }
}

