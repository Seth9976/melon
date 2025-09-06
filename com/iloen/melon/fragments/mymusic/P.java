package com.iloen.melon.fragments.mymusic;

public final class p implements Runnable {
    public final MemberProfileEditFragment a;
    public final String b;

    public p(MemberProfileEditFragment memberProfileEditFragment0, String s) {
        this.a = memberProfileEditFragment0;
        this.b = s;
    }

    @Override
    public final void run() {
        MemberProfileEditFragment.setUserProfileImage$lambda$10$lambda$9(this.a, this.b);
    }
}

