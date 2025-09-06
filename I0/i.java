package i0;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;

public final class i extends a {
    public int c;
    public Object[] d;
    public boolean e;

    public i(Object[] arr_object, int v, int v1, int v2) {
        super(v, v1);
        this.c = v2;
        Object[] arr_object1 = new Object[v2];
        this.d = arr_object1;
        int v3 = v == v1 ? 1 : 0;
        this.e = v3;
        arr_object1[0] = arr_object;
        this.b(v - v3, 1);
    }

    public final Object a() {
        int v = this.a & 0x1F;
        Object object0 = this.d[this.c - 1];
        q.e(object0, "null cannot be cast to non-null type kotlin.Array<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.TrieIterator>");
        return ((Object[])object0)[v];
    }

    public final void b(int v, int v1) {
        int v2 = (this.c - v1) * 5;
        while(v1 < this.c) {
            Object[] arr_object = this.d;
            Object object0 = arr_object[v1 - 1];
            q.e(object0, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            arr_object[v1] = ((Object[])object0)[v >> v2 & 0x1F];
            v2 -= 5;
            ++v1;
        }
    }

    public final void d(int v) {
        int v1;
        for(v1 = 0; (this.a >> v1 & 0x1F) == v; v1 += 5) {
        }
        if(v1 > 0) {
            this.b(this.a, this.c - 1 - v1 / 5 + 1);
        }
    }

    @Override
    public final Object next() {
        if(!this.hasNext()) {
            throw new NoSuchElementException();
        }
        Object object0 = this.a();
        int v = this.a + 1;
        this.a = v;
        if(v == this.b) {
            this.e = true;
            return object0;
        }
        this.d(0);
        return object0;
    }

    @Override
    public final Object previous() {
        if(!this.hasPrevious()) {
            throw new NoSuchElementException();
        }
        --this.a;
        if(this.e) {
            this.e = false;
            return this.a();
        }
        this.d(0x1F);
        return this.a();
    }
}

