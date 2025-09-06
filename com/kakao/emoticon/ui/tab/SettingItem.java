package com.kakao.emoticon.ui.tab;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.kakao.emoticon.R.drawable;
import com.kakao.emoticon.activity.EmoticonSettingActivity;
import com.kakao.emoticon.util.ActionTracker;
import com.kakao.emoticon.util.SoftInputHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\f\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000BJ\u000F\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u0003J\u000F\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0015\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0017\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0017\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/kakao/emoticon/ui/tab/SettingItem;", "Lcom/kakao/emoticon/ui/tab/EmoticonTabItem;", "<init>", "()V", "", "getItemId", "()Ljava/lang/String;", "Landroid/widget/ImageView;", "imageView", "Lie/H;", "setIconImage", "(Landroid/widget/ImageView;)V", "setIconOnImage", "actionTrack", "", "hasContentsView", "()Z", "Landroid/content/Context;", "context", "Landroid/view/View;", "view", "doClick", "(Landroid/content/Context;Landroid/view/View;)V", "isSelectable", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class SettingItem extends EmoticonTabItem {
    public SettingItem() {
        this.tabTag = TabTag.SETTING;
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public void actionTrack() {
        ActionTracker.pushLog$default("A001", "03", null, 4, null);
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public void doClick(@NotNull Context context0, @NotNull View view0) {
        q.g(context0, "context");
        q.g(view0, "view");
        SoftInputHelper.hideSoftInput(context0, view0);
        view0.postDelayed(new Runnable() {
            @Override
            public final void run() {
                try {
                    Intent intent0 = new Intent(this.$context, EmoticonSettingActivity.class);
                    this.$context.startActivity(intent0);
                }
                catch(Exception unused_ex) {
                }
            }
        }, 200L);
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    @NotNull
    public String getItemId() {
        return "settingItem";
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public boolean hasContentsView() {
        return false;
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public boolean isSelectable() {
        return false;
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public void setIconImage(@NotNull ImageView imageView0) {
        q.g(imageView0, "imageView");
        imageView0.setImageResource(drawable.emoticon_tabmenu_setting);
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public void setIconOnImage(@NotNull ImageView imageView0) {
        q.g(imageView0, "imageView");
    }
}

