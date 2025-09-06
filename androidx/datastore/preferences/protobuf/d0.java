package androidx.datastore.preferences.protobuf;

public final class d0 {
    public final a a;
    public final String b;
    public final Object[] c;
    public final int d;

    public d0(A a0, String s, Object[] arr_object) {
        this.a = a0;
        this.b = s;
        this.c = arr_object;
        int v = s.charAt(0);
        if(v < 0xD800) {
            this.d = v;
            return;
        }
        int v1 = v & 0x1FFF;
        int v2 = 13;
        int v4;
        for(int v3 = 1; (v4 = s.charAt(v3)) >= 0xD800; ++v3) {
            v1 |= (v4 & 0x1FFF) << v2;
            v2 += 13;
        }
        this.d = v1 | v4 << v2;
    }

    public final int a() {
        int v = this.d;
        if((v & 1) != 0) {
            return 1;
        }
        return (v & 4) == 4 ? 3 : 2;
    }
}

