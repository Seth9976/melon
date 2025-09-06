package com.melon.ui;

import U4.x;
import java.util.List;
import kotlin.jvm.internal.q;

public final class m3 extends o3 {
    public final List a;
    public final String b;
    public final String c;

    public m3(String s, String s1, List list0) {
        q.g(list0, "playableList");
        q.g(s, "menuId");
        q.g(s1, "ocrGroupId");
        super();
        this.a = list0;
        this.b = s;
        this.c = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof m3)) {
            return false;
        }
        if(!q.b(this.a, ((m3)object0).a)) {
            return false;
        }
        return q.b(this.b, ((m3)object0).b) ? q.b(this.c, ((m3)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ShowContextMenuAddToPopup(playableList=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", menuId=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", ocrGroupId=");
        return x.m(stringBuilder0, this.c, ")");
    }
}

