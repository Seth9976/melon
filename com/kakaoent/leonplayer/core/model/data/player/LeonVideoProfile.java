package com.kakaoent.leonplayer.core.model.data.player;

import A7.d;
import Tf.o;
import U4.x;
import java.util.List;
import java.util.regex.Pattern;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J1\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001A\u00020\u0006HÖ\u0001J\u0010\u0010\u001A\u001A\u00020\u00032\u0006\u0010\u001B\u001A\u00020\u0003H\u0002J\t\u0010\u001C\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u0011\u0010\u000F\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\f¨\u0006\u001D"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/player/LeonVideoProfile;", "", "id", "", "originName", "bitrate", "", "resolution", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getBitrate", "()I", "getId", "()Ljava/lang/String;", "getOriginName", "getResolution", "simpleName", "getSimpleName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "resolutionToSimpleName", "target", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LeonVideoProfile {
    private final int bitrate;
    @NotNull
    private final String id;
    @NotNull
    private final String originName;
    @NotNull
    private final String resolution;
    @NotNull
    private final String simpleName;

    public LeonVideoProfile(@NotNull String s, @NotNull String s1, int v, @NotNull String s2) {
        q.g(s, "id");
        q.g(s1, "originName");
        q.g(s2, "resolution");
        super();
        this.id = s;
        this.originName = s1;
        this.bitrate = v;
        this.resolution = s2;
        this.simpleName = this.resolutionToSimpleName(s2);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.originName;
    }

    public final int component3() {
        return this.bitrate;
    }

    @NotNull
    public final String component4() {
        return this.resolution;
    }

    @NotNull
    public final LeonVideoProfile copy(@NotNull String s, @NotNull String s1, int v, @NotNull String s2) {
        q.g(s, "id");
        q.g(s1, "originName");
        q.g(s2, "resolution");
        return new LeonVideoProfile(s, s1, v, s2);
    }

    public static LeonVideoProfile copy$default(LeonVideoProfile leonVideoProfile0, String s, String s1, int v, String s2, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = leonVideoProfile0.id;
        }
        if((v1 & 2) != 0) {
            s1 = leonVideoProfile0.originName;
        }
        if((v1 & 4) != 0) {
            v = leonVideoProfile0.bitrate;
        }
        if((v1 & 8) != 0) {
            s2 = leonVideoProfile0.resolution;
        }
        return leonVideoProfile0.copy(s, s1, v, s2);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof LeonVideoProfile)) {
            return false;
        }
        if(!q.b(this.id, ((LeonVideoProfile)object0).id)) {
            return false;
        }
        if(!q.b(this.originName, ((LeonVideoProfile)object0).originName)) {
            return false;
        }
        return this.bitrate == ((LeonVideoProfile)object0).bitrate ? q.b(this.resolution, ((LeonVideoProfile)object0).resolution) : false;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getOriginName() {
        return this.originName;
    }

    @NotNull
    public final String getResolution() {
        return this.resolution;
    }

    @NotNull
    public final String getSimpleName() {
        return this.simpleName;
    }

    @Override
    public int hashCode() {
        return this.resolution.hashCode() + d.b(this.bitrate, x.b(this.id.hashCode() * 0x1F, 0x1F, this.originName), 0x1F);
    }

    private final String resolutionToSimpleName(String s) {
        Pattern pattern0 = Pattern.compile("(\\d+)x(\\d+)");
        q.f(pattern0, "compile(...)");
        q.g(s, "input");
        if(pattern0.matcher(s).matches()) {
            List list0 = o.R0(s, new String[]{"x"}, 0, 6);
            String s1 = (String)p.n0(0, list0);
            String s2 = (String)p.n0(1, list0);
            return s1 == null || s2 == null ? "" : Math.min(Integer.parseInt(s1), Integer.parseInt(s2)) + 'p';
        }
        return "";
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("LeonVideoProfile(id=");
        stringBuilder0.append(this.id);
        stringBuilder0.append(", originName=");
        stringBuilder0.append(this.originName);
        stringBuilder0.append(", bitrate=");
        stringBuilder0.append(this.bitrate);
        stringBuilder0.append(", resolution=");
        return androidx.appcompat.app.o.r(stringBuilder0, this.resolution, ')');
    }
}

