package com.iloen.melon.player.playlist.mixup.composables;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.mixup.MixUpUIItemData.PlayableItem;
import com.iloen.melon.player.playlist.mixup.MixUpUIItemData;
import ie.H;
import we.a;

public final class b implements a {
    public final int a;
    public final SongListClickListener b;
    public final MixUpUIItemData c;
    public final Playable d;

    public b(SongListClickListener songListClickListener0, MixUpUIItemData mixUpUIItemData0, Playable playable0, int v) {
        this.a = v;
        this.b = songListClickListener0;
        this.c = mixUpUIItemData0;
        this.d = playable0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                String s1 = ((PlayableItem)this.c).getId();
                this.b.onClickMoveDown(s1, this.d);
                return H.a;
            }
            case 1: {
                String s2 = ((PlayableItem)this.c).getId();
                this.b.onShowAlbumInfo(s2, this.d);
                return H.a;
            }
            case 2: {
                String s3 = ((PlayableItem)this.c).getId();
                this.b.onShowAlbumInfo(s3, this.d);
                return H.a;
            }
            case 3: {
                String s4 = ((PlayableItem)this.c).getId();
                this.b.onClickSongLayer(s4, this.d);
                return H.a;
            }
            default: {
                String s = ((PlayableItem)this.c).getId();
                this.b.onClickMoveUp(s, this.d);
                return H.a;
            }
        }
    }
}

