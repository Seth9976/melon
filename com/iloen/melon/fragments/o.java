package com.iloen.melon.fragments;

import androidx.activity.result.ActivityResult;
import e.a;

public final class o implements a {
    public final int a;
    public final MelonBaseFragment b;

    public o(MelonBaseFragment melonBaseFragment0, int v) {
        this.a = v;
        this.b = melonBaseFragment0;
        super();
    }

    @Override  // e.a
    public final void onActivityResult(Object object0) {
        switch(this.a) {
            case 0: {
                this.b.lambda$new$0(((ActivityResult)object0));
                return;
            }
            case 1: {
                this.b.lambda$new$1(((ActivityResult)object0));
                return;
            }
            default: {
                this.b.lambda$new$2(((ActivityResult)object0));
            }
        }
    }
}

