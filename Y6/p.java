package Y6;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import y7.b;

public final class p implements b {
    public volatile Set a;
    public volatile Set b;

    @Override  // y7.b
    public final Object get() {
        if(this.b == null) {
            synchronized(this) {
                if(this.b == null) {
                    this.b = Collections.newSetFromMap(new ConcurrentHashMap());
                    synchronized(this) {
                        for(Object object0: this.a) {
                            this.b.add(((b)object0).get());
                        }
                        this.a = null;
                    }
                }
            }
        }
        return Collections.unmodifiableSet(this.b);
    }
}

