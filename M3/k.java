package m3;

import android.net.Uri;
import androidx.media3.common.StreamKey;
import androidx.media3.common.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class k extends l {
    public final List d;
    public final List e;
    public final List f;
    public final List g;
    public final List h;
    public final List i;
    public final b j;
    public final List k;
    public final Map l;
    public final List m;
    public static final k n;

    static {
        k.n = new k("", Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, null, Collections.EMPTY_LIST, false, Collections.EMPTY_MAP, Collections.EMPTY_LIST);
    }

    public k(String s, List list0, List list1, List list2, List list3, List list4, List list5, b b0, List list6, boolean z, Map map0, List list7) {
        super(s, list0, z);
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < list1.size(); ++v) {
            Uri uri0 = ((j)list1.get(v)).a;
            if(!arrayList0.contains(uri0)) {
                arrayList0.add(uri0);
            }
        }
        k.b(list2, arrayList0);
        k.b(list3, arrayList0);
        k.b(list4, arrayList0);
        k.b(list5, arrayList0);
        this.d = Collections.unmodifiableList(arrayList0);
        this.e = Collections.unmodifiableList(list1);
        this.f = Collections.unmodifiableList(list2);
        this.g = Collections.unmodifiableList(list3);
        this.h = Collections.unmodifiableList(list4);
        this.i = Collections.unmodifiableList(list5);
        this.j = b0;
        this.k = list6 == null ? null : Collections.unmodifiableList(list6);
        this.l = Collections.unmodifiableMap(map0);
        this.m = Collections.unmodifiableList(list7);
    }

    @Override  // m3.l
    public final Object a(List list0) {
        ArrayList arrayList0 = k.c(this.e, 0, list0);
        List list1 = Collections.EMPTY_LIST;
        ArrayList arrayList1 = k.c(this.g, 1, list0);
        ArrayList arrayList2 = k.c(this.h, 2, list0);
        return new k(this.a, this.b, arrayList0, list1, arrayList1, arrayList2, list1, this.j, this.k, this.c, this.l, this.m);
    }

    public static void b(List list0, ArrayList arrayList0) {
        for(int v = 0; v < list0.size(); ++v) {
            Uri uri0 = ((i)list0.get(v)).a;
            if(!arrayList0.contains(uri0)) {
                arrayList0.add(uri0);
            }
        }
    }

    public static ArrayList c(List list0, int v, List list1) {
        ArrayList arrayList0 = new ArrayList(list1.size());
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            Object object0 = list0.get(v1);
            for(int v2 = 0; v2 < list1.size(); ++v2) {
                StreamKey streamKey0 = (StreamKey)list1.get(v2);
                if(streamKey0.b == v && streamKey0.c == v1) {
                    arrayList0.add(object0);
                    break;
                }
            }
        }
        return arrayList0;
    }
}

