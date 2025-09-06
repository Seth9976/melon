package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import androidx.appcompat.app.o;
import java.util.List;
import java.util.Map;

public final class m9 implements b {
    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final int f;

    static {
        m9.CREATOR = new t(18);
    }

    public m9(int v, String s, String s1, String s2, boolean z, int v1) {
        M7.u(v1 == -1 || v1 > 0);
        this.a = v;
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = z;
        this.f = v1;
    }

    public m9(Parcel parcel0) {
        this.a = parcel0.readInt();
        this.b = parcel0.readString();
        this.c = parcel0.readString();
        this.d = parcel0.readString();
        this.e = parcel0.readInt() != 0;
        this.f = parcel0.readInt();
    }

    public static m9 a(Map map0) {
        int v3;
        boolean z1;
        String s3;
        String s2;
        String s1;
        int v2;
        boolean z;
        int v1;
        List list0 = (List)map0.get("icy-br");
        int v = -1;
        if(list0 == null) {
        label_15:
            z = false;
            v2 = -1;
        }
        else {
            String s = (String)list0.get(0);
            try {
                v1 = -1;
                v1 = Integer.parseInt(s) * 1000;
                if(v1 <= 0) {
                    Log.w("IcyHeaders", "Invalid bitrate: " + s);
                    goto label_15;
                }
                else {
                    z = true;
                    goto label_13;
                }
                goto label_17;
            }
            catch(NumberFormatException unused_ex) {
                o.A("Invalid bitrate header: ", s, "IcyHeaders");
                z = false;
            }
        label_13:
            v2 = v1;
        }
    label_17:
        List list1 = (List)map0.get("icy-genre");
        if(list1 == null) {
            s1 = null;
        }
        else {
            s1 = (String)list1.get(0);
            z = true;
        }
        List list2 = (List)map0.get("icy-name");
        if(list2 == null) {
            s2 = null;
        }
        else {
            s2 = (String)list2.get(0);
            z = true;
        }
        List list3 = (List)map0.get("icy-url");
        if(list3 == null) {
            s3 = null;
        }
        else {
            s3 = (String)list3.get(0);
            z = true;
        }
        List list4 = (List)map0.get("icy-pub");
        if(list4 == null) {
            z1 = false;
        }
        else {
            z1 = ((String)list4.get(0)).equals("1");
            z = true;
        }
        List list5 = (List)map0.get("icy-metaint");
        if(list5 != null) {
            String s4 = (String)list5.get(0);
            try {
                v3 = Integer.parseInt(s4);
                if(v3 > 0) {
                    return new m9(v2, s1, s2, s3, z1, v3);
                }
                goto label_47;
            }
            catch(NumberFormatException unused_ex) {
                o.A("Invalid metadata interval: ", s4, "IcyHeaders");
                return z ? new m9(v2, s1, s2, s3, z1, v) : null;
            }
            return new m9(v2, s1, s2, s3, z1, v3);
            try {
            label_47:
                Log.w("IcyHeaders", "Invalid metadata interval: " + s4);
                return z ? new m9(v2, s1, s2, s3, z1, -1) : null;
            }
            catch(NumberFormatException unused_ex) {
                v = v3;
            }
            o.A("Invalid metadata interval: ", s4, "IcyHeaders");
            return z ? new m9(v2, s1, s2, s3, z1, v) : null;
        }
        return z ? new m9(v2, s1, s2, s3, z1, -1) : null;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return m9.class == class0 && this.a == ((m9)object0).a && L7.p(this.b, ((m9)object0).b) && L7.p(this.c, ((m9)object0).c) && L7.p(this.d, ((m9)object0).d) && this.e == ((m9)object0).e && this.f == ((m9)object0).f;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = (this.a + 0x20F) * 0x1F;
        int v1 = 0;
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        String s = this.d;
        if(s != null) {
            v1 = s.hashCode();
        }
        return ((((v + v2) * 0x1F + v3) * 0x1F + v1) * 0x1F + this.e) * 0x1F + this.f;
    }

    @Override
    public final String toString() {
        return "IcyHeaders: name=\"" + this.c + "\", genre=\"" + this.b + "\", bitrate=" + this.a + ", metadataInterval=" + this.f;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.c);
        parcel0.writeString(this.d);
        parcel0.writeInt(((int)this.e));
        parcel0.writeInt(this.f);
    }
}

