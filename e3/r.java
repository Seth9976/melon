package e3;

import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;

public final class r {
    public static final r a;

    static {
        r.a = new r();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final t a(Looper looper0, Handler.Callback handler$Callback0) {
        return new t(new Handler(looper0, handler$Callback0));
    }
}

