package androidx.lifecycle;

import H8.i;
import R2.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import je.x;
import ke.e;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;

public final class c0 {
    public final LinkedHashMap a;
    public final i b;

    public c0() {
        this.a = new LinkedHashMap();
        this.b = new i(x.a);
    }

    public c0(e e0) {
        this.a = new LinkedHashMap();
        this.b = new i(e0);
    }

    public final Object a(String s) {
        q.g(s, "key");
        i i0 = this.b;
        LinkedHashMap linkedHashMap0 = (LinkedHashMap)i0.b;
        LinkedHashMap linkedHashMap1 = (LinkedHashMap)i0.e;
        try {
            MutableStateFlow mutableStateFlow0 = (MutableStateFlow)linkedHashMap1.get(s);
            if(mutableStateFlow0 != null) {
                Object object0 = mutableStateFlow0.getValue();
                return object0 == null ? linkedHashMap0.get(s) : object0;
            }
            return linkedHashMap0.get(s);
        }
        catch(ClassCastException unused_ex) {
            linkedHashMap0.remove(s);
            ((LinkedHashMap)i0.d).remove(s);
            linkedHashMap1.remove(s);
            return null;
        }
    }

    public final void b(Object object0, String s) {
        q.g(s, "key");
        if(object0 != null) {
            ArrayList arrayList0 = a.a;
            if(arrayList0 == null || !arrayList0.isEmpty()) {
                for(Object object1: arrayList0) {
                    if(!((Class)object1).isInstance(object0)) {
                        continue;
                    }
                    goto label_10;
                }
            }
            throw new IllegalArgumentException(("Can\'t put value with type " + object0.getClass() + " into saved state").toString());
        }
    label_10:
        Object object2 = this.a.get(s);
        L l0 = object2 instanceof L ? ((L)object2) : null;
        if(l0 != null) {
            l0.setValue(object0);
        }
        this.b.y(object0, s);
    }
}

