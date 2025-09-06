package com.airbnb.lottie.compose;

import N0.L;
import N0.N;
import N0.O;
import N0.Z;
import N0.a0;
import N0.q;
import P0.z;
import ie.H;
import je.x;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import r0.p;
import r1.a;
import r1.b;
import we.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u0010\u001A\u00020\r*\u00020\b2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000BH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000E\u0010\u000FR\"\u0010\u0004\u001A\u00020\u00038\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0004\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0005\u001A\u00020\u00038\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0005\u0010\u0011\u001A\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015\u0082\u0002\u0007\n\u0005\b¡\u001E0\u0001¨\u0006\u0018"}, d2 = {"Lcom/airbnb/lottie/compose/LottieAnimationSizeNode;", "Lr0/p;", "LP0/z;", "", "width", "height", "<init>", "(II)V", "LN0/O;", "LN0/L;", "measurable", "Lr1/a;", "constraints", "LN0/N;", "measure-3p2s80s", "(LN0/O;LN0/L;J)LN0/N;", "measure", "I", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class LottieAnimationSizeNode extends p implements z {
    public static final int $stable = 8;
    private int height;
    private int width;

    public LottieAnimationSizeNode(int v, int v1) {
        this.width = v;
        this.height = v1;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    @Override  // P0.z
    public int maxIntrinsicHeight(@NotNull q q0, @NotNull N0.p p0, int v) {
        return z.super.maxIntrinsicHeight(q0, p0, v);
    }

    @Override  // P0.z
    public int maxIntrinsicWidth(@NotNull q q0, @NotNull N0.p p0, int v) {
        return z.super.maxIntrinsicWidth(q0, p0, v);
    }

    @Override  // P0.z
    @NotNull
    public N measure-3p2s80s(@NotNull O o0, @NotNull L l0, long v) {
        long v4;
        kotlin.jvm.internal.q.g(o0, "$this$measure");
        kotlin.jvm.internal.q.g(l0, "measurable");
        long v1 = b.d(v, ((long)this.height) & 0xFFFFFFFFL | ((long)this.width) << 0x20);
        if(a.g(v) == 0x7FFFFFFF && a.h(v) != 0x7FFFFFFF) {
            int v2 = (int)(v1 >> 0x20);
            int v3 = this.height * v2 / this.width;
            v4 = b.a(v2, v2, v3, v3);
        }
        else if(a.h(v) != 0x7FFFFFFF || a.g(v) == 0x7FFFFFFF) {
            int v7 = (int)(v1 >> 0x20);
            int v8 = (int)(v1 & 0xFFFFFFFFL);
            v4 = b.a(v7, v7, v8, v8);
        }
        else {
            int v5 = (int)(v1 & 0xFFFFFFFFL);
            int v6 = this.width * v5 / this.height;
            v4 = b.a(v6, v6, v5, v5);
        }
        a0 a00 = l0.O(v4);
        int v9 = a00.a;
        int v10 = a00.b;
        com.airbnb.lottie.compose.LottieAnimationSizeNode.measure.1 lottieAnimationSizeNode$measure$10 = new k() {
            final a0 $placeable;

            {
                this.$placeable = a00;
                super(1);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Z)object0));
                return H.a;
            }

            public final void invoke(@NotNull Z z0) {
                kotlin.jvm.internal.q.g(z0, "$this$layout");
                Z.g(z0, this.$placeable, 0, 0);
            }
        };
        return o0.w(v9, v10, x.a, lottieAnimationSizeNode$measure$10);
    }

    @Override  // P0.z
    public int minIntrinsicHeight(@NotNull q q0, @NotNull N0.p p0, int v) {
        return z.super.minIntrinsicHeight(q0, p0, v);
    }

    @Override  // P0.z
    public int minIntrinsicWidth(@NotNull q q0, @NotNull N0.p p0, int v) {
        return z.super.minIntrinsicWidth(q0, p0, v);
    }

    @Override  // P0.m
    public void onDensityChange() {
    }

    @Override  // P0.m
    public void onLayoutDirectionChange() {
    }

    public final void setHeight(int v) {
        this.height = v;
    }

    public final void setWidth(int v) {
        this.width = v;
    }
}

