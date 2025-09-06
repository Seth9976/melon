package M7;

import android.os.Build.VERSION;
import android.os.Build;
import r7.c;
import r7.e;

public final class d implements r7.d {
    public static final d a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;

    static {
        d.a = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
        d.b = c.a("appId");
        d.c = c.a("deviceModel");
        d.d = c.a("sessionSdkVersion");
        d.e = c.a("osVersion");
        d.f = c.a("logEnvironment");
        d.g = c.a("androidAppInfo");
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((e)object1).a(d.b, ((b)object0).a);
        ((e)object1).a(d.c, Build.MODEL);
        ((e)object1).a(d.d, "2.1.2");
        ((e)object1).a(d.e, Build.VERSION.RELEASE);
        ((e)object1).a(d.f, C.b);
        ((e)object1).a(d.g, ((b)object0).b);
    }
}

