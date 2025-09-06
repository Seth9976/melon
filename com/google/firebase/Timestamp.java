package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import androidx.appcompat.app.o;
import e1.b;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import va.e;
import we.k;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/firebase/Timestamp;", "", "Landroid/os/Parcelable;", "com.google.firebase-firebase-common"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Timestamp implements Parcelable, Comparable {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public final long a;
    public final int b;

    static {
        Timestamp.CREATOR = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public Timestamp(long v, int v1) {
        if(v1 < 0 || v1 >= 1000000000) {
            throw new IllegalArgumentException(("Timestamp nanoseconds out of range: " + v1).toString());
        }
        if(0xFFFFFFF1886E0900L > v || v >= 253402300800L) {
            throw new IllegalArgumentException(e.a(v, "Timestamp seconds out of range: ").toString());
        }
        this.a = v;
        this.b = v1;
    }

    @Override
    public final int compareTo(Object object0) {
        q.g(((Timestamp)object0), "other");
        k[] arr_k = {i.b, j.b};
        for(int v = 0; v < 2; ++v) {
            k k0 = arr_k[v];
            int v1 = b.r(((Comparable)k0.invoke(this)), ((Comparable)k0.invoke(((Timestamp)object0))));
            if(v1 != 0) {
                return v1;
            }
        }
        return 0;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != this) {
            if(object0 instanceof Timestamp) {
                q.g(((Timestamp)object0), "other");
                k[] arr_k = {i.b, j.b};
                for(int v = 0; v < 2; ++v) {
                    k k0 = arr_k[v];
                    int v1 = b.r(((Comparable)k0.invoke(this)), ((Comparable)k0.invoke(((Timestamp)object0))));
                    if(v1 != 0) {
                        return v1 == 0;
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return (((int)this.a) * 0x559 + ((int)(this.a >> 0x20))) * 37 + this.b;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Timestamp(seconds=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", nanoseconds=");
        return o.q(stringBuilder0, this.b, ')');
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeLong(this.a);
        parcel0.writeInt(this.b);
    }
}

