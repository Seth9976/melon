package com.iloen.melon.fragments.local;

public final class w implements Runnable {
    public final LocalPlaylistDetailEditFragment a;

    public w(LocalPlaylistDetailEditFragment localPlaylistDetailEditFragment0) {
        this.a = localPlaylistDetailEditFragment0;
    }

    @Override
    public final void run() {
        LocalPlaylistDetailEditFragment.onViewCreated$lambda$1(this.a);
    }
}

