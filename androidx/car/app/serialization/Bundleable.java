package androidx.car.app.serialization;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayDeque;
import y.a;
import y.d;
import y.f;

public final class Bundleable implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final Bundle a;

    static {
        Bundleable.CREATOR = new a(0);
    }

    public Bundleable(Bundle bundle0) {
        this.a = bundle0;
    }

    public Bundleable(Object object0) {
        String s = f.i(object0.getClass());
        if(Log.isLoggable("CarApp.Bun", 3)) {
            Log.d("CarApp.Bun", "Bundling " + s);
        }
        this.a = f.o(object0, s, new d(null, "", new ArrayDeque()));
    }

    public final Object a() {
        boolean z = Log.isLoggable("CarApp.Bun", 3);
        Bundle bundle0 = this.a;
        if(z) {
            Integer integer0 = bundle0.getInt("tag_class_type");
            String s = (String)f.b.get(integer0);
            if(s == null) {
                s = "unknown";
            }
            Log.d("CarApp.Bun", "Unbundling " + s);
        }
        return f.f(bundle0, new d(null, "", new ArrayDeque()));
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeBundle(this.a);
    }
}

