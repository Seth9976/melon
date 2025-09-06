package com.google.protobuf;

import e0.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class p1 extends Enum {
    public final int a;
    public static final enum p1 b;
    public static final enum p1 c;
    public static final p1[] d;
    public static final p1[] e;

    static {
        p1 p10 = new p1("DOUBLE", 0, 0, 1, X1.f);
        p1 p11 = new p1("FLOAT", 1, 1, 1, X1.e);
        p1 p12 = new p1("INT64", 2, 2, 1, X1.d);
        p1 p13 = new p1("UINT64", 3, 3, 1, X1.d);
        p1 p14 = new p1("INT32", 4, 4, 1, X1.c);
        p1 p15 = new p1("FIXED64", 5, 5, 1, X1.d);
        p1 p16 = new p1("FIXED32", 6, 6, 1, X1.c);
        p1 p17 = new p1("BOOL", 7, 7, 1, X1.g);
        p1 p18 = new p1("STRING", 8, 8, 1, X1.h);
        p1 p19 = new p1("MESSAGE", 9, 9, 1, X1.k);
        p1 p110 = new p1("BYTES", 10, 10, 1, X1.i);
        p1 p111 = new p1("UINT32", 11, 11, 1, X1.c);
        p1 p112 = new p1("ENUM", 12, 12, 1, X1.j);
        p1 p113 = new p1("SFIXED32", 13, 13, 1, X1.c);
        p1 p114 = new p1("SFIXED64", 14, 14, 1, X1.d);
        p1 p115 = new p1("SINT32", 15, 15, 1, X1.c);
        p1 p116 = new p1("SINT64", 16, 16, 1, X1.d);
        p1 p117 = new p1("GROUP", 17, 17, 1, X1.k);
        p1 p118 = new p1("DOUBLE_LIST", 18, 18, 2, X1.f);
        p1 p119 = new p1("FLOAT_LIST", 19, 19, 2, X1.e);
        p1 p120 = new p1("INT64_LIST", 20, 20, 2, X1.d);
        p1 p121 = new p1("UINT64_LIST", 21, 21, 2, X1.d);
        p1 p122 = new p1("INT32_LIST", 22, 22, 2, X1.c);
        p1 p123 = new p1("FIXED64_LIST", 23, 23, 2, X1.d);
        p1 p124 = new p1("FIXED32_LIST", 24, 24, 2, X1.c);
        p1 p125 = new p1("BOOL_LIST", 25, 25, 2, X1.g);
        p1 p126 = new p1("STRING_LIST", 26, 26, 2, X1.h);
        p1 p127 = new p1("MESSAGE_LIST", 27, 27, 2, X1.k);
        p1 p128 = new p1("BYTES_LIST", 28, 28, 2, X1.i);
        p1 p129 = new p1("UINT32_LIST", 29, 29, 2, X1.c);
        p1 p130 = new p1("ENUM_LIST", 30, 30, 2, X1.j);
        p1 p131 = new p1("SFIXED32_LIST", 0x1F, 0x1F, 2, X1.c);
        p1 p132 = new p1("SFIXED64_LIST", 0x20, 0x20, 2, X1.d);
        p1 p133 = new p1("SINT32_LIST", 33, 33, 2, X1.c);
        p1 p134 = new p1("SINT64_LIST", 34, 34, 2, X1.d);
        p1.b = new p1("DOUBLE_LIST_PACKED", 35, 35, 3, X1.f);
        p1 p135 = new p1("FLOAT_LIST_PACKED", 36, 36, 3, X1.e);
        p1 p136 = new p1("INT64_LIST_PACKED", 37, 37, 3, X1.d);
        p1 p137 = new p1("UINT64_LIST_PACKED", 38, 38, 3, X1.d);
        p1 p138 = new p1("INT32_LIST_PACKED", 39, 39, 3, X1.c);
        p1 p139 = new p1("FIXED64_LIST_PACKED", 40, 40, 3, X1.d);
        p1 p140 = new p1("FIXED32_LIST_PACKED", 41, 41, 3, X1.c);
        p1 p141 = new p1("BOOL_LIST_PACKED", 42, 42, 3, X1.g);
        p1 p142 = new p1("UINT32_LIST_PACKED", 43, 43, 3, X1.c);
        p1 p143 = new p1("ENUM_LIST_PACKED", 44, 44, 3, X1.j);
        p1 p144 = new p1("SFIXED32_LIST_PACKED", 45, 45, 3, X1.c);
        p1 p145 = new p1("SFIXED64_LIST_PACKED", 46, 46, 3, X1.d);
        p1 p146 = new p1("SINT32_LIST_PACKED", 0x2F, 0x2F, 3, X1.c);
        p1.c = new p1("SINT64_LIST_PACKED", 0x30, 0x30, 3, X1.d);
        p1.e = new p1[]{p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p110, p111, p112, p113, p114, p115, p116, p117, p118, p119, p120, p121, p122, p123, p124, p125, p126, p127, p128, p129, p130, p131, p132, p133, p134, p1.b, p135, p136, p137, p138, p139, p140, p141, p142, p143, p144, p145, p146, p1.c, new p1("GROUP_LIST", 49, 49, 2, X1.k), new p1("MAP", 50, 50, 4, X1.b)};
        p1[] arr_p1 = (p1[])p1.e.clone();
        p1.d = new p1[arr_p1.length];
        for(int v = 0; v < arr_p1.length; ++v) {
            p1 p147 = arr_p1[v];
            p1.d[p147.a] = p147;
        }
    }

    public p1(String s, int v, int v1, int v2, X1 x10) {
        super(s, v);
        this.a = v1;
        switch(b.b(v2)) {
            case 1: {
                x10.getClass();
                break;
            }
            case 3: {
                x10.getClass();
            }
        }
        if(v2 == 1) {
            x10.ordinal();
        }
    }

    public static p1 valueOf(String s) {
        return (p1)Enum.valueOf(p1.class, s);
    }

    public static p1[] values() [...] // Inlined contents
}

