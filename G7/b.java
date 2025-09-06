package g7;

import U4.x;

public final class b extends o {
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final long f;

    public b(long v, String s, String s1, String s2, String s3) {
        if(s == null) {
            throw new NullPointerException("Null rolloutId");
        }
        this.b = s;
        if(s1 == null) {
            throw new NullPointerException("Null parameterKey");
        }
        this.c = s1;
        if(s2 == null) {
            throw new NullPointerException("Null parameterValue");
        }
        this.d = s2;
        if(s3 == null) {
            throw new NullPointerException("Null variantId");
        }
        this.e = s3;
        this.f = v;
    }

    // 去混淆评级： 中等(60)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this ? true : object0 instanceof o && this.b.equals(((b)(((o)object0))).b) && this.c.equals(((b)(((o)object0))).c) && this.d.equals(((b)(((o)object0))).d) && this.e.equals(((b)(((o)object0))).e) && this.f == ((b)(((o)object0))).f;
    }

    @Override
    public final int hashCode() {
        return ((((this.b.hashCode() ^ 1000003) * 1000003 ^ this.c.hashCode()) * 1000003 ^ this.d.hashCode()) * 1000003 ^ this.e.hashCode()) * 1000003 ^ ((int)(this.f >>> 0x20 ^ this.f));
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("RolloutAssignment{rolloutId=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", parameterKey=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", parameterValue=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", variantId=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", templateVersion=");
        return x.h(this.f, "}", stringBuilder0);
    }
}

