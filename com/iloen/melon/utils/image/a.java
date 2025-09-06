package com.iloen.melon.utils.image;

import androidx.activity.result.ActivityResult;

public final class a implements e.a {
    public final int a;
    public final ImageSelector b;

    public a(ImageSelector imageSelector0, int v) {
        this.a = v;
        this.b = imageSelector0;
        super();
    }

    @Override  // e.a
    public final void onActivityResult(Object object0) {
        switch(this.a) {
            case 0: {
                this.b.getClass();
                this.b.handleActivityResult(7000, ((ActivityResult)object0).a, ((ActivityResult)object0).b);
                return;
            }
            case 1: {
                this.b.getClass();
                this.b.handleActivityResult(7001, ((ActivityResult)object0).a, ((ActivityResult)object0).b);
                return;
            }
            default: {
                this.b.getClass();
                this.b.handleActivityResult(7002, ((ActivityResult)object0).a, ((ActivityResult)object0).b);
            }
        }
    }
}

