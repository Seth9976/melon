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
public final class ComposableSingletons.SettingMusicAlarmListFragmentKt {
    @NotNull
    public static final ComposableSingletons.SettingMusicAlarmListFragmentKt INSTANCE;
    @NotNull
    private static o lambda$1134620731;

    static {
        ComposableSingletons.SettingMusicAlarmListFragmentKt.INSTANCE = new ComposableSingletons.SettingMusicAlarmListFragmentKt();
        ComposableSingletons.SettingMusicAlarmListFragmentKt.lambda$1134620731 = new b(0x43A0F03B, new P(15), false);
    }

    @NotNull
    public final o getLambda$1134620731$app_playstoreProdRelease() {
        return ComposableSingletons.SettingMusicAlarmListFragmentKt.lambda$1134620731;
    }

    private static final H lambda_1134620731$lambda$0(a a0, l l0, int v) {
        q.g(a0, "$this$item");
        if(((p)l0).Q(v & 1, (v & 17) != 16)) {
            c.d(((p)l0), d.h(n.a, 150.0f));
            return H.a;
        }
        ((p)l0).T();
        return H.a;
    }
}

