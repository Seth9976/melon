package com.iloen.melon.fragments.webview;

import A8.M;
import B.a;
import F8.o;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.utils.system.AppUtils;

public class MelonWebViewWithTitleBarFragment extends MelonWebViewFragment {
    public static class CopyLightFragment extends MelonWebViewWithTitleBarFragment {
        public static String getCopyrightUrl() {
            return M.u + "?cpId=" + MelonAppBase.instance.getMelonCpId() + "&appVer=" + AppUtils.getVersionName(MelonAppBase.instance.getContext());
        }

        public static CopyLightFragment newInstance() {
            Bundle bundle0 = new Bundle();
            bundle0.putString("key_popup_title", "저작권정보");
            bundle0.putString("url", CopyLightFragment.getCopyrightUrl());
            CopyLightFragment melonWebViewWithTitleBarFragment$CopyLightFragment0 = new CopyLightFragment();
            melonWebViewWithTitleBarFragment$CopyLightFragment0.setArguments(bundle0);
            return melonWebViewWithTitleBarFragment$CopyLightFragment0;
        }
    }

    private static final String KEY_POPUP_TITLE = "key_popup_title";
    private String mPopupTitle;

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public o getTitleBarItem() {
        return a.t(6, new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                MelonWebViewWithTitleBarFragment.this.performBackPress();
            }
        });
    }

    public static MelonWebViewWithTitleBarFragment newInstance() {
        return new MelonWebViewWithTitleBarFragment();
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            this.mPopupTitle = bundle0.getString("key_popup_title");
        }
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D0907, viewGroup0, false);  // layout:webviewbrowser_titlebar
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putString("key_popup_title", this.mPopupTitle);
        }
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(this.getTitleBarItem());
            titleBar0.setTitle(this.mPopupTitle);
        }
    }
}

