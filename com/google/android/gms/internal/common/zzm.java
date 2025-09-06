package com.google.android.gms.internal.common;

import k8.Y;

final class zzm extends zzl {
    private final char zza;

    public zzm(char c) {
        this.zza = c;
    }

    @Override
    public final String toString() {
        char[] arr_c = {'\\', 'u', '\u0000', '\u0000', '\u0000', '\u0000'};
        int v = this.zza;
        for(int v1 = 0; v1 < 4; ++v1) {
            arr_c[5 - v1] = "0123456789ABCDEF".charAt(v & 15);
            v >>= 4;
        }
        String s = String.copyValueOf(arr_c);
        return Y.l(new StringBuilder(String.valueOf(s).length() + 18), "CharMatcher.is(\'", s, "\')");
    }

    @Override  // com.google.android.gms.internal.common.zzp
    public final boolean zza(char c) {
        return c == this.zza;
    }
}

