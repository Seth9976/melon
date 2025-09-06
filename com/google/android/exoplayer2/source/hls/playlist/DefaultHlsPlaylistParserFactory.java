package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.upstream.ParsingLoadable.Parser;

public final class DefaultHlsPlaylistParserFactory implements HlsPlaylistParserFactory {
    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory
    public Parser createPlaylistParser() {
        return new HlsPlaylistParser();
    }

    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory
    public Parser createPlaylistParser(HlsMasterPlaylist hlsMasterPlaylist0) {
        return new HlsPlaylistParser(hlsMasterPlaylist0);
    }
}

