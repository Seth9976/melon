package com.iloen.melon.player.playlist;

import ge.b;

public final class PlaylistMainViewModel_HiltModules_KeyModule_ProvideFactory implements b {
    static final class InstanceHolder {
        public static final PlaylistMainViewModel_HiltModules_KeyModule_ProvideFactory a;

        static {
            InstanceHolder.a = new PlaylistMainViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public static PlaylistMainViewModel_HiltModules_KeyModule_ProvideFactory create() {
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

