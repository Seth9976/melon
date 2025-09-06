package Q7;

import kotlin.jvm.internal.q;

public final class g {
    public final Boolean a;
    public final Double b;
    public final Integer c;
    public final Integer d;
    public final Long e;

    public g(Boolean boolean0, Double double0, Integer integer0, Integer integer1, Long long0) {
        this.a = boolean0;
        this.b = double0;
        this.c = integer0;
        this.d = integer1;
        this.e = long0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof g)) {
            return false;
        }
        if(!q.b(this.a, ((g)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((g)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((g)object0).c)) {
            return false;
        }
        return q.b(this.d, ((g)object0).d) ? q.b(this.e, ((g)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d == null ? 0 : this.d.hashCode();
        Long long0 = this.e;
        if(long0 != null) {
            v = long0.hashCode();
        }
        return (((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v;
    }

    @Override
    public final String toString() {
        return "SessionConfigs(sessionEnabled=" + this.a + ", sessionSamplingRate=" + this.b + ", sessionRestartTimeout=" + this.c + ", cacheDuration=" + this.d + ", cacheUpdatedTime=" + this.e + ')';
    }
}

