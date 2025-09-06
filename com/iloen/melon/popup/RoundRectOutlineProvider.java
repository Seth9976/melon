package com.iloen.melon.popup;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/popup/RoundRectOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "", "radius", "<init>", "(F)V", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "Lie/H;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class RoundRectOutlineProvider extends ViewOutlineProvider {
    public static final int $stable = 8;
    public final float a;

    public RoundRectOutlineProvider(float f) {
        this.a = f;
    }

    @Override  // android.view.ViewOutlineProvider
    public void getOutline(@NotNull View view0, @NotNull Outline outline0) {
        q.g(view0, "view");
        q.g(outline0, "outline");
        outline0.setRoundRect(0, 0, view0.getWidth(), view0.getHeight() + ((int)this.a), this.a);
    }
}

