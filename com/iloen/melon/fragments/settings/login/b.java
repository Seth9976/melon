package com.iloen.melon.fragments.settings.login;

public final class b implements Runnable {
    public final LoginSimpleAccountFragment a;

    public b(LoginSimpleAccountFragment loginSimpleAccountFragment0) {
        this.a = loginSimpleAccountFragment0;
    }

    @Override
    public final void run() {
        LoginSimpleAccountFragment.onResume$lambda$0(this.a);
    }
}

