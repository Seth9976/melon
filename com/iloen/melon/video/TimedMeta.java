package com.iloen.melon.video;

import A7.d;
import U4.x;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0013\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J;\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001J\t\u0010\u001B\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000BR\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000B¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/video/TimedMeta;", "", "key", "", "song", "vote", "notice", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getSong", "getVote", "getNotice", "getMessage", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TimedMeta {
    public static final int $stable;
    @NotNull
    private final String key;
    @NotNull
    private final String message;
    @NotNull
    private final String notice;
    @NotNull
    private final String song;
    @NotNull
    private final String vote;

    public TimedMeta(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4) {
        q.g(s, "key");
        q.g(s1, "song");
        q.g(s2, "vote");
        q.g(s3, "notice");
        q.g(s4, "message");
        super();
        this.key = s;
        this.song = s1;
        this.vote = s2;
        this.notice = s3;
        this.message = s4;
    }

    @NotNull
    public final String component1() {
        return this.key;
    }

    @NotNull
    public final String component2() {
        return this.song;
    }

    @NotNull
    public final String component3() {
        return this.vote;
    }

    @NotNull
    public final String component4() {
        return this.notice;
    }

    @NotNull
    public final String component5() {
        return this.message;
    }

    @NotNull
    public final TimedMeta copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4) {
        q.g(s, "key");
        q.g(s1, "song");
        q.g(s2, "vote");
        q.g(s3, "notice");
        q.g(s4, "message");
        return new TimedMeta(s, s1, s2, s3, s4);
    }

    public static TimedMeta copy$default(TimedMeta timedMeta0, String s, String s1, String s2, String s3, String s4, int v, Object object0) {
        if((v & 1) != 0) {
            s = timedMeta0.key;
        }
        if((v & 2) != 0) {
            s1 = timedMeta0.song;
        }
        if((v & 4) != 0) {
            s2 = timedMeta0.vote;
        }
        if((v & 8) != 0) {
            s3 = timedMeta0.notice;
        }
        if((v & 16) != 0) {
            s4 = timedMeta0.message;
        }
        return timedMeta0.copy(s, s1, s2, s3, s4);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof TimedMeta)) {
            return false;
        }
        if(!q.b(this.key, ((TimedMeta)object0).key)) {
            return false;
        }
        if(!q.b(this.song, ((TimedMeta)object0).song)) {
            return false;
        }
        if(!q.b(this.vote, ((TimedMeta)object0).vote)) {
            return false;
        }
        return q.b(this.notice, ((TimedMeta)object0).notice) ? q.b(this.message, ((TimedMeta)object0).message) : false;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final String getNotice() {
        return this.notice;
    }

    @NotNull
    public final String getSong() {
        return this.song;
    }

    @NotNull
    public final String getVote() {
        return this.vote;
    }

    @Override
    public int hashCode() {
        return this.message.hashCode() + x.b(x.b(x.b(this.key.hashCode() * 0x1F, 0x1F, this.song), 0x1F, this.vote), 0x1F, this.notice);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = d.o("TimedMeta(key=", this.key, ", song=", this.song, ", vote=");
        d.u(stringBuilder0, this.vote, ", notice=", this.notice, ", message=");
        return x.m(stringBuilder0, this.message, ")");
    }
}

