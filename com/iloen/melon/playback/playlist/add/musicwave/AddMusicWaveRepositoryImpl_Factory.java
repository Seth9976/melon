package com.iloen.melon.playback.playlist.add.musicwave;

import ge.b;

public final class AddMusicWaveRepositoryImpl_Factory implements b {
    private final b dataSourceProvider;

    public AddMusicWaveRepositoryImpl_Factory(b b0) {
        this.dataSourceProvider = b0;
    }

    public static AddMusicWaveRepositoryImpl_Factory create(b b0) {
        return new AddMusicWaveRepositoryImpl_Factory(b0);
    }

    public AddMusicWaveRepositoryImpl get() {
        return AddMusicWaveRepositoryImpl_Factory.newInstance(((AddMusicWaveDataSource)this.dataSourceProvider.get()));
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static AddMusicWaveRepositoryImpl newInstance(AddMusicWaveDataSource addMusicWaveDataSource0) {
        return new AddMusicWaveRepositoryImpl(addMusicWaveDataSource0);
    }
}

