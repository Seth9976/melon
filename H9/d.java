package h9;

import U4.x;
import android.net.Uri;
import java.io.Serializable;
import java.util.Map;

public final class d {
    public final int a;
    public long b;
    public long c;
    public final Serializable d;
    public Comparable e;
    public Comparable f;
    public Object g;

    public d() {
        this.a = 0;
        super();
        this.d = new StringBuilder(0x1000);
    }

    public d(byte[] arr_b, Uri uri0, Uri uri1, Map map0, long v, long v1) {
        this.a = 1;
        super();
        this.d = arr_b;
        this.e = uri0;
        this.f = uri1;
        this.g = map0;
        this.b = v;
        this.c = v1;
    }

    public int a() {
        return (this.b + "," + ((String)this.e) + "," + ((String)this.f)).hashCode();
    }

    @Override
    public String toString() {
        if(this.a != 0) {
            return super.toString();
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClientHttpHeader [");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", 0, ");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", ");
        stringBuilder0.append(((String)this.e));
        stringBuilder0.append(", ");
        stringBuilder0.append(((String)this.f));
        stringBuilder0.append(", ");
        return x.m(stringBuilder0, ((String)this.g), "]");
    }
}

