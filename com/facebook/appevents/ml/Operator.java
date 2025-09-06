package com.facebook.appevents.ml;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\f\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\b\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000B\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\r\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001D\u0010\u0015\u001A\u00020\u00042\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0017\u0010\u000EJ\'\u0010\u0018\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001D\u001A\u00020\u00042\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001A0\u00132\u0006\u0010\u001C\u001A\u00020\u000F2\u0006\u0010\n\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010\u001F\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u001F\u0010 J\u0017\u0010!\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b!\u0010 J\u001F\u0010\"\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\"\u0010\fJ\u001F\u0010$\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010#\u001A\u00020\u000FH\u0007¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/facebook/appevents/ml/Operator;", "", "<init>", "()V", "Lcom/facebook/appevents/ml/MTensor;", "x", "b", "Lie/H;", "addmv", "(Lcom/facebook/appevents/ml/MTensor;Lcom/facebook/appevents/ml/MTensor;)V", "w", "mul", "(Lcom/facebook/appevents/ml/MTensor;Lcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "relu", "(Lcom/facebook/appevents/ml/MTensor;)V", "", "startDim", "flatten", "(Lcom/facebook/appevents/ml/MTensor;I)V", "", "tensors", "concatenate", "([Lcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "softmax", "dense", "(Lcom/facebook/appevents/ml/MTensor;Lcom/facebook/appevents/ml/MTensor;Lcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "", "texts", "seqLength", "embedding", "([Ljava/lang/String;ILcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "transpose2D", "(Lcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "transpose3D", "conv1D", "poolSize", "maxPool1D", "(Lcom/facebook/appevents/ml/MTensor;I)Lcom/facebook/appevents/ml/MTensor;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Operator {
    @NotNull
    public static final Operator INSTANCE;

    static {
        Operator.INSTANCE = new Operator();
    }

    public static final void addmv(@NotNull MTensor mTensor0, @NotNull MTensor mTensor1) {
        Class class0 = Operator.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(mTensor0, "x");
                q.g(mTensor1, "b");
                int v = mTensor0.getShape(0);
                int v1 = mTensor0.getShape(1);
                int v2 = mTensor0.getShape(2);
                float[] arr_f = mTensor0.getData();
                float[] arr_f1 = mTensor1.getData();
                for(int v3 = 0; v3 < v; ++v3) {
                    for(int v4 = 0; v4 < v1; ++v4) {
                        for(int v5 = 0; v5 < v2; ++v5) {
                            int v6 = v4 * v2 + v3 * v1 * v2 + v5;
                            arr_f[v6] += arr_f1[v5];
                        }
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    @NotNull
    public static final MTensor concatenate(@NotNull MTensor[] arr_mTensor) {
        Class class0 = Operator.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(arr_mTensor, "tensors");
            int v = arr_mTensor[0].getShape(0);
            int v2 = 0;
            for(int v1 = 0; v1 < arr_mTensor.length; ++v1) {
                v2 += arr_mTensor[v1].getShape(1);
            }
            MTensor mTensor0 = new MTensor(new int[]{v, v2});
            float[] arr_f = mTensor0.getData();
            for(int v3 = 0; v3 < v; ++v3) {
                int v4 = v3 * v2;
                for(int v5 = 0; v5 < arr_mTensor.length; ++v5) {
                    float[] arr_f1 = arr_mTensor[v5].getData();
                    int v6 = arr_mTensor[v5].getShape(1);
                    System.arraycopy(arr_f1, v3 * v6, arr_f, v4, v6);
                    v4 += v6;
                }
            }
            return mTensor0;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    @NotNull
    public static final MTensor conv1D(@NotNull MTensor mTensor0, @NotNull MTensor mTensor1) {
        MTensor mTensor4;
        int v7;
        float[] arr_f2;
        float[] arr_f1;
        float[] arr_f;
        MTensor mTensor3;
        int v6;
        int v5;
        int v3;
        int v2;
        int v;
        Class class0 = Operator.class;
        MTensor mTensor2 = null;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(mTensor0, "x");
            q.g(mTensor1, "w");
            v = 0;
            int v1 = mTensor0.getShape(0);
            v2 = mTensor0.getShape(1);
            v3 = mTensor0.getShape(2);
            int v4 = mTensor1.getShape(0);
            v5 = v2 - v4 + 1;
            v6 = mTensor1.getShape(2);
            mTensor3 = new MTensor(new int[]{v1, v5, v6});
            arr_f = mTensor0.getData();
            arr_f1 = mTensor3.getData();
            arr_f2 = mTensor1.getData();
            v7 = 0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
        while(v7 < v1) {
            int v8 = 0;
            while(v8 < v6) {
                int v9 = 0;
            label_26:
                while(v9 < v5) {
                    float f = 0.0f;
                    while(true) {
                        if(v >= v4) {
                            goto label_38;
                        }
                        mTensor4 = mTensor2;
                        try {
                            for(int v10 = 0; v10 < v3; ++v10) {
                                f = arr_f[(v + v9) * v3 + v2 * v3 * v7 + v10] * arr_f2[(v * v3 + v10) * v6 + v8] + f;
                            }
                            ++v;
                            mTensor2 = mTensor4;
                            continue;
                        label_38:
                            mTensor4 = mTensor2;
                            arr_f1[v9 * v6 + v5 * v6 * v7 + v8] = f;
                            ++v9;
                            mTensor2 = mTensor4;
                            v = 0;
                            continue label_26;
                        }
                        catch(Throwable throwable0) {
                        }
                        break;
                    }
                    CrashShieldHandler.handleThrowable(throwable0, class0);
                    return mTensor4;
                }
                ++v8;
                v = 0;
            }
            ++v7;
            v = 0;
        }
        return mTensor3;
    }

    @NotNull
    public static final MTensor dense(@NotNull MTensor mTensor0, @NotNull MTensor mTensor1, @NotNull MTensor mTensor2) {
        Class class0 = Operator.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(mTensor0, "x");
            q.g(mTensor1, "w");
            q.g(mTensor2, "b");
            int v = mTensor0.getShape(0);
            int v1 = mTensor2.getShape(0);
            MTensor mTensor3 = Operator.mul(mTensor0, mTensor1);
            float[] arr_f = mTensor2.getData();
            float[] arr_f1 = mTensor3.getData();
            for(int v2 = 0; v2 < v; ++v2) {
                for(int v3 = 0; v3 < v1; ++v3) {
                    int v4 = v2 * v1 + v3;
                    arr_f1[v4] += arr_f[v3];
                }
            }
            return mTensor3;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @NotNull
    public static final MTensor embedding(@NotNull String[] arr_s, int v, @NotNull MTensor mTensor0) {
        Class class0 = Operator.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(arr_s, "texts");
            q.g(mTensor0, "w");
            int v1 = mTensor0.getShape(1);
            MTensor mTensor1 = new MTensor(new int[]{arr_s.length, v, v1});
            float[] arr_f = mTensor1.getData();
            float[] arr_f1 = mTensor0.getData();
            for(int v2 = 0; v2 < arr_s.length; ++v2) {
                int[] arr_v = Utils.INSTANCE.vectorize(arr_s[v2], v);
                for(int v3 = 0; v3 < v; ++v3) {
                    System.arraycopy(arr_f1, arr_v[v3] * v1, arr_f, v1 * v3 + v1 * v * v2, v1);
                }
            }
            return mTensor1;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    public static final void flatten(@NotNull MTensor mTensor0, int v) {
        Class class0 = Operator.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(mTensor0, "x");
                if(v < mTensor0.getShapeSize()) {
                    int v1 = mTensor0.getShapeSize();
                    int v2 = 1;
                    for(int v3 = v; v3 < v1; ++v3) {
                        v2 *= mTensor0.getShape(v3);
                    }
                    int[] arr_v = new int[v + 1];
                    for(int v4 = 0; v4 < v; ++v4) {
                        arr_v[v4] = mTensor0.getShape(v4);
                    }
                    arr_v[v] = v2;
                    mTensor0.reshape(arr_v);
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    @NotNull
    public static final MTensor maxPool1D(@NotNull MTensor mTensor0, int v) {
        Class class0 = Operator.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(mTensor0, "x");
            int v1 = mTensor0.getShape(0);
            int v2 = mTensor0.getShape(1);
            int v3 = mTensor0.getShape(2);
            int v4 = v2 - v + 1;
            MTensor mTensor1 = new MTensor(new int[]{v1, v4, v3});
            float[] arr_f = mTensor0.getData();
            float[] arr_f1 = mTensor1.getData();
            for(int v5 = 0; v5 < v1; ++v5) {
                for(int v6 = 0; v6 < v3; ++v6) {
                    for(int v7 = 0; v7 < v4; ++v7) {
                        int v8 = v7 * v3;
                        int v9 = v5 * v4 * v3 + v8 + v6;
                        int v10 = v5 * v2 * v3 + v8 + v6;
                        arr_f1[v9] = 1.401298E-45f;
                        for(int v11 = 0; v11 < v; ++v11) {
                            arr_f1[v9] = Math.max(arr_f1[v9], arr_f[v11 * v3 + v10]);
                        }
                    }
                }
            }
            return mTensor1;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @NotNull
    public static final MTensor mul(@NotNull MTensor mTensor0, @NotNull MTensor mTensor1) {
        Class class0 = Operator.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(mTensor0, "x");
            q.g(mTensor1, "w");
            int v = mTensor0.getShape(0);
            int v1 = mTensor1.getShape(0);
            int v2 = mTensor1.getShape(1);
            MTensor mTensor2 = new MTensor(new int[]{v, v2});
            float[] arr_f = mTensor0.getData();
            float[] arr_f1 = mTensor1.getData();
            float[] arr_f2 = mTensor2.getData();
            for(int v3 = 0; v3 < v; ++v3) {
                for(int v4 = 0; v4 < v2; ++v4) {
                    int v5 = v3 * v2 + v4;
                    arr_f2[v5] = 0.0f;
                    for(int v6 = 0; v6 < v1; ++v6) {
                        arr_f2[v5] = arr_f[v3 * v1 + v6] * arr_f1[v6 * v2 + v4] + arr_f2[v5];
                    }
                }
            }
            return mTensor2;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    public static final void relu(@NotNull MTensor mTensor0) {
        Class class0 = Operator.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(mTensor0, "x");
                float[] arr_f = mTensor0.getData();
                for(int v = 0; v < arr_f.length; ++v) {
                    if(arr_f[v] < 0.0f) {
                        arr_f[v] = 0.0f;
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public static final void softmax(@NotNull MTensor mTensor0) {
        Class class0 = Operator.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(mTensor0, "x");
                int v1 = mTensor0.getShape(0);
                int v2 = mTensor0.getShape(1);
                float[] arr_f = mTensor0.getData();
                for(int v = 0; v < v1; ++v) {
                    int v3 = v * v2;
                    int v4 = v3 + v2;
                    float f = 1.401298E-45f;
                    for(int v5 = v3; v5 < v4; ++v5) {
                        float f1 = arr_f[v5];
                        if(f1 > f) {
                            f = f1;
                        }
                    }
                    float f2 = 0.0f;
                    for(int v6 = v3; v6 < v4; ++v6) {
                        float f3 = (float)Math.exp(arr_f[v6] - f);
                        arr_f[v6] = f3;
                        f2 += f3;
                    }
                    while(v3 < v4) {
                        arr_f[v3] /= f2;
                        ++v3;
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    @NotNull
    public static final MTensor transpose2D(@NotNull MTensor mTensor0) {
        Class class0 = Operator.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(mTensor0, "x");
            int v = mTensor0.getShape(0);
            int v1 = mTensor0.getShape(1);
            MTensor mTensor1 = new MTensor(new int[]{v1, v});
            float[] arr_f = mTensor0.getData();
            float[] arr_f1 = mTensor1.getData();
            for(int v2 = 0; v2 < v; ++v2) {
                for(int v3 = 0; v3 < v1; ++v3) {
                    arr_f1[v3 * v + v2] = arr_f[v2 * v1 + v3];
                }
            }
            return mTensor1;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @NotNull
    public static final MTensor transpose3D(@NotNull MTensor mTensor0) {
        Class class0 = Operator.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(mTensor0, "x");
            int v = mTensor0.getShape(0);
            int v1 = mTensor0.getShape(1);
            int v2 = mTensor0.getShape(2);
            MTensor mTensor1 = new MTensor(new int[]{v2, v1, v});
            float[] arr_f = mTensor0.getData();
            float[] arr_f1 = mTensor1.getData();
            for(int v3 = 0; v3 < v; ++v3) {
                for(int v4 = 0; v4 < v1; ++v4) {
                    for(int v5 = 0; v5 < v2; ++v5) {
                        arr_f1[v4 * v + v5 * v * v1 + v3] = arr_f[v4 * v2 + v3 * v1 * v2 + v5];
                    }
                }
            }
            return mTensor1;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }
}

