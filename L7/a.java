package l7;

import i3.d;

public final class a {
    public final c a;
    public static final i7.a b;
    public static final String c;
    public static final String d;
    public static final d e;

    static {
        a.b = new i7.a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a.c = "https://crashlyticsreports-pa.googleapis.com/v1/firelog/legacy/batchlog";
        a.d = "AIzaSyBrpSYT4FFL09reHJi6H9FYdeiSnUTOv2M";
        a.e = new d(17);
    }

    public a(c c0) {
        this.a = c0;
    }

    public static String a(String s, String s1) {
        int v = s.length() - s1.length();
        if(v < 0 || v > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder stringBuilder0 = new StringBuilder(s1.length() + s.length());
        for(int v1 = 0; v1 < s.length(); ++v1) {
            stringBuilder0.append(s.charAt(v1));
            if(s1.length() > v1) {
                stringBuilder0.append(s1.charAt(v1));
            }
        }
        return stringBuilder0.toString();
    }
}

