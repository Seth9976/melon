package com.iloen.melon.popup;

import ge.b;

public final class RemoteConnectPopupViewModel_HiltModules_KeyModule_ProvideFactory implements b {
    static final class InstanceHolder {
        public static final RemoteConnectPopupViewModel_HiltModules_KeyModule_ProvideFactory a;

        static {
            InstanceHolder.a = new RemoteConnectPopupViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public static RemoteConnectPopupViewModel_HiltModules_KeyModule_ProvideFactory create() {
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

