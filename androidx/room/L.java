package androidx.room;

import Yc.D;
import android.content.Intent;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.q;
import ne.a;

public final class l {
    public final H a;
    public final String[] b;
    public final h0 c;
    public final LinkedHashMap d;
    public final ReentrantLock e;
    public final i f;
    public final i g;
    public Intent h;
    public p i;
    public final Object j;

    public l(H h0, HashMap hashMap0, HashMap hashMap1, String[] arr_s) {
        q.g(h0, "database");
        super();
        this.a = h0;
        this.b = arr_s;
        h0 h00 = new h0(h0, hashMap0, hashMap1, arr_s, h0.getUseTempTrackingTable$room_runtime_release(), new D(1, this, l.class, "notifyInvalidatedObservers", "notifyInvalidatedObservers(Ljava/util/Set;)V", 0, 15));
        this.c = h00;
        this.d = new LinkedHashMap();
        this.e = new ReentrantLock();
        this.f = new i(this, 0);
        this.g = new i(this, 1);
        q.f(Collections.newSetFromMap(new IdentityHashMap()), "newSetFromMap(...)");
        this.j = new Object();
        h00.k = new i(this, 2);
    }

    public final Object a(oe.i i0) {
        if(!this.a.inCompatibilityMode$room_runtime_release() || this.a.isOpenInternal()) {
            Object object0 = this.c.f(i0);
            if(object0 == a.a) {
                return object0;
            }
        }
        return ie.H.a;
    }
}

