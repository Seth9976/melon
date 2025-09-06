package com.iloen.melon.playback.playlist.musicwave;

import Ba.B;
import ge.b;

public final class MusicWavePlaylistRemoteDataSource_Factory implements b {
    private final b apiProvider;

    public MusicWavePlaylistRemoteDataSource_Factory(b b0) {
        this.apiProvider = b0;
    }

    public static MusicWavePlaylistRemoteDataSource_Factory create(b b0) {
        return new MusicWavePlaylistRemoteDataSource_Factory(b0);
    }

    public MusicWavePlaylistRemoteDataSource get() {
        return MusicWavePlaylistRemoteDataSource_Factory.newInstance(((B)this.apiProvider.get()));
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static MusicWavePlaylistRemoteDataSource newInstance(B b0) {
        return new MusicWavePlaylistRemoteDataSource(b0);
    }
}

