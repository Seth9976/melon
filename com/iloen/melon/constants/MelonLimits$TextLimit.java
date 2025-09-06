package com.iloen.melon.constants;

import A8.s;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"com/iloen/melon/constants/MelonLimits$TextLimit", "", "E9/w", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonLimits.TextLimit {
    public final int a;
    public static final MelonLimits.TextLimit b;
    public static final MelonLimits.TextLimit c;
    public static final MelonLimits.TextLimit d;
    public static final MelonLimits.TextLimit e;

    static {
        MelonLimits.TextLimit.b = new MelonLimits.TextLimit(3000);
        MelonLimits.TextLimit.c = new MelonLimits.TextLimit(40);
        MelonLimits.TextLimit.d = new MelonLimits.TextLimit(1000);
        MelonLimits.TextLimit.e = new MelonLimits.TextLimit(30);
    }

    public MelonLimits.TextLimit(int v) {
        this.a = v;
    }

    public final int a(String s) {
        q.g(s, "text");
        int v = s.length();
        return this.a == -1 || v <= this.a ? 0 : v - this.a;
    }

    @Override
    public final String toString() {
        return "TextLimit {unit:" + s.a + ", max:" + this.a + ", min:-1}";
    }
}

