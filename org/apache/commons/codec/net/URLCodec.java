package org.apache.commons.codec.net;

import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

@Deprecated
public class URLCodec implements BinaryDecoder, BinaryEncoder, StringDecoder, StringEncoder {
    protected static byte ESCAPE_CHAR;
    protected static final BitSet WWW_FORM_URL;
    protected String charset;

    public URLCodec() {
        throw new RuntimeException("Stub!");
    }

    public URLCodec(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.codec.Decoder
    public Object decode(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.codec.StringDecoder
    public String decode(String s) {
        throw new RuntimeException("Stub!");
    }

    public String decode(String s, String s1) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    public static final byte[] decodeUrl(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.codec.Encoder
    public Object encode(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.codec.StringEncoder
    public String encode(String s) {
        throw new RuntimeException("Stub!");
    }

    public String encode(String s, String s1) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    public static final byte[] encodeUrl(BitSet bitSet0, byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    public String getDefaultCharset() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public String getEncoding() {
        throw new RuntimeException("Stub!");
    }
}

