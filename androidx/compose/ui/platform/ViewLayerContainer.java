package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Canvas;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/ViewLayerContainer;", "Landroidx/compose/ui/platform/DrawChildContainer;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lie/H;", "dispatchGetDisplayList", "()V", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ViewLayerContainer extends DrawChildContainer {
    public ViewLayerContainer(@NotNull Context context0) {
        super(context0);
    }

    @Override  // androidx.compose.ui.platform.DrawChildContainer
    public final void dispatchDraw(Canvas canvas0) {
    }

    public final void dispatchGetDisplayList() {
    }
}

