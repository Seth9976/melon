package org.apache.commons.codec.binary;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;

@Deprecated
public class Base64 implements BinaryDecoder, BinaryEncoder {
    public Base64() {
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

    public static byte[] decodeBase64(byte[] arr_b) {
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

    public static byte[] encodeBase64(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    public static byte[] encodeBase64(byte[] arr_b, boolean z) {
        throw new RuntimeException("Stub!");
    }

    public static byte[] encodeBase64Chunked(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    public static boolean isArrayByteBase64(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }
}

