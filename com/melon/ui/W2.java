package com.melon.ui;

import kotlin.jvm.internal.q;

public final class w2 extends L2 {
    public final String a;
    public final String b;

    public w2(String s, String s1) {
        q.g(s1, "contsTypeCode");
        super();
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof w2)) {
            return false;
        }
        return q.b(this.a, ((w2)object0).a) ? q.b(this.b, ((w2)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? this.b.hashCode() : this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickLikeWith(contsId=" + this.a + ", contsTypeCode=" + this.b + ")";
    }
}

