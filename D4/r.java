package D4;

import A4.a;
import I4.b;
import d5.f;
import java.util.AbstractSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import je.p;
import je.w;
import kotlin.jvm.internal.q;

public final class r {
    public final String a;
    public final Object b;
    public final Set c;
    public final Set d;

    public r(String s, Map map0, AbstractSet abstractSet0, AbstractSet abstractSet1) {
        q.g(abstractSet0, "foreignKeys");
        super();
        this.a = s;
        this.b = map0;
        this.c = abstractSet0;
        this.d = abstractSet1;
    }

    public static final r a(b b0, String s) {
        return com.google.firebase.b.N(s, new a(b0));
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(!(object0 instanceof r) || !this.a.equals(((r)object0).a) || !this.b.equals(((r)object0).b) || !q.b(this.c, ((r)object0).c)) {
                return false;
            }
            Set set0 = this.d;
            if(set0 != null) {
                Set set1 = ((r)object0).d;
                return set1 == null ? true : set0.equals(set1);
            }
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("\n            |TableInfo {\n            |    name = \'");
        stringBuilder0.append(this.a);
        stringBuilder0.append("\',\n            |    columns = {");
        stringBuilder0.append(f.A(p.J0(((Map)this.b).values(), new A1.f(3))));
        stringBuilder0.append("\n            |    foreignKeys = {");
        stringBuilder0.append(f.A(this.c));
        stringBuilder0.append("\n            |    indices = {");
        Set set0 = this.d;
        List list0 = set0 == null ? w.a : p.J0(set0, new A1.f(4));
        stringBuilder0.append(f.A(list0));
        stringBuilder0.append("\n            |}\n        ");
        return Tf.p.d0(stringBuilder0.toString());
    }
}

