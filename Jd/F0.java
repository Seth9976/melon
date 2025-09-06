package jd;

import A7.d;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.ActionType;
import com.kakao.tiara.data.Meta;
import gd.Z3;
import kotlin.jvm.internal.q;

public final class f0 extends Z3 {
    public final ActionKind a;
    public final ActionType b;
    public final String c;
    public final String d;
    public final String e;
    public final Meta f;

    public f0(ActionKind actionKind0, ActionType actionType0, String s, String s1, String s2, Meta meta0, int v) {
        if((v & 1) != 0) {
            actionKind0 = null;
        }
        if((v & 2) != 0) {
            actionType0 = null;
        }
        if((v & 0x20) != 0) {
            meta0 = null;
        }
        super();
        this.a = actionKind0;
        this.b = actionType0;
        this.c = s;
        this.d = s1;
        this.e = s2;
        this.f = meta0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof f0)) {
            return false;
        }
        if(this.a != ((f0)object0).a) {
            return false;
        }
        if(this.b != ((f0)object0).b) {
            return false;
        }
        if(!q.b(this.c, ((f0)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((f0)object0).d)) {
            return false;
        }
        return q.b(this.e, ((f0)object0).e) ? q.b(this.f, ((f0)object0).f) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d == null ? 0 : this.d.hashCode();
        int v5 = this.e == null ? 0 : this.e.hashCode();
        Meta meta0 = this.f;
        if(meta0 != null) {
            v = meta0.hashCode();
        }
        return ((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("TiaraEvent(actionKind=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", actionType=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", actionName=");
        d.u(stringBuilder0, this.c, ", clickLayer1=", this.d, ", clickCopy=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", eventMeta=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

