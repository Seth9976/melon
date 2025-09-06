package io.netty.util.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import jeb.synthetic.FIN;

public final class ThrowableUtil {
    @SuppressJava6Requirement(reason = "Throwable addSuppressed is only available for >= 7. Has check for < 7.")
    public static void addSuppressed(Throwable throwable0, Throwable throwable1) {
        if(!ThrowableUtil.haveSuppressed()) {
            return;
        }
        throwable0.addSuppressed(throwable1);
    }

    public static void addSuppressed(Throwable throwable0, List list0) {
        for(Object object0: list0) {
            ThrowableUtil.addSuppressed(throwable0, ((Throwable)object0));
        }
    }

    public static void addSuppressedAndClear(Throwable throwable0, List list0) {
        ThrowableUtil.addSuppressed(throwable0, list0);
        list0.clear();
    }

    // 去混淆评级： 低(30)
    @SuppressJava6Requirement(reason = "Throwable getSuppressed is only available for >= 7. Has check for < 7.")
    public static Throwable[] getSuppressed(Throwable throwable0) {
        return EmptyArrays.EMPTY_THROWABLES;
    }

    // 去混淆评级： 低(20)
    public static boolean haveSuppressed() [...] // 潜在的解密器

    public static String stackTraceToString(Throwable throwable0) {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        PrintStream printStream0 = new PrintStream(byteArrayOutputStream0);
        throwable0.printStackTrace(printStream0);
        printStream0.flush();
        int v = FIN.finallyOpen$NT();
        String s = new String(byteArrayOutputStream0.toByteArray());
        try {
            FIN.finallyCodeBegin$NT(v);
            byteArrayOutputStream0.close();
            FIN.finallyCodeEnd$NT(v);
        }
        catch(IOException unused_ex) {
        }
        return s;
    }

    public static Throwable unknownStackTrace(Throwable throwable0, Class class0, String s) {
        throwable0.setStackTrace(new StackTraceElement[]{new StackTraceElement(class0.getName(), s, null, -1)});
        return throwable0;
    }
}

