package u7;

import r7.b;
import r7.c;
import r7.g;

public final class h implements g {
    public boolean a;
    public boolean b;
    public c c;
    public final f d;

    public h(f f0) {
        this.a = false;
        this.b = false;
        this.d = f0;
    }

    @Override  // r7.g
    public final g c(String s) {
        if(this.a) {
            throw new b("Cannot encode a second value in the ValueEncoderContext");  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
        }
        this.a = true;
        this.d.h(this.c, s, this.b);
        return this;
    }

    @Override  // r7.g
    public final g g(boolean z) {
        if(this.a) {
            throw new b("Cannot encode a second value in the ValueEncoderContext");  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
        }
        this.a = true;
        this.d.g(this.c, ((int)z), this.b);
        return this;
    }
}

