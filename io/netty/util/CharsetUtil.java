package io.netty.util;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Map;

public final class CharsetUtil {
    private static final Charset[] CHARSETS;
    public static final Charset ISO_8859_1;
    public static final Charset US_ASCII;
    public static final Charset UTF_16;
    public static final Charset UTF_16BE;
    public static final Charset UTF_16LE;
    public static final Charset UTF_8;

    static {
        Charset charset0 = Charset.forName("UTF-16");
        CharsetUtil.UTF_16 = charset0;
        Charset charset1 = Charset.forName("UTF-16BE");
        CharsetUtil.UTF_16BE = charset1;
        Charset charset2 = Charset.forName("UTF-16LE");
        CharsetUtil.UTF_16LE = charset2;
        Charset charset3 = Charset.forName("UTF-8");
        CharsetUtil.UTF_8 = charset3;
        Charset charset4 = Charset.forName("ISO-8859-1");
        CharsetUtil.ISO_8859_1 = charset4;
        Charset charset5 = Charset.forName("US-ASCII");
        CharsetUtil.US_ASCII = charset5;
        CharsetUtil.CHARSETS = new Charset[]{charset0, charset1, charset2, charset3, charset4, charset5};
    }

    public static CharsetDecoder decoder(Charset charset0) {
        ObjectUtil.checkNotNull(charset0, "charset");
        Map map0 = InternalThreadLocalMap.get().charsetDecoderCache();
        CharsetDecoder charsetDecoder0 = (CharsetDecoder)map0.get(charset0);
        if(charsetDecoder0 != null) {
            CharsetDecoder charsetDecoder1 = charsetDecoder0.reset();
            CodingErrorAction codingErrorAction0 = CodingErrorAction.REPLACE;
            charsetDecoder1.onMalformedInput(codingErrorAction0).onUnmappableCharacter(codingErrorAction0);
            return charsetDecoder0;
        }
        CharsetDecoder charsetDecoder2 = CharsetUtil.decoder(charset0, CodingErrorAction.REPLACE, CodingErrorAction.REPLACE);
        map0.put(charset0, charsetDecoder2);
        return charsetDecoder2;
    }

    public static CharsetDecoder decoder(Charset charset0, CodingErrorAction codingErrorAction0) {
        return CharsetUtil.decoder(charset0, codingErrorAction0, codingErrorAction0);
    }

    public static CharsetDecoder decoder(Charset charset0, CodingErrorAction codingErrorAction0, CodingErrorAction codingErrorAction1) {
        ObjectUtil.checkNotNull(charset0, "charset");
        CharsetDecoder charsetDecoder0 = charset0.newDecoder();
        charsetDecoder0.onMalformedInput(codingErrorAction0).onUnmappableCharacter(codingErrorAction1);
        return charsetDecoder0;
    }

    public static CharsetEncoder encoder(Charset charset0) {
        ObjectUtil.checkNotNull(charset0, "charset");
        Map map0 = InternalThreadLocalMap.get().charsetEncoderCache();
        CharsetEncoder charsetEncoder0 = (CharsetEncoder)map0.get(charset0);
        if(charsetEncoder0 != null) {
            CharsetEncoder charsetEncoder1 = charsetEncoder0.reset();
            CodingErrorAction codingErrorAction0 = CodingErrorAction.REPLACE;
            charsetEncoder1.onMalformedInput(codingErrorAction0).onUnmappableCharacter(codingErrorAction0);
            return charsetEncoder0;
        }
        CharsetEncoder charsetEncoder2 = CharsetUtil.encoder(charset0, CodingErrorAction.REPLACE, CodingErrorAction.REPLACE);
        map0.put(charset0, charsetEncoder2);
        return charsetEncoder2;
    }

    public static CharsetEncoder encoder(Charset charset0, CodingErrorAction codingErrorAction0) {
        return CharsetUtil.encoder(charset0, codingErrorAction0, codingErrorAction0);
    }

    public static CharsetEncoder encoder(Charset charset0, CodingErrorAction codingErrorAction0, CodingErrorAction codingErrorAction1) {
        ObjectUtil.checkNotNull(charset0, "charset");
        CharsetEncoder charsetEncoder0 = charset0.newEncoder();
        charsetEncoder0.onMalformedInput(codingErrorAction0).onUnmappableCharacter(codingErrorAction1);
        return charsetEncoder0;
    }

    @Deprecated
    public static CharsetDecoder getDecoder(Charset charset0) {
        return CharsetUtil.decoder(charset0);
    }

    @Deprecated
    public static CharsetEncoder getEncoder(Charset charset0) {
        return CharsetUtil.encoder(charset0);
    }

    public static Charset[] values() {
        return CharsetUtil.CHARSETS;
    }
}

