package com.iloen.melon.player.playlist.mixup;

import androidx.compose.runtime.l;
import ie.H;
import we.n;

public final class d implements n {
    public final int a;
    public final MixUpPlaylistComposeFragment b;
    public final int c;

    public d(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0, int v, int v1) {
        this.a = v1;
        this.b = mixUpPlaylistComposeFragment0;
        this.c = v;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        H h0 = H.a;
        int v = this.c;
        MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0 = this.b;
        ((Integer)object1).intValue();
        switch(this.a) {
            case 0: {
                mixUpPlaylistComposeFragment0.SourceTitle(((l)object0), (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
                return h0;
            }
            case 1: {
                mixUpPlaylistComposeFragment0.MixUpTabEmptyViewLayout(((l)object0), (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
                return h0;
            }
            case 2: {
                mixUpPlaylistComposeFragment0.WaitingTitle(((l)object0), (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
                return h0;
            }
            case 3: {
                mixUpPlaylistComposeFragment0.MixUpPlaylistList(((l)object0), (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
                return h0;
            }
            default: {
                mixUpPlaylistComposeFragment0.SelectableFilter(((l)object0), (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
                return h0;
            }
        }
    }
}

