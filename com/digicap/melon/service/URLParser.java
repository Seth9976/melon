package com.digicap.melon.service;

class URLParser {
    public String a;
    public String b;

    public URLParser() {
        this.a = null;
        this.b = null;
    }

    public void cleanInfo() {
        this.a = null;
        this.b = null;
    }

    public String getContentExtension() {
        return this.b;
    }

    public String getContentURL() {
        return this.a;
    }

    public int getEndPoint() [...] // Inlined contents

    public boolean getFlagOfRange() [...] // Inlined contents

    public int getStartPoint() [...] // Inlined contents

    public boolean parseURL(String s) {
        if(s == null) {
            return false;
        }
        s.indexOf("/", 0);
        String s1 = s.substring(0, s.length());
        this.a = s1;
        int v = s1.length();
        this.b = this.a.substring(v - 3, v).toUpperCase();
        return true;
    }
}

