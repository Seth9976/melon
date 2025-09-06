package com.iloen.melon.fragments.mymusic.playlist;

import ge.b;

public final class ImageToPlaylistViewModel_HiltModules_KeyModule_ProvideFactory implements b {
    static final class InstanceHolder {
        static final ImageToPlaylistViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE;

        static {
            InstanceHolder.INSTANCE = new ImageToPlaylistViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public static ImageToPlaylistViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    // 去混淆评级： 低(20)
    public Boolean get() {
        return true;
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static boolean provide() [...] // 潜在的解密器
}

