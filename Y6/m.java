package Y6;

import Z6.j;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import v7.a;
import v7.b;
import v7.c;

public final class m implements b, c {
    public final HashMap a;
    public ArrayDeque b;
    public final j c;

    public m() {
        this.a = new HashMap();
        this.b = new ArrayDeque();
        this.c = j.a;
    }

    public final void a(Executor executor0, a a0) {
        Class class0 = com.google.firebase.b.class;
        synchronized(this) {
            executor0.getClass();
            if(!this.a.containsKey(class0)) {
                ConcurrentHashMap concurrentHashMap0 = new ConcurrentHashMap();
                this.a.put(class0, concurrentHashMap0);
            }
            ((ConcurrentHashMap)this.a.get(class0)).put(a0, executor0);
        }
    }
}

