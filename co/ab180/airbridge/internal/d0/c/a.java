package co.ab180.airbridge.internal.d0.c;

import android.content.Context;
import co.ab180.airbridge.internal.d0.b.b.c;

public class a extends c {
    private static final String c = "com.facebook.FacebookSdk";
    private static final String d = "isInitialized";
    private static final String e = "sdkInitialize";

    private a(Object object0) {
        super("com.facebook.FacebookSdk", object0);
    }

    public static void a(Context context0) {
        c.a("com.facebook.FacebookSdk", "sdkInitialize", new Class[]{Context.class}, new Object[]{context0});
    }

    public static boolean c() {
        return ((Boolean)c.a("com.facebook.FacebookSdk", "isInitialized", new Class[0], new Object[0])).booleanValue();
    }
}

