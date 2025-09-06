package com.melon.ui;

import A7.d;
import java.util.List;
import k8.Y;
import kotlin.jvm.internal.q;

public final class v4 implements I4 {
    public final String a;
    public final List b;
    public final List c;

    public v4(String s, List list0, List list1) {
        q.g(list0, "receiverList");
        q.g(list1, "playableList");
        super();
        this.a = s;
        this.b = list0;
        this.c = list1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof v4)) {
            return false;
        }
        if(!q.b(this.a, ((v4)object0).a)) {
            return false;
        }
        return q.b(this.b, ((v4)object0).b) ? q.b(this.c, ((v4)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + d.d(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("PresentSend(menuId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", receiverList=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", playableList=");
        return Y.m(stringBuilder0, this.c, ")");
    }
}

