package te;

import Q0.W0;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
import xe.a;

public final class k implements Iterator, a {
    public String a;
    public boolean b;
    public final W0 c;

    public k(W0 w00) {
        this.c = w00;
    }

    @Override
    public final boolean hasNext() {
        if(this.a == null && !this.b) {
            String s = ((BufferedReader)this.c.b).readLine();
            this.a = s;
            if(s == null) {
                this.b = true;
            }
        }
        return this.a != null;
    }

    @Override
    public final Object next() {
        if(!this.hasNext()) {
            throw new NoSuchElementException();
        }
        String s = this.a;
        this.a = null;
        q.d(s);
        return s;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

