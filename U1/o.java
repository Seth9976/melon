package u1;

import I0.d;
import P0.r0;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.n;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.media3.session.legacy.V;
import o0.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

public final class o extends i {
    public final View T;
    public final d V;
    public h W;
    public k b0;
    public k c0;
    public k d0;

    public o(Context context0, k k0, n n0, o0.i i0, int v, r0 r00) {
        Object object0 = k0.invoke(context0);
        d d0 = new d();
        super(context0, n0, v, d0, ((View)object0), r00);
        this.T = (View)object0;
        this.V = d0;
        this.setClipChildren(false);
        String s = String.valueOf(v);
        SparseArray sparseArray0 = null;
        Object object1 = i0 == null ? null : i0.c(s);
        if(object1 instanceof SparseArray) {
            sparseArray0 = (SparseArray)object1;
        }
        if(sparseArray0 != null) {
            ((View)object0).restoreHierarchyState(sparseArray0);
        }
        if(i0 != null) {
            this.setSavableRegistryEntry(i0.d(s, new u1.h(this, 2)));
        }
        this.b0 = a.l;
        this.c0 = a.l;
        this.d0 = a.l;
    }

    @NotNull
    public final d getDispatcher() {
        return this.V;
    }

    @NotNull
    public final k getReleaseBlock() {
        return this.d0;
    }

    @NotNull
    public final k getResetBlock() {
        return this.c0;
    }

    @Nullable
    public AbstractComposeView getSubCompositionView() {
        return null;
    }

    @NotNull
    public final k getUpdateBlock() {
        return this.b0;
    }

    @NotNull
    public View getViewRoot() {
        return this;
    }

    public static final void h(o o0) {
        o0.setSavableRegistryEntry(null);
    }

    public final void setReleaseBlock(@NotNull k k0) {
        this.d0 = k0;
        this.setRelease(new u1.h(this, 3));
    }

    public final void setResetBlock(@NotNull k k0) {
        this.c0 = k0;
        this.setReset(new u1.h(this, 4));
    }

    private final void setSavableRegistryEntry(h h0) {
        h h1 = this.W;
        if(h1 != null) {
            ((V)h1).E();
        }
        this.W = h0;
    }

    public final void setUpdateBlock(@NotNull k k0) {
        this.b0 = k0;
        this.setUpdate(new u1.h(this, 5));
    }
}

