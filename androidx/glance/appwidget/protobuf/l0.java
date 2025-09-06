package androidx.glance.appwidget.protobuf;

import d5.f;

public abstract class l0 {
    public static final f a;

    // 去混淆评级： 低(25)
    static {
        l0.a = !i0.e || !i0.d ? new j0(0) : new j0(1);
    }

    public static int a(String s) {
        int v = s.length();
        int v1 = 0;
        int v2;
        for(v2 = 0; v2 < v && s.charAt(v2) < 0x80; ++v2) {
        }
        int v3 = v;
        while(v2 < v) {
            int v4 = s.charAt(v2);
            if(v4 < 0x800) {
                v3 += 0x7F - v4 >>> 0x1F;
                ++v2;
            }
            else {
                int v5 = s.length();
                while(v2 < v5) {
                    int v6 = s.charAt(v2);
                    if(v6 < 0x800) {
                        v1 += 0x7F - v6 >>> 0x1F;
                    }
                    else {
                        v1 += 2;
                        if(0xD800 <= v6 && v6 <= 0xDFFF) {
                            if(Character.codePointAt(s, v2) < 0x10000) {
                                throw new k0(v2, v5);
                            }
                            ++v2;
                        }
                    }
                    ++v2;
                }
                v3 += v1;
                if(true) {
                    break;
                }
            }
        }
        if(v3 < v) {
            throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long)v3) + 0x100000000L));
        }
        return v3;
    }
}

