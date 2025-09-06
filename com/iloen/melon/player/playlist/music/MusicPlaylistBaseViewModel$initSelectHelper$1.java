package com.iloen.melon.player.playlist.music;

import Ud.e;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001F\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/iloen/melon/player/playlist/music/MusicPlaylistBaseViewModel$initSelectHelper$1", "LUd/e;", "Lcom/iloen/melon/player/playlist/music/SongUiState;", "state", "", "select", "onChange", "(Lcom/iloen/melon/player/playlist/music/SongUiState;Z)Lcom/iloen/melon/player/playlist/music/SongUiState;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicPlaylistBaseViewModel.initSelectHelper.1 implements e {
    public SongUiState onChange(SongUiState songUiState0, boolean z) {
        q.g(songUiState0, "state");
        return SongUiState.copy$default(songUiState0, null, null, null, null, null, z, false, false, false, null, 0x3DF, null);
    }

    @Override  // Ud.e
    public Object onChange(Object object0, boolean z) {
        return this.onChange(((SongUiState)object0), z);
    }
}

