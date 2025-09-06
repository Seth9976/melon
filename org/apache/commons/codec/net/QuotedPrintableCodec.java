package org.apache.commons.codec.net;

import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

@Deprecated
public class QuotedPrintableCodec implements BinaryDecoder, BinaryEncoder, StringDecoder, StringEncoder {
    public QuotedPrintableCodec() {
        throw new RuntimeException("Stub!");
    }

    public QuotedPrintableCodec(String s) {
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

    public static final byte[] decodeQuotedPrintable(byte[] arr_b) {
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

    public static final byte[] encodeQuotedPrintable(BitSet bitSet0, byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    public String getDefaultCharset() {
        throw new RuntimeException("Stub!");
    }
}

