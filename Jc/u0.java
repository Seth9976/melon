package Jc;

import android.content.Context;
import android.os.Bundle;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.Arrays;
import kotlin.jvm.internal.q;

public final class u0 extends View.AccessibilityDelegate {
    public final Context a;
    public final X b;
    public final v0 c;

    public u0(Context context0, X x0, v0 v00) {
        this.a = context0;
        this.b = x0;
        this.c = v00;
        super();
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
        q.g(view0, "host");
        q.g(accessibilityNodeInfo0, "info");
        super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000001, this.a.getString((this.b.M ? 0x7F130C5A : 0x7F130C58))));  // string:talkback_songlist_unselect "선택 해제하기"
        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000002, "재생"));
        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000003, "앨범 정보"));
        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000004, "더보기"));
        q.f("%1$s, 아티스트 %2$s", "getString(...)");
        accessibilityNodeInfo0.setContentDescription((this.b.M ? "선택됨, " : "") + String.format("%1$s, 아티스트 %2$s", Arrays.copyOf(new Object[]{this.c.a.n.getText(), this.c.a.j.getText()}, 2)));
        accessibilityNodeInfo0.setHintText("두 번 탭하여 선택하거나 해제할 수 있습니다.");
        accessibilityNodeInfo0.setClassName("android.widget.Button");
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
        q.g(view0, "host");
        v0 v00 = this.c;
        switch(v) {
            case 100000001: {
                v00.a.a.performClick();
                return true;
            }
            case 100000002: {
                v00.a.c.performClick();
                return true;
            }
            case 100000003: {
                v00.a.h.a.performClick();
                return true;
            }
            case 100000004: {
                v00.a.b.performClick();
                return true;
            }
            default: {
                return super.performAccessibilityAction(view0, v, bundle0);
            }
        }
    }
}

