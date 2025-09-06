package ed;

import De.I;
import J8.L2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.iloen.melon.custom.MelonTextView;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.q;
import we.o;

public final class x extends n implements o {
    public static final x b;

    static {
        x.b = new x(3, L2.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/iloen/melon/databinding/SearchHotkeywordCollapseLayoutBinding;", 0);  // 初始化器: Lkotlin/jvm/internal/n;-><init>(ILjava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        q.g(((LayoutInflater)object0), "p0");
        View view0 = ((LayoutInflater)object0).inflate(0x7F0D080C, ((ViewGroup)object1), false);  // layout:search_hotkeyword_collapse_layout
        if(((Boolean)object2).booleanValue()) {
            ((ViewGroup)object1).addView(view0);
        }
        int v = 0x7F0A0473;  // id:expand_btn
        View view1 = I.C(view0, 0x7F0A0473);  // id:expand_btn
        if(((FrameLayout)view1) != null) {
            v = 0x7F0A0540;  // id:hot_keyword
            View view2 = I.C(view0, 0x7F0A0540);  // id:hot_keyword
            if(((MelonTextView)view2) != null) {
                v = 0x7F0A0541;  // id:hotkeyword_container
                View view3 = I.C(view0, 0x7F0A0541);  // id:hotkeyword_container
                if(((LinearLayout)view3) != null) {
                    v = 0x7F0A09AC;  // id:rank
                    View view4 = I.C(view0, 0x7F0A09AC);  // id:rank
                    if(((MelonTextView)view4) != null) {
                        return new L2(((LinearLayout)view0), ((FrameLayout)view1), ((MelonTextView)view2), ((LinearLayout)view3), ((MelonTextView)view4));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }
}

