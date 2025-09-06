package ud;

import E8.a;
import F8.s;
import F8.x;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.I;
import androidx.recyclerview.widget.RecyclerView;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.comments.CmtListFragment;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.ui.BottomSheetUtil;
import com.iloen.melon.utils.ui.EmptyOrErrorViewHelper;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.popup.b;
import kotlin.jvm.internal.q;
import v9.e;
import v9.o;

public final class i extends CmtListFragment {
    public final I a;
    public s b;
    public static final int c;

    public i(I i0) {
        q.g(i0, "fragment");
        super();
        this.a = i0;
    }

    @Override  // com.iloen.melon.fragments.comments.CmtListFragment
    public final View buildParallaxHeaderView() {
        return null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public final f1 getInsetHandlingType() {
        return f1.b;
    }

    @Override  // com.iloen.melon.fragments.comments.CmtListFragment
    public final int getParallaxFixedHeight() {
        return 0;
    }

    @Override  // com.iloen.melon.fragments.comments.CmtListFragment
    public final int getParallaxHeaderHeight() {
        return 0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public final boolean ignoreUpdateVideoScreen() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public final boolean isScreenLandscapeSupported() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.comments.CmtListFragment
    public final RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = super.onCreateRecyclerView();
        if(recyclerView0 != null) {
            recyclerView0.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F0604AB));  // color:white001s
        }
        q.d(recyclerView0);
        return recyclerView0;
    }

    @Override  // com.iloen.melon.fragments.comments.CmtListFragment
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            s s0 = new s();
            this.b = s0;
            TextView textView0 = (TextView)s0.h;
            if(textView0 != null) {
                ViewUtils.showWhen(textView0, false);
                TextView textView1 = (TextView)s0.h;
                if(textView1 != null) {
                    textView1.setText(StringUtils.getCountFormattedString(0));
                }
            }
            x x0 = new x(1);
            x0.c = new a(this, 11);
            titleBar0.c(57.0f);
            titleBar0.setBackgroundColor(0);
            titleBar0.setBackgroundResource(0x7F08091C);  // drawable:shape_white001s_top_round8
            s s1 = this.b;
            if(s1 != null) {
                s1.g(x0);
                titleBar0.a(s1);
                titleBar0.f(false);
                goto label_25;
            }
            q.m("commentCount");
            throw null;
        }
    label_25:
        Object object0 = this.getContentAdapter();
        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.e = -1;
        e0.g = -1;
        e0.i = -1;
        e0.k = -1;
        e0.l = -1;
        e0.d = 0x7F08093C;  // drawable:transparent
        o o0 = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
        o0.c = -1;
        o0.e = -1;
        o0.h = -1;
        o0.i = -1;
        o0.b = 0x7F08093C;  // drawable:transparent
        View view1 = this.mEmptyView;
        if(view1 != null) {
            EmptyOrErrorViewHelper.setEmptyViewInfo(view1, e0);
            EmptyOrErrorViewHelper.setNetworkErrorViewInfo(this.mEmptyView, o0);
            return;
        }
        if(object0 instanceof com.iloen.melon.adapters.common.e) {
            ((com.iloen.melon.adapters.common.e)object0).setEmptyViewInfo(e0);
            ((com.iloen.melon.adapters.common.e)object0).setErrorViewInfo(o0);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public final boolean shouldIgnoreSetOrientation() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.comments.CmtListFragment
    public final boolean shouldShowMiniPlayer() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public final void showLoginPopup() {
        b.l(this.getContext(), this.a.getChildFragmentManager(), null, 12);
        BottomSheetUtil.INSTANCE.dismissBottomSheetFragment(this);
    }

    @Override  // com.iloen.melon.fragments.comments.CmtListFragment
    public final void updateCmtAllCount(int v) {
        super.updateCmtAllCount(v);
        s s0 = this.b;
        if(s0 != null) {
            int v1 = this.getCmtAllCount();
            TextView textView0 = (TextView)s0.h;
            if(textView0 != null) {
                ViewUtils.showWhen(textView0, v1 > 0);
                TextView textView1 = (TextView)s0.h;
                if(textView1 != null) {
                    textView1.setText(StringUtils.getCountFormattedString(v1));
                }
            }
            return;
        }
        q.m("commentCount");
        throw null;
    }
}

