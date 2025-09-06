package ed;

import J8.L2;
import android.os.Bundle;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import com.iloen.melon.net.v6x.response.SearchHotKeywordAndMenuListRes.Contents;
import java.util.List;
import je.p;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.q;

public final class y extends View.AccessibilityDelegate {
    public final a a;
    public final F b;
    public final int c;
    public final List d;
    public final L2 e;

    public y(a z$a0, F f0, int v, List list0, L2 l20) {
        this.a = z$a0;
        this.b = f0;
        this.c = v;
        this.d = list0;
        this.e = l20;
        super();
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
        q.g(view0, "host");
        q.g(accessibilityNodeInfo0, "info");
        super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
        String s = null;
        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000001, (this.a.getContext() == null ? null : "다음 페이지")));
        if(this.a.getContext() != null) {
            s = "이전 페이지";
        }
        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000002, s));
    }

    @Override  // android.view.View$AccessibilityDelegate
    public final boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
        q.g(view0, "host");
        CharSequence charSequence0 = null;
        List list0 = this.d;
        int v1 = this.c;
        L2 l20 = this.e;
        F f0 = this.b;
        switch(v) {
            case 100000001: {
                int v2 = f0.a;
                f0.a = v2 + 1 < v1 ? v2 + 1 : 0;
                if(list0 != null) {
                    Contents searchHotKeywordAndMenuListRes$Contents0 = (Contents)p.n0(f0.a, list0);
                    if(searchHotKeywordAndMenuListRes$Contents0 != null) {
                        charSequence0 = searchHotKeywordAndMenuListRes$Contents0.keyword;
                    }
                }
                l20.e.setText(String.valueOf(f0.a + 1));
                l20.c.setText(charSequence0);
                return true;
            }
            case 100000002: {
                int v3 = f0.a;
                f0.a = v3 - 1 >= 0 ? v3 - 1 : v1 - 1;
                if(list0 != null) {
                    Contents searchHotKeywordAndMenuListRes$Contents1 = (Contents)p.n0(f0.a, list0);
                    if(searchHotKeywordAndMenuListRes$Contents1 != null) {
                        charSequence0 = searchHotKeywordAndMenuListRes$Contents1.keyword;
                    }
                }
                l20.e.setText(String.valueOf(f0.a + 1));
                l20.c.setText(charSequence0);
                return true;
            }
            default: {
                return super.performAccessibilityAction(view0, v, bundle0);
            }
        }
    }
}

