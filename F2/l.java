package F2;

import androidx.glance.appwidget.protobuf.D;
import androidx.glance.appwidget.protobuf.K;
import androidx.glance.appwidget.protobuf.W;
import androidx.glance.appwidget.protobuf.m;
import ie.H;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import l2.b;
import l2.c0;

public final class l implements c0 {
    public static final l a;
    public static final e b;

    static {
        l.a = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        e e0 = e.n();
        q.f(e0, "getDefaultInstance()");
        l.b = e0;
    }

    @Override  // l2.c0
    public final Object getDefaultValue() {
        return l.b;
    }

    @Override  // l2.c0
    public final Object readFrom(InputStream inputStream0, Continuation continuation0) {
        try {
            return e.q(inputStream0);
        }
        catch(D d0) {
            throw new b("Cannot read proto.", d0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
        }
    }

    @Override  // l2.c0
    public final Object writeTo(Object object0, OutputStream outputStream0, Continuation continuation0) {
        ((e)object0).getClass();
        int v = ((e)object0).a(null);
        if(v > 0x1000) {
            v = 0x1000;
        }
        m m0 = new m(outputStream0, v);
        ((e)object0).getClass();
        W.c.getClass();
        Class class0 = ((e)object0).getClass();
        W.c.a(class0).h(((e)object0), (m0.n == null ? new K(m0) : m0.n));
        if(m0.q > 0) {
            m0.W();
        }
        return H.a;
    }
}

