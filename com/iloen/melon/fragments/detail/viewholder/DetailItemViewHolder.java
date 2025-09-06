package com.iloen.melon.fragments.detail.viewholder;

import Q4.a;
import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout.LayoutParams;
import androidx.fragment.app.I;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.main.common.DetailViewHolderInterface;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000F\b\'\u0018\u0000 B*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001BB\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00028\u0000H\u0017\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH&\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001A\u00020\u000E2\u0006\u0010\u0015\u001A\u00020\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u001D\u0010\u0016\u001A\u00020\u000E2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0018\u001A\u00020\u000E\u00A2\u0006\u0004\b\u0016\u0010\u0019J\u0017\u0010\u001B\u001A\u00020\u000B2\b\u0010\u001A\u001A\u0004\u0018\u00010\u000E\u00A2\u0006\u0004\b\u001B\u0010\u001CJ+\u0010\u001B\u001A\u00020\u000B2\b\u0010\u001A\u001A\u0004\u0018\u00010\u000E2\b\u0010\u001D\u001A\u0004\u0018\u00010\u000E2\b\u0010\u001E\u001A\u0004\u0018\u00010\u000E\u00A2\u0006\u0004\b\u001B\u0010\u001FR\"\u0010 \u001A\u00020\u00068\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b \u0010!\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010\'\u001A\u0004\u0018\u00010&8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b\'\u0010(\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010.\u001A\u0004\u0018\u00010-8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b.\u0010/\u001A\u0004\b0\u00101\"\u0004\b2\u00103R$\u00105\u001A\u0004\u0018\u0001048\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b5\u00106\u001A\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010;\u001A\u0004\u0018\u00010\u000E8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b;\u0010<\u001A\u0004\b=\u0010\u0010\"\u0004\b>\u0010\u001CR$\u0010?\u001A\u0004\u0018\u00010\u000E8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b?\u0010<\u001A\u0004\b@\u0010\u0010\"\u0004\bA\u0010\u001C\u00A8\u0006C"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "ITEM", "Landroidx/recyclerview/widget/O0;", "Lcom/iloen/melon/fragments/main/common/DetailViewHolderInterface;", "LQ4/a;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "listener", "<init>", "(LQ4/a;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "row", "Lie/H;", "onBindView", "(Ljava/lang/Object;)V", "", "getTitleName", "()Ljava/lang/String;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "getCurrentFragment", "()Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "", "resourceId", "getString", "(I)Ljava/lang/String;", "string", "(ILjava/lang/String;)Ljava/lang/String;", "clickLayer1", "titleTiaraClickLog", "(Ljava/lang/String;)V", "clickCopy", "actionName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "getOnViewHolderActionListener", "()Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "setOnViewHolderActionListener", "(Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "statsElementsBase", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElementsBase", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "setStatsElementsBase", "(Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "Lcom/iloen/melon/fragments/main/common/MainTabTitleView;", "titleView", "Lcom/iloen/melon/fragments/main/common/MainTabTitleView;", "getTitleView", "()Lcom/iloen/melon/fragments/main/common/MainTabTitleView;", "setTitleView", "(Lcom/iloen/melon/fragments/main/common/MainTabTitleView;)V", "menuId", "Ljava/lang/String;", "getMenuId", "setMenuId", "pageImpressionId", "getPageImpressionId", "setPageImpressionId", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class DetailItemViewHolder extends O0 implements DetailViewHolderInterface {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "TIARA_POSITION_BASE", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
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
    private static final String TAG = "DetailItemViewHolder";
    public static final int TIARA_POSITION_BASE = 1;
    @Nullable
    private Context context;
    @Nullable
    private String menuId;
    @NotNull
    private OnViewHolderActionBaseListener onViewHolderActionListener;
    @Nullable
    private String pageImpressionId;
    @Nullable
    private StatsElementsBase statsElementsBase;
    @Nullable
    private MainTabTitleView titleView;

    static {
        DetailItemViewHolder.Companion = new Companion(null);
        DetailItemViewHolder.$stable = 8;
    }

    public DetailItemViewHolder(@NotNull a a0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(a0, "bind");
        q.g(onViewHolderActionBaseListener0, "listener");
        super(a0.getRoot());
        this.onViewHolderActionListener = onViewHolderActionBaseListener0;
        this.context = a0.getRoot().getContext();
        LinearLayout.LayoutParams linearLayout$LayoutParams0 = new LinearLayout.LayoutParams(-1, -2);
        this.itemView.setLayoutParams(linearLayout$LayoutParams0);
    }

    @Nullable
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final MetaContentBaseFragment getCurrentFragment() {
        I i0 = MelonFragmentManager.getInstance().getCurrentFragment();
        return i0 instanceof MetaContentBaseFragment ? ((MetaContentBaseFragment)i0) : null;
    }

    @Nullable
    public final String getMenuId() {
        return this.menuId;
    }

    @NotNull
    public final OnViewHolderActionBaseListener getOnViewHolderActionListener() {
        return this.onViewHolderActionListener;
    }

    @Nullable
    public final String getPageImpressionId() {
        return this.pageImpressionId;
    }

    @Nullable
    public final StatsElementsBase getStatsElementsBase() {
        return this.statsElementsBase;
    }

    @NotNull
    public final String getString(int v) {
        Context context0 = this.context;
        if(context0 != null) {
            Resources resources0 = context0.getResources();
            if(resources0 != null) {
                String s = resources0.getString(v);
                return s == null ? "" : s;
            }
        }
        return "";
    }

    @NotNull
    public final String getString(int v, @NotNull String s) {
        q.g(s, "string");
        Context context0 = this.context;
        if(context0 != null) {
            Resources resources0 = context0.getResources();
            if(resources0 != null) {
                String s1 = resources0.getString(v, new Object[]{s});
                return s1 == null ? "" : s1;
            }
        }
        return "";
    }

    @NotNull
    public abstract String getTitleName();

    @Nullable
    public final MainTabTitleView getTitleView() {
        return this.titleView;
    }

    @Override  // com.iloen.melon.fragments.main.common.DetailViewHolderInterface
    public void onBindView(Object object0) {
        if(object0 instanceof AdapterInViewHolder.Row) {
            this.menuId = ((AdapterInViewHolder.Row)object0).getMenuId();
            this.pageImpressionId = ((AdapterInViewHolder.Row)object0).getPageImpressionId();
        }
    }

    public final void setContext(@Nullable Context context0) {
        this.context = context0;
    }

    public final void setMenuId(@Nullable String s) {
        this.menuId = s;
    }

    public final void setOnViewHolderActionListener(@NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(onViewHolderActionBaseListener0, "<set-?>");
        this.onViewHolderActionListener = onViewHolderActionBaseListener0;
    }

    public final void setPageImpressionId(@Nullable String s) {
        this.pageImpressionId = s;
    }

    public final void setStatsElementsBase(@Nullable StatsElementsBase statsElementsBase0) {
        this.statsElementsBase = statsElementsBase0;
    }

    public final void setTitleView(@Nullable MainTabTitleView mainTabTitleView0) {
        this.titleView = mainTabTitleView0;
    }

    public final void titleTiaraClickLog(@Nullable String s) {
        this.titleTiaraClickLog(s, this.getString(0x7F130DB1), this.getString(0x7F130DC9));  // string:tiara_click_copy_view_all "전체보기"
    }

    public final void titleTiaraClickLog(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        if(this.context != null) {
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.a = s2;
            g0.b = this.getString(0x7F130E4B);  // string:tiara_common_section "멜론홈탭"
            g0.c = this.getString(0x7F130E52);  // string:tiara_common_section_music "멜론홈탭_뮤직"
            g0.y = s;
            g0.F = s1;
            g0.I = this.menuId;
            g0.J = this.statsElementsBase == null ? null : this.statsElementsBase.rangeCode;
            g0.a().track();
        }
    }
}

