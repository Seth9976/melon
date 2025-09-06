package com.google.gson;

public final class i {
    public final String a;
    public final String b;
    public final boolean c;
    public static final i d;

    static {
        i.d = new i("", "", false);
        new i("\n", "  ", true);
    }

    public i(String s, String s1, boolean z) {
        if(!s.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if(!s1.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.a = s;
        this.b = s1;
        this.c = z;
    }
}

