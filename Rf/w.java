package rf;

import androidx.datastore.preferences.protobuf.e;
import java.util.Iterator;

public final class w implements Iterator {
    public final v a;
    public e b;
    public int c;

    public w(x x0) {
        v v0 = new v(x0);
        this.a = v0;
        this.b = new e(v0.a());
        this.c = x0.b;
    }

    @Override
    public final boolean hasNext() {
        return this.c > 0;
    }

    @Override
    public final Object next() {
        if(!this.b.hasNext()) {
            this.b = new e(this.a.a());
        }
        --this.c;
        return this.b.a();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

