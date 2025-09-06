package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u001D\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u000F\u001A\u00020\b8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\"\u0010\u0017\u001A\u00020\u00108\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001B\u001A\u00020\u00108\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001A\u0004\b\u0019\u0010\u0014\"\u0004\b\u001A\u0010\u0016R\"\u0010\u001F\u001A\u00020\u00108\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001C\u0010\u0012\u001A\u0004\b\u001D\u0010\u0014\"\u0004\b\u001E\u0010\u0016¨\u0006 "}, d2 = {"Lcom/iloen/melon/custom/MelonContentLoadingProgressBar;", "Landroid/widget/ProgressBar;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "a", "J", "getMStartTime", "()J", "setMStartTime", "(J)V", "mStartTime", "", "b", "Z", "getMPostedHide", "()Z", "setMPostedHide", "(Z)V", "mPostedHide", "c", "getMPostedShow", "setMPostedShow", "mPostedShow", "d", "getMDismissed", "setMDismissed", "mDismissed", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonContentLoadingProgressBar extends ProgressBar {
    public long a;
    public boolean b;
    public boolean c;
    public boolean d;
    public final k0 e;
    public final k0 f;

    public MelonContentLoadingProgressBar(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null);
    }

    public MelonContentLoadingProgressBar(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        super(context0, attributeSet0, 0);
        this.a = -1L;
        this.e = new k0(this, 1);
        this.f = new k0(this, 2);
    }

    public final boolean getMDismissed() {
        return this.d;
    }

    public final boolean getMPostedHide() {
        return this.b;
    }

    public final boolean getMPostedShow() {
        return this.c;
    }

    public final long getMStartTime() {
        return this.a;
    }

    @Override  // android.widget.ProgressBar
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.removeCallbacks(this.e);
        this.removeCallbacks(this.f);
    }

    @Override  // android.widget.ProgressBar
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks(this.e);
        this.removeCallbacks(this.f);
    }

    public final void setMDismissed(boolean z) {
        this.d = z;
    }

    public final void setMPostedHide(boolean z) {
        this.b = z;
    }

    public final void setMPostedShow(boolean z) {
        this.c = z;
    }

    public final void setMStartTime(long v) {
        this.a = v;
    }
}

