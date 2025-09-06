package androidx.lifecycle;

import java.util.LinkedHashMap;

public final class q0 {
    public final LinkedHashMap a;

    public q0() {
        this.a = new LinkedHashMap();
    }

    public final void a() {
        LinkedHashMap linkedHashMap0 = this.a;
        for(Object object0: linkedHashMap0.values()) {
            ((m0)object0).clear$lifecycle_viewmodel_release();
        }
        linkedHashMap0.clear();
    }
}

