package g3;

import U4.x;
import android.net.Uri;
import b3.F;
import e3.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class j {
    public final Uri a;
    public final int b;
    public final byte[] c;
    public final Map d;
    public final long e;
    public final long f;
    public final String g;
    public final int h;
    public static final int i;

    static {
        F.a("media3.datasource");
    }

    public j(Uri uri0, int v, byte[] arr_b, Map map0, long v1, long v2, String s, int v3) {
        boolean z = false;
        b.c(Long.compare(v1, 0L) >= 0);
        b.c(v1 >= 0L);
        if(v2 > 0L || v2 == -1L) {
            z = true;
        }
        b.c(z);
        uri0.getClass();
        this.a = uri0;
        this.b = v;
        if(arr_b == null || arr_b.length == 0) {
            arr_b = null;
        }
        this.c = arr_b;
        this.d = Collections.unmodifiableMap(new HashMap(map0));
        this.e = v1;
        this.f = v2;
        this.g = s;
        this.h = v3;
    }

    public final i a() {
        i i0 = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
        i0.e = this.a;
        i0.a = this.b;
        i0.f = this.c;
        i0.g = this.d;
        i0.b = this.e;
        i0.d = this.f;
        i0.h = this.g;
        i0.c = this.h;
        return i0;
    }

    @Override
    public final String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder("DataSpec[");
        switch(this.b) {
            case 1: {
                s = "GET";
                break;
            }
            case 2: {
                s = "POST";
                break;
            }
            case 3: {
                s = "HEAD";
                break;
            }
            default: {
                throw new IllegalStateException();
            }
        }
        stringBuilder0.append(s);
        stringBuilder0.append(" ");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", ");
        return x.g(this.h, "]", stringBuilder0);
    }
}

