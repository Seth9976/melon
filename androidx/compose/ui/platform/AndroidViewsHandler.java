package androidx.compose.ui.platform;

import M0.a;
import P0.I;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import u1.i;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R3\u0010\u000E\u001A\u001E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\rR3\u0010\u0011\u001A\u001E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\u0006j\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0007`\t8\u0006¢\u0006\f\n\u0004\b\u000F\u0010\u000B\u001A\u0004\b\u0010\u0010\r¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/platform/AndroidViewsHandler;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Ljava/util/HashMap;", "Lu1/i;", "LP0/I;", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "getHolderToLayoutNode", "()Ljava/util/HashMap;", "holderToLayoutNode", "b", "getLayoutNodeToHolder", "layoutNodeToHolder", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class AndroidViewsHandler extends ViewGroup {
    public final HashMap a;
    public final HashMap b;

    public AndroidViewsHandler(@NotNull Context context0) {
        super(context0);
        this.setClipChildren(false);
        this.a = new HashMap();
        this.b = new HashMap();
    }

    @Override  // android.view.ViewGroup
    public final void dispatchDraw(Canvas canvas0) {
    }

    @Override  // android.view.ViewGroup
    public final boolean dispatchTouchEvent(MotionEvent motionEvent0) {
        return true;
    }

    @NotNull
    public final HashMap getHolderToLayoutNode() {
        return this.a;
    }

    @NotNull
    public final HashMap getLayoutNodeToHolder() {
        return this.b;
    }

    @Override  // android.view.ViewGroup
    public final ViewParent invalidateChildInParent(int[] arr_v, Rect rect0) {
        return null;
    }

    @Override  // android.view.ViewGroup
    public final void onDescendantInvalidated(View view0, View view1) {
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        for(Object object0: this.a.keySet()) {
            ((i)object0).layout(((i)object0).getLeft(), ((i)object0).getTop(), ((i)object0).getRight(), ((i)object0).getBottom());
        }
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        if(View.MeasureSpec.getMode(v) != 0x40000000) {
            a.a("widthMeasureSpec should be EXACTLY");
        }
        if(View.MeasureSpec.getMode(v1) != 0x40000000) {
            a.a("heightMeasureSpec should be EXACTLY");
        }
        this.setMeasuredDimension(View.MeasureSpec.getSize(v), View.MeasureSpec.getSize(v1));
        for(Object object0: this.a.keySet()) {
            i i0 = (i)object0;
            int v2 = i0.G;
            if(v2 != 0x80000000) {
                int v3 = i0.I;
                if(v3 != 0x80000000) {
                    i0.measure(v2, v3);
                }
            }
        }
    }

    @Override  // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.cleanupLayoutState(this);
        int v = this.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = this.getChildAt(v1);
            I i0 = (I)this.a.get(view0);
            if(view0.isLayoutRequested() && i0 != null) {
                I.W(i0, false, 7);
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}

