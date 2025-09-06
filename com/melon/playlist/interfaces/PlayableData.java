package com.melon.playlist.interfaces;

import A7.d;
import U4.x;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.SpecialBgVideo;
import com.iloen.melon.sns.model.e;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/playlist/interfaces/PlayableData;", "Landroid/os/Parcelable;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlayableData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public final Playable a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String e;
    public final String f;
    public final long g;
    public final String h;
    public final String i;
    public final boolean j;
    public final boolean k;
    public final int l;
    public final Uri m;
    public final Uri n;
    public final SpecialBgVideo o;
    public final List r;

    static {
        PlayableData.CREATOR = new e(24);
    }

    public PlayableData(Playable playable0, String s, boolean z, boolean z1, String s1, String s2, long v, String s3, String s4, boolean z2, boolean z3, int v1, Uri uri0, Uri uri1, SpecialBgVideo specialBgVideo0, List list0) {
        q.g(playable0, "rawPlayable");
        q.g(uri0, "smallAlbumUri");
        q.g(uri1, "largeAlbumUri");
        super();
        this.a = playable0;
        this.b = s;
        this.c = z;
        this.d = z1;
        this.e = s1;
        this.f = s2;
        this.g = v;
        this.h = s3;
        this.i = s4;
        this.j = z2;
        this.k = z3;
        this.l = v1;
        this.m = uri0;
        this.n = uri1;
        this.o = specialBgVideo0;
        this.r = list0;
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
        if(!(object0 instanceof PlayableData)) {
            return false;
        }
        if(!q.b(this.a, ((PlayableData)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((PlayableData)object0).b)) {
            return false;
        }
        if(this.c != ((PlayableData)object0).c) {
            return false;
        }
        if(this.d != ((PlayableData)object0).d) {
            return false;
        }
        if(!q.b(this.e, ((PlayableData)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((PlayableData)object0).f)) {
            return false;
        }
        if(this.g != ((PlayableData)object0).g) {
            return false;
        }
        if(!q.b(this.h, ((PlayableData)object0).h)) {
            return false;
        }
        if(!q.b(this.i, ((PlayableData)object0).i)) {
            return false;
        }
        if(this.j != ((PlayableData)object0).j) {
            return false;
        }
        if(this.k != ((PlayableData)object0).k) {
            return false;
        }
        if(this.l != ((PlayableData)object0).l) {
            return false;
        }
        if(!q.b(this.m, ((PlayableData)object0).m)) {
            return false;
        }
        if(!q.b(this.n, ((PlayableData)object0).n)) {
            return false;
        }
        return q.b(this.o, ((PlayableData)object0).o) ? q.b(this.r, ((PlayableData)object0).r) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = d.b(this.l, d.e(d.e(((d.c(((d.e(d.e((this.a.hashCode() * 0x1F + (this.b == null ? 0 : this.b.hashCode())) * 0x1F, 0x1F, this.c), 0x1F, this.d) + (this.e == null ? 0 : this.e.hashCode())) * 0x1F + (this.f == null ? 0 : this.f.hashCode())) * 0x1F, 0x1F, this.g) + (this.h == null ? 0 : this.h.hashCode())) * 0x1F + (this.i == null ? 0 : this.i.hashCode())) * 0x1F, 0x1F, this.j), 0x1F, this.k), 0x1F);
        int v2 = this.m.hashCode();
        int v3 = this.n.hashCode();
        SpecialBgVideo specialBgVideo0 = this.o;
        if(specialBgVideo0 != null) {
            v = specialBgVideo0.hashCode();
        }
        return this.r.hashCode() + ((v3 + (v2 + v1) * 0x1F) * 0x1F + v) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("PlayableData(rawPlayable=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", trackId=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", isOriginMelon=");
        x.y(stringBuilder0, this.c, ", isOriginLocal=", this.d, ", metaType=");
        d.u(stringBuilder0, this.e, ", bitrate=", this.f, ", durationLimit=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", songName=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", artistNames=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", isAdult=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(", isLiked=");
        stringBuilder0.append(this.k);
        stringBuilder0.append(", likeCount=");
        stringBuilder0.append(this.l);
        stringBuilder0.append(", smallAlbumUri=");
        stringBuilder0.append(this.m);
        stringBuilder0.append(", largeAlbumUri=");
        stringBuilder0.append(this.n);
        stringBuilder0.append(", specialBgVideo=");
        stringBuilder0.append(this.o);
        stringBuilder0.append(", specialBgImages=");
        stringBuilder0.append(this.r);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeParcelable(this.a, v);
        parcel0.writeString(this.b);
        parcel0.writeInt(((int)this.c));
        parcel0.writeInt(((int)this.d));
        parcel0.writeString(this.e);
        parcel0.writeString(this.f);
        parcel0.writeLong(this.g);
        parcel0.writeString(this.h);
        parcel0.writeString(this.i);
        parcel0.writeInt(((int)this.j));
        parcel0.writeInt(((int)this.k));
        parcel0.writeInt(this.l);
        parcel0.writeParcelable(this.m, v);
        parcel0.writeParcelable(this.n, v);
        parcel0.writeSerializable(this.o);
        parcel0.writeInt(this.r.size());
        for(Object object0: this.r) {
            parcel0.writeSerializable(((Serializable)object0));
        }
    }
}

