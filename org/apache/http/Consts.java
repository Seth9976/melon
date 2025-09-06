package org.apache.http;

import java.nio.charset.Charset;

public final class Consts {
    public static final Charset ASCII = null;
    public static final int CR = 13;
    public static final int HT = 9;
    public static final Charset ISO_8859_1 = null;
    public static final int LF = 10;
    public static final int SP = 0x20;
    public static final Charset UTF_8;

    static {
        Consts.UTF_8 = Charset.forName("UTF-8");
        Consts.ASCII = Charset.forName("US-ASCII");
        Consts.ISO_8859_1 = Charset.forName("ISO-8859-1");
    }
}

