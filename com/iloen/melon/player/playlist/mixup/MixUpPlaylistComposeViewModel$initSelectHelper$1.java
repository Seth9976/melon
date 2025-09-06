package com.iloen.melon.player.playlist.mixup;

import Ud.e;
import i.n.i.b.a.s.e.M3;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001F\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/iloen/melon/player/playlist/mixup/MixUpPlaylistComposeViewModel$initSelectHelper$1", "LUd/e;", "Lcom/iloen/melon/player/playlist/mixup/MixUpUIItemData;", "state", "", "select", "onChange", "(Lcom/iloen/melon/player/playlist/mixup/MixUpUIItemData;Z)Lcom/iloen/melon/player/playlist/mixup/MixUpUIItemData;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MixUpPlaylistComposeViewModel.initSelectHelper.1 implements e {
    public MixUpUIItemData onChange(MixUpUIItemData mixUpUIItemData0, boolean z) {
        q.g(mixUpUIItemData0, "state");
        if(mixUpUIItemData0 instanceof PlayableItem) {
            return PlayableItem.copy$default(((PlayableItem)mixUpUIItemData0), null, z, false, false, false, false, 61, null);
        }
        if(!(mixUpUIItemData0 instanceof WaitingTitle)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return mixUpUIItemData0;
    }

    @Override  // Ud.e
    public Object onChange(Object object0, boolean z) {
        return this.onChange(((MixUpUIItemData)object0), z);
    }
}

