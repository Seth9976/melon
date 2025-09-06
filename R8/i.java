package r8;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.iloen.melon.adapters.common.e;
import com.iloen.melon.adapters.common.f;
import com.iloen.melon.adapters.common.m;
import com.iloen.melon.adapters.common.n;
import com.iloen.melon.adapters.common.q;
import com.iloen.melon.adapters.common.t;
import com.iloen.melon.adapters.common.u;
import com.iloen.melon.adapters.common.v;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.k;
import v9.o;

public abstract class i extends q implements e, n, u {
    public static final int $stable = 8;
    @NotNull
    public static final h Companion = null;
    @NotNull
    private static final String TAG = "ViewModelAdapter";
    private static final int TYPE_ITEM_BASE = 100;
    public static final int TYPE_ITEM_EMPTY_VIEW = 103;
    public static final int TYPE_ITEM_LOADING_MORE = 102;
    public static final int TYPE_ITEM_NETWORK_ERROR_VIEW = 104;
    public static final int TYPE_ITEM_PARALLAX_FOOTER = 105;
    public static final int TYPE_ITEM_PARALLAX_HEADER = 101;
    public static final int TYPE_ITEM_UNKNOWN = -1;
    @Nullable
    private v9.e emptyViewInfo;
    private int emptyViewResId;
    private int errorViewResId;
    private int footerClipToPaddingHeight;
    private boolean footerParallaxEnabled;
    private int footerParallaxHeight;
    private boolean headerParallaxEnabled;
    private int headerParallaxHeight;
    private int loadingResId;
    @Nullable
    private k loadingViewInfo;
    private boolean mIsShowEmptyView;
    private boolean mIsShowErrorView;
    private boolean mIsShowLoading;
    @Nullable
    private o networkErrorInfo;

    static {
        i.Companion = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public i(Context context0, ArrayList arrayList0) {
        super(context0, arrayList0);
        this.headerParallaxHeight = -1;
        this.footerParallaxHeight = -1;
        this.loadingResId = -1;
        this.emptyViewResId = -1;
        this.errorViewResId = -1;
    }

    public final void addResponse(@NotNull v9.i i0, @NotNull HttpResponse httpResponse0) {
        kotlin.jvm.internal.q.g(i0, "type");
        kotlin.jvm.internal.q.g(httpResponse0, "response");
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.v("ViewModelAdapter", "addResponse() FetchType:" + i0);
        this.clear(false);
        if(!this.handleResponse(i0, httpResponse0) && httpResponse0 instanceof ResponseAdapter) {
            this.setMenuId(httpResponse0.getMenuId());
            this.setStatsElements(((ResponseAdapter)httpResponse0).getStatsElements());
            Collection collection0 = ((ResponseAdapter)httpResponse0).getItems();
            if(collection0 != null && !collection0.isEmpty()) {
                logU$Companion0.v("ViewModelAdapter", "addResponse() collection size: " + collection0.size());
                this.addAll(collection0);
                return;
            }
            logU$Companion0.w("ViewModelAdapter", "addResponse() collection is empty");
        }
    }

    public int getAvailableFooterPosition() {
        return this.getLoadingMoreViewPosition() - 1;
    }

    public int getAvailableHeaderPosition() {
        return this.getParallaxHeaderViewPosition() + 1;
    }

    public final int getEmptyViewPosition() {
        return this.getNetworkErrorViewPosition() - 1;
    }

    public int getFooterParallaxHeight() {
        return this.footerParallaxHeight;
    }

    @Override  // com.iloen.melon.adapters.common.y
    public int getFooterViewCount() {
        return this.hasFooterParallax() + 3;
    }

    public int getFooterViewItemCount() [...] // Inlined contents

    public int getHeaderParallaxHeight() {
        return this.headerParallaxHeight;
    }

    @Override  // com.iloen.melon.adapters.common.y
    public int getHeaderViewCount() {
        return this.hasHeaderParallax();
    }

    public int getHeaderViewItemCount() [...] // Inlined contents

    @Override  // androidx.recyclerview.widget.j0
    public int getItemViewType(int v) {
        if(v == this.getParallaxHeaderViewPosition() && this.hasHeaderParallax()) {
            return 101;
        }
        if(v == this.getLoadingMoreViewPosition()) {
            return 102;
        }
        if(v == this.getEmptyViewPosition()) {
            return 103;
        }
        if(v == this.getNetworkErrorViewPosition()) {
            return 104;
        }
        return v != this.getParallaxFooterViewPosition() || !this.hasFooterParallax() ? this.getItemViewTypeImpl(v, this.getItemPositionFromList(v)) : 105;
    }

    public abstract int getItemViewTypeImpl(int arg1, int arg2);

    public final int getLoadingMoreViewPosition() {
        return this.getEmptyViewPosition() - 1;
    }

    public final int getNetworkErrorViewPosition() {
        return this.getParallaxFooterViewPosition() - 1;
    }

    public final int getParallaxFooterViewPosition() {
        int v = this.getItemCount();
        return this.hasFooterParallax() ? v - 1 : v;
    }

    // 去混淆评级： 低(20)
    public final int getParallaxHeaderViewPosition() {
        return this.hasHeaderParallax() ? 0 : -1;
    }

    public boolean handleResponse(@NotNull v9.i i0, @NotNull HttpResponse httpResponse0) {
        kotlin.jvm.internal.q.g(i0, "type");
        kotlin.jvm.internal.q.g(httpResponse0, "response");
        return false;
    }

    @Override  // com.iloen.melon.adapters.common.u
    public boolean hasFooterParallax() {
        return this.footerParallaxEnabled;
    }

    public boolean hasHeaderParallax() {
        return this.headerParallaxEnabled;
    }

    @Override  // com.iloen.melon.adapters.common.n
    public void hideLoading() {
        if(!this.mIsShowLoading) {
            return;
        }
        this.mIsShowLoading = false;
        this.notifyDataSetChanged();
    }

    @Override  // com.iloen.melon.adapters.common.n
    public boolean isLoadingShowing() {
        return this.mIsShowLoading;
    }

    public final boolean isReservedPosition(int v) {
        return this.getParallaxHeaderViewPosition() == v || this.getLoadingMoreViewPosition() == v || this.getEmptyViewPosition() == v || this.getNetworkErrorViewPosition() == v || this.getParallaxFooterViewPosition() == v;
    }

    @Override  // com.iloen.melon.adapters.common.y
    public void onBindViewHolder(@NotNull O0 o00, int v, int v1) {
        kotlin.jvm.internal.q.g(o00, "viewHolder");
        boolean z = false;
        switch(o00.getItemViewType()) {
            case 101: {
                FrameLayout frameLayout0 = ((v)o00).a;
                if(this.headerParallaxHeight > 0) {
                    z = true;
                }
                ViewUtils.showWhen(frameLayout0, z);
                if(frameLayout0.getLayoutParams().height != this.headerParallaxHeight) {
                    ViewGroup.LayoutParams viewGroup$LayoutParams0 = frameLayout0.getLayoutParams();
                    viewGroup$LayoutParams0.height = this.headerParallaxHeight;
                    return;
                }
                break;
            }
            case 102: {
                this.setFullSpanIfStaggeredGridLayoutManager(o00.itemView);
                boolean z1 = this.mIsShowLoading;
                ViewUtils.showWhen(((m)o00).itemView, z1);
                ViewUtils.showWhen(((m)o00).b, z1);
                return;
            }
            case 103: {
                this.setFullSpanIfStaggeredGridLayoutManager(o00.itemView);
                if(!this.mIsShowErrorView && this.mIsShowEmptyView) {
                    z = true;
                }
                ((f)o00).a(z, this.emptyViewInfo);
                return;
            }
            case 104: {
                this.setFullSpanIfStaggeredGridLayoutManager(o00.itemView);
                ((t)o00).a(this.mIsShowErrorView, this.networkErrorInfo);
                return;
            }
            case 105: {
                FrameLayout frameLayout1 = ((v)o00).a;
                if(this.footerParallaxHeight > 0) {
                    z = true;
                }
                ViewUtils.showWhen(frameLayout1, z);
                if(frameLayout1.getLayoutParams().height != this.footerParallaxHeight) {
                    ViewGroup.LayoutParams viewGroup$LayoutParams1 = frameLayout1.getLayoutParams();
                    viewGroup$LayoutParams1.height = this.footerParallaxHeight - this.footerClipToPaddingHeight;
                    return;
                }
                break;
            }
            default: {
                this.onBindViewImpl(o00, v, v1);
            }
        }
    }

    public abstract void onBindViewImpl(O0 arg1, int arg2, int arg3);

    @Override  // androidx.recyclerview.widget.j0
    @NotNull
    public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
        kotlin.jvm.internal.q.g(viewGroup0, "parent");
        switch(v) {
            case 101: {
                return new v(this.mInflater.inflate(0x7F0D085F, viewGroup0, false));  // layout:spacing_header
            }
            case 102: {
                return new m(this.mInflater.inflate((this.loadingResId == -1 ? 0x7F0D0024 : this.loadingResId), viewGroup0, false));  // layout:adapter_loading_more_view
            }
            case 103: {
                return new f(this.getContext(), this.mInflater.inflate((this.emptyViewResId == -1 ? 0x7F0D0022 : this.emptyViewResId), viewGroup0, false));  // layout:adapter_empty_view
            }
            case 104: {
                return new t(this.getContext(), this.mInflater.inflate((this.errorViewResId == -1 ? 0x7F0D0028 : this.errorViewResId), viewGroup0, false));  // layout:adapter_network_error_view
            }
            case 105: {
                return new v(this.mInflater.inflate(0x7F0D085F, viewGroup0, false));  // layout:spacing_header
            }
            default: {
                return this.onCreateViewHolderImpl(viewGroup0, v);
            }
        }
    }

    public abstract O0 onCreateViewHolderImpl(ViewGroup arg1, int arg2);

    @Override  // com.iloen.melon.adapters.common.e
    public void setEmptyViewInfo(@Nullable v9.e e0) {
        this.emptyViewInfo = v9.e.a(this.emptyViewInfo, e0);
    }

    public void setEmptyViewResId(int v) {
        this.emptyViewResId = v;
    }

    @Override  // com.iloen.melon.adapters.common.e
    public void setErrorViewInfo(@Nullable o o0) {
        this.networkErrorInfo = o.a(this.networkErrorInfo, o0);
    }

    public void setErrorViewResId(int v) {
        this.errorViewResId = v;
    }

    @Override  // com.iloen.melon.adapters.common.u
    public void setFooterClipToPaddingHeight(int v) {
        this.footerClipToPaddingHeight = v;
    }

    @Override  // com.iloen.melon.adapters.common.u
    public void setFooterParallaxEnabled(boolean z) {
        this.footerParallaxEnabled = z;
    }

    @Override  // com.iloen.melon.adapters.common.u
    public void setFooterParallaxHeight(int v) {
        if(v < 0) {
            v = 0;
        }
        if(this.hasFooterParallax() && this.footerParallaxHeight != v) {
            this.footerParallaxHeight = v;
            this.notifyDataSetChanged();
        }
    }

    public void setFullSpanIfStaggeredGridLayoutManager(@Nullable View view0) {
        if(view0 == null) {
            LogU.Companion.w("ViewModelAdapter", "setFullSpanIfStaggeredGridLayoutManager() invalid view");
            return;
        }
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        LayoutParams staggeredGridLayoutManager$LayoutParams0 = viewGroup$LayoutParams0 instanceof LayoutParams ? ((LayoutParams)viewGroup$LayoutParams0) : null;
        if(staggeredGridLayoutManager$LayoutParams0 != null) {
            staggeredGridLayoutManager$LayoutParams0.f = true;
            staggeredGridLayoutManager$LayoutParams0.width = -1;
            staggeredGridLayoutManager$LayoutParams0.height = -2;
            view0.setLayoutParams(staggeredGridLayoutManager$LayoutParams0);
        }
    }

    @Override  // com.iloen.melon.adapters.common.u
    public void setHeaderParallaxEnabled(boolean z) {
        this.headerParallaxEnabled = z;
    }

    @Override  // com.iloen.melon.adapters.common.u
    @SuppressLint({"NotifyDataSetChanged"})
    public void setHeaderParallaxHeight(int v) {
        if(this.hasHeaderParallax()) {
            this.headerParallaxHeight = v;
            this.notifyDataSetChanged();
        }
    }

    public void setLoadingViewInfo(@NotNull k k0) {
        kotlin.jvm.internal.q.g(k0, "info");
    }

    public void setLoadingViewResId(int v) {
        this.loadingResId = v;
    }

    @Override  // com.iloen.melon.adapters.common.e
    public void showEmptyView(boolean z) {
        if(this.mIsShowEmptyView == z) {
            return;
        }
        this.mIsShowEmptyView = z;
        this.notifyDataSetChanged();
    }

    @Override  // com.iloen.melon.adapters.common.e
    public void showErrorView(boolean z) {
        if(this.mIsShowErrorView == z) {
            return;
        }
        this.mIsShowErrorView = z;
        this.notifyDataSetChanged();
    }

    @Override  // com.iloen.melon.adapters.common.n
    public void showLoading() {
        if(this.mIsShowLoading) {
            return;
        }
        this.mIsShowLoading = true;
        this.notifyDataSetChanged();
    }

    @Override  // com.iloen.melon.adapters.common.u
    public void updateParallaxFooterView() {
        this.notifyItemChanged(this.getParallaxFooterViewPosition());
    }
}

