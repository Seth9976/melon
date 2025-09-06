package androidx.media3.session.legacy;

import android.content.Context;
import android.media.session.MediaSessionManager;
import android.os.Build.VERSION;
import android.util.Log;

public final class c0 {
    public X a;
    public static final boolean b;
    public static final Object c;
    public static volatile c0 d;

    static {
        c0.b = Log.isLoggable("MediaSessionManager", 3);
        c0.c = new Object();
    }

    public static c0 a(Context context0) {
        if(context0 != null) {
            Object object0 = c0.c;
            synchronized(object0) {
                if(c0.d == null) {
                    Context context1 = context0.getApplicationContext();
                    c0 c00 = new c0();  // 初始化器: Ljava/lang/Object;-><init>()V
                    if(Build.VERSION.SDK_INT >= 28) {
                        Z z0 = new Z(context1);  // 初始化器: Landroidx/media3/session/legacy/X;-><init>(Landroid/content/Context;)V
                        MediaSessionManager mediaSessionManager0 = (MediaSessionManager)context1.getSystemService("media_session");
                        c00.a = z0;
                    }
                    else {
                        c00.a = new X(context1);
                    }
                    c0.d = c00;
                }
                return c0.d;
            }
        }
        throw new IllegalArgumentException("context cannot be null");
    }

    public final boolean b(b0 b00) {
        if(b00 == null) {
            throw new IllegalArgumentException("userInfo should not be null");
        }
        return this.a.a(b00.a);
    }
}

