package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;

public final class HlsManifest {
    public final HlsMasterPlaylist masterPlaylist;
    public final HlsMediaPlaylist mediaPlaylist;

    public HlsManifest(HlsMasterPlaylist hlsMasterPlaylist0, HlsMediaPlaylist hlsMediaPlaylist0) {
        this.masterPlaylist = hlsMasterPlaylist0;
        this.mediaPlaylist = hlsMediaPlaylist0;
    }
}

