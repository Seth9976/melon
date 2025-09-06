package androidx.media3.session.legacy;

import P4.d;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public final class MediaSessionCompat.Token implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final Object a;
    public final Object b;
    public f c;
    public d d;

    static {
        MediaSessionCompat.Token.CREATOR = new U(5);
    }

    public MediaSessionCompat.Token(Object object0, f f0, d d0) {
        this.a = new Object();
        this.b = object0;
        this.c = f0;
        this.d = d0;
    }

    public final f a() {
        synchronized(this.a) {
        }
        return this.c;
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
        if(!(object0 instanceof MediaSessionCompat.Token)) {
            return false;
        }
        Object object1 = this.b;
        if(object1 == null) {
            return ((MediaSessionCompat.Token)object0).b == null;
        }
        Object object2 = ((MediaSessionCompat.Token)object0).b;
        return object2 == null ? false : object1.equals(object2);
    }

    @Override
    public final int hashCode() {
        return this.b == null ? 0 : this.b.hashCode();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeParcelable(((Parcelable)this.b), v);
    }
}

