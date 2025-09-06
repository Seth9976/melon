package P5;

import U4.x;

public final class l extends a {
    public final Integer a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;

    public l(Integer integer0, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10) {
        this.a = integer0;
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = s3;
        this.f = s4;
        this.g = s5;
        this.h = s6;
        this.i = s7;
        this.j = s8;
        this.k = s9;
        this.l = s10;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof a) {
            a a0 = (a)object0;
            Integer integer0 = this.a;
            if(integer0 != null) {
                if(integer0.equals(((l)a0).a)) {
                label_9:
                    String s = this.b;
                    if(s != null) {
                        if(s.equals(((l)a0).b)) {
                        label_14:
                            String s1 = this.c;
                            if(s1 != null) {
                                if(s1.equals(((l)a0).c)) {
                                label_19:
                                    String s2 = this.d;
                                    if(s2 != null) {
                                        if(s2.equals(((l)a0).d)) {
                                        label_24:
                                            String s3 = this.e;
                                            if(s3 != null) {
                                                if(s3.equals(((l)a0).e)) {
                                                label_29:
                                                    String s4 = this.f;
                                                    if(s4 != null) {
                                                        if(s4.equals(((l)a0).f)) {
                                                        label_34:
                                                            String s5 = this.g;
                                                            if(s5 != null) {
                                                                if(s5.equals(((l)a0).g)) {
                                                                label_39:
                                                                    String s6 = this.h;
                                                                    if(s6 != null) {
                                                                        if(s6.equals(((l)a0).h)) {
                                                                        label_44:
                                                                            String s7 = this.i;
                                                                            if(s7 != null) {
                                                                                if(s7.equals(((l)a0).i)) {
                                                                                label_49:
                                                                                    String s8 = this.j;
                                                                                    if(s8 != null) {
                                                                                        if(s8.equals(((l)a0).j)) {
                                                                                        label_54:
                                                                                            String s9 = this.k;
                                                                                            if(s9 == null) {
                                                                                                if(((l)a0).k == null) {
                                                                                                    return this.l == null ? ((l)a0).l == null : this.l.equals(((l)a0).l);
                                                                                                }
                                                                                            }
                                                                                            else if(s9.equals(((l)a0).k)) {
                                                                                                return this.l == null ? ((l)a0).l == null : this.l.equals(((l)a0).l);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    else if(((l)a0).j == null) {
                                                                                        goto label_54;
                                                                                    }
                                                                                }
                                                                            }
                                                                            else if(((l)a0).i == null) {
                                                                                goto label_49;
                                                                            }
                                                                        }
                                                                    }
                                                                    else if(((l)a0).h == null) {
                                                                        goto label_44;
                                                                    }
                                                                }
                                                            }
                                                            else if(((l)a0).g == null) {
                                                                goto label_39;
                                                            }
                                                        }
                                                    }
                                                    else if(((l)a0).f == null) {
                                                        goto label_34;
                                                    }
                                                }
                                            }
                                            else if(((l)a0).e == null) {
                                                goto label_29;
                                            }
                                        }
                                    }
                                    else if(((l)a0).d == null) {
                                        goto label_24;
                                    }
                                }
                            }
                            else if(((l)a0).c == null) {
                                goto label_19;
                            }
                        }
                    }
                    else if(((l)a0).b == null) {
                        goto label_14;
                    }
                }
            }
            else if(((l)a0).a == null) {
                goto label_9;
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d == null ? 0 : this.d.hashCode();
        int v5 = this.e == null ? 0 : this.e.hashCode();
        int v6 = this.f == null ? 0 : this.f.hashCode();
        int v7 = this.g == null ? 0 : this.g.hashCode();
        int v8 = this.h == null ? 0 : this.h.hashCode();
        int v9 = this.i == null ? 0 : this.i.hashCode();
        int v10 = this.j == null ? 0 : this.j.hashCode();
        int v11 = this.k == null ? 0 : this.k.hashCode();
        String s = this.l;
        if(s != null) {
            v = s.hashCode();
        }
        return v ^ (((((((((((v1 ^ 1000003) * 1000003 ^ v2) * 1000003 ^ v3) * 1000003 ^ v4) * 1000003 ^ v5) * 1000003 ^ v6) * 1000003 ^ v7) * 1000003 ^ v8) * 1000003 ^ v9) * 1000003 ^ v10) * 1000003 ^ v11) * 1000003;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("AndroidClientInfo{sdkVersion=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", model=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", hardware=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", device=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", product=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", osBuild=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", manufacturer=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", fingerprint=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", locale=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", country=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(", mccMnc=");
        stringBuilder0.append(this.k);
        stringBuilder0.append(", applicationBuild=");
        return x.m(stringBuilder0, this.l, "}");
    }
}

