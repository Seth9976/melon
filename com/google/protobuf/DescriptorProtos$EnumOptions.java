package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos.EnumOptions extends GeneratedMessageLite.ExtendableMessage {
    public static final int ALLOW_ALIAS_FIELD_NUMBER = 2;
    private static final DescriptorProtos.EnumOptions DEFAULT_INSTANCE = null;
    public static final int DEPRECATED_FIELD_NUMBER = 3;
    public static final int DEPRECATED_LEGACY_JSON_FIELD_CONFLICTS_FIELD_NUMBER = 6;
    public static final int FEATURES_FIELD_NUMBER = 7;
    private static volatile z2 PARSER = null;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private boolean allowAlias_;
    private int bitField0_;
    private boolean deprecatedLegacyJsonFieldConflicts_;
    private boolean deprecated_;
    private DescriptorProtos.FeatureSet features_;
    private byte memoizedIsInitialized;
    private O1 uninterpretedOption_;

    static {
        DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0 = new DescriptorProtos.EnumOptions();
        DescriptorProtos.EnumOptions.DEFAULT_INSTANCE = descriptorProtos$EnumOptions0;
        A1.registerDefaultInstance(DescriptorProtos.EnumOptions.class, descriptorProtos$EnumOptions0);
    }

    private DescriptorProtos.EnumOptions() {
        this.memoizedIsInitialized = 2;
        this.uninterpretedOption_ = A1.emptyProtobufList();
    }

    public static void access$43900(DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0, boolean z) {
        descriptorProtos$EnumOptions0.setAllowAlias(z);
    }

    public static void access$44000(DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0) {
        descriptorProtos$EnumOptions0.clearAllowAlias();
    }

    public static void access$44100(DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0, boolean z) {
        descriptorProtos$EnumOptions0.setDeprecated(z);
    }

    public static void access$44200(DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0) {
        descriptorProtos$EnumOptions0.clearDeprecated();
    }

    public static void access$44300(DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0, boolean z) {
        descriptorProtos$EnumOptions0.setDeprecatedLegacyJsonFieldConflicts(z);
    }

    public static void access$44400(DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0) {
        descriptorProtos$EnumOptions0.clearDeprecatedLegacyJsonFieldConflicts();
    }

    public static void access$44500(DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$EnumOptions0.setFeatures(descriptorProtos$FeatureSet0);
    }

    public static void access$44600(DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$EnumOptions0.mergeFeatures(descriptorProtos$FeatureSet0);
    }

    public static void access$44700(DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0) {
        descriptorProtos$EnumOptions0.clearFeatures();
    }

    public static void access$44800(DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0, int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$EnumOptions0.setUninterpretedOption(v, descriptorProtos$UninterpretedOption0);
    }

    public static void access$44900(DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$EnumOptions0.addUninterpretedOption(descriptorProtos$UninterpretedOption0);
    }

    public static void access$45000(DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0, int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$EnumOptions0.addUninterpretedOption(v, descriptorProtos$UninterpretedOption0);
    }

    public static void access$45100(DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0, Iterable iterable0) {
        descriptorProtos$EnumOptions0.addAllUninterpretedOption(iterable0);
    }

    public static void access$45200(DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0) {
        descriptorProtos$EnumOptions0.clearUninterpretedOption();
    }

    public static void access$45300(DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0, int v) {
        descriptorProtos$EnumOptions0.removeUninterpretedOption(v);
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

    private void clearAllowAlias() {
        this.bitField0_ &= -2;
        this.allowAlias_ = false;
    }

    private void clearDeprecated() {
        this.bitField0_ &= -3;
        this.deprecated_ = false;
    }

    private void clearDeprecatedLegacyJsonFieldConflicts() {
        this.bitField0_ &= -5;
        this.deprecatedLegacyJsonFieldConflicts_ = false;
    }

    private void clearFeatures() {
        this.features_ = null;
        this.bitField0_ &= -9;
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
                return A1.newMessageInfo(DescriptorProtos.EnumOptions.DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0002ϧ\u0005\u0000\u0001\u0002\u0002ဇ\u0000\u0003ဇ\u0001\u0006ဇ\u0002\u0007ᐉ\u0003ϧЛ", new Object[]{"bitField0_", "allowAlias_", "deprecated_", "deprecatedLegacyJsonFieldConflicts_", "features_", "uninterpretedOption_", DescriptorProtos.UninterpretedOption.class});
            }
            case 3: {
                return new DescriptorProtos.EnumOptions();
            }
            case 4: {
                return new K(DescriptorProtos.EnumOptions.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.EnumOptions.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.EnumOptions.PARSER;
                if(z20 == null) {
                    synchronized(DescriptorProtos.EnumOptions.class) {
                        z21 = DescriptorProtos.EnumOptions.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.EnumOptions.PARSER = z21;
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

    public boolean getAllowAlias() {
        return this.allowAlias_;
    }

    public static DescriptorProtos.EnumOptions getDefaultInstance() {
        return DescriptorProtos.EnumOptions.DEFAULT_INSTANCE;
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    @Deprecated
    public boolean getDeprecatedLegacyJsonFieldConflicts() {
        return this.deprecatedLegacyJsonFieldConflicts_;
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

    public boolean hasAllowAlias() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasDeprecated() {
        return (this.bitField0_ & 2) != 0;
    }

    @Deprecated
    public boolean hasDeprecatedLegacyJsonFieldConflicts() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasFeatures() {
        return (this.bitField0_ & 8) != 0;
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
        this.bitField0_ |= 8;
    }

    public static K newBuilder() {
        return (K)DescriptorProtos.EnumOptions.DEFAULT_INSTANCE.createBuilder();
    }

    public static K newBuilder(DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0) {
        return (K)DescriptorProtos.EnumOptions.DEFAULT_INSTANCE.createBuilder(descriptorProtos$EnumOptions0);
    }

    public static DescriptorProtos.EnumOptions parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.EnumOptions)A1.parseDelimitedFrom(DescriptorProtos.EnumOptions.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.EnumOptions parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.EnumOptions)A1.parseDelimitedFrom(DescriptorProtos.EnumOptions.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.EnumOptions parseFrom(o o0) {
        return (DescriptorProtos.EnumOptions)A1.parseFrom(DescriptorProtos.EnumOptions.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.EnumOptions parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.EnumOptions)A1.parseFrom(DescriptorProtos.EnumOptions.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.EnumOptions parseFrom(t t0) {
        return (DescriptorProtos.EnumOptions)A1.parseFrom(DescriptorProtos.EnumOptions.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.EnumOptions parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.EnumOptions)A1.parseFrom(DescriptorProtos.EnumOptions.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.EnumOptions parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.EnumOptions)A1.parseFrom(DescriptorProtos.EnumOptions.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.EnumOptions parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.EnumOptions)A1.parseFrom(DescriptorProtos.EnumOptions.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.EnumOptions parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.EnumOptions)A1.parseFrom(DescriptorProtos.EnumOptions.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.EnumOptions parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.EnumOptions)A1.parseFrom(DescriptorProtos.EnumOptions.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.EnumOptions parseFrom(byte[] arr_b) {
        return (DescriptorProtos.EnumOptions)A1.parseFrom(DescriptorProtos.EnumOptions.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.EnumOptions parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.EnumOptions)A1.parseFrom(DescriptorProtos.EnumOptions.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.EnumOptions.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUninterpretedOption(int v) {
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.remove(v);
    }

    private void setAllowAlias(boolean z) {
        this.bitField0_ |= 1;
        this.allowAlias_ = z;
    }

    private void setDeprecated(boolean z) {
        this.bitField0_ |= 2;
        this.deprecated_ = z;
    }

    private void setDeprecatedLegacyJsonFieldConflicts(boolean z) {
        this.bitField0_ |= 4;
        this.deprecatedLegacyJsonFieldConflicts_ = z;
    }

    private void setFeatures(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FeatureSet0.getClass();
        this.features_ = descriptorProtos$FeatureSet0;
        this.bitField0_ |= 8;
    }

    private void setUninterpretedOption(int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.getClass();
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.set(v, descriptorProtos$UninterpretedOption0);
    }
}

