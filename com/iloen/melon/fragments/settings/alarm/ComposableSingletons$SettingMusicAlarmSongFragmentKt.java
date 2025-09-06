package com.iloen.melon.fragments.settings.alarm;

import Cc.P;
import M.c;
import androidx.compose.foundation.layout.d;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import m0.b;
import org.jetbrains.annotations.NotNull;
import r0.n;
import we.o;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
public final class ComposableSingletons.SettingMusicAlarmSongFragmentKt {
    @NotNull
    public static final ComposableSingletons.SettingMusicAlarmSongFragmentKt INSTANCE;
    @NotNull
    private static o lambda$-757654162;

    static {
        ComposableSingletons.SettingMusicAlarmSongFragmentKt.INSTANCE = new ComposableSingletons.SettingMusicAlarmSongFragmentKt();
        ComposableSingletons.SettingMusicAlarmSongFragmentKt.lambda$-757654162 = new b(0xD2D71D6E, new P(16), false);
    }

    @NotNull
    public final o getLambda$-757654162$app_playstoreProdRelease() {
        return ComposableSingletons.SettingMusicAlarmSongFragmentKt.lambda$-757654162;
    }

    private static final H lambda__757654162$lambda$0(a a0, l l0, int v) {
        q.g(a0, "$this$item");
        if(((p)l0).Q(v & 1, (v & 17) != 16)) {
            c.d(((p)l0), d.h(n.a, 150.0f));
            return H.a;
        }
        ((p)l0).T();
        return H.a;
    }
}

