package androidx.datastore.preferences.protobuf;

import e0.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class v extends Enum {
    public final int a;
    public static final enum v b;
    public static final enum v c;
    public static final v[] d;
    public static final v[] e;

    static {
        v v0 = new v("DOUBLE", 0, 0, 1, G.f);
        v v1 = new v("FLOAT", 1, 1, 1, G.e);
        v v2 = new v("INT64", 2, 2, 1, G.d);
        v v3 = new v("UINT64", 3, 3, 1, G.d);
        v v4 = new v("INT32", 4, 4, 1, G.c);
        v v5 = new v("FIXED64", 5, 5, 1, G.d);
        v v6 = new v("FIXED32", 6, 6, 1, G.c);
        v v7 = new v("BOOL", 7, 7, 1, G.g);
        v v8 = new v("STRING", 8, 8, 1, G.h);
        v v9 = new v("MESSAGE", 9, 9, 1, G.k);
        v v10 = new v("BYTES", 10, 10, 1, G.i);
        v v11 = new v("UINT32", 11, 11, 1, G.c);
        v v12 = new v("ENUM", 12, 12, 1, G.j);
        v v13 = new v("SFIXED32", 13, 13, 1, G.c);
        v v14 = new v("SFIXED64", 14, 14, 1, G.d);
        v v15 = new v("SINT32", 15, 15, 1, G.c);
        v v16 = new v("SINT64", 16, 16, 1, G.d);
        v v17 = new v("GROUP", 17, 17, 1, G.k);
        v v18 = new v("DOUBLE_LIST", 18, 18, 2, G.f);
        v v19 = new v("FLOAT_LIST", 19, 19, 2, G.e);
        v v20 = new v("INT64_LIST", 20, 20, 2, G.d);
        v v21 = new v("UINT64_LIST", 21, 21, 2, G.d);
        v v22 = new v("INT32_LIST", 22, 22, 2, G.c);
        v v23 = new v("FIXED64_LIST", 23, 23, 2, G.d);
        v v24 = new v("FIXED32_LIST", 24, 24, 2, G.c);
        v v25 = new v("BOOL_LIST", 25, 25, 2, G.g);
        v v26 = new v("STRING_LIST", 26, 26, 2, G.h);
        v v27 = new v("MESSAGE_LIST", 27, 27, 2, G.k);
        v v28 = new v("BYTES_LIST", 28, 28, 2, G.i);
        v v29 = new v("UINT32_LIST", 29, 29, 2, G.c);
        v v30 = new v("ENUM_LIST", 30, 30, 2, G.j);
        v v31 = new v("SFIXED32_LIST", 0x1F, 0x1F, 2, G.c);
        v v32 = new v("SFIXED64_LIST", 0x20, 0x20, 2, G.d);
        v v33 = new v("SINT32_LIST", 33, 33, 2, G.c);
        v v34 = new v("SINT64_LIST", 34, 34, 2, G.d);
        v.b = new v("DOUBLE_LIST_PACKED", 35, 35, 3, G.f);
        v v35 = new v("FLOAT_LIST_PACKED", 36, 36, 3, G.e);
        v v36 = new v("INT64_LIST_PACKED", 37, 37, 3, G.d);
        v v37 = new v("UINT64_LIST_PACKED", 38, 38, 3, G.d);
        v v38 = new v("INT32_LIST_PACKED", 39, 39, 3, G.c);
        v v39 = new v("FIXED64_LIST_PACKED", 40, 40, 3, G.d);
        v v40 = new v("FIXED32_LIST_PACKED", 41, 41, 3, G.c);
        v v41 = new v("BOOL_LIST_PACKED", 42, 42, 3, G.g);
        v v42 = new v("UINT32_LIST_PACKED", 43, 43, 3, G.c);
        v v43 = new v("ENUM_LIST_PACKED", 44, 44, 3, G.j);
        v v44 = new v("SFIXED32_LIST_PACKED", 45, 45, 3, G.c);
        v v45 = new v("SFIXED64_LIST_PACKED", 46, 46, 3, G.d);
        v v46 = new v("SINT32_LIST_PACKED", 0x2F, 0x2F, 3, G.c);
        v.c = new v("SINT64_LIST_PACKED", 0x30, 0x30, 3, G.d);
        v.e = new v[]{v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22, v23, v24, v25, v26, v27, v28, v29, v30, v31, v32, v33, v34, v.b, v35, v36, v37, v38, v39, v40, v41, v42, v43, v44, v45, v46, v.c, new v("GROUP_LIST", 49, 49, 2, G.k), new v("MAP", 50, 50, 4, G.b)};
        v[] arr_v = (v[])v.e.clone();
        v.d = new v[arr_v.length];
        for(int v47 = 0; v47 < arr_v.length; ++v47) {
            v v48 = arr_v[v47];
            v.d[v48.a] = v48;
        }
    }

    public v(String s, int v, int v1, int v2, G g0) {
        super(s, v);
        this.a = v1;
        switch(b.b(v2)) {
            case 1: {
                g0.getClass();
                break;
            }
            case 3: {
                g0.getClass();
            }
        }
        if(v2 == 1) {
            g0.ordinal();
        }
    }

    public static v valueOf(String s) {
        return (v)Enum.valueOf(v.class, s);
    }

    public static v[] values() [...] // Inlined contents
}

