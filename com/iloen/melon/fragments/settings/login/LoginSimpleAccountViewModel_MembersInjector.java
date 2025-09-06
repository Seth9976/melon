package com.iloen.melon.fragments.settings.login;

import Xd.a;
import eb.n;
import eb.u;
import ge.b;

public final class LoginSimpleAccountViewModel_MembersInjector implements a {
    private final b pvUseCaseProvider;
    private final b screenCaptureUseCaseProvider;

    public LoginSimpleAccountViewModel_MembersInjector(b b0, b b1) {
        this.pvUseCaseProvider = b0;
        this.screenCaptureUseCaseProvider = b1;
    }

    public static a create(b b0, b b1) {
        return new LoginSimpleAccountViewModel_MembersInjector(b0, b1);
    }

    public void injectMembers(LoginSimpleAccountViewModel loginSimpleAccountViewModel0) {
        loginSimpleAccountViewModel0.pvUseCase = (n)this.pvUseCaseProvider.get();
        loginSimpleAccountViewModel0.screenCaptureUseCase = (u)this.screenCaptureUseCaseProvider.get();
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((LoginSimpleAccountViewModel)object0));
    }
}

