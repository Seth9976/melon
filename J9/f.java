package J9;

import Hb.j;
import e0.b;
import k8.Y;

public final class f {
    public final j a;

    public f(j j0) {
        Y.r(2, "chatType");
        super();
        this.a = j0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof f && this.a.equals(((f)object0).a);
    }

    @Override
    public final int hashCode() {
        return (b.b(2) + this.a.hashCode() * 0x1F) * 0x1F + 1;
    }

    @Override
    public final String toString() {
        return "LeonChatConfig(phase=" + this.a + ", chatType=" + "MELON" + ", debuggable=true)";
    }
}

