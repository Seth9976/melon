package androidx.recyclerview.widget;

import java.util.Comparator;

public final class r implements Comparator {
    public final int a;

    public r(int v) {
        this.a = v;
        super();
    }

    @Override
    public final int compare(Object object0, Object object1) {
        if(this.a != 0) {
            RecyclerView recyclerView0 = ((E)object0).d;
            if((recyclerView0 == null ? 1 : 0) != (((E)object1).d == null ? 1 : 0)) {
                return recyclerView0 == null ? 1 : -1;
            }
            boolean z = ((E)object0).a;
            if(z != ((E)object1).a) {
                return z ? -1 : 1;
            }
            int v = ((E)object1).b - ((E)object0).b;
            if(v != 0) {
                return v;
            }
            int v1 = ((E)object0).c - ((E)object1).c;
            return v1 == 0 ? 0 : v1;
        }
        return ((t)object0).a - ((t)object1).a;
    }
}

