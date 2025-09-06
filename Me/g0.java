package Me;

import kotlin.jvm.internal.q;

public abstract class g0 {
    public final String a;
    public final boolean b;

    public g0(String s, boolean z) {
        this.a = s;
        this.b = z;
    }

    public Integer a(g0 g00) {
        q.g(g00, "visibility");
        if(this == g00) {
            return 0;
        }
        Integer integer0 = (Integer)f0.a.get(this);
        Integer integer1 = (Integer)f0.a.get(g00);
        return integer0 == null || integer1 == null || integer0.equals(integer1) ? null : ((int)(((int)integer0) - ((int)integer1)));
    }

    public String b() {
        return this.a;
    }

    public g0 c() {
        return this;
    }

    @Override
    public final String toString() {
        return this.b();
    }
}

