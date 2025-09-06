package com.iloen.melon.fragments.settings.login;

import eb.u;
import ge.b;
import k8.a;
import mb.k;
import mb.n;
import mb.o;

public final class LoginSimpleAccountViewModel_Factory implements b {
    private final b dialogManageProvider;
    private final b loginUseCaseProvider;
    private final b pvUseCaseProvider;
    private final b screenCaptureUseCaseProvider;
    private final b simpleAccountRemoveExplicitlyUseCaseProvider;
    private final b simpleAccountUseCaseProvider;

    public LoginSimpleAccountViewModel_Factory(b b0, b b1, b b2, b b3, b b4, b b5) {
        this.simpleAccountUseCaseProvider = b0;
        this.loginUseCaseProvider = b1;
        this.simpleAccountRemoveExplicitlyUseCaseProvider = b2;
        this.dialogManageProvider = b3;
        this.pvUseCaseProvider = b4;
        this.screenCaptureUseCaseProvider = b5;
    }

    public static LoginSimpleAccountViewModel_Factory create(b b0, b b1, b b2, b b3, b b4, b b5) {
        return new LoginSimpleAccountViewModel_Factory(b0, b1, b2, b3, b4, b5);
    }

    public LoginSimpleAccountViewModel get() {
        LoginSimpleAccountViewModel loginSimpleAccountViewModel0 = LoginSimpleAccountViewModel_Factory.newInstance(((o)this.simpleAccountUseCaseProvider.get()), ((k)this.loginUseCaseProvider.get()), ((n)this.simpleAccountRemoveExplicitlyUseCaseProvider.get()), ((a)this.dialogManageProvider.get()));
        loginSimpleAccountViewModel0.pvUseCase = (eb.n)this.pvUseCaseProvider.get();
        loginSimpleAccountViewModel0.screenCaptureUseCase = (u)this.screenCaptureUseCaseProvider.get();
        return loginSimpleAccountViewModel0;
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static LoginSimpleAccountViewModel newInstance(o o0, k k0, n n0, a a0) {
        return new LoginSimpleAccountViewModel(o0, k0, n0, a0);
    }
}

