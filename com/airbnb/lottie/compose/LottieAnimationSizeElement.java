package com.airbnb.lottie.compose;

import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.p;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\b\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000F\u001A\u00020\u000B*\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0010\u0010\u0019\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017J$\u0010\u001A\u001A\u00020\u00002\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u001D\u001A\u00020\u001CHÖ\u0001¢\u0006\u0004\b\u001D\u0010\u001ER\u0017\u0010\u0004\u001A\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001F\u001A\u0004\b \u0010\u0017R\u0017\u0010\u0005\u001A\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001F\u001A\u0004\b!\u0010\u0017¨\u0006\""}, d2 = {"Lcom/airbnb/lottie/compose/LottieAnimationSizeElement;", "LP0/a0;", "Lcom/airbnb/lottie/compose/LottieAnimationSizeNode;", "", "width", "height", "<init>", "(II)V", "create", "()Lcom/airbnb/lottie/compose/LottieAnimationSizeNode;", "node", "Lie/H;", "update", "(Lcom/airbnb/lottie/compose/LottieAnimationSizeNode;)V", "LQ0/x0;", "inspectableProperties", "(LQ0/x0;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "component1", "component2", "copy", "(II)Lcom/airbnb/lottie/compose/LottieAnimationSizeElement;", "", "toString", "()Ljava/lang/String;", "I", "getWidth", "getHeight", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class LottieAnimationSizeElement extends a0 {
    public static final int $stable;
    private final int height;
    private final int width;

    public LottieAnimationSizeElement(int v, int v1) {
        this.width = v;
        this.height = v1;
    }

    @Override  // r0.o
    public boolean all(@NotNull k k0) {
        return super.all(k0);
    }

    @Override  // r0.o
    public boolean any(@NotNull k k0) {
        return super.any(k0);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    @NotNull
    public final LottieAnimationSizeElement copy(int v, int v1) {
        return new LottieAnimationSizeElement(v, v1);
    }

    public static LottieAnimationSizeElement copy$default(LottieAnimationSizeElement lottieAnimationSizeElement0, int v, int v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = lottieAnimationSizeElement0.width;
        }
        if((v2 & 2) != 0) {
            v1 = lottieAnimationSizeElement0.height;
        }
        return lottieAnimationSizeElement0.copy(v, v1);
    }

    @NotNull
    public LottieAnimationSizeNode create() {
        return new LottieAnimationSizeNode(this.width, this.height);
    }

    @Override  // P0.a0
    public p create() {
        return this.create();
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof LottieAnimationSizeElement)) {
            return false;
        }
        return this.width == ((LottieAnimationSizeElement)object0).width ? this.height == ((LottieAnimationSizeElement)object0).height : false;
    }

    @Override  // r0.o
    public Object foldIn(Object object0, @NotNull n n0) {
        return n0.invoke(object0, this);
    }

    public Object foldOut(Object object0, @NotNull n n0) {
        return n0.invoke(this, object0);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    @Override
    public int hashCode() {
        return this.height + this.width * 0x1F;
    }

    @Override  // P0.a0
    public void inspectableProperties(@NotNull x0 x00) {
        q.g(x00, "<this>");
        x00.a = "Lottie Size";
        x00.c.b(this.width, "width");
        x00.c.b(this.height, "height");
    }

    @Override  // r0.q
    @NotNull
    public r0.q then(@NotNull r0.q q0) {
        return super.then(q0);
    }

    @Override
    @NotNull
    public String toString() {
        return "LottieAnimationSizeElement(width=" + this.width + ", height=" + this.height + ")";
    }

    public void update(@NotNull LottieAnimationSizeNode lottieAnimationSizeNode0) {
        q.g(lottieAnimationSizeNode0, "node");
        lottieAnimationSizeNode0.setWidth(this.width);
        lottieAnimationSizeNode0.setHeight(this.height);
    }

    @Override  // P0.a0
    public void update(p p0) {
        this.update(((LottieAnimationSizeNode)p0));
    }
}

