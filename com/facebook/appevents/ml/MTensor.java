package com.facebook.appevents.ml;

import Ce.f;
import Ce.g;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\n\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u000B\u0010\u0005R\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0016\u0010\r\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\r\u0010\u000ER$\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F8\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001A\u00020\u00068F¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/facebook/appevents/ml/MTensor;", "", "", "shape", "<init>", "([I)V", "", "i", "getShape", "(I)I", "Lie/H;", "reshape", "[I", "capacity", "I", "", "<set-?>", "data", "[F", "getData", "()[F", "getShapeSize", "()I", "shapeSize", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class MTensor {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/ml/MTensor$Companion;", "", "()V", "getCapacity", "", "shape", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final int access$getCapacity(Companion mTensor$Companion0, int[] arr_v) {
            return mTensor$Companion0.getCapacity(arr_v);
        }

        private final int getCapacity(int[] arr_v) {
            if(arr_v.length == 0) {
                throw new UnsupportedOperationException("Empty array can\'t be reduced.");
            }
            int v = arr_v[0];
            f f0 = new g(1, arr_v.length - 1, 1).b();  // 初始化器: LCe/e;-><init>(III)V
            while(f0.c) {
                v *= arr_v[f0.nextInt()];
            }
            return v;
        }
    }

    @NotNull
    public static final Companion Companion;
    private int capacity;
    @NotNull
    private float[] data;
    @NotNull
    private int[] shape;

    static {
        MTensor.Companion = new Companion(null);
    }

    public MTensor(@NotNull int[] arr_v) {
        q.g(arr_v, "shape");
        super();
        this.shape = arr_v;
        int v = Companion.access$getCapacity(MTensor.Companion, arr_v);
        this.capacity = v;
        this.data = new float[v];
    }

    @NotNull
    public final float[] getData() {
        return this.data;
    }

    public final int getShape(int v) {
        return this.shape[v];
    }

    public final int getShapeSize() {
        return this.shape.length;
    }

    public final void reshape(@NotNull int[] arr_v) {
        q.g(arr_v, "shape");
        this.shape = arr_v;
        int v = Companion.access$getCapacity(MTensor.Companion, arr_v);
        float[] arr_f = new float[v];
        System.arraycopy(this.data, 0, arr_f, 0, Math.min(this.capacity, v));
        this.data = arr_f;
        this.capacity = v;
    }
}

