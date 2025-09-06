package i.n.i.b.a.s.e;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class z9 extends v9 {
    public static final Parcelable.Creator CREATOR;
    public final String b;
    public final String c;

    static {
        z9.CREATOR = new Tc(6);
    }

    public z9(Parcel parcel0) {
        super(parcel0.readString());
        this.b = parcel0.readString();
        this.c = parcel0.readString();
    }

    public z9(String s, String s1, String s2) {
        super(s);
        this.b = s1;
        this.c = s2;
    }

    @Override  // i.n.i.b.a.s.e.x8$b
    public final void V(L l0) {
        this.a.getClass();
        int v = -1;
        switch(this.a) {
            case "TAL": {
                v = 0;
                break;
            }
            case "TALB": {
                v = 4;
                break;
            }
            case "TIT2": {
                v = 5;
                break;
            }
            case "TP1": {
                v = 1;
                break;
            }
            case "TP2": {
                v = 2;
                break;
            }
            case "TPE1": {
                v = 6;
                break;
            }
            case "TPE2": {
                v = 7;
                break;
            }
            case "TT2": {
                v = 3;
            }
        }
        String s = this.c;
        switch(v) {
            case 0: 
            case 4: {
                l0.c = s;
                return;
            }
            case 3: 
            case 5: {
                l0.a = s;
                return;
            }
            case 1: 
            case 6: {
                l0.b = s;
                return;
            }
            case 2: 
            case 7: {
                l0.d = s;
            }
        }
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return z9.class == class0 && L7.p(this.a, ((z9)object0).a) && L7.p(this.b, ((z9)object0).b) && L7.p(this.c, ((z9)object0).c);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(0x20F, 0x1F, this.a);
        int v1 = 0;
        int v2 = this.b == null ? 0 : this.b.hashCode();
        String s = this.c;
        if(s != null) {
            v1 = s.hashCode();
        }
        return (v + v2) * 0x1F + v1;
    }

    @Override  // i.n.i.b.a.s.e.v9
    public final String toString() {
        return this.a + ": description=" + this.b + ": value=" + this.c;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.c);
    }
}

