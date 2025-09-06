package com.iloen.melon.player.playlist.music;

import ge.b;

public final class MusicPlaylistViewModel_HiltModules_KeyModule_ProvideFactory implements b {
    static final class InstanceHolder {
        public static final MusicPlaylistViewModel_HiltModules_KeyModule_ProvideFactory a;

        static {
            InstanceHolder.a = new MusicPlaylistViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public static MusicPlaylistViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.a;
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

