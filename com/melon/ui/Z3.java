package com.melon.ui;

import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.target.SnsTarget;
import kotlin.jvm.internal.q;

public final class z3 extends N3 {
    public final String a;
    public final Sharable b;
    public final SnsTarget c;

    public z3(String s, Sharable sharable0, SnsTarget snsTarget0) {
        q.g(sharable0, "sharable");
        super();
        this.a = s;
        this.b = sharable0;
        this.c = snsTarget0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof z3)) {
            return false;
        }
        if(!q.b(this.a, ((z3)object0).a)) {
            return false;
        }
        return q.b(this.b, ((z3)object0).b) ? q.b(this.c, ((z3)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? this.c.hashCode() + this.b.hashCode() * 0x1F : this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "GetShareGatePageUrl(displayMsg=" + this.a + ", sharable=" + this.b + ", targetOther=" + this.c + ")";
    }
}

