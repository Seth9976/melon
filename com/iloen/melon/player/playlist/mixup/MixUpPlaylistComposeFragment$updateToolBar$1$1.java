package com.iloen.melon.player.playlist.mixup;

import com.iloen.melon.custom.r1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/iloen/melon/player/playlist/mixup/MixUpPlaylistComposeFragment$updateToolBar$1$1", "Lcom/iloen/melon/custom/r1;", "", "show", "Lie/H;", "onToolBarAnimationStart", "(Z)V", "onToolBarAnimationEnd", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MixUpPlaylistComposeFragment.updateToolBar.1.1 implements r1 {
    public final MixUpPlaylistComposeFragment a;

    public MixUpPlaylistComposeFragment.updateToolBar.1.1(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0) {
        this.a = mixUpPlaylistComposeFragment0;
    }

    @Override  // com.iloen.melon.custom.r1
    public void onToolBarAnimationEnd(boolean z) {
        MixUpPlaylistComposeFragment.access$getViewModel(this.a).updateHasToolbarPadding(true);
    }

    @Override  // com.iloen.melon.custom.r1
    public void onToolBarAnimationStart(boolean z) {
        MixUpPlaylistComposeFragment.access$getSharedViewModel(this.a).updateControllerVisibility(false);
    }
}

