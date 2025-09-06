package com.iloen.melon.playback.playlist.musicwave;

import ge.b;

public final class MusicWavePlaylistRepositoryImpl_Factory implements b {
    private final b remoteDataSourceProvider;

    public MusicWavePlaylistRepositoryImpl_Factory(b b0) {
        this.remoteDataSourceProvider = b0;
    }

    public static MusicWavePlaylistRepositoryImpl_Factory create(b b0) {
        return new MusicWavePlaylistRepositoryImpl_Factory(b0);
    }

    public MusicWavePlaylistRepositoryImpl get() {
        return MusicWavePlaylistRepositoryImpl_Factory.newInstance(((MusicWavePlaylistRemoteDataSource)this.remoteDataSourceProvider.get()));
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static MusicWavePlaylistRepositoryImpl newInstance(MusicWavePlaylistRemoteDataSource musicWavePlaylistRemoteDataSource0) {
        return new MusicWavePlaylistRepositoryImpl(musicWavePlaylistRemoteDataSource0);
    }
}

