package com.kakao.emoticon.ui.tab;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.j;
import com.kakao.emoticon.R.drawable;
import com.kakao.emoticon.util.IntentUtils;
import com.kakao.emoticon.util.SoftInputHelper;

public class StoreItem extends EmoticonTabItem {
    public StoreItem() {
        this.tabTag = TabTag.STORE;
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public void doClick(Context context0, View view0) {
        SoftInputHelper.hideSoftInput(context0, view0);
        view0.postDelayed(new j(context0, 1), 200L);
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public String getItemId() {
        return "storeItem";
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public boolean hasContentsView() {
        return false;
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public boolean isSelectable() {
        return false;
    }

    private static void lambda$doClick$0(Context context0) {
        IntentUtils.goToEmoticonStoreAlert(context0, "com.iloen.melon", "tab");
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public void setIconImage(ImageView imageView0) {
        imageView0.setImageResource(drawable.store_tabmenu);
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public void setIconOnImage(ImageView imageView0) {
    }
}

