package com.kakao.emoticon.ui;

import android.content.Context;
import com.kakao.emoticon.KakaoEmoticon;
import com.kakao.emoticon.R.dimen;
import com.kakao.emoticon.util.ScreenUtils;

public class DefaultViewSizeProvider {
    private static int landscapePagerHeight;
    private static int portraitPagerHeight;

    public static int getEmoticonIconTabHeight() {
        return (int)KakaoEmoticon.getApplication().getResources().getDimension(dimen.emoticon_tab_height);
    }

    private static int getLandscapePagerHeight() {
        return DefaultViewSizeProvider.landscapePagerHeight == 0 ? ((int)KakaoEmoticon.getApplication().getResources().getDimension(dimen.emoticon_keyboard_height_landscape)) - DefaultViewSizeProvider.getEmoticonIconTabHeight() : DefaultViewSizeProvider.landscapePagerHeight;
    }

    // 去混淆评级： 低(20)
    public static int getMeasuredPagerHeight() {
        return ScreenUtils.INSTANCE.isLandscape() ? DefaultViewSizeProvider.landscapePagerHeight : DefaultViewSizeProvider.portraitPagerHeight;
    }

    // 去混淆评级： 低(20)
    public static int getPagerHeight() {
        return ScreenUtils.INSTANCE.isLandscape() ? DefaultViewSizeProvider.getLandscapePagerHeight() : DefaultViewSizeProvider.getPortraitPagerHeight();
    }

    private static int getPortraitPagerHeight() {
        return DefaultViewSizeProvider.portraitPagerHeight == 0 ? ((int)KakaoEmoticon.getApplication().getResources().getDimension(dimen.emoticon_keyboard_height)) - DefaultViewSizeProvider.getEmoticonIconTabHeight() : DefaultViewSizeProvider.portraitPagerHeight;
    }

    public static void setMeasuredPagerHeight(Context context0, int v) {
        if(v > 0) {
            ScreenUtils screenUtils0 = ScreenUtils.INSTANCE;
            if(v <= screenUtils0.getHeight(context0)) {
                if(screenUtils0.isLandscape()) {
                    DefaultViewSizeProvider.landscapePagerHeight = v;
                    return;
                }
                DefaultViewSizeProvider.portraitPagerHeight = v;
            }
        }
    }
}

