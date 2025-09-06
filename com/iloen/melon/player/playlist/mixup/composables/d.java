package com.iloen.melon.player.playlist.mixup.composables;

import com.iloen.melon.player.playlist.mixup.MixUpUIItemData.PlayableItem;
import com.iloen.melon.player.playlist.mixup.MixUpUIItemData;
import ie.H;
import we.a;

public final class d implements a {
    public final int a;
    public final SongListClickListener b;
    public final MixUpUIItemData c;

    public d(SongListClickListener songListClickListener0, MixUpUIItemData mixUpUIItemData0, int v) {
        this.a = v;
        this.b = songListClickListener0;
        this.c = mixUpUIItemData0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            String s = ((PlayableItem)this.c).getId();
            boolean z = ((PlayableItem)this.c).isSelected();
            this.b.onSelect(s, !z);
            return H.a;
        }
        String s1 = ((PlayableItem)this.c).getId();
        boolean z1 = ((PlayableItem)this.c).isSelected();
        this.b.onSelect(s1, !z1);
        return H.a;
    }
}

