package com.kakao.emoticon.ui.tab;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.kakao.emoticon.KakaoEmoticon;
import com.kakao.emoticon.R.string;
import com.kakao.emoticon.controller.EmoticonResourceLoader;
import com.kakao.emoticon.net.response.Emoticon;
import com.kakao.emoticon.ui.EmoticonExpireView;
import com.kakao.emoticon.util.ActionTracker;

public class ExpiredItem extends EmoticonTabItem {
    public interface OnItemRemoveListener {
        void onRemove(String arg1);
    }

    private final Emoticon emoticon;
    private OnItemRemoveListener onItemRemoveListener;

    public ExpiredItem(Emoticon emoticon0, OnItemRemoveListener expiredItem$OnItemRemoveListener0) {
        this.tabTag = TabTag.EXPIRED_EMOTICON;
        this.emoticon = emoticon0;
        this.onItemRemoveListener = expiredItem$OnItemRemoveListener0;
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public void actionTrack() {
        ActionTracker.incrementTabCount();
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public String getDisplayName() {
        return KakaoEmoticon.getApplication().getApplicationContext().getString(string.label_emoticon_expired);
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
    public View provideView(Context context0) {
        return new EmoticonExpireView(context0, this.emoticon, this.onItemRemoveListener);
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

