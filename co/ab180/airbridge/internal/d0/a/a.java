package co.ab180.airbridge.internal.d0.a;

import android.content.Context;
import co.ab180.airbridge.internal.d0.b.b.c;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import java.lang.reflect.Proxy;

public class a extends c {
    static class co.ab180.airbridge.internal.d0.a.a.a {
    }

    public interface b {
        public static final int a = -3;
        public static final int b = -2;
        public static final int c = -1;
        public static final int d = 0;
        public static final int e = 1;
        public static final int f = 2;
        public static final int g = 3;
        public static final int h = 4;
        public static final int i = 5;
        public static final int j = 6;
        public static final int k = 7;
        public static final int l = 8;
        public static final int m = 12;

    }

    public static class co.ab180.airbridge.internal.d0.a.a.c extends c {
        private static final String c = "com.android.billingclient.api.BillingClient$Builder";
        private static final String d = "setListener";
        private static final String e = "enablePendingPurchases";
        private static final String f = "build";

        private co.ab180.airbridge.internal.d0.a.a.c(Object object0) {
            super("com.android.billingclient.api.BillingClient$Builder", object0);
        }

        public co.ab180.airbridge.internal.d0.a.a.c(Object object0, co.ab180.airbridge.internal.d0.a.a.a a$a0) {
            this(object0);
        }

        public co.ab180.airbridge.internal.d0.a.a.c a(e e0) {
            try {
                Object object0 = Proxy.newProxyInstance(PurchasesUpdatedListener.class.getClassLoader(), new Class[]{PurchasesUpdatedListener.class}, e0);
                this.a("setListener", new Class[]{PurchasesUpdatedListener.class}, new Object[]{object0});
                return this;
            }
            catch(ClassNotFoundException classNotFoundException0) {
                throw new co.ab180.airbridge.internal.d0.b.b.a(classNotFoundException0);
            }
        }

        public a c() {
            return new a(this.a("build"), null);
        }

        public co.ab180.airbridge.internal.d0.a.a.c d() {
            this.a("enablePendingPurchases");
            return this;
        }
    }

    private static final String c = "com.android.billingclient.api.BillingClient";
    private static final String d = "newBuilder";
    private static final String e = "startConnection";
    private static final String f = "isReady";
    private static final String g = "endConnection";

    private a(Object object0) {
        super("com.android.billingclient.api.BillingClient", object0);
    }

    public a(Object object0, co.ab180.airbridge.internal.d0.a.a.a a$a0) {
        this(object0);
    }

    public static co.ab180.airbridge.internal.d0.a.a.c a(Context context0) {
        return new co.ab180.airbridge.internal.d0.a.a.c(c.a("com.android.billingclient.api.BillingClient", "newBuilder", new Class[]{Context.class}, new Object[]{context0}), null);
    }

    public void a(co.ab180.airbridge.internal.d0.a.b b0) {
        try {
            Object object0 = Proxy.newProxyInstance(BillingClientStateListener.class.getClassLoader(), new Class[]{BillingClientStateListener.class}, b0);
            this.a("startConnection", new Class[]{BillingClientStateListener.class}, new Object[]{object0});
        }
        catch(ClassNotFoundException classNotFoundException0) {
            throw new co.ab180.airbridge.internal.d0.b.b.a(classNotFoundException0);
        }
    }

    public void c() {
        this.a("endConnection");
    }

    public boolean d() {
        return ((Boolean)this.a("isReady")).booleanValue();
    }
}

