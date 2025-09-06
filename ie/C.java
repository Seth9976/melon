package ie;

import kotlin.coroutines.Continuation;
import me.i;
import me.j;
import we.o;

public final class c extends b implements Continuation {
    public o a;
    public Continuation b;
    public Object c;

    @Override  // kotlin.coroutines.Continuation
    public final i getContext() {
        return j.a;
    }

    @Override  // kotlin.coroutines.Continuation
    public final void resumeWith(Object object0) {
        this.b = null;
        this.c = object0;
    }
}

