package io.netty.util.internal;

public final class ClassInitializerUtil {
    private static void tryLoadClass(ClassLoader classLoader0, String s) {
        try {
            Class.forName(s, true, classLoader0);
        }
        catch(ClassNotFoundException | SecurityException unused_ex) {
        }
    }

    public static void tryLoadClasses(Class class0, Class[] arr_class) {
        ClassLoader classLoader0 = PlatformDependent.getClassLoader(class0);
        for(int v = 0; v < arr_class.length; ++v) {
            ClassInitializerUtil.tryLoadClass(classLoader0, arr_class[v].getName());
        }
    }
}

