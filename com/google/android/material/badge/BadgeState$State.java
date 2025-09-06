package com.google.android.material.badge;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.iloen.melon.sns.model.e;
import java.util.Locale;

public final class BadgeState.State implements Parcelable {
    public int B;
    public static final Parcelable.Creator CREATOR;
    public Integer D;
    public Boolean E;
    public Integer G;
    public Integer I;
    public Integer M;
    public Integer N;
    public Integer S;
    public Integer T;
    public Integer V;
    public Integer W;
    public Integer X;
    public Boolean Y;
    public int a;
    public Integer b;
    public Integer c;
    public Integer d;
    public Integer e;
    public Integer f;
    public Integer g;
    public Integer h;
    public int i;
    public String j;
    public int k;
    public int l;
    public int m;
    public Locale n;
    public CharSequence o;
    public CharSequence r;
    public int w;

    static {
        BadgeState.State.CREATOR = new e(21);
    }

    public BadgeState.State() {
        this.i = 0xFF;
        this.k = -2;
        this.l = -2;
        this.m = -2;
        this.E = Boolean.TRUE;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.a);
        parcel0.writeSerializable(this.b);
        parcel0.writeSerializable(this.c);
        parcel0.writeSerializable(this.d);
        parcel0.writeSerializable(this.e);
        parcel0.writeSerializable(this.f);
        parcel0.writeSerializable(this.g);
        parcel0.writeSerializable(this.h);
        parcel0.writeInt(this.i);
        parcel0.writeString(this.j);
        parcel0.writeInt(this.k);
        parcel0.writeInt(this.l);
        parcel0.writeInt(this.m);
        String s = null;
        parcel0.writeString((this.o == null ? null : this.o.toString()));
        CharSequence charSequence0 = this.r;
        if(charSequence0 != null) {
            s = charSequence0.toString();
        }
        parcel0.writeString(s);
        parcel0.writeInt(this.w);
        parcel0.writeSerializable(this.D);
        parcel0.writeSerializable(this.G);
        parcel0.writeSerializable(this.I);
        parcel0.writeSerializable(this.M);
        parcel0.writeSerializable(this.N);
        parcel0.writeSerializable(this.S);
        parcel0.writeSerializable(this.T);
        parcel0.writeSerializable(this.X);
        parcel0.writeSerializable(this.V);
        parcel0.writeSerializable(this.W);
        parcel0.writeSerializable(this.E);
        parcel0.writeSerializable(this.n);
        parcel0.writeSerializable(this.Y);
    }
}

