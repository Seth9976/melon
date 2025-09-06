package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;

public interface HlsPlaylistTracker {
    public interface Factory {
        HlsPlaylistTracker createTracker(HlsDataSourceFactory arg1, LoadErrorHandlingPolicy arg2, HlsPlaylistParserFactory arg3);
    }

    public interface PlaylistEventListener {
        void onPlaylistChanged();

        boolean onPlaylistError(Uri arg1, long arg2);
    }

    public static final class PlaylistResetException extends IOException {
        public final Uri url;

        public PlaylistResetException(Uri uri0) {
            this.url = uri0;
        }
    }

    public static final class PlaylistStuckException extends IOException {
        public final Uri url;

        public PlaylistStuckException(Uri uri0) {
            this.url = uri0;
        }
    }

    public interface PrimaryPlaylistListener {
        void onPrimaryPlaylistRefreshed(HlsMediaPlaylist arg1);
    }

    void addListener(PlaylistEventListener arg1);

    long getInitialStartTimeUs();

    HlsMasterPlaylist getMasterPlaylist();

    HlsMediaPlaylist getPlaylistSnapshot(Uri arg1, boolean arg2);

    boolean isLive();

    boolean isSnapshotValid(Uri arg1);

    void maybeThrowPlaylistRefreshError(Uri arg1);

    void maybeThrowPrimaryPlaylistRefreshError();

    void refreshPlaylist(Uri arg1);

    void removeListener(PlaylistEventListener arg1);

    void start(Uri arg1, EventDispatcher arg2, PrimaryPlaylistListener arg3);

    void stop();
}

