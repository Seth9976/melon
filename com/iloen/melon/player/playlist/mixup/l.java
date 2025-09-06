package com.iloen.melon.player.playlist.mixup;

import androidx.lifecycle.f0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.player.playlist.tiara.MixUpPlaylistTiaraLogHelper;
import com.iloen.melon.player.playlist.tiara.MixUpPlaylistViewImpLogHelper;
import com.melon.playlist.mixup.DjMalrangInfo;
import com.melon.ui.interfaces.StringProviderImpl;
import e1.m;
import ie.H;
import k8.Y;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import od.b;
import pc.c;
import we.a;

public final class l implements a {
    public final int a;
    public final MixUpPlaylistComposeViewModel b;

    public l(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, int v) {
        this.a = v;
        this.b = mixUpPlaylistComposeViewModel0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0 = this.b;
        switch(this.a) {
            case 0: {
                BuildersKt__Builders_commonKt.launch$default(f0.h(mixUpPlaylistComposeViewModel0), null, null, new MixUpPlaylistComposeViewModel.playPopularPlaylistInternal.2.1(mixUpPlaylistComposeViewModel0, null), 3, null);
                return H.a;
            }
            case 1: {
                return new Jd.a(new StringProviderImpl(Y.a(MelonAppBase.Companion)), new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.toolBarEventHelper.2.1(1, 0, MixUpPlaylistComposeViewModel.class, this.b, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V"), null);  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            }
            case 2: {
                return mixUpPlaylistComposeViewModel0.getCurrentPlayable();
            }
            case 3: {
                return m.s(mixUpPlaylistComposeViewModel0.getCurrentIndex());
            }
            case 4: {
                return mixUpPlaylistComposeViewModel0.getTiaraProperty();
            }
            case 5: {
                return (c)mixUpPlaylistComposeViewModel0.r.getValue();
            }
            case 6: {
                return mixUpPlaylistComposeViewModel0.c().c();
            }
            case 7: {
                Object object0 = mixUpPlaylistComposeViewModel0.r.getValue();
                return object0 instanceof DjMalrangInfo ? ((DjMalrangInfo)object0) : null;
            }
            case 8: {
                return new b(new l(mixUpPlaylistComposeViewModel0, 7));
            }
            case 9: {
                l l0 = new l(mixUpPlaylistComposeViewModel0, 2);
                l l1 = new l(mixUpPlaylistComposeViewModel0, 3);
                l l2 = new l(mixUpPlaylistComposeViewModel0, 4);
                l l3 = new l(mixUpPlaylistComposeViewModel0, 5);
                com.iloen.melon.player.playlist.mixup.m m0 = new com.iloen.melon.player.playlist.mixup.m(mixUpPlaylistComposeViewModel0, 1);
                com.iloen.melon.player.playlist.mixup.m m1 = new com.iloen.melon.player.playlist.mixup.m(mixUpPlaylistComposeViewModel0, 2);
                l l4 = new l(mixUpPlaylistComposeViewModel0, 6);
                com.iloen.melon.player.playlist.mixup.m m2 = new com.iloen.melon.player.playlist.mixup.m(mixUpPlaylistComposeViewModel0, 3);
                return new MixUpPlaylistTiaraLogHelper(mixUpPlaylistComposeViewModel0.b, l0, l1, l2, l3, m0, m1, l4, m2);
            }
            case 10: {
                l l5 = new l(mixUpPlaylistComposeViewModel0, 11);
                com.iloen.melon.player.playlist.mixup.m m3 = new com.iloen.melon.player.playlist.mixup.m(mixUpPlaylistComposeViewModel0, 4);
                com.iloen.melon.player.playlist.mixup.m m4 = new com.iloen.melon.player.playlist.mixup.m(mixUpPlaylistComposeViewModel0, 5);
                l l6 = new l(mixUpPlaylistComposeViewModel0, 12);
                com.iloen.melon.player.playlist.mixup.m m5 = new com.iloen.melon.player.playlist.mixup.m(mixUpPlaylistComposeViewModel0, 0);
                return new MixUpPlaylistViewImpLogHelper(mixUpPlaylistComposeViewModel0.b, l5, m3, m4, l6, m5);
            }
            case 11: {
                return mixUpPlaylistComposeViewModel0.getTiaraProperty();
            }
            default: {
                return mixUpPlaylistComposeViewModel0.c().c();
            }
        }
    }
}

