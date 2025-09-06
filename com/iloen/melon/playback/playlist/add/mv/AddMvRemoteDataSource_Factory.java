package com.iloen.melon.playback.playlist.add.mv;

import Ba.Q;
import Ba.x;
import ge.b;

public final class AddMvRemoteDataSource_Factory implements b {
    private final b tvApiProvider;
    private final b vodApiProvider;

    public AddMvRemoteDataSource_Factory(b b0, b b1) {
        this.tvApiProvider = b0;
        this.vodApiProvider = b1;
    }

    public static AddMvRemoteDataSource_Factory create(b b0, b b1) {
        return new AddMvRemoteDataSource_Factory(b0, b1);
    }

    public AddMvRemoteDataSource get() {
        return AddMvRemoteDataSource_Factory.newInstance(((x)this.tvApiProvider.get()), ((Q)this.vodApiProvider.get()));
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static AddMvRemoteDataSource newInstance(x x0, Q q0) {
        return new AddMvRemoteDataSource(x0, q0);
    }
}

