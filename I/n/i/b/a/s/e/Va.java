package i.n.i.b.a.s.e;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class va extends Ib {
    public final List d;
    public final List e;
    public final List f;
    public final List g;
    public final List h;
    public final u i;
    public final List j;
    public final Map k;
    public final List l;
    public static final va m;

    static {
        va.m = new va("", Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, null, Collections.EMPTY_LIST, false, Collections.EMPTY_MAP, Collections.EMPTY_LIST);
    }

    public va(String s, List list0, List list1, List list2, List list3, List list4, List list5, u u0, List list6, boolean z, Map map0, List list7) {
        super(s, list0, z);
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < list1.size(); ++v) {
            Uri uri0 = ((ua)list1.get(v)).a;
            if(!arrayList0.contains(uri0)) {
                arrayList0.add(uri0);
            }
        }
        va.c(list2, arrayList0);
        va.c(list3, arrayList0);
        va.c(list4, arrayList0);
        va.c(list5, arrayList0);
        this.d = Collections.unmodifiableList(arrayList0);
        this.e = Collections.unmodifiableList(list1);
        this.f = Collections.unmodifiableList(list2);
        this.g = Collections.unmodifiableList(list3);
        this.h = Collections.unmodifiableList(list4);
        Collections.unmodifiableList(list5);
        this.i = u0;
        this.j = list6 == null ? null : Collections.unmodifiableList(list6);
        this.k = Collections.unmodifiableMap(map0);
        this.l = Collections.unmodifiableList(list7);
    }

    public static ArrayList a(List list0, int v, List list1) {
        ArrayList arrayList0 = new ArrayList(list1.size());
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            Object object0 = list0.get(v1);
            for(int v2 = 0; v2 < list1.size(); ++v2) {
                fb fb0 = (fb)list1.get(v2);
                if(fb0.b == v && fb0.c == v1) {
                    arrayList0.add(object0);
                    break;
                }
            }
        }
        return arrayList0;
    }

    @Override  // i.n.i.b.a.s.e.ne
    public final Object b(List list0) {
        ArrayList arrayList0 = va.a(this.e, 0, list0);
        List list1 = Collections.EMPTY_LIST;
        ArrayList arrayList1 = va.a(this.g, 1, list0);
        ArrayList arrayList2 = va.a(this.h, 2, list0);
        return new va(this.a, this.b, arrayList0, list1, arrayList1, arrayList2, list1, this.i, this.j, this.c, this.k, this.l);
    }

    public static void c(List list0, ArrayList arrayList0) {
        for(int v = 0; v < list0.size(); ++v) {
            Uri uri0 = ((ta)list0.get(v)).a;
            if(!arrayList0.contains(uri0)) {
                arrayList0.add(uri0);
            }
        }
    }
}

