package com.iloen.melon.player.playlist.mixup;

import ie.H;
import we.a;

public final class g implements a {
    public final int a;
    public final MixUpPlaylistComposeFragment b;

    public g(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0, int v) {
        this.a = v;
        this.b = mixUpPlaylistComposeFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0 = this.b;
        switch(this.a) {
            case 0: {
                return ((MixUpPlaylistComposeViewModel)mixUpPlaylistComposeFragment0.getViewModel()).getTiaraLogHelper();
            }
            case 1: {
                return ((MixUpPlaylistComposeViewModel)mixUpPlaylistComposeFragment0.getViewModel()).getViewImpLogHelper();
            }
            case 2: {
                ((MixUpPlaylistComposeViewModel)mixUpPlaylistComposeFragment0.getViewModel()).releaseSelectedAll();
                return h0;
            }
            case 3: {
                ((MixUpPlaylistComposeViewModel)mixUpPlaylistComposeFragment0.getViewModel()).selectAllWaitingList();
                return h0;
            }
            case 4: {
                ((MixUpPlaylistComposeViewModel)mixUpPlaylistComposeFragment0.getViewModel()).addAll();
                mixUpPlaylistComposeFragment0.n().logClickPutFromSourceTitle();
                return h0;
            }
            case 5: {
                mixUpPlaylistComposeFragment0.sendUserEvent(ClickOtherRecommend.INSTANCE);
                return h0;
            }
            case 6: {
                mixUpPlaylistComposeFragment0.sendUserEvent(ClickOtherRecommend.INSTANCE);
                return h0;
            }
            case 7: {
                mixUpPlaylistComposeFragment0.sendUserEvent(PlayOtherRecommendInDjMalrang.INSTANCE);
                return h0;
            }
            case 8: {
                mixUpPlaylistComposeFragment0.sendUserEvent(ClickOtherRecommend.INSTANCE);
                return h0;
            }
            case 9: {
                mixUpPlaylistComposeFragment0.sendUserEvent(ClickOtherRecommend.INSTANCE);
                return h0;
            }
            default: {
                mixUpPlaylistComposeFragment0.sendUserEvent(PlayOtherRecommendInDjMalrang.INSTANCE);
                return h0;
            }
        }
    }
}

