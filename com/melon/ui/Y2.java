package com.melon.ui;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class y2 extends L2 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public y2(String s, String s1, String s2, String s3) {
        q.g(s, "songId");
        q.g(s1, "songName");
        q.g(s3, "menuId");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof y2)) {
            return false;
        }
        if(!q.b(this.a, ((y2)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((y2)object0).b)) {
            return false;
        }
        return q.b(this.c, ((y2)object0).c) ? q.b(this.d, ((y2)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
        return this.c == null ? this.d.hashCode() + v * 0x1F : this.d.hashCode() + (v + this.c.hashCode()) * 0x1F;
    }

    @Override
    public final String toString() {
        return d.n(d.o("ClickMixUp(songId=", this.a, ", songName=", this.b, ", artistId="), this.c, ", menuId=", this.d, ")");
    }
}

