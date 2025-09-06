package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos.MessageOptions extends GeneratedMessageLite.ExtendableMessage {
    private static final DescriptorProtos.MessageOptions DEFAULT_INSTANCE = null;
    public static final int DEPRECATED_FIELD_NUMBER = 3;
    public static final int DEPRECATED_LEGACY_JSON_FIELD_CONFLICTS_FIELD_NUMBER = 11;
    public static final int FEATURES_FIELD_NUMBER = 12;
    public static final int MAP_ENTRY_FIELD_NUMBER = 7;
    public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
    public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
    private static volatile z2 PARSER = null;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private int bitField0_;
    private boolean deprecatedLegacyJsonFieldConflicts_;
    private boolean deprecated_;
    private DescriptorProtos.FeatureSet features_;
    private boolean mapEntry_;
    private byte memoizedIsInitialized;
    private boolean messageSetWireFormat_;
    private boolean noStandardDescriptorAccessor_;
    private O1 uninterpretedOption_;

    static {
        DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0 = new DescriptorProtos.MessageOptions();
        DescriptorProtos.MessageOptions.DEFAULT_INSTANCE = descriptorProtos$MessageOptions0;
        A1.registerDefaultInstance(DescriptorProtos.MessageOptions.class, descriptorProtos$MessageOptions0);
    }

    private DescriptorProtos.MessageOptions() {
        this.memoizedIsInitialized = 2;
        this.uninterpretedOption_ = A1.emptyProtobufList();
    }

    public static void access$34700(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0, boolean z) {
        descriptorProtos$MessageOptions0.setMessageSetWireFormat(z);
    }

    public static void access$34800(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0) {
        descriptorProtos$MessageOptions0.clearMessageSetWireFormat();
    }

    public static void access$34900(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0, boolean z) {
        descriptorProtos$MessageOptions0.setNoStandardDescriptorAccessor(z);
    }

    public static void access$35000(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0) {
        descriptorProtos$MessageOptions0.clearNoStandardDescriptorAccessor();
    }

    public static void access$35100(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0, boolean z) {
        descriptorProtos$MessageOptions0.setDeprecated(z);
    }

    public static void access$35200(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0) {
        descriptorProtos$MessageOptions0.clearDeprecated();
    }

    public static void access$35300(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0, boolean z) {
        descriptorProtos$MessageOptions0.setMapEntry(z);
    }

    public static void access$35400(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0) {
        descriptorProtos$MessageOptions0.clearMapEntry();
    }

    public static void access$35500(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0, boolean z) {
        descriptorProtos$MessageOptions0.setDeprecatedLegacyJsonFieldConflicts(z);
    }

    public static void access$35600(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0) {
        descriptorProtos$MessageOptions0.clearDeprecatedLegacyJsonFieldConflicts();
    }

    public static void access$35700(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$MessageOptions0.setFeatures(descriptorProtos$FeatureSet0);
    }

    public static void access$35800(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$MessageOptions0.mergeFeatures(descriptorProtos$FeatureSet0);
    }

    public static void access$35900(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0) {
        descriptorProtos$MessageOptions0.clearFeatures();
    }

    public static void access$36000(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0, int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$MessageOptions0.setUninterpretedOption(v, descriptorProtos$UninterpretedOption0);
    }

    public static void access$36100(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$MessageOptions0.addUninterpretedOption(descriptorProtos$UninterpretedOption0);
    }

    public static void access$36200(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0, int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$MessageOptions0.addUninterpretedOption(v, descriptorProtos$UninterpretedOption0);
    }

    public static void access$36300(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0, Iterable iterable0) {
        descriptorProtos$MessageOptions0.addAllUninterpretedOption(iterable0);
    }

    public static void access$36400(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0) {
        descriptorProtos$MessageOptions0.clearUninterpretedOption();
    }

    public static void access$36500(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0, int v) {
        descriptorProtos$MessageOptions0.removeUninterpretedOption(v);
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
        this.bitField0_ &= -5;
        this.deprecated_ = false;
    }

    private void clearDeprecatedLegacyJsonFieldConflicts() {
        this.bitField0_ &= -17;
        this.deprecatedLegacyJsonFieldConflicts_ = false;
    }

    private void clearFeatures() {
        this.features_ = null;
        this.bitField0_ &= -33;
    }

    private void clearMapEntry() {
        this.bitField0_ &= -9;
        this.mapEntry_ = false;
    }

    private void clearMessageSetWireFormat() {
        this.bitField0_ &= -2;
        this.messageSetWireFormat_ = false;
    }

    private void clearNoStandardDescriptorAccessor() {
        this.bitField0_ &= -3;
        this.noStandardDescriptorAccessor_ = false;
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
                return A1.newMessageInfo(DescriptorProtos.MessageOptions.DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001ϧ\u0007\u0000\u0001\u0002\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0007ဇ\u0003\u000Bဇ\u0004\fᐉ\u0005ϧЛ", new Object[]{"bitField0_", "messageSetWireFormat_", "noStandardDescriptorAccessor_", "deprecated_", "mapEntry_", "deprecatedLegacyJsonFieldConflicts_", "features_", "uninterpretedOption_", DescriptorProtos.UninterpretedOption.class});
            }
            case 3: {
                return new DescriptorProtos.MessageOptions();
            }
            case 4: {
                return new D0(DescriptorProtos.MessageOptions.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.MessageOptions.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.MessageOptions.PARSER;
                if(z20 == null) {
                    synchronized(DescriptorProtos.MessageOptions.class) {
                        z21 = DescriptorProtos.MessageOptions.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.MessageOptions.PARSER = z21;
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

    public static DescriptorProtos.MessageOptions getDefaultInstance() {
        return DescriptorProtos.MessageOptions.DEFAULT_INSTANCE;
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

    public boolean getMapEntry() {
        return this.mapEntry_;
    }

    public boolean getMessageSetWireFormat() {
        return this.messageSetWireFormat_;
    }

    public boolean getNoStandardDescriptorAccessor() {
        return this.noStandardDescriptorAccessor_;
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
        return (this.bitField0_ & 4) != 0;
    }

    @Deprecated
    public boolean hasDeprecatedLegacyJsonFieldConflicts() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasFeatures() {
        return (this.bitField0_ & 0x20) != 0;
    }

    public boolean hasMapEntry() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasMessageSetWireFormat() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasNoStandardDescriptorAccessor() {
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
        this.bitField0_ |= 0x20;
    }

    public static D0 newBuilder() {
        return (D0)DescriptorProtos.MessageOptions.DEFAULT_INSTANCE.createBuilder();
    }

    public static D0 newBuilder(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0) {
        return (D0)DescriptorProtos.MessageOptions.DEFAULT_INSTANCE.createBuilder(descriptorProtos$MessageOptions0);
    }

    public static DescriptorProtos.MessageOptions parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.MessageOptions)A1.parseDelimitedFrom(DescriptorProtos.MessageOptions.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.MessageOptions parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.MessageOptions)A1.parseDelimitedFrom(DescriptorProtos.MessageOptions.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.MessageOptions parseFrom(o o0) {
        return (DescriptorProtos.MessageOptions)A1.parseFrom(DescriptorProtos.MessageOptions.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.MessageOptions parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.MessageOptions)A1.parseFrom(DescriptorProtos.MessageOptions.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.MessageOptions parseFrom(t t0) {
        return (DescriptorProtos.MessageOptions)A1.parseFrom(DescriptorProtos.MessageOptions.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.MessageOptions parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.MessageOptions)A1.parseFrom(DescriptorProtos.MessageOptions.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.MessageOptions parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.MessageOptions)A1.parseFrom(DescriptorProtos.MessageOptions.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.MessageOptions parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.MessageOptions)A1.parseFrom(DescriptorProtos.MessageOptions.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.MessageOptions parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.MessageOptions)A1.parseFrom(DescriptorProtos.MessageOptions.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.MessageOptions parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.MessageOptions)A1.parseFrom(DescriptorProtos.MessageOptions.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.MessageOptions parseFrom(byte[] arr_b) {
        return (DescriptorProtos.MessageOptions)A1.parseFrom(DescriptorProtos.MessageOptions.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.MessageOptions parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.MessageOptions)A1.parseFrom(DescriptorProtos.MessageOptions.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.MessageOptions.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUninterpretedOption(int v) {
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.remove(v);
    }

    private void setDeprecated(boolean z) {
        this.bitField0_ |= 4;
        this.deprecated_ = z;
    }

    private void setDeprecatedLegacyJsonFieldConflicts(boolean z) {
        this.bitField0_ |= 16;
        this.deprecatedLegacyJsonFieldConflicts_ = z;
    }

    private void setFeatures(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FeatureSet0.getClass();
        this.features_ = descriptorProtos$FeatureSet0;
        this.bitField0_ |= 0x20;
    }

    private void setMapEntry(boolean z) {
        this.bitField0_ |= 8;
        this.mapEntry_ = z;
    }

    private void setMessageSetWireFormat(boolean z) {
        this.bitField0_ |= 1;
        this.messageSetWireFormat_ = z;
    }

    private void setNoStandardDescriptorAccessor(boolean z) {
        this.bitField0_ |= 2;
        this.noStandardDescriptorAccessor_ = z;
    }

    private void setUninterpretedOption(int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.getClass();
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.set(v, descriptorProtos$UninterpretedOption0);
    }
}

