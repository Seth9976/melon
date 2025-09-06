package A8;

import kotlin.jvm.internal.q;
import pe.b;
import w7.d;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class p extends Enum {
    public static final p[] B;
    public final boolean a;
    public final boolean b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public static final d g;
    public static final enum p h;
    public static final enum p i;
    public static final enum p j;
    public static final enum p k;
    public static final enum p l;
    public static final enum p m;
    public static final enum p n;
    public static final enum p o;
    public static final enum p r;
    public static final enum p w;

    static {
        p p0 = new p(0, "RECENT_LOG_FAV_SONG_ODD", 0x7F060084, true, true);  // color:color_36dde8
        p p1 = new p(1, "RECENT_LOG_FAV_SONG_EVEN", 0x7F06009E, true, true);  // color:color_f7a5ff
        p p2 = new p(2, "RECENT_LOG_GENRE_ODD", -1, true, true);
        p p3 = new p(3, "RECENT_LOG_GENRE_EVEN", -1, true, true);
        p.h = new p(4, "RECENT_LOG_ARTIST_ODD", 0x7F060084, true, true);  // color:color_36dde8
        p.i = new p(5, "RECENT_LOG_ARTIST_EVEN", 0x7F060098, true, true);  // color:color_c496ff
        p.j = new p(6, "MONTHLY_LOG_ARTIST_ODD", 0x7F060092, false, false);  // color:color_8c2cff
        p.k = new p(7, "MONTHLY_LOG_ARTIST_EVEN", 0x7F06008C, true, true);  // color:color_73f4de
        p.l = new p(8, "MONTHLY_LOG_SONG_ODD", 0x7F0600A2, false, false);  // color:color_ff2ca1
        p.m = new p(9, "MONTHLY_LOG_SONG_EVEN", 0x7F060094, true, true);  // color:color_ab8aff
        p.n = new p(10, "MONTHLY_LOG_LIKE_ODD", 0x7F060092, false, false);  // color:color_8c2cff
        p.o = new p(11, "MONTHLY_LOG_LIKE_EVEN", 0x7F06008A, true, true);  // color:color_6fff7d
        p.r = new p("MONTHLY_LOG_GRAPH_ODD", 12, false, false, -1, 0x7F0600A2, 0x7F060084, 0x7F060092);  // color:color_ff2ca1
        p.w = new p("MONTHLY_LOG_GRAPH_EVEN", 13, true, true, -1, 0x7F060094, 0x7F06009B, 0x7F060089);  // color:color_ab8aff
        p[] arr_p = {p0, p1, p2, p3, p.h, p.i, p.j, p.k, p.l, p.m, p.n, p.o, p.r, p.w};
        p.B = arr_p;
        q.g(arr_p, "entries");
        new b(arr_p);
        p.g = new d(3);
    }

    public p(int v, String s, int v1, boolean z, boolean z1) {
        this(s, v, z, z1, v1, -1, -1, -1);
    }

    public p(String s, int v, boolean z, boolean z1, int v1, int v2, int v3, int v4) {
        super(s, v);
        this.a = z;
        this.b = z1;
        this.c = v1;
        this.d = v2;
        this.e = v3;
        this.f = v4;
    }

    public static p valueOf(String s) {
        return (p)Enum.valueOf(p.class, s);
    }

    public static p[] values() {
        return (p[])p.B.clone();
    }
}

