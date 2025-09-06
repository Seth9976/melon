package com.iloen.melon.playback;

import com.iloen.melon.playback.playlist.db.entity.MixUpEntity;
import com.iloen.melon.playback.playlist.db.entity.MusicEntity;
import com.iloen.melon.playback.playlist.db.entity.PlayableEntity;
import com.iloen.melon.playback.playlist.db.entity.SmartEntity;
import com.iloen.melon.types.Song;
import e.k;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0003\u001A\u00020\u0004*\u00020\u0002\u001A\n\u0010\u0005\u001A\u00020\u0006*\u00020\u0002\u001A\n\u0010\u0007\u001A\u00020\b*\u00020\u0002\u001A\n\u0010\t\u001A\u00020\u0002*\u00020\u0002\u001A\n\u0010\n\u001A\u00020\u0002*\u00020\u0002\u001A\f\u0010\u000B\u001A\u00020\b*\u0004\u0018\u00010\u0002¨\u0006\f"}, d2 = {"toMusicEntity", "Lcom/iloen/melon/playback/playlist/db/entity/MusicEntity;", "Lcom/iloen/melon/playback/Playable;", "toSmartEntity", "Lcom/iloen/melon/playback/playlist/db/entity/SmartEntity;", "toMixUpEntity", "Lcom/iloen/melon/playback/playlist/db/entity/MixUpEntity;", "isDolby", "", "copyAndUpdatedWhenLocal", "copyAndUpdateStreaming", "isMvEnabled", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class PlayableExtensionsKt {
    @NotNull
    public static final Playable copyAndUpdateStreaming(@NotNull Playable playable0) {
        q.g(playable0, "<this>");
        Playable playable1 = Playable.copyValueOfWithNewTrackIdAndOriginMelon(playable0);
        playable1.setData("");
        playable1.setUriString("");
        return playable1;
    }

    @NotNull
    public static final Playable copyAndUpdatedWhenLocal(@NotNull Playable playable0) {
        q.g(playable0, "<this>");
        if(playable0.isOriginLocal()) {
            playable0 = Playable.copyValueOf(playable0);
            playable0.updateFrom(Song.e(playable0, true));
        }
        return playable0;
    }

    // 去混淆评级： 低(20)
    public static final boolean isDolby(@NotNull Playable playable0) {
        q.g(playable0, "<this>");
        return !playable0.isOriginLocal() && k.A(new String[]{"AC4", "EC3"}).contains("");
    }

    public static final boolean isMvEnabled(@Nullable Playable playable0) {
        boolean z2;
        if(playable0 == null) {
            return false;
        }
        boolean z = playable0.isTypeOfMv();
        int v = 0;
        boolean z1 = playable0.hasSongId();
        if(playable0.isMelonSong()) {
            if(!z) {
                v = z1;
            }
            z2 = v == 0 ? false : true;
        }
        else {
            z2 = false;
        }
        if(z2) {
            return playable0.isOriginMelon() ? playable0.hasMv() : true;
        }
        return false;
    }

    @NotNull
    public static final MixUpEntity toMixUpEntity(@NotNull Playable playable0) {
        q.g(playable0, "<this>");
        String s = playable0.getTrackId();
        q.f(s, "getTrackId(...)");
        return new MixUpEntity(s, PlayableEntity.Companion.newInstance(playable0));
    }

    @NotNull
    public static final MusicEntity toMusicEntity(@NotNull Playable playable0) {
        q.g(playable0, "<this>");
        String s = playable0.getTrackId();
        q.f(s, "getTrackId(...)");
        return new MusicEntity(s, PlayableEntity.Companion.newInstance(playable0));
    }

    @NotNull
    public static final SmartEntity toSmartEntity(@NotNull Playable playable0) {
        q.g(playable0, "<this>");
        String s = playable0.getTrackId();
        q.f(s, "getTrackId(...)");
        return new SmartEntity(s, PlayableEntity.Companion.newInstance(playable0));
    }
}

