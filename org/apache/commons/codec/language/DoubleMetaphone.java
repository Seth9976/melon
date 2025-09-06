package org.apache.commons.codec.language;

import org.apache.commons.codec.StringEncoder;

@Deprecated
public class DoubleMetaphone implements StringEncoder {
    public class DoubleMetaphoneResult {
        public DoubleMetaphoneResult(int v) {
            throw new RuntimeException("Stub!");
        }

        public void append(char c) {
            throw new RuntimeException("Stub!");
        }

        public void append(char c, char c1) {
            throw new RuntimeException("Stub!");
        }

        public void append(String s) {
            throw new RuntimeException("Stub!");
        }

        public void append(String s, String s1) {
            throw new RuntimeException("Stub!");
        }

        public void appendAlternate(char c) {
            throw new RuntimeException("Stub!");
        }

        public void appendAlternate(String s) {
            throw new RuntimeException("Stub!");
        }

        public void appendPrimary(char c) {
            throw new RuntimeException("Stub!");
        }

        public void appendPrimary(String s) {
            throw new RuntimeException("Stub!");
        }

        public String getAlternate() {
            throw new RuntimeException("Stub!");
        }

        public String getPrimary() {
            throw new RuntimeException("Stub!");
        }

        public boolean isComplete() {
            throw new RuntimeException("Stub!");
        }
    }

    protected int maxCodeLen;

    public DoubleMetaphone() {
        throw new RuntimeException("Stub!");
    }

    public char charAt(String s, int v) {
        throw new RuntimeException("Stub!");
    }

    public static boolean contains(String s, int v, int v1, String[] arr_s) {
        throw new RuntimeException("Stub!");
    }

    public String doubleMetaphone(String s) {
        throw new RuntimeException("Stub!");
    }

    public String doubleMetaphone(String s, boolean z) {
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

    public int getMaxCodeLen() {
        throw new RuntimeException("Stub!");
    }

    public boolean isDoubleMetaphoneEqual(String s, String s1) {
        throw new RuntimeException("Stub!");
    }

    public boolean isDoubleMetaphoneEqual(String s, String s1, boolean z) {
        throw new RuntimeException("Stub!");
    }

    public void setMaxCodeLen(int v) {
        throw new RuntimeException("Stub!");
    }
}

