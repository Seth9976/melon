package com.melon.ui;

import com.iloen.melon.utils.NameValuePairList;
import kotlin.jvm.internal.q;

public final class u4 implements I4 {
    public final String a;
    public final NameValuePairList b;

    public u4(String s, NameValuePairList nameValuePairList0) {
        q.g(s, "url");
        super();
        this.a = s;
        this.b = nameValuePairList0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof u4 && q.b(this.a, ((u4)object0).a) && this.b.equals(((u4)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 961;
    }

    @Override
    public final String toString() {
        return "Download(url=" + this.a + ", title=, params=" + this.b + ")";
    }
}

