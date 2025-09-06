package Nb;

import i.n.i.b.a.s.e.M3;

public abstract class z0 {
    public final boolean a;

    public z0(boolean z) {
        this.a = z;
    }

    public final String a() {
        if(this instanceof y0) {
            return "None";
        }
        if(this instanceof w0) {
            return "Exo";
        }
        if(this instanceof x0) {
            return "Leon";
        }
        if(this instanceof u0) {
            return "Cast";
        }
        if(!(this instanceof v0)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return "Dlna";
    }
}

