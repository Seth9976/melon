package com.iloen.melon.player.video;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001D\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J4\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\r\u001A\u0004\u0018\u00010\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u0010\u001A\u00020\u000BH\u0016J,\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\r\u001A\u0004\u0018\u00010\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0016J:\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u000B2\u0006\u0010\u0014\u001A\u00020\u000B2\u0006\u0010\u0015\u001A\u00020\u000B2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u0010\u001A\u00020\u000BH\u0016J2\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u000B2\u0006\u0010\u0014\u001A\u00020\u000B2\u0006\u0010\u0015\u001A\u00020\u000B2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0016J \u0010\u0016\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\r\u001A\u00020\tH\u0016J\u0018\u0010\u001A\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u0018H\u0016J\b\u0010\u001B\u001A\u00020\u0018H\u0014¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/player/video/VideoChatCustomRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dispatchNestedPreScroll", "", "dx", "", "dy", "consumed", "", "offsetInWindow", "type", "dispatchNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "dispatchNestedFling", "velocityX", "", "velocityY", "dispatchNestedPreFling", "getBottomFadingEdgeStrength", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoChatCustomRecyclerView extends RecyclerView {
    public static final int $stable = 8;

    public VideoChatCustomRecyclerView(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 2, null);
    }

    public VideoChatCustomRecyclerView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        super(context0, attributeSet0);
    }

    public VideoChatCustomRecyclerView(Context context0, AttributeSet attributeSet0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0);
    }

    @Override  // androidx.recyclerview.widget.RecyclerView
    public boolean dispatchNestedFling(float f, float f1, boolean z) {
        return false;
    }

    @Override  // androidx.recyclerview.widget.RecyclerView
    public boolean dispatchNestedPreFling(float f, float f1) {
        return false;
    }

    @Override  // androidx.recyclerview.widget.RecyclerView
    public boolean dispatchNestedPreScroll(int v, int v1, @Nullable int[] arr_v, @Nullable int[] arr_v1) {
        return false;
    }

    @Override  // androidx.recyclerview.widget.RecyclerView
    public boolean dispatchNestedPreScroll(int v, int v1, @Nullable int[] arr_v, @Nullable int[] arr_v1, int v2) {
        return false;
    }

    @Override  // androidx.recyclerview.widget.RecyclerView
    public boolean dispatchNestedScroll(int v, int v1, int v2, int v3, @Nullable int[] arr_v) {
        return false;
    }

    public boolean dispatchNestedScroll(int v, int v1, int v2, int v3, @Nullable int[] arr_v, int v4) {
        return false;
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.View
    public float getBottomFadingEdgeStrength() {
        return this.canScrollVertically(1) ? super.getBottomFadingEdgeStrength() : 0.0f;
    }
}

