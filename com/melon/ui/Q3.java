package com.melon.ui;

import A7.d;
import Pc.e;
import U4.x;
import java.util.List;
import kotlin.jvm.internal.q;

public final class q3 implements e {
    public final String a;
    public final List b;
    public final String c;

    public q3(String s, List list0, String s1) {
        q.g(list0, "playableList");
        q.g(s1, "ocrGroupId");
        super();
        this.a = s;
        this.b = list0;
        this.c = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof q3)) {
            return false;
        }
        if(!q.b(this.a, ((q3)object0).a)) {
            return false;
        }
        return q.b(this.b, ((q3)object0).b) ? q.b(this.c, ((q3)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + d.d(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("FetchAndSelectPlaylist(playlistType=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", playableList=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", ocrGroupId=");
        return x.m(stringBuilder0, this.c, ")");
    }
}

