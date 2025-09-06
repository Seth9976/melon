package com.kakaoent.leonplayer.core.model.data.player;

import androidx.appcompat.app.o;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001A\u00020\u0003HÆ\u0003J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\u000B\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/player/LeonMediaTime;", "", "position", "", "duration", "(II)V", "getDuration", "()I", "getPosition", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LeonMediaTime {
    private final int duration;
    private final int position;

    public LeonMediaTime(int v, int v1) {
        this.position = v;
        this.duration = v1;
    }

    public final int component1() {
        return this.position;
    }

    public final int component2() {
        return this.duration;
    }

    @NotNull
    public final LeonMediaTime copy(int v, int v1) {
        return new LeonMediaTime(v, v1);
    }

    public static LeonMediaTime copy$default(LeonMediaTime leonMediaTime0, int v, int v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = leonMediaTime0.position;
        }
        if((v2 & 2) != 0) {
            v1 = leonMediaTime0.duration;
        }
        return leonMediaTime0.copy(v, v1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof LeonMediaTime)) {
            return false;
        }
        return this.position == ((LeonMediaTime)object0).position ? this.duration == ((LeonMediaTime)object0).duration : false;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getPosition() {
        return this.position;
    }

    @Override
    public int hashCode() {
        return this.duration + this.position * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("LeonMediaTime(position=");
        stringBuilder0.append(this.position);
        stringBuilder0.append(", duration=");
        return o.q(stringBuilder0, this.duration, ')');
    }
}

