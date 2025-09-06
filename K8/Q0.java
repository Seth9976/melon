package k8;

import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.fragments.tabs.BottomTabPagerAdapter.BottomTabPagerEventListener;

public final class q0 implements BottomTabPagerEventListener {
    public final MusicBrowserActivity a;

    public q0(MusicBrowserActivity musicBrowserActivity0) {
        this.a = musicBrowserActivity0;
    }

    @Override  // com.iloen.melon.fragments.tabs.BottomTabPagerAdapter$BottomTabPagerEventListener
    public final void onAllTabFragmentCreated() {
        this.a.handlePendingIntentAsync();
    }
}

