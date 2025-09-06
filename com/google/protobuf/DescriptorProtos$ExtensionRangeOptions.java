package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos.ExtensionRangeOptions extends GeneratedMessageLite.ExtendableMessage {
    public static final class Declaration extends A1 implements Q {
        private static final Declaration DEFAULT_INSTANCE = null;
        public static final int FULL_NAME_FIELD_NUMBER = 2;
        public static final int NUMBER_FIELD_NUMBER = 1;
        private static volatile z2 PARSER = null;
        public static final int REPEATED_FIELD_NUMBER = 6;
        public static final int RESERVED_FIELD_NUMBER = 5;
        public static final int TYPE_FIELD_NUMBER = 3;
        private int bitField0_;
        private String fullName_;
        private int number_;
        private boolean repeated_;
        private boolean reserved_;
        private String type_;

        static {
            Declaration descriptorProtos$ExtensionRangeOptions$Declaration0 = new Declaration();
            Declaration.DEFAULT_INSTANCE = descriptorProtos$ExtensionRangeOptions$Declaration0;
            A1.registerDefaultInstance(Declaration.class, descriptorProtos$ExtensionRangeOptions$Declaration0);
        }

        private Declaration() {
            this.fullName_ = "";
            this.type_ = "";
        }

        public static void access$14200(Declaration descriptorProtos$ExtensionRangeOptions$Declaration0, int v) {
            descriptorProtos$ExtensionRangeOptions$Declaration0.setNumber(v);
        }

        public static void access$14300(Declaration descriptorProtos$ExtensionRangeOptions$Declaration0) {
            descriptorProtos$ExtensionRangeOptions$Declaration0.clearNumber();
        }

        public static void access$14400(Declaration descriptorProtos$ExtensionRangeOptions$Declaration0, String s) {
            descriptorProtos$ExtensionRangeOptions$Declaration0.setFullName(s);
        }

        public static void access$14500(Declaration descriptorProtos$ExtensionRangeOptions$Declaration0) {
            descriptorProtos$ExtensionRangeOptions$Declaration0.clearFullName();
        }

        public static void access$14600(Declaration descriptorProtos$ExtensionRangeOptions$Declaration0, o o0) {
            descriptorProtos$ExtensionRangeOptions$Declaration0.setFullNameBytes(o0);
        }

        public static void access$14700(Declaration descriptorProtos$ExtensionRangeOptions$Declaration0, String s) {
            descriptorProtos$ExtensionRangeOptions$Declaration0.setType(s);
        }

        public static void access$14800(Declaration descriptorProtos$ExtensionRangeOptions$Declaration0) {
            descriptorProtos$ExtensionRangeOptions$Declaration0.clearType();
        }

        public static void access$14900(Declaration descriptorProtos$ExtensionRangeOptions$Declaration0, o o0) {
            descriptorProtos$ExtensionRangeOptions$Declaration0.setTypeBytes(o0);
        }

        public static void access$15000(Declaration descriptorProtos$ExtensionRangeOptions$Declaration0, boolean z) {
            descriptorProtos$ExtensionRangeOptions$Declaration0.setReserved(z);
        }

        public static void access$15100(Declaration descriptorProtos$ExtensionRangeOptions$Declaration0) {
            descriptorProtos$ExtensionRangeOptions$Declaration0.clearReserved();
        }

        public static void access$15200(Declaration descriptorProtos$ExtensionRangeOptions$Declaration0, boolean z) {
            descriptorProtos$ExtensionRangeOptions$Declaration0.setRepeated(z);
        }

        public static void access$15300(Declaration descriptorProtos$ExtensionRangeOptions$Declaration0) {
            descriptorProtos$ExtensionRangeOptions$Declaration0.clearRepeated();
        }

        private void clearFullName() {
            this.bitField0_ &= -3;
            this.fullName_ = "";
        }

        private void clearNumber() {
            this.bitField0_ &= -2;
            this.number_ = 0;
        }

        private void clearRepeated() {
            this.bitField0_ &= -17;
            this.repeated_ = false;
        }

        private void clearReserved() {
            this.bitField0_ &= -9;
            this.reserved_ = false;
        }

        private void clearType() {
            this.bitField0_ &= -5;
            this.type_ = "";
        }

        @Override  // com.google.protobuf.A1
        public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
            z2 z21;
            switch(z10.ordinal()) {
                case 0: {
                    return (byte)1;
                }
                case 2: {
                    return A1.newMessageInfo(Declaration.DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0005ဇ\u0003\u0006ဇ\u0004", new Object[]{"bitField0_", "number_", "fullName_", "type_", "reserved_", "repeated_"});
                }
                case 3: {
                    return new Declaration();
                }
                case 4: {
                    return new P(Declaration.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
                }
                case 5: {
                    return Declaration.DEFAULT_INSTANCE;
                }
                case 6: {
                    z2 z20 = Declaration.PARSER;
                    if(z20 == null) {
                        synchronized(Declaration.class) {
                            z21 = Declaration.PARSER;
                            if(z21 == null) {
                                z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                                Declaration.PARSER = z21;
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

        public static Declaration getDefaultInstance() {
            return Declaration.DEFAULT_INSTANCE;
        }

        public String getFullName() [...] // 潜在的解密器

        public o getFullNameBytes() {
            return o.e(this.fullName_);
        }

        public int getNumber() {
            return this.number_;
        }

        public boolean getRepeated() {
            return this.repeated_;
        }

        public boolean getReserved() {
            return this.reserved_;
        }

        public String getType() [...] // 潜在的解密器

        public o getTypeBytes() {
            return o.e(this.type_);
        }

        public boolean hasFullName() {
            return (this.bitField0_ & 2) != 0;
        }

        public boolean hasNumber() {
            return (this.bitField0_ & 1) != 0;
        }

        public boolean hasRepeated() {
            return (this.bitField0_ & 16) != 0;
        }

        public boolean hasReserved() {
            return (this.bitField0_ & 8) != 0;
        }

        public boolean hasType() {
            return (this.bitField0_ & 4) != 0;
        }

        public static P newBuilder() {
            return (P)Declaration.DEFAULT_INSTANCE.createBuilder();
        }

        public static P newBuilder(Declaration descriptorProtos$ExtensionRangeOptions$Declaration0) {
            return (P)Declaration.DEFAULT_INSTANCE.createBuilder(descriptorProtos$ExtensionRangeOptions$Declaration0);
        }

        public static Declaration parseDelimitedFrom(InputStream inputStream0) {
            return (Declaration)A1.parseDelimitedFrom(Declaration.DEFAULT_INSTANCE, inputStream0);
        }

        public static Declaration parseDelimitedFrom(InputStream inputStream0, g1 g10) {
            return (Declaration)A1.parseDelimitedFrom(Declaration.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static Declaration parseFrom(o o0) {
            return (Declaration)A1.parseFrom(Declaration.DEFAULT_INSTANCE, o0);
        }

        public static Declaration parseFrom(o o0, g1 g10) {
            return (Declaration)A1.parseFrom(Declaration.DEFAULT_INSTANCE, o0, g10);
        }

        public static Declaration parseFrom(t t0) {
            return (Declaration)A1.parseFrom(Declaration.DEFAULT_INSTANCE, t0);
        }

        public static Declaration parseFrom(t t0, g1 g10) {
            return (Declaration)A1.parseFrom(Declaration.DEFAULT_INSTANCE, t0, g10);
        }

        public static Declaration parseFrom(InputStream inputStream0) {
            return (Declaration)A1.parseFrom(Declaration.DEFAULT_INSTANCE, inputStream0);
        }

        public static Declaration parseFrom(InputStream inputStream0, g1 g10) {
            return (Declaration)A1.parseFrom(Declaration.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static Declaration parseFrom(ByteBuffer byteBuffer0) {
            return (Declaration)A1.parseFrom(Declaration.DEFAULT_INSTANCE, byteBuffer0);
        }

        public static Declaration parseFrom(ByteBuffer byteBuffer0, g1 g10) {
            return (Declaration)A1.parseFrom(Declaration.DEFAULT_INSTANCE, byteBuffer0, g10);
        }

        public static Declaration parseFrom(byte[] arr_b) {
            return (Declaration)A1.parseFrom(Declaration.DEFAULT_INSTANCE, arr_b);
        }

        public static Declaration parseFrom(byte[] arr_b, g1 g10) {
            return (Declaration)A1.parseFrom(Declaration.DEFAULT_INSTANCE, arr_b, g10);
        }

        public static z2 parser() {
            return Declaration.DEFAULT_INSTANCE.getParserForType();
        }

        private void setFullName(String s) {
            s.getClass();
            this.bitField0_ |= 2;
            this.fullName_ = s;
        }

        private void setFullNameBytes(o o0) {
            this.fullName_ = o0.p();
            this.bitField0_ |= 2;
        }

        private void setNumber(int v) {
            this.bitField0_ |= 1;
            this.number_ = v;
        }

        private void setRepeated(boolean z) {
            this.bitField0_ |= 16;
            this.repeated_ = z;
        }

        private void setReserved(boolean z) {
            this.bitField0_ |= 8;
            this.reserved_ = z;
        }

        private void setType(String s) {
            s.getClass();
            this.bitField0_ |= 4;
            this.type_ = s;
        }

        private void setTypeBytes(o o0) {
            this.type_ = o0.p();
            this.bitField0_ |= 4;
        }
    }

    public static final int DECLARATION_FIELD_NUMBER = 2;
    private static final DescriptorProtos.ExtensionRangeOptions DEFAULT_INSTANCE = null;
    public static final int FEATURES_FIELD_NUMBER = 50;
    private static volatile z2 PARSER = null;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    public static final int VERIFICATION_FIELD_NUMBER = 3;
    private int bitField0_;
    private O1 declaration_;
    private DescriptorProtos.FeatureSet features_;
    private byte memoizedIsInitialized;
    private O1 uninterpretedOption_;
    private int verification_;

    static {
        DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0 = new DescriptorProtos.ExtensionRangeOptions();
        DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE = descriptorProtos$ExtensionRangeOptions0;
        A1.registerDefaultInstance(DescriptorProtos.ExtensionRangeOptions.class, descriptorProtos$ExtensionRangeOptions0);
    }

    private DescriptorProtos.ExtensionRangeOptions() {
        this.memoizedIsInitialized = 2;
        this.uninterpretedOption_ = A1.emptyProtobufList();
        this.declaration_ = A1.emptyProtobufList();
        this.verification_ = 1;
    }

    public static void access$15600(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0, int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$ExtensionRangeOptions0.setUninterpretedOption(v, descriptorProtos$UninterpretedOption0);
    }

    public static void access$15700(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$ExtensionRangeOptions0.addUninterpretedOption(descriptorProtos$UninterpretedOption0);
    }

    public static void access$15800(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0, int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$ExtensionRangeOptions0.addUninterpretedOption(v, descriptorProtos$UninterpretedOption0);
    }

    public static void access$15900(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0, Iterable iterable0) {
        descriptorProtos$ExtensionRangeOptions0.addAllUninterpretedOption(iterable0);
    }

    public static void access$16000(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0) {
        descriptorProtos$ExtensionRangeOptions0.clearUninterpretedOption();
    }

    public static void access$16100(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0, int v) {
        descriptorProtos$ExtensionRangeOptions0.removeUninterpretedOption(v);
    }

    public static void access$16200(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0, int v, Declaration descriptorProtos$ExtensionRangeOptions$Declaration0) {
        descriptorProtos$ExtensionRangeOptions0.setDeclaration(v, descriptorProtos$ExtensionRangeOptions$Declaration0);
    }

    public static void access$16300(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0, Declaration descriptorProtos$ExtensionRangeOptions$Declaration0) {
        descriptorProtos$ExtensionRangeOptions0.addDeclaration(descriptorProtos$ExtensionRangeOptions$Declaration0);
    }

    public static void access$16400(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0, int v, Declaration descriptorProtos$ExtensionRangeOptions$Declaration0) {
        descriptorProtos$ExtensionRangeOptions0.addDeclaration(v, descriptorProtos$ExtensionRangeOptions$Declaration0);
    }

    public static void access$16500(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0, Iterable iterable0) {
        descriptorProtos$ExtensionRangeOptions0.addAllDeclaration(iterable0);
    }

    public static void access$16600(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0) {
        descriptorProtos$ExtensionRangeOptions0.clearDeclaration();
    }

    public static void access$16700(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0, int v) {
        descriptorProtos$ExtensionRangeOptions0.removeDeclaration(v);
    }

    public static void access$16800(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$ExtensionRangeOptions0.setFeatures(descriptorProtos$FeatureSet0);
    }

    public static void access$16900(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$ExtensionRangeOptions0.mergeFeatures(descriptorProtos$FeatureSet0);
    }

    public static void access$17000(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0) {
        descriptorProtos$ExtensionRangeOptions0.clearFeatures();
    }

    public static void access$17100(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0, S s0) {
        descriptorProtos$ExtensionRangeOptions0.setVerification(s0);
    }

    public static void access$17200(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0) {
        descriptorProtos$ExtensionRangeOptions0.clearVerification();
    }

    private void addAllDeclaration(Iterable iterable0) {
        this.ensureDeclarationIsMutable();
        b.addAll(iterable0, this.declaration_);
    }

    private void addAllUninterpretedOption(Iterable iterable0) {
        this.ensureUninterpretedOptionIsMutable();
        b.addAll(iterable0, this.uninterpretedOption_);
    }

    private void addDeclaration(int v, Declaration descriptorProtos$ExtensionRangeOptions$Declaration0) {
        descriptorProtos$ExtensionRangeOptions$Declaration0.getClass();
        this.ensureDeclarationIsMutable();
        this.declaration_.add(v, descriptorProtos$ExtensionRangeOptions$Declaration0);
    }

    private void addDeclaration(Declaration descriptorProtos$ExtensionRangeOptions$Declaration0) {
        descriptorProtos$ExtensionRangeOptions$Declaration0.getClass();
        this.ensureDeclarationIsMutable();
        this.declaration_.add(descriptorProtos$ExtensionRangeOptions$Declaration0);
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

    private void clearDeclaration() {
        this.declaration_ = A1.emptyProtobufList();
    }

    private void clearFeatures() {
        this.features_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUninterpretedOption() {
        this.uninterpretedOption_ = A1.emptyProtobufList();
    }

    private void clearVerification() {
        this.bitField0_ &= -3;
        this.verification_ = 1;
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
                return A1.newMessageInfo(DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0002ϧ\u0004\u0000\u0002\u0002\u0002\u001B\u0003᠌\u00012ᐉ\u0000ϧЛ", new Object[]{"bitField0_", "declaration_", Declaration.class, "verification_", E.c, "features_", "uninterpretedOption_", DescriptorProtos.UninterpretedOption.class});
            }
            case 3: {
                return new DescriptorProtos.ExtensionRangeOptions();
            }
            case 4: {
                return new O(DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.ExtensionRangeOptions.PARSER;
                if(z20 == null) {
                    synchronized(DescriptorProtos.ExtensionRangeOptions.class) {
                        z21 = DescriptorProtos.ExtensionRangeOptions.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.ExtensionRangeOptions.PARSER = z21;
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

    private void ensureDeclarationIsMutable() {
        O1 o10 = this.declaration_;
        if(!((c)o10).a) {
            this.declaration_ = A1.mutableCopy(o10);
        }
    }

    private void ensureUninterpretedOptionIsMutable() {
        O1 o10 = this.uninterpretedOption_;
        if(!((c)o10).a) {
            this.uninterpretedOption_ = A1.mutableCopy(o10);
        }
    }

    public Declaration getDeclaration(int v) {
        return (Declaration)this.declaration_.get(v);
    }

    public int getDeclarationCount() {
        return this.declaration_.size();
    }

    public List getDeclarationList() {
        return this.declaration_;
    }

    public Q getDeclarationOrBuilder(int v) {
        return (Q)this.declaration_.get(v);
    }

    public List getDeclarationOrBuilderList() {
        return this.declaration_;
    }

    public static DescriptorProtos.ExtensionRangeOptions getDefaultInstance() {
        return DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE;
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

    public S getVerification() {
        S s0 = S.c;
        switch(this.verification_) {
            case 0: {
                return S.b == null ? s0 : S.b;
            }
            case 1: {
                return s0;
            }
            default: {
                return s0;
            }
        }
    }

    public boolean hasFeatures() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasVerification() {
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
        this.bitField0_ |= 1;
    }

    public static O newBuilder() {
        return (O)DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE.createBuilder();
    }

    public static O newBuilder(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0) {
        return (O)DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE.createBuilder(descriptorProtos$ExtensionRangeOptions0);
    }

    public static DescriptorProtos.ExtensionRangeOptions parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.ExtensionRangeOptions)A1.parseDelimitedFrom(DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.ExtensionRangeOptions parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.ExtensionRangeOptions)A1.parseDelimitedFrom(DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.ExtensionRangeOptions parseFrom(o o0) {
        return (DescriptorProtos.ExtensionRangeOptions)A1.parseFrom(DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.ExtensionRangeOptions parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.ExtensionRangeOptions)A1.parseFrom(DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.ExtensionRangeOptions parseFrom(t t0) {
        return (DescriptorProtos.ExtensionRangeOptions)A1.parseFrom(DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.ExtensionRangeOptions parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.ExtensionRangeOptions)A1.parseFrom(DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.ExtensionRangeOptions parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.ExtensionRangeOptions)A1.parseFrom(DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.ExtensionRangeOptions parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.ExtensionRangeOptions)A1.parseFrom(DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.ExtensionRangeOptions parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.ExtensionRangeOptions)A1.parseFrom(DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.ExtensionRangeOptions parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.ExtensionRangeOptions)A1.parseFrom(DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.ExtensionRangeOptions parseFrom(byte[] arr_b) {
        return (DescriptorProtos.ExtensionRangeOptions)A1.parseFrom(DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.ExtensionRangeOptions parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.ExtensionRangeOptions)A1.parseFrom(DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.ExtensionRangeOptions.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeDeclaration(int v) {
        this.ensureDeclarationIsMutable();
        this.declaration_.remove(v);
    }

    private void removeUninterpretedOption(int v) {
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.remove(v);
    }

    private void setDeclaration(int v, Declaration descriptorProtos$ExtensionRangeOptions$Declaration0) {
        descriptorProtos$ExtensionRangeOptions$Declaration0.getClass();
        this.ensureDeclarationIsMutable();
        this.declaration_.set(v, descriptorProtos$ExtensionRangeOptions$Declaration0);
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

    private void setVerification(S s0) {
        this.verification_ = s0.a;
        this.bitField0_ |= 2;
    }
}

