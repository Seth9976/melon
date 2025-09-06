package com.iloen.melon.custom.tablayout;

import J8.O3;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000F\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000ER0\u0010\u0018\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001F\u001A\u00020\u00068\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001E¨\u0006 "}, d2 = {"Lcom/iloen/melon/custom/tablayout/RoundedTabLayout;", "Landroid/widget/HorizontalScrollView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LJ8/O3;", "a", "LJ8/O3;", "getBinding", "()LJ8/O3;", "binding", "Lkotlin/Function1;", "Lie/H;", "b", "Lwe/k;", "getActionSelected", "()Lwe/k;", "setActionSelected", "(Lwe/k;)V", "actionSelected", "c", "I", "getCurrentTab", "()I", "setCurrentTab", "(I)V", "currentTab", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class RoundedTabLayout extends HorizontalScrollView {
    public final O3 a;
    public k b;
    public int c;

    public RoundedTabLayout(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 6, 0);
    }

    public RoundedTabLayout(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 4, 0);
    }

    public RoundedTabLayout(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        View view0 = LayoutInflater.from(context0).inflate(0x7F0D0901, this, false);  // layout:view_rounded_tab_layout
        this.addView(view0);
        if(view0 == null) {
            throw new NullPointerException("rootView");
        }
        this.a = new O3(((LinearLayout)view0));
        this.setOverScrollMode(2);
    }

    public RoundedTabLayout(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0, 0);
    }

    @Nullable
    public final k getActionSelected() {
        return this.b;
    }

    @NotNull
    public final O3 getBinding() {
        return this.a;
    }

    public final int getCurrentTab() {
        return this.c;
    }

    public final void setActionSelected(@Nullable k k0) {
        this.b = k0;
    }

    public final void setCurrentTab(int v) {
        this.c = v;
    }
}

