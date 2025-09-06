package com.iloen.melon.playback.playlist.musicwave;

import A7.d;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001Ba\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ\r\u0010\u000E\u001A\u00020\r\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u001D\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\r\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u0019\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u0017J\u0012\u0010\u001A\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u0017J\u0012\u0010\u001B\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u0017J\u0012\u0010\u001C\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u0017J\u0012\u0010\u001D\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u0017J\u0012\u0010\u001E\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u0017Jl\u0010\u001F\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0002H\u00C6\u0001\u00A2\u0006\u0004\b\u001F\u0010 J\u0010\u0010!\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b!\u0010\u0017J\u0010\u0010\"\u001A\u00020\rH\u00D6\u0001\u00A2\u0006\u0004\b\"\u0010\u000FJ\u001A\u0010&\u001A\u00020%2\b\u0010$\u001A\u0004\u0018\u00010#H\u00D6\u0003\u00A2\u0006\u0004\b&\u0010\'R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010(\u001A\u0004\b)\u0010\u0017R\u0017\u0010\u0004\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010(\u001A\u0004\b*\u0010\u0017R\u0019\u0010\u0005\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010(\u001A\u0004\b+\u0010\u0017R\u0019\u0010\u0006\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010(\u001A\u0004\b,\u0010\u0017R\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010(\u001A\u0004\b-\u0010\u0017R\u0019\u0010\b\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\b\u0010(\u001A\u0004\b.\u0010\u0017R\u0019\u0010\t\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\t\u0010(\u001A\u0004\b/\u0010\u0017R\u0019\u0010\n\u001A\u0004\u0018\u00010\u00028\u0006\u00A2\u0006\f\n\u0004\b\n\u0010(\u001A\u0004\b0\u0010\u0017\u00A8\u00061"}, d2 = {"Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveChannelInfo;", "Landroid/os/Parcelable;", "", "id", "type", "originMenuId", "channelImgType", "channelImgUrl", "title", "subTitle", "channelTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveChannelInfo;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getType", "getOriginMenuId", "getChannelImgType", "getChannelImgUrl", "getTitle", "getSubTitle", "getChannelTitle", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWaveChannelInfo implements Parcelable {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class Creator implements Parcelable.Creator {
        public final MusicWaveChannelInfo createFromParcel(Parcel parcel0) {
            q.g(parcel0, "parcel");
            return new MusicWaveChannelInfo(parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString());
        }

        @Override  // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel0) {
            return this.createFromParcel(parcel0);
        }

        public final MusicWaveChannelInfo[] newArray(int v) {
            return new MusicWaveChannelInfo[v];
        }

        @Override  // android.os.Parcelable$Creator
        public Object[] newArray(int v) {
            return this.newArray(v);
        }
    }

    public static final int $stable;
    @NotNull
    public static final Parcelable.Creator CREATOR;
    @Nullable
    private final String channelImgType;
    @Nullable
    private final String channelImgUrl;
    @Nullable
    private final String channelTitle;
    @NotNull
    private final String id;
    @Nullable
    private final String originMenuId;
    @Nullable
    private final String subTitle;
    @Nullable
    private final String title;
    @NotNull
    private final String type;

    static {
        MusicWaveChannelInfo.CREATOR = new Creator();
    }

    public MusicWaveChannelInfo(@NotNull String s, @NotNull String s1) {
        q.g(s, "id");
        q.g(s1, "type");
        this(s, s1, null, null, null, null, null, null, 0xFC, null);
    }

    public MusicWaveChannelInfo(@NotNull String s, @NotNull String s1, @Nullable String s2) {
        q.g(s, "id");
        q.g(s1, "type");
        this(s, s1, s2, null, null, null, null, null, 0xF8, null);
    }

    public MusicWaveChannelInfo(@NotNull String s, @NotNull String s1, @Nullable String s2, @Nullable String s3) {
        q.g(s, "id");
        q.g(s1, "type");
        this(s, s1, s2, s3, null, null, null, null, 0xF0, null);
    }

    public MusicWaveChannelInfo(@NotNull String s, @NotNull String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4) {
        q.g(s, "id");
        q.g(s1, "type");
        this(s, s1, s2, s3, s4, null, null, null, 0xE0, null);
    }

    public MusicWaveChannelInfo(@NotNull String s, @NotNull String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5) {
        q.g(s, "id");
        q.g(s1, "type");
        this(s, s1, s2, s3, s4, s5, null, null, 0xC0, null);
    }

    public MusicWaveChannelInfo(@NotNull String s, @NotNull String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6) {
        q.g(s, "id");
        q.g(s1, "type");
        this(s, s1, s2, s3, s4, s5, s6, null, 0x80, null);
    }

    public MusicWaveChannelInfo(@NotNull String s, @NotNull String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7) {
        q.g(s, "id");
        q.g(s1, "type");
        super();
        this.id = s;
        this.type = s1;
        this.originMenuId = s2;
        this.channelImgType = s3;
        this.channelImgUrl = s4;
        this.title = s5;
        this.subTitle = s6;
        this.channelTitle = s7;
    }

    public MusicWaveChannelInfo(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 4) != 0) {
            s2 = null;
        }
        if((v & 8) != 0) {
            s3 = null;
        }
        if((v & 16) != 0) {
            s4 = null;
        }
        if((v & 0x20) != 0) {
            s5 = null;
        }
        if((v & 0x40) != 0) {
            s6 = null;
        }
        this(s, s1, s2, s3, s4, s5, s6, ((v & 0x80) == 0 ? s7 : null));
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    @Nullable
    public final String component3() {
        return this.originMenuId;
    }

    @Nullable
    public final String component4() {
        return this.channelImgType;
    }

    @Nullable
    public final String component5() {
        return this.channelImgUrl;
    }

    @Nullable
    public final String component6() {
        return this.title;
    }

    @Nullable
    public final String component7() {
        return this.subTitle;
    }

    @Nullable
    public final String component8() {
        return this.channelTitle;
    }

    @NotNull
    public final MusicWaveChannelInfo copy(@NotNull String s, @NotNull String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7) {
        q.g(s, "id");
        q.g(s1, "type");
        return new MusicWaveChannelInfo(s, s1, s2, s3, s4, s5, s6, s7);
    }

    public static MusicWaveChannelInfo copy$default(MusicWaveChannelInfo musicWaveChannelInfo0, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, int v, Object object0) {
        if((v & 1) != 0) {
            s = musicWaveChannelInfo0.id;
        }
        if((v & 2) != 0) {
            s1 = musicWaveChannelInfo0.type;
        }
        if((v & 4) != 0) {
            s2 = musicWaveChannelInfo0.originMenuId;
        }
        if((v & 8) != 0) {
            s3 = musicWaveChannelInfo0.channelImgType;
        }
        if((v & 16) != 0) {
            s4 = musicWaveChannelInfo0.channelImgUrl;
        }
        if((v & 0x20) != 0) {
            s5 = musicWaveChannelInfo0.title;
        }
        if((v & 0x40) != 0) {
            s6 = musicWaveChannelInfo0.subTitle;
        }
        if((v & 0x80) != 0) {
            s7 = musicWaveChannelInfo0.channelTitle;
        }
        return musicWaveChannelInfo0.copy(s, s1, s2, s3, s4, s5, s6, s7);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof MusicWaveChannelInfo)) {
            return false;
        }
        if(!q.b(this.id, ((MusicWaveChannelInfo)object0).id)) {
            return false;
        }
        if(!q.b(this.type, ((MusicWaveChannelInfo)object0).type)) {
            return false;
        }
        if(!q.b(this.originMenuId, ((MusicWaveChannelInfo)object0).originMenuId)) {
            return false;
        }
        if(!q.b(this.channelImgType, ((MusicWaveChannelInfo)object0).channelImgType)) {
            return false;
        }
        if(!q.b(this.channelImgUrl, ((MusicWaveChannelInfo)object0).channelImgUrl)) {
            return false;
        }
        if(!q.b(this.title, ((MusicWaveChannelInfo)object0).title)) {
            return false;
        }
        return q.b(this.subTitle, ((MusicWaveChannelInfo)object0).subTitle) ? q.b(this.channelTitle, ((MusicWaveChannelInfo)object0).channelTitle) : false;
    }

    @Nullable
    public final String getChannelImgType() {
        return this.channelImgType;
    }

    @Nullable
    public final String getChannelImgUrl() {
        return this.channelImgUrl;
    }

    @Nullable
    public final String getChannelTitle() {
        return this.channelTitle;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getOriginMenuId() {
        return this.originMenuId;
    }

    @Nullable
    public final String getSubTitle() {
        return this.subTitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Override
    public int hashCode() {
        int v = x.b(this.id.hashCode() * 0x1F, 0x1F, this.type);
        int v1 = 0;
        int v2 = this.originMenuId == null ? 0 : this.originMenuId.hashCode();
        int v3 = this.channelImgType == null ? 0 : this.channelImgType.hashCode();
        int v4 = this.channelImgUrl == null ? 0 : this.channelImgUrl.hashCode();
        int v5 = this.title == null ? 0 : this.title.hashCode();
        int v6 = this.subTitle == null ? 0 : this.subTitle.hashCode();
        String s = this.channelTitle;
        if(s != null) {
            v1 = s.hashCode();
        }
        return (((((v + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v1;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = d.o("MusicWaveChannelInfo(id=", this.id, ", type=", this.type, ", originMenuId=");
        d.u(stringBuilder0, this.originMenuId, ", channelImgType=", this.channelImgType, ", channelImgUrl=");
        d.u(stringBuilder0, this.channelImgUrl, ", title=", this.title, ", subTitle=");
        return d.n(stringBuilder0, this.subTitle, ", channelTitle=", this.channelTitle, ")");
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.id);
        parcel0.writeString(this.type);
        parcel0.writeString(this.originMenuId);
        parcel0.writeString(this.channelImgType);
        parcel0.writeString(this.channelImgUrl);
        parcel0.writeString(this.title);
        parcel0.writeString(this.subTitle);
        parcel0.writeString(this.channelTitle);
    }
}

