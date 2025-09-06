package com.kakaoent.trevi.ad.data;

import H0.b;
import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001A\u00020\u00052\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/kakaoent/trevi/ad/data/VideoState;", "", "positionMs", "", "isMute", "", "(JZ)V", "()Z", "getPositionMs", "()J", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class VideoState {
    private final boolean isMute;
    private final long positionMs;

    public VideoState(long v, boolean z) {
        this.positionMs = v;
        this.isMute = z;
    }

    public final long component1() {
        return this.positionMs;
    }

    public final boolean component2() {
        return this.isMute;
    }

    @NotNull
    public final VideoState copy(long v, boolean z) {
        return new VideoState(v, z);
    }

    public static VideoState copy$default(VideoState videoState0, long v, boolean z, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = videoState0.positionMs;
        }
        if((v1 & 2) != 0) {
            z = videoState0.isMute;
        }
        return videoState0.copy(v, z);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof VideoState)) {
            return false;
        }
        return this.positionMs == ((VideoState)object0).positionMs ? this.isMute == ((VideoState)object0).isMute : false;
    }

    public final long getPositionMs() {
        return this.positionMs;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(this.isMute) + Long.hashCode(this.positionMs) * 0x1F;
    }

    public final boolean isMute() {
        return this.isMute;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("VideoState(positionMs=");
        stringBuilder0.append(this.positionMs);
        stringBuilder0.append(", isMute=");
        return b.k(stringBuilder0, this.isMute, ')');
    }
}

