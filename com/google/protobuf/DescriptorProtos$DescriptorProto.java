package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos.DescriptorProto extends A1 implements D {
    public static final class ExtensionRange extends A1 implements A {
        private static final ExtensionRange DEFAULT_INSTANCE = null;
        public static final int END_FIELD_NUMBER = 2;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile z2 PARSER = null;
        public static final int START_FIELD_NUMBER = 1;
        private int bitField0_;
        private int end_;
        private byte memoizedIsInitialized;
        private DescriptorProtos.ExtensionRangeOptions options_;
        private int start_;

        static {
            ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange0 = new ExtensionRange();
            ExtensionRange.DEFAULT_INSTANCE = descriptorProtos$DescriptorProto$ExtensionRange0;
            A1.registerDefaultInstance(ExtensionRange.class, descriptorProtos$DescriptorProto$ExtensionRange0);
        }

        private ExtensionRange() {
            this.memoizedIsInitialized = 2;
        }

        public static void access$7000(ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange0, int v) {
            descriptorProtos$DescriptorProto$ExtensionRange0.setStart(v);
        }

        public static void access$7100(ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange0) {
            descriptorProtos$DescriptorProto$ExtensionRange0.clearStart();
        }

        public static void access$7200(ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange0, int v) {
            descriptorProtos$DescriptorProto$ExtensionRange0.setEnd(v);
        }

        public static void access$7300(ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange0) {
            descriptorProtos$DescriptorProto$ExtensionRange0.clearEnd();
        }

        public static void access$7400(ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange0, DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0) {
            descriptorProtos$DescriptorProto$ExtensionRange0.setOptions(descriptorProtos$ExtensionRangeOptions0);
        }

        public static void access$7500(ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange0, DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0) {
            descriptorProtos$DescriptorProto$ExtensionRange0.mergeOptions(descriptorProtos$ExtensionRangeOptions0);
        }

        public static void access$7600(ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange0) {
            descriptorProtos$DescriptorProto$ExtensionRange0.clearOptions();
        }

        private void clearEnd() {
            this.bitField0_ &= -3;
            this.end_ = 0;
        }

        private void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -5;
        }

        private void clearStart() {
            this.bitField0_ &= -2;
            this.start_ = 0;
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
                    return A1.newMessageInfo(ExtensionRange.DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001င\u0000\u0002င\u0001\u0003ᐉ\u0002", new Object[]{"bitField0_", "start_", "end_", "options_"});
                }
                case 3: {
                    return new ExtensionRange();
                }
                case 4: {
                    return new z(ExtensionRange.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
                }
                case 5: {
                    return ExtensionRange.DEFAULT_INSTANCE;
                }
                case 6: {
                    z2 z20 = ExtensionRange.PARSER;
                    if(z20 == null) {
                        Class class0 = ExtensionRange.class;
                        synchronized(class0) {
                            z2 z21 = ExtensionRange.PARSER;
                            if(z21 == null) {
                                z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                                ExtensionRange.PARSER = z21;
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

        public static ExtensionRange getDefaultInstance() {
            return ExtensionRange.DEFAULT_INSTANCE;
        }

        public int getEnd() {
            return this.end_;
        }

        public DescriptorProtos.ExtensionRangeOptions getOptions() {
            return this.options_ == null ? DescriptorProtos.ExtensionRangeOptions.getDefaultInstance() : this.options_;
        }

        public int getStart() {
            return this.start_;
        }

        public boolean hasEnd() {
            return (this.bitField0_ & 2) != 0;
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 4) != 0;
        }

        public boolean hasStart() {
            return (this.bitField0_ & 1) != 0;
        }

        private void mergeOptions(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0) {
            descriptorProtos$ExtensionRangeOptions0.getClass();
            if(this.options_ == null || this.options_ == DescriptorProtos.ExtensionRangeOptions.getDefaultInstance()) {
                this.options_ = descriptorProtos$ExtensionRangeOptions0;
            }
            else {
                O o0 = DescriptorProtos.ExtensionRangeOptions.newBuilder(this.options_);
                o0.f(descriptorProtos$ExtensionRangeOptions0);
                this.options_ = (DescriptorProtos.ExtensionRangeOptions)o0.i();
            }
            this.bitField0_ |= 4;
        }

        public static z newBuilder() {
            return (z)ExtensionRange.DEFAULT_INSTANCE.createBuilder();
        }

        public static z newBuilder(ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange0) {
            return (z)ExtensionRange.DEFAULT_INSTANCE.createBuilder(descriptorProtos$DescriptorProto$ExtensionRange0);
        }

        public static ExtensionRange parseDelimitedFrom(InputStream inputStream0) {
            return (ExtensionRange)A1.parseDelimitedFrom(ExtensionRange.DEFAULT_INSTANCE, inputStream0);
        }

        public static ExtensionRange parseDelimitedFrom(InputStream inputStream0, g1 g10) {
            return (ExtensionRange)A1.parseDelimitedFrom(ExtensionRange.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static ExtensionRange parseFrom(o o0) {
            return (ExtensionRange)A1.parseFrom(ExtensionRange.DEFAULT_INSTANCE, o0);
        }

        public static ExtensionRange parseFrom(o o0, g1 g10) {
            return (ExtensionRange)A1.parseFrom(ExtensionRange.DEFAULT_INSTANCE, o0, g10);
        }

        public static ExtensionRange parseFrom(t t0) {
            return (ExtensionRange)A1.parseFrom(ExtensionRange.DEFAULT_INSTANCE, t0);
        }

        public static ExtensionRange parseFrom(t t0, g1 g10) {
            return (ExtensionRange)A1.parseFrom(ExtensionRange.DEFAULT_INSTANCE, t0, g10);
        }

        public static ExtensionRange parseFrom(InputStream inputStream0) {
            return (ExtensionRange)A1.parseFrom(ExtensionRange.DEFAULT_INSTANCE, inputStream0);
        }

        public static ExtensionRange parseFrom(InputStream inputStream0, g1 g10) {
            return (ExtensionRange)A1.parseFrom(ExtensionRange.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static ExtensionRange parseFrom(ByteBuffer byteBuffer0) {
            return (ExtensionRange)A1.parseFrom(ExtensionRange.DEFAULT_INSTANCE, byteBuffer0);
        }

        public static ExtensionRange parseFrom(ByteBuffer byteBuffer0, g1 g10) {
            return (ExtensionRange)A1.parseFrom(ExtensionRange.DEFAULT_INSTANCE, byteBuffer0, g10);
        }

        public static ExtensionRange parseFrom(byte[] arr_b) {
            return (ExtensionRange)A1.parseFrom(ExtensionRange.DEFAULT_INSTANCE, arr_b);
        }

        public static ExtensionRange parseFrom(byte[] arr_b, g1 g10) {
            return (ExtensionRange)A1.parseFrom(ExtensionRange.DEFAULT_INSTANCE, arr_b, g10);
        }

        public static z2 parser() {
            return ExtensionRange.DEFAULT_INSTANCE.getParserForType();
        }

        private void setEnd(int v) {
            this.bitField0_ |= 2;
            this.end_ = v;
        }

        private void setOptions(DescriptorProtos.ExtensionRangeOptions descriptorProtos$ExtensionRangeOptions0) {
            descriptorProtos$ExtensionRangeOptions0.getClass();
            this.options_ = descriptorProtos$ExtensionRangeOptions0;
            this.bitField0_ |= 4;
        }

        private void setStart(int v) {
            this.bitField0_ |= 1;
            this.start_ = v;
        }
    }

    public static final class ReservedRange extends A1 implements C {
        private static final ReservedRange DEFAULT_INSTANCE = null;
        public static final int END_FIELD_NUMBER = 2;
        private static volatile z2 PARSER = null;
        public static final int START_FIELD_NUMBER = 1;
        private int bitField0_;
        private int end_;
        private int start_;

        static {
            ReservedRange descriptorProtos$DescriptorProto$ReservedRange0 = new ReservedRange();
            ReservedRange.DEFAULT_INSTANCE = descriptorProtos$DescriptorProto$ReservedRange0;
            A1.registerDefaultInstance(ReservedRange.class, descriptorProtos$DescriptorProto$ReservedRange0);
        }

        public static void access$7900(ReservedRange descriptorProtos$DescriptorProto$ReservedRange0, int v) {
            descriptorProtos$DescriptorProto$ReservedRange0.setStart(v);
        }

        public static void access$8000(ReservedRange descriptorProtos$DescriptorProto$ReservedRange0) {
            descriptorProtos$DescriptorProto$ReservedRange0.clearStart();
        }

        public static void access$8100(ReservedRange descriptorProtos$DescriptorProto$ReservedRange0, int v) {
            descriptorProtos$DescriptorProto$ReservedRange0.setEnd(v);
        }

        public static void access$8200(ReservedRange descriptorProtos$DescriptorProto$ReservedRange0) {
            descriptorProtos$DescriptorProto$ReservedRange0.clearEnd();
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
                    return A1.newMessageInfo(ReservedRange.DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"bitField0_", "start_", "end_"});
                }
                case 3: {
                    return new ReservedRange();
                }
                case 4: {
                    return new B(ReservedRange.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
                }
                case 5: {
                    return ReservedRange.DEFAULT_INSTANCE;
                }
                case 6: {
                    z2 z20 = ReservedRange.PARSER;
                    if(z20 == null) {
                        Class class0 = ReservedRange.class;
                        synchronized(class0) {
                            z2 z21 = ReservedRange.PARSER;
                            if(z21 == null) {
                                z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                                ReservedRange.PARSER = z21;
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

        public static ReservedRange getDefaultInstance() {
            return ReservedRange.DEFAULT_INSTANCE;
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

        public static B newBuilder() {
            return (B)ReservedRange.DEFAULT_INSTANCE.createBuilder();
        }

        public static B newBuilder(ReservedRange descriptorProtos$DescriptorProto$ReservedRange0) {
            return (B)ReservedRange.DEFAULT_INSTANCE.createBuilder(descriptorProtos$DescriptorProto$ReservedRange0);
        }

        public static ReservedRange parseDelimitedFrom(InputStream inputStream0) {
            return (ReservedRange)A1.parseDelimitedFrom(ReservedRange.DEFAULT_INSTANCE, inputStream0);
        }

        public static ReservedRange parseDelimitedFrom(InputStream inputStream0, g1 g10) {
            return (ReservedRange)A1.parseDelimitedFrom(ReservedRange.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static ReservedRange parseFrom(o o0) {
            return (ReservedRange)A1.parseFrom(ReservedRange.DEFAULT_INSTANCE, o0);
        }

        public static ReservedRange parseFrom(o o0, g1 g10) {
            return (ReservedRange)A1.parseFrom(ReservedRange.DEFAULT_INSTANCE, o0, g10);
        }

        public static ReservedRange parseFrom(t t0) {
            return (ReservedRange)A1.parseFrom(ReservedRange.DEFAULT_INSTANCE, t0);
        }

        public static ReservedRange parseFrom(t t0, g1 g10) {
            return (ReservedRange)A1.parseFrom(ReservedRange.DEFAULT_INSTANCE, t0, g10);
        }

        public static ReservedRange parseFrom(InputStream inputStream0) {
            return (ReservedRange)A1.parseFrom(ReservedRange.DEFAULT_INSTANCE, inputStream0);
        }

        public static ReservedRange parseFrom(InputStream inputStream0, g1 g10) {
            return (ReservedRange)A1.parseFrom(ReservedRange.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static ReservedRange parseFrom(ByteBuffer byteBuffer0) {
            return (ReservedRange)A1.parseFrom(ReservedRange.DEFAULT_INSTANCE, byteBuffer0);
        }

        public static ReservedRange parseFrom(ByteBuffer byteBuffer0, g1 g10) {
            return (ReservedRange)A1.parseFrom(ReservedRange.DEFAULT_INSTANCE, byteBuffer0, g10);
        }

        public static ReservedRange parseFrom(byte[] arr_b) {
            return (ReservedRange)A1.parseFrom(ReservedRange.DEFAULT_INSTANCE, arr_b);
        }

        public static ReservedRange parseFrom(byte[] arr_b, g1 g10) {
            return (ReservedRange)A1.parseFrom(ReservedRange.DEFAULT_INSTANCE, arr_b, g10);
        }

        public static z2 parser() {
            return ReservedRange.DEFAULT_INSTANCE.getParserForType();
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

    private static final DescriptorProtos.DescriptorProto DEFAULT_INSTANCE = null;
    public static final int ENUM_TYPE_FIELD_NUMBER = 4;
    public static final int EXTENSION_FIELD_NUMBER = 6;
    public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
    public static final int FIELD_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NESTED_TYPE_FIELD_NUMBER = 3;
    public static final int ONEOF_DECL_FIELD_NUMBER = 8;
    public static final int OPTIONS_FIELD_NUMBER = 7;
    private static volatile z2 PARSER = null;
    public static final int RESERVED_NAME_FIELD_NUMBER = 10;
    public static final int RESERVED_RANGE_FIELD_NUMBER = 9;
    public static final int VISIBILITY_FIELD_NUMBER = 11;
    private int bitField0_;
    private O1 enumType_;
    private O1 extensionRange_;
    private O1 extension_;
    private O1 field_;
    private byte memoizedIsInitialized;
    private String name_;
    private O1 nestedType_;
    private O1 oneofDecl_;
    private DescriptorProtos.MessageOptions options_;
    private O1 reservedName_;
    private O1 reservedRange_;
    private int visibility_;

    static {
        DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0 = new DescriptorProtos.DescriptorProto();
        DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE = descriptorProtos$DescriptorProto0;
        A1.registerDefaultInstance(DescriptorProtos.DescriptorProto.class, descriptorProtos$DescriptorProto0);
    }

    private DescriptorProtos.DescriptorProto() {
        this.memoizedIsInitialized = 2;
        this.name_ = "";
        this.field_ = A1.emptyProtobufList();
        this.extension_ = A1.emptyProtobufList();
        this.nestedType_ = A1.emptyProtobufList();
        this.enumType_ = A1.emptyProtobufList();
        this.extensionRange_ = A1.emptyProtobufList();
        this.oneofDecl_ = A1.emptyProtobufList();
        this.reservedRange_ = A1.emptyProtobufList();
        this.reservedName_ = A1.emptyProtobufList();
    }

    public static void access$10000(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v, DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto1) {
        descriptorProtos$DescriptorProto0.setNestedType(v, descriptorProtos$DescriptorProto1);
    }

    public static void access$10100(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto1) {
        descriptorProtos$DescriptorProto0.addNestedType(descriptorProtos$DescriptorProto1);
    }

    public static void access$10200(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v, DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto1) {
        descriptorProtos$DescriptorProto0.addNestedType(v, descriptorProtos$DescriptorProto1);
    }

    public static void access$10300(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, Iterable iterable0) {
        descriptorProtos$DescriptorProto0.addAllNestedType(iterable0);
    }

    public static void access$10400(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$DescriptorProto0.clearNestedType();
    }

    public static void access$10500(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v) {
        descriptorProtos$DescriptorProto0.removeNestedType(v);
    }

    public static void access$10600(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v, DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0) {
        descriptorProtos$DescriptorProto0.setEnumType(v, descriptorProtos$EnumDescriptorProto0);
    }

    public static void access$10700(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0) {
        descriptorProtos$DescriptorProto0.addEnumType(descriptorProtos$EnumDescriptorProto0);
    }

    public static void access$10800(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v, DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0) {
        descriptorProtos$DescriptorProto0.addEnumType(v, descriptorProtos$EnumDescriptorProto0);
    }

    public static void access$10900(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, Iterable iterable0) {
        descriptorProtos$DescriptorProto0.addAllEnumType(iterable0);
    }

    public static void access$11000(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$DescriptorProto0.clearEnumType();
    }

    public static void access$11100(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v) {
        descriptorProtos$DescriptorProto0.removeEnumType(v);
    }

    public static void access$11200(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v, ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange0) {
        descriptorProtos$DescriptorProto0.setExtensionRange(v, descriptorProtos$DescriptorProto$ExtensionRange0);
    }

    public static void access$11300(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange0) {
        descriptorProtos$DescriptorProto0.addExtensionRange(descriptorProtos$DescriptorProto$ExtensionRange0);
    }

    public static void access$11400(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v, ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange0) {
        descriptorProtos$DescriptorProto0.addExtensionRange(v, descriptorProtos$DescriptorProto$ExtensionRange0);
    }

    public static void access$11500(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, Iterable iterable0) {
        descriptorProtos$DescriptorProto0.addAllExtensionRange(iterable0);
    }

    public static void access$11600(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$DescriptorProto0.clearExtensionRange();
    }

    public static void access$11700(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v) {
        descriptorProtos$DescriptorProto0.removeExtensionRange(v);
    }

    public static void access$11800(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v, DescriptorProtos.OneofDescriptorProto descriptorProtos$OneofDescriptorProto0) {
        descriptorProtos$DescriptorProto0.setOneofDecl(v, descriptorProtos$OneofDescriptorProto0);
    }

    public static void access$11900(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, DescriptorProtos.OneofDescriptorProto descriptorProtos$OneofDescriptorProto0) {
        descriptorProtos$DescriptorProto0.addOneofDecl(descriptorProtos$OneofDescriptorProto0);
    }

    public static void access$12000(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v, DescriptorProtos.OneofDescriptorProto descriptorProtos$OneofDescriptorProto0) {
        descriptorProtos$DescriptorProto0.addOneofDecl(v, descriptorProtos$OneofDescriptorProto0);
    }

    public static void access$12100(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, Iterable iterable0) {
        descriptorProtos$DescriptorProto0.addAllOneofDecl(iterable0);
    }

    public static void access$12200(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$DescriptorProto0.clearOneofDecl();
    }

    public static void access$12300(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v) {
        descriptorProtos$DescriptorProto0.removeOneofDecl(v);
    }

    public static void access$12400(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0) {
        descriptorProtos$DescriptorProto0.setOptions(descriptorProtos$MessageOptions0);
    }

    public static void access$12500(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0) {
        descriptorProtos$DescriptorProto0.mergeOptions(descriptorProtos$MessageOptions0);
    }

    public static void access$12600(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$DescriptorProto0.clearOptions();
    }

    public static void access$12700(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v, ReservedRange descriptorProtos$DescriptorProto$ReservedRange0) {
        descriptorProtos$DescriptorProto0.setReservedRange(v, descriptorProtos$DescriptorProto$ReservedRange0);
    }

    public static void access$12800(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, ReservedRange descriptorProtos$DescriptorProto$ReservedRange0) {
        descriptorProtos$DescriptorProto0.addReservedRange(descriptorProtos$DescriptorProto$ReservedRange0);
    }

    public static void access$12900(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v, ReservedRange descriptorProtos$DescriptorProto$ReservedRange0) {
        descriptorProtos$DescriptorProto0.addReservedRange(v, descriptorProtos$DescriptorProto$ReservedRange0);
    }

    public static void access$13000(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, Iterable iterable0) {
        descriptorProtos$DescriptorProto0.addAllReservedRange(iterable0);
    }

    public static void access$13100(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$DescriptorProto0.clearReservedRange();
    }

    public static void access$13200(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v) {
        descriptorProtos$DescriptorProto0.removeReservedRange(v);
    }

    public static void access$13300(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v, String s) {
        descriptorProtos$DescriptorProto0.setReservedName(v, s);
    }

    public static void access$13400(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, String s) {
        descriptorProtos$DescriptorProto0.addReservedName(s);
    }

    public static void access$13500(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, Iterable iterable0) {
        descriptorProtos$DescriptorProto0.addAllReservedName(iterable0);
    }

    public static void access$13600(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$DescriptorProto0.clearReservedName();
    }

    public static void access$13700(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, o o0) {
        descriptorProtos$DescriptorProto0.addReservedNameBytes(o0);
    }

    public static void access$13800(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, R0 r00) {
        descriptorProtos$DescriptorProto0.setVisibility(r00);
    }

    public static void access$13900(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$DescriptorProto0.clearVisibility();
    }

    public static void access$8500(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, String s) {
        descriptorProtos$DescriptorProto0.setName(s);
    }

    public static void access$8600(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$DescriptorProto0.clearName();
    }

    public static void access$8700(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, o o0) {
        descriptorProtos$DescriptorProto0.setNameBytes(o0);
    }

    public static void access$8800(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v, DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$DescriptorProto0.setField(v, descriptorProtos$FieldDescriptorProto0);
    }

    public static void access$8900(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$DescriptorProto0.addField(descriptorProtos$FieldDescriptorProto0);
    }

    public static void access$9000(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v, DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$DescriptorProto0.addField(v, descriptorProtos$FieldDescriptorProto0);
    }

    public static void access$9100(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, Iterable iterable0) {
        descriptorProtos$DescriptorProto0.addAllField(iterable0);
    }

    public static void access$9200(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$DescriptorProto0.clearField();
    }

    public static void access$9300(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v) {
        descriptorProtos$DescriptorProto0.removeField(v);
    }

    public static void access$9400(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v, DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$DescriptorProto0.setExtension(v, descriptorProtos$FieldDescriptorProto0);
    }

    public static void access$9500(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$DescriptorProto0.addExtension(descriptorProtos$FieldDescriptorProto0);
    }

    public static void access$9600(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v, DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$DescriptorProto0.addExtension(v, descriptorProtos$FieldDescriptorProto0);
    }

    public static void access$9700(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, Iterable iterable0) {
        descriptorProtos$DescriptorProto0.addAllExtension(iterable0);
    }

    public static void access$9800(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$DescriptorProto0.clearExtension();
    }

    public static void access$9900(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0, int v) {
        descriptorProtos$DescriptorProto0.removeExtension(v);
    }

    private void addAllEnumType(Iterable iterable0) {
        this.ensureEnumTypeIsMutable();
        b.addAll(iterable0, this.enumType_);
    }

    private void addAllExtension(Iterable iterable0) {
        this.ensureExtensionIsMutable();
        b.addAll(iterable0, this.extension_);
    }

    private void addAllExtensionRange(Iterable iterable0) {
        this.ensureExtensionRangeIsMutable();
        b.addAll(iterable0, this.extensionRange_);
    }

    private void addAllField(Iterable iterable0) {
        this.ensureFieldIsMutable();
        b.addAll(iterable0, this.field_);
    }

    private void addAllNestedType(Iterable iterable0) {
        this.ensureNestedTypeIsMutable();
        b.addAll(iterable0, this.nestedType_);
    }

    private void addAllOneofDecl(Iterable iterable0) {
        this.ensureOneofDeclIsMutable();
        b.addAll(iterable0, this.oneofDecl_);
    }

    private void addAllReservedName(Iterable iterable0) {
        this.ensureReservedNameIsMutable();
        b.addAll(iterable0, this.reservedName_);
    }

    private void addAllReservedRange(Iterable iterable0) {
        this.ensureReservedRangeIsMutable();
        b.addAll(iterable0, this.reservedRange_);
    }

    private void addEnumType(int v, DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0) {
        descriptorProtos$EnumDescriptorProto0.getClass();
        this.ensureEnumTypeIsMutable();
        this.enumType_.add(v, descriptorProtos$EnumDescriptorProto0);
    }

    private void addEnumType(DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0) {
        descriptorProtos$EnumDescriptorProto0.getClass();
        this.ensureEnumTypeIsMutable();
        this.enumType_.add(descriptorProtos$EnumDescriptorProto0);
    }

    private void addExtension(int v, DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FieldDescriptorProto0.getClass();
        this.ensureExtensionIsMutable();
        this.extension_.add(v, descriptorProtos$FieldDescriptorProto0);
    }

    private void addExtension(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FieldDescriptorProto0.getClass();
        this.ensureExtensionIsMutable();
        this.extension_.add(descriptorProtos$FieldDescriptorProto0);
    }

    private void addExtensionRange(int v, ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange0) {
        descriptorProtos$DescriptorProto$ExtensionRange0.getClass();
        this.ensureExtensionRangeIsMutable();
        this.extensionRange_.add(v, descriptorProtos$DescriptorProto$ExtensionRange0);
    }

    private void addExtensionRange(ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange0) {
        descriptorProtos$DescriptorProto$ExtensionRange0.getClass();
        this.ensureExtensionRangeIsMutable();
        this.extensionRange_.add(descriptorProtos$DescriptorProto$ExtensionRange0);
    }

    private void addField(int v, DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FieldDescriptorProto0.getClass();
        this.ensureFieldIsMutable();
        this.field_.add(v, descriptorProtos$FieldDescriptorProto0);
    }

    private void addField(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FieldDescriptorProto0.getClass();
        this.ensureFieldIsMutable();
        this.field_.add(descriptorProtos$FieldDescriptorProto0);
    }

    private void addNestedType(int v, DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$DescriptorProto0.getClass();
        this.ensureNestedTypeIsMutable();
        this.nestedType_.add(v, descriptorProtos$DescriptorProto0);
    }

    private void addNestedType(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$DescriptorProto0.getClass();
        this.ensureNestedTypeIsMutable();
        this.nestedType_.add(descriptorProtos$DescriptorProto0);
    }

    private void addOneofDecl(int v, DescriptorProtos.OneofDescriptorProto descriptorProtos$OneofDescriptorProto0) {
        descriptorProtos$OneofDescriptorProto0.getClass();
        this.ensureOneofDeclIsMutable();
        this.oneofDecl_.add(v, descriptorProtos$OneofDescriptorProto0);
    }

    private void addOneofDecl(DescriptorProtos.OneofDescriptorProto descriptorProtos$OneofDescriptorProto0) {
        descriptorProtos$OneofDescriptorProto0.getClass();
        this.ensureOneofDeclIsMutable();
        this.oneofDecl_.add(descriptorProtos$OneofDescriptorProto0);
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

    private void addReservedRange(int v, ReservedRange descriptorProtos$DescriptorProto$ReservedRange0) {
        descriptorProtos$DescriptorProto$ReservedRange0.getClass();
        this.ensureReservedRangeIsMutable();
        this.reservedRange_.add(v, descriptorProtos$DescriptorProto$ReservedRange0);
    }

    private void addReservedRange(ReservedRange descriptorProtos$DescriptorProto$ReservedRange0) {
        descriptorProtos$DescriptorProto$ReservedRange0.getClass();
        this.ensureReservedRangeIsMutable();
        this.reservedRange_.add(descriptorProtos$DescriptorProto$ReservedRange0);
    }

    private void clearEnumType() {
        this.enumType_ = A1.emptyProtobufList();
    }

    private void clearExtension() {
        this.extension_ = A1.emptyProtobufList();
    }

    private void clearExtensionRange() {
        this.extensionRange_ = A1.emptyProtobufList();
    }

    private void clearField() {
        this.field_ = A1.emptyProtobufList();
    }

    private void clearName() {
        this.bitField0_ &= -2;
        this.name_ = "";
    }

    private void clearNestedType() {
        this.nestedType_ = A1.emptyProtobufList();
    }

    private void clearOneofDecl() {
        this.oneofDecl_ = A1.emptyProtobufList();
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

    private void clearVisibility() {
        this.bitField0_ &= -5;
        this.visibility_ = 0;
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
                return A1.newMessageInfo(DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE, "\u0001\u000B\u0000\u0001\u0001\u000B\u000B\u0000\b\u0007\u0001ဈ\u0000\u0002Л\u0003Л\u0004Л\u0005Л\u0006Л\u0007ᐉ\u0001\bЛ\t\u001B\n\u001A\u000B᠌\u0002", new Object[]{"bitField0_", "name_", "field_", DescriptorProtos.FieldDescriptorProto.class, "nestedType_", DescriptorProtos.DescriptorProto.class, "enumType_", DescriptorProtos.EnumDescriptorProto.class, "extensionRange_", ExtensionRange.class, "extension_", DescriptorProtos.FieldDescriptorProto.class, "options_", "oneofDecl_", DescriptorProtos.OneofDescriptorProto.class, "reservedRange_", ReservedRange.class, "reservedName_", "visibility_", E.s});
            }
            case 3: {
                return new DescriptorProtos.DescriptorProto();
            }
            case 4: {
                return new y(DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.DescriptorProto.PARSER;
                if(z20 == null) {
                    Class class0 = DescriptorProtos.DescriptorProto.class;
                    synchronized(class0) {
                        z2 z21 = DescriptorProtos.DescriptorProto.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.DescriptorProto.PARSER = z21;
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

    private void ensureEnumTypeIsMutable() {
        O1 o10 = this.enumType_;
        if(!((c)o10).a) {
            this.enumType_ = A1.mutableCopy(o10);
        }
    }

    private void ensureExtensionIsMutable() {
        O1 o10 = this.extension_;
        if(!((c)o10).a) {
            this.extension_ = A1.mutableCopy(o10);
        }
    }

    private void ensureExtensionRangeIsMutable() {
        O1 o10 = this.extensionRange_;
        if(!((c)o10).a) {
            this.extensionRange_ = A1.mutableCopy(o10);
        }
    }

    private void ensureFieldIsMutable() {
        O1 o10 = this.field_;
        if(!((c)o10).a) {
            this.field_ = A1.mutableCopy(o10);
        }
    }

    private void ensureNestedTypeIsMutable() {
        O1 o10 = this.nestedType_;
        if(!((c)o10).a) {
            this.nestedType_ = A1.mutableCopy(o10);
        }
    }

    private void ensureOneofDeclIsMutable() {
        O1 o10 = this.oneofDecl_;
        if(!((c)o10).a) {
            this.oneofDecl_ = A1.mutableCopy(o10);
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

    public static DescriptorProtos.DescriptorProto getDefaultInstance() {
        return DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE;
    }

    public DescriptorProtos.EnumDescriptorProto getEnumType(int v) {
        return (DescriptorProtos.EnumDescriptorProto)this.enumType_.get(v);
    }

    public int getEnumTypeCount() {
        return this.enumType_.size();
    }

    public List getEnumTypeList() {
        return this.enumType_;
    }

    public J getEnumTypeOrBuilder(int v) {
        return (J)this.enumType_.get(v);
    }

    public List getEnumTypeOrBuilderList() {
        return this.enumType_;
    }

    public DescriptorProtos.FieldDescriptorProto getExtension(int v) {
        return (DescriptorProtos.FieldDescriptorProto)this.extension_.get(v);
    }

    public int getExtensionCount() {
        return this.extension_.size();
    }

    public List getExtensionList() {
        return this.extension_;
    }

    public k0 getExtensionOrBuilder(int v) {
        return (k0)this.extension_.get(v);
    }

    public List getExtensionOrBuilderList() {
        return this.extension_;
    }

    public ExtensionRange getExtensionRange(int v) {
        return (ExtensionRange)this.extensionRange_.get(v);
    }

    public int getExtensionRangeCount() {
        return this.extensionRange_.size();
    }

    public List getExtensionRangeList() {
        return this.extensionRange_;
    }

    public A getExtensionRangeOrBuilder(int v) {
        return (A)this.extensionRange_.get(v);
    }

    public List getExtensionRangeOrBuilderList() {
        return this.extensionRange_;
    }

    public DescriptorProtos.FieldDescriptorProto getField(int v) {
        return (DescriptorProtos.FieldDescriptorProto)this.field_.get(v);
    }

    public int getFieldCount() {
        return this.field_.size();
    }

    public List getFieldList() {
        return this.field_;
    }

    public k0 getFieldOrBuilder(int v) {
        return (k0)this.field_.get(v);
    }

    public List getFieldOrBuilderList() {
        return this.field_;
    }

    public String getName() [...] // 潜在的解密器

    public o getNameBytes() {
        return o.e(this.name_);
    }

    public DescriptorProtos.DescriptorProto getNestedType(int v) {
        return (DescriptorProtos.DescriptorProto)this.nestedType_.get(v);
    }

    public int getNestedTypeCount() {
        return this.nestedType_.size();
    }

    public List getNestedTypeList() {
        return this.nestedType_;
    }

    public D getNestedTypeOrBuilder(int v) {
        return (D)this.nestedType_.get(v);
    }

    public List getNestedTypeOrBuilderList() {
        return this.nestedType_;
    }

    public DescriptorProtos.OneofDescriptorProto getOneofDecl(int v) {
        return (DescriptorProtos.OneofDescriptorProto)this.oneofDecl_.get(v);
    }

    public int getOneofDeclCount() {
        return this.oneofDecl_.size();
    }

    public List getOneofDeclList() {
        return this.oneofDecl_;
    }

    public J0 getOneofDeclOrBuilder(int v) {
        return (J0)this.oneofDecl_.get(v);
    }

    public List getOneofDeclOrBuilderList() {
        return this.oneofDecl_;
    }

    public DescriptorProtos.MessageOptions getOptions() {
        return this.options_ == null ? DescriptorProtos.MessageOptions.getDefaultInstance() : this.options_;
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

    public ReservedRange getReservedRange(int v) {
        return (ReservedRange)this.reservedRange_.get(v);
    }

    public int getReservedRangeCount() {
        return this.reservedRange_.size();
    }

    public List getReservedRangeList() {
        return this.reservedRange_;
    }

    public C getReservedRangeOrBuilder(int v) {
        return (C)this.reservedRange_.get(v);
    }

    public List getReservedRangeOrBuilderList() {
        return this.reservedRange_;
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

    private void mergeOptions(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0) {
        descriptorProtos$MessageOptions0.getClass();
        if(this.options_ == null || this.options_ == DescriptorProtos.MessageOptions.getDefaultInstance()) {
            this.options_ = descriptorProtos$MessageOptions0;
        }
        else {
            D0 d00 = DescriptorProtos.MessageOptions.newBuilder(this.options_);
            d00.f(descriptorProtos$MessageOptions0);
            this.options_ = (DescriptorProtos.MessageOptions)d00.i();
        }
        this.bitField0_ |= 2;
    }

    public static y newBuilder() {
        return (y)DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE.createBuilder();
    }

    public static y newBuilder(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        return (y)DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE.createBuilder(descriptorProtos$DescriptorProto0);
    }

    public static DescriptorProtos.DescriptorProto parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.DescriptorProto)A1.parseDelimitedFrom(DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.DescriptorProto parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.DescriptorProto)A1.parseDelimitedFrom(DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.DescriptorProto parseFrom(o o0) {
        return (DescriptorProtos.DescriptorProto)A1.parseFrom(DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.DescriptorProto parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.DescriptorProto)A1.parseFrom(DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.DescriptorProto parseFrom(t t0) {
        return (DescriptorProtos.DescriptorProto)A1.parseFrom(DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.DescriptorProto parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.DescriptorProto)A1.parseFrom(DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.DescriptorProto parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.DescriptorProto)A1.parseFrom(DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.DescriptorProto parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.DescriptorProto)A1.parseFrom(DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.DescriptorProto parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.DescriptorProto)A1.parseFrom(DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.DescriptorProto parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.DescriptorProto)A1.parseFrom(DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.DescriptorProto parseFrom(byte[] arr_b) {
        return (DescriptorProtos.DescriptorProto)A1.parseFrom(DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.DescriptorProto parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.DescriptorProto)A1.parseFrom(DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.DescriptorProto.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeEnumType(int v) {
        this.ensureEnumTypeIsMutable();
        this.enumType_.remove(v);
    }

    private void removeExtension(int v) {
        this.ensureExtensionIsMutable();
        this.extension_.remove(v);
    }

    private void removeExtensionRange(int v) {
        this.ensureExtensionRangeIsMutable();
        this.extensionRange_.remove(v);
    }

    private void removeField(int v) {
        this.ensureFieldIsMutable();
        this.field_.remove(v);
    }

    private void removeNestedType(int v) {
        this.ensureNestedTypeIsMutable();
        this.nestedType_.remove(v);
    }

    private void removeOneofDecl(int v) {
        this.ensureOneofDeclIsMutable();
        this.oneofDecl_.remove(v);
    }

    private void removeReservedRange(int v) {
        this.ensureReservedRangeIsMutable();
        this.reservedRange_.remove(v);
    }

    private void setEnumType(int v, DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0) {
        descriptorProtos$EnumDescriptorProto0.getClass();
        this.ensureEnumTypeIsMutable();
        this.enumType_.set(v, descriptorProtos$EnumDescriptorProto0);
    }

    private void setExtension(int v, DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FieldDescriptorProto0.getClass();
        this.ensureExtensionIsMutable();
        this.extension_.set(v, descriptorProtos$FieldDescriptorProto0);
    }

    private void setExtensionRange(int v, ExtensionRange descriptorProtos$DescriptorProto$ExtensionRange0) {
        descriptorProtos$DescriptorProto$ExtensionRange0.getClass();
        this.ensureExtensionRangeIsMutable();
        this.extensionRange_.set(v, descriptorProtos$DescriptorProto$ExtensionRange0);
    }

    private void setField(int v, DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FieldDescriptorProto0.getClass();
        this.ensureFieldIsMutable();
        this.field_.set(v, descriptorProtos$FieldDescriptorProto0);
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

    private void setNestedType(int v, DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$DescriptorProto0.getClass();
        this.ensureNestedTypeIsMutable();
        this.nestedType_.set(v, descriptorProtos$DescriptorProto0);
    }

    private void setOneofDecl(int v, DescriptorProtos.OneofDescriptorProto descriptorProtos$OneofDescriptorProto0) {
        descriptorProtos$OneofDescriptorProto0.getClass();
        this.ensureOneofDeclIsMutable();
        this.oneofDecl_.set(v, descriptorProtos$OneofDescriptorProto0);
    }

    private void setOptions(DescriptorProtos.MessageOptions descriptorProtos$MessageOptions0) {
        descriptorProtos$MessageOptions0.getClass();
        this.options_ = descriptorProtos$MessageOptions0;
        this.bitField0_ |= 2;
    }

    private void setReservedName(int v, String s) {
        s.getClass();
        this.ensureReservedNameIsMutable();
        this.reservedName_.set(v, s);
    }

    private void setReservedRange(int v, ReservedRange descriptorProtos$DescriptorProto$ReservedRange0) {
        descriptorProtos$DescriptorProto$ReservedRange0.getClass();
        this.ensureReservedRangeIsMutable();
        this.reservedRange_.set(v, descriptorProtos$DescriptorProto$ReservedRange0);
    }

    private void setVisibility(R0 r00) {
        this.visibility_ = r00.a;
        this.bitField0_ |= 4;
    }
}

