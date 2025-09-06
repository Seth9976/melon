package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import c2.B0;
import c2.W;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z2.a;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u0004\u0010\nJ\u0019\u0010\u000E\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u0019\u0010\u0012\u001A\u00020\r2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001A\u001A\u00028\u0000\"\n\b\u0000\u0010\u0019*\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2 = {"Landroidx/fragment/app/FragmentContainerView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/animation/LayoutTransition;", "transition", "Lie/H;", "setLayoutTransition", "(Landroid/animation/LayoutTransition;)V", "Landroid/view/View$OnApplyWindowInsetsListener;", "listener", "setOnApplyWindowInsetsListener", "(Landroid/view/View$OnApplyWindowInsetsListener;)V", "", "drawDisappearingViewsFirst", "setDrawDisappearingViewsLast", "(Z)V", "Landroidx/fragment/app/I;", "F", "getFragment", "()Landroidx/fragment/app/I;", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FragmentContainerView extends FrameLayout {
    public final ArrayList a;
    public final ArrayList b;
    public View.OnApplyWindowInsetsListener c;
    public boolean d;

    public FragmentContainerView(@NotNull Context context0) {
        q.g(context0, "context");
        super(context0);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.d = true;
    }

    public FragmentContainerView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 0);
    }

    public FragmentContainerView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        String s1;
        super(context0, attributeSet0, v);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.d = true;
        if(attributeSet0 != null) {
            String s = attributeSet0.getClassAttribute();
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.b, 0, 0);
            if(s == null) {
                s = typedArray0.getString(0);
                s1 = "android:name";
            }
            else {
                s1 = "class";
            }
            typedArray0.recycle();
            if(s != null && !this.isInEditMode()) {
                throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + s1 + "=\"" + s + '\"');
            }
        }
    }

    public FragmentContainerView(Context context0, AttributeSet attributeSet0, l0 l00) {
        q.g(context0, "context");
        q.g(attributeSet0, "attrs");
        super(context0, attributeSet0);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.d = true;
        String s = attributeSet0.getClassAttribute();
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.b, 0, 0);
        if(s == null) {
            s = typedArray0.getString(0);
        }
        String s1 = typedArray0.getString(1);
        typedArray0.recycle();
        int v = this.getId();
        if(s != null && l00.D(v) == null) {
            if(v == -1) {
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + s + (s1 == null ? "" : " with tag " + s1));
            }
            b0 b00 = l00.M();
            context0.getClassLoader();
            I i0 = I.instantiate(b00.a.x.b, s, null);
            q.f(i0, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            i0.mFragmentId = v;
            i0.mContainerId = v;
            i0.mTag = s1;
            i0.mFragmentManager = l00;
            i0.mHost = l00.x;
            i0.onInflate(context0, attributeSet0, null);
            androidx.fragment.app.a a0 = new androidx.fragment.app.a(l00);
            a0.p = true;
            i0.mContainer = this;
            i0.mInDynamicContainer = true;
            a0.e(this.getId(), i0, s1, 1);
            if(a0.g) {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
            a0.h = false;
            a0.r.A(a0, true);
        }
        for(Object object0: l00.c.d()) {
            t0 t00 = (t0)object0;
            I i1 = t00.c;
            if(i1.mContainerId == this.getId() && (i1.mView != null && i1.mView.getParent() == null)) {
                i1.mContainer = this;
                t00.b();
                t00.k();
            }
        }
    }

    public final void a(View view0) {
        if(this.b.contains(view0)) {
            this.a.add(view0);
        }
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        q.g(view0, "child");
        Object object0 = view0.getTag(0x7F0A04DE);  // id:fragment_container_view_tag
        if((object0 instanceof I ? ((I)object0) : null) == null) {
            throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view0 + " is not associated with a Fragment.").toString());
        }
        super.addView(view0, v, viewGroup$LayoutParams0);
    }

    @Override  // android.view.ViewGroup
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets0) {
        B0 b01;
        q.g(windowInsets0, "insets");
        B0 b00 = B0.h(null, windowInsets0);
        View.OnApplyWindowInsetsListener view$OnApplyWindowInsetsListener0 = this.c;
        if(view$OnApplyWindowInsetsListener0 == null) {
            b01 = W.j(this, b00);
        }
        else {
            q.d(view$OnApplyWindowInsetsListener0);
            WindowInsets windowInsets1 = view$OnApplyWindowInsetsListener0.onApplyWindowInsets(this, windowInsets0);
            q.f(windowInsets1, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            b01 = B0.h(null, windowInsets1);
        }
        q.f(b01, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if(!b01.a.o()) {
            int v = this.getChildCount();
            for(int v1 = 0; v1 < v; ++v1) {
                W.b(this.getChildAt(v1), b01);
            }
        }
        return windowInsets0;
    }

    @Override  // android.view.ViewGroup
    public final void dispatchDraw(Canvas canvas0) {
        q.g(canvas0, "canvas");
        if(this.d) {
            for(Object object0: this.a) {
                super.drawChild(canvas0, ((View)object0), this.getDrawingTime());
            }
        }
        super.dispatchDraw(canvas0);
    }

    @Override  // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas0, View view0, long v) {
        q.g(canvas0, "canvas");
        q.g(view0, "child");
        return !this.d || (this.a.isEmpty() || !this.a.contains(view0)) ? super.drawChild(canvas0, view0, v) : false;
    }

    @Override  // android.view.ViewGroup
    public final void endViewTransition(View view0) {
        q.g(view0, "view");
        this.b.remove(view0);
        if(this.a.remove(view0)) {
            this.d = true;
        }
        super.endViewTransition(view0);
    }

    public final I getFragment() {
        FragmentActivity fragmentActivity0;
        I i0 = l0.F(this);
        if(i0 != null) {
            if(!i0.isAdded()) {
                throw new IllegalStateException("The Fragment " + i0 + " that owns View " + this + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
            }
            return i0.getChildFragmentManager().D(this.getId());
        }
        for(Context context0 = this.getContext(); true; context0 = ((ContextWrapper)context0).getBaseContext()) {
            fragmentActivity0 = null;
            if(!(context0 instanceof ContextWrapper)) {
                break;
            }
            if(context0 instanceof FragmentActivity) {
                fragmentActivity0 = (FragmentActivity)context0;
                break;
            }
        }
        if(fragmentActivity0 == null) {
            throw new IllegalStateException("View " + this + " is not within a subclass of FragmentActivity.");
        }
        return fragmentActivity0.getSupportFragmentManager().D(this.getId());
    }

    @Override  // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets0) {
        q.g(windowInsets0, "insets");
        return windowInsets0;
    }

    @Override  // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        for(int v = this.getChildCount() - 1; -1 < v; --v) {
            View view0 = this.getChildAt(v);
            q.f(view0, "view");
            this.a(view0);
        }
        super.removeAllViewsInLayout();
    }

    @Override  // android.view.ViewGroup
    public final void removeView(View view0) {
        q.g(view0, "view");
        this.a(view0);
        super.removeView(view0);
    }

    @Override  // android.view.ViewGroup
    public final void removeViewAt(int v) {
        View view0 = this.getChildAt(v);
        q.f(view0, "view");
        this.a(view0);
        super.removeViewAt(v);
    }

    @Override  // android.view.ViewGroup
    public final void removeViewInLayout(View view0) {
        q.g(view0, "view");
        this.a(view0);
        super.removeViewInLayout(view0);
    }

    @Override  // android.view.ViewGroup
    public final void removeViews(int v, int v1) {
        for(int v2 = v; v2 < v + v1; ++v2) {
            View view0 = this.getChildAt(v2);
            q.f(view0, "view");
            this.a(view0);
        }
        super.removeViews(v, v1);
    }

    @Override  // android.view.ViewGroup
    public final void removeViewsInLayout(int v, int v1) {
        for(int v2 = v; v2 < v + v1; ++v2) {
            View view0 = this.getChildAt(v2);
            q.f(view0, "view");
            this.a(view0);
        }
        super.removeViewsInLayout(v, v1);
    }

    public final void setDrawDisappearingViewsLast(boolean z) {
        this.d = z;
    }

    @Override  // android.view.ViewGroup
    public void setLayoutTransition(@Nullable LayoutTransition layoutTransition0) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override  // android.view.View
    public void setOnApplyWindowInsetsListener(@Nullable View.OnApplyWindowInsetsListener view$OnApplyWindowInsetsListener0) {
        this.c = view$OnApplyWindowInsetsListener0;
    }

    @Override  // android.view.ViewGroup
    public final void startViewTransition(View view0) {
        q.g(view0, "view");
        if(view0.getParent() == this) {
            this.b.add(view0);
        }
        super.startViewTransition(view0);
    }
}

