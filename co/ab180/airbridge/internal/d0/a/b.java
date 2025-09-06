package co.ab180.airbridge.internal.d0.a;

import java.lang.reflect.Method;
import org.jetbrains.annotations.NotNull;

public abstract class b extends co.ab180.airbridge.internal.d0.b.b.b {
    static final String a = "com.android.billingclient.api.BillingClientStateListener";
    private static final String b = "onBillingServiceDisconnected";
    private static final String c = "onBillingSetupFinished";

    public abstract void a();

    public abstract void a(@NotNull c arg1);

    @Override
    public Object invoke(Object object0, Method method0, Object[] arr_object) {
        try {
            if(method0.getName().equals("onBillingServiceDisconnected")) {
                this.a();
            }
            if(method0.getName().equals("onBillingSetupFinished")) {
                Object object1 = arr_object[0];
                c c0 = object1 == null ? null : new c(object1);
                if(c0 != null) {
                    this.a(c0);
                    return null;
                }
            }
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
        return null;
    }
}

