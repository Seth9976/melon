package Q0;

import B2.o;
import G.g;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import i.n.i.b.a.s.e.M3;
import kotlin.jvm.internal.H;
import me.h;
import we.a;

public final class t0 implements a1, h {
    public final int a;
    public static final t0 b;
    public static final t0 c;
    public static final t0 d;
    public static final g1 e;

    static {
        t0.b = new t0(0);
        t0.c = new t0(1);
        t0.d = new t0(2);
        t0.e = new g1();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public t0(int v) {
        this.a = v;
        super();
    }

    public static final boolean a() {
        try {
            if(u.Z0 == null) {
                Class class0 = Class.forName("android.os.SystemProperties");
                u.Z0 = class0;
                u.a1 = class0.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE);
            }
            Boolean boolean0 = null;
            Object object0 = u.a1 == null ? null : u.a1.invoke(null, "debug.layout", Boolean.FALSE);
            if(object0 instanceof Boolean) {
                boolean0 = (Boolean)object0;
            }
            return boolean0 == null ? false : boolean0.booleanValue();
        }
        catch(Exception unused_ex) {
        }
        return false;
    }

    @Override  // Q0.a1
    public a u(AbstractComposeView abstractComposeView0) {
        if(this.a != 1) {
            if(abstractComposeView0.isAttachedToWindow()) {
                D d0 = f0.d(abstractComposeView0);
                if(d0 != null) {
                    return N.d(abstractComposeView0, d0.getLifecycle());
                }
                M0.a.c(("View tree for " + abstractComposeView0 + " has no ViewTreeLifecycleOwner"));
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
            Z0 z00 = new Z0(abstractComposeView0, 0, h0);
            abstractComposeView0.addOnAttachStateChangeListener(z00);
            h0.a = new g(15, abstractComposeView0, z00);
            return new o(h0, 20);
        }
        X0 x00 = new X0(abstractComposeView0, 0);
        abstractComposeView0.addOnAttachStateChangeListener(x00);
        return new g(14, abstractComposeView0, x00);
    }
}

