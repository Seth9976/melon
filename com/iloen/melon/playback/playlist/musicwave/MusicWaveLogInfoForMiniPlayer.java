package com.iloen.melon.playback.playlist.musicwave;

import A7.d;
import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000B\u0010\f\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\r\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u000E\u001A\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000F\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveLogInfoForMiniPlayer;", "", "key", "", "title", "menuId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getTitle", "getMenuId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWaveLogInfoForMiniPlayer {
    public static final int $stable;
    @Nullable
    private final String key;
    @Nullable
    private final String menuId;
    @Nullable
    private final String title;

    public MusicWaveLogInfoForMiniPlayer(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        this.key = s;
        this.title = s1;
        this.menuId = s2;
    }

    @Nullable
    public final String component1() {
        return this.key;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.menuId;
    }

    @NotNull
    public final MusicWaveLogInfoForMiniPlayer copy(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        return new MusicWaveLogInfoForMiniPlayer(s, s1, s2);
    }

    public static MusicWaveLogInfoForMiniPlayer copy$default(MusicWaveLogInfoForMiniPlayer musicWaveLogInfoForMiniPlayer0, String s, String s1, String s2, int v, Object object0) {
        if((v & 1) != 0) {
            s = musicWaveLogInfoForMiniPlayer0.key;
        }
        if((v & 2) != 0) {
            s1 = musicWaveLogInfoForMiniPlayer0.title;
        }
        if((v & 4) != 0) {
            s2 = musicWaveLogInfoForMiniPlayer0.menuId;
        }
        return musicWaveLogInfoForMiniPlayer0.copy(s, s1, s2);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof MusicWaveLogInfoForMiniPlayer)) {
            return false;
        }
        if(!q.b(this.key, ((MusicWaveLogInfoForMiniPlayer)object0).key)) {
            return false;
        }
        return q.b(this.title, ((MusicWaveLogInfoForMiniPlayer)object0).title) ? q.b(this.menuId, ((MusicWaveLogInfoForMiniPlayer)object0).menuId) : false;
    }

    @Nullable
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final String getMenuId() {
        return this.menuId;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.key == null ? 0 : this.key.hashCode();
        int v2 = this.title == null ? 0 : this.title.hashCode();
        String s = this.menuId;
        if(s != null) {
            v = s.hashCode();
        }
        return (v1 * 0x1F + v2) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return x.m(d.o("MusicWaveLogInfoForMiniPlayer(key=", this.key, ", title=", this.title, ", menuId="), this.menuId, ")");
    }
}

