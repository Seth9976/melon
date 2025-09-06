package kf;

import e3.h;
import java.util.LinkedHashMap;
import pe.b;

public enum a {
    UNKNOWN(0),
    CLASS(1),
    FILE_FACADE(2),
    SYNTHETIC_CLASS(3),
    MULTIFILE_CLASS(4),
    MULTIFILE_CLASS_PART(5);

    public final int a;
    public static final h b;
    public static final LinkedHashMap c;
    public static final a[] j;

    static {
        int v1;
        a.j = arr_a;
        new b(arr_a);
        a.b = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        a[] arr_a1 = (a[])a.j.clone();
        if(arr_a1.length < 0) {
            v1 = arr_a1.length;
        }
        else if(arr_a1.length < 3) {
            v1 = arr_a1.length + 1;
        }
        else {
            v1 = arr_a1.length >= 0x40000000 ? 0x7FFFFFFF : ((int)(((float)arr_a1.length) / 0.75f + 1.0f));
        }
        LinkedHashMap linkedHashMap0 = new LinkedHashMap((v1 >= 16 ? v1 : 16));
        for(int v = 0; v < arr_a1.length; ++v) {
            a a0 = arr_a1[v];
            linkedHashMap0.put(a0.a, a0);
        }
        a.c = linkedHashMap0;
    }

    public a(int v1) {
        this.a = v1;
    }
}

