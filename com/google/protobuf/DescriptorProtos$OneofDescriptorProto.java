package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DescriptorProtos.OneofDescriptorProto extends A1 implements J0 {
    private static final DescriptorProtos.OneofDescriptorProto DEFAULT_INSTANCE = null;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 2;
    private static volatile z2 PARSER;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private String name_;
    private DescriptorProtos.OneofOptions options_;

    static {
        DescriptorProtos.OneofDescriptorProto descriptorProtos$OneofDescriptorProto0 = new DescriptorProtos.OneofDescriptorProto();
        DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE = descriptorProtos$OneofDescriptorProto0;
        A1.registerDefaultInstance(DescriptorProtos.OneofDescriptorProto.class, descriptorProtos$OneofDescriptorProto0);
    }

    private DescriptorProtos.OneofDescriptorProto() {
        this.memoizedIsInitialized = 2;
        this.name_ = "";
    }

    public static void access$20500(DescriptorProtos.OneofDescriptorProto descriptorProtos$OneofDescriptorProto0, String s) {
        descriptorProtos$OneofDescriptorProto0.setName(s);
    }

    public static void access$20600(DescriptorProtos.OneofDescriptorProto descriptorProtos$OneofDescriptorProto0) {
        descriptorProtos$OneofDescriptorProto0.clearName();
    }

    public static void access$20700(DescriptorProtos.OneofDescriptorProto descriptorProtos$OneofDescriptorProto0, o o0) {
        descriptorProtos$OneofDescriptorProto0.setNameBytes(o0);
    }

    public static void access$20800(DescriptorProtos.OneofDescriptorProto descriptorProtos$OneofDescriptorProto0, DescriptorProtos.OneofOptions descriptorProtos$OneofOptions0) {
        descriptorProtos$OneofDescriptorProto0.setOptions(descriptorProtos$OneofOptions0);
    }

    public static void access$20900(DescriptorProtos.OneofDescriptorProto descriptorProtos$OneofDescriptorProto0, DescriptorProtos.OneofOptions descriptorProtos$OneofOptions0) {
        descriptorProtos$OneofDescriptorProto0.mergeOptions(descriptorProtos$OneofOptions0);
    }

    public static void access$21000(DescriptorProtos.OneofDescriptorProto descriptorProtos$OneofDescriptorProto0) {
        descriptorProtos$OneofDescriptorProto0.clearOptions();
    }

    private void clearName() {
        this.bitField0_ &= -2;
        this.name_ = "";
    }

    private void clearOptions() {
        this.options_ = null;
        this.bitField0_ &= -3;
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
                return A1.newMessageInfo(DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ဈ\u0000\u0002ᐉ\u0001", new Object[]{"bitField0_", "name_", "options_"});
            }
            case 3: {
                return new DescriptorProtos.OneofDescriptorProto();
            }
            case 4: {
                return new I0(DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.OneofDescriptorProto.PARSER;
                if(z20 == null) {
                    Class class0 = DescriptorProtos.OneofDescriptorProto.class;
                    synchronized(class0) {
                        z2 z21 = DescriptorProtos.OneofDescriptorProto.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.OneofDescriptorProto.PARSER = z21;
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

    public static DescriptorProtos.OneofDescriptorProto getDefaultInstance() {
        return DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE;
    }

    public String getName() [...] // 潜在的解密器

    public o getNameBytes() {
        return o.e(this.name_);
    }

    public DescriptorProtos.OneofOptions getOptions() {
        return this.options_ == null ? DescriptorProtos.OneofOptions.getDefaultInstance() : this.options_;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasOptions() {
        return (this.bitField0_ & 2) != 0;
    }

    private void mergeOptions(DescriptorProtos.OneofOptions descriptorProtos$OneofOptions0) {
        descriptorProtos$OneofOptions0.getClass();
        if(this.options_ == null || this.options_ == DescriptorProtos.OneofOptions.getDefaultInstance()) {
            this.options_ = descriptorProtos$OneofOptions0;
        }
        else {
            K0 k00 = DescriptorProtos.OneofOptions.newBuilder(this.options_);
            k00.f(descriptorProtos$OneofOptions0);
            this.options_ = (DescriptorProtos.OneofOptions)k00.i();
        }
        this.bitField0_ |= 2;
    }

    public static I0 newBuilder() {
        return (I0)DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE.createBuilder();
    }

    public static I0 newBuilder(DescriptorProtos.OneofDescriptorProto descriptorProtos$OneofDescriptorProto0) {
        return (I0)DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE.createBuilder(descriptorProtos$OneofDescriptorProto0);
    }

    public static DescriptorProtos.OneofDescriptorProto parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.OneofDescriptorProto)A1.parseDelimitedFrom(DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.OneofDescriptorProto parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.OneofDescriptorProto)A1.parseDelimitedFrom(DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.OneofDescriptorProto parseFrom(o o0) {
        return (DescriptorProtos.OneofDescriptorProto)A1.parseFrom(DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.OneofDescriptorProto parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.OneofDescriptorProto)A1.parseFrom(DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.OneofDescriptorProto parseFrom(t t0) {
        return (DescriptorProtos.OneofDescriptorProto)A1.parseFrom(DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.OneofDescriptorProto parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.OneofDescriptorProto)A1.parseFrom(DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.OneofDescriptorProto parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.OneofDescriptorProto)A1.parseFrom(DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.OneofDescriptorProto parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.OneofDescriptorProto)A1.parseFrom(DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.OneofDescriptorProto parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.OneofDescriptorProto)A1.parseFrom(DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.OneofDescriptorProto parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.OneofDescriptorProto)A1.parseFrom(DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.OneofDescriptorProto parseFrom(byte[] arr_b) {
        return (DescriptorProtos.OneofDescriptorProto)A1.parseFrom(DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.OneofDescriptorProto parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.OneofDescriptorProto)A1.parseFrom(DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.OneofDescriptorProto.DEFAULT_INSTANCE.getParserForType();
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

    private void setOptions(DescriptorProtos.OneofOptions descriptorProtos$OneofOptions0) {
        descriptorProtos$OneofOptions0.getClass();
        this.options_ = descriptorProtos$OneofOptions0;
        this.bitField0_ |= 2;
    }
}

