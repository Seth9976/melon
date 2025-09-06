package androidx.compose.ui.platform;

import A3.c;
import F.e;
import I.i;
import P0.r0;
import Q0.A0;
import Q0.X0;
import Q0.Y0;
import Q0.Z0;
import Q0.Z;
import Q0.a1;
import Q0.b0;
import Q0.g1;
import Q0.h1;
import Q0.i1;
import Q0.j1;
import Q0.n1;
import Q0.q1;
import Q0.u1;
import Q0.u;
import Q0.v1;
import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.V;
import androidx.compose.runtime.W;
import androidx.compose.runtime.o0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.s;
import androidx.compose.runtime.u0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.t;
import e.k;
import i.n.i.b.a.s.e.M3;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;
import m0.b;
import me.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.d;
import r0.r;
import we.a;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\b\'\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\b\u0010\u000B\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000EJ\u0015\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000F¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0014\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R(\u0010\u001D\u001A\u0004\u0018\u00010\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u00178\u0002@BX\u0082\u000E¢\u0006\f\n\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR(\u0010!\u001A\u0004\u0018\u00010\n2\b\u0010\u0018\u001A\u0004\u0018\u00010\n8\u0002@BX\u0082\u000E¢\u0006\f\n\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010\u000ER$\u0010\'\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\"8\u0002@\u0002X\u0082\u000E¢\u0006\f\n\u0004\b#\u0010$\u0012\u0004\b%\u0010&R0\u0010.\u001A\u00020\u00132\u0006\u0010\u0018\u001A\u00020\u00138F@FX\u0087\u000E¢\u0006\u0018\n\u0004\b(\u0010)\u0012\u0004\b-\u0010&\u001A\u0004\b*\u0010+\"\u0004\b,\u0010\u0016R\u0014\u00100\u001A\u00020\u00138TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b/\u0010+R\u0011\u00102\u001A\u00020\u00138F¢\u0006\u0006\u001A\u0004\b1\u0010+¨\u00063"}, d2 = {"Landroidx/compose/ui/platform/AbstractComposeView;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/compose/runtime/s;", "parent", "Lie/H;", "setParentCompositionContext", "(Landroidx/compose/runtime/s;)V", "LQ0/a1;", "strategy", "setViewCompositionStrategy", "(LQ0/a1;)V", "", "isTransitionGroup", "setTransitionGroup", "(Z)V", "Landroid/os/IBinder;", "value", "b", "Landroid/os/IBinder;", "setPreviousAttachedWindowToken", "(Landroid/os/IBinder;)V", "previousAttachedWindowToken", "d", "Landroidx/compose/runtime/s;", "setParentContext", "parentContext", "Lkotlin/Function0;", "e", "Lwe/a;", "getDisposeViewCompositionStrategy$annotations", "()V", "disposeViewCompositionStrategy", "f", "Z", "getShowLayoutBounds", "()Z", "setShowLayoutBounds", "getShowLayoutBounds$annotations", "showLayoutBounds", "getShouldCreateCompositionOnAttachedToWindow", "shouldCreateCompositionOnAttachedToWindow", "getHasComposition", "hasComposition", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public abstract class AbstractComposeView extends ViewGroup {
    public WeakReference a;
    public IBinder b;
    public u1 c;
    public s d;
    public a e;
    public boolean f;
    public boolean g;
    public boolean h;

    public AbstractComposeView(@NotNull Context context0) {
        this(context0, null, 6, 0);
    }

    public AbstractComposeView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        this(context0, attributeSet0, 4, 0);
    }

    public AbstractComposeView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.setClipChildren(false);
        this.setClipToPadding(false);
        this.setImportantForAccessibility(1);
        X0 x00 = new X0(this, 1);
        this.addOnAttachStateChangeListener(x00);
        Y0 y00 = new Y0(this);
        k.t(this).a.add(y00);
        this.e = new i(this, x00, y00, 3);
    }

    public AbstractComposeView(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0, 0);
    }

    public abstract void a(p arg1);

    @Override  // android.view.ViewGroup
    public final void addView(View view0) {
        this.b();
        super.addView(view0);
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v) {
        this.b();
        super.addView(view0, v);
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v, int v1) {
        this.b();
        super.addView(view0, v, v1);
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.b();
        super.addView(view0, v, viewGroup$LayoutParams0);
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.b();
        super.addView(view0, viewGroup$LayoutParams0);
    }

    @Override  // android.view.ViewGroup
    public final boolean addViewInLayout(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.b();
        return super.addViewInLayout(view0, v, viewGroup$LayoutParams0);
    }

    @Override  // android.view.ViewGroup
    public final boolean addViewInLayout(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0, boolean z) {
        this.b();
        return super.addViewInLayout(view0, v, viewGroup$LayoutParams0, z);
    }

    public final void b() {
        if(!this.g) {
            throw new UnsupportedOperationException("Cannot add views to " + this.getClass().getSimpleName() + "; only Compose content is supported");
        }
    }

    public final void c() {
        u1 u10 = this.c;
        if(u10 != null) {
            u10.a();
        }
        this.c = null;
        this.requestLayout();
    }

    public final void d() {
        if(this.c == null) {
            try {
                this.g = true;
                this.c = v1.a(this, this.g(), new b(0xD8E40040, new e(this, 10), true));
                this.g = false;
            }
            catch(Throwable throwable0) {
                this.g = false;
                throw throwable0;
            }
        }
    }

    public void e(int v, int v1, int v2, int v3, boolean z) {
        View view0 = this.getChildAt(0);
        if(view0 != null) {
            view0.layout(this.getPaddingLeft(), this.getPaddingTop(), v2 - v - this.getPaddingRight(), v3 - v1 - this.getPaddingBottom());
        }
    }

    public void f(int v, int v1) {
        View view0 = this.getChildAt(0);
        if(view0 == null) {
            super.onMeasure(v, v1);
            return;
        }
        int v2 = Math.max(0, View.MeasureSpec.getSize(v) - this.getPaddingLeft() - this.getPaddingRight());
        int v3 = Math.max(0, View.MeasureSpec.getSize(v1) - this.getPaddingTop() - this.getPaddingBottom());
        view0.measure(View.MeasureSpec.makeMeasureSpec(v2, View.MeasureSpec.getMode(v)), View.MeasureSpec.makeMeasureSpec(v3, View.MeasureSpec.getMode(v1)));
        int v4 = view0.getMeasuredWidth();
        int v5 = this.getPaddingLeft();
        int v6 = this.getPaddingRight();
        int v7 = view0.getMeasuredHeight();
        int v8 = this.getPaddingTop();
        this.setMeasuredDimension(v6 + (v5 + v4), this.getPaddingBottom() + (v8 + v7));
    }

    public final s g() {
        s s4;
        b0 b00;
        me.i i0;
        s s0 = this.d;
        if(s0 == null) {
            s0 = q1.b(this);
            if(s0 == null) {
                for(ViewParent viewParent0 = this.getParent(); s0 == null && viewParent0 instanceof View; viewParent0 = viewParent0.getParent()) {
                    s0 = q1.b(((View)viewParent0));
                }
            }
            s s1 = null;
            if(s0 == null) {
                s0 = null;
            }
            else {
                s s2 = !(s0 instanceof u0) || ((o0)((u0)s0).u.getValue()).compareTo(o0.b) > 0 ? s0 : null;
                if(s2 != null) {
                    this.a = new WeakReference(s2);
                }
            }
            if(s0 == null) {
                WeakReference weakReference0 = this.a;
                if(weakReference0 == null) {
                    s0 = null;
                }
                else {
                    s0 = (s)weakReference0.get();
                    if(s0 == null || s0 instanceof u0 && ((o0)((u0)s0).u.getValue()).compareTo(o0.b) <= 0) {
                        s0 = null;
                    }
                }
                if(s0 == null) {
                    if(!this.isAttachedToWindow()) {
                        M0.a.b(("Cannot locate windowRecomposer; View " + this + " is not attached to a window"));
                    }
                    ViewParent viewParent1 = this.getParent();
                    View view0 = this;
                    while(viewParent1 instanceof View && ((View)viewParent1).getId() != 0x1020002) {
                        ViewParent viewParent2 = ((View)viewParent1).getParent();
                        view0 = (View)viewParent1;
                        viewParent1 = viewParent2;
                    }
                    s s3 = q1.b(view0);
                    if(s3 == null) {
                        ((g1)j1.a.get()).getClass();
                        j j0 = j.a;
                        if(Looper.myLooper() == Looper.getMainLooper()) {
                            i0 = (me.i)Z.l.getValue();
                        }
                        else {
                            i0 = (me.i)Z.m.get();
                            if(i0 == null) {
                                throw new IllegalStateException("no AndroidUiDispatcher for this thread");
                            }
                        }
                        me.i i1 = i0.plus(j0);
                        W w0 = (W)i1.get(V.b);
                        if(w0 == null) {
                            b00 = null;
                        }
                        else {
                            b00 = new b0(w0);
                            synchronized(((c)b00.c).b) {
                                ((c)b00.c).a = false;
                            }
                        }
                        H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                        r r0 = (r)i1.get(d.r);
                        if(r0 == null) {
                            r0 = new A0();
                            h0.a = r0;
                        }
                        if(b00 != null) {
                            j0 = b00;
                        }
                        me.i i2 = i1.plus(j0).plus(r0);
                        s4 = new u0(i2);
                        synchronized(s4.c) {
                            s4.t = true;
                        }
                        CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(i2);
                        D d0 = f0.d(view0);
                        t t0 = d0 == null ? null : d0.getLifecycle();
                        if(t0 != null) {
                            view0.addOnAttachStateChangeListener(new Z0(view0, 1, s4));
                            t0.a(new n1(coroutineScope0, b00, ((u0)s4), h0, view0));
                            view0.setTag(0x7F0A009E, s4);  // id:androidx_compose_ui_view_composition_context
                            HandlerDispatcher handlerDispatcher0 = HandlerDispatcherKt.from(view0.getHandler(), "windowRecomposer cleanup").getImmediate();
                            i1 i10 = new i1(((u0)s4), view0, null);
                            view0.addOnAttachStateChangeListener(new h1(BuildersKt__Builders_commonKt.launch$default(() -> j.a, handlerDispatcher0, null, i10, 2, null)));
                            goto label_80;
                        }
                        M0.a.c(("ViewTreeLifecycleOwner not found from " + view0));
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    if(!(s3 instanceof u0)) {
                        throw new IllegalStateException("root viewTreeParentCompositionContext is not a Recomposer");
                    }
                    s4 = (u0)s3;
                label_80:
                    if(((o0)s4.u.getValue()).compareTo(o0.b) > 0) {
                        s1 = s4;
                    }
                    if(s1 != null) {
                        this.a = new WeakReference(s1);
                    }
                    return s4;
                }
            }
        }
        return s0;
    }

    private static void getDisposeViewCompositionStrategy$annotations() {
    }

    public final boolean getHasComposition() {
        return this.c != null;
    }

    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return true;
    }

    public final boolean getShowLayoutBounds() {
        return this.f;
    }

    public static void getShowLayoutBounds$annotations() {
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.ViewGroup
    public final boolean isTransitionGroup() {
        return !this.h || super.isTransitionGroup();
    }

    @Override  // android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.setPreviousAttachedWindowToken(this.getWindowToken());
        if(this.getShouldCreateCompositionOnAttachedToWindow()) {
            this.d();
        }
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        this.e(v, v1, v2, v3, z);
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        this.d();
        this.f(v, v1);
    }

    @Override  // android.view.View
    public final void onRtlPropertiesChanged(int v) {
        View view0 = this.getChildAt(0);
        if(view0 == null) {
            return;
        }
        view0.setLayoutDirection(v);
    }

    public final void setParentCompositionContext(@Nullable s s0) {
        this.setParentContext(s0);
    }

    private final void setParentContext(s s0) {
        if(this.d != s0) {
            this.d = s0;
            if(s0 != null) {
                this.a = null;
            }
            u1 u10 = this.c;
            if(u10 != null) {
                u10.a();
                this.c = null;
                if(this.isAttachedToWindow()) {
                    this.d();
                }
            }
        }
    }

    private final void setPreviousAttachedWindowToken(IBinder iBinder0) {
        if(this.b != iBinder0) {
            this.b = iBinder0;
            this.a = null;
        }
    }

    public final void setShowLayoutBounds(boolean z) {
        this.f = z;
        View view0 = this.getChildAt(0);
        if(view0 != null) {
            ((u)(((r0)view0))).setShowLayoutBounds(z);
        }
    }

    @Override  // android.view.ViewGroup
    public void setTransitionGroup(boolean z) {
        super.setTransitionGroup(z);
        this.h = true;
    }

    public final void setViewCompositionStrategy(@NotNull a1 a10) {
        a a0 = this.e;
        if(a0 != null) {
            a0.invoke();
        }
        this.e = a10.u(this);
    }

    @Override  // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}

