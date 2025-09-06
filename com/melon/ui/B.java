package com.melon.ui;

import com.iloen.melon.playback.playlist.add.AddResult;

public final class b implements I4 {
    public final AddResult a;
    public final q b;

    public b(AddResult addResult0, q q0) {
        kotlin.jvm.internal.q.g(addResult0, "result");
        super();
        this.a = addResult0;
        this.b = q0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof b)) {
            return false;
        }
        return kotlin.jvm.internal.q.b(this.a, ((b)object0).a) ? kotlin.jvm.internal.q.b(this.b, ((b)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? v * 0x1F : v * 0x1F + this.b.hashCode();
    }

    @Override
    public final String toString() {
        return "AddPlayUiEvent(result=" + this.a + ", userEvent=" + this.b + ")";
    }
}

