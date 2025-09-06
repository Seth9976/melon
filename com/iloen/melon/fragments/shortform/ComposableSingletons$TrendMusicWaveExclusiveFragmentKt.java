package com.iloen.melon.fragments.shortform;

import M.t;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.l;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST.CHAT;
import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import m0.b;
import org.jetbrains.annotations.NotNull;
import r0.n;
import we.p;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
public final class ComposableSingletons.TrendMusicWaveExclusiveFragmentKt {
    @NotNull
    public static final ComposableSingletons.TrendMusicWaveExclusiveFragmentKt INSTANCE;
    @NotNull
    private static p lambda$1323796333;

    static {
        ComposableSingletons.TrendMusicWaveExclusiveFragmentKt.INSTANCE = new ComposableSingletons.TrendMusicWaveExclusiveFragmentKt();
        ComposableSingletons.TrendMusicWaveExclusiveFragmentKt.lambda$1323796333 = new b(0x4EE7876D, new a(0), false);
    }

    @NotNull
    public final p getLambda$1323796333$app_playstoreProdRelease() {
        return ComposableSingletons.TrendMusicWaveExclusiveFragmentKt.lambda$1323796333;
    }

    private static final H lambda_1323796333$lambda$0(t t0, CHAT trendShortFormRes$Response$SLOTLIST$CHAT0, l l0, int v) {
        q.g(t0, "$this$AutoScrollingInfiniteLazyColumn");
        q.g(trendShortFormRes$Response$SLOTLIST$CHAT0, "chat");
        r0.q q0 = d.f(n.a, 1.0f);
        String s = trendShortFormRes$Response$SLOTLIST$CHAT0.text;
        q.f(s, "text");
        String s1 = trendShortFormRes$Response$SLOTLIST$CHAT0.name;
        q.f(s1, "name");
        String s2 = trendShortFormRes$Response$SLOTLIST$CHAT0.profileImgUrl;
        q.f(s2, "profileImgUrl");
        TrendMusicWaveExclusiveFragmentKt.MusicWaveChatItem(q0, s, s1, s2, l0, 6, 0);
        return H.a;
    }
}

