package com.iloen.melon.popup;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.PopupTextListAdapter;
import com.iloen.melon.adapters.RecyclerItemClickListener.OnItemClickListener;
import com.iloen.melon.adapters.common.RecyclerViewCursorAdapter;
import com.iloen.melon.adapters.common.i;
import com.iloen.melon.custom.l1;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\b\'\u0018\u0000 u2\u00020\u0001:\u0001uB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016\u00A2\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000E\u001A\b\u0012\u0002\b\u0003\u0018\u00010\r2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH$\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0015\u0010\u0010\u001A\b\u0012\u0002\b\u0003\u0018\u00010\rH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0017J\u0015\u0010\u001B\u001A\u00020\b2\u0006\u0010\u001A\u001A\u00020\u0019\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u001D\u0010\u0017J\u000F\u0010\u001E\u001A\u00020\bH\u0004\u00A2\u0006\u0004\b\u001E\u0010\u0017J\u0015\u0010 \u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\u0019\u00A2\u0006\u0004\b \u0010\u001CJ\u0015\u0010#\u001A\u00020\b2\u0006\u0010\"\u001A\u00020!\u00A2\u0006\u0004\b#\u0010$J\u0019\u0010\'\u001A\u00020\b2\b\u0010&\u001A\u0004\u0018\u00010%H\u0016\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010\'\u001A\u00020\b2\u0006\u0010)\u001A\u00020!H\u0016\u00A2\u0006\u0004\b\'\u0010$J#\u0010\'\u001A\u00020\b2\b\u0010+\u001A\u0004\u0018\u00010*2\b\u0010,\u001A\u0004\u0018\u00010*H\u0016\u00A2\u0006\u0004\b\'\u0010-J\u0017\u0010.\u001A\u00020\b2\u0006\u0010\u001A\u001A\u00020\u0019H\u0014\u00A2\u0006\u0004\b.\u0010\u001CJ\u0011\u00100\u001A\u0004\u0018\u00010/H\u0016\u00A2\u0006\u0004\b0\u00101J\u000F\u00102\u001A\u00020!H\u0014\u00A2\u0006\u0004\b2\u00103J\u0015\u00104\u001A\b\u0012\u0002\b\u0003\u0018\u00010\rH\u0014\u00A2\u0006\u0004\b4\u0010\u0011J\u0011\u00105\u001A\u0004\u0018\u00010*H\u0014\u00A2\u0006\u0004\b5\u00106J\u0011\u00108\u001A\u0004\u0018\u000107H\u0004\u00A2\u0006\u0004\b8\u00109J\u0019\u0010;\u001A\u00020\b2\b\u0010:\u001A\u0004\u0018\u000107H\u0004\u00A2\u0006\u0004\b;\u0010<J\u000F\u0010=\u001A\u00020\u0019H\u0014\u00A2\u0006\u0004\b=\u0010>J\u000F\u0010?\u001A\u00020!H\u0014\u00A2\u0006\u0004\b?\u00103J\u000F\u0010@\u001A\u00020\u0019H\u0014\u00A2\u0006\u0004\b@\u0010>J\u000F\u0010A\u001A\u00020\u0019H\u0014\u00A2\u0006\u0004\bA\u0010>J\u000F\u0010B\u001A\u00020\u0019H\u0004\u00A2\u0006\u0004\bB\u0010>J\u000F\u0010C\u001A\u00020!H\u0014\u00A2\u0006\u0004\bC\u00103J\u000F\u0010D\u001A\u00020\bH\u0014\u00A2\u0006\u0004\bD\u0010\u0017R\"\u0010E\u001A\u00020!8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bE\u0010F\u001A\u0004\bG\u00103\"\u0004\bH\u0010$R\"\u0010I\u001A\u00020!8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bI\u0010F\u001A\u0004\bJ\u00103\"\u0004\bK\u0010$R$\u0010L\u001A\u0004\u0018\u00010/8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bL\u0010M\u001A\u0004\bN\u00101\"\u0004\bO\u0010PR$\u0010Q\u001A\u0004\u0018\u00010/8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bQ\u0010M\u001A\u0004\bR\u00101\"\u0004\bS\u0010PR$\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b\u0007\u0010T\u001A\u0004\bU\u0010V\"\u0004\bW\u0010\nR$\u0010Y\u001A\u0004\u0018\u00010X8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bY\u0010Z\u001A\u0004\b[\u0010\\\"\u0004\b]\u0010^R$\u0010`\u001A\u0004\u0018\u00010_8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b`\u0010a\u001A\u0004\bb\u0010c\"\u0004\bd\u0010eR$\u0010f\u001A\u0004\u0018\u00010/8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bf\u0010M\u001A\u0004\bg\u00101\"\u0004\bh\u0010PR$\u0010i\u001A\u0004\u0018\u00010/8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bi\u0010M\u001A\u0004\bj\u00101\"\u0004\bk\u0010PR$\u0010&\u001A\u0004\u0018\u00010*8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\b&\u0010l\u001A\u0004\bm\u00106\"\u0004\b\'\u0010nR\u0018\u0010o\u001A\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bo\u0010lR\u0016\u0010p\u001A\u00020\u00198\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010r\u001A\u00020!8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\br\u0010FR\u0014\u0010t\u001A\u00020!8TX\u0094\u0004\u00A2\u0006\u0006\u001A\u0004\bs\u00103\u00A8\u0006v"}, d2 = {"Lcom/iloen/melon/popup/AbsListPopup;", "Lcom/iloen/melon/popup/MelonBaseListPopup;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "Lcom/iloen/melon/adapters/RecyclerItemClickListener$OnItemClickListener;", "listener", "Lie/H;", "setOnItemClickListener", "(Lcom/iloen/melon/adapters/RecyclerItemClickListener$OnItemClickListener;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "getAdapter", "()Landroidx/recyclerview/widget/j0;", "Landroid/os/Bundle;", "savedInstanceState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "onViewCreated", "()V", "onWindowAttributesSet", "", "show", "showBottomShadow", "(Z)V", "makeHeaderView", "makeFooterCloseView", "enabled", "showProgress", "", "colorId", "setBackgroundColor", "(I)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "titleId", "", "mainTitle", "subTitle", "(Ljava/lang/String;Ljava/lang/String;)V", "showEmptyView", "Landroid/view/View;", "getShowingView", "()Landroid/view/View;", "getItemCount", "()I", "getContentAdapter", "getCacheKey", "()Ljava/lang/String;", "Landroid/database/Cursor;", "fetchCursor", "()Landroid/database/Cursor;", "cursor", "changeCursor", "(Landroid/database/Cursor;)V", "setPopupHeight", "()Z", "getMaxPopupHeight", "isOverSize", "hasHeader", "hasBottomCloseBtn", "getItemHeight", "sendLogClosePopup", "headerHeight", "I", "getHeaderHeight", "setHeaderHeight", "bottomCloseHeight", "getBottomCloseHeight", "setBottomCloseHeight", "headerView", "Landroid/view/View;", "getHeaderView", "setHeaderView", "(Landroid/view/View;)V", "closeView", "getCloseView", "setCloseView", "Lcom/iloen/melon/adapters/RecyclerItemClickListener$OnItemClickListener;", "getListener", "()Lcom/iloen/melon/adapters/RecyclerItemClickListener$OnItemClickListener;", "setListener", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "progress", "getProgress", "setProgress", "emptyView", "getEmptyView", "setEmptyView", "Ljava/lang/String;", "getTitle", "(Ljava/lang/String;)V", "mCacheKey", "mShowBottomShadow", "Z", "mBackgroundColorId", "getPopupHeight", "popupHeight", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class AbsListPopup extends MelonBaseListPopup {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/popup/AbsListPopup$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "AbsListPopup";
    private int bottomCloseHeight;
    @Nullable
    private View closeView;
    @Nullable
    private View emptyView;
    private int headerHeight;
    @Nullable
    private View headerView;
    @Nullable
    private LinearLayoutManager layoutManager;
    @Nullable
    private RecyclerItemClickListener.OnItemClickListener listener;
    private int mBackgroundColorId;
    @Nullable
    private String mCacheKey;
    private boolean mShowBottomShadow;
    @Nullable
    private View progress;
    @Nullable
    private RecyclerView recyclerView;
    @Nullable
    private String title;

    static {
        AbsListPopup.Companion = new Companion(null);
        AbsListPopup.$stable = 8;
    }

    public AbsListPopup(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        super(activity0);
        this.mShowBottomShadow = true;
        this.mBackgroundColorId = -1;
        this.headerHeight = this.getContext().getResources().getDimensionPixelSize(0x7F070300);  // dimen:melon_popup_header_height
    }

    public final void changeCursor(@Nullable Cursor cursor0) {
        j0 j00 = this.getContentAdapter();
        if(j00 instanceof RecyclerViewCursorAdapter) {
            ((RecyclerViewCursorAdapter)j00).changeCursor(cursor0);
        }
    }

    @Nullable
    public abstract j0 createAdapter(@Nullable Context arg1);

    @Nullable
    public final Cursor fetchCursor() {
        String s = this.getCacheKey();
        if(TextUtils.isEmpty(s)) {
            LogU.Companion.w("AbsListPopup", "fetchCursor() invalid key");
            return null;
        }
        return a.f(this.getContext(), s);
    }

    @Nullable
    public j0 getAdapter() {
        return this.recyclerView == null ? null : this.recyclerView.getAdapter();
    }

    public final int getBottomCloseHeight() {
        return this.bottomCloseHeight;
    }

    @Nullable
    public String getCacheKey() {
        if(TextUtils.isEmpty(this.mCacheKey)) {
            String s = this.getClass().getName() + this.getClass().getName().hashCode();
            this.mCacheKey = s;
            LogU.Companion.v("AbsListPopup", "getCacheKey() cacheKey:" + s);
        }
        return this.mCacheKey;
    }

    @Nullable
    public final View getCloseView() {
        return this.closeView;
    }

    @Nullable
    public j0 getContentAdapter() {
        return this.recyclerView == null ? null : this.recyclerView.getAdapter();
    }

    @Nullable
    public final View getEmptyView() {
        return this.emptyView;
    }

    public final int getHeaderHeight() {
        return this.headerHeight;
    }

    @Nullable
    public final View getHeaderView() {
        return this.headerView;
    }

    public int getItemCount() {
        j0 j00 = this.getContentAdapter();
        return j00 instanceof i ? ((i)j00).getCount() : 0;
    }

    // 去混淆评级： 低(20)
    public int getItemHeight() {
        return this.getContentAdapter() instanceof PopupTextListAdapter ? this.getContext().getResources().getDimensionPixelSize(0x7F070309) : 0;  // dimen:melon_popup_text_list_row_height
    }

    @Nullable
    public final LinearLayoutManager getLayoutManager() {
        return this.layoutManager;
    }

    @Nullable
    public final RecyclerItemClickListener.OnItemClickListener getListener() {
        return this.listener;
    }

    // 去混淆评级： 低(20)
    public int getMaxPopupHeight() {
        return ScreenUtils.isOrientationPortrait(this.getContext()) ? ScreenUtils.dipToPixel(this.getContext(), 363.0f) : ScreenUtils.dipToPixel(this.getContext(), 312.0f);
    }

    public int getPopupHeight() {
        int v = this.getMaxPopupHeight();
        j0 j00 = this.getContentAdapter();
        int v1 = j00 == null ? 0 : j00.getItemCount();
        int v2 = this.hasHeader() ? this.headerHeight : 0;
        if(this.hasBottomCloseBtn()) {
            v2 += this.bottomCloseHeight;
        }
        int v3 = this.getItemHeight() * v1 + v2;
        if(v3 > v) {
            return v;
        }
        return v3 >= 0 ? v3 : 0;
    }

    @Nullable
    public final View getProgress() {
        return this.progress;
    }

    @Nullable
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @Nullable
    public View getShowingView() {
        if(this.recyclerView != null && this.recyclerView.getVisibility() == 0) {
            return this.recyclerView;
        }
        if(this.emptyView != null && this.emptyView.getVisibility() == 0) {
            return this.emptyView;
        }
        return this.progress == null || this.progress.getVisibility() != 0 ? null : this.progress;
    }

    @Nullable
    public String getTitle() {
        return this.title;
    }

    public final boolean hasBottomCloseBtn() {
        return this.closeView != null && this.closeView.getVisibility() == 0;
    }

    public boolean hasHeader() {
        return this.headerView != null && this.headerView.getVisibility() == 0;
    }

    public boolean isOverSize() {
        return false;
    }

    public final void makeFooterCloseView() {
        if(this.closeView != null) {
            this.bottomCloseHeight = this.getContext().getResources().getDimensionPixelSize(0x7F0702FF);  // dimen:melon_popup_footer_close_button_height
            ViewUtils.setOnClickListener(this.closeView, new E(this, 1));
            ViewUtils.setContentDescriptionWithButtonClassName(this.closeView, "닫기");
        }
    }

    public void makeHeaderView() {
        boolean z = TextUtils.isEmpty(this.getTitle());
        ViewUtils.showWhen(this.headerView, !z);
        if(!z) {
            View view0 = this.headerView;
            if(view0 != null) {
                TextView textView0 = (TextView)view0.findViewById(0x7F0A0B9A);  // id:title_front_item
                if(textView0 != null) {
                    textView0.setText(this.getTitle());
                }
            }
            View view1 = this.headerView;
            if(view1 != null) {
                view1.setBackgroundResource(0x7F08091C);  // drawable:shape_white001s_top_round8
            }
        }
    }

    @Override  // android.app.Dialog
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "savedInstanceState");
        super.onRestoreInstanceState(bundle0);
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    public void onViewCreated() {
        View view0 = this.getRootView();
        View view1 = view0.findViewById(0x7F0A0952);  // id:popup_header
        this.headerView = view1;
        if(view1 != null) {
            this.makeHeaderView();
        }
        View view2 = view0.findViewById(0x7F0A070A);  // id:layout_close
        this.closeView = view2;
        if(view2 != null) {
            this.makeFooterCloseView();
        }
        this.emptyView = view0.findViewById(0x7F0A0425);  // id:empty
        this.progress = view0.findViewById(0x7F0A097E);  // id:progress
        RecyclerView recyclerView0 = (RecyclerView)view0.findViewById(0x7F0A0957);  // id:popup_list
        boolean z = true;
        if(recyclerView0 != null) {
            this.getContext();
            LinearLayoutManager linearLayoutManager0 = new LinearLayoutManager(1, false);
            this.layoutManager = linearLayoutManager0;
            recyclerView0.setLayoutManager(linearLayoutManager0);
            int v = ColorUtils.getColor(this.getContext(), 0x7F0600C5);  // color:common_popup_bg
            int v1 = this.mBackgroundColorId;
            if(v1 != -1) {
                v = v1;
            }
            recyclerView0.setBackgroundColor(v);
            recyclerView0.setVisibility(0);
            recyclerView0.setAdapter(this.createAdapter(this.getContext()));
            recyclerView0.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public final RecyclerView a;
                public final AbsListPopup b;

                {
                    RecyclerView recyclerView0 = this;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    this.a = recyclerView0;
                    this.b = absListPopup0;
                }

                @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
                public void onGlobalLayout() {
                    this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    j0 j00 = this.b.getContentAdapter();
                    boolean z = j00 == null || j00.getItemCount() <= 0;
                    this.b.showEmptyView(z);
                }
            });
            this.recyclerView = recyclerView0;
        }
        ImageView imageView0 = this.getBottomShadow();
        if(!this.mShowBottomShadow || !this.isOverSize()) {
            z = false;
        }
        ViewUtils.showWhen(imageView0, z);
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    public void onWindowAttributesSet() {
        if(this.mShowBottomShadow) {
            RecyclerView recyclerView0 = this.recyclerView;
            if(recyclerView0 != null) {
                recyclerView0.addOnScrollListener(new A0() {
                    public final AbsListPopup a;

                    {
                        this.a = absListPopup0;
                    }

                    @Override  // androidx.recyclerview.widget.A0
                    public void onScrollStateChanged(RecyclerView recyclerView0, int v) {
                        q.g(recyclerView0, "recyclerView");
                        super.onScrollStateChanged(recyclerView0, v);
                        AbsListPopup absListPopup0 = this.a;
                        if(absListPopup0.isOverSize() && absListPopup0.getContentAdapter() != null) {
                            ImageView imageView0 = absListPopup0.getBottomShadow();
                            LinearLayoutManager linearLayoutManager0 = absListPopup0.getLayoutManager();
                            boolean z = false;
                            if(linearLayoutManager0 != null) {
                                int v1 = linearLayoutManager0.findLastCompletelyVisibleItemPosition();
                                j0 j00 = absListPopup0.getContentAdapter();
                                if(v1 == (j00 == null ? 0 : j00.getItemCount()) - 1) {
                                    z = true;
                                }
                            }
                            ViewUtils.hideWhen(imageView0, z);
                        }
                    }
                });
            }
        }
    }

    public void sendLogClosePopup() {
    }

    public final void setBackgroundColor(int v) {
        this.mBackgroundColorId = v;
        RecyclerView recyclerView0 = this.recyclerView;
        if(recyclerView0 != null) {
            recyclerView0.setBackgroundColor(v);
        }
    }

    public final void setBottomCloseHeight(int v) {
        this.bottomCloseHeight = v;
    }

    public final void setCloseView(@Nullable View view0) {
        this.closeView = view0;
    }

    public final void setEmptyView(@Nullable View view0) {
        this.emptyView = view0;
    }

    public final void setHeaderHeight(int v) {
        this.headerHeight = v;
    }

    public final void setHeaderView(@Nullable View view0) {
        this.headerView = view0;
    }

    public final void setLayoutManager(@Nullable LinearLayoutManager linearLayoutManager0) {
        this.layoutManager = linearLayoutManager0;
    }

    public final void setListener(@Nullable RecyclerItemClickListener.OnItemClickListener recyclerItemClickListener$OnItemClickListener0) {
        this.listener = recyclerItemClickListener$OnItemClickListener0;
    }

    public void setOnItemClickListener(@Nullable RecyclerItemClickListener.OnItemClickListener recyclerItemClickListener$OnItemClickListener0) {
        this.listener = recyclerItemClickListener$OnItemClickListener0;
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    public boolean setPopupHeight() {
        this.mPopupHeight = this.getPopupHeight();
        return true;
    }

    public final void setProgress(@Nullable View view0) {
        this.progress = view0;
    }

    public final void setRecyclerView(@Nullable RecyclerView recyclerView0) {
        this.recyclerView = recyclerView0;
    }

    @Override  // android.app.Dialog
    public void setTitle(int v) {
        this.setTitle(this.getContext().getString(v));
    }

    @Override  // android.app.Dialog
    public void setTitle(@Nullable CharSequence charSequence0) {
        this.setTitle(((String)charSequence0));
    }

    public void setTitle(@Nullable String s) {
        this.title = s;
    }

    public void setTitle(@Nullable String s, @Nullable String s1) {
        if(TextUtils.isEmpty(s) && TextUtils.isEmpty(s1)) {
            return;
        }
        if(TextUtils.isEmpty(s1)) {
            this.setTitle(s);
            return;
        }
        this.setTitle(String.format("%s - %s", Arrays.copyOf(new Object[]{s, s1}, 2)));
    }

    public final void showBottomShadow(boolean z) {
        this.mShowBottomShadow = z;
    }

    public void showEmptyView(boolean z) {
        l1.B("showEmptyView() show:", z, LogU.Companion, "AbsListPopup");
        RecyclerView recyclerView0 = this.recyclerView;
        if(recyclerView0 != null) {
            View view0 = this.emptyView;
            if(!z) {
                recyclerView0.setVisibility(0);
                ViewUtils.hideWhen(view0, true);
            }
            else if(view0 != null) {
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
                viewGroup$LayoutParams0.height = ScreenUtils.dipToPixel(recyclerView0.getContext(), 300.0f);
                view0.setLayoutParams(viewGroup$LayoutParams0);
                view0.setVisibility(0);
                recyclerView0.setVisibility(8);
            }
            ViewUtils.showWhen(view0, z);
        }
    }

    public final void showProgress(boolean z) {
        ViewUtils.showWhen(this.progress, z);
    }
}

