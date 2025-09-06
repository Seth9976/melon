package com.iloen.melon.playback.playlist.sol;

import ge.b;
import y8.w;

public final class PlaylistSolMetaRepository_Factory implements b {
    private final b remoteDataSourceProvider;

    public PlaylistSolMetaRepository_Factory(b b0) {
        this.remoteDataSourceProvider = b0;
    }

    public static PlaylistSolMetaRepository_Factory create(b b0) {
        return new PlaylistSolMetaRepository_Factory(b0);
    }

    public PlaylistSolMetaRepository get() {
        return PlaylistSolMetaRepository_Factory.newInstance(((w)this.remoteDataSourceProvider.get()));
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static PlaylistSolMetaRepository newInstance(w w0) {
        return new PlaylistSolMetaRepository(w0);
    }
}

