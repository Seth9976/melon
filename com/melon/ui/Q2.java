package com.melon.ui;

import kotlin.jvm.internal.q;

public final class q2 extends L2 {
    public final String a;
    public final String b;

    public q2(String s, String s1) {
        q.g(s, "playlistSeq");
        q.g(s1, "playlistTitle");
        super();
        this.a = s;
        this.b = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof q2)) {
            return false;
        }
        return q.b(this.a, ((q2)object0).a) ? q.b(this.b, ((q2)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickDeletePlaylist(playlistSeq=" + this.a + ", playlistTitle=" + this.b + ")";
    }
}

