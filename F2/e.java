package F2;

import androidx.glance.appwidget.protobuf.A;
import androidx.glance.appwidget.protobuf.B;
import androidx.glance.appwidget.protobuf.D;
import androidx.glance.appwidget.protobuf.V;
import androidx.glance.appwidget.protobuf.W;
import androidx.glance.appwidget.protobuf.X;
import androidx.glance.appwidget.protobuf.Y;
import androidx.glance.appwidget.protobuf.Z;
import androidx.glance.appwidget.protobuf.b0;
import androidx.glance.appwidget.protobuf.j;
import androidx.glance.appwidget.protobuf.k;
import androidx.glance.appwidget.protobuf.p;
import androidx.glance.appwidget.protobuf.w;
import androidx.glance.appwidget.protobuf.x;
import e0.b;
import java.io.IOException;
import java.io.InputStream;

public final class e extends x {
    private static final e DEFAULT_INSTANCE = null;
    public static final int LAYOUT_FIELD_NUMBER = 1;
    public static final int NEXT_INDEX_FIELD_NUMBER = 2;
    private static volatile V PARSER;
    private A layout_;
    private int nextIndex_;

    static {
        e e0 = new e();
        e.DEFAULT_INSTANCE = e0;
        x.i(e.class, e0);
    }

    public e() {
        this.layout_ = X.d;
    }

    @Override  // androidx.glance.appwidget.protobuf.x
    public final Object b(int v) {
        switch(b.b(v)) {
            case 0: {
                return (byte)1;
            }
            case 1: {
                return null;
            }
            case 2: {
                return new Y(e.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001B\u0002\u0004", new Object[]{"layout_", g.class, "nextIndex_"});
            }
            case 3: {
                return new e();
            }
            case 4: {
                return new d(e.DEFAULT_INSTANCE);  // 初始化器: Landroidx/glance/appwidget/protobuf/v;-><init>(Landroidx/glance/appwidget/protobuf/x;)V
            }
            case 5: {
                return e.DEFAULT_INSTANCE;
            }
            case 6: {
                V v1 = e.PARSER;
                if(v1 == null) {
                    Class class0 = e.class;
                    synchronized(class0) {
                        V v3 = e.PARSER;
                        if(v3 == null) {
                            v3 = new w();  // 初始化器: Ljava/lang/Object;-><init>()V
                            e.PARSER = v3;
                        }
                        return v3;
                    }
                }
                return v1;
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
    }

    public static void k(e e0, g g0) {
        e0.getClass();
        A a0 = e0.layout_;
        if(!((androidx.glance.appwidget.protobuf.b)a0).a) {
            int v = a0.size();
            e0.layout_ = ((X)a0).e((v == 0 ? 10 : v * 2));
        }
        e0.layout_.add(g0);
    }

    public static void l(e e0) {
        e0.getClass();
        e0.layout_ = X.d;
    }

    public static void m(e e0, int v) {
        e0.nextIndex_ = v;
    }

    public static e n() {
        return e.DEFAULT_INSTANCE;
    }

    public final A o() {
        return this.layout_;
    }

    public final int p() {
        return this.nextIndex_;
    }

    public static e q(InputStream inputStream0) {
        j j0;
        e e0 = e.DEFAULT_INSTANCE;
        if(inputStream0 == null) {
            j0 = new j(B.b, 0, B.b.length, false);
            try {
                j0.i(B.b.length);
            }
            catch(D d0) {
                throw new IllegalArgumentException(d0);
            }
        }
        else {
            j0 = new k(inputStream0);
        }
        p p0 = p.a();
        x x0 = e0.h();
        try {
            W.c.getClass();
            Class class0 = x0.getClass();
            Z z0 = W.c.a(class0);
            Vd.w w0 = (Vd.w)j0.b;
            if(w0 == null) {
                w0 = new Vd.w(j0, 0);
            }
            z0.g(x0, w0, p0);
            z0.b(x0);
        }
        catch(D d1) {
            if(d1.a) {
                d1 = new D(d1.getMessage(), d1);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
            }
            throw d1;
        }
        catch(b0 b00) {
            throw new D(b00.getMessage());  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        catch(IOException iOException0) {
            throw iOException0.getCause() instanceof D ? ((D)iOException0.getCause()) : new D(iOException0.getMessage(), iOException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
        }
        catch(RuntimeException runtimeException0) {
            if(!(runtimeException0.getCause() instanceof D)) {
                throw runtimeException0;
            }
            throw (D)runtimeException0.getCause();
        }
        if(!x.e(x0, true)) {
            throw new D("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        return (e)x0;
    }
}

