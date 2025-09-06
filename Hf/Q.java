package hf;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import je.D;

public final class q {
    public final LinkedHashMap a;

    public q(LinkedHashMap linkedHashMap0) {
        this.a = linkedHashMap0;
    }

    public final q a() {
        LinkedHashMap linkedHashMap0 = new LinkedHashMap(D.N(this.a.size()));
        for(Object object0: this.a.entrySet()) {
            Object object1 = ((Map.Entry)object0).getKey();
            d d0 = (d)((Map.Entry)object0).getValue();
            linkedHashMap0.put(object1, new d(d0.a, d0.b, d0.c, true));
        }
        return new q(linkedHashMap0);
    }
}

