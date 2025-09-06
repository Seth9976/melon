package pe;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import je.c;
import je.f;
import je.n;
import kotlin.jvm.internal.q;

public final class b extends f implements Serializable, a {
    public final Enum[] a;

    public b(Enum[] arr_enum) {
        q.g(arr_enum, "entries");
        super();
        this.a = arr_enum;
    }

    @Override  // je.a
    public final boolean contains(Object object0) {
        if(!(object0 instanceof Enum)) {
            return false;
        }
        q.g(((Enum)object0), "element");
        return ((Enum)n.n0(((Enum)object0).ordinal(), this.a)) == ((Enum)object0);
    }

    @Override
    public final Object get(int v) {
        f.Companion.getClass();
        c.b(v, this.a.length);
        return this.a[v];
    }

    @Override  // je.a
    public final int getSize() {
        return this.a.length;
    }

    @Override  // je.f
    public final int indexOf(Object object0) {
        if(!(object0 instanceof Enum)) {
            return -1;
        }
        q.g(((Enum)object0), "element");
        int v = ((Enum)object0).ordinal();
        return ((Enum)n.n0(v, this.a)) == ((Enum)object0) ? v : -1;
    }

    @Override  // je.f
    public final int lastIndexOf(Object object0) {
        if(!(object0 instanceof Enum)) {
            return -1;
        }
        q.g(((Enum)object0), "element");
        int v = ((Enum)object0).ordinal();
        return ((Enum)n.n0(v, this.a)) == ((Enum)object0) ? v : -1;
    }

    private final void readObject(ObjectInputStream objectInputStream0) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return new pe.c(this.a);
    }
}

