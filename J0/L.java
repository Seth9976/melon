package j0;

import androidx.collection.v;

public final class l extends k {
    public final int d;

    public l(int v) {
        this.d = v;
        super();
    }

    @Override
    public final Object next() {
        switch(this.d) {
            case 0: {
                int v1 = this.c;
                this.c = v1 + 2;
                return new v(1, this.a[v1], this.a[v1 + 1]);
            }
            case 1: {
                int v2 = this.c;
                this.c = v2 + 2;
                return this.a[v2];
            }
            default: {
                int v = this.c;
                this.c = v + 2;
                return this.a[v + 1];
            }
        }
    }
}

