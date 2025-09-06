package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos.EnumDescriptorProto extends A1 implements J {
    public static final class EnumReservedRange extends A1 implements I {
        private static final EnumReservedRange DEFAULT_INSTANCE = null;
        public static final int END_FIELD_NUMBER = 2;
        private static volatile z2 PARSER = null;
        public static final int START_FIELD_NUMBER = 1;
        private int bitField0_;
        private int end_;
        private int start_;

        static {
            EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange0 = new EnumReservedRange();
            EnumReservedRange.DEFAULT_INSTANCE = descriptorProtos$EnumDescriptorProto$EnumReservedRange0;
            A1.registerDefaultInstance(EnumReservedRange.class, descriptorProtos$EnumDescriptorProto$EnumReservedRange0);
        }

        public static void access$21300(EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange0, int v) {
            descriptorProtos$EnumDescriptorProto$EnumReservedRange0.setStart(v);
        }

        public static void access$21400(EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange0) {
            descriptorProtos$EnumDescriptorProto$EnumReservedRange0.clearStart();
        }

        public static void access$21500(EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange0, int v) {
            descriptorProtos$EnumDescriptorProto$EnumReservedRange0.setEnd(v);
        }

        public static void access$21600(EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange0) {
            descriptorProtos$EnumDescriptorProto$EnumReservedRange0.clearEnd();
        }

        private void clearEnd() {
            this.bitField0_ &= -3;
            this.end_ = 0;
        }

        private void clearStart() {
            this.bitField0_ &= -2;
            this.start_ = 0;
        }

        @Override  // com.google.protobuf.A1
        public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
            switch(z10.ordinal()) {
                case 0: {
                    return (byte)1;
                }
                case 2: {
                    return A1.newMessageInfo(EnumReservedRange.DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"bitField0_", "start_", "end_"});
                }
                case 3: {
                    return new EnumReservedRange();
                }
                case 4: {
                    return new H(EnumReservedRange.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
                }
                case 5: {
                    return EnumReservedRange.DEFAULT_INSTANCE;
                }
                case 6: {
                    z2 z20 = EnumReservedRange.PARSER;
                    if(z20 == null) {
                        Class class0 = EnumReservedRange.class;
                        synchronized(class0) {
                            z2 z21 = EnumReservedRange.PARSER;
                            if(z21 == null) {
                                z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                                EnumReservedRange.PARSER = z21;
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

        public static EnumReservedRange getDefaultInstance() {
            return EnumReservedRange.DEFAULT_INSTANCE;
        }

        public int getEnd() {
            return this.end_;
        }

        public int getStart() {
            return this.start_;
        }

        public boolean hasEnd() {
            return (this.bitField0_ & 2) != 0;
        }

        public boolean hasStart() {
            return (this.bitField0_ & 1) != 0;
        }

        public static H newBuilder() {
            return (H)EnumReservedRange.DEFAULT_INSTANCE.createBuilder();
        }

        public static H newBuilder(EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange0) {
            return (H)EnumReservedRange.DEFAULT_INSTANCE.createBuilder(descriptorProtos$EnumDescriptorProto$EnumReservedRange0);
        }

        public static EnumReservedRange parseDelimitedFrom(InputStream inputStream0) {
            return (EnumReservedRange)A1.parseDelimitedFrom(EnumReservedRange.DEFAULT_INSTANCE, inputStream0);
        }

        public static EnumReservedRange parseDelimitedFrom(InputStream inputStream0, g1 g10) {
            return (EnumReservedRange)A1.parseDelimitedFrom(EnumReservedRange.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static EnumReservedRange parseFrom(o o0) {
            return (EnumReservedRange)A1.parseFrom(EnumReservedRange.DEFAULT_INSTANCE, o0);
        }

        public static EnumReservedRange parseFrom(o o0, g1 g10) {
            return (EnumReservedRange)A1.parseFrom(EnumReservedRange.DEFAULT_INSTANCE, o0, g10);
        }

        public static EnumReservedRange parseFrom(t t0) {
            return (EnumReservedRange)A1.parseFrom(EnumReservedRange.DEFAULT_INSTANCE, t0);
        }

        public static EnumReservedRange parseFrom(t t0, g1 g10) {
            return (EnumReservedRange)A1.parseFrom(EnumReservedRange.DEFAULT_INSTANCE, t0, g10);
        }

        public static EnumReservedRange parseFrom(InputStream inputStream0) {
            return (EnumReservedRange)A1.parseFrom(EnumReservedRange.DEFAULT_INSTANCE, inputStream0);
        }

        public static EnumReservedRange parseFrom(InputStream inputStream0, g1 g10) {
            return (EnumReservedRange)A1.parseFrom(EnumReservedRange.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static EnumReservedRange parseFrom(ByteBuffer byteBuffer0) {
            return (EnumReservedRange)A1.parseFrom(EnumReservedRange.DEFAULT_INSTANCE, byteBuffer0);
        }

        public static EnumReservedRange parseFrom(ByteBuffer byteBuffer0, g1 g10) {
            return (EnumReservedRange)A1.parseFrom(EnumReservedRange.DEFAULT_INSTANCE, byteBuffer0, g10);
        }

        public static EnumReservedRange parseFrom(byte[] arr_b) {
            return (EnumReservedRange)A1.parseFrom(EnumReservedRange.DEFAULT_INSTANCE, arr_b);
        }

        public static EnumReservedRange parseFrom(byte[] arr_b, g1 g10) {
            return (EnumReservedRange)A1.parseFrom(EnumReservedRange.DEFAULT_INSTANCE, arr_b, g10);
        }

        public static z2 parser() {
            return EnumReservedRange.DEFAULT_INSTANCE.getParserForType();
        }

        private void setEnd(int v) {
            this.bitField0_ |= 2;
            this.end_ = v;
        }

        private void setStart(int v) {
            this.bitField0_ |= 1;
            this.start_ = v;
        }
    }

    private static final DescriptorProtos.EnumDescriptorProto DEFAULT_INSTANCE = null;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile z2 PARSER = null;
    public static final int RESERVED_NAME_FIELD_NUMBER = 5;
    public static final int RESERVED_RANGE_FIELD_NUMBER = 4;
    public static final int VALUE_FIELD_NUMBER = 2;
    public static final int VISIBILITY_FIELD_NUMBER = 6;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private String name_;
    private DescriptorProtos.EnumOptions options_;
    private O1 reservedName_;
    private O1 reservedRange_;
    private O1 value_;
    private int visibility_;

    static {
        DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0 = new DescriptorProtos.EnumDescriptorProto();
        DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE = descriptorProtos$EnumDescriptorProto0;
        A1.registerDefaultInstance(DescriptorProtos.EnumDescriptorProto.class, descriptorProtos$EnumDescriptorProto0);
    }

    private DescriptorProtos.EnumDescriptorProto() {
        this.memoizedIsInitialized = 2;
        this.name_ = "";
        this.value_ = A1.emptyProtobufList();
        this.reservedRange_ = A1.emptyProtobufList();
        this.reservedName_ = A1.emptyProtobufList();
    }

    public static void access$21900(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, String s) {
        descriptorProtos$EnumDescriptorProto0.setName(s);
    }

    public static void access$22000(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0) {
        descriptorProtos$EnumDescriptorProto0.clearName();
    }

    public static void access$22100(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, o o0) {
        descriptorProtos$EnumDescriptorProto0.setNameBytes(o0);
    }

    public static void access$22200(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, int v, DescriptorProtos.EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto0) {
        descriptorProtos$EnumDescriptorProto0.setValue(v, descriptorProtos$EnumValueDescriptorProto0);
    }

    public static void access$22300(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, DescriptorProtos.EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto0) {
        descriptorProtos$EnumDescriptorProto0.addValue(descriptorProtos$EnumValueDescriptorProto0);
    }

    public static void access$22400(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, int v, DescriptorProtos.EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto0) {
        descriptorProtos$EnumDescriptorProto0.addValue(v, descriptorProtos$EnumValueDescriptorProto0);
    }

    public static void access$22500(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, Iterable iterable0) {
        descriptorProtos$EnumDescriptorProto0.addAllValue(iterable0);
    }

    public static void access$22600(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0) {
        descriptorProtos$EnumDescriptorProto0.clearValue();
    }

    public static void access$22700(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, int v) {
        descriptorProtos$EnumDescriptorProto0.removeValue(v);
    }

    public static void access$22800(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0) {
        descriptorProtos$EnumDescriptorProto0.setOptions(descriptorProtos$EnumOptions0);
    }

    public static void access$22900(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0) {
        descriptorProtos$EnumDescriptorProto0.mergeOptions(descriptorProtos$EnumOptions0);
    }

    public static void access$23000(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0) {
        descriptorProtos$EnumDescriptorProto0.clearOptions();
    }

    public static void access$23100(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, int v, EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange0) {
        descriptorProtos$EnumDescriptorProto0.setReservedRange(v, descriptorProtos$EnumDescriptorProto$EnumReservedRange0);
    }

    public static void access$23200(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange0) {
        descriptorProtos$EnumDescriptorProto0.addReservedRange(descriptorProtos$EnumDescriptorProto$EnumReservedRange0);
    }

    public static void access$23300(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, int v, EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange0) {
        descriptorProtos$EnumDescriptorProto0.addReservedRange(v, descriptorProtos$EnumDescriptorProto$EnumReservedRange0);
    }

    public static void access$23400(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, Iterable iterable0) {
        descriptorProtos$EnumDescriptorProto0.addAllReservedRange(iterable0);
    }

    public static void access$23500(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0) {
        descriptorProtos$EnumDescriptorProto0.clearReservedRange();
    }

    public static void access$23600(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, int v) {
        descriptorProtos$EnumDescriptorProto0.removeReservedRange(v);
    }

    public static void access$23700(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, int v, String s) {
        descriptorProtos$EnumDescriptorProto0.setReservedName(v, s);
    }

    public static void access$23800(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, String s) {
        descriptorProtos$EnumDescriptorProto0.addReservedName(s);
    }

    public static void access$23900(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, Iterable iterable0) {
        descriptorProtos$EnumDescriptorProto0.addAllReservedName(iterable0);
    }

    public static void access$24000(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0) {
        descriptorProtos$EnumDescriptorProto0.clearReservedName();
    }

    public static void access$24100(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, o o0) {
        descriptorProtos$EnumDescriptorProto0.addReservedNameBytes(o0);
    }

    public static void access$24200(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0, R0 r00) {
        descriptorProtos$EnumDescriptorProto0.setVisibility(r00);
    }

    public static void access$24300(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0) {
        descriptorProtos$EnumDescriptorProto0.clearVisibility();
    }

    private void addAllReservedName(Iterable iterable0) {
        this.ensureReservedNameIsMutable();
        b.addAll(iterable0, this.reservedName_);
    }

    private void addAllReservedRange(Iterable iterable0) {
        this.ensureReservedRangeIsMutable();
        b.addAll(iterable0, this.reservedRange_);
    }

    private void addAllValue(Iterable iterable0) {
        this.ensureValueIsMutable();
        b.addAll(iterable0, this.value_);
    }

    private void addReservedName(String s) {
        s.getClass();
        this.ensureReservedNameIsMutable();
        this.reservedName_.add(s);
    }

    private void addReservedNameBytes(o o0) {
        this.ensureReservedNameIsMutable();
        this.reservedName_.add(o0.p());
    }

    private void addReservedRange(int v, EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange0) {
        descriptorProtos$EnumDescriptorProto$EnumReservedRange0.getClass();
        this.ensureReservedRangeIsMutable();
        this.reservedRange_.add(v, descriptorProtos$EnumDescriptorProto$EnumReservedRange0);
    }

    private void addReservedRange(EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange0) {
        descriptorProtos$EnumDescriptorProto$EnumReservedRange0.getClass();
        this.ensureReservedRangeIsMutable();
        this.reservedRange_.add(descriptorProtos$EnumDescriptorProto$EnumReservedRange0);
    }

    private void addValue(int v, DescriptorProtos.EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto0) {
        descriptorProtos$EnumValueDescriptorProto0.getClass();
        this.ensureValueIsMutable();
        this.value_.add(v, descriptorProtos$EnumValueDescriptorProto0);
    }

    private void addValue(DescriptorProtos.EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto0) {
        descriptorProtos$EnumValueDescriptorProto0.getClass();
        this.ensureValueIsMutable();
        this.value_.add(descriptorProtos$EnumValueDescriptorProto0);
    }

    private void clearName() {
        this.bitField0_ &= -2;
        this.name_ = "";
    }

    private void clearOptions() {
        this.options_ = null;
        this.bitField0_ &= -3;
    }

    private void clearReservedName() {
        this.reservedName_ = A1.emptyProtobufList();
    }

    private void clearReservedRange() {
        this.reservedRange_ = A1.emptyProtobufList();
    }

    private void clearValue() {
        this.value_ = A1.emptyProtobufList();
    }

    private void clearVisibility() {
        this.bitField0_ &= -5;
        this.visibility_ = 0;
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
                return A1.newMessageInfo(DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0003\u0002\u0001ဈ\u0000\u0002Л\u0003ᐉ\u0001\u0004\u001B\u0005\u001A\u0006᠌\u0002", new Object[]{"bitField0_", "name_", "value_", DescriptorProtos.EnumValueDescriptorProto.class, "options_", "reservedRange_", EnumReservedRange.class, "reservedName_", "visibility_", E.s});
            }
            case 3: {
                return new DescriptorProtos.EnumDescriptorProto();
            }
            case 4: {
                return new G(DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.EnumDescriptorProto.PARSER;
                if(z20 == null) {
                    synchronized(DescriptorProtos.EnumDescriptorProto.class) {
                        z21 = DescriptorProtos.EnumDescriptorProto.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.EnumDescriptorProto.PARSER = z21;
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

    private void ensureReservedNameIsMutable() {
        O1 o10 = this.reservedName_;
        if(!((c)o10).a) {
            this.reservedName_ = A1.mutableCopy(o10);
        }
    }

    private void ensureReservedRangeIsMutable() {
        O1 o10 = this.reservedRange_;
        if(!((c)o10).a) {
            this.reservedRange_ = A1.mutableCopy(o10);
        }
    }

    private void ensureValueIsMutable() {
        O1 o10 = this.value_;
        if(!((c)o10).a) {
            this.value_ = A1.mutableCopy(o10);
        }
    }

    public static DescriptorProtos.EnumDescriptorProto getDefaultInstance() {
        return DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE;
    }

    public String getName() [...] // 潜在的解密器

    public o getNameBytes() {
        return o.e(this.name_);
    }

    public DescriptorProtos.EnumOptions getOptions() {
        return this.options_ == null ? DescriptorProtos.EnumOptions.getDefaultInstance() : this.options_;
    }

    public String getReservedName(int v) {
        return (String)this.reservedName_.get(v);
    }

    public o getReservedNameBytes(int v) {
        return o.e(((String)this.reservedName_.get(v)));
    }

    public int getReservedNameCount() {
        return this.reservedName_.size();
    }

    public List getReservedNameList() {
        return this.reservedName_;
    }

    public EnumReservedRange getReservedRange(int v) {
        return (EnumReservedRange)this.reservedRange_.get(v);
    }

    public int getReservedRangeCount() {
        return this.reservedRange_.size();
    }

    public List getReservedRangeList() {
        return this.reservedRange_;
    }

    public I getReservedRangeOrBuilder(int v) {
        return (I)this.reservedRange_.get(v);
    }

    public List getReservedRangeOrBuilderList() {
        return this.reservedRange_;
    }

    public DescriptorProtos.EnumValueDescriptorProto getValue(int v) {
        return (DescriptorProtos.EnumValueDescriptorProto)this.value_.get(v);
    }

    public int getValueCount() {
        return this.value_.size();
    }

    public List getValueList() {
        return this.value_;
    }

    public M getValueOrBuilder(int v) {
        return (M)this.value_.get(v);
    }

    public List getValueOrBuilderList() {
        return this.value_;
    }

    public R0 getVisibility() {
        R0 r00 = R0.b(this.visibility_);
        return r00 == null ? R0.b : r00;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasOptions() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasVisibility() {
        return (this.bitField0_ & 4) != 0;
    }

    private void mergeOptions(DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0) {
        descriptorProtos$EnumOptions0.getClass();
        if(this.options_ == null || this.options_ == DescriptorProtos.EnumOptions.getDefaultInstance()) {
            this.options_ = descriptorProtos$EnumOptions0;
        }
        else {
            K k0 = DescriptorProtos.EnumOptions.newBuilder(this.options_);
            k0.f(descriptorProtos$EnumOptions0);
            this.options_ = (DescriptorProtos.EnumOptions)k0.i();
        }
        this.bitField0_ |= 2;
    }

    public static G newBuilder() {
        return (G)DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE.createBuilder();
    }

    public static G newBuilder(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0) {
        return (G)DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE.createBuilder(descriptorProtos$EnumDescriptorProto0);
    }

    public static DescriptorProtos.EnumDescriptorProto parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.EnumDescriptorProto)A1.parseDelimitedFrom(DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.EnumDescriptorProto parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.EnumDescriptorProto)A1.parseDelimitedFrom(DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.EnumDescriptorProto parseFrom(o o0) {
        return (DescriptorProtos.EnumDescriptorProto)A1.parseFrom(DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.EnumDescriptorProto parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.EnumDescriptorProto)A1.parseFrom(DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.EnumDescriptorProto parseFrom(t t0) {
        return (DescriptorProtos.EnumDescriptorProto)A1.parseFrom(DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.EnumDescriptorProto parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.EnumDescriptorProto)A1.parseFrom(DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.EnumDescriptorProto parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.EnumDescriptorProto)A1.parseFrom(DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.EnumDescriptorProto parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.EnumDescriptorProto)A1.parseFrom(DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.EnumDescriptorProto parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.EnumDescriptorProto)A1.parseFrom(DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.EnumDescriptorProto parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.EnumDescriptorProto)A1.parseFrom(DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.EnumDescriptorProto parseFrom(byte[] arr_b) {
        return (DescriptorProtos.EnumDescriptorProto)A1.parseFrom(DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.EnumDescriptorProto parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.EnumDescriptorProto)A1.parseFrom(DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.EnumDescriptorProto.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeReservedRange(int v) {
        this.ensureReservedRangeIsMutable();
        this.reservedRange_.remove(v);
    }

    private void removeValue(int v) {
        this.ensureValueIsMutable();
        this.value_.remove(v);
    }

    private void setName(String s) {
        s.getClass();
        this.bitField0_ |= 1;
        this.name_ = s;
    }

    private void setNameBytes(o o0) {
        this.name_ = o0.p();
        this.bitField0_ |= 1;
    }

    private void setOptions(DescriptorProtos.EnumOptions descriptorProtos$EnumOptions0) {
        descriptorProtos$EnumOptions0.getClass();
        this.options_ = descriptorProtos$EnumOptions0;
        this.bitField0_ |= 2;
    }

    private void setReservedName(int v, String s) {
        s.getClass();
        this.ensureReservedNameIsMutable();
        this.reservedName_.set(v, s);
    }

    private void setReservedRange(int v, EnumReservedRange descriptorProtos$EnumDescriptorProto$EnumReservedRange0) {
        descriptorProtos$EnumDescriptorProto$EnumReservedRange0.getClass();
        this.ensureReservedRangeIsMutable();
        this.reservedRange_.set(v, descriptorProtos$EnumDescriptorProto$EnumReservedRange0);
    }

    private void setValue(int v, DescriptorProtos.EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto0) {
        descriptorProtos$EnumValueDescriptorProto0.getClass();
        this.ensureValueIsMutable();
        this.value_.set(v, descriptorProtos$EnumValueDescriptorProto0);
    }

    private void setVisibility(R0 r00) {
        this.visibility_ = r00.a;
        this.bitField0_ |= 4;
    }
}

