package org.apache.commons.codec.net;

@Deprecated
abstract class RFC1522Codec {
    public RFC1522Codec() {
        throw new RuntimeException("Stub!");
    }

    public String decodeText(String s) {
        throw new RuntimeException("Stub!");
    }

    public abstract byte[] doDecoding(byte[] arg1);

    public abstract byte[] doEncoding(byte[] arg1);

    public String encodeText(String s, String s1) {
        throw new RuntimeException("Stub!");
    }

    public abstract String getEncoding();
}

