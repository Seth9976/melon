package Q5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class i {
    public final String a;
    public final Integer b;
    public final n c;
    public final long d;
    public final long e;
    public final Map f;
    public final Integer g;
    public final String h;
    public final byte[] i;
    public final byte[] j;

    public i(String s, Integer integer0, n n0, long v, long v1, HashMap hashMap0, Integer integer1, String s1, byte[] arr_b, byte[] arr_b1) {
        this.a = s;
        this.b = integer0;
        this.c = n0;
        this.d = v;
        this.e = v1;
        this.f = hashMap0;
        this.g = integer1;
        this.h = s1;
        this.i = arr_b;
        this.j = arr_b1;
    }

    public final String a(String s) {
        String s1 = (String)this.f.get(s);
        return s1 == null ? "" : s1;
    }

    public final int b(String s) {
        String s1 = (String)this.f.get(s);
        return s1 == null ? 0 : ((int)Integer.valueOf(s1));
    }

    public final h c() {
        h h0 = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        String s = this.a;
        if(s == null) {
            throw new NullPointerException("Null transportName");
        }
        h0.a = s;
        h0.c = this.b;
        h0.d = this.g;
        h0.b = this.h;
        h0.i = this.i;
        h0.j = this.j;
        n n0 = this.c;
        if(n0 == null) {
            throw new NullPointerException("Null encodedPayload");
        }
        h0.e = n0;
        h0.f = this.d;
        h0.g = this.e;
        h0.h = new HashMap(this.f);
        return h0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof i && this.a.equals(((i)object0).a)) {
            Integer integer0 = this.b;
            if(integer0 != null) {
                if(integer0.equals(((i)object0).b)) {
                label_8:
                    String s = ((i)object0).h;
                    Integer integer1 = ((i)object0).g;
                    if(this.c.equals(((i)object0).c) && this.d == ((i)object0).d && this.e == ((i)object0).e && this.f.equals(((i)object0).f)) {
                        Integer integer2 = this.g;
                        if(integer2 != null) {
                            if(integer2.equals(integer1)) {
                            label_16:
                                String s1 = this.h;
                                if(s1 == null) {
                                    if(s == null) {
                                        return Arrays.equals(this.i, (((i)object0) instanceof i ? ((i)object0).i : ((i)object0).i)) ? Arrays.equals(this.j, (((i)object0) instanceof i ? ((i)object0).j : ((i)object0).j)) : false;
                                    }
                                }
                                else if(s1.equals(s)) {
                                    return Arrays.equals(this.i, (((i)object0) instanceof i ? ((i)object0).i : ((i)object0).i)) ? Arrays.equals(this.j, (((i)object0) instanceof i ? ((i)object0).j : ((i)object0).j)) : false;
                                }
                            }
                        }
                        else if(integer1 == null) {
                            goto label_16;
                        }
                    }
                }
            }
            else if(((i)object0).b == null) {
                goto label_8;
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = ((((((this.a.hashCode() ^ 1000003) * 1000003 ^ (this.b == null ? 0 : this.b.hashCode())) * 1000003 ^ this.c.hashCode()) * 1000003 ^ ((int)(this.d ^ this.d >>> 0x20))) * 1000003 ^ ((int)(this.e ^ this.e >>> 0x20))) * 1000003 ^ this.f.hashCode()) * 1000003;
        int v2 = this.g == null ? 0 : this.g.hashCode();
        String s = this.h;
        if(s != null) {
            v = s.hashCode();
        }
        return (((v1 ^ v2) * 1000003 ^ v) * 1000003 ^ Arrays.hashCode(this.i)) * 1000003 ^ Arrays.hashCode(this.j);
    }

    @Override
    public final String toString() {
        return "EventInternal{transportName=" + this.a + ", code=" + this.b + ", encodedPayload=" + this.c + ", eventMillis=" + this.d + ", uptimeMillis=" + this.e + ", autoMetadata=" + this.f + ", productId=" + this.g + ", pseudonymousId=" + this.h + ", experimentIdsClear=" + Arrays.toString(this.i) + ", experimentIdsEncrypted=" + Arrays.toString(this.j) + "}";
    }
}

