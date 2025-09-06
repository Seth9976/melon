package P5;

import java.util.Arrays;

public final class s extends E {
    public final long a;
    public final Integer b;
    public final A c;
    public final long d;
    public final byte[] e;
    public final String f;
    public final long g;
    public final I h;
    public final B i;

    public s(long v, Integer integer0, A a0, long v1, byte[] arr_b, String s, long v2, I i0, B b0) {
        this.a = v;
        this.b = integer0;
        this.c = a0;
        this.d = v1;
        this.e = arr_b;
        this.f = s;
        this.g = v2;
        this.h = i0;
        this.i = b0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof E && this.a == ((s)(((E)object0))).a) {
            Integer integer0 = this.b;
            if(integer0 != null) {
                if(integer0.equals(((s)(((E)object0))).b)) {
                label_8:
                    A a0 = this.c;
                    if(a0 != null) {
                        if(a0.equals(((s)(((E)object0))).c)) {
                        label_13:
                            B b0 = ((s)(((E)object0))).i;
                            I i0 = ((s)(((E)object0))).h;
                            String s = ((s)(((E)object0))).f;
                            if(this.d == ((s)(((E)object0))).d && Arrays.equals(this.e, (((E)object0) instanceof s ? ((s)(((E)object0))).e : ((s)(((E)object0))).e))) {
                                String s1 = this.f;
                                if(s1 != null) {
                                    if(s1.equals(s)) {
                                    label_22:
                                        if(this.g == ((s)(((E)object0))).g) {
                                            I i1 = this.h;
                                            if(i1 == null) {
                                                if(i0 == null) {
                                                    return this.i == null ? b0 == null : this.i.equals(b0);
                                                }
                                            }
                                            else if(i1.equals(i0)) {
                                                return this.i == null ? b0 == null : this.i.equals(b0);
                                            }
                                        }
                                    }
                                }
                                else if(s == null) {
                                    goto label_22;
                                }
                            }
                        }
                    }
                    else if(((s)(((E)object0))).c == null) {
                        goto label_13;
                    }
                }
            }
            else if(((s)(((E)object0))).b == null) {
                goto label_8;
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = Arrays.hashCode(this.e);
        int v2 = (((((((((int)(this.a ^ this.a >>> 0x20)) ^ 1000003) * 1000003 ^ (this.b == null ? 0 : this.b.hashCode())) * 1000003 ^ (this.c == null ? 0 : this.c.hashCode())) * 1000003 ^ ((int)(this.d ^ this.d >>> 0x20))) * 1000003 ^ v1) * 1000003 ^ (this.f == null ? 0 : this.f.hashCode())) * 1000003 ^ ((int)(this.g ^ this.g >>> 0x20))) * 1000003;
        int v3 = this.h == null ? 0 : this.h.hashCode();
        B b0 = this.i;
        if(b0 != null) {
            v = b0.hashCode();
        }
        return (v2 ^ v3) * 1000003 ^ v;
    }

    @Override
    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.a + ", eventCode=" + this.b + ", complianceData=" + this.c + ", eventUptimeMs=" + this.d + ", sourceExtension=" + Arrays.toString(this.e) + ", sourceExtensionJsonProto3=" + this.f + ", timezoneOffsetSeconds=" + this.g + ", networkConnectionInfo=" + this.h + ", experimentIds=" + this.i + "}";
    }
}

