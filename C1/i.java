package C1;

import java.util.HashMap;

public enum i {
    SPREAD,
    SPREAD_INSIDE,
    PACKED;

    public static final HashMap d;

    static {
        HashMap hashMap0 = new HashMap();
        HashMap hashMap1 = new HashMap();
        i.d = hashMap1;
        hashMap0.put("packed", i.c);
        hashMap0.put("spread_inside", i.b);
        hashMap0.put("spread", i.a);
        hashMap1.put("packed", 2);
        hashMap1.put("spread_inside", 1);
        hashMap1.put("spread", 0);
    }

    // 去混淆评级： 低(20)
    public static int a(String s) {
        return i.d.containsKey(s) ? ((int)(((Integer)i.d.get(s)))) : -1;
    }
}

