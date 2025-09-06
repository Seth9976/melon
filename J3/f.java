package j3;

import V3.c;

public final class f {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public static final f d;

    static {
        f.d = new c().a();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public f(c c0) {
        this.a = c0.a;
        this.b = c0.b;
        this.c = c0.c;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 != null) {
                Class class0 = object0.getClass();
                return f.class == class0 && this.a == ((f)object0).a && this.b == ((f)object0).b && this.c == ((f)object0).c;
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return (this.a << 2) + (this.b << 1) + this.c;
    }
}

