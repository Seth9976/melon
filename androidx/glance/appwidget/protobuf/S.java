package androidx.glance.appwidget.protobuf;

import e0.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class s extends Enum {
    public final int a;
    public static final enum s b;
    public static final enum s c;
    public static final s[] d;
    public static final s[] e;

    static {
        s s0 = new s("DOUBLE", 0, 0, 1, E.f);
        s s1 = new s("FLOAT", 1, 1, 1, E.e);
        s s2 = new s("INT64", 2, 2, 1, E.d);
        s s3 = new s("UINT64", 3, 3, 1, E.d);
        s s4 = new s("INT32", 4, 4, 1, E.c);
        s s5 = new s("FIXED64", 5, 5, 1, E.d);
        s s6 = new s("FIXED32", 6, 6, 1, E.c);
        s s7 = new s("BOOL", 7, 7, 1, E.g);
        s s8 = new s("STRING", 8, 8, 1, E.h);
        s s9 = new s("MESSAGE", 9, 9, 1, E.k);
        s s10 = new s("BYTES", 10, 10, 1, E.i);
        s s11 = new s("UINT32", 11, 11, 1, E.c);
        s s12 = new s("ENUM", 12, 12, 1, E.j);
        s s13 = new s("SFIXED32", 13, 13, 1, E.c);
        s s14 = new s("SFIXED64", 14, 14, 1, E.d);
        s s15 = new s("SINT32", 15, 15, 1, E.c);
        s s16 = new s("SINT64", 16, 16, 1, E.d);
        s s17 = new s("GROUP", 17, 17, 1, E.k);
        s s18 = new s("DOUBLE_LIST", 18, 18, 2, E.f);
        s s19 = new s("FLOAT_LIST", 19, 19, 2, E.e);
        s s20 = new s("INT64_LIST", 20, 20, 2, E.d);
        s s21 = new s("UINT64_LIST", 21, 21, 2, E.d);
        s s22 = new s("INT32_LIST", 22, 22, 2, E.c);
        s s23 = new s("FIXED64_LIST", 23, 23, 2, E.d);
        s s24 = new s("FIXED32_LIST", 24, 24, 2, E.c);
        s s25 = new s("BOOL_LIST", 25, 25, 2, E.g);
        s s26 = new s("STRING_LIST", 26, 26, 2, E.h);
        s s27 = new s("MESSAGE_LIST", 27, 27, 2, E.k);
        s s28 = new s("BYTES_LIST", 28, 28, 2, E.i);
        s s29 = new s("UINT32_LIST", 29, 29, 2, E.c);
        s s30 = new s("ENUM_LIST", 30, 30, 2, E.j);
        s s31 = new s("SFIXED32_LIST", 0x1F, 0x1F, 2, E.c);
        s s32 = new s("SFIXED64_LIST", 0x20, 0x20, 2, E.d);
        s s33 = new s("SINT32_LIST", 33, 33, 2, E.c);
        s s34 = new s("SINT64_LIST", 34, 34, 2, E.d);
        s.b = new s("DOUBLE_LIST_PACKED", 35, 35, 3, E.f);
        s s35 = new s("FLOAT_LIST_PACKED", 36, 36, 3, E.e);
        s s36 = new s("INT64_LIST_PACKED", 37, 37, 3, E.d);
        s s37 = new s("UINT64_LIST_PACKED", 38, 38, 3, E.d);
        s s38 = new s("INT32_LIST_PACKED", 39, 39, 3, E.c);
        s s39 = new s("FIXED64_LIST_PACKED", 40, 40, 3, E.d);
        s s40 = new s("FIXED32_LIST_PACKED", 41, 41, 3, E.c);
        s s41 = new s("BOOL_LIST_PACKED", 42, 42, 3, E.g);
        s s42 = new s("UINT32_LIST_PACKED", 43, 43, 3, E.c);
        s s43 = new s("ENUM_LIST_PACKED", 44, 44, 3, E.j);
        s s44 = new s("SFIXED32_LIST_PACKED", 45, 45, 3, E.c);
        s s45 = new s("SFIXED64_LIST_PACKED", 46, 46, 3, E.d);
        s s46 = new s("SINT32_LIST_PACKED", 0x2F, 0x2F, 3, E.c);
        s.c = new s("SINT64_LIST_PACKED", 0x30, 0x30, 3, E.d);
        s.e = new s[]{s0, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31, s32, s33, s34, s.b, s35, s36, s37, s38, s39, s40, s41, s42, s43, s44, s45, s46, s.c, new s("GROUP_LIST", 49, 49, 2, E.k), new s("MAP", 50, 50, 4, E.b)};
        s[] arr_s = (s[])s.e.clone();
        s.d = new s[arr_s.length];
        for(int v = 0; v < arr_s.length; ++v) {
            s s47 = arr_s[v];
            s.d[s47.a] = s47;
        }
    }

    public s(String s, int v, int v1, int v2, E e0) {
        super(s, v);
        this.a = v1;
        switch(b.b(v2)) {
            case 1: {
                e0.getClass();
                break;
            }
            case 3: {
                e0.getClass();
            }
        }
        if(v2 == 1) {
            e0.ordinal();
        }
    }

    public static s valueOf(String s) {
        return (s)Enum.valueOf(s.class, s);
    }

    public static s[] values() [...] // Inlined contents
}

