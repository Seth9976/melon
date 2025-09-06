package com.iloen.melon.fragments.main.common;

import android.util.SparseArray;
import android.view.View.OnAttachStateChangeListener;
import android.view.View;
import androidx.fragment.app.I;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.fragments.tabs.OnTabActionListener;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.viewable.ViewableCheck.Builder;
import com.iloen.melon.utils.viewable.ViewableCheck;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\'\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0002GHB\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001A\u0004\u0018\u00010\u0007H&\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u0003H\u0016\u00A2\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\r\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u0003H\u0016\u00A2\u0006\u0004\b\r\u0010\u0006J\u0011\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\u000BH\u0014\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u000BH\u0014\u00A2\u0006\u0004\b\u0013\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u000BH\u0014\u00A2\u0006\u0004\b\u0014\u0010\u0012J1\u0010\u001A\u001A\u00020\u000B2\b\u0010\u0015\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001A\u00020\u00162\u000E\u0010\u0019\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u0018H\u0014\u00A2\u0006\u0004\b\u001A\u0010\u001BJA\u0010\u001A\u001A\u00020\u000B2\b\u0010\u0015\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\u000E2\u000E\u0010\u0019\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u0018H\u0014\u00A2\u0006\u0004\b\u001A\u0010\u001FJ!\u0010\"\u001A\u00020\u000B2\u0006\u0010\u0017\u001A\u00020\u00162\b\u0010!\u001A\u0004\u0018\u00010 H\u0014\u00A2\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001A\u00020\u000B2\u0006\u0010\u0017\u001A\u00020\u0016H\u0014\u00A2\u0006\u0004\b$\u0010%J\u0017\u0010&\u001A\u00020\u000E2\u0006\u0010\u0017\u001A\u00020\u0016H\u0014\u00A2\u0006\u0004\b&\u0010\'J\u0017\u0010(\u001A\u00020\u000B2\u0006\u0010\u0017\u001A\u00020\u0016H\u0014\u00A2\u0006\u0004\b(\u0010%J\u0017\u0010)\u001A\u00020\u000B2\u0006\u0010\u0017\u001A\u00020\u0016H\u0014\u00A2\u0006\u0004\b)\u0010%J\u0019\u0010,\u001A\u00020*2\b\u0010+\u001A\u0004\u0018\u00010*H\u0014\u00A2\u0006\u0004\b,\u0010-J\r\u0010.\u001A\u00020\u000B\u00A2\u0006\u0004\b.\u0010\u0012R\u0016\u0010\u000F\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u000F\u0010/R\"\u00100\u001A\u00020\u000E8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b0\u0010/\u001A\u0004\b0\u00101\"\u0004\b2\u00103R$\u00105\u001A\u0004\u0018\u0001048\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b5\u00106\u001A\u0004\b7\u00108\"\u0004\b9\u0010:R\u001F\u0010<\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010 0;8\u0006\u00A2\u0006\f\n\u0004\b<\u0010=\u001A\u0004\b>\u0010?R\"\u0010A\u001A\u00020@8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bA\u0010B\u001A\u0004\bC\u0010D\"\u0004\bE\u0010F\u00A8\u0006I"}, d2 = {"Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Landroidx/fragment/app/I;", "getCurrentFragment", "()Landroidx/fragment/app/I;", "v", "Lie/H;", "onViewAttachedToWindow", "onViewDetachedFromWindow", "", "isForegroundFragment", "()Ljava/lang/Boolean;", "removeAllViewableCheck", "()V", "startAllViewableCheck", "stopAllViewableCheck", "targetView", "", "index", "Lkotlin/Function0;", "callback", "addAndStartViewableCheck", "(Landroid/view/View;ILwe/a;)V", "", "minWidthDp", "isIgnoreIntersectionChecker", "(Landroid/view/View;IFZLwe/a;)V", "Lcom/iloen/melon/utils/viewable/ViewableCheck;", "viewableCheck", "addViewableCheck", "(ILcom/iloen/melon/utils/viewable/ViewableCheck;)V", "viewableCheckStart", "(I)V", "hasViewableCheck", "(I)Z", "selectedPagerViewableCheckRestart", "removeViewableCheck", "", "contentId", "getImpLogKey", "(Ljava/lang/String;)Ljava/lang/String;", "onViewRecycled", "Z", "isViewAttachedToWindow", "()Z", "setViewAttachedToWindow", "(Z)V", "Lcom/iloen/melon/fragments/tabs/OnTabActionListener;", "onTabActionListener", "Lcom/iloen/melon/fragments/tabs/OnTabActionListener;", "getOnTabActionListener", "()Lcom/iloen/melon/fragments/tabs/OnTabActionListener;", "setOnTabActionListener", "(Lcom/iloen/melon/fragments/tabs/OnTabActionListener;)V", "Landroid/util/SparseArray;", "viewableCheckSparseArray", "Landroid/util/SparseArray;", "getViewableCheckSparseArray", "()Landroid/util/SparseArray;", "Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder$OnStateChangeListener;", "onStateChangeListener", "Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder$OnStateChangeListener;", "getOnStateChangeListener", "()Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder$OnStateChangeListener;", "setOnStateChangeListener", "(Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder$OnStateChangeListener;)V", "Companion", "OnStateChangeListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class ViewableCheckViewHolder extends O0 implements View.OnAttachStateChangeListener {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "FIXED_VIEWABLE_CHECK_POSITION", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0005\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder$OnStateChangeListener;", "", "Lie/H;", "onStart", "()V", "onStop", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface OnStateChangeListener {
        void onStart();

        void onStop();
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    public static final int FIXED_VIEWABLE_CHECK_POSITION = 0;
    @NotNull
    private static final String TAG = "ViewableCheckViewHolder";
    private boolean isForegroundFragment;
    private boolean isViewAttachedToWindow;
    @NotNull
    private OnStateChangeListener onStateChangeListener;
    @Nullable
    private OnTabActionListener onTabActionListener;
    @NotNull
    private final SparseArray viewableCheckSparseArray;

    static {
        ViewableCheckViewHolder.Companion = new Companion(null);
        ViewableCheckViewHolder.$stable = 8;
    }

    public ViewableCheckViewHolder(@NotNull View view0) {
        q.g(view0, "itemView");
        super(view0);
        this.viewableCheckSparseArray = new SparseArray();
        this.onStateChangeListener = new OnStateChangeListener() {
            @Override  // com.iloen.melon.fragments.main.common.ViewableCheckViewHolder$OnStateChangeListener
            public void onStart() {
                ViewableCheckViewHolder.access$setForegroundFragment$p(ViewableCheckViewHolder.this, true);
                ViewableCheckViewHolder.this.startAllViewableCheck();
            }

            @Override  // com.iloen.melon.fragments.main.common.ViewableCheckViewHolder$OnStateChangeListener
            public void onStop() {
                ViewableCheckViewHolder.access$setForegroundFragment$p(ViewableCheckViewHolder.this, false);
                ViewableCheckViewHolder.this.stopAllViewableCheck();
            }
        };
    }

    public static final void access$setForegroundFragment$p(ViewableCheckViewHolder viewableCheckViewHolder0, boolean z) {
        viewableCheckViewHolder0.isForegroundFragment = z;
    }

    public void addAndStartViewableCheck(@Nullable View view0, int v, float f, boolean z, @Nullable a a0) {
        if(view0 != null && !this.hasViewableCheck(v) && a0 != null) {
            Builder viewableCheck$Builder0 = new Builder(view0);
            viewableCheck$Builder0.setCallback(a0);
            if(f > 0.0f) {
                viewableCheck$Builder0.setMinWidth(ScreenUtils.dipToPixel(view0.getContext(), f));
            }
            viewableCheck$Builder0.setIgnoreIntersectionChecker(z);
            this.addViewableCheck(v, viewableCheck$Builder0.build());
            if(this.isViewAttachedToWindow && (this.isForegroundFragment || q.b(this.isForegroundFragment(), Boolean.TRUE))) {
                this.viewableCheckStart(v);
            }
        }
    }

    public void addAndStartViewableCheck(@Nullable View view0, int v, @Nullable a a0) {
        this.addAndStartViewableCheck(view0, v, 0.0f, false, a0);
    }

    public void addViewableCheck(int v, @Nullable ViewableCheck viewableCheck0) {
        synchronized(this.viewableCheckSparseArray) {
            this.viewableCheckSparseArray.append(v, viewableCheck0);
        }
    }

    @Nullable
    public abstract I getCurrentFragment();

    @NotNull
    public String getImpLogKey(@Nullable String s) {
        return this.getAdapterPosition() + "-" + s;
    }

    @NotNull
    public final OnStateChangeListener getOnStateChangeListener() {
        return this.onStateChangeListener;
    }

    @Nullable
    public final OnTabActionListener getOnTabActionListener() {
        return this.onTabActionListener;
    }

    @NotNull
    public final SparseArray getViewableCheckSparseArray() {
        return this.viewableCheckSparseArray;
    }

    public boolean hasViewableCheck(int v) {
        return this.viewableCheckSparseArray.get(v) != null;
    }

    @Nullable
    public Boolean isForegroundFragment() {
        return this.onTabActionListener == null ? null : Boolean.valueOf(this.onTabActionListener.isForegroundFragment());
    }

    public final boolean isViewAttachedToWindow() {
        return this.isViewAttachedToWindow;
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View view0) {
        q.g(view0, "v");
        this.isViewAttachedToWindow = true;
        OnTabActionListener onTabActionListener0 = this.onTabActionListener;
        if(onTabActionListener0 != null) {
            onTabActionListener0.addOnStateChangeListener(this.onStateChangeListener);
        }
        this.startAllViewableCheck();
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View view0) {
        q.g(view0, "v");
        this.isViewAttachedToWindow = false;
        OnTabActionListener onTabActionListener0 = this.onTabActionListener;
        if(onTabActionListener0 != null) {
            onTabActionListener0.removeOnStateChangeListener(this.onStateChangeListener);
        }
        this.stopAllViewableCheck();
    }

    public final void onViewRecycled() {
        this.removeAllViewableCheck();
    }

    public void removeAllViewableCheck() {
        this.stopAllViewableCheck();
        synchronized(this.viewableCheckSparseArray) {
            this.viewableCheckSparseArray.clear();
        }
    }

    public void removeViewableCheck(int v) {
        synchronized(this.viewableCheckSparseArray) {
            ViewableCheck viewableCheck0 = (ViewableCheck)this.viewableCheckSparseArray.get(v);
            if(viewableCheck0 != null) {
                viewableCheck0.stop();
                this.viewableCheckSparseArray.remove(v);
            }
        }
    }

    public void selectedPagerViewableCheckRestart(int v) {
        ViewableCheck viewableCheck0 = (ViewableCheck)this.viewableCheckSparseArray.get(v);
        if(viewableCheck0 != null) {
            viewableCheck0.start();
        }
    }

    public final void setOnStateChangeListener(@NotNull OnStateChangeListener viewableCheckViewHolder$OnStateChangeListener0) {
        q.g(viewableCheckViewHolder$OnStateChangeListener0, "<set-?>");
        this.onStateChangeListener = viewableCheckViewHolder$OnStateChangeListener0;
    }

    public final void setOnTabActionListener(@Nullable OnTabActionListener onTabActionListener0) {
        this.onTabActionListener = onTabActionListener0;
    }

    public final void setViewAttachedToWindow(boolean z) {
        this.isViewAttachedToWindow = z;
    }

    public void startAllViewableCheck() {
        if(!this.isForegroundFragment && !q.b(this.isForegroundFragment(), Boolean.TRUE)) {
            return;
        }
        synchronized(this.viewableCheckSparseArray) {
            int v1 = this.viewableCheckSparseArray.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                int v3 = this.viewableCheckSparseArray.keyAt(v2);
                ViewableCheck viewableCheck0 = (ViewableCheck)this.viewableCheckSparseArray.get(v3);
                if(viewableCheck0 != null) {
                    viewableCheck0.start();
                }
            }
        }
    }

    public void stopAllViewableCheck() {
        synchronized(this.viewableCheckSparseArray) {
            int v1 = this.viewableCheckSparseArray.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                int v3 = this.viewableCheckSparseArray.keyAt(v2);
                ViewableCheck viewableCheck0 = (ViewableCheck)this.viewableCheckSparseArray.get(v3);
                if(viewableCheck0 != null) {
                    viewableCheck0.stop();
                }
            }
        }
    }

    public void viewableCheckStart(int v) {
        ViewableCheck viewableCheck0 = (ViewableCheck)this.viewableCheckSparseArray.get(v);
        if(viewableCheck0 != null) {
            viewableCheck0.start();
        }
    }
}

