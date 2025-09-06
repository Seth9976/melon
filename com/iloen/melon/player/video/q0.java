package com.iloen.melon.player.video;

import we.o;

public final class q0 implements o {
    public final VideoViewModel a;

    public q0(VideoViewModel videoViewModel0) {
        this.a = videoViewModel0;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        boolean z = ((Boolean)object0).booleanValue();
        boolean z1 = ((Boolean)object1).booleanValue();
        if(((Boolean)object2).booleanValue()) {
            return ControllerVisibleStatus.ONLY_SEEK;
        }
        if(!z) {
            return ControllerVisibleStatus.ALL_GONE;
        }
        return !z1 || this.a.l.getValue() != VideoStatus.FullScreen ? ControllerVisibleStatus.All_VISIBLE : ControllerVisibleStatus.ONLY_TITLE;
    }
}

