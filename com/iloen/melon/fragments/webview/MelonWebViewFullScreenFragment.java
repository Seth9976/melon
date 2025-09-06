package com.iloen.melon.fragments.webview;

import B.a;
import F8.o;
import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.types.BasicNameValuePair;
import com.iloen.melon.utils.ContentValuesEncodedUtils;
import com.iloen.melon.utils.NameValuePairList;
import com.iloen.melon.utils.ui.ViewUtils;
import java.io.Serializable;
import java.util.Map;

public class MelonWebViewFullScreenFragment extends MelonWebViewFragment implements CAWebView {
    public static class ParamItem {
        public Map additionalHttpHeaders;
        public NameValuePairList params;
        public boolean post;
        public String title;
        public String url;

        public ParamItem() {
        }

        public ParamItem(String s) {
            this.url = s;
        }
    }

    private static final String KEY_POPUP_TITLE = "key_popup_title";
    private static final String TAG = "MelonWebViewFullScreenFragment";
    private String mPopupTitle;

    private void close() {
        this.showBlockedProgress(false);
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null && !fragmentActivity0.isFinishing()) {
            fragmentActivity0.getOnBackPressedDispatcher().c();
        }
    }

    public static Bundle createBundleArguments(ParamItem melonWebViewFullScreenFragment$ParamItem0) {
        Bundle bundle0 = new Bundle();
        bundle0.putString("key_popup_title", melonWebViewFullScreenFragment$ParamItem0.title);
        if(melonWebViewFullScreenFragment$ParamItem0.post) {
            if(melonWebViewFullScreenFragment$ParamItem0.params != null && melonWebViewFullScreenFragment$ParamItem0.params.size() > 0) {
                bundle0.putByteArray("data", ContentValuesEncodedUtils.format(melonWebViewFullScreenFragment$ParamItem0.params, "utf-8").getBytes());
                bundle0.putBoolean("isPostMethod", true);
            }
            bundle0.putString("url", melonWebViewFullScreenFragment$ParamItem0.url);
            return bundle0;
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(melonWebViewFullScreenFragment$ParamItem0.url);
        if(melonWebViewFullScreenFragment$ParamItem0.params != null && melonWebViewFullScreenFragment$ParamItem0.params.size() > 0) {
            stringBuilder0.append("?");
            for(Object object0: melonWebViewFullScreenFragment$ParamItem0.params) {
                stringBuilder0.append(((BasicNameValuePair)object0).a);
                stringBuilder0.append("=");
                stringBuilder0.append(((BasicNameValuePair)object0).b.toString());
                stringBuilder0.append("&");
            }
            stringBuilder0.setLength(stringBuilder0.length() - 1);
        }
        bundle0.putString("url", stringBuilder0.toString());
        bundle0.putSerializable("additionalHttpHeader", ((Serializable)melonWebViewFullScreenFragment$ParamItem0.additionalHttpHeaders));
        return bundle0;
    }

    private Activity getMainActivity() {
        Activity activity0 = this.getActivity();
        if(activity0 != null) {
            Activity activity1 = activity0.getParent();
            return activity1 == null ? activity0 : activity1;
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public o getTitleBarItem() {
        return a.t(6, new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                MelonWebViewFullScreenFragment.this.performBackPress();
            }
        });
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public void navigateBack() {
        this.close();
    }

    public static MelonWebViewFullScreenFragment newInstance(ParamItem melonWebViewFullScreenFragment$ParamItem0) {
        MelonWebViewFullScreenFragment melonWebViewFullScreenFragment0 = new MelonWebViewFullScreenFragment();
        melonWebViewFullScreenFragment0.setArguments(MelonWebViewFullScreenFragment.createBundleArguments(melonWebViewFullScreenFragment$ParamItem0));
        return melonWebViewFullScreenFragment0;
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
    public void onPause() {
        Activity activity0 = this.getMainActivity();
        if(activity0 != null) {
            activity0.getWindow().setSoftInputMode(0x20);
        }
        super.onPause();
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public void onResume() {
        Activity activity0 = this.getMainActivity();
        if(activity0 != null) {
            activity0.getWindow().setSoftInputMode(18);
        }
        super.onResume();
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
        this.setWebviewTitleBar(this.mPopupTitle);
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public void restoreScreenRotation() {
        ViewUtils.setOrientation(this.getActivity(), 1);
    }

    public void setWebviewTitleBar(String s) {
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(this.getTitleBarItem());
            titleBar0.setBackgroundColor(0);
            titleBar0.f(false);
            titleBar0.setTitle(s);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }
}

