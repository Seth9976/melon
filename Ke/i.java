package ke;

import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import je.j;
import kotlin.jvm.internal.q;

public final class i extends j implements Serializable {
    public final e a;
    public static final i b;

    static {
        i.b = new i(e.n);
    }

    public i() {
        this(new e());
    }

    public i(e e0) {
        q.g(e0, "backing");
        super();
        this.a = e0;
    }

    @Override
    public final boolean add(Object object0) {
        return this.a.a(object0) >= 0;
    }

    @Override
    public final boolean addAll(Collection collection0) {
        q.g(collection0, "elements");
        this.a.d();
        return super.addAll(collection0);
    }

    @Override  // je.j
    public final int b() {
        return this.a.i;
    }

    @Override
    public final void clear() {
        this.a.clear();
    }

    @Override
    public final boolean contains(Object object0) {
        return this.a.containsKey(object0);
    }

    @Override
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override
    public final Iterator iterator() {
        this.a.getClass();
        return new c(this.a, 1);
    }

    private final void readObject(ObjectInputStream objectInputStream0) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @Override
    public final boolean remove(Object object0) {
        e e0 = this.a;
        e0.d();
        int v = e0.j(object0);
        if(v < 0) {
            return false;
        }
        e0.n(v);
        return true;
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        q.g(collection0, "elements");
        this.a.d();
        return super.removeAll(collection0);
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        q.g(collection0, "elements");
        this.a.d();
        return super.retainAll(collection0);
    }

    private final Object writeReplace() {
        if(!this.a.m) {
            throw new NotSerializableException("The set cannot be serialized while it is being built.");
        }
        return new g(this, 1);
    }
}

