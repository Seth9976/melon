package androidx.collection;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;

public final class d implements Iterator, Map.Entry {
    public int a;
    public int b;
    public boolean c;
    public final f d;

    public d(f f0) {
        this.d = f0;
        this.a = f0.size() - 1;
        this.b = -1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return object0 instanceof Map.Entry && (q.b(((Map.Entry)object0).getKey(), this.d.keyAt(this.b)) && q.b(((Map.Entry)object0).getValue(), this.d.valueAt(this.b)));
    }

    @Override
    public final Object getKey() {
        if(!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.d.keyAt(this.b);
    }

    @Override
    public final Object getValue() {
        if(!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.d.valueAt(this.b);
    }

    @Override
    public final boolean hasNext() {
        return this.b < this.a;
    }

    @Override
    public final int hashCode() {
        if(!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        Object object0 = this.d.keyAt(this.b);
        Object object1 = this.d.valueAt(this.b);
        int v = 0;
        int v1 = object0 == null ? 0 : object0.hashCode();
        if(object1 != null) {
            v = object1.hashCode();
        }
        return v1 ^ v;
    }

    @Override
    public final Object next() {
        if(!this.hasNext()) {
            throw new NoSuchElementException();
        }
        ++this.b;
        this.c = true;
        return this;
    }

    @Override
    public final void remove() {
        if(!this.c) {
            throw new IllegalStateException();
        }
        this.d.removeAt(this.b);
        --this.b;
        --this.a;
        this.c = false;
    }

    @Override
    public final Object setValue(Object object0) {
        if(!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.d.setValueAt(this.b, object0);
    }

    @Override
    public final String toString() {
        return this.getKey() + "=" + this.getValue();
    }
}

