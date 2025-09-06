package com.iloen.melon.playback.playlist.db.entity;

import G8.g;
import H8.k;
import android.net.Uri;
import android.text.TextUtils;
import com.iloen.melon.constants.CType;
import com.iloen.melon.playback.Playable.Builder;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z6.f;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004¨\u0006\u0005"}, d2 = {"convertToPlayable", "Lcom/iloen/melon/playback/Playable;", "Lcom/iloen/melon/playback/playlist/db/entity/PlayableEntity;", "trackId", "", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class PlayableEntityKt {
    @NotNull
    public static final Playable convertToPlayable(@NotNull PlayableEntity playableEntity0, @Nullable String s) {
        String s4;
        k k0;
        q.g(playableEntity0, "<this>");
        String s1 = playableEntity0.getMenuId();
        CType cType0 = CType.get(playableEntity0.getCType());
        String s2 = playableEntity0.getUriString();
        long v = -1L;
        String s3 = "";
        if(playableEntity0.getOrigin() == 1) {
            boolean z = StorageUtils.isScopedStorage();
            f f0 = g.a;
            if(!z) {
                f0.m();
                k0 = g.k(playableEntity0.getData());
            }
            else if(playableEntity0.getUriString().length() == 0 && playableEntity0.getData().length() > 0) {
                f0.m();
                k0 = g.k(playableEntity0.getData());
            }
            else {
                f0.m();
                Uri uri0 = Uri.parse(playableEntity0.getUriString());
                q.f(uri0, "parse(...)");
                k0 = g.j(uri0);
            }
            if(k0 == null) {
                s4 = "";
            }
            else {
                v = k0.w;
                s4 = k0.p;
            }
            if(StorageUtils.isScopedStorage() && playableEntity0.getUriString().length() == 0) {
                if(k0 == null) {
                    s2 = "";
                }
                else {
                    s2 = k0.c;
                    if(s2 == null) {
                        s2 = "";
                    }
                }
            }
            s3 = s4;
        }
        Builder playable$Builder0 = Playable.newBuilder(playableEntity0.getOrigin()).data(playableEntity0.getData()).songIdTitle(playableEntity0.getSongId(), playableEntity0.getTitle()).artists(StringUtils.makeArtistMap(playableEntity0.getArtistId(), playableEntity0.getArtist())).albumIdName(playableEntity0.getAlbumId(), playableEntity0.getAlbum()).albumImg(playableEntity0.getAlbumImgPath()).albumImgThumb(playableEntity0.getAlbumThumbPath()).duration(playableEntity0.getDuration()).cType(playableEntity0.getCType());
        if(TextUtils.isEmpty(s1)) {
            s1 = q.b(cType0, CType.SONG) ? "1000000558" : "1000000562";
        }
        Playable playable0 = playable$Builder0.menuId(s1).hasMv(playableEntity0.getHasMv()).mvTitle(playableEntity0.getMvName()).mvId(playableEntity0.getMvId()).isAdult(playableEntity0.isAdult()).playCount(playableEntity0.getPlayCount()).isFree(playableEntity0.isFree()).isHitsong(playableEntity0.isHitSong()).isHoldback(playableEntity0.isHoldBack()).isTitle(playableEntity0.isTitle()).order(playableEntity0.getDisplayOrder()).originMenuId(playableEntity0.getOriginMenuId()).statsElements(playableEntity0.getStatsElements()).uriString(s2).displayName(playableEntity0.getDisplayName()).mediaStoreAlbumId(v).localAlbumKey(s3).trackId(s).build();
        playable0.setCreatedAt(playableEntity0.getCreatedAt());
        playable0.setCreatedSeq(playableEntity0.getCreatedSeq());
        return playable0;
    }
}

