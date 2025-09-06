package com.iloen.melon.utils.log;

public class DcfLog {
    public static void a(String s, String s1) {
        try {
            DevLog.get("Dcf").put(s + " " + s1);
        }
        catch(Exception unused_ex) {
        }
    }

    public static void d(String s, String s1) {
        if(s1 != null) {
            DcfLog.a(s, s1);
            LogU.d(s, s1);
        }
    }

    public static void e(String s, String s1) {
        if(s1 != null) {
            DcfLog.a(s, s1);
            LogU.e(s, s1);
        }
    }

    public static void i(String s, String s1) {
        if(s1 != null) {
            DcfLog.a(s, s1);
            LogU.i(s, s1);
        }
    }

    public static void v(String s, String s1) {
        if(s1 != null) {
            DcfLog.a(s, s1);
            LogU.v(s, s1);
        }
    }

    public static void w(String s, String s1) {
        if(s1 != null) {
            DcfLog.a(s, s1);
            LogU.w(s, s1);
        }
    }
}

