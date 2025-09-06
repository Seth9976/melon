package org.apache.commons.codec.binary;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;

@Deprecated
public class BinaryCodec implements BinaryDecoder, BinaryEncoder {
    public BinaryCodec() {
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

    @Override  // org.apache.commons.codec.Encoder
    public Object encode(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    public static byte[] fromAscii(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    public static byte[] fromAscii(char[] arr_c) {
        throw new RuntimeException("Stub!");
    }

    public static byte[] toAsciiBytes(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    public static char[] toAsciiChars(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    public static String toAsciiString(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    public byte[] toByteArray(String s) {
        throw new RuntimeException("Stub!");
    }
}

