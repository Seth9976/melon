package com.iloen.melon.fragments.melontv;

import android.content.res.Configuration;
import androidx.fragment.app.I;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.utils.system.ScreenUtils;

public abstract class MelonTvBaseFragment extends MetaContentBaseFragment {
    protected static final int COUNT_2 = 2;
    protected static final int COUNT_3 = 3;
    protected static final int COUNT_6 = 6;
    protected static final String TYPE_MOBILE_LAND = "mobileLandscape";
    protected static final String TYPE_MOBILE_PORT = "mobilePortrait";
    protected static final String TYPE_TABLET_LAND = "tabletLandscape";
    protected static final String TYPE_TABLET_PORT = "tabletPortrait";

    public String getDeviceUiType() {
        if(!ScreenUtils.isTablet(this.getContext())) {
            return ScreenUtils.isPortrait(this.getContext()) ? "mobilePortrait" : "mobileLandscape";
        }
        return ScreenUtils.isPortrait(this.getContext()) ? "tabletPortrait" : "tabletLandscape";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        I i0 = MelonFragmentManager.getInstance().getCurrentFragment();
        if(i0 instanceof MelonTvTabFragment) {
            ((MelonTvTabFragment)i0).updateOnIconTab();
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onForeground() {
        super.onForeground();
        if(this.isFragmentVisible) {
            I i0 = this.getParentFragment();
            if(i0 instanceof MelonTvTabFragment) {
                ((MelonTvTabFragment)i0).updateOnIconTab();
            }
        }
    }
}

