package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos.UninterpretedOption extends A1 implements V0 {
    public static final class NamePart extends A1 implements U0 {
        private static final NamePart DEFAULT_INSTANCE = null;
        public static final int IS_EXTENSION_FIELD_NUMBER = 2;
        public static final int NAME_PART_FIELD_NUMBER = 1;
        private static volatile z2 PARSER;
        private int bitField0_;
        private boolean isExtension_;
        private byte memoizedIsInitialized;
        private String namePart_;

        static {
            NamePart descriptorProtos$UninterpretedOption$NamePart0 = new NamePart();
            NamePart.DEFAULT_INSTANCE = descriptorProtos$UninterpretedOption$NamePart0;
            A1.registerDefaultInstance(NamePart.class, descriptorProtos$UninterpretedOption$NamePart0);
        }

        private NamePart() {
            this.memoizedIsInitialized = 2;
            this.namePart_ = "";
        }

        public static void access$50200(NamePart descriptorProtos$UninterpretedOption$NamePart0, String s) {
            descriptorProtos$UninterpretedOption$NamePart0.setNamePart(s);
        }

        public static void access$50300(NamePart descriptorProtos$UninterpretedOption$NamePart0) {
            descriptorProtos$UninterpretedOption$NamePart0.clearNamePart();
        }

        public static void access$50400(NamePart descriptorProtos$UninterpretedOption$NamePart0, o o0) {
            descriptorProtos$UninterpretedOption$NamePart0.setNamePartBytes(o0);
        }

        public static void access$50500(NamePart descriptorProtos$UninterpretedOption$NamePart0, boolean z) {
            descriptorProtos$UninterpretedOption$NamePart0.setIsExtension(z);
        }

        public static void access$50600(NamePart descriptorProtos$UninterpretedOption$NamePart0) {
            descriptorProtos$UninterpretedOption$NamePart0.clearIsExtension();
        }

        private void clearIsExtension() {
            this.bitField0_ &= -3;
            this.isExtension_ = false;
        }

        private void clearNamePart() {
            this.bitField0_ &= -2;
            this.namePart_ = "";
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
                    return A1.newMessageInfo(NamePart.DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔇ\u0001", new Object[]{"bitField0_", "namePart_", "isExtension_"});
                }
                case 3: {
                    return new NamePart();
                }
                case 4: {
                    return new T0(NamePart.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
                }
                case 5: {
                    return NamePart.DEFAULT_INSTANCE;
                }
                case 6: {
                    z2 z20 = NamePart.PARSER;
                    if(z20 == null) {
                        Class class0 = NamePart.class;
                        synchronized(class0) {
                            z2 z21 = NamePart.PARSER;
                            if(z21 == null) {
                                z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                                NamePart.PARSER = z21;
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

        public static NamePart getDefaultInstance() {
            return NamePart.DEFAULT_INSTANCE;
        }

        public boolean getIsExtension() {
            return this.isExtension_;
        }

        public String getNamePart() [...] // 潜在的解密器

        public o getNamePartBytes() {
            return o.e(this.namePart_);
        }

        public boolean hasIsExtension() {
            return (this.bitField0_ & 2) != 0;
        }

        public boolean hasNamePart() {
            return (this.bitField0_ & 1) != 0;
        }

        public static T0 newBuilder() {
            return (T0)NamePart.DEFAULT_INSTANCE.createBuilder();
        }

        public static T0 newBuilder(NamePart descriptorProtos$UninterpretedOption$NamePart0) {
            return (T0)NamePart.DEFAULT_INSTANCE.createBuilder(descriptorProtos$UninterpretedOption$NamePart0);
        }

        public static NamePart parseDelimitedFrom(InputStream inputStream0) {
            return (NamePart)A1.parseDelimitedFrom(NamePart.DEFAULT_INSTANCE, inputStream0);
        }

        public static NamePart parseDelimitedFrom(InputStream inputStream0, g1 g10) {
            return (NamePart)A1.parseDelimitedFrom(NamePart.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static NamePart parseFrom(o o0) {
            return (NamePart)A1.parseFrom(NamePart.DEFAULT_INSTANCE, o0);
        }

        public static NamePart parseFrom(o o0, g1 g10) {
            return (NamePart)A1.parseFrom(NamePart.DEFAULT_INSTANCE, o0, g10);
        }

        public static NamePart parseFrom(t t0) {
            return (NamePart)A1.parseFrom(NamePart.DEFAULT_INSTANCE, t0);
        }

        public static NamePart parseFrom(t t0, g1 g10) {
            return (NamePart)A1.parseFrom(NamePart.DEFAULT_INSTANCE, t0, g10);
        }

        public static NamePart parseFrom(InputStream inputStream0) {
            return (NamePart)A1.parseFrom(NamePart.DEFAULT_INSTANCE, inputStream0);
        }

        public static NamePart parseFrom(InputStream inputStream0, g1 g10) {
            return (NamePart)A1.parseFrom(NamePart.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static NamePart parseFrom(ByteBuffer byteBuffer0) {
            return (NamePart)A1.parseFrom(NamePart.DEFAULT_INSTANCE, byteBuffer0);
        }

        public static NamePart parseFrom(ByteBuffer byteBuffer0, g1 g10) {
            return (NamePart)A1.parseFrom(NamePart.DEFAULT_INSTANCE, byteBuffer0, g10);
        }

        public static NamePart parseFrom(byte[] arr_b) {
            return (NamePart)A1.parseFrom(NamePart.DEFAULT_INSTANCE, arr_b);
        }

        public static NamePart parseFrom(byte[] arr_b, g1 g10) {
            return (NamePart)A1.parseFrom(NamePart.DEFAULT_INSTANCE, arr_b, g10);
        }

        public static z2 parser() {
            return NamePart.DEFAULT_INSTANCE.getParserForType();
        }

        private void setIsExtension(boolean z) {
            this.bitField0_ |= 2;
            this.isExtension_ = z;
        }

        private void setNamePart(String s) {
            s.getClass();
            this.bitField0_ |= 1;
            this.namePart_ = s;
        }

        private void setNamePartBytes(o o0) {
            this.namePart_ = o0.p();
            this.bitField0_ |= 1;
        }
    }

    public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
    private static final DescriptorProtos.UninterpretedOption DEFAULT_INSTANCE = null;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
    public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
    private static volatile z2 PARSER = null;
    public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
    public static final int STRING_VALUE_FIELD_NUMBER = 7;
    private String aggregateValue_;
    private int bitField0_;
    private double doubleValue_;
    private String identifierValue_;
    private byte memoizedIsInitialized;
    private O1 name_;
    private long negativeIntValue_;
    private long positiveIntValue_;
    private o stringValue_;

    static {
        DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0 = new DescriptorProtos.UninterpretedOption();
        DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE = descriptorProtos$UninterpretedOption0;
        A1.registerDefaultInstance(DescriptorProtos.UninterpretedOption.class, descriptorProtos$UninterpretedOption0);
    }

    private DescriptorProtos.UninterpretedOption() {
        this.memoizedIsInitialized = 2;
        this.name_ = A1.emptyProtobufList();
        this.identifierValue_ = "";
        this.stringValue_ = o.b;
        this.aggregateValue_ = "";
    }

    public static void access$50900(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0, int v, NamePart descriptorProtos$UninterpretedOption$NamePart0) {
        descriptorProtos$UninterpretedOption0.setName(v, descriptorProtos$UninterpretedOption$NamePart0);
    }

    public static void access$51000(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0, NamePart descriptorProtos$UninterpretedOption$NamePart0) {
        descriptorProtos$UninterpretedOption0.addName(descriptorProtos$UninterpretedOption$NamePart0);
    }

    public static void access$51100(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0, int v, NamePart descriptorProtos$UninterpretedOption$NamePart0) {
        descriptorProtos$UninterpretedOption0.addName(v, descriptorProtos$UninterpretedOption$NamePart0);
    }

    public static void access$51200(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0, Iterable iterable0) {
        descriptorProtos$UninterpretedOption0.addAllName(iterable0);
    }

    public static void access$51300(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.clearName();
    }

    public static void access$51400(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0, int v) {
        descriptorProtos$UninterpretedOption0.removeName(v);
    }

    public static void access$51500(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0, String s) {
        descriptorProtos$UninterpretedOption0.setIdentifierValue(s);
    }

    public static void access$51600(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.clearIdentifierValue();
    }

    public static void access$51700(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0, o o0) {
        descriptorProtos$UninterpretedOption0.setIdentifierValueBytes(o0);
    }

    public static void access$51800(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0, long v) {
        descriptorProtos$UninterpretedOption0.setPositiveIntValue(v);
    }

    public static void access$51900(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.clearPositiveIntValue();
    }

    public static void access$52000(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0, long v) {
        descriptorProtos$UninterpretedOption0.setNegativeIntValue(v);
    }

    public static void access$52100(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.clearNegativeIntValue();
    }

    public static void access$52200(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0, double f) {
        descriptorProtos$UninterpretedOption0.setDoubleValue(f);
    }

    public static void access$52300(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.clearDoubleValue();
    }

    public static void access$52400(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0, o o0) {
        descriptorProtos$UninterpretedOption0.setStringValue(o0);
    }

    public static void access$52500(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.clearStringValue();
    }

    public static void access$52600(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0, String s) {
        descriptorProtos$UninterpretedOption0.setAggregateValue(s);
    }

    public static void access$52700(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.clearAggregateValue();
    }

    public static void access$52800(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0, o o0) {
        descriptorProtos$UninterpretedOption0.setAggregateValueBytes(o0);
    }

    private void addAllName(Iterable iterable0) {
        this.ensureNameIsMutable();
        b.addAll(iterable0, this.name_);
    }

    private void addName(int v, NamePart descriptorProtos$UninterpretedOption$NamePart0) {
        descriptorProtos$UninterpretedOption$NamePart0.getClass();
        this.ensureNameIsMutable();
        this.name_.add(v, descriptorProtos$UninterpretedOption$NamePart0);
    }

    private void addName(NamePart descriptorProtos$UninterpretedOption$NamePart0) {
        descriptorProtos$UninterpretedOption$NamePart0.getClass();
        this.ensureNameIsMutable();
        this.name_.add(descriptorProtos$UninterpretedOption$NamePart0);
    }

    private void clearAggregateValue() {
        this.bitField0_ &= -33;
        this.aggregateValue_ = "";
    }

    private void clearDoubleValue() {
        this.bitField0_ &= -9;
        this.doubleValue_ = 0.0;
    }

    private void clearIdentifierValue() {
        this.bitField0_ &= -2;
        this.identifierValue_ = "";
    }

    private void clearName() {
        this.name_ = A1.emptyProtobufList();
    }

    private void clearNegativeIntValue() {
        this.bitField0_ &= -5;
        this.negativeIntValue_ = 0L;
    }

    private void clearPositiveIntValue() {
        this.bitField0_ &= -3;
        this.positiveIntValue_ = 0L;
    }

    private void clearStringValue() {
        this.bitField0_ &= -17;
        this.stringValue_ = DescriptorProtos.UninterpretedOption.getDefaultInstance().getStringValue();
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
                return A1.newMessageInfo(DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0002\b\u0007\u0000\u0001\u0001\u0002Л\u0003ဈ\u0000\u0004ဃ\u0001\u0005ဂ\u0002\u0006က\u0003\u0007ည\u0004\bဈ\u0005", new Object[]{"bitField0_", "name_", NamePart.class, "identifierValue_", "positiveIntValue_", "negativeIntValue_", "doubleValue_", "stringValue_", "aggregateValue_"});
            }
            case 3: {
                return new DescriptorProtos.UninterpretedOption();
            }
            case 4: {
                return new S0(DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.UninterpretedOption.PARSER;
                if(z20 == null) {
                    synchronized(DescriptorProtos.UninterpretedOption.class) {
                        z21 = DescriptorProtos.UninterpretedOption.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.UninterpretedOption.PARSER = z21;
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

    private void ensureNameIsMutable() {
        O1 o10 = this.name_;
        if(!((c)o10).a) {
            this.name_ = A1.mutableCopy(o10);
        }
    }

    public String getAggregateValue() [...] // 潜在的解密器

    public o getAggregateValueBytes() {
        return o.e(this.aggregateValue_);
    }

    public static DescriptorProtos.UninterpretedOption getDefaultInstance() {
        return DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE;
    }

    public double getDoubleValue() {
        return this.doubleValue_;
    }

    public String getIdentifierValue() [...] // 潜在的解密器

    public o getIdentifierValueBytes() {
        return o.e(this.identifierValue_);
    }

    public NamePart getName(int v) {
        return (NamePart)this.name_.get(v);
    }

    public int getNameCount() {
        return this.name_.size();
    }

    public List getNameList() {
        return this.name_;
    }

    public U0 getNameOrBuilder(int v) {
        return (U0)this.name_.get(v);
    }

    public List getNameOrBuilderList() {
        return this.name_;
    }

    public long getNegativeIntValue() {
        return this.negativeIntValue_;
    }

    public long getPositiveIntValue() {
        return this.positiveIntValue_;
    }

    public o getStringValue() {
        return this.stringValue_;
    }

    public boolean hasAggregateValue() {
        return (this.bitField0_ & 0x20) != 0;
    }

    public boolean hasDoubleValue() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasIdentifierValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasNegativeIntValue() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasPositiveIntValue() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasStringValue() {
        return (this.bitField0_ & 16) != 0;
    }

    public static S0 newBuilder() {
        return (S0)DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE.createBuilder();
    }

    public static S0 newBuilder(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        return (S0)DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE.createBuilder(descriptorProtos$UninterpretedOption0);
    }

    public static DescriptorProtos.UninterpretedOption parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.UninterpretedOption)A1.parseDelimitedFrom(DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.UninterpretedOption parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.UninterpretedOption)A1.parseDelimitedFrom(DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.UninterpretedOption parseFrom(o o0) {
        return (DescriptorProtos.UninterpretedOption)A1.parseFrom(DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.UninterpretedOption parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.UninterpretedOption)A1.parseFrom(DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.UninterpretedOption parseFrom(t t0) {
        return (DescriptorProtos.UninterpretedOption)A1.parseFrom(DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.UninterpretedOption parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.UninterpretedOption)A1.parseFrom(DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.UninterpretedOption parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.UninterpretedOption)A1.parseFrom(DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.UninterpretedOption parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.UninterpretedOption)A1.parseFrom(DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.UninterpretedOption parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.UninterpretedOption)A1.parseFrom(DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.UninterpretedOption parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.UninterpretedOption)A1.parseFrom(DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.UninterpretedOption parseFrom(byte[] arr_b) {
        return (DescriptorProtos.UninterpretedOption)A1.parseFrom(DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.UninterpretedOption parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.UninterpretedOption)A1.parseFrom(DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.UninterpretedOption.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeName(int v) {
        this.ensureNameIsMutable();
        this.name_.remove(v);
    }

    private void setAggregateValue(String s) {
        s.getClass();
        this.bitField0_ |= 0x20;
        this.aggregateValue_ = s;
    }

    private void setAggregateValueBytes(o o0) {
        this.aggregateValue_ = o0.p();
        this.bitField0_ |= 0x20;
    }

    private void setDoubleValue(double f) {
        this.bitField0_ |= 8;
        this.doubleValue_ = f;
    }

    private void setIdentifierValue(String s) {
        s.getClass();
        this.bitField0_ |= 1;
        this.identifierValue_ = s;
    }

    private void setIdentifierValueBytes(o o0) {
        this.identifierValue_ = o0.p();
        this.bitField0_ |= 1;
    }

    private void setName(int v, NamePart descriptorProtos$UninterpretedOption$NamePart0) {
        descriptorProtos$UninterpretedOption$NamePart0.getClass();
        this.ensureNameIsMutable();
        this.name_.set(v, descriptorProtos$UninterpretedOption$NamePart0);
    }

    private void setNegativeIntValue(long v) {
        this.bitField0_ |= 4;
        this.negativeIntValue_ = v;
    }

    private void setPositiveIntValue(long v) {
        this.bitField0_ |= 2;
        this.positiveIntValue_ = v;
    }

    private void setStringValue(o o0) {
        o0.getClass();
        this.bitField0_ |= 16;
        this.stringValue_ = o0;
    }
}

