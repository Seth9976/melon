package h7;

import U4.x;
import android.os.Build;

public final class n0 {
    public final int a;
    public final int b;
    public final long c;
    public final long d;
    public final boolean e;
    public final int f;

    public n0(int v, int v1, long v2, long v3, boolean z, int v4) {
        String s = Build.MODEL;
        String s1 = Build.MANUFACTURER;
        String s2 = Build.PRODUCT;
        super();
        this.a = v;
        if(s == null) {
            throw new NullPointerException("Null model");
        }
        this.b = v1;
        this.c = v2;
        this.d = v3;
        this.e = z;
        this.f = v4;
        if(s1 == null) {
            throw new NullPointerException("Null manufacturer");
        }
        if(s2 == null) {
            throw new NullPointerException("Null modelClass");
        }
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this || object0 instanceof n0 && this.a == ((n0)object0).a && Build.MODEL.equals(Build.MODEL) && this.b == ((n0)object0).b && this.c == ((n0)object0).c && this.d == ((n0)object0).d && this.e == ((n0)object0).e && this.f == ((n0)object0).f && Build.MANUFACTURER.equals(Build.MANUFACTURER) && Build.PRODUCT.equals(Build.PRODUCT);
    }

    @Override
    public final int hashCode() {
        int v = (((((this.a ^ 1000003) * 1000003 ^ Build.MODEL.hashCode()) * 1000003 ^ this.b) * 1000003 ^ ((int)(this.c ^ this.c >>> 0x20))) * 1000003 ^ ((int)(this.d ^ this.d >>> 0x20))) * 1000003;
        return this.e ? (((v ^ 0x4CF) * 1000003 ^ this.f) * 1000003 ^ Build.MANUFACTURER.hashCode()) * 1000003 ^ Build.PRODUCT.hashCode() : (((v ^ 0x4D5) * 1000003 ^ this.f) * 1000003 ^ Build.MANUFACTURER.hashCode()) * 1000003 ^ Build.PRODUCT.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DeviceData{arch=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", model=");
        stringBuilder0.append(Build.MODEL);
        stringBuilder0.append(", availableProcessors=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", totalRam=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", diskSpace=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", isEmulator=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", state=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", manufacturer=");
        stringBuilder0.append(Build.MANUFACTURER);
        stringBuilder0.append(", modelClass=");
        return x.m(stringBuilder0, Build.PRODUCT, "}");
    }
}

