package a6;

import N5.d;
import android.util.SparseArray;
import java.util.HashMap;

public abstract class a {
    public static final SparseArray a;
    public static final HashMap b;

    static {
        a.a = new SparseArray();
        HashMap hashMap0 = new HashMap();
        a.b = hashMap0;
        hashMap0.put(d.a, 0);
        hashMap0.put(d.b, 1);
        hashMap0.put(d.c, 2);
        for(Object object0: hashMap0.keySet()) {
            int v = (int)(((Integer)a.b.get(((d)object0))));
            a.a.append(v, ((d)object0));
        }
    }

    public static int a(d d0) {
        Integer integer0 = (Integer)a.b.get(d0);
        if(integer0 == null) {
            throw new IllegalStateException("PriorityMapping is missing known Priority value " + d0);
        }
        return (int)integer0;
    }

    public static d b(int v) {
        d d0 = (d)a.a.get(v);
        if(d0 == null) {
            throw new IllegalArgumentException("Unknown Priority for value " + v);
        }
        return d0;
    }
}

