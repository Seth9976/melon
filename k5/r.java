package k5;

import okio.ByteString;

public abstract class r {
    public static final ByteString a;
    public static final ByteString b;
    public static final ByteString c;
    public static final ByteString d;
    public static final ByteString e;
    public static final ByteString f;
    public static final ByteString g;
    public static final ByteString h;
    public static final ByteString i;

    static {
        r.a = ByteString.Companion.encodeUtf8("GIF87a");
        r.b = ByteString.Companion.encodeUtf8("GIF89a");
        r.c = ByteString.Companion.encodeUtf8("RIFF");
        r.d = ByteString.Companion.encodeUtf8("WEBP");
        r.e = ByteString.Companion.encodeUtf8("VP8X");
        r.f = ByteString.Companion.encodeUtf8("ftyp");
        r.g = ByteString.Companion.encodeUtf8("msf1");
        r.h = ByteString.Companion.encodeUtf8("hevc");
        r.i = ByteString.Companion.encodeUtf8("hevx");
    }
}

