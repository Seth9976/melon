package org.apache.commons.codec.binary;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;

@Deprecated
public class Hex implements BinaryDecoder, BinaryEncoder {
    public Hex() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.codec.Decoder
    public Object decode(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    public static byte[] decodeHex(char[] arr_c) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.codec.Encoder
    public Object encode(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    public static char[] encodeHex(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    public static int toDigit(char c, int v) {
        throw new RuntimeException("Stub!");
    }
}

