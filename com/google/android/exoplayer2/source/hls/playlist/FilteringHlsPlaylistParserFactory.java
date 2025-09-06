package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.offline.FilteringManifestParser;
import com.google.android.exoplayer2.upstream.ParsingLoadable.Parser;
import java.util.List;

public final class FilteringHlsPlaylistParserFactory implements HlsPlaylistParserFactory {
    private final HlsPlaylistParserFactory hlsPlaylistParserFactory;
    private final List streamKeys;

    public FilteringHlsPlaylistParserFactory(HlsPlaylistParserFactory hlsPlaylistParserFactory0, List list0) {
        this.hlsPlaylistParserFactory = hlsPlaylistParserFactory0;
        this.streamKeys = list0;
    }

    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory
    public Parser createPlaylistParser() {
        return new FilteringManifestParser(this.hlsPlaylistParserFactory.createPlaylistParser(), this.streamKeys);
    }

    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory
    public Parser createPlaylistParser(HlsMasterPlaylist hlsMasterPlaylist0) {
        return new FilteringManifestParser(this.hlsPlaylistParserFactory.createPlaylistParser(hlsMasterPlaylist0), this.streamKeys);
    }
}

