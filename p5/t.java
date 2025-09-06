package P5;

import java.util.ArrayList;

public final class t extends F {
    public final long a;
    public final long b;
    public final n c;
    public final Integer d;
    public final String e;
    public final ArrayList f;

    public t(long v, long v1, n n0, Integer integer0, String s, ArrayList arrayList0) {
        this.a = v;
        this.b = v1;
        this.c = n0;
        this.d = integer0;
        this.e = s;
        this.f = arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != this) {
            if(object0 instanceof F && this.a == ((t)(((F)object0))).a) {
                ((t)(((F)object0))).getClass();
                J j0 = J.a;
                ArrayList arrayList0 = ((t)(((F)object0))).f;
                String s = ((t)(((F)object0))).e;
                Integer integer0 = ((t)(((F)object0))).d;
                if(this.b == ((t)(((F)object0))).b && this.c.equals(((t)(((F)object0))).c)) {
                    Integer integer1 = this.d;
                    if(integer1 != null) {
                        if(integer1.equals(integer0)) {
                        label_13:
                            String s1 = this.e;
                            if(s1 == null) {
                                return s == null ? this.f.equals(arrayList0) && j0.equals(j0) : false;
                            }
                            return s1.equals(s) ? this.f.equals(arrayList0) && j0.equals(j0) : false;
                        }
                    }
                    else if(integer0 == null) {
                        goto label_13;
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        int v = (((((int)(this.a ^ this.a >>> 0x20)) ^ 1000003) * 1000003 ^ ((int)(this.b >>> 0x20 ^ this.b))) * 1000003 ^ this.c.hashCode()) * 1000003;
        int v1 = 0;
        int v2 = this.d == null ? 0 : this.d.hashCode();
        String s = this.e;
        if(s != null) {
            v1 = s.hashCode();
        }
        return (((v ^ v2) * 1000003 ^ v1) * 1000003 ^ this.f.hashCode()) * 1000003 ^ J.a.hashCode();
    }

    @Override
    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.a + ", requestUptimeMs=" + this.b + ", clientInfo=" + this.c + ", logSource=" + this.d + ", logSourceName=" + this.e + ", logEvents=" + this.f + ", qosTier=" + J.a + "}";
    }
}

