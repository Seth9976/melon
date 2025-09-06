package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class t implements Parcelable.Creator {
    public final int a;

    public t(int v) {
        this.a = v;
        super();
    }

    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        switch(this.a) {
            case 0: {
                return new aa(parcel0);
            }
            case 1: {
                return new ba(parcel0);
            }
            case 2: {
                return new c3(parcel0);
            }
            case 3: {
                return new ca(parcel0);
            }
            case 4: {
                return new cb(parcel0);
            }
            case 5: {
                String s = parcel0.readString();
                s.getClass();
                return new e9(parcel0.readInt(), s);
            }
            case 6: {
                return new ea(parcel0);
            }
            case 7: {
                return new fa(parcel0);
            }
            case 8: {
                return new fb(parcel0);
            }
            case 9: {
                return new g9(parcel0);
            }
            case 10: {
                return new hf(parcel0);
            }
            case 11: {
                return new ia(parcel0);
            }
            case 12: {
                return new ib(parcel0.readInt());
            }
            case 13: {
                return new j9(parcel0);
            }
            case 14: {
                return new ja();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
            case 15: {
                return new k9(parcel0);
            }
            case 16: {
                return new ka(parcel0);
            }
            case 17: {
                return new la(parcel0.readLong(), parcel0.readLong());
            }
            case 18: {
                return new m9(parcel0);
            }
            case 19: {
                return new mi(parcel0);
            }
            case 20: {
                return new n9(parcel0);
            }
            case 21: {
                return new o9(parcel0);
            }
            case 22: {
                return new p9(parcel0);
            }
            case 23: {
                return new q9(parcel0);
            }
            case 24: {
                return new r9(parcel0);
            }
            case 25: {
                return new s9(parcel0);
            }
            case 26: {
                return new t9(parcel0);
            }
            case 27: {
                return new u(parcel0);
            }
            case 28: {
                return new vc(parcel0);
            }
            default: {
                return new vm(parcel0);
            }
        }
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        switch(this.a) {
            case 0: {
                return new aa[v];
            }
            case 1: {
                return new ba[v];
            }
            case 2: {
                return new c3[v];
            }
            case 3: {
                return new ca[v];
            }
            case 4: {
                return new cb[v];
            }
            case 5: {
                return new e9[v];
            }
            case 6: {
                return new ea[v];
            }
            case 7: {
                return new fa[v];
            }
            case 8: {
                return new fb[v];
            }
            case 9: {
                return new g9[v];
            }
            case 10: {
                return new hf[v];
            }
            case 11: {
                return new ia[v];
            }
            case 12: {
                return new ib[v];
            }
            case 13: {
                return new j9[v];
            }
            case 14: {
                return new ja[v];
            }
            case 15: {
                return new k9[v];
            }
            case 16: {
                return new ka[v];
            }
            case 17: {
                return new la[v];
            }
            case 18: {
                return new m9[v];
            }
            case 19: {
                return new mi[v];
            }
            case 20: {
                return new n9[v];
            }
            case 21: {
                return new o9[v];
            }
            case 22: {
                return new p9[v];
            }
            case 23: {
                return new q9[v];
            }
            case 24: {
                return new r9[v];
            }
            case 25: {
                return new s9[v];
            }
            case 26: {
                return new t9[v];
            }
            case 27: {
                return new u[v];
            }
            case 28: {
                return new vc[v];
            }
            default: {
                return new vm[v];
            }
        }
    }
}

