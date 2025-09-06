package p8;

import A7.d;
import com.kakao.tiara.data.Meta;
import kotlin.jvm.internal.q;

public final class s {
    public final String a;
    public final String b;
    public final String c;
    public final Meta d;

    public s(String s, String s1, String s2, Meta meta0) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = meta0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof s)) {
            return false;
        }
        if(!q.b(this.a, ((s)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((s)object0).b)) {
            return false;
        }
        return q.b(this.c, ((s)object0).c) ? q.b(this.d, ((s)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        Meta meta0 = this.d;
        if(meta0 != null) {
            v = meta0.hashCode();
        }
        return ((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("MelonTiaraProperty(section=", this.a, ", page=", this.b, ", menuId=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", pageMeta=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

