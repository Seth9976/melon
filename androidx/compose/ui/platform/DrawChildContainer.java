package androidx.compose.ui.platform;

import Q0.c1;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import y0.c;
import y0.q;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/DrawChildContainer;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "getChildCount", "()I", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public class DrawChildContainer extends ViewGroup {
    public boolean a;

    public DrawChildContainer(@NotNull Context context0) {
        super(context0);
        this.setClipChildren(false);
        this.setTag(0x7F0A052E, Boolean.TRUE);  // id:hide_in_inspector_tag
    }

    public final void a(q q0, c1 c10, long v) {
        super.drawChild(c.a(q0), c10, v);
    }

    @Override  // android.view.ViewGroup
    public void dispatchDraw(Canvas canvas0) {
        int v = super.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = this.getChildAt(v1);
            kotlin.jvm.internal.q.e(view0, "null cannot be cast to non-null type androidx.compose.ui.platform.ViewLayer");
            if(((c1)view0).h) {
                try {
                    this.a = true;
                    super.dispatchDraw(canvas0);
                    this.a = false;
                    return;
                }
                catch(Throwable throwable0) {
                    this.a = false;
                    throw throwable0;
                }
            }
        }
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.ViewGroup
    public int getChildCount() {
        return this.a ? super.getChildCount() : 0;
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        this.setMeasuredDimension(0, 0);
    }

    @Override  // android.view.View, android.view.ViewParent
    public final void requestLayout() {
    }
}

