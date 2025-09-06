package io.netty.util.internal;

final class NativeLibraryUtil {
    public static void loadLibrary(String s, boolean z) {
        if(z) {
            System.load(s);
            return;
        }
        System.loadLibrary(s);
    }
}

