package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos.ServiceDescriptorProto extends A1 implements M0 {
    private static final DescriptorProtos.ServiceDescriptorProto DEFAULT_INSTANCE = null;
    public static final int METHOD_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile z2 PARSER;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private O1 method_;
    private String name_;
    private DescriptorProtos.ServiceOptions options_;

    static {
        DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0 = new DescriptorProtos.ServiceDescriptorProto();
        DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE = descriptorProtos$ServiceDescriptorProto0;
        A1.registerDefaultInstance(DescriptorProtos.ServiceDescriptorProto.class, descriptorProtos$ServiceDescriptorProto0);
    }

    private DescriptorProtos.ServiceDescriptorProto() {
        this.memoizedIsInitialized = 2;
        this.name_ = "";
        this.method_ = A1.emptyProtobufList();
    }

    public static void access$25600(DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0, String s) {
        descriptorProtos$ServiceDescriptorProto0.setName(s);
    }

    public static void access$25700(DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0) {
        descriptorProtos$ServiceDescriptorProto0.clearName();
    }

    public static void access$25800(DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0, o o0) {
        descriptorProtos$ServiceDescriptorProto0.setNameBytes(o0);
    }

    public static void access$25900(DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0, int v, DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0) {
        descriptorProtos$ServiceDescriptorProto0.setMethod(v, descriptorProtos$MethodDescriptorProto0);
    }

    public static void access$26000(DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0, DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0) {
        descriptorProtos$ServiceDescriptorProto0.addMethod(descriptorProtos$MethodDescriptorProto0);
    }

    public static void access$26100(DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0, int v, DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0) {
        descriptorProtos$ServiceDescriptorProto0.addMethod(v, descriptorProtos$MethodDescriptorProto0);
    }

    public static void access$26200(DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0, Iterable iterable0) {
        descriptorProtos$ServiceDescriptorProto0.addAllMethod(iterable0);
    }

    public static void access$26300(DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0) {
        descriptorProtos$ServiceDescriptorProto0.clearMethod();
    }

    public static void access$26400(DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0, int v) {
        descriptorProtos$ServiceDescriptorProto0.removeMethod(v);
    }

    public static void access$26500(DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0, DescriptorProtos.ServiceOptions descriptorProtos$ServiceOptions0) {
        descriptorProtos$ServiceDescriptorProto0.setOptions(descriptorProtos$ServiceOptions0);
    }

    public static void access$26600(DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0, DescriptorProtos.ServiceOptions descriptorProtos$ServiceOptions0) {
        descriptorProtos$ServiceDescriptorProto0.mergeOptions(descriptorProtos$ServiceOptions0);
    }

    public static void access$26700(DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0) {
        descriptorProtos$ServiceDescriptorProto0.clearOptions();
    }

    private void addAllMethod(Iterable iterable0) {
        this.ensureMethodIsMutable();
        b.addAll(iterable0, this.method_);
    }

    private void addMethod(int v, DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0) {
        descriptorProtos$MethodDescriptorProto0.getClass();
        this.ensureMethodIsMutable();
        this.method_.add(v, descriptorProtos$MethodDescriptorProto0);
    }

    private void addMethod(DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0) {
        descriptorProtos$MethodDescriptorProto0.getClass();
        this.ensureMethodIsMutable();
        this.method_.add(descriptorProtos$MethodDescriptorProto0);
    }

    private void clearMethod() {
        this.method_ = A1.emptyProtobufList();
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
                return A1.newMessageInfo(DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001ဈ\u0000\u0002Л\u0003ᐉ\u0001", new Object[]{"bitField0_", "name_", "method_", DescriptorProtos.MethodDescriptorProto.class, "options_"});
            }
            case 3: {
                return new DescriptorProtos.ServiceDescriptorProto();
            }
            case 4: {
                return new L0(DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.ServiceDescriptorProto.PARSER;
                if(z20 == null) {
                    Class class0 = DescriptorProtos.ServiceDescriptorProto.class;
                    synchronized(class0) {
                        z2 z21 = DescriptorProtos.ServiceDescriptorProto.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.ServiceDescriptorProto.PARSER = z21;
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

    private void ensureMethodIsMutable() {
        O1 o10 = this.method_;
        if(!((c)o10).a) {
            this.method_ = A1.mutableCopy(o10);
        }
    }

    public static DescriptorProtos.ServiceDescriptorProto getDefaultInstance() {
        return DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE;
    }

    public DescriptorProtos.MethodDescriptorProto getMethod(int v) {
        return (DescriptorProtos.MethodDescriptorProto)this.method_.get(v);
    }

    public int getMethodCount() {
        return this.method_.size();
    }

    public List getMethodList() {
        return this.method_;
    }

    public F0 getMethodOrBuilder(int v) {
        return (F0)this.method_.get(v);
    }

    public List getMethodOrBuilderList() {
        return this.method_;
    }

    public String getName() [...] // 潜在的解密器

    public o getNameBytes() {
        return o.e(this.name_);
    }

    public DescriptorProtos.ServiceOptions getOptions() {
        return this.options_ == null ? DescriptorProtos.ServiceOptions.getDefaultInstance() : this.options_;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasOptions() {
        return (this.bitField0_ & 2) != 0;
    }

    private void mergeOptions(DescriptorProtos.ServiceOptions descriptorProtos$ServiceOptions0) {
        descriptorProtos$ServiceOptions0.getClass();
        if(this.options_ == null || this.options_ == DescriptorProtos.ServiceOptions.getDefaultInstance()) {
            this.options_ = descriptorProtos$ServiceOptions0;
        }
        else {
            N0 n00 = DescriptorProtos.ServiceOptions.newBuilder(this.options_);
            n00.f(descriptorProtos$ServiceOptions0);
            this.options_ = (DescriptorProtos.ServiceOptions)n00.i();
        }
        this.bitField0_ |= 2;
    }

    public static L0 newBuilder() {
        return (L0)DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE.createBuilder();
    }

    public static L0 newBuilder(DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0) {
        return (L0)DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE.createBuilder(descriptorProtos$ServiceDescriptorProto0);
    }

    public static DescriptorProtos.ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.ServiceDescriptorProto)A1.parseDelimitedFrom(DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.ServiceDescriptorProto)A1.parseDelimitedFrom(DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.ServiceDescriptorProto parseFrom(o o0) {
        return (DescriptorProtos.ServiceDescriptorProto)A1.parseFrom(DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.ServiceDescriptorProto parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.ServiceDescriptorProto)A1.parseFrom(DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.ServiceDescriptorProto parseFrom(t t0) {
        return (DescriptorProtos.ServiceDescriptorProto)A1.parseFrom(DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.ServiceDescriptorProto parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.ServiceDescriptorProto)A1.parseFrom(DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.ServiceDescriptorProto parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.ServiceDescriptorProto)A1.parseFrom(DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.ServiceDescriptorProto parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.ServiceDescriptorProto)A1.parseFrom(DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.ServiceDescriptorProto parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.ServiceDescriptorProto)A1.parseFrom(DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.ServiceDescriptorProto parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.ServiceDescriptorProto)A1.parseFrom(DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.ServiceDescriptorProto parseFrom(byte[] arr_b) {
        return (DescriptorProtos.ServiceDescriptorProto)A1.parseFrom(DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.ServiceDescriptorProto parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.ServiceDescriptorProto)A1.parseFrom(DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.ServiceDescriptorProto.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMethod(int v) {
        this.ensureMethodIsMutable();
        this.method_.remove(v);
    }

    private void setMethod(int v, DescriptorProtos.MethodDescriptorProto descriptorProtos$MethodDescriptorProto0) {
        descriptorProtos$MethodDescriptorProto0.getClass();
        this.ensureMethodIsMutable();
        this.method_.set(v, descriptorProtos$MethodDescriptorProto0);
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

    private void setOptions(DescriptorProtos.ServiceOptions descriptorProtos$ServiceOptions0) {
        descriptorProtos$ServiceOptions0.getClass();
        this.options_ = descriptorProtos$ServiceOptions0;
        this.bitField0_ |= 2;
    }
}

