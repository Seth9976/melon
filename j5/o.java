package j5;

import A7.d;
import coil.memory.MemoryCache.Key;
import i5.e;
import kotlin.jvm.internal.q;
import t5.j;

public final class o {
    public final Object a;
    public final u b;
    public final e c;

    public o(Object object0, u u0, e e0) {
        this.a = object0;
        this.b = u0;
        this.c = e0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof o) {
                Object object1 = ((o)object0).a;
                this.b.getClass();
                Object object2 = this.a;
                if(object2 == object1) {
                    return q.b(this.c, ((o)object0).c);
                }
                if(object2 instanceof j && object1 instanceof j) {
                    return q.b(((j)object2).a, ((j)object1).a) && ((j)object2).b.equals(((j)object1).b) && q.b(((j)object2).B, ((j)object1).B) && q.b(((j)object2).e, ((j)object1).e) && ((j)object2).f == ((j)object1).f && q.b(((j)object2).i, ((j)object1).i) && q.b(((j)object2).k, ((j)object1).k) && ((j)object2).m == ((j)object1).m && ((j)object2).n == ((j)object1).n && ((j)object2).o == ((j)object1).o && ((j)object2).p == ((j)object1).p && ((j)object2).q == ((j)object1).q && ((j)object2).r == ((j)object1).r && ((j)object2).s == ((j)object1).s && ((j)object2).y.equals(((j)object1).y) && ((j)object2).z == ((j)object1).z && ((j)object2).g == ((j)object1).g && ((j)object2).A.equals(((j)object1).A) ? q.b(this.c, ((o)object0).c) : false;
                }
                return q.b(object2, object1) && q.b(this.c, ((o)object0).c);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        this.b.getClass();
        Object object0 = this.a;
        int v = 0;
        if(!(object0 instanceof j)) {
            return object0 == null ? this.c.hashCode() : this.c.hashCode() + object0.hashCode() * 0x1F;
        }
        int v1 = ((j)object0).a.hashCode();
        int v2 = ((j)object0).b.hashCode();
        MemoryCache.Key memoryCache$Key0 = ((j)object0).B;
        int v3 = memoryCache$Key0 == null ? 0 : memoryCache$Key0.hashCode();
        MemoryCache.Key memoryCache$Key1 = ((j)object0).e;
        if(memoryCache$Key1 != null) {
            v = memoryCache$Key1.hashCode();
        }
        return this.c.hashCode() + (((j)object0).A.a.hashCode() + (((j)object0).g.hashCode() + (((j)object0).z.hashCode() + (((j)object0).y.hashCode() + (((j)object0).s.hashCode() + (((j)object0).r.hashCode() + (((j)object0).q.hashCode() + d.e(d.e(d.e(d.e((((j)object0).k.hashCode() + d.d((((j)object0).f.hashCode() + (((v2 + v1 * 0x1F) * 0x1F + v3) * 0x1F + v) * 961) * 961, 0x1F, ((j)object0).i)) * 0x1F, 0x1F, ((j)object0).m), 0x1F, ((j)object0).n), 0x1F, ((j)object0).o), 0x1F, ((j)object0).p)) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F;
    }
}

