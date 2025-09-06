package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;

public final class a implements Factory {
    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$Factory
    public final HlsPlaylistTracker createTracker(HlsDataSourceFactory hlsDataSourceFactory0, LoadErrorHandlingPolicy loadErrorHandlingPolicy0, HlsPlaylistParserFactory hlsPlaylistParserFactory0) {
        return new DefaultHlsPlaylistTracker(hlsDataSourceFactory0, loadErrorHandlingPolicy0, hlsPlaylistParserFactory0);
    }
}

