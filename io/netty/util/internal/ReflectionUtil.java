package io.netty.util.internal;

import java.lang.reflect.AccessibleObject;

public final class ReflectionUtil {
    private static RuntimeException handleInaccessibleObjectException(RuntimeException runtimeException0) {
        if(!"java.lang.reflect.InaccessibleObjectException".equals(runtimeException0.getClass().getName())) {
            throw runtimeException0;
        }
        return runtimeException0;
    }

    public static Throwable trySetAccessible(AccessibleObject accessibleObject0, boolean z) {
        if(z) {
            return new UnsupportedOperationException("Reflective setAccessible(true) disabled");
        }
        try {
            accessibleObject0.setAccessible(true);
            return null;
        }
        catch(SecurityException throwable0) {
            return throwable0;
        }
        catch(RuntimeException runtimeException0) {
            return ReflectionUtil.handleInaccessibleObjectException(runtimeException0);
        }
    }
}

