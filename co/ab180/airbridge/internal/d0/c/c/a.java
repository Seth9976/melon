package co.ab180.airbridge.internal.d0.c.c;

import android.content.Context;
import android.net.Uri;
import co.ab180.airbridge.internal.d0.b.b.c;
import com.facebook.applinks.AppLinkData.CompletionHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.jetbrains.annotations.Nullable;

public class a extends c {
    static class co.ab180.airbridge.internal.d0.c.c.a.a {
    }

    public static abstract class b extends co.ab180.airbridge.internal.d0.b.b.b {
        private static final String a = "com.facebook.applinks.AppLinkData$CompletionHandler";

        public abstract void a(@Nullable a arg1);

        @Override
        public Object invoke(Object object0, Method method0, Object[] arr_object) {
            try {
                Object object1 = arr_object[0];
                a a0 = object1 == null ? null : new a(object1, null);
                if(a0 == null) {
                    this.a(null);
                    return null;
                }
                this.a(a0);
                return null;
            }
            catch(Exception exception0) {
            }
            co.ab180.airbridge.internal.b.b(exception0);
            return null;
        }
    }

    private static final String c = "com.facebook.applinks.AppLinkData";
    private static final String d = "fetchDeferredAppLinkData";
    private static final String e = "getTargetUri";

    private a(Object object0) {
        super("com.facebook.applinks.AppLinkData", object0);
    }

    public a(Object object0, co.ab180.airbridge.internal.d0.c.c.a.a a$a0) {
        this(object0);
    }

    public static void a(Context context0, b a$b0) {
        try {
            Object object0 = Proxy.newProxyInstance(CompletionHandler.class.getClassLoader(), new Class[]{CompletionHandler.class}, a$b0);
            c.a("com.facebook.applinks.AppLinkData", "fetchDeferredAppLinkData", new Class[]{Context.class, CompletionHandler.class}, new Object[]{context0, object0});
        }
        catch(ClassNotFoundException classNotFoundException0) {
            throw new co.ab180.airbridge.internal.d0.b.b.a(classNotFoundException0);
        }
    }

    @Nullable
    public Uri c() {
        try {
            return (Uri)this.a("getTargetUri");
        }
        catch(co.ab180.airbridge.internal.d0.b.b.a unused_ex) {
            return null;
        }
    }
}

