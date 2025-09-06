package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DescriptorProtos.EnumValueDescriptorProto extends A1 implements M {
    private static final DescriptorProtos.EnumValueDescriptorProto DEFAULT_INSTANCE = null;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile z2 PARSER;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private String name_;
    private int number_;
    private DescriptorProtos.EnumValueOptions options_;

    static {
        DescriptorProtos.EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto0 = new DescriptorProtos.EnumValueDescriptorProto();
        DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE = descriptorProtos$EnumValueDescriptorProto0;
        A1.registerDefaultInstance(DescriptorProtos.EnumValueDescriptorProto.class, descriptorProtos$EnumValueDescriptorProto0);
    }

    private DescriptorProtos.EnumValueDescriptorProto() {
        this.memoizedIsInitialized = 2;
        this.name_ = "";
    }

    public static void access$24600(DescriptorProtos.EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto0, String s) {
        descriptorProtos$EnumValueDescriptorProto0.setName(s);
    }

    public static void access$24700(DescriptorProtos.EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto0) {
        descriptorProtos$EnumValueDescriptorProto0.clearName();
    }

    public static void access$24800(DescriptorProtos.EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto0, o o0) {
        descriptorProtos$EnumValueDescriptorProto0.setNameBytes(o0);
    }

    public static void access$24900(DescriptorProtos.EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto0, int v) {
        descriptorProtos$EnumValueDescriptorProto0.setNumber(v);
    }

    public static void access$25000(DescriptorProtos.EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto0) {
        descriptorProtos$EnumValueDescriptorProto0.clearNumber();
    }

    public static void access$25100(DescriptorProtos.EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto0, DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0) {
        descriptorProtos$EnumValueDescriptorProto0.setOptions(descriptorProtos$EnumValueOptions0);
    }

    public static void access$25200(DescriptorProtos.EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto0, DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0) {
        descriptorProtos$EnumValueDescriptorProto0.mergeOptions(descriptorProtos$EnumValueOptions0);
    }

    public static void access$25300(DescriptorProtos.EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto0) {
        descriptorProtos$EnumValueDescriptorProto0.clearOptions();
    }

    private void clearName() {
        this.bitField0_ &= -2;
        this.name_ = "";
    }

    private void clearNumber() {
        this.bitField0_ &= -3;
        this.number_ = 0;
    }

    private void clearOptions() {
        this.options_ = null;
        this.bitField0_ &= -5;
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
                return A1.newMessageInfo(DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ဈ\u0000\u0002င\u0001\u0003ᐉ\u0002", new Object[]{"bitField0_", "name_", "number_", "options_"});
            }
            case 3: {
                return new DescriptorProtos.EnumValueDescriptorProto();
            }
            case 4: {
                return new L(DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.EnumValueDescriptorProto.PARSER;
                if(z20 == null) {
                    Class class0 = DescriptorProtos.EnumValueDescriptorProto.class;
                    synchronized(class0) {
                        z2 z21 = DescriptorProtos.EnumValueDescriptorProto.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.EnumValueDescriptorProto.PARSER = z21;
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

    public static DescriptorProtos.EnumValueDescriptorProto getDefaultInstance() {
        return DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE;
    }

    public String getName() [...] // 潜在的解密器

    public o getNameBytes() {
        return o.e(this.name_);
    }

    public int getNumber() {
        return this.number_;
    }

    public DescriptorProtos.EnumValueOptions getOptions() {
        return this.options_ == null ? DescriptorProtos.EnumValueOptions.getDefaultInstance() : this.options_;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasNumber() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasOptions() {
        return (this.bitField0_ & 4) != 0;
    }

    private void mergeOptions(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0) {
        descriptorProtos$EnumValueOptions0.getClass();
        if(this.options_ == null || this.options_ == DescriptorProtos.EnumValueOptions.getDefaultInstance()) {
            this.options_ = descriptorProtos$EnumValueOptions0;
        }
        else {
            N n0 = DescriptorProtos.EnumValueOptions.newBuilder(this.options_);
            n0.f(descriptorProtos$EnumValueOptions0);
            this.options_ = (DescriptorProtos.EnumValueOptions)n0.i();
        }
        this.bitField0_ |= 4;
    }

    public static L newBuilder() {
        return (L)DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE.createBuilder();
    }

    public static L newBuilder(DescriptorProtos.EnumValueDescriptorProto descriptorProtos$EnumValueDescriptorProto0) {
        return (L)DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE.createBuilder(descriptorProtos$EnumValueDescriptorProto0);
    }

    public static DescriptorProtos.EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.EnumValueDescriptorProto)A1.parseDelimitedFrom(DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.EnumValueDescriptorProto)A1.parseDelimitedFrom(DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.EnumValueDescriptorProto parseFrom(o o0) {
        return (DescriptorProtos.EnumValueDescriptorProto)A1.parseFrom(DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.EnumValueDescriptorProto parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.EnumValueDescriptorProto)A1.parseFrom(DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.EnumValueDescriptorProto parseFrom(t t0) {
        return (DescriptorProtos.EnumValueDescriptorProto)A1.parseFrom(DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.EnumValueDescriptorProto parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.EnumValueDescriptorProto)A1.parseFrom(DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.EnumValueDescriptorProto parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.EnumValueDescriptorProto)A1.parseFrom(DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.EnumValueDescriptorProto parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.EnumValueDescriptorProto)A1.parseFrom(DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.EnumValueDescriptorProto parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.EnumValueDescriptorProto)A1.parseFrom(DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.EnumValueDescriptorProto parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.EnumValueDescriptorProto)A1.parseFrom(DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.EnumValueDescriptorProto parseFrom(byte[] arr_b) {
        return (DescriptorProtos.EnumValueDescriptorProto)A1.parseFrom(DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.EnumValueDescriptorProto parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.EnumValueDescriptorProto)A1.parseFrom(DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.EnumValueDescriptorProto.DEFAULT_INSTANCE.getParserForType();
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

    private void setNumber(int v) {
        this.bitField0_ |= 2;
        this.number_ = v;
    }

    private void setOptions(DescriptorProtos.EnumValueOptions descriptorProtos$EnumValueOptions0) {
        descriptorProtos$EnumValueOptions0.getClass();
        this.options_ = descriptorProtos$EnumValueOptions0;
        this.bitField0_ |= 4;
    }
}

