package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.upstream.ParsingLoadable.Parser;

public interface HlsPlaylistParserFactory {
    Parser createPlaylistParser();

    Parser createPlaylistParser(HlsMasterPlaylist arg1);
}

