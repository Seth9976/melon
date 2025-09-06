package O5;

import N5.c;
import Q5.m;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class a implements m {
    public final String a;
    public final String b;
    public static final String c;
    public static final Set d;
    public static final a e;
    public static final a f;

    // 去混淆评级： 低(28)
    static {
        a.c = "https://firebaselogging.googleapis.com/v0cc/log/batch?format=json_proto3";
        a.d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new c[]{new c("proto"), new c("json")})));
        a.e = new a("https://firebaselogging.googleapis.com/v0cc/log/batch?format=json_proto3", null);
        a.f = new a("https://firebaselogging-pa.googleapis.com/v1/firelog/legacy/batchlog", "AIzaSyCckkiH8i2ZARwOs1LEzFKld15aOG8ozKo");
    }

    public a(String s, String s1) {
        this.a = s;
        this.b = s1;
    }

    public static a a(byte[] arr_b) {
        String s = new String(arr_b, Charset.forName("UTF-8"));
        if(!s.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] arr_s = s.substring(2).split("\\Q\\\\E", 2);
        if(arr_s.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String s1 = arr_s[0];
        if(s1.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String s2 = arr_s[1];
        if(s2.isEmpty()) {
            s2 = null;
        }
        return new a(s1, s2);
    }
}

