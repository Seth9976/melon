package p2;

import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.C;
import androidx.datastore.preferences.protobuf.H;
import androidx.datastore.preferences.protobuf.Z;
import androidx.datastore.preferences.protobuf.a0;
import androidx.datastore.preferences.protobuf.c0;
import androidx.datastore.preferences.protobuf.d0;
import androidx.datastore.preferences.protobuf.y;
import androidx.datastore.preferences.protobuf.z;
import e0.b;
import java.util.ArrayList;
import java.util.Collection;

public final class g extends A {
    private static final g DEFAULT_INSTANCE = null;
    private static volatile Z PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private C strings_;

    static {
        g g0 = new g();
        g.DEFAULT_INSTANCE = g0;
        A.i(g.class, g0);
    }

    public g() {
        this.strings_ = c0.d;
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
                return new d0(g.DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001A", new Object[]{"strings_"});
            }
            case 3: {
                return new g();
            }
            case 4: {
                return new f(g.DEFAULT_INSTANCE);  // 初始化器: Landroidx/datastore/preferences/protobuf/y;-><init>(Landroidx/datastore/preferences/protobuf/A;)V
            }
            case 5: {
                return g.DEFAULT_INSTANCE;
            }
            case 6: {
                Z z0 = g.PARSER;
                if(z0 == null) {
                    Class class0 = g.class;
                    synchronized(class0) {
                        Z z1 = g.PARSER;
                        if(z1 == null) {
                            z1 = new z();  // 初始化器: Ljava/lang/Object;-><init>()V
                            g.PARSER = z1;
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

    public static void l(g g0, Iterable iterable0) {
        C c0 = g0.strings_;
        if(!((androidx.datastore.preferences.protobuf.b)c0).a) {
            int v = c0.size();
            g0.strings_ = ((c0)c0).e((v == 0 ? 10 : v * 2));
        }
        C c1 = g0.strings_;
        iterable0.getClass();
        if(iterable0 instanceof H) {
            ((H)iterable0).h();
            if(c1 != null) {
                throw new ClassCastException();
            }
            throw new NullPointerException();
        }
        if(iterable0 instanceof a0) {
            c1.addAll(((Collection)iterable0));
            return;
        }
        if(c1 instanceof ArrayList && iterable0 instanceof Collection) {
            ((ArrayList)c1).ensureCapacity(((Collection)iterable0).size() + c1.size());
        }
        int v1 = c1.size();
        for(Object object0: iterable0) {
            if(object0 == null) {
                String s = "Element at index " + (c1.size() - v1) + " is null.";
                for(int v2 = c1.size() - 1; v2 >= v1; --v2) {
                    c1.remove(v2);
                }
                throw new NullPointerException(s);
            }
            c1.add(object0);
        }
        return;
    }

    public static g m() {
        return g.DEFAULT_INSTANCE;
    }

    public final C n() {
        return this.strings_;
    }

    public static f o() {
        return (f)(((y)g.DEFAULT_INSTANCE.b(5)));
    }
}

