package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos.OneofOptions extends GeneratedMessageLite.ExtendableMessage {
    private static final DescriptorProtos.OneofOptions DEFAULT_INSTANCE = null;
    public static final int FEATURES_FIELD_NUMBER = 1;
    private static volatile z2 PARSER = null;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private int bitField0_;
    private DescriptorProtos.FeatureSet features_;
    private byte memoizedIsInitialized;
    private O1 uninterpretedOption_;

    static {
        DescriptorProtos.OneofOptions descriptorProtos$OneofOptions0 = new DescriptorProtos.OneofOptions();
        DescriptorProtos.OneofOptions.DEFAULT_INSTANCE = descriptorProtos$OneofOptions0;
        A1.registerDefaultInstance(DescriptorProtos.OneofOptions.class, descriptorProtos$OneofOptions0);
    }

    private DescriptorProtos.OneofOptions() {
        this.memoizedIsInitialized = 2;
        this.uninterpretedOption_ = A1.emptyProtobufList();
    }

    public static void access$42800(DescriptorProtos.OneofOptions descriptorProtos$OneofOptions0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$OneofOptions0.setFeatures(descriptorProtos$FeatureSet0);
    }

    public static void access$42900(DescriptorProtos.OneofOptions descriptorProtos$OneofOptions0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$OneofOptions0.mergeFeatures(descriptorProtos$FeatureSet0);
    }

    public static void access$43000(DescriptorProtos.OneofOptions descriptorProtos$OneofOptions0) {
        descriptorProtos$OneofOptions0.clearFeatures();
    }

    public static void access$43100(DescriptorProtos.OneofOptions descriptorProtos$OneofOptions0, int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$OneofOptions0.setUninterpretedOption(v, descriptorProtos$UninterpretedOption0);
    }

    public static void access$43200(DescriptorProtos.OneofOptions descriptorProtos$OneofOptions0, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$OneofOptions0.addUninterpretedOption(descriptorProtos$UninterpretedOption0);
    }

    public static void access$43300(DescriptorProtos.OneofOptions descriptorProtos$OneofOptions0, int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$OneofOptions0.addUninterpretedOption(v, descriptorProtos$UninterpretedOption0);
    }

    public static void access$43400(DescriptorProtos.OneofOptions descriptorProtos$OneofOptions0, Iterable iterable0) {
        descriptorProtos$OneofOptions0.addAllUninterpretedOption(iterable0);
    }

    public static void access$43500(DescriptorProtos.OneofOptions descriptorProtos$OneofOptions0) {
        descriptorProtos$OneofOptions0.clearUninterpretedOption();
    }

    public static void access$43600(DescriptorProtos.OneofOptions descriptorProtos$OneofOptions0, int v) {
        descriptorProtos$OneofOptions0.removeUninterpretedOption(v);
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

    private void clearFeatures() {
        this.features_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUninterpretedOption() {
        this.uninterpretedOption_ = A1.emptyProtobufList();
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return this.memoizedIsInitialized;
            }
            case 1: {
                this.memoizedIsInitialized = (byte)(object0 == null ? 0 : 1);
                return null;
            }
            case 2: {
                return A1.newMessageInfo(DescriptorProtos.OneofOptions.DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001ϧ\u0002\u0000\u0001\u0002\u0001ᐉ\u0000ϧЛ", new Object[]{"bitField0_", "features_", "uninterpretedOption_", DescriptorProtos.UninterpretedOption.class});
            }
            case 3: {
                return new DescriptorProtos.OneofOptions();
            }
            case 4: {
                return new K0(DescriptorProtos.OneofOptions.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.OneofOptions.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.OneofOptions.PARSER;
                if(z20 == null) {
                    Class class0 = DescriptorProtos.OneofOptions.class;
                    synchronized(class0) {
                        z2 z21 = DescriptorProtos.OneofOptions.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.OneofOptions.PARSER = z21;
                        }
                        return z21;
                    }
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

    public static DescriptorProtos.OneofOptions getDefaultInstance() {
        return DescriptorProtos.OneofOptions.DEFAULT_INSTANCE;
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

    public boolean hasFeatures() {
        return (this.bitField0_ & 1) != 0;
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
        this.bitField0_ |= 1;
    }

    public static K0 newBuilder() {
        return (K0)DescriptorProtos.OneofOptions.DEFAULT_INSTANCE.createBuilder();
    }

    public static K0 newBuilder(DescriptorProtos.OneofOptions descriptorProtos$OneofOptions0) {
        return (K0)DescriptorProtos.OneofOptions.DEFAULT_INSTANCE.createBuilder(descriptorProtos$OneofOptions0);
    }

    public static DescriptorProtos.OneofOptions parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.OneofOptions)A1.parseDelimitedFrom(DescriptorProtos.OneofOptions.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.OneofOptions parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.OneofOptions)A1.parseDelimitedFrom(DescriptorProtos.OneofOptions.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.OneofOptions parseFrom(o o0) {
        return (DescriptorProtos.OneofOptions)A1.parseFrom(DescriptorProtos.OneofOptions.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.OneofOptions parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.OneofOptions)A1.parseFrom(DescriptorProtos.OneofOptions.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.OneofOptions parseFrom(t t0) {
        return (DescriptorProtos.OneofOptions)A1.parseFrom(DescriptorProtos.OneofOptions.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.OneofOptions parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.OneofOptions)A1.parseFrom(DescriptorProtos.OneofOptions.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.OneofOptions parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.OneofOptions)A1.parseFrom(DescriptorProtos.OneofOptions.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.OneofOptions parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.OneofOptions)A1.parseFrom(DescriptorProtos.OneofOptions.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.OneofOptions parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.OneofOptions)A1.parseFrom(DescriptorProtos.OneofOptions.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.OneofOptions parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.OneofOptions)A1.parseFrom(DescriptorProtos.OneofOptions.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.OneofOptions parseFrom(byte[] arr_b) {
        return (DescriptorProtos.OneofOptions)A1.parseFrom(DescriptorProtos.OneofOptions.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.OneofOptions parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.OneofOptions)A1.parseFrom(DescriptorProtos.OneofOptions.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.OneofOptions.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUninterpretedOption(int v) {
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.remove(v);
    }

    private void setFeatures(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FeatureSet0.getClass();
        this.features_ = descriptorProtos$FeatureSet0;
        this.bitField0_ |= 1;
    }

    private void setUninterpretedOption(int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.getClass();
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.set(v, descriptorProtos$UninterpretedOption0);
    }
}

