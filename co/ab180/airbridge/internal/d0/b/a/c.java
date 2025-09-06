package co.ab180.airbridge.internal.d0.b.a;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c {
    private static final ClassLoader a;
    private static final int b;

    static {
        c.a = c.class.getClassLoader();
    }

    public static Parcelable a(Parcel parcel0, Parcelable.Creator parcelable$Creator0) {
        return parcel0.readInt() == 0 ? null : ((Parcelable)parcelable$Creator0.createFromParcel(parcel0));
    }

    public static void a(Parcel parcel0, IInterface iInterface0) {
        parcel0.writeStrongBinder((iInterface0 == null ? null : iInterface0.asBinder()));
    }

    public static void a(Parcel parcel0, Parcelable parcelable0) {
        if(parcelable0 == null) {
            parcel0.writeInt(0);
            return;
        }
        parcel0.writeInt(1);
        parcelable0.writeToParcel(parcel0, 0);
    }

    public static void a(Parcel parcel0, CharSequence charSequence0) {
        if(charSequence0 != null) {
            parcel0.writeInt(1);
            TextUtils.writeToParcel(charSequence0, parcel0, 0);
            return;
        }
        parcel0.writeInt(0);
    }

    public static void a(Parcel parcel0, List list0) {
        parcel0.readList(list0, c.a);
    }

    public static void a(Parcel parcel0, Map map0) {
        parcel0.readMap(map0, c.a);
    }

    public static void a(Parcel parcel0, boolean z) {
        parcel0.writeInt(((int)z));
    }

    public static boolean a(Parcel parcel0) {
        return parcel0.readInt() != 0;
    }

    public static CharSequence b(Parcel parcel0) {
        return parcel0.readInt() == 0 ? null : ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel0));
    }

    public static void b(Parcel parcel0, Parcelable parcelable0) {
        if(parcelable0 == null) {
            parcel0.writeInt(0);
            return;
        }
        parcel0.writeInt(1);
        parcelable0.writeToParcel(parcel0, 1);
    }

    public static void b(Parcel parcel0, CharSequence charSequence0) {
        if(charSequence0 != null) {
            parcel0.writeInt(1);
            TextUtils.writeToParcel(charSequence0, parcel0, 1);
            return;
        }
        parcel0.writeInt(0);
    }

    public static ArrayList c(Parcel parcel0) {
        return parcel0.readArrayList(c.a);
    }

    public static HashMap d(Parcel parcel0) {
        return parcel0.readHashMap(c.a);
    }
}

