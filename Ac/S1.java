package Ac;

import kotlin.jvm.internal.q;

public final class s1 implements C1 {
    public final String a;

    public s1(String s) {
        q.g(s, "originalUrl");
        super();
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof s1 ? q.b(this.a, ((s1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "AttachmentLinkGenrlItemClickEvent(originalUrl=" + this.a + ")";
    }
}

