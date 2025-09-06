package com.kakao.emoticon.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.fragment.app.I;
import com.kakao.emoticon.KakaoEmoticon;
import com.kakao.emoticon.R.dimen;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.controller.EmoticonSectionViewController;
import com.kakao.emoticon.controller.KeyboardHeightHelper;
import com.kakao.emoticon.interfaces.EmoticonClickListener;
import com.kakao.emoticon.interfaces.EmoticonKeyboardActivityListener;
import com.kakao.emoticon.interfaces.EmoticonLoginClickListener;
import com.kakao.emoticon.interfaces.EmoticonOnKeyboardListener;
import com.kakao.emoticon.interfaces.EmoticonTabListener;
import com.kakao.emoticon.ui.widget.EmoticonKeyboardLayout;
import com.kakao.emoticon.util.ActionTracker;
import com.kakao.emoticon.util.ScreenUtils;
import com.kakao.emoticon.util.SoftInputHelper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KeyboardEmoticonManager implements EmoticonKeyboardActivityListener, OnKeyboardDetectListener {
    public static enum ShowType {
        DEFAULT,
        POPUP,
        ADD_VIEW;

    }

    private Map contentViewToPopupWindowMap;
    private FrameLayout contentsLayout;
    private int customLandscapeKeyboardHeight;
    private FrameLayout emoticonLayout;
    private EmoticonOnKeyboardListener emoticonOnKeyboardListener;
    private final EmoticonSectionViewController emoticonSectionViewController;
    private EmoticonTabListener iEmoticonOnListener;
    private boolean isLazyFirstShow;
    private KeyboardDetectorLayout keyboardDetectorLayout;
    private KeyboardHeightHelper keyboardHeightHelper;
    private ShowType keyboardShowType;
    private Fragment mAppFragment;
    private Activity mContentActivity;
    private final Activity mCurrentActivity;
    private I mSupportFragment;
    private PopupWindow popupWindow;

    public KeyboardEmoticonManager(Activity activity0, EmoticonClickListener emoticonClickListener0) {
        this.keyboardShowType = ShowType.DEFAULT;
        this.customLandscapeKeyboardHeight = -1;
        if(activity0 == null) {
            throw new RuntimeException("activity is null!");
        }
        this.mCurrentActivity = activity0;
        this.mContentActivity = activity0;
        this.emoticonSectionViewController = new EmoticonSectionViewController(activity0, emoticonClickListener0);
    }

    public KeyboardEmoticonManager(I i0, EmoticonClickListener emoticonClickListener0) {
        this.keyboardShowType = ShowType.DEFAULT;
        this.customLandscapeKeyboardHeight = -1;
        if(i0 == null) {
            throw new RuntimeException("fragment is null!");
        }
        this.mSupportFragment = i0;
        this.mCurrentActivity = i0.getActivity();
        this.emoticonSectionViewController = new EmoticonSectionViewController(i0.getActivity(), emoticonClickListener0);
    }

    private void adjustHeight() {
        if(ScreenUtils.INSTANCE.getOrientation() == 2) {
            int v = this.customLandscapeKeyboardHeight;
            if(v > 0) {
                this.keyboardHeightHelper.setKeyboardHeight(v, 2);
            }
        }
        int v1 = this.keyboardHeightHelper.getKeyboardHeight();
        if(this.keyboardDetectorLayout.isKeyboardOn()) {
            this.adjustPopupHeight(v1);
            return;
        }
        this.adjustViewHeight(v1);
    }

    private void adjustPopupHeight(int v) {
        PopupWindow popupWindow0 = this.popupWindow;
        if(popupWindow0 != null) {
            popupWindow0.setHeight(v);
        }
    }

    private void adjustViewHeight(int v) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.emoticonLayout.getLayoutParams();
        if(viewGroup$LayoutParams0.height != v) {
            viewGroup$LayoutParams0.height = v;
            this.emoticonLayout.setLayoutParams(viewGroup$LayoutParams0);
        }
    }

    @Override  // com.kakao.emoticon.ui.KeyboardDetectorLayout$OnKeyboardDetectListener
    public void clear() {
        if(this.isShowingAsPopup()) {
            this.hide();
        }
    }

    private void dismissOtherPopupWindowsDelayed() {
        KakaoEmoticon.getMainHandler().postDelayed(new b(this, 2), 100L);
    }

    @SuppressLint({"NewApi"})
    private int getPopupYOffset(int v) {
        int v1 = 0;
        int v2 = this.keyboardDetectorLayout == null || Build.VERSION.SDK_INT < 28 || this.keyboardDetectorLayout.getRootWindowInsets().getDisplayCutout() == null ? 0 : this.keyboardDetectorLayout.getRootWindowInsets().getDisplayCutout().getSafeInsetTop();
        if(this.keyboardDetectorLayout != null && Build.VERSION.SDK_INT >= 29 && this.keyboardDetectorLayout.getRootWindowInsets().getStableInsetBottom() - this.keyboardDetectorLayout.getRootWindowInsets().getMandatorySystemGestureInsets().bottom != 0) {
            v1 = this.keyboardDetectorLayout.getRootWindowInsets().getMandatorySystemGestureInsets().bottom;
        }
        return ScreenUtils.INSTANCE.getHeight() + v2 - v - v1;
    }

    public void hide() {
        if(this.popupWindow == null || !this.popupWindow.isShowing()) {
            this.emoticonLayout.removeAllViews();
            this.emoticonLayout.setVisibility(8);
        }
        else {
            this.emoticonLayout.post(new b(this, 0));
        }
        EmoticonSectionViewController emoticonSectionViewController0 = this.emoticonSectionViewController;
        if(emoticonSectionViewController0 != null) {
            emoticonSectionViewController0.hideContentView();
        }
        EmoticonTabListener emoticonTabListener0 = this.iEmoticonOnListener;
        if(emoticonTabListener0 != null) {
            emoticonTabListener0.onEmoticonTabHidden();
        }
    }

    public View inflate(LayoutInflater layoutInflater0, int v, ViewGroup viewGroup0, boolean z) {
        View view0 = layoutInflater0.inflate(layout.kakao_emoticon_empty, viewGroup0, z);
        this.initLayout(view0, layoutInflater0.inflate(v, viewGroup0, z));
        return view0;
    }

    public View inflate(LayoutInflater layoutInflater0, View view0, ViewGroup viewGroup0, boolean z) {
        View view1 = layoutInflater0.inflate(layout.kakao_emoticon_empty, viewGroup0, z);
        this.initLayout(view1, view0);
        return view1;
    }

    public void inflateEmoticonLayout(EmoticonKeyboardLayout emoticonKeyboardLayout0) {
        ViewGroup viewGroup0;
        if(emoticonKeyboardLayout0 == null) {
            throw new RuntimeException("emoticonKeyboardLayout is null!!");
        }
        Activity activity0 = this.mContentActivity;
        if(activity0 == null) {
            Fragment fragment0 = this.mAppFragment;
            if(fragment0 == null) {
                viewGroup0 = this.mSupportFragment == null ? null : ((ViewGroup)((ViewGroup)this.mSupportFragment.getView().getParent()).getChildAt(0));
            }
            else {
                viewGroup0 = (ViewGroup)((ViewGroup)fragment0.getView().getParent()).getChildAt(0);
            }
        }
        else {
            viewGroup0 = (ViewGroup)((ViewGroup)activity0.findViewById(0x1020002)).getChildAt(0);
        }
        this.keyboardDetectorLayout = (KeyboardDetectorLayout)((LayoutInflater)this.mCurrentActivity.getSystemService("layout_inflater")).inflate(layout.emoticon_sdk_keyboard_detector, null);
        if(viewGroup0 == null) {
            throw new RuntimeException("rootView is null!!");
        }
        viewGroup0.addView(this.keyboardDetectorLayout, 0);
        this.keyboardDetectorLayout.setKeyboardStateChangedListener(this);
        this.emoticonLayout = emoticonKeyboardLayout0;
        this.isLazyFirstShow = true;
        this.initHelper();
    }

    private void initHelper() {
        this.mCurrentActivity.getWindow().getDecorView().setBackgroundColor(-1);
        this.contentViewToPopupWindowMap = new ConcurrentHashMap();
        int v = (int)KakaoEmoticon.getApplication().getResources().getDimension(dimen.emoticon_keyboard_height);
        int v1 = (int)KakaoEmoticon.getApplication().getResources().getDimension(dimen.emoticon_keyboard_height_landscape);
        int v2 = (int)KakaoEmoticon.getApplication().getResources().getDimension(dimen.emoticon_keyboard_min_height);
        int v3 = ScreenUtils.INSTANCE.getOrientation() == 2 ? ScreenUtils.INSTANCE.getHeight() : ScreenUtils.INSTANCE.getWidth();
        int v4 = ScreenUtils.INSTANCE.getStatusBarHeight(KakaoEmoticon.getApplication().getResources());
        KeyboardHeightHelper keyboardHeightHelper0 = new KeyboardHeightHelper(this.mCurrentActivity.getBaseContext(), v, v1, v2, v3 - v4);
        this.keyboardHeightHelper = keyboardHeightHelper0;
        keyboardHeightHelper0.setShowType(this.keyboardShowType);
    }

    private void initLayout(View view0, View view1) {
        if(view0 != null && view1 != null) {
            KeyboardDetectorLayout keyboardDetectorLayout0 = (KeyboardDetectorLayout)view0.findViewById(id.keyboard_detector_layout);
            this.keyboardDetectorLayout = keyboardDetectorLayout0;
            keyboardDetectorLayout0.setKeyboardStateChangedListener(this);
            this.contentsLayout = (FrameLayout)view0.findViewById(id.contents_layout);
            this.emoticonLayout = (FrameLayout)view0.findViewById(id.emoticon_layout);
            this.contentsLayout.addView(view1);
            this.initHelper();
        }
    }

    private boolean isSameContentViewPopupShowing(View view0) {
        return this.contentViewToPopupWindowMap.containsKey(view0);
    }

    private boolean isSameContentViewShowingByAddingView(View view0) {
        if(!KeyboardEmoticonManager.isVisible(view0)) {
            return false;
        }
        for(int v = 0; v < this.emoticonLayout.getChildCount(); ++v) {
            if(view0 == this.emoticonLayout.getChildAt(v)) {
                return true;
            }
        }
        return false;
    }

    // 去混淆评级： 低(20)
    public boolean isShowing() {
        return this.isShowingAsPopup() || this.isShowingAsView();
    }

    // 去混淆评级： 低(30)
    public boolean isShowing(View view0) {
        return this.isShowing() && (this.isSameContentViewPopupShowing(view0) || this.isSameContentViewShowingByAddingView(view0));
    }

    private boolean isShowingAsPopup() {
        return this.popupWindow != null && this.popupWindow.isShowing();
    }

    private boolean isShowingAsView() {
        return this.emoticonLayout == null ? false : this.emoticonLayout.getVisibility() == 0;
    }

    public static boolean isVisible(View view0) {
        return view0 != null && view0.getVisibility() == 0;
    }

    private void lambda$dismissOtherPopupWindowsDelayed$2() {
        for(Object object0: this.contentViewToPopupWindowMap.values()) {
            PopupWindow popupWindow0 = (PopupWindow)object0;
            if(popupWindow0 != this.popupWindow) {
                popupWindow0.dismiss();
            }
        }
    }

    private void lambda$hide$3() {
        this.popupWindow.dismiss();
    }

    private void lambda$onConfigurationChanged$4() {
        this.showByPopupWindow(this.emoticonSectionViewController.getContentView());
    }

    private void lambda$show$0() {
        this.showByAddingView(this.emoticonSectionViewController.getContentView());
    }

    // 检测为 Lambda 实现
    private void lambda$showByPopupWindow$1(PopupWindow popupWindow0) [...]

    @Override  // com.kakao.emoticon.interfaces.EmoticonKeyboardActivityListener
    public void onConfigurationChanged(Configuration configuration0) {
        this.emoticonSectionViewController.onConfigurationChanged();
        if(this.isShowingAsPopup() && this.keyboardHeightHelper.isHeightTooSmall()) {
            this.hide();
            return;
        }
        if(this.isShowingAsPopup()) {
            this.hide();
            this.emoticonLayout.post(new b(this, 1));
            return;
        }
        if(this.isShowing()) {
            this.adjustHeight();
        }
    }

    @Override  // com.kakao.emoticon.interfaces.EmoticonKeyboardActivityListener
    public void onDestroy() {
        this.hide();
        this.emoticonSectionViewController.onDestroy();
    }

    @Override  // com.kakao.emoticon.ui.KeyboardDetectorLayout$OnKeyboardDetectListener
    public void onKeyboardHeightChanged(int v, int v1) {
        stringBuilder0.toString();
        if(this.keyboardHeightHelper.getKeyboardHeight(v1) != v) {
            this.keyboardHeightHelper.setKeyboardHeight(v, v1);
            if(this.isShowing()) {
                this.adjustHeight();
            }
        }
    }

    @Override  // com.kakao.emoticon.ui.KeyboardDetectorLayout$OnKeyboardDetectListener
    public void onKeyboardHidden() {
        if(this.isShowingAsPopup()) {
            this.hide();
        }
        EmoticonOnKeyboardListener emoticonOnKeyboardListener0 = this.emoticonOnKeyboardListener;
        if(emoticonOnKeyboardListener0 != null) {
            emoticonOnKeyboardListener0.onKeyboardHidden();
        }
    }

    @Override  // com.kakao.emoticon.ui.KeyboardDetectorLayout$OnKeyboardDetectListener
    public void onKeyboardShown() {
        if(this.isShowingAsView()) {
            this.hide();
        }
        EmoticonOnKeyboardListener emoticonOnKeyboardListener0 = this.emoticonOnKeyboardListener;
        if(emoticonOnKeyboardListener0 != null) {
            emoticonOnKeyboardListener0.onKeyboardShown();
        }
    }

    @Override  // com.kakao.emoticon.interfaces.EmoticonKeyboardActivityListener
    public void onPause() {
    }

    @Override  // com.kakao.emoticon.interfaces.EmoticonKeyboardActivityListener
    public void onResume() {
    }

    public void setContentView(int v) {
        Activity activity0 = this.mContentActivity;
        if(activity0 == null) {
            throw new RuntimeException("activity is null!");
        }
        activity0.setContentView(layout.kakao_emoticon_empty);
        this.initLayout(((ViewGroup)((ViewGroup)this.mContentActivity.findViewById(0x1020002)).getChildAt(0)), View.inflate(this.mContentActivity.getBaseContext(), v, null));
    }

    public void setContentView(View view0) {
        Activity activity0 = this.mContentActivity;
        if(activity0 == null) {
            throw new RuntimeException("activity is null!");
        }
        activity0.setContentView(layout.kakao_emoticon_empty);
        this.initLayout(((ViewGroup)((ViewGroup)this.mContentActivity.findViewById(0x1020002)).getChildAt(0)), view0);
    }

    public void setKeyboardType(ShowType keyboardEmoticonManager$ShowType0) {
        KeyboardHeightHelper keyboardHeightHelper0 = this.keyboardHeightHelper;
        if(keyboardHeightHelper0 != null) {
            keyboardHeightHelper0.setShowType(keyboardEmoticonManager$ShowType0);
        }
        this.keyboardShowType = keyboardEmoticonManager$ShowType0;
    }

    public void setLandscapeKeyboardHeight(int v) {
        if(v >= KakaoEmoticon.getApplication().getResources().getDimensionPixelSize(dimen.emoticon_keyboard_popup_min_height)) {
            this.customLandscapeKeyboardHeight = v;
        }
    }

    public void setLoginClickListener(EmoticonLoginClickListener emoticonLoginClickListener0) {
        this.emoticonSectionViewController.setLoginClickListener(emoticonLoginClickListener0);
    }

    public void setLoginText(String s, String s1) {
        this.emoticonSectionViewController.setLoginText(s, s1);
    }

    public void setOnEmoticonListener(EmoticonTabListener emoticonTabListener0) {
        this.iEmoticonOnListener = emoticonTabListener0;
    }

    public void setOnKeyboardListener(EmoticonOnKeyboardListener emoticonOnKeyboardListener0) {
        this.emoticonOnKeyboardListener = emoticonOnKeyboardListener0;
    }

    public void show() {
        this.emoticonLayout.removeAllViews();
        if(ScreenUtils.INSTANCE.getOrientation() == 2) {
            int v = this.customLandscapeKeyboardHeight;
            if(v > 0) {
                this.keyboardHeightHelper.setKeyboardHeight(v, 2);
                stringBuilder0.toString();
            }
        }
        if(!this.isLazyFirstShow && !this.keyboardHeightHelper.isHeightTooSmall()) {
            int v1 = com.kakao.emoticon.ui.KeyboardEmoticonManager.1.$SwitchMap$com$kakao$emoticon$ui$KeyboardEmoticonManager$ShowType[this.keyboardShowType.ordinal()];
            switch(v1) {
                case 1: {
                    if(this.keyboardDetectorLayout.isKeyboardOn()) {
                        this.showByPopupWindow(this.emoticonSectionViewController.getContentView());
                        return;
                    }
                    SoftInputHelper.showSoftInput(this.emoticonLayout.getContext(), this.emoticonLayout, 1);
                    this.showByAddingView(this.emoticonSectionViewController.getContentView());
                    return;
                }
                case 2: {
                    this.showByAddingView(this.emoticonSectionViewController.getContentView());
                    return;
                }
                default: {
                    if(v1 != 3) {
                        return;
                    }
                    if(this.keyboardDetectorLayout.isKeyboardOn()) {
                        this.showByPopupWindow(this.emoticonSectionViewController.getContentView());
                        return;
                    }
                    this.showByAddingView(this.emoticonSectionViewController.getContentView());
                    return;
                }
            }
        }
        this.isLazyFirstShow = false;
        SoftInputHelper.hideSoftInput(this.emoticonLayout.getContext(), this.emoticonLayout);
        KakaoEmoticon.getMainHandler().postDelayed(new b(this, 3), 100L);
    }

    private void showByAddingView(View view0) {
        if(!this.isSameContentViewShowingByAddingView(view0)) {
            this.emoticonLayout.addView(view0, -1, -1);
            this.adjustViewHeight(this.keyboardHeightHelper.getKeyboardHeight());
            this.emoticonLayout.setVisibility(0);
            EmoticonSectionViewController emoticonSectionViewController0 = this.emoticonSectionViewController;
            if(emoticonSectionViewController0 != null) {
                emoticonSectionViewController0.onViewAppear();
            }
            ActionTracker.pushLog("A001", "01", null);
            EmoticonTabListener emoticonTabListener0 = this.iEmoticonOnListener;
            if(emoticonTabListener0 != null) {
                emoticonTabListener0.onEmoticonTabShown();
            }
        }
    }

    private void showByPopupWindow(View view0) {
        if(!this.isSameContentViewPopupShowing(view0)) {
            PopupWindow popupWindow0 = new PopupWindow(view0, -1, -2, false);
            this.popupWindow = popupWindow0;
            popupWindow0.setInputMethodMode(2);
            popupWindow0.setSoftInputMode(16);
            this.adjustPopupHeight(this.keyboardHeightHelper.getKeyboardHeight());
            popupWindow0.showAtLocation(this.keyboardDetectorLayout, 0, 0, this.getPopupYOffset(this.keyboardHeightHelper.getKeyboardHeight()));
            popupWindow0.setOnDismissListener(() -> PopupWindow popupWindow1 = (PopupWindow)this.contentViewToPopupWindowMap.remove(popupWindow0.getContentView()));
            this.contentViewToPopupWindowMap.put(view0, popupWindow0);
            EmoticonSectionViewController emoticonSectionViewController0 = this.emoticonSectionViewController;
            if(emoticonSectionViewController0 != null) {
                emoticonSectionViewController0.onViewAppear();
            }
            this.dismissOtherPopupWindowsDelayed();
            ActionTracker.pushLog("A001", "01", null);
            EmoticonTabListener emoticonTabListener0 = this.iEmoticonOnListener;
            if(emoticonTabListener0 != null) {
                emoticonTabListener0.onEmoticonTabShown();
            }
        }
    }

    public void showOrHide() {
        if(this.isShowing()) {
            this.hide();
            return;
        }
        this.show();
    }

    class com.kakao.emoticon.ui.KeyboardEmoticonManager.1 {
        static final int[] $SwitchMap$com$kakao$emoticon$ui$KeyboardEmoticonManager$ShowType;

        static {
            int[] arr_v = new int[ShowType.values().length];
            com.kakao.emoticon.ui.KeyboardEmoticonManager.1.$SwitchMap$com$kakao$emoticon$ui$KeyboardEmoticonManager$ShowType = arr_v;
            try {
                arr_v[ShowType.POPUP.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.kakao.emoticon.ui.KeyboardEmoticonManager.1.$SwitchMap$com$kakao$emoticon$ui$KeyboardEmoticonManager$ShowType[ShowType.ADD_VIEW.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.kakao.emoticon.ui.KeyboardEmoticonManager.1.$SwitchMap$com$kakao$emoticon$ui$KeyboardEmoticonManager$ShowType[ShowType.DEFAULT.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

