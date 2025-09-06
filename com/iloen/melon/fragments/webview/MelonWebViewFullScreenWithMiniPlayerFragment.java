package com.iloen.melon.fragments.webview;

import com.iloen.melon.utils.ui.ViewUtils;

public class MelonWebViewFullScreenWithMiniPlayerFragment extends MelonWebViewFullScreenFragment {
    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFullScreenFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    public static MelonWebViewFullScreenWithMiniPlayerFragment newInstance(ParamItem melonWebViewFullScreenFragment$ParamItem0) {
        MelonWebViewFullScreenWithMiniPlayerFragment melonWebViewFullScreenWithMiniPlayerFragment0 = new MelonWebViewFullScreenWithMiniPlayerFragment();
        melonWebViewFullScreenWithMiniPlayerFragment0.setArguments(MelonWebViewFullScreenFragment.createBundleArguments(melonWebViewFullScreenFragment$ParamItem0));
        return melonWebViewFullScreenWithMiniPlayerFragment0;
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFullScreenFragment
    public void restoreScreenRotation() {
        ViewUtils.setOrientation(this.getActivity(), 1);
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFullScreenFragment
    public boolean shouldShowMiniPlayer() {
        return true;
    }
}

