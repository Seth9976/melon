package com.melon.ui;

import kotlin.jvm.internal.q;

public final class b1 extends d1 {
    public final e3 a;

    public b1(e3 e30) {
        this.a = e30;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b1 ? q.b(this.a, ((b1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "NotificationScreen(uiState=" + this.a + ")";
    }
}

