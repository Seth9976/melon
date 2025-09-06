package com.melon.ui;

import com.iloen.melon.sns.model.Sharable;
import kotlin.jvm.internal.q;

public final class w3 extends x3 {
    public final Sharable a;

    public w3(Sharable sharable0) {
        q.g(sharable0, "sharable");
        super();
        this.a = sharable0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof w3 ? q.b(this.a, ((w3)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ShowSnsListPopup(sharable=" + this.a + ")";
    }
}

