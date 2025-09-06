package com.kakao.emoticon.ui.tab;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

public abstract class EmoticonTabItem {
    public static enum TabTag {
        EMOTICON,
        DOWNLOADABLE_EMOTICON,
        LOGIN,
        SETTING,
        STORE,
        EXPIRED_EMOTICON;

    }

    public TabTag tabTag;

    public void actionTrack() {
    }

    public void doClick(Context context0, View view0) {
    }

    public String getDisplayName() {
        return null;
    }

    public abstract String getItemId();

    public abstract boolean hasContentsView();

    public boolean isSelectable() {
        return true;
    }

    public void onSelected() {
    }

    public View provideView(Context context0) {
        return null;
    }

    public abstract void setIconImage(ImageView arg1);

    public abstract void setIconOnImage(ImageView arg1);
}

