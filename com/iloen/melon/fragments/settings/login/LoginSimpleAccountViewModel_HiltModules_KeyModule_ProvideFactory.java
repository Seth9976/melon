package com.iloen.melon.fragments.settings.login;

import ge.b;

public final class LoginSimpleAccountViewModel_HiltModules_KeyModule_ProvideFactory implements b {
    static final class InstanceHolder {
        static final LoginSimpleAccountViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE;

        static {
            InstanceHolder.INSTANCE = new LoginSimpleAccountViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public static LoginSimpleAccountViewModel_HiltModules_KeyModule_ProvideFactory create() {
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

