package F2;

import androidx.glance.appwidget.protobuf.V;
import androidx.glance.appwidget.protobuf.Y;
import androidx.glance.appwidget.protobuf.v;
import androidx.glance.appwidget.protobuf.w;
import androidx.glance.appwidget.protobuf.x;
import e0.b;

public final class g extends x {
    private static final g DEFAULT_INSTANCE = null;
    public static final int LAYOUT_FIELD_NUMBER = 1;
    public static final int LAYOUT_INDEX_FIELD_NUMBER = 2;
    private static volatile V PARSER;
    private int bitField0_;
    private int layoutIndex_;
    private i layout_;

    static {
        g g0 = new g();  // 初始化器: Landroidx/glance/appwidget/protobuf/x;-><init>()V
        g.DEFAULT_INSTANCE = g0;
        x.i(g.class, g0);
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
                return new Y(g.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004", new Object[]{"bitField0_", "layout_", "layoutIndex_"});
            }
            case 3: {
                return new g();  // 初始化器: Landroidx/glance/appwidget/protobuf/x;-><init>()V
            }
            case 4: {
                return new f(g.DEFAULT_INSTANCE);  // 初始化器: Landroidx/glance/appwidget/protobuf/v;-><init>(Landroidx/glance/appwidget/protobuf/x;)V
            }
            case 5: {
                return g.DEFAULT_INSTANCE;
            }
            case 6: {
                V v1 = g.PARSER;
                if(v1 == null) {
                    Class class0 = g.class;
                    synchronized(class0) {
                        V v3 = g.PARSER;
                        if(v3 == null) {
                            v3 = new w();  // 初始化器: Ljava/lang/Object;-><init>()V
                            g.PARSER = v3;
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

    public static void k(g g0, i i0) {
        g0.getClass();
        i0.getClass();
        g0.layout_ = i0;
        g0.bitField0_ |= 1;
    }

    public static void l(g g0, int v) {
        g0.layoutIndex_ = v;
    }

    public final i m() {
        return this.layout_ == null ? i.v() : this.layout_;
    }

    public final int n() {
        return this.layoutIndex_;
    }

    public static f o() {
        return (f)(((v)g.DEFAULT_INSTANCE.b(5)));
    }
}

