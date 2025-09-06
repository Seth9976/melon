package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.RetainForClient;
import com.iloen.melon.utils.a;
import java.lang.reflect.Field;

@KeepForSdk
@RetainForClient
public final class ObjectWrapper extends Stub {
    private final Object zza;

    private ObjectWrapper(Object object0) {
        this.zza = object0;
    }

    @KeepForSdk
    public static Object unwrap(IObjectWrapper iObjectWrapper0) {
        if(iObjectWrapper0 instanceof ObjectWrapper) {
            return ((ObjectWrapper)iObjectWrapper0).zza;
        }
        IBinder iBinder0 = iObjectWrapper0.asBinder();
        Field[] arr_field = iBinder0.getClass().getDeclaredFields();
        Field field0 = null;
        int v1 = 0;
        for(int v = 0; v < arr_field.length; ++v) {
            Field field1 = arr_field[v];
            if(!field1.isSynthetic()) {
                ++v1;
                field0 = field1;
            }
        }
        if(v1 == 1) {
            Preconditions.checkNotNull(field0);
            if(!field0.isAccessible()) {
                field0.setAccessible(true);
                try {
                    return field0.get(iBinder0);
                }
                catch(NullPointerException nullPointerException0) {
                    throw new IllegalArgumentException("Binder object is null.", nullPointerException0);
                }
                catch(IllegalAccessException illegalAccessException0) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", illegalAccessException0);
                }
            }
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        StringBuilder stringBuilder0 = new StringBuilder(String.valueOf(arr_field.length).length() + 53);
        throw new IllegalArgumentException(a.k(arr_field.length, "Unexpected number of IObjectWrapper declared fields: ", stringBuilder0));
    }

    @KeepForSdk
    public static IObjectWrapper wrap(Object object0) {
        return new ObjectWrapper(object0);
    }
}

