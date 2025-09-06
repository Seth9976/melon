package com.google.gson;

import T7.o;

public final class t extends q {
    public final o a;

    public t() {
        this.a = new o(false);
    }

    public final void d(String s, q q0) {
        if(q0 == null) {
            q0 = s.a;
        }
        this.a.put(s, q0);
    }

    public final void e(String s, String s1) [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this || object0 instanceof t && ((t)object0).a.equals(this.a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }
}

