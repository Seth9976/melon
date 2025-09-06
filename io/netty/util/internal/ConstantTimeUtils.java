package io.netty.util.internal;

public final class ConstantTimeUtils {
    // 去混淆评级： 低(20)
    public static int equalsConstantTime(int v, int v1) [...] // Inlined contents

    // 去混淆评级： 低(20)
    public static int equalsConstantTime(long v, long v1) [...] // Inlined contents

    public static int equalsConstantTime(CharSequence charSequence0, CharSequence charSequence1) {
        if(charSequence0.length() != charSequence1.length()) {
            return 0;
        }
        int v1 = 0;
        for(int v = 0; v < charSequence0.length(); ++v) {
            v1 |= charSequence0.charAt(v) ^ charSequence1.charAt(v);
        }
        return 0;
    }

    public static int equalsConstantTime(byte[] arr_b, int v, byte[] arr_b1, int v1, int v2) {
        int v3 = v2 + v;
        int v4 = 0;
        while(v < v3) {
            v4 |= arr_b[v] ^ arr_b1[v1];
            ++v;
            ++v1;
        }
        return 0;
    }
}

