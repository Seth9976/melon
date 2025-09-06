package org.apache.http.client.utils;

import org.apache.http.annotation.Immutable;

@Immutable
public class Punycode {
    private static final Idn impl;

    static {
        JdkIdn jdkIdn0;
        try {
            jdkIdn0 = new JdkIdn();
        }
        catch(Exception unused_ex) {
            jdkIdn0 = new Rfc3492Idn();
        }
        Punycode.impl = jdkIdn0;
    }

    public static String toUnicode(String s) {
        return Punycode.impl.toUnicode(s);
    }
}

