package com.iloen.melon.player.playlist.mixup.composables;

import com.iloen.melon.player.playlist.mixup.MixUpUIItemData.PlayableItem;
import com.iloen.melon.player.playlist.mixup.MixUpUIItemData;
import ie.H;
import kotlin.jvm.internal.q;
import we.a;
import we.k;
import x0.b;

public final class e implements k {
    public final int a;
    public final a b;
    public final SongListClickListener c;

    public e(a a0, SongListClickListener songListClickListener0, int v) {
        this.a = v;
        this.b = a0;
        this.c = songListClickListener0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        b b0 = (b)object0;
        if(this.a != 0) {
            Object object1 = this.b.invoke();
            q.e(object1, "null cannot be cast to non-null type com.iloen.melon.player.playlist.mixup.MixUpUIItemData.PlayableItem");
            String s = ((MixUpUIItemData)this.b.invoke()).getId();
            this.c.onClickSongLayer(s, ((PlayableItem)object1).getPlayableData().a);
            return H.a;
        }
        Object object2 = this.b.invoke();
        q.e(object2, "null cannot be cast to non-null type com.iloen.melon.player.playlist.mixup.MixUpUIItemData.PlayableItem");
        String s1 = ((MixUpUIItemData)this.b.invoke()).getId();
        this.c.onMore(s1, ((PlayableItem)object2).getPlayableData());
        return H.a;
    }
}

