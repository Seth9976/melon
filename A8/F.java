package A8;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class f extends Enum {
    public final int a;
    public final int b;
    public final int c;
    public static final z6.f d;
    public static final enum f e;
    public static final f[] f;

    static {
        f f0 = new f(0, 0x7F0600A2, 0x7F0604A1, 0x7F0604B7, "DNA001");  // color:color_ff2ca1
        f f1 = new f(1, 0x7F060085, 0x7F06016A, 0x7F060164, "DNA002");  // color:color_3dff88
        f f2 = new f(2, 0x7F060085, 0x7F06016A, 0x7F060164, "DNA003");  // color:color_3dff88
        f f3 = new f(3, 0x7F0600A2, 0x7F0604A1, 0x7F0604B7, "DNA004");  // color:color_ff2ca1
        f f4 = new f(4, 0x7F06007B, 0x7F06016A, 0x7F060164, "DNA005");  // color:color_00e7ff
        f f5 = new f(5, 0x7F060085, 0x7F06016A, 0x7F060164, "DNA006");  // color:color_3dff88
        f f6 = new f(6, 0x7F0600A2, 0x7F0604A1, 0x7F0604B7, "DNA007");  // color:color_ff2ca1
        f f7 = new f(7, 0x7F0600A2, 0x7F0604A1, 0x7F0604B7, "DNA008");  // color:color_ff2ca1
        f f8 = new f(8, 0x7F060092, 0x7F0604A1, 0x7F0604B7, "DNA009");  // color:color_8c2cff
        f f9 = new f(9, 0x7F06007B, 0x7F06016A, 0x7F060164, "DNA010");  // color:color_00e7ff
        f f10 = new f(10, 0x7F06007B, 0x7F06016A, 0x7F060164, "DNA011");  // color:color_00e7ff
        f f11 = new f(11, 0x7F060092, 0x7F0604A1, 0x7F0604B7, "DNA012");  // color:color_8c2cff
        f f12 = new f(12, 0x7F060092, 0x7F0604A1, 0x7F0604B7, "DNA013");  // color:color_8c2cff
        f.e = new f(13, 0x7F06008B, 0x7F0604A1, 0x7F0604B7, "DEFAULT");  // color:color_727272
        f[] arr_f = {f0, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f.e};
        f.f = arr_f;
        q.g(arr_f, "entries");
        new b(arr_f);
        f.d = new z6.f(1);
    }

    public f(int v, int v1, int v2, int v3, String s) {
        super(s, v);
        this.a = v1;
        this.b = v2;
        this.c = v3;
    }

    public static f valueOf(String s) {
        return (f)Enum.valueOf(f.class, s);
    }

    public static f[] values() {
        return (f[])f.f.clone();
    }
}

