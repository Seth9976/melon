package i.n.i.b.a.s.e;

import java.nio.charset.Charset;

public abstract class b9 {
    public static final Charset a;
    public static final Charset b;
    public static final Charset c;
    public static final Charset d;
    public static final Charset e;

    static {
        b9.a = Charset.forName("US-ASCII");
        b9.b = Charset.forName("ISO-8859-1");
        b9.c = Charset.forName("UTF-8");
        Charset.forName("UTF-16BE");
        b9.d = Charset.forName("UTF-16LE");
        b9.e = Charset.forName("UTF-16");
    }
}

