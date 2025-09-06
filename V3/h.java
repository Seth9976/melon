package v3;

import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.appcompat.app.o;
import androidx.media3.common.TrackSelectionParameters.Builder;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector.Parameters.Builder;
import b3.u0;
import e3.b;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Objects;
import s3.g0;
import t9.B;
import ye.a;

public final class h extends u0 {
    public static final String A0;
    public static final String B0;
    public static final String C0;
    public static final String D0;
    public static final String E0;
    public static final String F0;
    public static final String G0;
    public static final String H0;
    public static final String I0;
    public static final String J0;
    public final boolean i0;
    public final boolean j0;
    public final boolean k0;
    public final boolean l0;
    public final boolean m0;
    public final boolean n0;
    public final boolean o0;
    public final SparseArray p0;
    public final SparseBooleanArray q0;
    public static final String r0;
    public static final String s0;
    public static final String t0;
    public static final String u0;
    public static final String v0;
    public static final String w0;
    public static final String x0;
    public static final String y0;
    public static final String z0;

    static {
        new h(new DefaultTrackSelector.Parameters.Builder());
        h.r0 = "rs";
        h.s0 = "rt";
        h.t0 = "ru";
        h.u0 = "rv";
        h.v0 = "rw";
        h.w0 = "rx";
        h.x0 = "ry";
        h.y0 = "rz";
        h.z0 = "s0";
        h.A0 = "s1";
        h.B0 = "s2";
        h.C0 = "s3";
        h.D0 = "s4";
        h.E0 = "s5";
        h.F0 = "s6";
        h.G0 = "s7";
        h.H0 = "s8";
        h.I0 = "s9";
        h.J0 = "sa";
    }

    public h(DefaultTrackSelector.Parameters.Builder defaultTrackSelector$Parameters$Builder0) {
        super(defaultTrackSelector$Parameters$Builder0);
        this.i0 = defaultTrackSelector$Parameters$Builder0.C;
        this.j0 = defaultTrackSelector$Parameters$Builder0.D;
        this.k0 = defaultTrackSelector$Parameters$Builder0.E;
        this.l0 = defaultTrackSelector$Parameters$Builder0.F;
        this.m0 = defaultTrackSelector$Parameters$Builder0.G;
        this.n0 = defaultTrackSelector$Parameters$Builder0.H;
        this.o0 = defaultTrackSelector$Parameters$Builder0.I;
        this.p0 = defaultTrackSelector$Parameters$Builder0.J;
        this.q0 = defaultTrackSelector$Parameters$Builder0.K;
    }

    @Override  // b3.u0
    public final TrackSelectionParameters.Builder a() {
        return new DefaultTrackSelector.Parameters.Builder(this);
    }

    @Override  // b3.u0
    public final Bundle c() {
        Bundle bundle0 = super.c();
        bundle0.putBoolean(h.r0, this.i0);
        bundle0.putBoolean(h.s0, false);
        bundle0.putBoolean(h.t0, this.j0);
        bundle0.putBoolean(h.F0, false);
        bundle0.putBoolean(h.u0, this.k0);
        bundle0.putBoolean(h.v0, false);
        bundle0.putBoolean(h.w0, false);
        bundle0.putBoolean(h.x0, false);
        bundle0.putBoolean(h.G0, false);
        bundle0.putBoolean(h.J0, this.l0);
        bundle0.putBoolean(h.H0, this.m0);
        bundle0.putBoolean(h.y0, this.n0);
        bundle0.putBoolean(h.z0, false);
        bundle0.putBoolean(h.A0, this.o0);
        bundle0.putBoolean(h.I0, false);
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        SparseArray sparseArray0 = new SparseArray();
        int v1 = 0;
        while(true) {
            SparseArray sparseArray1 = this.p0;
            if(v1 >= sparseArray1.size()) {
                break;
            }
            int v2 = sparseArray1.keyAt(v1);
            for(Object object0: ((Map)sparseArray1.valueAt(v1)).entrySet()) {
                if(((Map.Entry)object0).getValue() != null) {
                    throw new ClassCastException();
                }
                arrayList1.add(((g0)((Map.Entry)object0).getKey()));
                arrayList0.add(v2);
            }
            int[] arr_v = a.Y(arrayList0);
            bundle0.putIntArray(h.B0, arr_v);
            ArrayList arrayList2 = b.C(arrayList1, new B(4));
            bundle0.putParcelableArrayList(h.C0, arrayList2);
            SparseArray sparseArray2 = new SparseArray(sparseArray0.size());
            if(sparseArray0.size() <= 0) {
                bundle0.putSparseParcelableArray(h.D0, sparseArray2);
                ++v1;
                continue;
            }
            sparseArray0.keyAt(0);
            o.z(sparseArray0.valueAt(0));
            throw null;
        }
        SparseBooleanArray sparseBooleanArray0 = this.q0;
        int[] arr_v1 = new int[sparseBooleanArray0.size()];
        for(int v = 0; v < sparseBooleanArray0.size(); ++v) {
            arr_v1[v] = sparseBooleanArray0.keyAt(v);
        }
        bundle0.putIntArray(h.E0, arr_v1);
        return bundle0;
    }

    @Override  // b3.u0
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 != null) {
                Class class0 = object0.getClass();
                if(h.class == class0 && super.equals(((h)object0)) && this.i0 == ((h)object0).i0 && this.j0 == ((h)object0).j0 && this.k0 == ((h)object0).k0 && this.l0 == ((h)object0).l0 && this.m0 == ((h)object0).m0 && this.n0 == ((h)object0).n0 && this.o0 == ((h)object0).o0) {
                    SparseBooleanArray sparseBooleanArray0 = ((h)object0).q0;
                    SparseBooleanArray sparseBooleanArray1 = this.q0;
                    int v = sparseBooleanArray1.size();
                    if(sparseBooleanArray0.size() == v) {
                        for(int v1 = 0; v1 < v; ++v1) {
                            if(sparseBooleanArray0.indexOfKey(sparseBooleanArray1.keyAt(v1)) < 0) {
                                return false;
                            }
                        }
                        SparseArray sparseArray0 = ((h)object0).p0;
                        SparseArray sparseArray1 = this.p0;
                        int v2 = sparseArray1.size();
                        if(sparseArray0.size() == v2) {
                            for(int v3 = 0; v3 < v2; ++v3) {
                                int v4 = sparseArray0.indexOfKey(sparseArray1.keyAt(v3));
                                if(v4 < 0) {
                                    return false;
                                }
                                Map map0 = (Map)sparseArray1.valueAt(v3);
                                Map map1 = (Map)sparseArray0.valueAt(v4);
                                if(map1.size() != map0.size()) {
                                    return false;
                                }
                                for(Object object1: map0.entrySet()) {
                                    g0 g00 = (g0)((Map.Entry)object1).getKey();
                                    if(!map1.containsKey(g00) || !Objects.equals(((Map.Entry)object1).getValue(), map1.get(g00))) {
                                        return false;
                                    }
                                    if(false) {
                                        break;
                                    }
                                }
                            }
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override  // b3.u0
    public final int hashCode() {
        return ((((((((super.hashCode() + 0x1F) * 0x1F + this.i0) * 961 + this.j0) * 961 + this.k0) * 0x1B4D89F + this.l0) * 0x1F + this.m0) * 0x1F + this.n0) * 961 + this.o0) * 0x1F;
    }
}

