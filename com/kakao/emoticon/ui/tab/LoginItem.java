package com.kakao.emoticon.ui.tab;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.kakao.emoticon.R.drawable;
import com.kakao.emoticon.interfaces.EmoticonLoginClickListener;
import com.kakao.emoticon.ui.LoginView;
import com.kakao.emoticon.util.ActionTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0010\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0010\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0018\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u001A\u0010\u001BR\u0016\u0010\u001C\u001A\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001C\u0010\u001DR\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001ER\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001E¨\u0006\u001F"}, d2 = {"Lcom/kakao/emoticon/ui/tab/LoginItem;", "Lcom/kakao/emoticon/ui/tab/EmoticonTabItem;", "Lcom/kakao/emoticon/interfaces/EmoticonLoginClickListener;", "emoticonLoginClickListener", "", "message", "buttonText", "<init>", "(Lcom/kakao/emoticon/interfaces/EmoticonLoginClickListener;Ljava/lang/String;Ljava/lang/String;)V", "getItemId", "()Ljava/lang/String;", "Landroid/widget/ImageView;", "imageView", "Lie/H;", "setIconImage", "(Landroid/widget/ImageView;)V", "setIconOnImage", "actionTrack", "()V", "", "hasContentsView", "()Z", "isSelectable", "Landroid/content/Context;", "context", "Landroid/view/View;", "provideView", "(Landroid/content/Context;)Landroid/view/View;", "loginClickListener", "Lcom/kakao/emoticon/interfaces/EmoticonLoginClickListener;", "Ljava/lang/String;", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class LoginItem extends EmoticonTabItem {
    private final String buttonText;
    private final EmoticonLoginClickListener loginClickListener;
    private final String message;

    public LoginItem(@Nullable EmoticonLoginClickListener emoticonLoginClickListener0, @Nullable String s, @Nullable String s1) {
        this.tabTag = TabTag.LOGIN;
        this.message = s;
        this.buttonText = s1;
        this.loginClickListener = emoticonLoginClickListener0;
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public void actionTrack() {
        ActionTracker.pushLog$default("A001", "07", null, 4, null);
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    @NotNull
    public String getItemId() {
        return "loginItem";
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
    @NotNull
    public View provideView(@NotNull Context context0) {
        q.g(context0, "context");
        return new LoginView(context0, this.message, this.buttonText, this.loginClickListener);
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public void setIconImage(@NotNull ImageView imageView0) {
        q.g(imageView0, "imageView");
        imageView0.setImageResource(drawable.tabmenu_login_off);
    }

    @Override  // com.kakao.emoticon.ui.tab.EmoticonTabItem
    public void setIconOnImage(@NotNull ImageView imageView0) {
        q.g(imageView0, "imageView");
        imageView0.setImageResource(drawable.tabmenu_login_on);
    }
}

