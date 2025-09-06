package com.iloen.melon.fragments.main.common;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\'\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\t\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u0011\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\u000F\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R$\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0004@\u0004X\u0084\u000E¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolderForMelonBase;", "Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "v", "Lie/H;", "onViewAttachedToWindow", "onViewDetachedFromWindow", "", "isForegroundFragment", "()Ljava/lang/Boolean;", "", "contentId", "getImpLogKey", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/iloen/melon/fragments/main/common/OnImpLogListener;", "onImpLogListener", "Lcom/iloen/melon/fragments/main/common/OnImpLogListener;", "getOnImpLogListener", "()Lcom/iloen/melon/fragments/main/common/OnImpLogListener;", "setOnImpLogListener", "(Lcom/iloen/melon/fragments/main/common/OnImpLogListener;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class ViewableCheckViewHolderForMelonBase extends ViewableCheckViewHolder {
    public static final int $stable = 8;
    @Nullable
    private OnImpLogListener onImpLogListener;

    public ViewableCheckViewHolderForMelonBase(@NotNull View view0) {
        q.g(view0, "itemView");
        super(view0);
    }

    @Override  // com.iloen.melon.fragments.main.common.ViewableCheckViewHolder
    @NotNull
    public String getImpLogKey(@Nullable String s) {
        return super.getImpLogKey(s);
    }

    @Nullable
    public final OnImpLogListener getOnImpLogListener() {
        return this.onImpLogListener;
    }

    @Override  // com.iloen.melon.fragments.main.common.ViewableCheckViewHolder
    @Nullable
    public Boolean isForegroundFragment() {
        return this.onImpLogListener == null ? null : Boolean.valueOf(this.onImpLogListener.isForegroundFragment());
    }

    @Override  // com.iloen.melon.fragments.main.common.ViewableCheckViewHolder
    public void onViewAttachedToWindow(@NotNull View view0) {
        q.g(view0, "v");
        this.setViewAttachedToWindow(true);
        OnImpLogListener onImpLogListener0 = this.onImpLogListener;
        if(onImpLogListener0 != null) {
            onImpLogListener0.addOnStateChangeListener(this.getOnStateChangeListener());
        }
        this.startAllViewableCheck();
    }

    @Override  // com.iloen.melon.fragments.main.common.ViewableCheckViewHolder
    public void onViewDetachedFromWindow(@NotNull View view0) {
        q.g(view0, "v");
        this.setViewAttachedToWindow(false);
        OnImpLogListener onImpLogListener0 = this.onImpLogListener;
        if(onImpLogListener0 != null) {
            onImpLogListener0.removeOnStateChangeListener(this.getOnStateChangeListener());
        }
        this.stopAllViewableCheck();
    }

    public final void setOnImpLogListener(@Nullable OnImpLogListener onImpLogListener0) {
        this.onImpLogListener = onImpLogListener0;
    }
}

