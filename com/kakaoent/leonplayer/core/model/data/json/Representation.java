package com.kakaoent.leonplayer.core.model.data.json;

import U4.x;
import Vd.i;
import Vd.l;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u001B\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001A\u00020\u0005\u0012\b\b\u0001\u0010\b\u001A\u00020\u0005\u0012\n\b\u0001\u0010\t\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000BJ\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u0018\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0005HÆ\u0003J\u000B\u0010\u001C\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015JZ\u0010\u001E\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001A\u00020\u00052\b\b\u0003\u0010\u0007\u001A\u00020\u00052\b\b\u0003\u0010\b\u001A\u00020\u00052\n\b\u0003\u0010\t\u001A\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001A\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001FJ\u0013\u0010 \u001A\u00020!2\b\u0010\"\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001A\u00020\u0003HÖ\u0001J\t\u0010$\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000FR\u0011\u0010\u0007\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000FR\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000FR\u0013\u0010\t\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u000FR\u0015\u0010\n\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/Representation;", "", "bitrate", "", "channels", "", "codec", "dispName", "id", "resolution", "sampleRate", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getBitrate", "()I", "getChannels", "()Ljava/lang/String;", "getCodec", "getDispName", "getId", "getResolution", "getSampleRate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/kakaoent/leonplayer/core/model/data/json/Representation;", "equals", "", "other", "hashCode", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class Representation {
    private final int bitrate;
    @Nullable
    private final String channels;
    @NotNull
    private final String codec;
    @NotNull
    private final String dispName;
    @NotNull
    private final String id;
    @Nullable
    private final String resolution;
    @Nullable
    private final Integer sampleRate;

    public Representation(@i(name = "bitrate") int v, @i(name = "channels") @Nullable String s, @i(name = "codec") @NotNull String s1, @i(name = "disp_name") @NotNull String s2, @i(name = "id") @NotNull String s3, @i(name = "resolution") @Nullable String s4, @i(name = "sample_rate") @Nullable Integer integer0) {
        q.g(s1, "codec");
        q.g(s2, "dispName");
        q.g(s3, "id");
        super();
        this.bitrate = v;
        this.channels = s;
        this.codec = s1;
        this.dispName = s2;
        this.id = s3;
        this.resolution = s4;
        this.sampleRate = integer0;
    }

    public final int component1() {
        return this.bitrate;
    }

    @Nullable
    public final String component2() {
        return this.channels;
    }

    @NotNull
    public final String component3() {
        return this.codec;
    }

    @NotNull
    public final String component4() {
        return this.dispName;
    }

    @NotNull
    public final String component5() {
        return this.id;
    }

    @Nullable
    public final String component6() {
        return this.resolution;
    }

    @Nullable
    public final Integer component7() {
        return this.sampleRate;
    }

    @NotNull
    public final Representation copy(@i(name = "bitrate") int v, @i(name = "channels") @Nullable String s, @i(name = "codec") @NotNull String s1, @i(name = "disp_name") @NotNull String s2, @i(name = "id") @NotNull String s3, @i(name = "resolution") @Nullable String s4, @i(name = "sample_rate") @Nullable Integer integer0) {
        q.g(s1, "codec");
        q.g(s2, "dispName");
        q.g(s3, "id");
        return new Representation(v, s, s1, s2, s3, s4, integer0);
    }

    public static Representation copy$default(Representation representation0, int v, String s, String s1, String s2, String s3, String s4, Integer integer0, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = representation0.bitrate;
        }
        if((v1 & 2) != 0) {
            s = representation0.channels;
        }
        if((v1 & 4) != 0) {
            s1 = representation0.codec;
        }
        if((v1 & 8) != 0) {
            s2 = representation0.dispName;
        }
        if((v1 & 16) != 0) {
            s3 = representation0.id;
        }
        if((v1 & 0x20) != 0) {
            s4 = representation0.resolution;
        }
        if((v1 & 0x40) != 0) {
            integer0 = representation0.sampleRate;
        }
        return representation0.copy(v, s, s1, s2, s3, s4, integer0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Representation)) {
            return false;
        }
        if(this.bitrate != ((Representation)object0).bitrate) {
            return false;
        }
        if(!q.b(this.channels, ((Representation)object0).channels)) {
            return false;
        }
        if(!q.b(this.codec, ((Representation)object0).codec)) {
            return false;
        }
        if(!q.b(this.dispName, ((Representation)object0).dispName)) {
            return false;
        }
        if(!q.b(this.id, ((Representation)object0).id)) {
            return false;
        }
        return q.b(this.resolution, ((Representation)object0).resolution) ? q.b(this.sampleRate, ((Representation)object0).sampleRate) : false;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    @Nullable
    public final String getChannels() {
        return this.channels;
    }

    @NotNull
    public final String getCodec() {
        return this.codec;
    }

    @NotNull
    public final String getDispName() {
        return this.dispName;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getResolution() {
        return this.resolution;
    }

    @Nullable
    public final Integer getSampleRate() {
        return this.sampleRate;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = x.b(x.b(x.b((this.bitrate * 0x1F + (this.channels == null ? 0 : this.channels.hashCode())) * 0x1F, 0x1F, this.codec), 0x1F, this.dispName), 0x1F, this.id);
        int v2 = this.resolution == null ? 0 : this.resolution.hashCode();
        Integer integer0 = this.sampleRate;
        if(integer0 != null) {
            v = integer0.hashCode();
        }
        return (v1 + v2) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "Representation(bitrate=" + this.bitrate + ", channels=" + this.channels + ", codec=" + this.codec + ", dispName=" + this.dispName + ", id=" + this.id + ", resolution=" + this.resolution + ", sampleRate=" + this.sampleRate + ')';
    }
}

