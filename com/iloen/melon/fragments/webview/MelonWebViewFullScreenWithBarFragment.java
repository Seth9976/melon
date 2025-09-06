package com.iloen.melon.fragments.webview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.iloen.melon.custom.MelonWebView;
import com.iloen.melon.utils.ui.ViewUtils;
import java.lang.ref.WeakReference;

public class MelonWebViewFullScreenWithBarFragment extends MelonWebViewFragment implements PopupWebView {
    private static final String KEY_USE_JAVASCRIPT = "useJavascript";
    private ImageButton mNextImageButton;
    private WeakReference mNextImageButtonReference;
    private ImageButton mPrevImageButton;
    private WeakReference mPrevImageButtonReference;
    private View mProgressBar;
    private String mRootUrlAddress;
    private boolean mUseJavascript;

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public void goHome(boolean z) {
        MelonWebView melonWebView0 = this.getWebView();
        if(melonWebView0 != null) {
            while(melonWebView0.canGoBack()) {
                melonWebView0.goBack();
            }
        }
    }

    private void initUIClass() {
        View view0 = this.findViewById(0x7F0A097E);  // id:progress
        this.mProgressBar = view0;
        ViewUtils.hideWhen(view0, true);
        this.mPrevImageButton = (ImageButton)this.findViewById(0x7F0A0961);  // id:prev
        this.mPrevImageButtonReference = new WeakReference(this.mPrevImageButton);
        this.mNextImageButton = (ImageButton)this.findViewById(0x7F0A08B0);  // id:next
        this.mNextImageButtonReference = new WeakReference(this.mNextImageButton);
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public void initWebView() {
        super.initWebView();
        this.mWebView.getSettings().setJavaScriptEnabled(this.mUseJavascript);
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    public static MelonWebViewFullScreenWithBarFragment newInstance(String s, boolean z) {
        MelonWebViewFullScreenWithBarFragment melonWebViewFullScreenWithBarFragment0 = new MelonWebViewFullScreenWithBarFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putString("url", s);
        bundle0.putBoolean("useJavascript", z);
        melonWebViewFullScreenWithBarFragment0.setArguments(bundle0);
        return melonWebViewFullScreenWithBarFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        MelonWebView melonWebView0 = this.getWebView();
        if(melonWebView0 != null && melonWebView0.canGoBack()) {
            melonWebView0.goBack();
            this.setButtonEnable();
            return true;
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 != null) {
            this.mRootUrlAddress = bundle0.getString("url");
            this.mUseJavascript = bundle0.getBoolean("useJavascript");
            return;
        }
        Bundle bundle1 = this.getArguments();
        if(bundle1 != null) {
            this.mRootUrlAddress = bundle1.getString("url");
            this.mUseJavascript = bundle1.getBoolean("useJavascript");
        }
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D05AF, viewGroup0, false);  // layout:popup_melon_web_view
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putString("url", this.mRootUrlAddress);
        }
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        this.initUIClass();
        this.setClickEventListener();
    }

    @Override  // com.iloen.melon.fragments.webview.MelonWebViewFragment
    public void restoreScreenRotation() {
        ViewUtils.setOrientation(this.getActivity(), 1);
    }

    private void setButtonEnable() {
        if(this.mPrevImageButtonReference != null && this.mNextImageButtonReference != null) {
            MelonWebView melonWebView0 = this.getWebView();
            ImageButton imageButton0 = (ImageButton)this.mPrevImageButtonReference.get();
            if(melonWebView0 == null || !melonWebView0.canGoBack()) {
                ViewUtils.setEnable(imageButton0, false);
            }
            else {
                ViewUtils.setEnable(imageButton0, true);
                ViewUtils.setOnClickListener(imageButton0, new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        MelonWebView melonWebView0 = MelonWebViewFullScreenWithBarFragment.this.getWebView();
                        if(melonWebView0 != null && melonWebView0.canGoBack()) {
                            melonWebView0.goBack();
                        }
                        MelonWebViewFullScreenWithBarFragment.t0(MelonWebViewFullScreenWithBarFragment.this);
                    }
                });
            }
            ImageButton imageButton1 = (ImageButton)this.mNextImageButtonReference.get();
            if(melonWebView0 != null && melonWebView0.canGoForward()) {
                ViewUtils.setEnable(imageButton1, true);
                ViewUtils.setOnClickListener(imageButton1, new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        MelonWebView melonWebView0 = MelonWebViewFullScreenWithBarFragment.this.getWebView();
                        if(melonWebView0 != null && melonWebView0.canGoForward()) {
                            melonWebView0.goForward();
                        }
                        MelonWebViewFullScreenWithBarFragment.t0(MelonWebViewFullScreenWithBarFragment.this);
                    }
                });
                return;
            }
            ViewUtils.setEnable(imageButton1, false);
        }
    }

    private void setClickEventListener() {
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A09D6), new View.OnClickListener() {  // id:refresh
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                MelonWebView melonWebView0 = MelonWebViewFullScreenWithBarFragment.this.getWebView();
                if(melonWebView0 != null) {
                    melonWebView0.reload();
                }
            }
        });
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A0BC9), new View.OnClickListener() {  // id:top
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                MelonWebView melonWebView0 = MelonWebViewFullScreenWithBarFragment.this.getWebView();
                if(melonWebView0 != null) {
                    melonWebView0.scrollTo(0, 0);
                }
            }
        });
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A02C7), new View.OnClickListener() {  // id:close
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                MelonWebViewFullScreenWithBarFragment.this.navigateBack();
            }
        });
        this.setButtonEnable();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    @Override  // com.iloen.melon.custom.MelonWebViewInterface, com.iloen.melon.fragments.MelonBaseFragment
    public void showProgress(boolean z) {
        super.showProgress(z);
        if(!z) {
            this.setButtonEnable();
        }
    }

    public static void t0(MelonWebViewFullScreenWithBarFragment melonWebViewFullScreenWithBarFragment0) {
        melonWebViewFullScreenWithBarFragment0.setButtonEnable();
    }
}

