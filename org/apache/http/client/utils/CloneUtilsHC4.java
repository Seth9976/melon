package org.apache.http.client.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.http.annotation.Immutable;

@Immutable
public class CloneUtilsHC4 {
    public static Object clone(Object object0) {
        return CloneUtilsHC4.cloneObject(object0);
    }

    public static Object cloneObject(Object object0) {
        Method method0;
        if(object0 == null) {
            return null;
        }
        if(object0 instanceof Cloneable) {
            Class class0 = object0.getClass();
            try {
                method0 = class0.getMethod("clone", null);
            }
            catch(NoSuchMethodException noSuchMethodException0) {
                throw new NoSuchMethodError(noSuchMethodException0.getMessage());
            }
            try {
                return method0.invoke(object0, null);
            }
            catch(InvocationTargetException invocationTargetException0) {
                Throwable throwable0 = invocationTargetException0.getCause();
                if(!(throwable0 instanceof CloneNotSupportedException)) {
                    throw new Error("Unexpected exception", throwable0);
                }
                throw (CloneNotSupportedException)throwable0;
            }
            catch(IllegalAccessException illegalAccessException0) {
                throw new IllegalAccessError(illegalAccessException0.getMessage());
            }
        }
        throw new CloneNotSupportedException();
    }
}

