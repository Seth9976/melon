package com.melon.ui;

import kotlin.jvm.internal.q;

public final class z1 implements k2 {
    public final String a;
    public final String b;

    public z1(String s, String s1) {
        q.g(s, "ownerMemberKey");
        super();
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof z1)) {
            return false;
        }
        return q.b(this.a, ((z1)object0).a) ? q.b(this.b, ((z1)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? v * 0x1F : v * 0x1F + this.b.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickCreatorsMusic(ownerMemberKey=" + this.a + ", withDrawYN=" + this.b + ")";
    }
}

