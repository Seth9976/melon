package org.apache.http.client.utils;

import java.util.StringTokenizer;
import org.apache.http.annotation.Immutable;

@Immutable
public class Rfc3492Idn implements Idn {
    private static final String ACE_PREFIX = "xn--";
    private static final int base = 36;
    private static final int damp = 700;
    private static final char delimiter = '-';
    private static final int initial_bias = 72;
    private static final int initial_n = 0x80;
    private static final int skew = 38;
    private static final int tmax = 26;
    private static final int tmin = 1;

    private int adapt(int v, int v1, boolean z) {
        int v2 = z ? v / 700 : v / 2;
        int v3 = v2 / v1 + v2;
        int v4;
        for(v4 = 0; v3 > 455; v4 += 36) {
            v3 /= 35;
        }
        return v3 * 36 / (v3 + 38) + v4;
    }

    public String decode(String s) {
        int v9;
        StringBuilder stringBuilder0 = new StringBuilder(s.length());
        int v = s.lastIndexOf(45);
        int v1 = 0x80;
        int v2 = 72;
        if(v != -1) {
            stringBuilder0.append(s.subSequence(0, v));
            s = s.substring(v + 1);
        }
        for(int v3 = 0; s.length() > 0; v3 = v10 + 1) {
            int v5 = v3;
            int v6 = 1;
            for(int v4 = 36; s.length() != 0; v4 += 36) {
                int v7 = s.charAt(0);
                s = s.substring(1);
                int v8 = this.digit(((char)v7));
                v5 += v8 * v6;
                if(v4 <= v2 + 1) {
                    v9 = 1;
                }
                else {
                    v9 = v4 < v2 + 26 ? v4 - v2 : 26;
                }
                if(v8 < v9) {
                    break;
                }
                v6 *= 36 - v9;
            }
            v2 = this.adapt(v5 - v3, stringBuilder0.length() + 1, v3 == 0);
            v1 += v5 / (stringBuilder0.length() + 1);
            int v10 = v5 % (stringBuilder0.length() + 1);
            stringBuilder0.insert(v10, ((char)v1));
        }
        return stringBuilder0.toString();
    }

    private int digit(char c) {
        if(c >= 65 && c <= 90) {
            return c - 65;
        }
        if(c >= 97 && c <= 0x7A) {
            return c - 97;
        }
        if(c < 0x30 || c > 57) {
            throw new IllegalArgumentException("illegal digit: " + c);
        }
        return c - 22;
    }

    @Override  // org.apache.http.client.utils.Idn
    public String toUnicode(String s) {
        StringBuilder stringBuilder0 = new StringBuilder(s.length());
        StringTokenizer stringTokenizer0 = new StringTokenizer(s, ".");
        while(stringTokenizer0.hasMoreTokens()) {
            String s1 = stringTokenizer0.nextToken();
            if(stringBuilder0.length() > 0) {
                stringBuilder0.append('.');
            }
            if(s1.startsWith("xn--")) {
                s1 = this.decode(s1.substring(4));
            }
            stringBuilder0.append(s1);
        }
        return stringBuilder0.toString();
    }
}

