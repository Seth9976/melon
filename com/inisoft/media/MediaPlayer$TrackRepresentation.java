package com.inisoft.media;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import i.n.i.b.a.s.e.u;
import y.a;

public class MediaPlayer.TrackRepresentation implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final u b;
    public final RectF c;

    static {
        MediaPlayer.TrackRepresentation.CREATOR = new a(3);
    }

    public MediaPlayer.TrackRepresentation(int v, u u0, RectF rectF0) {
        this.a = v;
        this.b = u0;
        if(rectF0 == null) {
            rectF0 = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
        }
        this.c = rectF0;
    }

    public MediaPlayer.TrackRepresentation(Parcel parcel0) {
        this.a = parcel0.readInt();
        u u0 = (u)parcel0.readParcelable(u.class.getClassLoader());
        u0.getClass();
        this.b = u0;
        RectF rectF0 = (RectF)parcel0.readParcelable(RectF.class.getClassLoader());
        rectF0.getClass();
        this.c = rectF0;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
        this.b.writeToParcel(parcel0, 0);
        this.c.writeToParcel(parcel0, 0);
    }
}

