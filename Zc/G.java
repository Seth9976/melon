package zc;

import A0.f;
import Tf.u;
import android.content.Context;
import android.graphics.DashPathEffect;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.Z;
import com.iloen.melon.net.v4x.common.GraphDataListInfo.GRAPHDATA;
import com.iloen.melon.net.v4x.common.GraphDataListInfo;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;
import we.k;
import y0.M;
import y0.h;

public final class g implements k {
    public final ArrayList a;
    public final List b;
    public final Context c;
    public final zc.k d;
    public final List e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;
    public final float j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final Z r;

    public g(ArrayList arrayList0, List list0, Context context0, zc.k k0, List list1, float f, float f1, float f2, float f3, float f4, int v, int v1, int v2, int v3, int v4, Z z0) {
        this.a = arrayList0;
        this.b = list0;
        this.c = context0;
        this.d = k0;
        this.e = list1;
        this.f = f;
        this.g = f1;
        this.h = f2;
        this.i = f3;
        this.j = f4;
        this.k = v;
        this.l = v1;
        this.m = v2;
        this.n = v3;
        this.o = v4;
        this.r = z0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        long v5;
        List list3;
        int v4;
        float f12;
        float f11;
        float f9;
        GraphDataListInfo graphDataListInfo1;
        Float float1;
        q.g(((f)object0), "$this$Canvas");
        float f = (float)ViewUtilsKt.dpToPx(5.0f);
        float f1 = (float)ViewUtilsKt.dpToPx(3.0f);
        for(Object object1: this.a) {
            int v = ((Number)object1).intValue();
            GraphDataListInfo graphDataListInfo0 = (GraphDataListInfo)this.b.get(v);
            List list0 = this.d.j;
            float f2 = this.d.e;
            Object object2 = v >= list0.size() ? p.s0(list0) : list0.get(v);
            long v1 = M.c(ColorUtils.getColor(this.c, ((Number)object2).intValue()));
            List list1 = graphDataListInfo0.graphDataList;
            q.f(list1, "graphDataList");
            int v2 = 0;
            for(Object object3: list1) {
                if(v2 >= 0) {
                    List list2 = this.e;
                    if(v2 < list2.size()) {
                        String s = ((GRAPHDATA)object3).value;
                        q.f(s, "value");
                        Float float0 = u.g0(s);
                        if(v2 > 0) {
                            String s1 = ((GRAPHDATA)graphDataListInfo0.graphDataList.get(v2 - 1)).value;
                            q.f(s1, "value");
                            float1 = u.g0(s1);
                        }
                        else {
                            float1 = float0;
                        }
                        float f3 = this.f;
                        float f4 = ((f)object0).Y(f2) + ((float)Integer.max(v2 - 1, 0)) * f3;
                        float f5 = this.g;
                        graphDataListInfo1 = graphDataListInfo0;
                        float f6 = this.h;
                        float f7 = this.i;
                        float f8 = this.j;
                        Z z0 = this.r;
                        if(float1 == null) {
                            f9 = -1.0f;
                        }
                        else {
                            f9 = q.a(float1, 0.0f) ? f5 : ((I0)z0).m() - ((float)float1) / f6 * f7 + f8;
                        }
                        float f10 = ((f)object0).Y(f2) + ((float)v2) * f3;
                        if(float0 == null) {
                            f11 = -1.0f;
                        }
                        else {
                            if(!q.a(float0, 0.0f)) {
                                f5 = ((I0)z0).m() - ((float)float0) / f6 * f7 + f8;
                            }
                            f11 = f5;
                        }
                        int v3 = this.k;
                        if(Float.compare(f9, -1.0f) == 0 || f11 == -1.0f) {
                            f12 = f2;
                            v5 = v1;
                            list3 = list2;
                            v4 = v3;
                        }
                        else {
                            f12 = f2;
                            v4 = v3;
                            list3 = list2;
                            v5 = v1;
                            f.k0(((f)object0), v5, ((long)Float.floatToRawIntBits(f9)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f4)) << 0x20, ((long)Float.floatToRawIntBits(f11)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f10)) << 0x20, ((float)(v == v3 ? this.l : this.m)), 0, new h(new DashPathEffect(new float[]{(v == v3 ? f : f1), f1}, 0.0f)), 0x1D0);
                        }
                        if((v == v4 || list3.size() == 1) && f11 != -1.0f) {
                            f.Q(((f)object0), v5, ((float)(v == v4 ? this.n : this.o)), ((long)Float.floatToRawIntBits(f10)) << 0x20 | ((long)Float.floatToRawIntBits(f11)) & 0xFFFFFFFFL, 120);
                        }
                    }
                    else {
                        graphDataListInfo1 = graphDataListInfo0;
                        f12 = f2;
                        v5 = v1;
                    }
                    v1 = v5;
                    ++v2;
                    graphDataListInfo0 = graphDataListInfo1;
                    f2 = f12;
                    continue;
                }
                e.k.O();
                throw null;
            }
        }
        return H.a;
    }
}

