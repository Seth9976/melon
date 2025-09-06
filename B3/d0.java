package b3;

public final class d0 {
    public final Object a;
    public final long b;
    public final b c;
    public final boolean d;

    public d0(c0 c00) {
        this.a = c00.a;
        this.b = c00.b;
        this.c = c00.c;
        this.d = c00.d;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof d0 ? this.a.equals(((d0)object0).a) && this.b == ((d0)object0).b && this.c.equals(((d0)object0).c) && this.d == ((d0)object0).d : false;
    }

    @Override
    public final int hashCode() {
        return (this.c.hashCode() + ((this.a.hashCode() + 0xD9) * 0x1F + ((int)(this.b ^ this.b >>> 0x20))) * 0x1F) * 0x1F + this.d;
    }
}

