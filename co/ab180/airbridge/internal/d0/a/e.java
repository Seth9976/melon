package co.ab180.airbridge.internal.d0.a;

import co.ab180.airbridge.internal.d0.b.b.b;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class e extends b {
    static final String a = "com.android.billingclient.api.PurchasesUpdatedListener";

    public abstract void a(@NotNull c arg1, @Nullable List arg2);

    @Override
    public Object invoke(Object object0, Method method0, Object[] arr_object) {
        ArrayList arrayList0;
        try {
            Object object1 = arr_object[0];
            c c0 = object1 == null ? null : new c(object1);
            if(arr_object.length > 1) {
                Object object2 = arr_object[1];
                if(object2 instanceof List) {
                    arrayList0 = new ArrayList();
                    for(Object object3: ((List)object2)) {
                        if(object3 != null) {
                            arrayList0.add(new d(object3));
                        }
                    }
                }
                else {
                    arrayList0 = null;
                }
            }
            else {
                arrayList0 = null;
            }
            if(c0 != null) {
                this.a(c0, arrayList0);
                return null;
            }
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
        return null;
    }
}

