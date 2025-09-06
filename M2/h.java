package M2;

import D2.v0;
import android.content.Context;
import e1.G;
import java.io.File;
import q2.e;

public final class h implements g {
    public static final h a;

    static {
        h.a = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // M2.g
    public final File a(Context context0, String s) {
        return G.x(context0, s);
    }

    @Override  // M2.g
    public final Object b(Context context0, String s) {
        return e.a(null, new v0(context0, s, 1), 7);
    }
}

