package org.apache.http.client.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import org.apache.http.annotation.Immutable;

@Immutable
public class JdkIdn implements Idn {
    private final Method toUnicode;

    public JdkIdn() {
        try {
            this.toUnicode = IDN.class.getMethod("toUnicode", String.class);
        }
        catch(SecurityException securityException0) {
            throw new IllegalStateException(securityException0.getMessage(), securityException0);
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new IllegalStateException(noSuchMethodException0.getMessage(), noSuchMethodException0);
        }
    }

    @Override  // org.apache.http.client.utils.Idn
    public String toUnicode(String s) {
        try {
            return (String)this.toUnicode.invoke(null, s);
        }
        catch(IllegalAccessException illegalAccessException0) {
            throw new IllegalStateException(illegalAccessException0.getMessage(), illegalAccessException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            Throwable throwable0 = invocationTargetException0.getCause();
            throw new RuntimeException(throwable0.getMessage(), throwable0);
        }
    }
}

