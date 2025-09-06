package v9;

import U4.x;

public final class i {
    public final String a;
    public static final i b;
    public static final i c;

    static {
        i.b = new i("Default");
        i.c = new i("LoadMore");
    }

    public i(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == null) {
            return false;
        }
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof i)) {
            return false;
        }
        String s = ((i)object0).a;
        return s != null && s.equals(this.a);
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0x20F : this.a.hashCode() + 0x20F;
    }

    @Override
    public final String toString() {
        return x.m(new StringBuilder("FetchType {"), this.a, "}");
    }
}

