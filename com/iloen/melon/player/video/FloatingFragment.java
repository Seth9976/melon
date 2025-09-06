package com.iloen.melon.player.video;

import androidx.fragment.app.I;
import com.iloen.melon.fragments.IFragmentContainer;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.melon.ui.c0;
import com.melon.ui.h3;
import com.melon.ui.q1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u000B\u0010\u0006J\u000F\u0010\f\u001A\u00020\bH\u0004¢\u0006\u0004\b\f\u0010\u0003¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/video/FloatingFragment;", "Landroidx/fragment/app/I;", "<init>", "()V", "", "isFullCover", "()Z", "hasFocus", "Lie/H;", "onWindowFocusChanged", "(Z)V", "onBackPressed", "postFragmentForegroundEventManually", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class FloatingFragment extends I {
    public static final int $stable = 8;

    public abstract boolean isFullCover();

    public boolean onBackPressed() {
        return false;
    }

    public abstract void onWindowFocusChanged(boolean arg1);

    public final void postFragmentForegroundEventManually() {
        I i2;
        I i0 = MelonFragmentManager.getInstance().getCurrentFragment();
        if(i0 != null) {
            I i1 = i0.getParentFragment();
            if(i0 instanceof MelonBaseFragment || i0 instanceof c0) {
                if(i0 instanceof IFragmentContainer) {
                    i2 = ((IFragmentContainer)i0).getCurrentFragment();
                    if(i2 == null) {
                        i2 = i0;
                    }
                }
                else {
                    i2 = i0;
                }
                if(i2 instanceof h3) {
                    if(i1 instanceof q1) {
                        if(((q1)i1).getBottomTabVisible()) {
                            ((h3)i2).onForeground();
                        }
                    }
                    else if(i0 instanceof MelonBaseFragment) {
                        if(((MelonBaseFragment)i0).getParentTabContainerFragment() == ((MelonBaseFragment)i0).getCurrentTabContainerFragment()) {
                            ((h3)i2).onForeground();
                        }
                    }
                    else if(i0 instanceof c0 && ((c0)i0).getParentTabContainerFragment() == De.I.F(((c0)i0))) {
                        ((h3)i2).onForeground();
                    }
                }
            }
        }
    }
}

