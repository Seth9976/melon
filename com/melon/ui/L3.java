package com.melon.ui;

import A7.d;
import java.util.List;
import kotlin.jvm.internal.q;

public final class l3 extends o3 {
    public final String a;
    public final List b;
    public final List c;
    public final String d;

    public l3(String s, String s1, List list0, List list1) {
        q.g(s, "playlistType");
        q.g(list1, "playableList");
        q.g(s1, "ocrGroupId");
        super();
        this.a = s;
        this.b = list0;
        this.c = list1;
        this.d = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof l3)) {
            return false;
        }
        if(!q.b(this.a, ((l3)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((l3)object0).b)) {
            return false;
        }
        return q.b(this.c, ((l3)object0).c) ? q.b(this.d, ((l3)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? this.d.hashCode() + d.d(v * 961, 0x1F, this.c) : this.d.hashCode() + d.d((v * 0x1F + this.b.hashCode()) * 0x1F, 0x1F, this.c);
    }

    @Override
    public final String toString() {
        return "ShowAddToPlayListPopup(playlistType=" + this.a + ", contextItemInfoList=" + this.b + ", playableList=" + this.c + ", ocrGroupId=" + this.d + ")";
    }
}

