package F8;

import android.content.Context;
import kotlin.jvm.internal.q;

public abstract class w extends o implements Comparable {
    @Override
    public final int compareTo(Object object0) {
        q.g(((w)object0), "other");
        if(this.i() < ((w)object0).i()) {
            return -1;
        }
        return this.i() <= ((w)object0).i() ? 0 : 1;
    }

    @Override  // F8.o
    public String f(Context context0) {
        return null;
    }

    public abstract int i();
}

