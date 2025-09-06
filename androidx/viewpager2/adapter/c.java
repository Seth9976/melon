package androidx.viewpager2.adapter;

import H0.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c {
    public CopyOnWriteArrayList a;

    public static void a(List list0) {
        Iterator iterator0 = list0.iterator();
        if(iterator0.hasNext()) {
            throw b.b(iterator0);
        }
    }
}

