package i.n.i.b.a.s.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import androidx.appcompat.app.o;
import java.util.Arrays;

public final class vm implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final int b;
    public final int c;
    public final byte[] d;
    public int e;

    static {
        vm.CREATOR = new t(29);
    }

    public vm(int v, int v1, int v2, byte[] arr_b) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = arr_b;
    }

    public vm(Parcel parcel0) {
        this.a = parcel0.readInt();
        this.b = parcel0.readInt();
        this.c = parcel0.readInt();
        this.d = parcel0.readInt() == 0 ? null : parcel0.createByteArray();
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
            return vm.class == class0 && this.a == ((vm)object0).a && this.b == ((vm)object0).b && this.c == ((vm)object0).c && Arrays.equals(this.d, ((vm)object0).d);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        if(this.e == 0) {
            this.e = Arrays.hashCode(this.d) + (((this.a + 0x20F) * 0x1F + this.b) * 0x1F + this.c) * 0x1F;
        }
        return this.e;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ColorInfo(");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", ");
        return this.d == null ? o.s(stringBuilder0, false, ")") : o.s(stringBuilder0, true, ")");
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
        parcel0.writeInt(this.b);
        parcel0.writeInt(this.c);
        byte[] arr_b = this.d;
        parcel0.writeInt((arr_b == null ? 0 : 1));
        if(arr_b != null) {
            parcel0.writeByteArray(arr_b);
        }
    }
}

