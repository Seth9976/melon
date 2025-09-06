package androidx.media3.exoplayer.trackselection;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.media3.common.TrackSelectionParameters.Builder;
import b3.r0;
import b3.u0;
import java.util.HashMap;
import java.util.Map;
import v3.h;

public final class DefaultTrackSelector.Parameters.Builder extends TrackSelectionParameters.Builder {
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public final SparseArray J;
    public final SparseBooleanArray K;

    public DefaultTrackSelector.Parameters.Builder() {
        this.J = new SparseArray();
        this.K = new SparseBooleanArray();
        this.j();
    }

    public DefaultTrackSelector.Parameters.Builder(Context context0) {
        super(context0);
        this.J = new SparseArray();
        this.K = new SparseBooleanArray();
        this.j();
    }

    public DefaultTrackSelector.Parameters.Builder(h h0) {
        this.d(h0);
        this.C = h0.i0;
        this.D = h0.j0;
        this.E = h0.k0;
        this.F = h0.l0;
        this.G = h0.m0;
        this.H = h0.n0;
        this.I = h0.o0;
        SparseArray sparseArray0 = h0.p0;
        SparseArray sparseArray1 = new SparseArray();
        for(int v = 0; v < sparseArray0.size(); ++v) {
            sparseArray1.put(sparseArray0.keyAt(v), new HashMap(((Map)sparseArray0.valueAt(v))));
        }
        this.J = sparseArray1;
        this.K = h0.q0.clone();
    }

    @Override  // androidx.media3.common.TrackSelectionParameters$Builder
    public final void a(r0 r00) {
        this.A.put(r00.a, r00);
    }

    @Override  // androidx.media3.common.TrackSelectionParameters$Builder
    public final u0 b() {
        return new h(this);
    }

    @Override  // androidx.media3.common.TrackSelectionParameters$Builder
    public final TrackSelectionParameters.Builder c() {
        super.c();
        return this;
    }

    @Override  // androidx.media3.common.TrackSelectionParameters$Builder
    public final TrackSelectionParameters.Builder g(int v, int v1) {
        super.g(v, v1);
        return this;
    }

    public final void i() {
        super.c();
    }

    public final void j() {
        this.C = true;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = true;
        this.I = true;
    }

    public final void k(Context context0) {
        super.f(context0);
    }

    public final void l(int v, int v1) {
        super.g(v, v1);
    }

    public final void m(Context context0) {
        super.h(context0);
    }
}

