package com.iloen.melon.playback.playlist.add.musicwave;

import Ba.B;
import ge.b;

public final class AddMusicWaveDataSource_Factory implements b {
    private final b apiProvider;

    public AddMusicWaveDataSource_Factory(b b0) {
        this.apiProvider = b0;
    }

    public static AddMusicWaveDataSource_Factory create(b b0) {
        return new AddMusicWaveDataSource_Factory(b0);
    }

    public AddMusicWaveDataSource get() {
        return AddMusicWaveDataSource_Factory.newInstance(((B)this.apiProvider.get()));
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static AddMusicWaveDataSource newInstance(B b0) {
        return new AddMusicWaveDataSource(b0);
    }
}

