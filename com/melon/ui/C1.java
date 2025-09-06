package com.melon.ui;

import com.melon.net.res.common.ResponseBase;
import kotlin.jvm.internal.q;

public final class c1 extends d1 {
    public final ResponseBase a;

    public c1(ResponseBase responseBase0) {
        this.a = responseBase0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c1 ? q.b(this.a, ((c1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Success(responseBase=" + this.a + ")";
    }
}

