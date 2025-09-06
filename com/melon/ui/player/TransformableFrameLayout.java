package com.melon.ui.player;

import android.content.Context;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qd.X;
import we.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000B\u001A\u00020\t2\u0014\u0010\n\u001A\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/melon/ui/player/TransformableFrameLayout;", "Landroid/widget/FrameLayout;", "Lqd/X;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lkotlin/Function1;", "", "Lie/H;", "listener", "setTransformationListener", "(Lwe/k;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TransformableFrameLayout extends FrameLayout implements X {
    public k a;

    public TransformableFrameLayout(@NotNull Context context0) {
        q.g(context0, "context");
        super(context0);
    }

    public final void setTransformationListener(@Nullable k k0) {
        this.a = k0;
    }
}

