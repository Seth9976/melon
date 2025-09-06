package org.apache.commons.codec.language;

import org.apache.commons.codec.StringEncoder;

@Deprecated
public class Soundex implements StringEncoder {
    public static final Soundex US_ENGLISH = null;
    public static final char[] US_ENGLISH_MAPPING = null;
    public static final String US_ENGLISH_MAPPING_STRING = "01230120022455012623010202";

    public Soundex() {
        throw new RuntimeException("Stub!");
    }

    public Soundex(char[] arr_c) {
        throw new RuntimeException("Stub!");
    }

    public int difference(String s, String s1) {
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

    @Deprecated
    public int getMaxLength() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public void setMaxLength(int v) {
        throw new RuntimeException("Stub!");
    }

    public String soundex(String s) {
        throw new RuntimeException("Stub!");
    }
}

