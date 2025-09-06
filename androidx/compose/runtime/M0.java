package androidx.compose.runtime;

import i.n.i.b.a.s.e.M3;

public final class m0 {
    public final l0 a;
    public final boolean b;
    public final P0 c;
    public final boolean d;
    public final Object e;
    public boolean f;

    public m0(l0 l00, Object object0, boolean z, P0 p00, boolean z1) {
        this.a = l00;
        this.b = z;
        this.c = p00;
        this.d = z1;
        this.e = object0;
        this.f = true;
    }

    public final Object a() {
        if(this.b) {
            return null;
        }
        Object object0 = this.e;
        if(object0 != null) {
            return object0;
        }
        q.d("Unexpected form of a provided value");
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }
}

