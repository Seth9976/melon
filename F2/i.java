package F2;

import androidx.glance.appwidget.protobuf.A;
import androidx.glance.appwidget.protobuf.V;
import androidx.glance.appwidget.protobuf.X;
import androidx.glance.appwidget.protobuf.Y;
import androidx.glance.appwidget.protobuf.v;
import androidx.glance.appwidget.protobuf.w;
import androidx.glance.appwidget.protobuf.x;
import e0.b;
import java.util.ArrayList;

public final class i extends x {
    public static final int CHILDREN_FIELD_NUMBER = 7;
    private static final i DEFAULT_INSTANCE = null;
    public static final int HASACTION_FIELD_NUMBER = 9;
    public static final int HAS_IMAGE_COLOR_FILTER_FIELD_NUMBER = 11;
    public static final int HAS_IMAGE_DESCRIPTION_FIELD_NUMBER = 10;
    public static final int HEIGHT_FIELD_NUMBER = 3;
    public static final int HORIZONTAL_ALIGNMENT_FIELD_NUMBER = 4;
    public static final int IDENTITY_FIELD_NUMBER = 8;
    public static final int IMAGE_SCALE_FIELD_NUMBER = 6;
    private static volatile V PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int VERTICAL_ALIGNMENT_FIELD_NUMBER = 5;
    public static final int WIDTH_FIELD_NUMBER = 2;
    private A children_;
    private boolean hasAction_;
    private boolean hasImageColorFilter_;
    private boolean hasImageDescription_;
    private int height_;
    private int horizontalAlignment_;
    private int identity_;
    private int imageScale_;
    private int type_;
    private int verticalAlignment_;
    private int width_;

    static {
        i i0 = new i();
        i.DEFAULT_INSTANCE = i0;
        x.i(i.class, i0);
    }

    public i() {
        this.children_ = X.d;
    }

    @Override  // androidx.glance.appwidget.protobuf.x
    public final Object b(int v) {
        V v2;
        switch(b.b(v)) {
            case 0: {
                return (byte)1;
            }
            case 1: {
                return null;
            }
            case 2: {
                return new Y(i.DEFAULT_INSTANCE, "\u0000\u000B\u0000\u0000\u0001\u000B\u000B\u0000\u0001\u0000\u0001\f\u0002\f\u0003\f\u0004\f\u0005\f\u0006\f\u0007\u001B\b\f\t\u0007\n\u0007\u000B\u0007", new Object[]{"type_", "width_", "height_", "horizontalAlignment_", "verticalAlignment_", "imageScale_", "children_", i.class, "identity_", "hasAction_", "hasImageDescription_", "hasImageColorFilter_"});
            }
            case 3: {
                return new i();
            }
            case 4: {
                return new h(i.DEFAULT_INSTANCE);  // 初始化器: Landroidx/glance/appwidget/protobuf/v;-><init>(Landroidx/glance/appwidget/protobuf/x;)V
            }
            case 5: {
                return i.DEFAULT_INSTANCE;
            }
            case 6: {
                V v1 = i.PARSER;
                if(v1 == null) {
                    synchronized(i.class) {
                        v2 = i.PARSER;
                        if(v2 == null) {
                            v2 = new w();  // 初始化器: Ljava/lang/Object;-><init>()V
                            i.PARSER = v2;
                        }
                    }
                    return v2;
                }
                return v1;
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
    }

    public static void k(i i0, j j0) {
        i0.getClass();
        if(j0 == j.n) {
            throw new IllegalArgumentException("Can\'t get the number of an unknown enum value.");
        }
        i0.type_ = j0.a;
    }

    public static void l(i i0, F2.b b0) {
        i0.getClass();
        i0.width_ = b0.a();
    }

    public static void m(i i0, F2.b b0) {
        i0.getClass();
        i0.height_ = b0.a();
    }

    public static void n(i i0, c c0) {
        i0.getClass();
        if(c0 == c.e) {
            throw new IllegalArgumentException("Can\'t get the number of an unknown enum value.");
        }
        i0.horizontalAlignment_ = c0.a;
    }

    public static void o(i i0, k k0) {
        i0.getClass();
        if(k0 == k.e) {
            throw new IllegalArgumentException("Can\'t get the number of an unknown enum value.");
        }
        i0.verticalAlignment_ = k0.a;
    }

    public static void p(i i0, a a0) {
        i0.getClass();
        if(a0 == a.e) {
            throw new IllegalArgumentException("Can\'t get the number of an unknown enum value.");
        }
        i0.imageScale_ = a0.a;
    }

    public static void q(i i0) {
        i0.getClass();
        i0.identity_ = 1;
    }

    public static void r(i i0, boolean z) {
        i0.hasAction_ = z;
    }

    public static void s(i i0, ArrayList arrayList0) {
        A a0 = i0.children_;
        if(!((androidx.glance.appwidget.protobuf.b)a0).a) {
            int v = a0.size();
            i0.children_ = ((X)a0).e((v == 0 ? 10 : v * 2));
        }
        A a1 = i0.children_;
        if(a1 instanceof ArrayList) {
            ((ArrayList)a1).ensureCapacity(arrayList0.size() + a1.size());
        }
        int v1 = a1.size();
        for(Object object0: arrayList0) {
            if(object0 == null) {
                String s = "Element at index " + (a1.size() - v1) + " is null.";
                for(int v2 = a1.size() - 1; v2 >= v1; --v2) {
                    a1.remove(v2);
                }
                throw new NullPointerException(s);
            }
            a1.add(object0);
        }
    }

    public static void t(i i0, boolean z) {
        i0.hasImageDescription_ = z;
    }

    public static void u(i i0) {
        i0.hasImageColorFilter_ = false;
    }

    public static i v() {
        return i.DEFAULT_INSTANCE;
    }

    public static h w() {
        return (h)(((v)i.DEFAULT_INSTANCE.b(5)));
    }
}

