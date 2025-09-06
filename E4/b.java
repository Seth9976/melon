package e4;

import I6.b0;
import java.util.regex.Pattern;

public final class b {
    public final int a;
    public final int b;
    public final int c;
    public static final Pattern d;
    public static final b0 e;
    public static final b0 f;
    public static final b0 g;
    public static final b0 h;

    static {
        b.d = Pattern.compile("\\s+");
        b.e = b0.o(2, new Object[]{"auto", "none"});
        b.f = b0.o(3, new Object[]{"dot", "sesame", "circle"});
        b.g = b0.o(2, new Object[]{"filled", "open"});
        b.h = b0.o(3, new Object[]{"after", "before", "outside"});
    }

    public b(int v, int v1, int v2) {
        this.a = v;
        this.b = v1;
        this.c = v2;
    }
}

