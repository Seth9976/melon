package h7;

import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;

public final class m0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final DevelopmentPlatformProvider f;

    public m0(String s, String s1, String s2, String s3, int v, DevelopmentPlatformProvider developmentPlatformProvider0) {
        if(s == null) {
            throw new NullPointerException("Null appIdentifier");
        }
        this.a = s;
        if(s1 == null) {
            throw new NullPointerException("Null versionCode");
        }
        this.b = s1;
        if(s2 == null) {
            throw new NullPointerException("Null versionName");
        }
        this.c = s2;
        if(s3 == null) {
            throw new NullPointerException("Null installUuid");
        }
        this.d = s3;
        this.e = v;
        this.f = developmentPlatformProvider0;
    }

    // 去混淆评级： 中等(70)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this || object0 instanceof m0 && this.a.equals(((m0)object0).a) && this.b.equals(((m0)object0).b) && this.c.equals(((m0)object0).c) && this.d.equals(((m0)object0).d) && this.e == ((m0)object0).e && this.f.equals(((m0)object0).f);
    }

    @Override
    public final int hashCode() {
        return (((((this.a.hashCode() ^ 1000003) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode()) * 1000003 ^ this.d.hashCode()) * 1000003 ^ this.e) * 1000003 ^ this.f.hashCode();
    }

    @Override
    public final String toString() {
        return "AppData{appIdentifier=" + this.a + ", versionCode=" + this.b + ", versionName=" + this.c + ", installUuid=" + this.d + ", deliveryMechanism=" + this.e + ", developmentPlatformProvider=" + this.f + "}";
    }
}

