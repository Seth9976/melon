package com.melon.playback.melon.drm;

import com.iloen.melon.drm.CollectionRulesDcf;
import kotlin.jvm.internal.q;

public final class e extends f {
    public final int a;
    public final CollectionRulesDcf b;

    public e(int v, CollectionRulesDcf collectionRulesDcf0) {
        this.a = v;
        this.b = collectionRulesDcf0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof e)) {
            return false;
        }
        return this.a == ((e)object0).a ? q.b(this.b, ((e)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b == null ? this.a * 0x1F : this.a * 0x1F + this.b.hashCode();
    }

    @Override
    public final String toString() {
        return "Success(updateCount=" + this.a + ", info=" + this.b + ")";
    }
}

