package com.iloen.melon.fragments.main.common;

import android.content.Context;
import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import androidx.fragment.app.I;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import p8.s;
import y5.a;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\'\u0018\u0000 O*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u00032\u00020\u0004:\u0001OB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u00A2\u0006\u0004\b\u0007\u0010\bB\u001B\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\b\u0010\n\u001A\u0004\u0018\u00010\t\u00A2\u0006\u0004\b\u0007\u0010\u000BJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00028\u0000H\u0017\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u00A2\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\u00052\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0004\u00A2\u0006\u0004\b\u0014\u0010\u000BJ\u0017\u0010\u0017\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001A\u00020\u0015\u00A2\u0006\u0004\b\u0017\u0010\u0018Jm\u0010\"\u001A\u00020\r2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010\u00192\n\b\u0002\u0010 \u001A\u0004\u0018\u00010\u00192\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\u0019H\u0016\u00A2\u0006\u0004\b\"\u0010#R$\u0010$\u001A\u0004\u0018\u00010\t8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b$\u0010%\u001A\u0004\b&\u0010\'\"\u0004\b(\u0010)R$\u0010+\u001A\u0004\u0018\u00010*8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b+\u0010,\u001A\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00102\u001A\u0004\u0018\u0001018\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b2\u00103\u001A\u0004\b4\u00105\"\u0004\b6\u00107R$\u00108\u001A\u0004\u0018\u00010\u00198\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b8\u00109\u001A\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010?\u001A\u0004\u0018\u00010>8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b?\u0010@\u001A\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010E\u001A\u0004\u0018\u00010\u00198\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bE\u00109\u001A\u0004\bF\u0010;\"\u0004\bG\u0010=R$\u0010I\u001A\u0004\u0018\u00010H8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bI\u0010J\u001A\u0004\bK\u0010L\"\u0004\bM\u0010N\u00A8\u0006P"}, d2 = {"Lcom/iloen/melon/fragments/main/common/TabItemViewHolder;", "ITEM", "Lcom/iloen/melon/fragments/main/common/DetailViewHolderInterface;", "Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Lcom/iloen/melon/fragments/main/common/OnItemViewClickListener;", "listener", "(Landroid/view/View;Lcom/iloen/melon/fragments/main/common/OnItemViewClickListener;)V", "row", "Lie/H;", "onBindView", "(Ljava/lang/Object;)V", "Landroidx/fragment/app/I;", "getCurrentFragment", "()Landroidx/fragment/app/I;", "view", "init", "", "resourceId", "findViewById", "(I)Landroid/view/View;", "", "clickLayer1", "clickCopy", "actionName", "id", "name", "type", "page", "clickImpressionProvider", "titleTiaraClickLog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onItemViewClickListener", "Lcom/iloen/melon/fragments/main/common/OnItemViewClickListener;", "getOnItemViewClickListener", "()Lcom/iloen/melon/fragments/main/common/OnItemViewClickListener;", "setOnItemViewClickListener", "(Lcom/iloen/melon/fragments/main/common/OnItemViewClickListener;)V", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "slotStatsElementsBase", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getSlotStatsElementsBase", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "setSlotStatsElementsBase", "(Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "Lcom/iloen/melon/fragments/main/common/MainTabTitleView;", "titleView", "Lcom/iloen/melon/fragments/main/common/MainTabTitleView;", "getTitleView", "()Lcom/iloen/melon/fragments/main/common/MainTabTitleView;", "setTitleView", "(Lcom/iloen/melon/fragments/main/common/MainTabTitleView;)V", "menuId", "Ljava/lang/String;", "getMenuId", "()Ljava/lang/String;", "setMenuId", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "pageImpressionId", "getPageImpressionId", "setPageImpressionId", "Lp8/s;", "melonTiaraProperty", "Lp8/s;", "getMelonTiaraProperty", "()Lp8/s;", "setMelonTiaraProperty", "(Lp8/s;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class TabItemViewHolder extends ViewableCheckViewHolder implements View.OnAttachStateChangeListener, DetailViewHolderInterface {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/main/common/TabItemViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "TIARA_POSITION_BASE", "", "TIARA_POSITION_BASE_WITH_TAB_TITLE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "TabItemViewHolder";
    public static final int TIARA_POSITION_BASE = 1;
    public static final int TIARA_POSITION_BASE_WITH_TAB_TITLE;
    @Nullable
    private Context context;
    @Nullable
    private s melonTiaraProperty;
    @Nullable
    private String menuId;
    @Nullable
    private OnItemViewClickListener onItemViewClickListener;
    @Nullable
    private String pageImpressionId;
    @Nullable
    private StatsElementsBase slotStatsElementsBase;
    @Nullable
    private MainTabTitleView titleView;

    static {
        TabItemViewHolder.Companion = new Companion(null);
        TabItemViewHolder.$stable = 8;
    }

    public TabItemViewHolder(@NotNull View view0) {
        q.g(view0, "itemView");
        super(view0);
        this.init(view0, null);
    }

    public TabItemViewHolder(@NotNull View view0, @Nullable OnItemViewClickListener onItemViewClickListener0) {
        q.g(view0, "itemView");
        super(view0);
        this.init(view0, onItemViewClickListener0);
    }

    @Nullable
    public final View findViewById(int v) {
        return this.itemView.findViewById(v);
    }

    @Nullable
    public final Context getContext() {
        return this.context;
    }

    @Override  // com.iloen.melon.fragments.main.common.ViewableCheckViewHolder
    @Nullable
    public final I getCurrentFragment() {
        return MelonFragmentManager.getInstance().getCurrentFragment();
    }

    @Nullable
    public final s getMelonTiaraProperty() {
        return this.melonTiaraProperty;
    }

    @Nullable
    public final String getMenuId() {
        return this.menuId;
    }

    @Nullable
    public final OnItemViewClickListener getOnItemViewClickListener() {
        return this.onItemViewClickListener;
    }

    @Nullable
    public final String getPageImpressionId() {
        return this.pageImpressionId;
    }

    @Nullable
    public final StatsElementsBase getSlotStatsElementsBase() {
        return this.slotStatsElementsBase;
    }

    @Nullable
    public final MainTabTitleView getTitleView() {
        return this.titleView;
    }

    public final void init(@NotNull View view0, @Nullable OnItemViewClickListener onItemViewClickListener0) {
        q.g(view0, "view");
        this.onItemViewClickListener = onItemViewClickListener0;
        this.context = view0.getContext();
        View view1 = view0.findViewById(0x7F0A07CA);  // id:main_contents_title
        this.titleView = view1 instanceof MainTabTitleView ? ((MainTabTitleView)view1) : null;
        LinearLayout.LayoutParams linearLayout$LayoutParams0 = new LinearLayout.LayoutParams(-1, -2);
        this.itemView.setLayoutParams(linearLayout$LayoutParams0);
    }

    @Override  // com.iloen.melon.fragments.main.common.DetailViewHolderInterface
    public void onBindView(Object object0) {
        if(object0 instanceof AdapterInViewHolder.Row) {
            this.menuId = ((AdapterInViewHolder.Row)object0).getMenuId();
            this.pageImpressionId = ((AdapterInViewHolder.Row)object0).getPageImpressionId();
            this.melonTiaraProperty = ((AdapterInViewHolder.Row)object0).getMelonTiaraProperty();
        }
    }

    public final void setContext(@Nullable Context context0) {
        this.context = context0;
    }

    public final void setMelonTiaraProperty(@Nullable s s0) {
        this.melonTiaraProperty = s0;
    }

    public final void setMenuId(@Nullable String s) {
        this.menuId = s;
    }

    public final void setOnItemViewClickListener(@Nullable OnItemViewClickListener onItemViewClickListener0) {
        this.onItemViewClickListener = onItemViewClickListener0;
    }

    public final void setPageImpressionId(@Nullable String s) {
        this.pageImpressionId = s;
    }

    public final void setSlotStatsElementsBase(@Nullable StatsElementsBase statsElementsBase0) {
        this.slotStatsElementsBase = statsElementsBase0;
    }

    public final void setTitleView(@Nullable MainTabTitleView mainTabTitleView0) {
        this.titleView = mainTabTitleView0;
    }

    public void titleTiaraClickLog(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7) {
        if(this.context != null) {
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.e = s3;
            g0.g = s4;
            g0.h = s4;
            g0.f = s5;
            g0.a = s2;
            String s8 = null;
            g0.b = this.melonTiaraProperty == null ? null : this.melonTiaraProperty.a;
            g0.c = s6;
            g0.y = s;
            g0.F = s1;
            g0.H = s7;
            g0.I = this.menuId;
            StatsElementsBase statsElementsBase0 = this.slotStatsElementsBase;
            if(statsElementsBase0 != null) {
                s8 = statsElementsBase0.rangeCode;
            }
            g0.J = s8;
            g0.a().track();
        }
    }

    public static void titleTiaraClickLog$default(TabItemViewHolder tabItemViewHolder0, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, int v, Object object0) {
        String s8;
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: titleTiaraClickLog");
        }
        if((v & 2) != 0) {
            s1 = a.K(tabItemViewHolder0, 0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
        }
        if((v & 4) != 0) {
            s2 = a.K(tabItemViewHolder0, 0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        }
        if((v & 0x40) == 0) {
            s8 = s6;
        }
        else {
            s8 = tabItemViewHolder0.melonTiaraProperty == null ? null : tabItemViewHolder0.melonTiaraProperty.b;
        }
        tabItemViewHolder0.titleTiaraClickLog(s, s1, s2, ((v & 8) == 0 ? s3 : null), ((v & 16) == 0 ? s4 : null), ((v & 0x20) == 0 ? s5 : null), s8, ((v & 0x80) == 0 ? s7 : null));
    }
}

