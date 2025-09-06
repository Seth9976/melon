package com.iloen.melon.popup;

import J8.B2;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.lifecycle.D;
import androidx.lifecycle.F;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.w0;
import com.iloen.melon.utils.system.VolumeUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import d3.g;
import ie.H;
import ie.r;
import kotlin.Metadata;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\'\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001(B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000F\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\rH&¢\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\nH\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\nH\u0016¢\u0006\u0004\b\u001A\u0010\u0019J\u000F\u0010\u001B\u001A\u00020\nH\u0015¢\u0006\u0004\b\u001B\u0010\u0019J\u000F\u0010\u001C\u001A\u00020\nH\u0015¢\u0006\u0004\b\u001C\u0010\u0019J\u000F\u0010\u001D\u001A\u00020\nH\u0017¢\u0006\u0004\b\u001D\u0010\u0019J\u001F\u0010\"\u001A\u00020\u00152\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010!\u001A\u00020 H\u0016¢\u0006\u0004\b\"\u0010#R\u0014\u0010\'\u001A\u00020$8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/iloen/melon/popup/MelonBaseLifecyclePopup;", "Landroid/app/Dialog;", "Landroidx/lifecycle/D;", "Lcom/iloen/melon/popup/ConfigChangeable;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/ViewGroup;", "parent", "inflateContentView", "(Landroid/view/ViewGroup;)V", "Landroid/view/WindowManager$LayoutParams;", "wlp", "setWindowLayoutParams", "(Landroid/view/WindowManager$LayoutParams;)Landroid/view/WindowManager$LayoutParams;", "", "useEnterExitSlideAnimation", "()Z", "onConfigurationChanged", "()V", "onViewCreated", "onStart", "onStop", "dismiss", "", "keyCode", "Landroid/view/KeyEvent;", "event", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "Landroidx/lifecycle/t;", "getLifecycle", "()Landroidx/lifecycle/t;", "lifecycle", "ScrollListenerForBottomShadow", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class MelonBaseLifecyclePopup extends Dialog implements D, ConfigChangeable {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/popup/MelonBaseLifecyclePopup$ScrollListenerForBottomShadow;", "Landroidx/recyclerview/widget/A0;", "Landroid/view/View;", "bottomShadowView", "<init>", "(Landroid/view/View;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "Lie/H;", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ScrollListenerForBottomShadow extends A0 {
        public static final int $stable = 8;
        public final View a;

        public ScrollListenerForBottomShadow(@NotNull View view0) {
            q.g(view0, "bottomShadowView");
            super();
            this.a = view0;
        }

        @Override  // androidx.recyclerview.widget.A0
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView0, int v) {
            boolean z = false;
            q.g(recyclerView0, "recyclerView");
            super.onScrollStateChanged(recyclerView0, v);
            w0 w00 = recyclerView0.getLayoutManager();
            if(w00 instanceof LinearLayoutManager) {
                if(recyclerView0.computeVerticalScrollRange() > recyclerView0.getHeight()) {
                    j0 j00 = recyclerView0.getAdapter();
                    if(((LinearLayoutManager)w00).findLastCompletelyVisibleItemPosition() < (j00 == null ? 0 : j00.getItemCount() - 1)) {
                        z = true;
                    }
                }
                ViewUtils.showWhen(this.a, z);
            }
        }
    }

    public static final int $stable = 8;
    public final r a;
    public final r b;
    public final r c;

    public MelonBaseLifecyclePopup(@NotNull Context context0) {
        q.g(context0, "context");
        super(context0);
        this.a = g.Q(new c(context0, 2));
        this.b = g.Q(new com.iloen.melon.popup.D(this, 1));
        this.c = g.Q(new com.iloen.melon.popup.D(this, 0));

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.popup.MelonBaseLifecyclePopup.sizer.2.1 extends n implements a {
            @Override  // we.a
            public Object invoke() {
                this.invoke();
                return H.a;
            }

            public final void invoke() {
                ((MelonBaseLifecyclePopup)this.receiver).dismiss();
            }
        }

    }

    public final B2 a() {
        return (B2)this.a.getValue();
    }

    @Override  // android.app.Dialog
    public void dismiss() {
        super.dismiss();
        ((F)this.b.getValue()).h(s.a);
    }

    @Override  // androidx.lifecycle.D
    @NotNull
    public t getLifecycle() {
        return (F)this.b.getValue();
    }

    public abstract void inflateContentView(@NotNull ViewGroup arg1);

    @Override  // com.iloen.melon.popup.ConfigChangeable
    public void onConfigurationChanged() {
        ((PopupSizer)this.c.getValue()).setConfigurationChanged();
    }

    @Override  // android.app.Dialog
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        ((F)this.b.getValue()).h(s.c);
        this.requestWindowFeature(1);
        this.setContentView(this.a().a);
        this.inflateContentView(this.a().b);
        this.onViewCreated();
        B2 b20 = this.a();
        E e0 = new E(this, 2);
        b20.c.setOnClickListener(e0);
        ViewUtilsKt.setAccessibilityButtonClassName(this.a().d);
        Window window0 = this.getWindow();
        if(window0 != null) {
            window0.setBackgroundDrawableResource(0x7F06048A);  // color:transparent
            WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
            q.f(windowManager$LayoutParams0, "getAttributes(...)");
            WindowManager.LayoutParams windowManager$LayoutParams1 = this.setWindowLayoutParams(windowManager$LayoutParams0);
            if(this.useEnterExitSlideAnimation()) {
                windowManager$LayoutParams1.windowAnimations = 0x7F140189;  // style:MelonDialogAnimation
            }
            window0.setAttributes(windowManager$LayoutParams1);
        }
    }

    @Override  // android.app.Dialog
    public boolean onKeyDown(int v, @NotNull KeyEvent keyEvent0) {
        q.g(keyEvent0, "event");
        Context context0 = this.getContext();
        q.f(context0, "getContext(...)");
        return VolumeUtils.Companion.onVolumeKeyDown(context0, v) ? true : super.onKeyDown(v, keyEvent0);
    }

    @Override  // android.app.Dialog
    public void onStart() {
        super.onStart();
        ((F)this.b.getValue()).h(s.e);
    }

    @Override  // android.app.Dialog
    public void onStop() {
        super.onStop();
        ((F)this.b.getValue()).h(s.c);
    }

    public void onViewCreated() {
    }

    @NotNull
    public final WindowManager.LayoutParams setWindowLayoutParams(@NotNull WindowManager.LayoutParams windowManager$LayoutParams0) {
        q.g(windowManager$LayoutParams0, "wlp");
        ((PopupSizer)this.c.getValue()).init();
        return ((PopupSizer)this.c.getValue()).getProperWindowLayoutParams(windowManager$LayoutParams0);
    }

    public boolean useEnterExitSlideAnimation() {
        return false;
    }
}

