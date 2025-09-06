package com.inisoft.media;

import U4.x;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import i.n.i.b.a.s.e.u;
import y.a;

public class MediaPlayer.TrackInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final int b;
    public final int c;
    public final u d;
    public final String e;
    public final String f;
    public final MediaPlayer.TrackRepresentation[] g;
    public final String h;

    static {
        MediaPlayer.TrackInfo.CREATOR = new a(2);
    }

    public MediaPlayer.TrackInfo(int v, int v1, int v2, u u0, String s, String s1, u[] arr_u, RectF rectF0, String s2) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = u0;
        this.e = s;
        this.f = s1;
        this.g = new MediaPlayer.TrackRepresentation[arr_u.length];
        for(int v3 = 0; v3 < arr_u.length; ++v3) {
            this.g[v3] = new MediaPlayer.TrackRepresentation(v2, arr_u[v3], rectF0);
        }
        this.h = s2;
    }

    public MediaPlayer.TrackInfo(Parcel parcel0) {
        this.a = parcel0.readInt();
        this.b = parcel0.readInt();
        this.c = parcel0.readInt();
        u u0 = (u)parcel0.readParcelable(u.class.getClassLoader());
        u0.getClass();
        this.d = u0;
        String s = parcel0.readString();
        s.getClass();
        this.e = s;
        String s1 = parcel0.readString();
        s1.getClass();
        this.f = s1;
        MediaPlayer.TrackRepresentation[] arr_mediaPlayer$TrackRepresentation = (MediaPlayer.TrackRepresentation[])parcel0.createTypedArray(MediaPlayer.TrackRepresentation.CREATOR);
        arr_mediaPlayer$TrackRepresentation.getClass();
        this.g = arr_mediaPlayer$TrackRepresentation;
        this.h = parcel0.readString();
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final String toString() {
        String s;
        int v = this.c;
        switch(v) {
            case 0: {
                s = "unknown";
                break;
            }
            case 1: {
                s = "video";
                break;
            }
            case 2: {
                s = "audio";
                break;
            }
            case 3: {
                s = "timedtext";
                break;
            }
            case 5: {
                s = "metadata";
                break;
            }
            default: {
                s = "unknown(" + v + ")";
            }
        }
        StringBuilder stringBuilder0 = com.iloen.melon.utils.a.n("TrackInfo(type=", s, ", mime=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", lang=");
        return x.m(stringBuilder0, this.f, ")");
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
        parcel0.writeInt(this.b);
        parcel0.writeInt(this.c);
        parcel0.writeParcelable(this.d, 0);
        parcel0.writeString(this.e);
        parcel0.writeString(this.f);
        parcel0.writeTypedArray(this.g, v);
    }
}

