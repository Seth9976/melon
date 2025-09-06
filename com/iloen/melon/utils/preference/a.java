package com.iloen.melon.utils.preference;

import com.iloen.melon.playback.playlist.db.d;
import com.iloen.melon.player.playlist.common.h;
import java.util.function.Predicate;
import we.k;

public final class a implements Predicate {
    public final int a;
    public final k b;

    public a(int v, k k0) {
        this.a = v;
        this.b = k0;
        super();
    }

    @Override
    public final boolean test(Object object0) {
        switch(this.a) {
            case 0: {
                return ((Boolean)((h)this.b).invoke(object0)).booleanValue();
            }
            case 1: {
                return ((Boolean)((h)this.b).invoke(object0)).booleanValue();
            }
            case 2: {
                return ((Boolean)((h)this.b).invoke(object0)).booleanValue();
            }
            default: {
                return ((Boolean)((d)this.b).invoke(object0)).booleanValue();
            }
        }
    }
}

