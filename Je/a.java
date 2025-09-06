package je;

import kotlin.jvm.internal.q;

public final class A {
    public final int a;
    public final Object b;

    public A(int v, Object object0) {
        this.a = v;
        this.b = object0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof A)) {
            return false;
        }
        return this.a == ((A)object0).a ? q.b(this.b, ((A)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b == null ? this.a * 0x1F : this.a * 0x1F + this.b.hashCode();
    }

    @Override
    public final String toString() {
        return "IndexedValue(index=" + this.a + ", value=" + this.b + ')';
    }
}

