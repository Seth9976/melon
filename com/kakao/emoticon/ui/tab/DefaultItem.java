package com.kakao.emoticon.ui.tab;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.kakao.emoticon.KakaoEmoticon;
import com.kakao.emoticon.R.string;
import com.kakao.emoticon.controller.EmoticonResourceLoader;
import com.kakao.emoticon.interfaces.EmoticonClickListener;
import com.kakao.emoticon.net.response.Emoticon;
import com.kakao.emoticon.ui.EmoticonPageView;
import com.kakao.emoticon.util.ActionTracker;

public class DefaultItem extends EmoticonTabItem {
    private final Emoticon emoticon;
    private EmoticonClickListener emoticonClickListener;

    public DefaultItem(Emoticon emoticon0, EmoticonClickListener emoticonClickListener0) {
        this.tabTag = TabTag.EMOTICON;
        this.emoticon = emoticon0;
        this.emoticonClickListener = emoticonClickListener0;
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public void actionTrack() {
        ActionTracker.incrementTabCount();
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public String getDisplayName() {
        return KakaoEmoticon.getApplication().getApplicationContext().getString(string.label_for_default_emoticon_title);
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public String getItemId() {
        return this.emoticon.getId();
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public boolean hasContentsView() {
        return true;
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public boolean isSelectable() {
        return true;
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public View provideView(Context context0) {
        return new EmoticonPageView(context0, this.emoticon, this.emoticonClickListener);
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public void setIconImage(ImageView imageView0) {
        EmoticonResourceLoader.INSTANCE.loadOffIcon(imageView0, this.emoticon);
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public void setIconOnImage(ImageView imageView0) {
        EmoticonResourceLoader.INSTANCE.loadOnIcon(imageView0, this.emoticon);
    }
}

