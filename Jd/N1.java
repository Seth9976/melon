package jd;

import A7.d;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.Meta;
import gd.Z3;
import kotlin.jvm.internal.q;

public final class n1 extends Z3 {
    public final ActionKind a;
    public final String b;
    public final String c;
    public final String d;
    public final Meta e;

    public n1(ActionKind actionKind0, String s, String s1, String s2, Meta meta0) {
        this.a = actionKind0;
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = meta0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof n1)) {
            return false;
        }
        if(this.a != ((n1)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((n1)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((n1)object0).c)) {
            return false;
        }
        return q.b(this.d, ((n1)object0).d) ? q.b(this.e, ((n1)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d == null ? 0 : this.d.hashCode();
        Meta meta0 = this.e;
        if(meta0 != null) {
            v = meta0.hashCode();
        }
        return (((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("TiaraEvent(actionKind=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", actionName=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", clickLayer1=");
        d.u(stringBuilder0, this.c, ", clickCopy=", this.d, ", eventMeta=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

