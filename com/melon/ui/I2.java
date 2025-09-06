package com.melon.ui;

import kotlin.jvm.internal.q;

public final class i2 implements k2 {
    public final String a;
    public final String b;

    public i2(String s, String s1) {
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof i2)) {
            return false;
        }
        return q.b(this.a, ((i2)object0).a) ? q.b(this.b, ((i2)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickTikTok(linkType=" + this.a + ", linkUrl=" + this.b + ")";
    }
}

