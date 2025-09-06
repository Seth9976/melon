package com.kakaoent.leonplayer.core.model.data.json;

import Vd.i;
import Vd.l;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000B\u0010\u0018\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u0019\u001A\u0004\u0018\u00010\u0003HÆ\u0003JH\u0010\u001A\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001A\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001A\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001BJ\u0013\u0010\u001C\u001A\u00020\u001D2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001F\u001A\u00020\u0007HÖ\u0001J\t\u0010 \u001A\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\t\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0013\u0010\b\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000FR\u0015\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u000F¨\u0006!"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/MediaProperties;", "", "type", "", "duration", "", "ndvrWindowSize", "", "liveStartTime", "liveEndTime", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getDuration", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLiveEndTime", "()Ljava/lang/String;", "getLiveStartTime", "getNdvrWindowSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/kakaoent/leonplayer/core/model/data/json/MediaProperties;", "equals", "", "other", "hashCode", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class MediaProperties {
    @Nullable
    private final Double duration;
    @Nullable
    private final String liveEndTime;
    @Nullable
    private final String liveStartTime;
    @Nullable
    private final Integer ndvrWindowSize;
    @NotNull
    private final String type;

    public MediaProperties(@i(name = "type") @NotNull String s, @i(name = "duration") @Nullable Double double0, @i(name = "ndvr_window_size") @Nullable Integer integer0, @i(name = "live_start_time") @Nullable String s1, @i(name = "live_end_time") @Nullable String s2) {
        q.g(s, "type");
        super();
        this.type = s;
        this.duration = double0;
        this.ndvrWindowSize = integer0;
        this.liveStartTime = s1;
        this.liveEndTime = s2;
    }

    public MediaProperties(String s, Double double0, Integer integer0, String s1, String s2, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            double0 = null;
        }
        this(s, double0, integer0, s1, s2);
    }

    @NotNull
    public final String component1() {
        return this.type;
    }

    @Nullable
    public final Double component2() {
        return this.duration;
    }

    @Nullable
    public final Integer component3() {
        return this.ndvrWindowSize;
    }

    @Nullable
    public final String component4() {
        return this.liveStartTime;
    }

    @Nullable
    public final String component5() {
        return this.liveEndTime;
    }

    @NotNull
    public final MediaProperties copy(@i(name = "type") @NotNull String s, @i(name = "duration") @Nullable Double double0, @i(name = "ndvr_window_size") @Nullable Integer integer0, @i(name = "live_start_time") @Nullable String s1, @i(name = "live_end_time") @Nullable String s2) {
        q.g(s, "type");
        return new MediaProperties(s, double0, integer0, s1, s2);
    }

    public static MediaProperties copy$default(MediaProperties mediaProperties0, String s, Double double0, Integer integer0, String s1, String s2, int v, Object object0) {
        if((v & 1) != 0) {
            s = mediaProperties0.type;
        }
        if((v & 2) != 0) {
            double0 = mediaProperties0.duration;
        }
        if((v & 4) != 0) {
            integer0 = mediaProperties0.ndvrWindowSize;
        }
        if((v & 8) != 0) {
            s1 = mediaProperties0.liveStartTime;
        }
        if((v & 16) != 0) {
            s2 = mediaProperties0.liveEndTime;
        }
        return mediaProperties0.copy(s, double0, integer0, s1, s2);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof MediaProperties)) {
            return false;
        }
        if(!q.b(this.type, ((MediaProperties)object0).type)) {
            return false;
        }
        if(!q.b(this.duration, ((MediaProperties)object0).duration)) {
            return false;
        }
        if(!q.b(this.ndvrWindowSize, ((MediaProperties)object0).ndvrWindowSize)) {
            return false;
        }
        return q.b(this.liveStartTime, ((MediaProperties)object0).liveStartTime) ? q.b(this.liveEndTime, ((MediaProperties)object0).liveEndTime) : false;
    }

    @Nullable
    public final Double getDuration() {
        return this.duration;
    }

    @Nullable
    public final String getLiveEndTime() {
        return this.liveEndTime;
    }

    @Nullable
    public final String getLiveStartTime() {
        return this.liveStartTime;
    }

    @Nullable
    public final Integer getNdvrWindowSize() {
        return this.ndvrWindowSize;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Override
    public int hashCode() {
        int v = this.type.hashCode();
        int v1 = 0;
        int v2 = this.duration == null ? 0 : this.duration.hashCode();
        int v3 = this.ndvrWindowSize == null ? 0 : this.ndvrWindowSize.hashCode();
        int v4 = this.liveStartTime == null ? 0 : this.liveStartTime.hashCode();
        String s = this.liveEndTime;
        if(s != null) {
            v1 = s.hashCode();
        }
        return (((v * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v1;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("MediaProperties(type=");
        stringBuilder0.append(this.type);
        stringBuilder0.append(", duration=");
        stringBuilder0.append(this.duration);
        stringBuilder0.append(", ndvrWindowSize=");
        stringBuilder0.append(this.ndvrWindowSize);
        stringBuilder0.append(", liveStartTime=");
        stringBuilder0.append(this.liveStartTime);
        stringBuilder0.append(", liveEndTime=");
        return o.r(stringBuilder0, this.liveEndTime, ')');
    }
}

