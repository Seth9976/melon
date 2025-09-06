package i.n.i.b.a.s.e;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class wa implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final Uri b;
    public final String c;
    public final List d;
    public final byte[] e;
    public final String f;
    public final byte[] g;

    static {
        wa.CREATOR = new Tc(1);
    }

    public wa(Parcel parcel0) {
        this.a = parcel0.readString();
        this.b = Uri.parse(parcel0.readString());
        this.c = parcel0.readString();
        int v = parcel0.readInt();
        ArrayList arrayList0 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            arrayList0.add(((fb)parcel0.readParcelable(fb.class.getClassLoader())));
        }
        this.d = Collections.unmodifiableList(arrayList0);
        this.e = parcel0.createByteArray();
        this.f = parcel0.readString();
        this.g = parcel0.createByteArray();
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    // 去混淆评级： 中等(80)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof wa ? this.a.equals(((wa)object0).a) && this.b.equals(((wa)object0).b) && L7.p(this.c, ((wa)object0).c) && this.d.equals(((wa)object0).d) && Arrays.equals(this.e, ((wa)object0).e) && L7.p(this.f, ((wa)object0).f) && Arrays.equals(this.g, ((wa)object0).g) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        int v1 = this.b.hashCode();
        int v2 = 0;
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d.hashCode();
        int v5 = Arrays.hashCode(this.e);
        String s = this.f;
        if(s != null) {
            v2 = s.hashCode();
        }
        return Arrays.hashCode(this.g) + ((v5 + (v4 + ((v1 + v * 961) * 0x1F + v3) * 0x1F) * 0x1F) * 0x1F + v2) * 0x1F;
    }

    @Override
    public final String toString() {
        return this.c + ":" + this.a;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b.toString());
        parcel0.writeString(this.c);
        List list0 = this.d;
        parcel0.writeInt(list0.size());
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            parcel0.writeParcelable(((Parcelable)list0.get(v1)), 0);
        }
        parcel0.writeByteArray(this.e);
        parcel0.writeString(this.f);
        parcel0.writeByteArray(this.g);
    }
}

