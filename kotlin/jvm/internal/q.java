package kotlin.jvm.internal;

import A7.d;
import android.net.Uri;
import c2.Y;
import ie.G;
import java.util.Arrays;

public abstract class q {
    public static boolean a(Float float0, float f) {
        return float0 != null && ((float)float0) == f;
    }

    public static boolean b(Object object0, Object object1) {
        return object0 == null ? object1 == null : object0.equals(object1);
    }

    public static void c(Uri uri0) {
        if(uri0 != null) {
            return;
        }
        IllegalStateException illegalStateException0 = new IllegalStateException("Uri.parse(this) must not be null");
        q.l(illegalStateException0, "kotlin.jvm.internal.q");
        throw illegalStateException0;
    }

    public static void d(Object object0) [...] // 潜在的解密器

    public static void e(Object object0, String s) [...] // 潜在的解密器

    public static void f(Object object0, String s) [...] // 潜在的解密器

    public static void g(Object object0, String s) [...] // 潜在的解密器

    public static int h(int v, int v1) {
        if(v < v1) {
            return -1;
        }
        return v == v1 ? 0 : 1;
    }

    public static String i(String s) {
        StackTraceElement[] arr_stackTraceElement = Thread.currentThread().getStackTrace();
        int v;
        for(v = 0; !arr_stackTraceElement[v].getClassName().equals("kotlin.jvm.internal.q"); ++v) {
        }
        while(arr_stackTraceElement[v].getClassName().equals("kotlin.jvm.internal.q")) {
            ++v;
        }
        StackTraceElement stackTraceElement0 = arr_stackTraceElement[v];
        StringBuilder stringBuilder0 = d.o("Parameter specified as non-null is null: method ", stackTraceElement0.getClassName(), ".", stackTraceElement0.getMethodName(), ", parameter ");
        stringBuilder0.append(s);
        return stringBuilder0.toString();
    }

    public static final Y j(Object[] arr_object) {
        q.g(arr_object, "array");
        return new Y(arr_object);
    }

    public static void k() {
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void l(RuntimeException runtimeException0, String s) {
        StackTraceElement[] arr_stackTraceElement = runtimeException0.getStackTrace();
        int v = -1;
        for(int v1 = 0; v1 < arr_stackTraceElement.length; ++v1) {
            if(s.equals(arr_stackTraceElement[v1].getClassName())) {
                v = v1;
            }
        }
        runtimeException0.setStackTrace(((StackTraceElement[])Arrays.copyOfRange(arr_stackTraceElement, v + 1, arr_stackTraceElement.length)));
    }

    public static void m(String s) {
        G g0 = new G("lateinit property " + s + " has not been initialized");  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
        q.l(g0, "kotlin.jvm.internal.q");
        throw g0;
    }
}

