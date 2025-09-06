package com.kakaoent.leonplayer.core.model.data.player;

import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\t\u0010\f\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/player/LeonTimedMeta;", "", "timeStamp", "", "data", "", "(JLjava/lang/String;)V", "getData", "()Ljava/lang/String;", "getTimeStamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LeonTimedMeta {
    @NotNull
    private final String data;
    private final long timeStamp;

    public LeonTimedMeta(long v, @NotNull String s) {
        q.g(s, "data");
        super();
        this.timeStamp = v;
        this.data = s;
    }

    public final long component1() {
        return this.timeStamp;
    }

    @NotNull
    public final String component2() {
        return this.data;
    }

    @NotNull
    public final LeonTimedMeta copy(long v, @NotNull String s) {
        q.g(s, "data");
        return new LeonTimedMeta(v, s);
    }

    public static LeonTimedMeta copy$default(LeonTimedMeta leonTimedMeta0, long v, String s, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = leonTimedMeta0.timeStamp;
        }
        if((v1 & 2) != 0) {
            s = leonTimedMeta0.data;
        }
        return leonTimedMeta0.copy(v, s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof LeonTimedMeta)) {
            return false;
        }
        return this.timeStamp == ((LeonTimedMeta)object0).timeStamp ? q.b(this.data, ((LeonTimedMeta)object0).data) : false;
    }

    @NotNull
    public final String getData() {
        return this.data;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public int hashCode() {
        return this.data.hashCode() + Long.hashCode(this.timeStamp) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("LeonTimedMeta(timeStamp=");
        stringBuilder0.append(this.timeStamp);
        stringBuilder0.append(", data=");
        return o.r(stringBuilder0, this.data, ')');
    }
}

