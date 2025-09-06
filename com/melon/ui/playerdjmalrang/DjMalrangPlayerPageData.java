package com.melon.ui.playerdjmalrang;

import A7.d;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import rd.f0;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/ui/playerdjmalrang/DjMalrangPlayerPageData;", "Landroid/os/Parcelable;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DjMalrangPlayerPageData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public final List a;
    public final String b;
    public final String c;
    public final boolean d;
    public final int e;
    public final boolean f;

    static {
        DjMalrangPlayerPageData.CREATOR = new f0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public DjMalrangPlayerPageData(List list0, String s, String s1, boolean z, int v, boolean z1) {
        q.g(list0, "albumUris");
        super();
        this.a = list0;
        this.b = s;
        this.c = s1;
        this.d = z;
        this.e = v;
        this.f = z1;
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
        if(!(object0 instanceof DjMalrangPlayerPageData)) {
            return false;
        }
        if(!q.b(this.a, ((DjMalrangPlayerPageData)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((DjMalrangPlayerPageData)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((DjMalrangPlayerPageData)object0).c)) {
            return false;
        }
        if(this.d != ((DjMalrangPlayerPageData)object0).d) {
            return false;
        }
        return this.e == ((DjMalrangPlayerPageData)object0).e ? this.f == ((DjMalrangPlayerPageData)object0).f : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        int v1 = 0;
        int v2 = this.b == null ? 0 : this.b.hashCode();
        String s = this.c;
        if(s != null) {
            v1 = s.hashCode();
        }
        return Boolean.hashCode(this.f) + d.b(this.e, d.e(((v * 0x1F + v2) * 0x1F + v1) * 0x1F, 0x1F, this.d), 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DjMalrangPlayerPageData(albumUris=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", songName=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", artistName=");
        Y.x(stringBuilder0, this.c, ", isLiked=", this.d, ", likeCount=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", isCurrent=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeStringList(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.c);
        parcel0.writeInt(((int)this.d));
        parcel0.writeInt(this.e);
        parcel0.writeInt(((int)this.f));
    }
}

