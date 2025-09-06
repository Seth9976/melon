package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DescriptorProtos.MethodDescriptorProto extends A1 implements F0 {
    public static final int CLIENT_STREAMING_FIELD_NUMBER = 5;
    private static final DescriptorProtos.MethodDescriptorProto DEFAULT_INSTANCE = null;
    public static final int INPUT_TYPE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
    private static volatile z2 PARSER = null;
    public static final int SERVER_STREAMING_FIELD_NUMBER = 6;
    private int bitField0_;
    private boolean clientStreaming_;
    private String inputType_;
    private byte memoizedIsInitialized;
    private String name_;
    private DescriptorProtos.MethodOptions options_;
    private String outputType_;
    private boolean serverStreaming_;

    static {
        DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0 = new DescriptorProtos.MethodDescriptorProto();
        DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE = descriptorProtos$MethodDescriptorProto0;
        A1.registerDefaultInstance(DescriptorProtos.MethodDescriptorProto.class, descriptorProtos$MethodDescriptorProto0);
    }

    private DescriptorProtos.MethodDescriptorProto() {
        this.memoizedIsInitialized = 2;
        this.name_ = "";
        this.inputType_ = "";
        this.outputType_ = "";
    }

    public static void access$27000(DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0, String s) {
        descriptorProtos$MethodDescriptorProto0.setName(s);
    }

    public static void access$27100(DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0) {
        descriptorProtos$MethodDescriptorProto0.clearName();
    }

    public static void access$27200(DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0, o o0) {
        descriptorProtos$MethodDescriptorProto0.setNameBytes(o0);
    }

    public static void access$27300(DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0, String s) {
        descriptorProtos$MethodDescriptorProto0.setInputType(s);
    }

    public static void access$27400(DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0) {
        descriptorProtos$MethodDescriptorProto0.clearInputType();
    }

    public static void access$27500(DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0, o o0) {
        descriptorProtos$MethodDescriptorProto0.setInputTypeBytes(o0);
    }

    public static void access$27600(DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0, String s) {
        descriptorProtos$MethodDescriptorProto0.setOutputType(s);
    }

    public static void access$27700(DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0) {
        descriptorProtos$MethodDescriptorProto0.clearOutputType();
    }

    public static void access$27800(DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0, o o0) {
        descriptorProtos$MethodDescriptorProto0.setOutputTypeBytes(o0);
    }

    public static void access$27900(DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0, DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0) {
        descriptorProtos$MethodDescriptorProto0.setOptions(descriptorProtos$MethodOptions0);
    }

    public static void access$28000(DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0, DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0) {
        descriptorProtos$MethodDescriptorProto0.mergeOptions(descriptorProtos$MethodOptions0);
    }

    public static void access$28100(DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0) {
        descriptorProtos$MethodDescriptorProto0.clearOptions();
    }

    public static void access$28200(DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0, boolean z) {
        descriptorProtos$MethodDescriptorProto0.setClientStreaming(z);
    }

    public static void access$28300(DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0) {
        descriptorProtos$MethodDescriptorProto0.clearClientStreaming();
    }

    public static void access$28400(DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0, boolean z) {
        descriptorProtos$MethodDescriptorProto0.setServerStreaming(z);
    }

    public static void access$28500(DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0) {
        descriptorProtos$MethodDescriptorProto0.clearServerStreaming();
    }

    private void clearClientStreaming() {
        this.bitField0_ &= -17;
        this.clientStreaming_ = false;
    }

    private void clearInputType() {
        this.bitField0_ &= -3;
        this.inputType_ = "";
    }

    private void clearName() {
        this.bitField0_ &= -2;
        this.name_ = "";
    }

    private void clearOptions() {
        this.options_ = null;
        this.bitField0_ &= -9;
    }

    private void clearOutputType() {
        this.bitField0_ &= -5;
        this.outputType_ = "";
    }

    private void clearServerStreaming() {
        this.bitField0_ &= -33;
        this.serverStreaming_ = false;
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
                return A1.newMessageInfo(DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ᐉ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"bitField0_", "name_", "inputType_", "outputType_", "options_", "clientStreaming_", "serverStreaming_"});
            }
            case 3: {
                return new DescriptorProtos.MethodDescriptorProto();
            }
            case 4: {
                return new E0(DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.MethodDescriptorProto.PARSER;
                if(z20 == null) {
                    synchronized(DescriptorProtos.MethodDescriptorProto.class) {
                        z21 = DescriptorProtos.MethodDescriptorProto.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.MethodDescriptorProto.PARSER = z21;
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

    public boolean getClientStreaming() {
        return this.clientStreaming_;
    }

    public static DescriptorProtos.MethodDescriptorProto getDefaultInstance() {
        return DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE;
    }

    public String getInputType() [...] // 潜在的解密器

    public o getInputTypeBytes() {
        return o.e(this.inputType_);
    }

    public String getName() [...] // 潜在的解密器

    public o getNameBytes() {
        return o.e(this.name_);
    }

    public DescriptorProtos.MethodOptions getOptions() {
        return this.options_ == null ? DescriptorProtos.MethodOptions.getDefaultInstance() : this.options_;
    }

    public String getOutputType() [...] // 潜在的解密器

    public o getOutputTypeBytes() {
        return o.e(this.outputType_);
    }

    public boolean getServerStreaming() {
        return this.serverStreaming_;
    }

    public boolean hasClientStreaming() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasInputType() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasOptions() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasOutputType() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasServerStreaming() {
        return (this.bitField0_ & 0x20) != 0;
    }

    private void mergeOptions(DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0) {
        descriptorProtos$MethodOptions0.getClass();
        if(this.options_ == null || this.options_ == DescriptorProtos.MethodOptions.getDefaultInstance()) {
            this.options_ = descriptorProtos$MethodOptions0;
        }
        else {
            G0 g00 = DescriptorProtos.MethodOptions.newBuilder(this.options_);
            g00.f(descriptorProtos$MethodOptions0);
            this.options_ = (DescriptorProtos.MethodOptions)g00.i();
        }
        this.bitField0_ |= 8;
    }

    public static E0 newBuilder() {
        return (E0)DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE.createBuilder();
    }

    public static E0 newBuilder(DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0) {
        return (E0)DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE.createBuilder(descriptorProtos$MethodDescriptorProto0);
    }

    public static DescriptorProtos.MethodDescriptorProto parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.MethodDescriptorProto)A1.parseDelimitedFrom(DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.MethodDescriptorProto parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.MethodDescriptorProto)A1.parseDelimitedFrom(DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.MethodDescriptorProto parseFrom(o o0) {
        return (DescriptorProtos.MethodDescriptorProto)A1.parseFrom(DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.MethodDescriptorProto parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.MethodDescriptorProto)A1.parseFrom(DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.MethodDescriptorProto parseFrom(t t0) {
        return (DescriptorProtos.MethodDescriptorProto)A1.parseFrom(DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.MethodDescriptorProto parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.MethodDescriptorProto)A1.parseFrom(DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.MethodDescriptorProto parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.MethodDescriptorProto)A1.parseFrom(DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.MethodDescriptorProto parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.MethodDescriptorProto)A1.parseFrom(DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.MethodDescriptorProto parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.MethodDescriptorProto)A1.parseFrom(DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.MethodDescriptorProto parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.MethodDescriptorProto)A1.parseFrom(DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.MethodDescriptorProto parseFrom(byte[] arr_b) {
        return (DescriptorProtos.MethodDescriptorProto)A1.parseFrom(DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.MethodDescriptorProto parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.MethodDescriptorProto)A1.parseFrom(DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.MethodDescriptorProto.DEFAULT_INSTANCE.getParserForType();
    }

    private void setClientStreaming(boolean z) {
        this.bitField0_ |= 16;
        this.clientStreaming_ = z;
    }

    private void setInputType(String s) {
        s.getClass();
        this.bitField0_ |= 2;
        this.inputType_ = s;
    }

    private void setInputTypeBytes(o o0) {
        this.inputType_ = o0.p();
        this.bitField0_ |= 2;
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

    private void setOptions(DescriptorProtos.MethodOptions descriptorProtos$MethodOptions0) {
        descriptorProtos$MethodOptions0.getClass();
        this.options_ = descriptorProtos$MethodOptions0;
        this.bitField0_ |= 8;
    }

    private void setOutputType(String s) {
        s.getClass();
        this.bitField0_ |= 4;
        this.outputType_ = s;
    }

    private void setOutputTypeBytes(o o0) {
        this.outputType_ = o0.p();
        this.bitField0_ |= 4;
    }

    private void setServerStreaming(boolean z) {
        this.bitField0_ |= 0x20;
        this.serverStreaming_ = z;
    }
}

