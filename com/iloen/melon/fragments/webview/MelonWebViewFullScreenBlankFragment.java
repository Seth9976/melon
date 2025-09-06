package com.iloen.melon.fragments.webview;

import F8.m;
import F8.o;
import F8.z;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.utils.ui.ViewUtils;

public class MelonWebViewFullScreenBlankFragment extends MelonWebViewFullScreenFragment {
    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFullScreenFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    public static MelonWebViewFullScreenBlankFragment newInstance(ParamItem melonWebViewFullScreenFragment$ParamItem0) {
        MelonWebViewFullScreenBlankFragment melonWebViewFullScreenBlankFragment0 = new MelonWebViewFullScreenBlankFragment();
        melonWebViewFullScreenBlankFragment0.setArguments(MelonWebViewFullScreenFragment.createBundleArguments(melonWebViewFullScreenFragment$ParamItem0));
        return melonWebViewFullScreenBlankFragment0;
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFullScreenFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            z z0 = new z(2);
            m m0 = new m(0, false);
            TextView textView0 = m0.g;
            if(textView0 != null) {
                textView0.setTextSize(1, 19.0f);
            }
            o[] arr_o = {m0, z0};
            o o0 = null;
            for(int v = 0; v < 2; ++v) {
                o o1 = arr_o[v];
                if(o0 == null) {
                    o0 = o1;
                }
                else {
                    o0.g(o1);
                }
            }
            titleBar0.a(o0);
            titleBar0.setBackgroundColor(0);
        }
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFullScreenFragment
    public void restoreScreenRotation() {
        ViewUtils.setOrientation(this.getActivity(), 1);
    }
}

