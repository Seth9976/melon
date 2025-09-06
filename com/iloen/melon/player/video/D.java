package com.iloen.melon.player.video;

import androidx.fragment.app.I;
import kotlin.jvm.internal.q;
import we.a;

public final class d implements a {
    public final int a;
    public final VideoChatFragment b;

    public d(VideoChatFragment videoChatFragment0, int v) {
        this.a = v;
        this.b = videoChatFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        VideoChatFragment videoChatFragment0 = this.b;
        switch(this.a) {
            case 0: {
                I i0 = videoChatFragment0.requireParentFragment();
                q.f(i0, "requireParentFragment(...)");
                return i0;
            }
            case 1: {
                I i1 = videoChatFragment0.requireParentFragment();
                q.f(i1, "requireParentFragment(...)");
                return i1;
            }
            default: {
                return VideoChatFragment.d0(videoChatFragment0);
            }
        }
    }
}

