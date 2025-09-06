package com.melon.ui;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;

public final class j2 implements k2 {
    public final boolean a;
    public final int b;
    public final String c;

    public j2(boolean z, int v, String s) {
        q.g(s, "contsTypeCode");
        super();
        this.a = z;
        this.b = v;
        this.c = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof j2)) {
            return false;
        }
        if(this.a != ((j2)object0).a) {
            return false;
        }
        return this.b == ((j2)object0).b ? q.b(this.c, ((j2)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + d.b(this.b, Boolean.hashCode(this.a) * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("LikeUiUpdate(isLike=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", likeCnt=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", contsTypeCode=");
        return x.m(stringBuilder0, this.c, ")");
    }
}

