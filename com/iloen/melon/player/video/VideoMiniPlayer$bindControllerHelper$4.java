package com.iloen.melon.player.video;

import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/iloen/melon/player/video/VideoMiniPlayer$bindControllerHelper$4", "Landroid/view/View$AccessibilityDelegate;", "Landroid/view/View;", "host", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "Lie/H;", "onInitializeAccessibilityNodeInfo", "(Landroid/view/View;Landroid/view/accessibility/AccessibilityNodeInfo;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoMiniPlayer.bindControllerHelper.4 extends View.AccessibilityDelegate {
    public final VideoMiniPlayer a;

    public VideoMiniPlayer.bindControllerHelper.4(VideoMiniPlayer videoMiniPlayer0) {
        this.a = videoMiniPlayer0;
        super();
    }

    @Override  // android.view.View$AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
        q.g(view0, "host");
        q.g(accessibilityNodeInfo0, "info");
        super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
        accessibilityNodeInfo0.setClassName("android.widget.Button");
        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, "전체플레이어로 이동"));
    }
}

