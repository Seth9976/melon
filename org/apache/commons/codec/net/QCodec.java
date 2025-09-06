package org.apache.commons.codec.net;

import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

@Deprecated
public class QCodec extends RFC1522Codec implements StringDecoder, StringEncoder {
    public QCodec() {
        throw new RuntimeException("Stub!");
    }

    public QCodec(String s) {
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

    @Override  // org.apache.commons.codec.net.RFC1522Codec
    public byte[] doDecoding(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.codec.net.RFC1522Codec
    public byte[] doEncoding(byte[] arr_b) {
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

    public String getDefaultCharset() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.codec.net.RFC1522Codec
    public String getEncoding() {
        throw new RuntimeException("Stub!");
    }

    public boolean isEncodeBlanks() {
        throw new RuntimeException("Stub!");
    }

    public void setEncodeBlanks(boolean z) {
        throw new RuntimeException("Stub!");
    }
}

