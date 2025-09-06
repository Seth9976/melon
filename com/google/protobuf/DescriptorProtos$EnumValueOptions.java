package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos.EnumValueOptions extends GeneratedMessageLite.ExtendableMessage {
    public static final int DEBUG_REDACT_FIELD_NUMBER = 3;
    private static final DescriptorProtos.EnumValueOptions DEFAULT_INSTANCE = null;
    public static final int DEPRECATED_FIELD_NUMBER = 1;
    public static final int FEATURES_FIELD_NUMBER = 2;
    public static final int FEATURE_SUPPORT_FIELD_NUMBER = 4;
    private static volatile z2 PARSER = null;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private int bitField0_;
    private boolean debugRedact_;
    private boolean deprecated_;
    private FeatureSupport featureSupport_;
    private DescriptorProtos.FeatureSet features_;
    private byte memoizedIsInitialized;
    private O1 uninterpretedOption_;

    static {
        DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0 = new DescriptorProtos.EnumValueOptions();
        DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE = descriptorProtos$EnumValueOptions0;
        A1.registerDefaultInstance(DescriptorProtos.EnumValueOptions.class, descriptorProtos$EnumValueOptions0);
    }

    private DescriptorProtos.EnumValueOptions() {
        this.memoizedIsInitialized = 2;
        this.uninterpretedOption_ = A1.emptyProtobufList();
    }

    public static void access$45600(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0, boolean z) {
        descriptorProtos$EnumValueOptions0.setDeprecated(z);
    }

    public static void access$45700(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0) {
        descriptorProtos$EnumValueOptions0.clearDeprecated();
    }

    public static void access$45800(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$EnumValueOptions0.setFeatures(descriptorProtos$FeatureSet0);
    }

    public static void access$45900(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$EnumValueOptions0.mergeFeatures(descriptorProtos$FeatureSet0);
    }

    public static void access$46000(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0) {
        descriptorProtos$EnumValueOptions0.clearFeatures();
    }

    public static void access$46100(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0, boolean z) {
        descriptorProtos$EnumValueOptions0.setDebugRedact(z);
    }

    public static void access$46200(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0) {
        descriptorProtos$EnumValueOptions0.clearDebugRedact();
    }

    public static void access$46300(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0, FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0) {
        descriptorProtos$EnumValueOptions0.setFeatureSupport(descriptorProtos$FieldOptions$FeatureSupport0);
    }

    public static void access$46400(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0, FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0) {
        descriptorProtos$EnumValueOptions0.mergeFeatureSupport(descriptorProtos$FieldOptions$FeatureSupport0);
    }

    public static void access$46500(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0) {
        descriptorProtos$EnumValueOptions0.clearFeatureSupport();
    }

    public static void access$46600(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0, int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$EnumValueOptions0.setUninterpretedOption(v, descriptorProtos$UninterpretedOption0);
    }

    public static void access$46700(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$EnumValueOptions0.addUninterpretedOption(descriptorProtos$UninterpretedOption0);
    }

    public static void access$46800(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0, int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$EnumValueOptions0.addUninterpretedOption(v, descriptorProtos$UninterpretedOption0);
    }

    public static void access$46900(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0, Iterable iterable0) {
        descriptorProtos$EnumValueOptions0.addAllUninterpretedOption(iterable0);
    }

    public static void access$47000(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0) {
        descriptorProtos$EnumValueOptions0.clearUninterpretedOption();
    }

    public static void access$47100(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0, int v) {
        descriptorProtos$EnumValueOptions0.removeUninterpretedOption(v);
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

    private void clearDebugRedact() {
        this.bitField0_ &= -5;
        this.debugRedact_ = false;
    }

    private void clearDeprecated() {
        this.bitField0_ &= -2;
        this.deprecated_ = false;
    }

    private void clearFeatureSupport() {
        this.featureSupport_ = null;
        this.bitField0_ &= -9;
    }

    private void clearFeatures() {
        this.features_ = null;
        this.bitField0_ &= -3;
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
                return A1.newMessageInfo(DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001ϧ\u0005\u0000\u0001\u0002\u0001ဇ\u0000\u0002ᐉ\u0001\u0003ဇ\u0002\u0004ဉ\u0003ϧЛ", new Object[]{"bitField0_", "deprecated_", "features_", "debugRedact_", "featureSupport_", "uninterpretedOption_", DescriptorProtos.UninterpretedOption.class});
            }
            case 3: {
                return new DescriptorProtos.EnumValueOptions();
            }
            case 4: {
                return new N(DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.EnumValueOptions.PARSER;
                if(z20 == null) {
                    synchronized(DescriptorProtos.EnumValueOptions.class) {
                        z21 = DescriptorProtos.EnumValueOptions.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.EnumValueOptions.PARSER = z21;
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

    public boolean getDebugRedact() {
        return this.debugRedact_;
    }

    public static DescriptorProtos.EnumValueOptions getDefaultInstance() {
        return DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE;
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public FeatureSupport getFeatureSupport() {
        return this.featureSupport_ == null ? FeatureSupport.getDefaultInstance() : this.featureSupport_;
    }

    public DescriptorProtos.FeatureSet getFeatures() {
        return this.features_ == null ? DescriptorProtos.FeatureSet.getDefaultInstance() : this.features_;
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

    public boolean hasDebugRedact() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasDeprecated() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasFeatureSupport() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasFeatures() {
        return (this.bitField0_ & 2) != 0;
    }

    private void mergeFeatureSupport(FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0) {
        descriptorProtos$FieldOptions$FeatureSupport0.getClass();
        if(this.featureSupport_ == null || this.featureSupport_ == FeatureSupport.getDefaultInstance()) {
            this.featureSupport_ = descriptorProtos$FieldOptions$FeatureSupport0;
        }
        else {
            p0 p00 = FeatureSupport.newBuilder(this.featureSupport_);
            p00.f(descriptorProtos$FieldOptions$FeatureSupport0);
            this.featureSupport_ = (FeatureSupport)p00.b();
        }
        this.bitField0_ |= 8;
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
        this.bitField0_ |= 2;
    }

    public static N newBuilder() {
        return (N)DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE.createBuilder();
    }

    public static N newBuilder(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0) {
        return (N)DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE.createBuilder(descriptorProtos$EnumValueOptions0);
    }

    public static DescriptorProtos.EnumValueOptions parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.EnumValueOptions)A1.parseDelimitedFrom(DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.EnumValueOptions parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.EnumValueOptions)A1.parseDelimitedFrom(DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.EnumValueOptions parseFrom(o o0) {
        return (DescriptorProtos.EnumValueOptions)A1.parseFrom(DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.EnumValueOptions parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.EnumValueOptions)A1.parseFrom(DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.EnumValueOptions parseFrom(t t0) {
        return (DescriptorProtos.EnumValueOptions)A1.parseFrom(DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.EnumValueOptions parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.EnumValueOptions)A1.parseFrom(DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.EnumValueOptions parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.EnumValueOptions)A1.parseFrom(DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.EnumValueOptions parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.EnumValueOptions)A1.parseFrom(DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.EnumValueOptions parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.EnumValueOptions)A1.parseFrom(DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.EnumValueOptions parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.EnumValueOptions)A1.parseFrom(DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.EnumValueOptions parseFrom(byte[] arr_b) {
        return (DescriptorProtos.EnumValueOptions)A1.parseFrom(DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.EnumValueOptions parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.EnumValueOptions)A1.parseFrom(DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.EnumValueOptions.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUninterpretedOption(int v) {
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.remove(v);
    }

    private void setDebugRedact(boolean z) {
        this.bitField0_ |= 4;
        this.debugRedact_ = z;
    }

    private void setDeprecated(boolean z) {
        this.bitField0_ |= 1;
        this.deprecated_ = z;
    }

    private void setFeatureSupport(FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0) {
        descriptorProtos$FieldOptions$FeatureSupport0.getClass();
        this.featureSupport_ = descriptorProtos$FieldOptions$FeatureSupport0;
        this.bitField0_ |= 8;
    }

    private void setFeatures(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FeatureSet0.getClass();
        this.features_ = descriptorProtos$FeatureSet0;
        this.bitField0_ |= 2;
    }

    private void setUninterpretedOption(int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.getClass();
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.set(v, descriptorProtos$UninterpretedOption0);
    }
}

