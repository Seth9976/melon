package com.iloen.melon.utils.ui;

import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.e;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001BB\u001F\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\u000B\u0010\fJ\r\u0010\r\u001A\u00020\n¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\n2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u001A\u001A\u00020\u00138\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/utils/ui/RefreshStateHelper;", "Lcom/google/android/material/appbar/e;", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Lcom/google/android/material/appbar/AppBarLayout;Landroidx/recyclerview/widget/RecyclerView;)V", "Lcom/iloen/melon/utils/ui/RefreshStateHelper$RefreshStateListener;", "refreshStateListener", "Lie/H;", "addRefreshStateListener", "(Lcom/iloen/melon/utils/ui/RefreshStateHelper$RefreshStateListener;)V", "removeRefreshStateListener", "()V", "", "verticalOffset", "onOffsetChanged", "(Lcom/google/android/material/appbar/AppBarLayout;I)V", "Landroidx/recyclerview/widget/A0;", "f", "Landroidx/recyclerview/widget/A0;", "getOnScrollListener", "()Landroidx/recyclerview/widget/A0;", "setOnScrollListener", "(Landroidx/recyclerview/widget/A0;)V", "onScrollListener", "RefreshStateListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class RefreshStateHelper implements e {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/utils/ui/RefreshStateHelper$RefreshStateListener;", "", "", "enable", "Lie/H;", "onRefreshEnable", "(Z)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface RefreshStateListener {
        void onRefreshEnable(boolean arg1);
    }

    public static final int $stable = 8;
    public final AppBarLayout a;
    public final RecyclerView b;
    public boolean c;
    public int d;
    public RefreshStateListener e;
    public A0 f;

    public RefreshStateHelper() {
        this(null, null, 3, null);
    }

    public RefreshStateHelper(@Nullable AppBarLayout appBarLayout0, @Nullable RecyclerView recyclerView0) {
        this.a = appBarLayout0;
        this.b = recyclerView0;
        this.c = true;
        this.f = new A0() {
            public final RefreshStateHelper a;

            {
                this.a = refreshStateHelper0;
            }

            @Override  // androidx.recyclerview.widget.A0
            public void onScrollStateChanged(RecyclerView recyclerView0, int v) {
                q.g(recyclerView0, "recyclerView");
                super.onScrollStateChanged(recyclerView0, v);
                if(v == 0) {
                    RefreshStateHelper refreshStateHelper0 = this.a;
                    RefreshStateHelper.access$setRefreshEnable$p(refreshStateHelper0, refreshStateHelper0.d == 0 && recyclerView0.computeVerticalScrollOffset() == 0);
                    RefreshStateListener refreshStateHelper$RefreshStateListener0 = RefreshStateHelper.access$getRefreshStateListener$p(refreshStateHelper0);
                    if(refreshStateHelper$RefreshStateListener0 != null) {
                        refreshStateHelper$RefreshStateListener0.onRefreshEnable(RefreshStateHelper.access$getRefreshEnable$p(refreshStateHelper0));
                    }
                }
            }
        };
    }

    public RefreshStateHelper(AppBarLayout appBarLayout0, RecyclerView recyclerView0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            appBarLayout0 = null;
        }
        if((v & 2) != 0) {
            recyclerView0 = null;
        }
        this(appBarLayout0, recyclerView0);
    }

    public static final boolean access$getRefreshEnable$p(RefreshStateHelper refreshStateHelper0) {
        return refreshStateHelper0.c;
    }

    public static final RefreshStateListener access$getRefreshStateListener$p(RefreshStateHelper refreshStateHelper0) {
        return refreshStateHelper0.e;
    }

    public static final void access$setRefreshEnable$p(RefreshStateHelper refreshStateHelper0, boolean z) {
        refreshStateHelper0.c = z;
    }

    public final void addRefreshStateListener(@Nullable RefreshStateListener refreshStateHelper$RefreshStateListener0) {
        this.e = refreshStateHelper$RefreshStateListener0;
        AppBarLayout appBarLayout0 = this.a;
        if(appBarLayout0 != null) {
            appBarLayout0.a(this);
        }
        RecyclerView recyclerView0 = this.b;
        if(recyclerView0 != null) {
            recyclerView0.addOnScrollListener(this.f);
        }
    }

    @NotNull
    public final A0 getOnScrollListener() {
        return this.f;
    }

    @Override  // com.google.android.material.appbar.e
    public void onOffsetChanged(@NotNull AppBarLayout appBarLayout0, int v) {
        q.g(appBarLayout0, "appBarLayout");
        this.d = v;
    }

    public final void removeRefreshStateListener() {
        this.e = null;
        AppBarLayout appBarLayout0 = this.a;
        if(appBarLayout0 != null) {
            ArrayList arrayList0 = appBarLayout0.h;
            if(arrayList0 != null) {
                arrayList0.remove(this);
            }
        }
        RecyclerView recyclerView0 = this.b;
        if(recyclerView0 != null) {
            recyclerView0.removeOnScrollListener(this.f);
        }
    }

    public final void setOnScrollListener(@NotNull A0 a00) {
        q.g(a00, "<set-?>");
        this.f = a00;
    }
}

