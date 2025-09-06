package org.androidannotations.api.bundle;

import android.os.Bundle;
import android.os.Parcelable;
import java.lang.reflect.Array;

public final class BundleHelper {
    public static Parcelable[] getParcelableArray(Bundle bundle0, String s, Class class0) {
        Parcelable[] arr_parcelable = bundle0.getParcelableArray(s);
        if(arr_parcelable == null) {
            return null;
        }
        Object object0 = Array.newInstance(class0.getComponentType(), arr_parcelable.length);
        System.arraycopy(arr_parcelable, 0, object0, 0, arr_parcelable.length);
        return (Parcelable[])object0;
    }
}

