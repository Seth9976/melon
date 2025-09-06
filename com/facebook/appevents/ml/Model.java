package com.facebook.appevents.ml;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import ie.m;
import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import je.C;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AB\u001B\b\u0002\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J+\u0010\u0014\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001A\u00020\u00052\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u0018\u001A\u00020\u0004¢\u0006\u0002\u0010\u0019R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2 = {"Lcom/facebook/appevents/ml/Model;", "", "weights", "", "", "Lcom/facebook/appevents/ml/MTensor;", "(Ljava/util/Map;)V", "convs0Bias", "convs0Weight", "convs1Bias", "convs1Weight", "convs2Bias", "convs2Weight", "embedding", "fc1Bias", "fc1Weight", "fc2Bias", "fc2Weight", "finalWeights", "", "predictOnMTML", "dense", "texts", "", "task", "(Lcom/facebook/appevents/ml/MTensor;[Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/appevents/ml/MTensor;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Model {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\n\u001A\u00020\u000BJ\u001E\u0010\f\u001A\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0018\u00010\u00062\u0006\u0010\n\u001A\u00020\u000BH\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/facebook/appevents/ml/Model$Companion;", "", "()V", "SEQ_LEN", "", "mapping", "", "", "build", "Lcom/facebook/appevents/ml/Model;", "file", "Ljava/io/File;", "parse", "Lcom/facebook/appevents/ml/MTensor;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final Model build(@NotNull File file0) {
            q.g(file0, "file");
            Map map0 = this.parse(file0);
            if(map0 == null) {
                return null;
            }
            try {
                return new Model(map0, null);
            }
            catch(Exception unused_ex) {
                return null;
            }
        }

        private final Map parse(File file0) {
            Map map0 = Utils.parseModelWeights(file0);
            if(map0 != null) {
                Map map1 = new HashMap();
                Map map2 = Model.access$getMapping$cp();
                for(Object object0: map0.entrySet()) {
                    Map.Entry map$Entry0 = (Map.Entry)object0;
                    String s = (String)map$Entry0.getKey();
                    if(map2.containsKey(map$Entry0.getKey())) {
                        s = (String)map2.get(map$Entry0.getKey());
                        if(s == null) {
                            return null;
                        }
                    }
                    map1.put(s, map$Entry0.getValue());
                }
                return map1;
            }
            return null;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private static final int SEQ_LEN = 0x80;
    @NotNull
    private final MTensor convs0Bias;
    @NotNull
    private final MTensor convs0Weight;
    @NotNull
    private final MTensor convs1Bias;
    @NotNull
    private final MTensor convs1Weight;
    @NotNull
    private final MTensor convs2Bias;
    @NotNull
    private final MTensor convs2Weight;
    @NotNull
    private final MTensor embedding;
    @NotNull
    private final MTensor fc1Bias;
    @NotNull
    private final MTensor fc1Weight;
    @NotNull
    private final MTensor fc2Bias;
    @NotNull
    private final MTensor fc2Weight;
    @NotNull
    private final Map finalWeights;
    @NotNull
    private static final Map mapping;

    static {
        Model.Companion = new Companion(null);
        Model.mapping = C.R(new m[]{new m("embedding.weight", "embed.weight"), new m("dense1.weight", "fc1.weight"), new m("dense2.weight", "fc2.weight"), new m("dense3.weight", "fc3.weight"), new m("dense1.bias", "fc1.bias"), new m("dense2.bias", "fc2.bias"), new m("dense3.bias", "fc3.bias")});
    }

    private Model(Map map0) {
        Object object0 = map0.get("embed.weight");
        if(object0 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.embedding = (MTensor)object0;
        Object object1 = map0.get("convs.0.weight");
        if(object1 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.convs0Weight = Operator.transpose3D(((MTensor)object1));
        Object object2 = map0.get("convs.1.weight");
        if(object2 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.convs1Weight = Operator.transpose3D(((MTensor)object2));
        Object object3 = map0.get("convs.2.weight");
        if(object3 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.convs2Weight = Operator.transpose3D(((MTensor)object3));
        Object object4 = map0.get("convs.0.bias");
        if(object4 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.convs0Bias = (MTensor)object4;
        Object object5 = map0.get("convs.1.bias");
        if(object5 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.convs1Bias = (MTensor)object5;
        Object object6 = map0.get("convs.2.bias");
        if(object6 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.convs2Bias = (MTensor)object6;
        Object object7 = map0.get("fc1.weight");
        if(object7 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.fc1Weight = Operator.transpose2D(((MTensor)object7));
        Object object8 = map0.get("fc2.weight");
        if(object8 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.fc2Weight = Operator.transpose2D(((MTensor)object8));
        Object object9 = map0.get("fc1.bias");
        if(object9 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.fc1Bias = (MTensor)object9;
        Object object10 = map0.get("fc2.bias");
        if(object10 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.fc2Bias = (MTensor)object10;
        this.finalWeights = new HashMap();
        for(Object object11: n.A0(new String[]{"integrity_detect", "app_event_pred"})) {
            String s = e.h(((String)object11), ".weight");
            String s1 = e.h(((String)object11), ".bias");
            MTensor mTensor0 = (MTensor)map0.get(s);
            MTensor mTensor1 = (MTensor)map0.get(s1);
            if(mTensor0 != null) {
                MTensor mTensor2 = Operator.transpose2D(mTensor0);
                this.finalWeights.put(s, mTensor2);
            }
            if(mTensor1 != null) {
                this.finalWeights.put(s1, mTensor1);
            }
        }
    }

    public Model(Map map0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(map0);
    }

    // 去混淆评级： 低(20)
    public static final Map access$getMapping$cp() {
        return CrashShieldHandler.isObjectCrashing(Model.class) ? null : Model.mapping;
    }

    @Nullable
    public final MTensor predictOnMTML(@NotNull MTensor mTensor0, @NotNull String[] arr_s, @NotNull String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            q.g(mTensor0, "dense");
            q.g(arr_s, "texts");
            q.g(s, "task");
            MTensor mTensor1 = Operator.conv1D(Operator.embedding(arr_s, 0x80, this.embedding), this.convs0Weight);
            Operator.addmv(mTensor1, this.convs0Bias);
            Operator.relu(mTensor1);
            MTensor mTensor2 = Operator.conv1D(mTensor1, this.convs1Weight);
            Operator.addmv(mTensor2, this.convs1Bias);
            Operator.relu(mTensor2);
            MTensor mTensor3 = Operator.maxPool1D(mTensor2, 2);
            MTensor mTensor4 = Operator.conv1D(mTensor3, this.convs2Weight);
            Operator.addmv(mTensor4, this.convs2Bias);
            Operator.relu(mTensor4);
            MTensor mTensor5 = Operator.maxPool1D(mTensor1, mTensor1.getShape(1));
            MTensor mTensor6 = Operator.maxPool1D(mTensor3, mTensor3.getShape(1));
            MTensor mTensor7 = Operator.maxPool1D(mTensor4, mTensor4.getShape(1));
            Operator.flatten(mTensor5, 1);
            Operator.flatten(mTensor6, 1);
            Operator.flatten(mTensor7, 1);
            MTensor mTensor8 = Operator.dense(Operator.concatenate(new MTensor[]{mTensor5, mTensor6, mTensor7, mTensor0}), this.fc1Weight, this.fc1Bias);
            Operator.relu(mTensor8);
            MTensor mTensor9 = Operator.dense(mTensor8, this.fc2Weight, this.fc2Bias);
            Operator.relu(mTensor9);
            MTensor mTensor10 = (MTensor)this.finalWeights.get(s + ".weight");
            MTensor mTensor11 = (MTensor)this.finalWeights.get(s + ".bias");
            if(mTensor10 != null && mTensor11 != null) {
                MTensor mTensor12 = Operator.dense(mTensor9, mTensor10, mTensor11);
                Operator.softmax(mTensor12);
                return mTensor12;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
        return null;
    }
}

