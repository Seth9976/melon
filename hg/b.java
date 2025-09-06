package hg;

import J0.h;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public final class b {
    public final String a;
    public final long[] b;
    public boolean c;
    public h d;
    public final d e;

    public b(d d0, String s) {
        this.e = d0;
        this.a = s;
        this.b = new long[d0.f];
    }

    public static void a(b b0, String[] arr_s) {
        if(arr_s.length == b0.e.f) {
            try {
                for(int v = 0; v < arr_s.length; ++v) {
                    b0.b[v] = Long.parseLong(arr_s[v]);
                }
                return;
            }
            catch(NumberFormatException unused_ex) {
                throw new IOException("unexpected journal line: " + Arrays.toString(arr_s));
            }
        }
        throw new IOException("unexpected journal line: " + Arrays.toString(arr_s));
    }

    public final File b(int v) {
        return new File(this.e.a, this.a + "." + v);
    }

    public final String c() {
        StringBuilder stringBuilder0 = new StringBuilder();
        long[] arr_v = this.b;
        for(int v = 0; v < arr_v.length; ++v) {
            long v1 = arr_v[v];
            stringBuilder0.append(' ');
            stringBuilder0.append(v1);
        }
        return stringBuilder0.toString();
    }
}

