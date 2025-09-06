package e7;

import U4.x;

public final class b {
    public final String a;
    public final String b;
    public final String c;

    public b(String s, String s1, String s2) {
        if(s == null) {
            throw new NullPointerException("Null crashlyticsInstallId");
        }
        this.a = s;
        this.b = s1;
        this.c = s2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof b) {
            String s = ((b)object0).c;
            String s1 = ((b)object0).b;
            if(this.a.equals(((b)object0).a)) {
                String s2 = this.b;
                if(s2 == null) {
                    if(s1 == null) {
                        return this.c == null ? s == null : this.c.equals(s);
                    }
                }
                else if(s2.equals(s1)) {
                    return this.c == null ? s == null : this.c.equals(s);
                }
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        int v1 = 0;
        int v2 = this.b == null ? 0 : this.b.hashCode();
        String s = this.c;
        if(s != null) {
            v1 = s.hashCode();
        }
        return ((v ^ 1000003) * 1000003 ^ v2) * 1000003 ^ v1;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("InstallIds{crashlyticsInstallId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", firebaseInstallationId=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", firebaseAuthenticationToken=");
        return x.m(stringBuilder0, this.c, "}");
    }
}

