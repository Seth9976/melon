package j0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
import xe.a;

public abstract class c implements Iterator, a {
    public final k[] a;
    public int b;
    public boolean c;

    public c(j j0, k[] arr_k) {
        this.a = arr_k;
        this.c = true;
        arr_k[0].a(j0.d, Integer.bitCount(j0.a) * 2, 0);
        this.b = 0;
        this.a();
    }

    public final void a() {
        int v = this.b;
        k[] arr_k = this.a;
        k k0 = arr_k[v];
        if(k0.c < k0.b) {
            return;
        }
        while(-1 < v) {
            int v1 = this.b(v);
            if(v1 == -1) {
                k k1 = arr_k[v];
                int v2 = k1.c;
                if(v2 < k1.a.length) {
                    k1.c = v2 + 1;
                    v1 = this.b(v);
                }
            }
            if(v1 != -1) {
                this.b = v1;
                return;
            }
            if(v > 0) {
                k k2 = arr_k[v - 1];
                ++k2.c;
            }
            arr_k[v].a(j.e.d, 0, 0);
            --v;
        }
        this.c = false;
    }

    public final int b(int v) {
        k[] arr_k = this.a;
        k k0 = arr_k[v];
        int v1 = k0.c;
        if(v1 < k0.b) {
            return v;
        }
        Object[] arr_object = k0.a;
        if(v1 < arr_object.length) {
            Object object0 = arr_object[v1];
            q.e(object0, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
            if(v == 6) {
                arr_k[7].a(((j)object0).d, ((j)object0).d.length, 0);
                return this.b(7);
            }
            arr_k[v + 1].a(((j)object0).d, Integer.bitCount(((j)object0).a) * 2, 0);
            return this.b(v + 1);
        }
        return -1;
    }

    @Override
    public final boolean hasNext() {
        return this.c;
    }

    @Override
    public Object next() {
        if(!this.c) {
            throw new NoSuchElementException();
        }
        Object object0 = this.a[this.b].next();
        this.a();
        return object0;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

