package com.melon.ui;

import kotlin.jvm.internal.q;

public final class y1 implements k2 {
    public final String a;

    public y1(String s) {
        q.g(s, "songId");
        super();
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof y1 ? q.b(this.a, ((y1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickChartReport(songId=" + this.a + ")";
    }
}

