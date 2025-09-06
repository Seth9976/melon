package org.apache.commons.codec.language;

import org.apache.commons.codec.StringEncoder;

@Deprecated
public class RefinedSoundex implements StringEncoder {
    public static final RefinedSoundex US_ENGLISH;
    public static final char[] US_ENGLISH_MAPPING;

    public RefinedSoundex() {
        throw new RuntimeException("Stub!");
    }

    public RefinedSoundex(char[] arr_c) {
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

    public String soundex(String s) {
        throw new RuntimeException("Stub!");
    }
}

