package m0;

import androidx.compose.runtime.e1;
import androidx.compose.runtime.l0;
import j0.j;
import java.util.Map;
import je.i;
import kotlin.jvm.internal.q;
import l0.a;
import l0.b;

public final class f extends i {
    public b a;
    public j b;
    public Object c;
    public int d;
    public int e;
    public g f;

    public f(g g0) {
        this.a = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.b = g0.a;
        this.e = g0.b;
        this.f = g0;
    }

    public final g a() {
        g g0 = this.f;
        if(this.b != g0.a) {
            this.a = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
            g0 = new g(this.b, this.size());  // 初始化器: Lj0/b;-><init>(Lj0/j;I)V
        }
        this.f = g0;
        return g0;
    }

    public final boolean b(Object object0) {
        j j0 = this.b;
        return object0 == null ? j0.d(0, 0, null) : j0.d(object0.hashCode(), 0, object0);
    }

    @Override
    public final void clear() {
        this.b = j.e;
        this.g(0);
    }

    @Override
    public final boolean containsKey(Object object0) {
        return object0 instanceof l0 ? this.b(((l0)object0)) : false;
    }

    @Override
    public final boolean containsValue(Object object0) {
        return object0 instanceof e1 ? super.containsValue(((e1)object0)) : false;
    }

    public final Object d(Object object0) {
        j j0 = this.b;
        return object0 == null ? j0.g(0, 0, null) : j0.g(object0.hashCode(), 0, object0);
    }

    public final Object e(Object object0) {
        this.c = null;
        j j0 = this.b.n((object0 == null ? 0 : object0.hashCode()), object0, 0, this);
        if(j0 == null) {
            j0 = j.e;
        }
        this.b = j0;
        return this.c;
    }

    public final void g(int v) {
        this.e = v;
        ++this.d;
    }

    @Override
    public final Object get(Object object0) {
        return !(object0 instanceof l0) ? null : ((e1)this.d(((l0)object0)));
    }

    @Override
    public final Object getOrDefault(Object object0, Object object1) {
        return !(object0 instanceof l0) ? object1 : ((e1)super.getOrDefault(((l0)object0), ((e1)object1)));
    }

    @Override
    public final Object put(Object object0, Object object1) {
        this.c = null;
        this.b = this.b.l((object0 == null ? 0 : object0.hashCode()), object0, object1, 0, this);
        return this.c;
    }

    @Override
    public final void putAll(Map map0) {
        j0.b b0 = null;
        j0.b b1 = map0 instanceof j0.b ? ((j0.b)map0) : null;
        if(b1 == null) {
            f f0 = map0 instanceof f ? ((f)map0) : null;
            if(f0 != null) {
                b0 = f0.a();
            }
        }
        else {
            b0 = b1;
        }
        if(b0 != null) {
            a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
            a0.a = 0;
            int v = this.size();
            j j0 = this.b;
            q.e(b0.a, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
            this.b = j0.m(b0.a, 0, a0, this);
            int v1 = b0.b + v - a0.a;
            if(v != v1) {
                this.g(v1);
            }
            return;
        }
        super.putAll(map0);
    }

    @Override
    public final Object remove(Object object0) {
        return !(object0 instanceof l0) ? null : ((e1)this.e(((l0)object0)));
    }

    @Override
    public final boolean remove(Object object0, Object object1) {
        int v = this.size();
        j j0 = this.b.o((object0 == null ? 0 : object0.hashCode()), object0, object1, 0, this);
        if(j0 == null) {
            j0 = j.e;
        }
        this.b = j0;
        return v != this.size();
    }
}

