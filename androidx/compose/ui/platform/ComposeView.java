package androidx.compose.ui.platform;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u001B\u0010\u0010\u001A\u00020\u000E2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u001A\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00128\u0014@RX\u0094\u000E¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u0016\u0010\u0017¨\u0006\u001B"}, d2 = {"Landroidx/compose/ui/platform/ComposeView;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "getAccessibilityClassName", "()Ljava/lang/CharSequence;", "Lkotlin/Function0;", "Lie/H;", "content", "setContent", "(Lwe/n;)V", "", "<set-?>", "j", "Z", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "getShouldCreateCompositionOnAttachedToWindow$annotations", "()V", "shouldCreateCompositionOnAttachedToWindow", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ComposeView extends AbstractComposeView {
    public final b0 i;
    public boolean j;

    public ComposeView(@NotNull Context context0) {
        this(context0, null, 6, 0);
    }

    public ComposeView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        this(context0, attributeSet0, 4, 0);
    }

    public ComposeView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.i = w.s(null);
    }

    public ComposeView(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0, 0);
    }

    @Override  // androidx.compose.ui.platform.AbstractComposeView
    public final void a(p p0) {
        p0.a0(0x190BF45A);
        n n0 = (n)((O0)this.i).getValue();
        if(n0 == null) {
            p0.a0(0x155C14B9);
        }
        else {
            p0.a0(150107208);
            n0.invoke(p0, 0);
        }
        p0.p(false);
        p0.p(false);
    }

    @Override  // android.view.ViewGroup
    @NotNull
    public CharSequence getAccessibilityClassName() {
        return "androidx.compose.ui.platform.ComposeView";
    }

    @Override  // androidx.compose.ui.platform.AbstractComposeView
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.j;
    }

    public static void getShouldCreateCompositionOnAttachedToWindow$annotations() {
    }

    public final void setContent(@NotNull n n0) {
        this.j = true;
        ((O0)this.i).setValue(n0);
        if(this.isAttachedToWindow()) {
            if(this.d == null && !this.isAttachedToWindow()) {
                throw new IllegalStateException("createComposition requires either a parent reference or the View to be attachedto a window. Attach the View or call setParentCompositionReference.");
            }
            this.d();
        }
    }
}

