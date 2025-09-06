package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos.MethodOptions extends GeneratedMessageLite.ExtendableMessage {
    private static final DescriptorProtos.MethodOptions DEFAULT_INSTANCE = null;
    public static final int DEPRECATED_FIELD_NUMBER = 33;
    public static final int FEATURES_FIELD_NUMBER = 35;
    public static final int IDEMPOTENCY_LEVEL_FIELD_NUMBER = 34;
    private static volatile z2 PARSER = null;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private int bitField0_;
    private boolean deprecated_;
    private DescriptorProtos.FeatureSet features_;
    private int idempotencyLevel_;
    private byte memoizedIsInitialized;
    private O1 uninterpretedOption_;

    static {
        DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0 = new DescriptorProtos.MethodOptions();
        DescriptorProtos.MethodOptions.DEFAULT_INSTANCE = descriptorProtos$MethodOptions0;
        A1.registerDefaultInstance(DescriptorProtos.MethodOptions.class, descriptorProtos$MethodOptions0);
    }

    private DescriptorProtos.MethodOptions() {
        this.memoizedIsInitialized = 2;
        this.uninterpretedOption_ = A1.emptyProtobufList();
    }

    public static void access$48700(DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0, boolean z) {
        descriptorProtos$MethodOptions0.setDeprecated(z);
    }

    public static void access$48800(DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0) {
        descriptorProtos$MethodOptions0.clearDeprecated();
    }

    public static void access$48900(DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0, H0 h00) {
        descriptorProtos$MethodOptions0.setIdempotencyLevel(h00);
    }

    public static void access$49000(DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0) {
        descriptorProtos$MethodOptions0.clearIdempotencyLevel();
    }

    public static void access$49100(DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$MethodOptions0.setFeatures(descriptorProtos$FeatureSet0);
    }

    public static void access$49200(DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$MethodOptions0.mergeFeatures(descriptorProtos$FeatureSet0);
    }

    public static void access$49300(DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0) {
        descriptorProtos$MethodOptions0.clearFeatures();
    }

    public static void access$49400(DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0, int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$MethodOptions0.setUninterpretedOption(v, descriptorProtos$UninterpretedOption0);
    }

    public static void access$49500(DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$MethodOptions0.addUninterpretedOption(descriptorProtos$UninterpretedOption0);
    }

    public static void access$49600(DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0, int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$MethodOptions0.addUninterpretedOption(v, descriptorProtos$UninterpretedOption0);
    }

    public static void access$49700(DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0, Iterable iterable0) {
        descriptorProtos$MethodOptions0.addAllUninterpretedOption(iterable0);
    }

    public static void access$49800(DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0) {
        descriptorProtos$MethodOptions0.clearUninterpretedOption();
    }

    public static void access$49900(DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0, int v) {
        descriptorProtos$MethodOptions0.removeUninterpretedOption(v);
    }

    private void addAllUninterpretedOption(Iterable iterable0) {
        this.ensureUninterpretedOptionIsMutable();
        b.addAll(iterable0, this.uninterpretedOption_);
    }

    private void addUninterpretedOption(int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.getClass();
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(v, descriptorProtos$UninterpretedOption0);
    }

    private void addUninterpretedOption(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.getClass();
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(descriptorProtos$UninterpretedOption0);
    }

    private void clearDeprecated() {
        this.bitField0_ &= -2;
        this.deprecated_ = false;
    }

    private void clearFeatures() {
        this.features_ = null;
        this.bitField0_ &= -5;
    }

    private void clearIdempotencyLevel() {
        this.bitField0_ &= -3;
        this.idempotencyLevel_ = 0;
    }

    private void clearUninterpretedOption() {
        this.uninterpretedOption_ = A1.emptyProtobufList();
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        z2 z21;
        switch(z10.ordinal()) {
            case 0: {
                return this.memoizedIsInitialized;
            }
            case 1: {
                this.memoizedIsInitialized = (byte)(object0 == null ? 0 : 1);
                return null;
            }
            case 2: {
                return A1.newMessageInfo(DescriptorProtos.MethodOptions.DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001!ϧ\u0004\u0000\u0001\u0002!ဇ\u0000\"᠌\u0001#ᐉ\u0002ϧЛ", new Object[]{"bitField0_", "deprecated_", "idempotencyLevel_", E.r, "features_", "uninterpretedOption_", DescriptorProtos.UninterpretedOption.class});
            }
            case 3: {
                return new DescriptorProtos.MethodOptions();
            }
            case 4: {
                return new G0(DescriptorProtos.MethodOptions.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.MethodOptions.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.MethodOptions.PARSER;
                if(z20 == null) {
                    synchronized(DescriptorProtos.MethodOptions.class) {
                        z21 = DescriptorProtos.MethodOptions.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.MethodOptions.PARSER = z21;
                        }
                    }
                    return z21;
                }
                return z20;
            }
            default: {
                throw null;
            }
        }
    }

    private void ensureUninterpretedOptionIsMutable() {
        O1 o10 = this.uninterpretedOption_;
        if(!((c)o10).a) {
            this.uninterpretedOption_ = A1.mutableCopy(o10);
        }
    }

    public static DescriptorProtos.MethodOptions getDefaultInstance() {
        return DescriptorProtos.MethodOptions.DEFAULT_INSTANCE;
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public DescriptorProtos.FeatureSet getFeatures() {
        return this.features_ == null ? DescriptorProtos.FeatureSet.getDefaultInstance() : this.features_;
    }

    public H0 getIdempotencyLevel() {
        H0 h00 = H0.b(this.idempotencyLevel_);
        return h00 == null ? H0.b : h00;
    }

    public DescriptorProtos.UninterpretedOption getUninterpretedOption(int v) {
        return (DescriptorProtos.UninterpretedOption)this.uninterpretedOption_.get(v);
    }

    public int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }

    public List getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }

    public V0 getUninterpretedOptionOrBuilder(int v) {
        return (V0)this.uninterpretedOption_.get(v);
    }

    public List getUninterpretedOptionOrBuilderList() {
        return this.uninterpretedOption_;
    }

    public boolean hasDeprecated() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasFeatures() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasIdempotencyLevel() {
        return (this.bitField0_ & 2) != 0;
    }

    private void mergeFeatures(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FeatureSet0.getClass();
        if(this.features_ == null || this.features_ == DescriptorProtos.FeatureSet.getDefaultInstance()) {
            this.features_ = descriptorProtos$FeatureSet0;
        }
        else {
            T t0 = DescriptorProtos.FeatureSet.newBuilder(this.features_);
            t0.f(descriptorProtos$FeatureSet0);
            this.features_ = (DescriptorProtos.FeatureSet)t0.i();
        }
        this.bitField0_ |= 4;
    }

    public static G0 newBuilder() {
        return (G0)DescriptorProtos.MethodOptions.DEFAULT_INSTANCE.createBuilder();
    }

    public static G0 newBuilder(DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0) {
        return (G0)DescriptorProtos.MethodOptions.DEFAULT_INSTANCE.createBuilder(descriptorProtos$MethodOptions0);
    }

    public static DescriptorProtos.MethodOptions parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.MethodOptions)A1.parseDelimitedFrom(DescriptorProtos.MethodOptions.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.MethodOptions parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.MethodOptions)A1.parseDelimitedFrom(DescriptorProtos.MethodOptions.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.MethodOptions parseFrom(o o0) {
        return (DescriptorProtos.MethodOptions)A1.parseFrom(DescriptorProtos.MethodOptions.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.MethodOptions parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.MethodOptions)A1.parseFrom(DescriptorProtos.MethodOptions.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.MethodOptions parseFrom(t t0) {
        return (DescriptorProtos.MethodOptions)A1.parseFrom(DescriptorProtos.MethodOptions.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.MethodOptions parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.MethodOptions)A1.parseFrom(DescriptorProtos.MethodOptions.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.MethodOptions parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.MethodOptions)A1.parseFrom(DescriptorProtos.MethodOptions.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.MethodOptions parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.MethodOptions)A1.parseFrom(DescriptorProtos.MethodOptions.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.MethodOptions parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.MethodOptions)A1.parseFrom(DescriptorProtos.MethodOptions.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.MethodOptions parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.MethodOptions)A1.parseFrom(DescriptorProtos.MethodOptions.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.MethodOptions parseFrom(byte[] arr_b) {
        return (DescriptorProtos.MethodOptions)A1.parseFrom(DescriptorProtos.MethodOptions.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.MethodOptions parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.MethodOptions)A1.parseFrom(DescriptorProtos.MethodOptions.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.MethodOptions.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUninterpretedOption(int v) {
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.remove(v);
    }

    private void setDeprecated(boolean z) {
        this.bitField0_ |= 1;
        this.deprecated_ = z;
    }

    private void setFeatures(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FeatureSet0.getClass();
        this.features_ = descriptorProtos$FeatureSet0;
        this.bitField0_ |= 4;
    }

    private void setIdempotencyLevel(H0 h00) {
        this.idempotencyLevel_ = h00.a;
        this.bitField0_ |= 2;
    }

    private void setUninterpretedOption(int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.getClass();
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.set(v, descriptorProtos$UninterpretedOption0);
    }
}

