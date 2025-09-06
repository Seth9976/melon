package com.kakaoent.trevi.ad.webview.helper;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/helper/FullscreenHolder;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onTouchEvent", "", "evt", "Landroid/view/MotionEvent;", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class FullscreenHolder extends FrameLayout {
    public FullscreenHolder(@NotNull Context context0) {
        q.g(context0, "context");
        super(context0);
        this.setBackgroundColor(0xFF000000);
    }

    @Override  // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent motionEvent0) {
        q.g(motionEvent0, "evt");
        return true;
    }
}

