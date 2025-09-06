package com.iloen.melon.playback.playlist.add.mv;

import ge.b;

public final class AddMVRepositoryImpl_Factory implements b {
    private final b remoteDatasourceProvider;

    public AddMVRepositoryImpl_Factory(b b0) {
        this.remoteDatasourceProvider = b0;
    }

    public static AddMVRepositoryImpl_Factory create(b b0) {
        return new AddMVRepositoryImpl_Factory(b0);
    }

    public AddMVRepositoryImpl get() {
        return AddMVRepositoryImpl_Factory.newInstance(((AddMvRemoteDataSource)this.remoteDatasourceProvider.get()));
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static AddMVRepositoryImpl newInstance(AddMvRemoteDataSource addMvRemoteDataSource0) {
        return new AddMVRepositoryImpl(addMvRemoteDataSource0);
    }
}

