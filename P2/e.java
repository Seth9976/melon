package p2;

import Vd.w;
import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.D;
import androidx.datastore.preferences.protobuf.F;
import androidx.datastore.preferences.protobuf.P;
import androidx.datastore.preferences.protobuf.Z;
import androidx.datastore.preferences.protobuf.b0;
import androidx.datastore.preferences.protobuf.d0;
import androidx.datastore.preferences.protobuf.e0;
import androidx.datastore.preferences.protobuf.k0;
import androidx.datastore.preferences.protobuf.k;
import androidx.datastore.preferences.protobuf.l;
import androidx.datastore.preferences.protobuf.r;
import androidx.datastore.preferences.protobuf.y;
import androidx.datastore.preferences.protobuf.z;
import e0.b;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public final class e extends A {
    private static final e DEFAULT_INSTANCE = null;
    private static volatile Z PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private P preferences_;

    static {
        e e0 = new e();
        e.DEFAULT_INSTANCE = e0;
        A.i(e.class, e0);
    }

    public e() {
        this.preferences_ = P.b;
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
                return new d0(e.DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", d.a});
            }
            case 3: {
                return new e();
            }
            case 4: {
                return new c(e.DEFAULT_INSTANCE);  // 初始化器: Landroidx/datastore/preferences/protobuf/y;-><init>(Landroidx/datastore/preferences/protobuf/A;)V
            }
            case 5: {
                return e.DEFAULT_INSTANCE;
            }
            case 6: {
                Z z0 = e.PARSER;
                if(z0 == null) {
                    Class class0 = e.class;
                    synchronized(class0) {
                        Z z1 = e.PARSER;
                        if(z1 == null) {
                            z1 = new z();  // 初始化器: Ljava/lang/Object;-><init>()V
                            e.PARSER = z1;
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

    public static P l(e e0) {
        P p0 = e0.preferences_;
        if(!p0.a) {
            e0.preferences_ = p0.b();
        }
        return e0.preferences_;
    }

    public final Map m() {
        return Collections.unmodifiableMap(this.preferences_);
    }

    public static c n() {
        return (c)(((y)e.DEFAULT_INSTANCE.b(5)));
    }

    public static e o(InputStream inputStream0) {
        k k0;
        e e0 = e.DEFAULT_INSTANCE;
        if(inputStream0 == null) {
            k0 = new k(D.b, 0, D.b.length, false);
            try {
                k0.i(D.b.length);
            }
            catch(F f0) {
                throw new IllegalArgumentException(f0);
            }
        }
        else {
            k0 = new l(inputStream0);
        }
        r r0 = r.a();
        A a0 = e0.h();
        try {
            b0.c.getClass();
            Class class0 = a0.getClass();
            e0 e00 = b0.c.a(class0);
            w w0 = (w)k0.b;
            if(w0 == null) {
                w0 = new w(k0);
            }
            e00.f(a0, w0, r0);
            e00.b(a0);
        }
        catch(F f1) {
            if(f1.a) {
                f1 = new F(f1.getMessage(), f1);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
            }
            throw f1;
        }
        catch(k0 k00) {
            throw new F(k00.getMessage());  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        catch(IOException iOException0) {
            throw iOException0.getCause() instanceof F ? ((F)iOException0.getCause()) : new F(iOException0.getMessage(), iOException0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
        }
        catch(RuntimeException runtimeException0) {
            if(!(runtimeException0.getCause() instanceof F)) {
                throw runtimeException0;
            }
            throw (F)runtimeException0.getCause();
        }
        if(!A.e(a0, true)) {
            throw new F("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        return (e)a0;
    }
}

