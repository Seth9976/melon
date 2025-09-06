package com.iloen.melon.popup;

import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.WindowManager.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.n;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B%\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001A\u00020\u0006¢\u0006\u0004\b\n\u0010\u000BJ\r\u0010\f\u001A\u00020\u0006¢\u0006\u0004\b\f\u0010\u000BJ\u0015\u0010\u000F\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/popup/PopupSizer;", "", "Landroidx/constraintlayout/widget/ConstraintLayout;", "topContainer", "popupContainer", "Lkotlin/Function0;", "Lie/H;", "dismiss", "<init>", "(Landroidx/constraintlayout/widget/ConstraintLayout;Landroidx/constraintlayout/widget/ConstraintLayout;Lwe/a;)V", "init", "()V", "setConfigurationChanged", "Landroid/view/WindowManager$LayoutParams;", "wlp", "getProperWindowLayoutParams", "(Landroid/view/WindowManager$LayoutParams;)Landroid/view/WindowManager$LayoutParams;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PopupSizer {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/popup/PopupSizer$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final a c;

    static {
        PopupSizer.Companion = new Companion(null);
        PopupSizer.$stable = 8;
    }

    public PopupSizer(@NotNull ConstraintLayout constraintLayout0, @NotNull ConstraintLayout constraintLayout1, @NotNull a a0) {
        q.g(constraintLayout0, "topContainer");
        q.g(constraintLayout1, "popupContainer");
        q.g(a0, "dismiss");
        super();
        this.a = constraintLayout0;
        this.b = constraintLayout1;
        this.c = a0;
    }

    public final void a(int v) {
        n n0 = new n();
        n0.f(this.a);
        n0.l(this.b.getId()).e.b0 = v;
        n0.l(this.b.getId()).e.n0 = true;
        n0.b(this.a);
    }

    public final void b() {
        n n0 = new n();
        n0.f(this.a);
        ConstraintLayout constraintLayout0 = this.b;
        n0.h(constraintLayout0.getId(), 1, this.a.getId(), 1);
        n0.h(constraintLayout0.getId(), 2, this.a.getId(), 2);
        n0.b(this.a);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = constraintLayout0.getLayoutParams();
        if(viewGroup$LayoutParams0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        viewGroup$LayoutParams0.width = -1;
        constraintLayout0.setLayoutParams(viewGroup$LayoutParams0);
    }

    @NotNull
    public final WindowManager.LayoutParams getProperWindowLayoutParams(@NotNull WindowManager.LayoutParams windowManager$LayoutParams0) {
        q.g(windowManager$LayoutParams0, "wlp");
        windowManager$LayoutParams0.gravity = 80;
        windowManager$LayoutParams0.width = -1;
        return windowManager$LayoutParams0;
    }

    public final void init() {
        ViewParent viewParent0 = this.b.getParent();
        ConstraintLayout constraintLayout0 = this.a;
        boolean z = q.b(viewParent0, constraintLayout0);
        if(!z) {
            LogU.Companion.w("PopupSizer", "checkValid() topContainer is not parent of popupContainer");
        }
        if(z) {
            constraintLayout0.setOnClickListener(new E(this, 3));
            this.setConfigurationChanged();
        }
    }

    public final void setConfigurationChanged() {
        ConstraintLayout constraintLayout0 = this.b;
        ViewParent viewParent0 = constraintLayout0.getParent();
        ConstraintLayout constraintLayout1 = this.a;
        boolean z = q.b(viewParent0, constraintLayout1);
        if(!z) {
            LogU.Companion.w("PopupSizer", "checkValid() topContainer is not parent of popupContainer");
        }
        if(!z) {
            return;
        }
        if(ScreenUtils.isTablet(constraintLayout0.getContext())) {
            this.b();
            this.a(ScreenUtils.dipToPixel(constraintLayout0.getContext(), 600.0f));
            constraintLayout1.setPadding(constraintLayout1.getPaddingLeft(), 0, constraintLayout1.getPaddingRight(), constraintLayout1.getPaddingBottom());
            return;
        }
        if(!ScreenUtils.isOrientationPortrait(constraintLayout0.getContext())) {
            this.b();
            this.a(-1);
            constraintLayout1.setPadding(constraintLayout1.getPaddingLeft(), 0, constraintLayout1.getPaddingRight(), constraintLayout1.getPaddingBottom());
            return;
        }
        this.b();
        this.a(-1);
        int v = ScreenUtils.dipToPixel(constraintLayout0.getContext(), 60.0f);
        constraintLayout1.setPadding(constraintLayout1.getPaddingLeft(), v, constraintLayout1.getPaddingRight(), constraintLayout1.getPaddingBottom());
    }
}

