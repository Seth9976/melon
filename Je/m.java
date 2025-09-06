package je;

import e.k;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;

public final class m extends h {
    public int a;
    public Object[] b;
    public int c;
    public static final Object[] d;

    static {
        m.d = new Object[0];
    }

    public m() {
        this.b = m.d;
    }

    @Override
    public final void add(int v, Object object0) {
        int v1 = this.c;
        f.Companion.getClass();
        c.c(v, v1);
        if(v == this.c) {
            this.addLast(object0);
            return;
        }
        if(v == 0) {
            this.addFirst(object0);
            return;
        }
        this.q();
        this.g(this.c + 1);
        int v2 = this.p(this.a + v);
        int v3 = this.c;
        if(v < v3 + 1 >> 1) {
            int v4 = v2 == 0 ? n.l0(this.b) : v2 - 1;
            int v5 = this.a == 0 ? n.l0(this.b) : this.a - 1;
            int v6 = this.a;
            if(v4 >= v6) {
                Object[] arr_object = this.b;
                arr_object[v5] = arr_object[v6];
                n.W(arr_object, v6, arr_object, v6 + 1, v4 + 1);
            }
            else {
                n.W(this.b, v6 - 1, this.b, v6, this.b.length);
                Object[] arr_object1 = this.b;
                arr_object1[arr_object1.length - 1] = arr_object1[0];
                n.W(arr_object1, 0, arr_object1, 1, v4 + 1);
            }
            this.b[v4] = object0;
            this.a = v5;
        }
        else {
            int v7 = this.p(v3 + this.a);
            if(v2 < v7) {
                n.W(this.b, v2 + 1, this.b, v2, v7);
            }
            else {
                n.W(this.b, 1, this.b, 0, v7);
                Object[] arr_object2 = this.b;
                arr_object2[0] = arr_object2[arr_object2.length - 1];
                n.W(arr_object2, v2 + 1, arr_object2, v2, arr_object2.length - 1);
            }
            this.b[v2] = object0;
        }
        ++this.c;
    }

    @Override
    public final boolean add(Object object0) {
        this.addLast(object0);
        return true;
    }

    @Override
    public final boolean addAll(int v, Collection collection0) {
        q.g(collection0, "elements");
        int v1 = this.c;
        f.Companion.getClass();
        c.c(v, v1);
        if(collection0.isEmpty()) {
            return false;
        }
        if(v == this.c) {
            return this.addAll(collection0);
        }
        this.q();
        this.g(collection0.size() + this.c);
        int v2 = this.p(this.c + this.a);
        int v3 = this.p(this.a + v);
        int v4 = collection0.size();
        if(v < this.c + 1 >> 1) {
            int v5 = this.a;
            int v6 = v5 - v4;
            if(v3 < v5) {
                n.W(this.b, v6, this.b, v5, this.b.length);
                if(v4 >= v3) {
                    n.W(this.b, this.b.length - v4, this.b, 0, v3);
                }
                else {
                    n.W(this.b, this.b.length - v4, this.b, 0, v4);
                    n.W(this.b, 0, this.b, v4, v3);
                }
            }
            else if(v6 >= 0) {
                n.W(this.b, v6, this.b, v5, v3);
            }
            else {
                Object[] arr_object = this.b;
                v6 += arr_object.length;
                int v7 = arr_object.length - v6;
                if(v7 >= v3 - v5) {
                    n.W(arr_object, v6, arr_object, v5, v3);
                }
                else {
                    n.W(arr_object, v6, arr_object, v5, v5 + v7);
                    n.W(this.b, 0, this.b, this.a + v7, v3);
                }
            }
            this.a = v6;
            this.e(this.l(v3 - v4), collection0);
            return true;
        }
        int v8 = v3 + v4;
        if(v3 < v2) {
            int v9 = v4 + v2;
            Object[] arr_object1 = this.b;
            if(v9 <= arr_object1.length) {
                n.W(arr_object1, v8, arr_object1, v3, v2);
            }
            else if(v8 >= arr_object1.length) {
                n.W(arr_object1, v8 - arr_object1.length, arr_object1, v3, v2);
            }
            else {
                int v10 = v2 - (v9 - arr_object1.length);
                n.W(arr_object1, 0, arr_object1, v10, v2);
                n.W(this.b, v8, this.b, v3, v10);
            }
        }
        else {
            n.W(this.b, v4, this.b, 0, v2);
            Object[] arr_object2 = this.b;
            if(v8 >= arr_object2.length) {
                n.W(arr_object2, v8 - arr_object2.length, arr_object2, v3, arr_object2.length);
            }
            else {
                n.W(arr_object2, 0, arr_object2, arr_object2.length - v4, arr_object2.length);
                n.W(this.b, v8, this.b, v3, this.b.length - v4);
            }
        }
        this.e(v3, collection0);
        return true;
    }

    @Override
    public final boolean addAll(Collection collection0) {
        q.g(collection0, "elements");
        if(collection0.isEmpty()) {
            return false;
        }
        this.q();
        this.g(collection0.size() + this.b());
        this.e(this.p(this.b() + this.a), collection0);
        return true;
    }

    @Override
    public final void addFirst(Object object0) {
        this.q();
        this.g(this.c + 1);
        int v = this.a == 0 ? n.l0(this.b) : this.a - 1;
        this.a = v;
        this.b[v] = object0;
        ++this.c;
    }

    @Override
    public final void addLast(Object object0) {
        this.q();
        this.g(this.b() + 1);
        this.b[this.p(this.b() + this.a)] = object0;
        this.c = this.b() + 1;
    }

    @Override  // je.h
    public final int b() {
        return this.c;
    }

    @Override
    public final void clear() {
        if(!this.isEmpty()) {
            this.q();
            int v = this.p(this.b() + this.a);
            this.o(this.a, v);
        }
        this.a = 0;
        this.c = 0;
    }

    @Override
    public final boolean contains(Object object0) {
        return this.indexOf(object0) != -1;
    }

    @Override  // je.h
    public final Object d(int v) {
        int v1 = this.c;
        f.Companion.getClass();
        c.b(v, v1);
        if(v == k.s(this)) {
            return this.removeLast();
        }
        if(v == 0) {
            return this.removeFirst();
        }
        this.q();
        int v2 = this.p(this.a + v);
        Object[] arr_object = this.b;
        Object object0 = arr_object[v2];
        if(v < this.c >> 1) {
            int v3 = this.a;
            if(v2 >= v3) {
                n.W(arr_object, v3 + 1, arr_object, v3, v2);
            }
            else {
                n.W(arr_object, 1, arr_object, 0, v2);
                Object[] arr_object1 = this.b;
                arr_object1[0] = arr_object1[arr_object1.length - 1];
                n.W(arr_object1, this.a + 1, arr_object1, this.a, arr_object1.length - 1);
            }
            int v4 = this.a;
            this.b[v4] = null;
            this.a = this.i(v4);
        }
        else {
            int v5 = this.a;
            int v6 = this.p(k.s(this) + v5);
            if(v2 <= v6) {
                n.W(this.b, v2, this.b, v2 + 1, v6 + 1);
            }
            else {
                n.W(this.b, v2, this.b, v2 + 1, this.b.length);
                Object[] arr_object2 = this.b;
                arr_object2[arr_object2.length - 1] = arr_object2[0];
                n.W(arr_object2, 0, arr_object2, 1, v6 + 1);
            }
            this.b[v6] = null;
        }
        --this.c;
        return object0;
    }

    public final void e(int v, Collection collection0) {
        Iterator iterator0 = collection0.iterator();
        while(v < this.b.length && iterator0.hasNext()) {
            Object[] arr_object = this.b;
            Object object0 = iterator0.next();
            arr_object[v] = object0;
            ++v;
        }
        int v1 = this.a;
        for(int v2 = 0; v2 < v1 && iterator0.hasNext(); ++v2) {
            Object[] arr_object1 = this.b;
            Object object1 = iterator0.next();
            arr_object1[v2] = object1;
        }
        this.c = collection0.size() + this.c;
    }

    public final Object first() {
        if(this.isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.b[this.a];
    }

    public final void g(int v) {
        if(v < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] arr_object = this.b;
        if(v <= arr_object.length) {
            return;
        }
        if(arr_object == m.d) {
            if(v < 10) {
                v = 10;
            }
            this.b = new Object[v];
            return;
        }
        f.Companion.getClass();
        Object[] arr_object1 = new Object[c.e(arr_object.length, v)];
        n.W(this.b, 0, arr_object1, this.a, this.b.length);
        n.W(this.b, this.b.length - this.a, arr_object1, 0, this.a);
        this.a = 0;
        this.b = arr_object1;
    }

    @Override
    public final Object get(int v) {
        int v1 = this.c;
        f.Companion.getClass();
        c.b(v, v1);
        return this.b[this.p(this.a + v)];
    }

    public final int i(int v) {
        return v == n.l0(this.b) ? 0 : v + 1;
    }

    @Override
    public final int indexOf(Object object0) {
        int v = this.p(this.b() + this.a);
        int v1 = this.a;
        if(v1 < v) {
            while(v1 < v) {
                if(q.b(object0, this.b[v1])) {
                    return v1 - this.a;
                }
                ++v1;
            }
            return -1;
        }
        if(v1 >= v) {
            while(v1 < this.b.length) {
                if(q.b(object0, this.b[v1])) {
                    return v1 - this.a;
                }
                ++v1;
            }
            for(int v2 = 0; v2 < v; ++v2) {
                if(q.b(object0, this.b[v2])) {
                    return v2 + this.b.length - this.a;
                }
            }
        }
        return -1;
    }

    @Override
    public final boolean isEmpty() {
        return this.b() == 0;
    }

    public final Object k() {
        if(this.isEmpty()) {
            return null;
        }
        Object[] arr_object = this.b;
        int v = this.a;
        return arr_object[this.p(k.s(this) + v)];
    }

    public final int l(int v) {
        return v >= 0 ? v : v + this.b.length;
    }

    public final Object last() {
        if(this.isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] arr_object = this.b;
        int v = this.a;
        return arr_object[this.p(k.s(this) + v)];
    }

    @Override
    public final int lastIndexOf(Object object0) {
        int v2;
        int v = this.p(this.b() + this.a);
        int v1 = this.a;
        if(v1 < v) {
            v2 = v - 1;
            if(v1 <= v2) {
                while(true) {
                    if(q.b(object0, this.b[v2])) {
                        return v2 - this.a;
                    }
                    if(v2 == v1) {
                        break;
                    }
                    --v2;
                }
            }
        }
        else if(v1 > v) {
            for(int v3 = v - 1; -1 < v3; --v3) {
                if(q.b(object0, this.b[v3])) {
                    return v3 + this.b.length - this.a;
                }
            }
            v2 = n.l0(this.b);
            int v4 = this.a;
            if(v4 <= v2) {
                while(true) {
                    if(q.b(object0, this.b[v2])) {
                        return v2 - this.a;
                    }
                    if(v2 == v4) {
                        break;
                    }
                    --v2;
                }
            }
        }
        return -1;
    }

    public final void o(int v, int v1) {
        if(v < v1) {
            n.c0(v, v1, null, this.b);
            return;
        }
        n.c0(v, this.b.length, null, this.b);
        n.c0(0, v1, null, this.b);
    }

    public final int p(int v) {
        return v < this.b.length ? v : v - this.b.length;
    }

    public final void q() {
        ++this.modCount;
    }

    @Override
    public final boolean remove(Object object0) {
        int v = this.indexOf(object0);
        if(v == -1) {
            return false;
        }
        this.d(v);
        return true;
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        int v3;
        q.g(collection0, "elements");
        int v = 0;
        if(!this.isEmpty() && this.b.length != 0) {
            int v1 = this.p(this.b() + this.a);
            int v2 = this.a;
            if(v2 < v1) {
                v3 = v2;
                while(v2 < v1) {
                    Object object0 = this.b[v2];
                    if(collection0.contains(object0)) {
                        v = 1;
                    }
                    else {
                        this.b[v3] = object0;
                        ++v3;
                    }
                    ++v2;
                }
                n.c0(v3, v1, null, this.b);
            }
            else {
                int v4 = 0;
                int v5 = v2;
                while(v2 < this.b.length) {
                    Object[] arr_object = this.b;
                    Object object1 = arr_object[v2];
                    arr_object[v2] = null;
                    if(collection0.contains(object1)) {
                        v4 = 1;
                    }
                    else {
                        this.b[v5] = object1;
                        ++v5;
                    }
                    ++v2;
                }
                v3 = this.p(v5);
                while(v < v1) {
                    Object[] arr_object1 = this.b;
                    Object object2 = arr_object1[v];
                    arr_object1[v] = null;
                    if(collection0.contains(object2)) {
                        v4 = 1;
                    }
                    else {
                        this.b[v3] = object2;
                        v3 = this.i(v3);
                    }
                    ++v;
                }
                v = v4;
            }
            if(v) {
                this.q();
                this.c = this.l(v3 - this.a);
            }
        }
        return v != 0;
    }

    @Override
    public final Object removeFirst() {
        if(this.isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        this.q();
        Object[] arr_object = this.b;
        int v = this.a;
        Object object0 = arr_object[v];
        arr_object[v] = null;
        this.a = this.i(v);
        this.c = this.b() - 1;
        return object0;
    }

    @Override
    public final Object removeLast() {
        if(this.isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        this.q();
        int v = this.a;
        int v1 = this.p(k.s(this) + v);
        Object[] arr_object = this.b;
        Object object0 = arr_object[v1];
        arr_object[v1] = null;
        this.c = this.b() - 1;
        return object0;
    }

    @Override
    public final void removeRange(int v, int v1) {
        int v2 = this.c;
        f.Companion.getClass();
        c.d(v, v1, v2);
        int v3 = v1 - v;
        if(v3 == 0) {
            return;
        }
        if(v3 == this.c) {
            this.clear();
            return;
        }
        if(v3 == 1) {
            this.d(v);
            return;
        }
        this.q();
        if(v < this.c - v1) {
            int v4 = this.p(this.a + (v - 1));
            int v5 = this.p(this.a + (v1 - 1));
            while(v > 0) {
                int v6 = Math.min(v, Math.min(v4 + 1, v5 + 1));
                int v7 = v5 - v6;
                int v8 = v4 - v6;
                n.W(this.b, v7 + 1, this.b, v8 + 1, v4 + 1);
                v4 = this.l(v8);
                v5 = this.l(v7);
                v -= v6;
            }
            int v9 = this.p(this.a + v3);
            this.o(this.a, v9);
            this.a = v9;
        }
        else {
            int v10 = this.p(this.a + v1);
            int v11 = this.p(this.a + v);
            int v12 = this.c;
            while(true) {
                v12 -= v1;
                if(v12 <= 0) {
                    break;
                }
                v1 = Math.min(v12, Math.min(this.b.length - v10, this.b.length - v11));
                int v13 = v10 + v1;
                n.W(this.b, v11, this.b, v10, v13);
                v10 = this.p(v13);
                v11 = this.p(v11 + v1);
            }
            int v14 = this.p(this.c + this.a);
            this.o(this.l(v14 - v3), v14);
        }
        this.c -= v3;
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        int v3;
        q.g(collection0, "elements");
        int v = 0;
        if(!this.isEmpty() && this.b.length != 0) {
            int v1 = this.p(this.b() + this.a);
            int v2 = this.a;
            if(v2 < v1) {
                v3 = v2;
                while(v2 < v1) {
                    Object object0 = this.b[v2];
                    if(collection0.contains(object0)) {
                        this.b[v3] = object0;
                        ++v3;
                    }
                    else {
                        v = 1;
                    }
                    ++v2;
                }
                n.c0(v3, v1, null, this.b);
            }
            else {
                int v4 = 0;
                int v5 = v2;
                while(v2 < this.b.length) {
                    Object[] arr_object = this.b;
                    Object object1 = arr_object[v2];
                    arr_object[v2] = null;
                    if(collection0.contains(object1)) {
                        this.b[v5] = object1;
                        ++v5;
                    }
                    else {
                        v4 = 1;
                    }
                    ++v2;
                }
                v3 = this.p(v5);
                while(v < v1) {
                    Object[] arr_object1 = this.b;
                    Object object2 = arr_object1[v];
                    arr_object1[v] = null;
                    if(collection0.contains(object2)) {
                        this.b[v3] = object2;
                        v3 = this.i(v3);
                    }
                    else {
                        v4 = 1;
                    }
                    ++v;
                }
                v = v4;
            }
            if(v) {
                this.q();
                this.c = this.l(v3 - this.a);
            }
        }
        return v != 0;
    }

    @Override
    public final Object set(int v, Object object0) {
        int v1 = this.c;
        f.Companion.getClass();
        c.b(v, v1);
        int v2 = this.p(this.a + v);
        Object[] arr_object = this.b;
        Object object1 = arr_object[v2];
        arr_object[v2] = object0;
        return object1;
    }

    @Override
    public final Object[] toArray() {
        return this.toArray(new Object[this.b()]);
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        q.g(arr_object, "array");
        int v = this.c;
        if(arr_object.length < v) {
            Object object0 = Array.newInstance(arr_object.getClass().getComponentType(), v);
            q.e(object0, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            arr_object = (Object[])object0;
        }
        int v1 = this.p(this.c + this.a);
        int v2 = this.a;
        if(v2 < v1) {
            n.Y(this.b, v2, arr_object, v1, 2);
        }
        else if(!this.isEmpty()) {
            n.W(this.b, 0, arr_object, this.a, this.b.length);
            n.W(this.b, this.b.length - this.a, arr_object, 0, v1);
        }
        int v3 = this.c;
        if(v3 < arr_object.length) {
            arr_object[v3] = null;
        }
        return arr_object;
    }
}

