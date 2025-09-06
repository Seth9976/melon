package j0;

import D0.E;

public final class m extends k {
    public final E d;

    public m(E e0) {
        this.d = e0;
    }

    @Override
    public final Object next() {
        int v = this.c;
        this.c = v + 2;
        return new a(this.d, this.a[v], this.a[v + 1]);
    }
}

