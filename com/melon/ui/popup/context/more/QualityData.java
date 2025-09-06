package com.melon.ui.popup.context.more;

import A7.d;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import v9.n;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/ui/popup/context/more/QualityData;", "Landroid/os/Parcelable;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class QualityData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final String b;
    public final boolean c;

    static {
        QualityData.CREATOR = new n(3);
    }

    public QualityData(String s, String s1, boolean z) {
        q.g(s, "id");
        q.g(s1, "quality");
        super();
        this.a = s;
        this.b = s1;
        this.c = z;
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
        if(!(object0 instanceof QualityData)) {
            return false;
        }
        if(!q.b(this.a, ((QualityData)object0).a)) {
            return false;
        }
        return q.b(this.b, ((QualityData)object0).b) ? this.c == ((QualityData)object0).c : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.c) + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        return o.s(d.o("QualityData(id=", this.a, ", quality=", this.b, ", isSelected="), this.c, ")");
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeInt(((int)this.c));
    }
}

