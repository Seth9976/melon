package com.iloen.melon.fragments.settings;

import B.a;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.custom.RadioGroup;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.FetcherBaseFragment;
import com.iloen.melon.utils.ui.ViewTreeObserverHelper.OnGlobalLayoutListener;
import com.iloen.melon.utils.ui.ViewTreeObserverHelper;
import v9.h;
import v9.i;

public abstract class SettingBaseFragment extends FetcherBaseFragment {
    private static final String TAG = "SettingBaseFragment";
    private ViewTreeObserverHelper observerHelper;

    private void calculateScrollView(ScrollView scrollView0) {
        ViewTreeObserverHelper viewTreeObserverHelper0 = this.observerHelper;
        if(viewTreeObserverHelper0 != null) {
            viewTreeObserverHelper0.unregisterGlobalLayoutListener();
            this.observerHelper = null;
        }
        ViewTreeObserverHelper viewTreeObserverHelper1 = new ViewTreeObserverHelper();
        this.observerHelper = viewTreeObserverHelper1;
        viewTreeObserverHelper1.registerGlobalLayoutListener(scrollView0, new OnGlobalLayoutListener() {
            @Override  // com.iloen.melon.utils.ui.ViewTreeObserverHelper$OnGlobalLayoutListener
            public void onGlobalLayout() {
                scrollView0.requestLayout();
            }
        });
    }

    public void calculateScrollView(View view0) {
        if(view0 instanceof ScrollView) {
            this.calculateScrollView(((ScrollView)view0));
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return null;
    }

    public abstract int getTitleResId();

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        ViewTreeObserverHelper viewTreeObserverHelper0 = this.observerHelper;
        if(viewTreeObserverHelper0 != null) {
            viewTreeObserverHelper0.unregisterGlobalLayoutListener();
            this.observerHelper = null;
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setTitle(this.getContext().getString(this.getTitleResId()));
            titleBar0.f(true);
        }
    }

    public void setAccessibilityRadioGroup(RadioGroup radioGroup0, int v, String[] arr_s, int[] arr_v) {
        int v4;
        int v2 = 0;
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            int v3 = arr_v[v1];
            if(v3 == v) {
                v4 = v2 + 1;
                radioGroup0.c(v3, String.format(this.getString(0x7F130AF3), arr_s[v2]));  // string:talkback_common_select "%s 선택됨"
            }
            else {
                v4 = v2 + 1;
                radioGroup0.c(v3, String.format(this.getString(0x7F130AF7), arr_s[v2]));  // string:talkback_common_unselect "%s 선택해제"
            }
            v2 = v4;
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }
}

