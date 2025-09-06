package i.n.i.b.a.s.e;

import android.content.Context;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.view.accessibility.CaptioningManager;
import java.util.ArrayList;
import java.util.Locale;

public class mi implements Parcelable {
    public static class b {
        public h9 a;
        public int b;
        public h9 c;
        public int d;
        public boolean e;
        public int f;

        public b() {
            this.a = c5.e;
            this.b = 0;
            this.c = c5.e;
            this.d = 0;
            this.e = false;
            this.f = 0;
        }

        public b(Context context0) {
            int v = L7.a;
            if(v >= 19 && (v >= 23 || Looper.myLooper() != null)) {
                CaptioningManager captioningManager0 = (CaptioningManager)context0.getSystemService("captioning");
                if(captioningManager0 != null && captioningManager0.isEnabled()) {
                    this.d = 0x440;
                    Locale locale0 = captioningManager0.getLocale();
                    if(locale0 != null) {
                        this.c = h9.l((v < 21 ? locale0.toString() : locale0.toLanguageTag()));
                    }
                }
            }
        }
    }

    public static final Parcelable.Creator CREATOR;
    public final h9 a;
    public final int b;
    public final h9 c;
    public final int d;
    public final boolean e;
    public final int f;

    static {
        new b();
        mi.CREATOR = new t(19);
    }

    public mi(Parcel parcel0) {
        ArrayList arrayList0 = new ArrayList();
        parcel0.readList(arrayList0, null);
        this.a = h9.q(arrayList0);
        this.b = parcel0.readInt();
        ArrayList arrayList1 = new ArrayList();
        parcel0.readList(arrayList1, null);
        this.c = h9.q(arrayList1);
        this.d = parcel0.readInt();
        this.e = parcel0.readInt() != 0;
        this.f = parcel0.readInt();
    }

    public mi(h9 h90, int v, h9 h91, int v1, boolean z, int v2) {
        this.a = h90;
        this.b = v;
        this.c = h91;
        this.d = v1;
        this.e = z;
        this.f = v2;
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(Object object0) {
        return this == object0 ? true : object0 != null && this.getClass() == object0.getClass() && this.a.equals(((mi)object0).a) && this.b == ((mi)object0).b && this.c.equals(((mi)object0).c) && this.d == ((mi)object0).d && this.e == ((mi)object0).e && this.f == ((mi)object0).f;
    }

    @Override
    public int hashCode() {
        return (((this.c.hashCode() + ((this.a.hashCode() + 0x1F) * 0x1F + this.b) * 0x1F) * 0x1F + this.d) * 0x1F + this.e) * 0x1F + this.f;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeList(this.a);
        parcel0.writeInt(this.b);
        parcel0.writeList(this.c);
        parcel0.writeInt(this.d);
        parcel0.writeInt(((int)this.e));
        parcel0.writeInt(this.f);
    }
}

