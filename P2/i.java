package p2;

import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.Z;
import androidx.datastore.preferences.protobuf.d0;
import androidx.datastore.preferences.protobuf.j;
import androidx.datastore.preferences.protobuf.y;
import androidx.datastore.preferences.protobuf.z;
import e0.b;

public final class i extends A {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    public static final int BYTES_FIELD_NUMBER = 8;
    private static final i DEFAULT_INSTANCE = null;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile Z PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int valueCase_;
    private Object value_;

    static {
        i i0 = new i();
        i.DEFAULT_INSTANCE = i0;
        A.i(i.class, i0);
    }

    public i() {
        this.valueCase_ = 0;
    }

    public final String A() [...] // 潜在的解密器

    public final g B() {
        return this.valueCase_ == 6 ? ((g)this.value_) : g.m();
    }

    public final int C() {
        switch(this.valueCase_) {
            case 0: {
                return 9;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
            case 7: {
                return 7;
            }
            case 8: {
                return 8;
            }
            default: {
                return 0;
            }
        }
    }

    public static h D() {
        return (h)(((y)i.DEFAULT_INSTANCE.b(5)));
    }

    @Override  // androidx.datastore.preferences.protobuf.A
    public final Object b(int v) {
        switch(b.b(v)) {
            case 0: {
                return (byte)1;
            }
            case 1: {
                return null;
            }
            case 2: {
                return new d0(i.DEFAULT_INSTANCE, "\u0001\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000\b=\u0000", new Object[]{"value_", "valueCase_", g.class});
            }
            case 3: {
                return new i();
            }
            case 4: {
                return new h(i.DEFAULT_INSTANCE);  // 初始化器: Landroidx/datastore/preferences/protobuf/y;-><init>(Landroidx/datastore/preferences/protobuf/A;)V
            }
            case 5: {
                return i.DEFAULT_INSTANCE;
            }
            case 6: {
                Z z0 = i.PARSER;
                if(z0 == null) {
                    Class class0 = i.class;
                    synchronized(class0) {
                        Z z1 = i.PARSER;
                        if(z1 == null) {
                            z1 = new z();  // 初始化器: Ljava/lang/Object;-><init>()V
                            i.PARSER = z1;
                        }
                        return z1;
                    }
                }
                return z0;
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
    }

    public static void l(i i0, long v) {
        i0.valueCase_ = 4;
        i0.value_ = v;
    }

    public static void m(i i0, String s) {
        i0.getClass();
        s.getClass();
        i0.valueCase_ = 5;
        i0.value_ = s;
    }

    public static void n(i i0, g g0) {
        i0.getClass();
        i0.value_ = g0;
        i0.valueCase_ = 6;
    }

    public static void o(i i0, double f) {
        i0.valueCase_ = 7;
        i0.value_ = f;
    }

    public static void p(i i0, androidx.datastore.preferences.protobuf.i i1) {
        i0.getClass();
        i0.valueCase_ = 8;
        i0.value_ = i1;
    }

    public static void q(i i0, boolean z) {
        i0.valueCase_ = 1;
        i0.value_ = Boolean.valueOf(z);
    }

    public static void r(i i0, float f) {
        i0.valueCase_ = 2;
        i0.value_ = f;
    }

    public static void s(i i0, int v) {
        i0.valueCase_ = 3;
        i0.value_ = v;
    }

    public final boolean t() {
        return this.valueCase_ == 1 ? ((Boolean)this.value_).booleanValue() : false;
    }

    public final j u() {
        return this.valueCase_ == 8 ? ((j)this.value_) : j.b;
    }

    public static i v() {
        return i.DEFAULT_INSTANCE;
    }

    public final double w() {
        return this.valueCase_ == 7 ? ((double)(((Double)this.value_))) : 0.0;
    }

    public final float x() {
        return this.valueCase_ == 2 ? ((float)(((Float)this.value_))) : 0.0f;
    }

    public final int y() {
        return this.valueCase_ == 3 ? ((int)(((Integer)this.value_))) : 0;
    }

    public final long z() {
        return this.valueCase_ == 4 ? ((long)(((Long)this.value_))) : 0L;
    }
}

