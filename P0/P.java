package p0;

import O.B;
import P0.r;
import androidx.compose.runtime.j0;
import i0.b;
import i0.e;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import we.k;
import xe.c;

public final class p implements List, RandomAccess, t, c {
    public o a;

    public p() {
        h h0 = m.k();
        i0.h h1 = i0.h.b;
        o o0 = new o(h0.g(), h1);
        if(!(h0 instanceof p0.c)) {
            o0.b = new o(1L, h1);
        }
        this.a = o0;
    }

    @Override
    public final void add(int v, Object object0) {
        h h0;
        b b0;
        int v2;
        do {
            synchronized(q.a) {
                o o0 = this.a;
                kotlin.jvm.internal.q.e(o0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                o o1 = (o)m.i(o0);
                v2 = o1.d;
                b0 = o1.c;
            }
            kotlin.jvm.internal.q.d(b0);
            b b1 = b0.a(v, object0);
            if(b1.equals(b0)) {
                break;
            }
            o o2 = this.a;
            kotlin.jvm.internal.q.e(o2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized(m.b) {
                h0 = m.k();
                boolean z = p.d(((o)m.w(o2, this, h0)), v2, b1, true);
            }
            m.n(h0, this);
        }
        while(!z);
    }

    @Override
    public final boolean add(Object object0) {
        h h0;
        b b0;
        int v1;
        do {
            synchronized(q.a) {
                o o0 = this.a;
                kotlin.jvm.internal.q.e(o0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                o o1 = (o)m.i(o0);
                v1 = o1.d;
                b0 = o1.c;
            }
            kotlin.jvm.internal.q.d(b0);
            b b1 = b0.b(object0);
            if(b1.equals(b0)) {
                return false;
            }
            o o2 = this.a;
            kotlin.jvm.internal.q.e(o2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized(m.b) {
                h0 = m.k();
                boolean z = p.d(((o)m.w(o2, this, h0)), v1, b1, true);
            }
            m.n(h0, this);
        }
        while(!z);
        return true;
    }

    @Override
    public final boolean addAll(int v, Collection collection0) {
        return this.k(new B(v, collection0));
    }

    @Override
    public final boolean addAll(Collection collection0) {
        h h0;
        b b0;
        int v1;
        do {
            synchronized(q.a) {
                o o0 = this.a;
                kotlin.jvm.internal.q.e(o0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                o o1 = (o)m.i(o0);
                v1 = o1.d;
                b0 = o1.c;
            }
            kotlin.jvm.internal.q.d(b0);
            b b1 = b0.d(collection0);
            if(kotlin.jvm.internal.q.b(b1, b0)) {
                return false;
            }
            o o2 = this.a;
            kotlin.jvm.internal.q.e(o2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized(m.b) {
                h0 = m.k();
                boolean z = p.d(((o)m.w(o2, this, h0)), v1, b1, true);
            }
            m.n(h0, this);
        }
        while(!z);
        return true;
    }

    @Override  // p0.t
    public final void b(v v0) {
        v0.b = this.a;
        this.a = (o)v0;
    }

    @Override
    public final void clear() {
        h h0;
        o o0 = this.a;
        kotlin.jvm.internal.q.e(o0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        synchronized(m.b) {
            h0 = m.k();
            o o1 = (o)m.w(o0, this, h0);
            synchronized(q.a) {
                o1.c = i0.h.b;
                ++o1.d;
                ++o1.e;
            }
        }
        m.n(h0, this);
    }

    @Override
    public final boolean contains(Object object0) {
        return this.g().c.contains(object0);
    }

    @Override
    public final boolean containsAll(Collection collection0) {
        return this.g().c.containsAll(collection0);
    }

    public static boolean d(o o0, int v, b b0, boolean z) {
        boolean z1;
        synchronized(q.a) {
            int v1 = o0.d;
            if(v1 == v) {
                o0.c = b0;
                z1 = true;
                if(z) {
                    ++o0.e;
                }
                o0.d = v1 + 1;
            }
            else {
                z1 = false;
            }
        }
        return z1;
    }

    @Override  // p0.t
    public final v e() {
        return this.a;
    }

    public final o g() {
        o o0 = this.a;
        kotlin.jvm.internal.q.e(o0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (o)m.t(o0, this);
    }

    @Override
    public final Object get(int v) {
        return this.g().c.get(v);
    }

    public final int i() {
        o o0 = this.a;
        kotlin.jvm.internal.q.e(o0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((o)m.i(o0)).e;
    }

    @Override
    public final int indexOf(Object object0) {
        return this.g().c.indexOf(object0);
    }

    @Override
    public final boolean isEmpty() {
        return this.g().c.isEmpty();
    }

    @Override
    public final Iterator iterator() {
        return this.listIterator();
    }

    public final boolean k(k k0) {
        h h0;
        b b0;
        int v1;
        Object object0;
        while(true) {
            synchronized(q.a) {
                o o0 = this.a;
                kotlin.jvm.internal.q.e(o0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                o o1 = (o)m.i(o0);
                v1 = o1.d;
                b0 = o1.c;
            }
            kotlin.jvm.internal.q.d(b0);
            e e0 = b0.e();
            object0 = k0.invoke(e0);
            b b1 = e0.e();
            if(kotlin.jvm.internal.q.b(b1, b0)) {
                break;
            }
            o o2 = this.a;
            kotlin.jvm.internal.q.e(o2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized(m.b) {
                h0 = m.k();
                boolean z = p.d(((o)m.w(o2, this, h0)), v1, b1, true);
            }
            m.n(h0, this);
            if(z) {
                return ((Boolean)object0).booleanValue();
            }
        }
        return ((Boolean)object0).booleanValue();
    }

    public final void l(int v, int v1) {
        h h0;
        b b0;
        int v3;
        while(true) {
            synchronized(q.a) {
                o o0 = this.a;
                kotlin.jvm.internal.q.e(o0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                o o1 = (o)m.i(o0);
                v3 = o1.d;
                b0 = o1.c;
            }
            kotlin.jvm.internal.q.d(b0);
            e e0 = b0.e();
            e0.subList(v, v1).clear();
            b b1 = e0.e();
            if(kotlin.jvm.internal.q.b(b1, b0)) {
                break;
            }
            o o2 = this.a;
            kotlin.jvm.internal.q.e(o2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized(m.b) {
                h0 = m.k();
                boolean z = p.d(((o)m.w(o2, this, h0)), v3, b1, true);
            }
            m.n(h0, this);
            if(z) {
                return;
            }
        }
    }

    @Override
    public final int lastIndexOf(Object object0) {
        return this.g().c.lastIndexOf(object0);
    }

    @Override
    public final ListIterator listIterator() {
        return new r(this, 0);
    }

    @Override
    public final ListIterator listIterator(int v) {
        return new r(this, v);
    }

    @Override
    public final Object remove(int v) {
        h h0;
        b b0;
        int v2;
        Object object0 = this.get(v);
        do {
            synchronized(q.a) {
                o o0 = this.a;
                kotlin.jvm.internal.q.e(o0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                o o1 = (o)m.i(o0);
                v2 = o1.d;
                b0 = o1.c;
            }
            kotlin.jvm.internal.q.d(b0);
            b b1 = b0.i(v);
            if(b1.equals(b0)) {
                break;
            }
            o o2 = this.a;
            kotlin.jvm.internal.q.e(o2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized(m.b) {
                h0 = m.k();
                boolean z = p.d(((o)m.w(o2, this, h0)), v2, b1, true);
            }
            m.n(h0, this);
        }
        while(!z);
        return object0;
    }

    @Override
    public final boolean remove(Object object0) {
        h h0;
        b b0;
        int v1;
        do {
            synchronized(q.a) {
                o o0 = this.a;
                kotlin.jvm.internal.q.e(o0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                o o1 = (o)m.i(o0);
                v1 = o1.d;
                b0 = o1.c;
            }
            kotlin.jvm.internal.q.d(b0);
            int v2 = b0.indexOf(object0);
            b b1 = v2 == -1 ? b0 : b0.i(v2);
            if(b1.equals(b0)) {
                return false;
            }
            o o2 = this.a;
            kotlin.jvm.internal.q.e(o2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized(m.b) {
                h0 = m.k();
                boolean z = p.d(((o)m.w(o2, this, h0)), v1, b1, true);
            }
            m.n(h0, this);
        }
        while(!z);
        return true;
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        h h0;
        b b0;
        int v1;
        do {
            synchronized(q.a) {
                o o0 = this.a;
                kotlin.jvm.internal.q.e(o0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                o o1 = (o)m.i(o0);
                v1 = o1.d;
                b0 = o1.c;
            }
            kotlin.jvm.internal.q.d(b0);
            b b1 = b0.g(new androidx.fragment.app.p(1, collection0));
            if(kotlin.jvm.internal.q.b(b1, b0)) {
                return false;
            }
            o o2 = this.a;
            kotlin.jvm.internal.q.e(o2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized(m.b) {
                h0 = m.k();
                boolean z = p.d(((o)m.w(o2, this, h0)), v1, b1, true);
            }
            m.n(h0, this);
        }
        while(!z);
        return true;
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        return this.k(new androidx.fragment.app.p(3, collection0));
    }

    @Override
    public final Object set(int v, Object object0) {
        h h0;
        b b0;
        int v2;
        Object object1 = this.get(v);
        do {
            synchronized(q.a) {
                o o0 = this.a;
                kotlin.jvm.internal.q.e(o0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                o o1 = (o)m.i(o0);
                v2 = o1.d;
                b0 = o1.c;
            }
            kotlin.jvm.internal.q.d(b0);
            b b1 = b0.k(v, object0);
            if(b1.equals(b0)) {
                break;
            }
            o o2 = this.a;
            kotlin.jvm.internal.q.e(o2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            synchronized(m.b) {
                h0 = m.k();
                boolean z = p.d(((o)m.w(o2, this, h0)), v2, b1, false);
            }
            m.n(h0, this);
        }
        while(!z);
        return object1;
    }

    @Override
    public final int size() {
        return this.g().c.size();
    }

    @Override
    public final List subList(int v, int v1) {
        if(v < 0 || v > v1 || v1 > this.size()) {
            j0.a("fromIndex or toIndex are out of bounds");
        }
        return new w(this, v, v1);
    }

    @Override
    public final Object[] toArray() {
        return kotlin.jvm.internal.p.a(this);
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        return kotlin.jvm.internal.p.b(this, arr_object);
    }

    @Override
    public final String toString() {
        o o0 = this.a;
        kotlin.jvm.internal.q.e(o0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return "SnapshotStateList(value=" + ((o)m.i(o0)).c + ")@" + this.hashCode();
    }
}

