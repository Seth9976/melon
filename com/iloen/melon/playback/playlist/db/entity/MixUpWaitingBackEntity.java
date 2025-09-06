package com.iloen.melon.playback.playlist.db.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/playback/playlist/db/entity/MixUpWaitingBackEntity;", "", "trackId", "", "playableEntity", "Lcom/iloen/melon/playback/playlist/db/entity/PlayableEntity;", "<init>", "(Ljava/lang/String;Lcom/iloen/melon/playback/playlist/db/entity/PlayableEntity;)V", "getTrackId", "()Ljava/lang/String;", "getPlayableEntity", "()Lcom/iloen/melon/playback/playlist/db/entity/PlayableEntity;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MixUpWaitingBackEntity {
    public static final int $stable;
    @NotNull
    private final PlayableEntity playableEntity;
    @NotNull
    private final String trackId;

    public MixUpWaitingBackEntity(@NotNull String s, @NotNull PlayableEntity playableEntity0) {
        q.g(s, "trackId");
        q.g(playableEntity0, "playableEntity");
        super();
        this.trackId = s;
        this.playableEntity = playableEntity0;
    }

    @NotNull
    public final String component1() {
        return this.trackId;
    }

    @NotNull
    public final PlayableEntity component2() {
        return this.playableEntity;
    }

    @NotNull
    public final MixUpWaitingBackEntity copy(@NotNull String s, @NotNull PlayableEntity playableEntity0) {
        q.g(s, "trackId");
        q.g(playableEntity0, "playableEntity");
        return new MixUpWaitingBackEntity(s, playableEntity0);
    }

    public static MixUpWaitingBackEntity copy$default(MixUpWaitingBackEntity mixUpWaitingBackEntity0, String s, PlayableEntity playableEntity0, int v, Object object0) {
        if((v & 1) != 0) {
            s = mixUpWaitingBackEntity0.trackId;
        }
        if((v & 2) != 0) {
            playableEntity0 = mixUpWaitingBackEntity0.playableEntity;
        }
        return mixUpWaitingBackEntity0.copy(s, playableEntity0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof MixUpWaitingBackEntity)) {
            return false;
        }
        return q.b(this.trackId, ((MixUpWaitingBackEntity)object0).trackId) ? q.b(this.playableEntity, ((MixUpWaitingBackEntity)object0).playableEntity) : false;
    }

    @NotNull
    public final PlayableEntity getPlayableEntity() {
        return this.playableEntity;
    }

    @NotNull
    public final String getTrackId() {
        return this.trackId;
    }

    @Override
    public int hashCode() {
        return this.playableEntity.hashCode() + this.trackId.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "MixUpWaitingBackEntity(trackId=" + this.trackId + ", playableEntity=" + this.playableEntity + ")";
    }
}

