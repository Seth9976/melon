package N5;

public final class a {
    public final Integer a;
    public final Object b;
    public final d c;
    public final b d;

    public a(Integer integer0, Object object0, d d0, b b0) {
        this.a = integer0;
        if(object0 == null) {
            throw new NullPointerException("Null payload");
        }
        this.b = object0;
        this.c = d0;
        this.d = b0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof a) {
            Integer integer0 = this.a;
            if(integer0 != null) {
                if(integer0.equals(((a)object0).a)) {
                label_8:
                    b b0 = ((a)object0).d;
                    if(this.b.equals(((a)object0).b) && this.c.equals(((a)object0).c)) {
                        return this.d == null ? b0 == null : this.d.equals(b0);
                    }
                }
            }
            else if(((a)object0).a == null) {
                goto label_8;
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b.hashCode();
        int v3 = this.c.hashCode();
        b b0 = this.d;
        if(b0 != null) {
            v = b0.hashCode();
        }
        return (v ^ (((v1 ^ 1000003) * 1000003 ^ v2) * 1000003 ^ v3) * 1000003) * 1000003;
    }

    @Override
    public final String toString() {
        return "Event{code=" + this.a + ", payload=" + this.b + ", priority=" + this.c + ", productData=" + this.d + ", eventContext=null}";
    }
}

