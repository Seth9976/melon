package androidx.constraintlayout.widget;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public final class s {
    public HashMap a;

    public final void a(int v, r r0) {
        HashMap hashMap0 = this.a;
        HashSet hashSet0 = (HashSet)hashMap0.get(v);
        if(hashSet0 == null) {
            hashSet0 = new HashSet();
            hashMap0.put(v, hashSet0);
        }
        hashSet0.add(new WeakReference(r0));
    }
}

