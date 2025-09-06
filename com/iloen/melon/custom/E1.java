package com.iloen.melon.custom;

import Vb.p0;
import androidx.lifecycle.D;
import androidx.lifecycle.L;
import androidx.lifecycle.M;
import com.iloen.melon.utils.log.LogU;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.q;

public final class e1 extends L {
    public final AtomicBoolean l;

    public e1() {
        this.l = new AtomicBoolean(false);
    }

    @Override  // androidx.lifecycle.K
    public final void observe(D d0, M m0) {
        q.g(d0, "owner");
        if(this.hasActiveObservers()) {
            LogU.Companion.w("SingleLiveEvent", "Multiple observers registered but only one will be notified of changes.");
        }
        super.observe(d0, new d1(0, new p0(9, this, m0)));
    }

    @Override  // androidx.lifecycle.K
    public final void setValue(Object object0) {
        this.l.set(true);
        super.setValue(object0);
    }
}

