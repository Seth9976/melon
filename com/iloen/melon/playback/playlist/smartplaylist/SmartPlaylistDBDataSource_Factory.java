package com.iloen.melon.playback.playlist.smartplaylist;

import com.iloen.melon.playback.playlist.db.SmartPlaylistDao;
import ge.b;

public final class SmartPlaylistDBDataSource_Factory implements b {
    private final b playlistDaoProvider;

    public SmartPlaylistDBDataSource_Factory(b b0) {
        this.playlistDaoProvider = b0;
    }

    public static SmartPlaylistDBDataSource_Factory create(b b0) {
        return new SmartPlaylistDBDataSource_Factory(b0);
    }

    public SmartPlaylistDBDataSource get() {
        return SmartPlaylistDBDataSource_Factory.newInstance(((SmartPlaylistDao)this.playlistDaoProvider.get()));
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static SmartPlaylistDBDataSource newInstance(SmartPlaylistDao smartPlaylistDao0) {
        return new SmartPlaylistDBDataSource(smartPlaylistDao0);
    }
}

