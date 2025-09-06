package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos.FileDescriptorProto extends A1 implements u0 {
    private static final DescriptorProtos.FileDescriptorProto DEFAULT_INSTANCE = null;
    public static final int DEPENDENCY_FIELD_NUMBER = 3;
    public static final int EDITION_FIELD_NUMBER = 14;
    public static final int ENUM_TYPE_FIELD_NUMBER = 5;
    public static final int EXTENSION_FIELD_NUMBER = 7;
    public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 8;
    public static final int OPTION_DEPENDENCY_FIELD_NUMBER = 15;
    public static final int PACKAGE_FIELD_NUMBER = 2;
    private static volatile z2 PARSER = null;
    public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
    public static final int SERVICE_FIELD_NUMBER = 6;
    public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
    public static final int SYNTAX_FIELD_NUMBER = 12;
    public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
    private int bitField0_;
    private O1 dependency_;
    private int edition_;
    private O1 enumType_;
    private O1 extension_;
    private byte memoizedIsInitialized;
    private O1 messageType_;
    private String name_;
    private O1 optionDependency_;
    private DescriptorProtos.FileOptions options_;
    private String package_;
    private K1 publicDependency_;
    private O1 service_;
    private DescriptorProtos.SourceCodeInfo sourceCodeInfo_;
    private String syntax_;
    private K1 weakDependency_;

    static {
        DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0 = new DescriptorProtos.FileDescriptorProto();
        DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE = descriptorProtos$FileDescriptorProto0;
        A1.registerDefaultInstance(DescriptorProtos.FileDescriptorProto.class, descriptorProtos$FileDescriptorProto0);
    }

    private DescriptorProtos.FileDescriptorProto() {
        this.memoizedIsInitialized = 2;
        this.name_ = "";
        this.package_ = "";
        this.dependency_ = A1.emptyProtobufList();
        this.publicDependency_ = A1.emptyIntList();
        this.weakDependency_ = A1.emptyIntList();
        this.optionDependency_ = A1.emptyProtobufList();
        this.messageType_ = A1.emptyProtobufList();
        this.enumType_ = A1.emptyProtobufList();
        this.service_ = A1.emptyProtobufList();
        this.extension_ = A1.emptyProtobufList();
        this.syntax_ = "";
    }

    public static void access$1000(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.clearName();
    }

    public static void access$1100(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, o o0) {
        descriptorProtos$FileDescriptorProto0.setNameBytes(o0);
    }

    public static void access$1200(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, String s) {
        descriptorProtos$FileDescriptorProto0.setPackage(s);
    }

    public static void access$1300(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.clearPackage();
    }

    public static void access$1400(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, o o0) {
        descriptorProtos$FileDescriptorProto0.setPackageBytes(o0);
    }

    public static void access$1500(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, int v, String s) {
        descriptorProtos$FileDescriptorProto0.setDependency(v, s);
    }

    public static void access$1600(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, String s) {
        descriptorProtos$FileDescriptorProto0.addDependency(s);
    }

    public static void access$1700(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, Iterable iterable0) {
        descriptorProtos$FileDescriptorProto0.addAllDependency(iterable0);
    }

    public static void access$1800(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.clearDependency();
    }

    public static void access$1900(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, o o0) {
        descriptorProtos$FileDescriptorProto0.addDependencyBytes(o0);
    }

    public static void access$2000(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, int v, int v1) {
        descriptorProtos$FileDescriptorProto0.setPublicDependency(v, v1);
    }

    public static void access$2100(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, int v) {
        descriptorProtos$FileDescriptorProto0.addPublicDependency(v);
    }

    public static void access$2200(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, Iterable iterable0) {
        descriptorProtos$FileDescriptorProto0.addAllPublicDependency(iterable0);
    }

    public static void access$2300(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.clearPublicDependency();
    }

    public static void access$2400(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, int v, int v1) {
        descriptorProtos$FileDescriptorProto0.setWeakDependency(v, v1);
    }

    public static void access$2500(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, int v) {
        descriptorProtos$FileDescriptorProto0.addWeakDependency(v);
    }

    public static void access$2600(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, Iterable iterable0) {
        descriptorProtos$FileDescriptorProto0.addAllWeakDependency(iterable0);
    }

    public static void access$2700(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.clearWeakDependency();
    }

    public static void access$2800(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, int v, String s) {
        descriptorProtos$FileDescriptorProto0.setOptionDependency(v, s);
    }

    public static void access$2900(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, String s) {
        descriptorProtos$FileDescriptorProto0.addOptionDependency(s);
    }

    public static void access$3000(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, Iterable iterable0) {
        descriptorProtos$FileDescriptorProto0.addAllOptionDependency(iterable0);
    }

    public static void access$3100(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.clearOptionDependency();
    }

    public static void access$3200(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, o o0) {
        descriptorProtos$FileDescriptorProto0.addOptionDependencyBytes(o0);
    }

    public static void access$3300(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, int v, DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.setMessageType(v, descriptorProtos$DescriptorProto0);
    }

    public static void access$3400(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.addMessageType(descriptorProtos$DescriptorProto0);
    }

    public static void access$3500(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, int v, DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.addMessageType(v, descriptorProtos$DescriptorProto0);
    }

    public static void access$3600(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, Iterable iterable0) {
        descriptorProtos$FileDescriptorProto0.addAllMessageType(iterable0);
    }

    public static void access$3700(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.clearMessageType();
    }

    public static void access$3800(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, int v) {
        descriptorProtos$FileDescriptorProto0.removeMessageType(v);
    }

    public static void access$3900(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, int v, DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.setEnumType(v, descriptorProtos$EnumDescriptorProto0);
    }

    public static void access$4000(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.addEnumType(descriptorProtos$EnumDescriptorProto0);
    }

    public static void access$4100(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, int v, DescriptorProtos.EnumDescriptorProto descriptorProtos$EnumDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.addEnumType(v, descriptorProtos$EnumDescriptorProto0);
    }

    public static void access$4200(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, Iterable iterable0) {
        descriptorProtos$FileDescriptorProto0.addAllEnumType(iterable0);
    }

    public static void access$4300(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.clearEnumType();
    }

    public static void access$4400(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, int v) {
        descriptorProtos$FileDescriptorProto0.removeEnumType(v);
    }

    public static void access$4500(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, int v, DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.setService(v, descriptorProtos$ServiceDescriptorProto0);
    }

    public static void access$4600(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.addService(descriptorProtos$ServiceDescriptorProto0);
    }

    public static void access$4700(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, int v, DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.addService(v, descriptorProtos$ServiceDescriptorProto0);
    }

    public static void access$4800(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, Iterable iterable0) {
        descriptorProtos$FileDescriptorProto0.addAllService(iterable0);
    }

    public static void access$4900(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.clearService();
    }

    public static void access$5000(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, int v) {
        descriptorProtos$FileDescriptorProto0.removeService(v);
    }

    public static void access$5100(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, int v, DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.setExtension(v, descriptorProtos$FieldDescriptorProto0);
    }

    public static void access$5200(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.addExtension(descriptorProtos$FieldDescriptorProto0);
    }

    public static void access$5300(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, int v, DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.addExtension(v, descriptorProtos$FieldDescriptorProto0);
    }

    public static void access$5400(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, Iterable iterable0) {
        descriptorProtos$FileDescriptorProto0.addAllExtension(iterable0);
    }

    public static void access$5500(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.clearExtension();
    }

    public static void access$5600(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, int v) {
        descriptorProtos$FileDescriptorProto0.removeExtension(v);
    }

    public static void access$5700(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileDescriptorProto0.setOptions(descriptorProtos$FileOptions0);
    }

    public static void access$5800(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileDescriptorProto0.mergeOptions(descriptorProtos$FileOptions0);
    }

    public static void access$5900(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.clearOptions();
    }

    public static void access$6000(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, DescriptorProtos.SourceCodeInfo descriptorProtos$SourceCodeInfo0) {
        descriptorProtos$FileDescriptorProto0.setSourceCodeInfo(descriptorProtos$SourceCodeInfo0);
    }

    public static void access$6100(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, DescriptorProtos.SourceCodeInfo descriptorProtos$SourceCodeInfo0) {
        descriptorProtos$FileDescriptorProto0.mergeSourceCodeInfo(descriptorProtos$SourceCodeInfo0);
    }

    public static void access$6200(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.clearSourceCodeInfo();
    }

    public static void access$6300(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, String s) {
        descriptorProtos$FileDescriptorProto0.setSyntax(s);
    }

    public static void access$6400(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.clearSyntax();
    }

    public static void access$6500(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, o o0) {
        descriptorProtos$FileDescriptorProto0.setSyntaxBytes(o0);
    }

    public static void access$6600(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, F f0) {
        descriptorProtos$FileDescriptorProto0.setEdition(f0);
    }

    public static void access$6700(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.clearEdition();
    }

    public static void access$900(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0, String s) {
        descriptorProtos$FileDescriptorProto0.setName(s);
    }

    private void addAllDependency(Iterable iterable0) {
        this.ensureDependencyIsMutable();
        b.addAll(iterable0, this.dependency_);
    }

    private void addAllEnumType(Iterable iterable0) {
        this.ensureEnumTypeIsMutable();
        b.addAll(iterable0, this.enumType_);
    }

    private void addAllExtension(Iterable iterable0) {
        this.ensureExtensionIsMutable();
        b.addAll(iterable0, this.extension_);
    }

    private void addAllMessageType(Iterable iterable0) {
        this.ensureMessageTypeIsMutable();
        b.addAll(iterable0, this.messageType_);
    }

    private void addAllOptionDependency(Iterable iterable0) {
        this.ensureOptionDependencyIsMutable();
        b.addAll(iterable0, this.optionDependency_);
    }

    private void addAllPublicDependency(Iterable iterable0) {
        this.ensurePublicDependencyIsMutable();
        b.addAll(iterable0, this.publicDependency_);
    }

    private void addAllService(Iterable iterable0) {
        this.ensureServiceIsMutable();
        b.addAll(iterable0, this.service_);
    }

    private void addAllWeakDependency(Iterable iterable0) {
        this.ensureWeakDependencyIsMutable();
        b.addAll(iterable0, this.weakDependency_);
    }

    private void addDependency(String s) {
        s.getClass();
        this.ensureDependencyIsMutable();
        this.dependency_.add(s);
    }

    private void addDependencyBytes(o o0) {
        this.ensureDependencyIsMutable();
        this.dependency_.add(o0.p());
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

    private void addMessageType(int v, DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$DescriptorProto0.getClass();
        this.ensureMessageTypeIsMutable();
        this.messageType_.add(v, descriptorProtos$DescriptorProto0);
    }

    private void addMessageType(DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$DescriptorProto0.getClass();
        this.ensureMessageTypeIsMutable();
        this.messageType_.add(descriptorProtos$DescriptorProto0);
    }

    private void addOptionDependency(String s) {
        s.getClass();
        this.ensureOptionDependencyIsMutable();
        this.optionDependency_.add(s);
    }

    private void addOptionDependencyBytes(o o0) {
        this.ensureOptionDependencyIsMutable();
        this.optionDependency_.add(o0.p());
    }

    private void addPublicDependency(int v) {
        this.ensurePublicDependencyIsMutable();
        ((D1)this.publicDependency_).d(v);
    }

    private void addService(int v, DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0) {
        descriptorProtos$ServiceDescriptorProto0.getClass();
        this.ensureServiceIsMutable();
        this.service_.add(v, descriptorProtos$ServiceDescriptorProto0);
    }

    private void addService(DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0) {
        descriptorProtos$ServiceDescriptorProto0.getClass();
        this.ensureServiceIsMutable();
        this.service_.add(descriptorProtos$ServiceDescriptorProto0);
    }

    private void addWeakDependency(int v) {
        this.ensureWeakDependencyIsMutable();
        ((D1)this.weakDependency_).d(v);
    }

    private void clearDependency() {
        this.dependency_ = A1.emptyProtobufList();
    }

    private void clearEdition() {
        this.bitField0_ &= -33;
        this.edition_ = 0;
    }

    private void clearEnumType() {
        this.enumType_ = A1.emptyProtobufList();
    }

    private void clearExtension() {
        this.extension_ = A1.emptyProtobufList();
    }

    private void clearMessageType() {
        this.messageType_ = A1.emptyProtobufList();
    }

    private void clearName() {
        this.bitField0_ &= -2;
        this.name_ = "";
    }

    private void clearOptionDependency() {
        this.optionDependency_ = A1.emptyProtobufList();
    }

    private void clearOptions() {
        this.options_ = null;
        this.bitField0_ &= -5;
    }

    private void clearPackage() {
        this.bitField0_ &= -3;
        this.package_ = "";
    }

    private void clearPublicDependency() {
        this.publicDependency_ = A1.emptyIntList();
    }

    private void clearService() {
        this.service_ = A1.emptyProtobufList();
    }

    private void clearSourceCodeInfo() {
        this.sourceCodeInfo_ = null;
        this.bitField0_ &= -9;
    }

    private void clearSyntax() {
        this.bitField0_ &= -17;
        this.syntax_ = "";
    }

    private void clearWeakDependency() {
        this.weakDependency_ = A1.emptyIntList();
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
                return A1.newMessageInfo(DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE, "\u0001\u000E\u0000\u0001\u0001\u000F\u000E\u0000\b\u0006\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001A\u0004Л\u0005Л\u0006Л\u0007Л\bᐉ\u0002\tᐉ\u0003\n\u0016\u000B\u0016\fဈ\u0004\u000E᠌\u0005\u000F\u001A", new Object[]{"bitField0_", "name_", "package_", "dependency_", "messageType_", DescriptorProtos.DescriptorProto.class, "enumType_", DescriptorProtos.EnumDescriptorProto.class, "service_", DescriptorProtos.ServiceDescriptorProto.class, "extension_", DescriptorProtos.FieldDescriptorProto.class, "options_", "sourceCodeInfo_", "publicDependency_", "weakDependency_", "syntax_", "edition_", E.b, "optionDependency_"});
            }
            case 3: {
                return new DescriptorProtos.FileDescriptorProto();
            }
            case 4: {
                return new t0(DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.FileDescriptorProto.PARSER;
                if(z20 == null) {
                    Class class0 = DescriptorProtos.FileDescriptorProto.class;
                    synchronized(class0) {
                        z2 z21 = DescriptorProtos.FileDescriptorProto.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.FileDescriptorProto.PARSER = z21;
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

    private void ensureDependencyIsMutable() {
        O1 o10 = this.dependency_;
        if(!((c)o10).a) {
            this.dependency_ = A1.mutableCopy(o10);
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

    private void ensureMessageTypeIsMutable() {
        O1 o10 = this.messageType_;
        if(!((c)o10).a) {
            this.messageType_ = A1.mutableCopy(o10);
        }
    }

    private void ensureOptionDependencyIsMutable() {
        O1 o10 = this.optionDependency_;
        if(!((c)o10).a) {
            this.optionDependency_ = A1.mutableCopy(o10);
        }
    }

    private void ensurePublicDependencyIsMutable() {
        K1 k10 = this.publicDependency_;
        if(!((c)k10).a) {
            this.publicDependency_ = A1.mutableCopy(k10);
        }
    }

    private void ensureServiceIsMutable() {
        O1 o10 = this.service_;
        if(!((c)o10).a) {
            this.service_ = A1.mutableCopy(o10);
        }
    }

    private void ensureWeakDependencyIsMutable() {
        K1 k10 = this.weakDependency_;
        if(!((c)k10).a) {
            this.weakDependency_ = A1.mutableCopy(k10);
        }
    }

    public static DescriptorProtos.FileDescriptorProto getDefaultInstance() {
        return DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE;
    }

    public String getDependency(int v) {
        return (String)this.dependency_.get(v);
    }

    public o getDependencyBytes(int v) {
        return o.e(((String)this.dependency_.get(v)));
    }

    public int getDependencyCount() {
        return this.dependency_.size();
    }

    public List getDependencyList() {
        return this.dependency_;
    }

    public F getEdition() {
        F f0 = F.b(this.edition_);
        return f0 == null ? F.b : f0;
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

    public DescriptorProtos.DescriptorProto getMessageType(int v) {
        return (DescriptorProtos.DescriptorProto)this.messageType_.get(v);
    }

    public int getMessageTypeCount() {
        return this.messageType_.size();
    }

    public List getMessageTypeList() {
        return this.messageType_;
    }

    public D getMessageTypeOrBuilder(int v) {
        return (D)this.messageType_.get(v);
    }

    public List getMessageTypeOrBuilderList() {
        return this.messageType_;
    }

    public String getName() [...] // 潜在的解密器

    public o getNameBytes() {
        return o.e(this.name_);
    }

    public String getOptionDependency(int v) {
        return (String)this.optionDependency_.get(v);
    }

    public o getOptionDependencyBytes(int v) {
        return o.e(((String)this.optionDependency_.get(v)));
    }

    public int getOptionDependencyCount() {
        return this.optionDependency_.size();
    }

    public List getOptionDependencyList() {
        return this.optionDependency_;
    }

    public DescriptorProtos.FileOptions getOptions() {
        return this.options_ == null ? DescriptorProtos.FileOptions.getDefaultInstance() : this.options_;
    }

    public String getPackage() [...] // 潜在的解密器

    public o getPackageBytes() {
        return o.e(this.package_);
    }

    public int getPublicDependency(int v) {
        return ((D1)this.publicDependency_).f(v);
    }

    public int getPublicDependencyCount() {
        return this.publicDependency_.size();
    }

    public List getPublicDependencyList() {
        return this.publicDependency_;
    }

    public DescriptorProtos.ServiceDescriptorProto getService(int v) {
        return (DescriptorProtos.ServiceDescriptorProto)this.service_.get(v);
    }

    public int getServiceCount() {
        return this.service_.size();
    }

    public List getServiceList() {
        return this.service_;
    }

    public M0 getServiceOrBuilder(int v) {
        return (M0)this.service_.get(v);
    }

    public List getServiceOrBuilderList() {
        return this.service_;
    }

    public DescriptorProtos.SourceCodeInfo getSourceCodeInfo() {
        return this.sourceCodeInfo_ == null ? DescriptorProtos.SourceCodeInfo.getDefaultInstance() : this.sourceCodeInfo_;
    }

    public String getSyntax() [...] // 潜在的解密器

    public o getSyntaxBytes() {
        return o.e(this.syntax_);
    }

    public int getWeakDependency(int v) {
        return ((D1)this.weakDependency_).f(v);
    }

    public int getWeakDependencyCount() {
        return this.weakDependency_.size();
    }

    public List getWeakDependencyList() {
        return this.weakDependency_;
    }

    public boolean hasEdition() {
        return (this.bitField0_ & 0x20) != 0;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasOptions() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasPackage() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSourceCodeInfo() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasSyntax() {
        return (this.bitField0_ & 16) != 0;
    }

    private void mergeOptions(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.getClass();
        if(this.options_ == null || this.options_ == DescriptorProtos.FileOptions.getDefaultInstance()) {
            this.options_ = descriptorProtos$FileOptions0;
        }
        else {
            w0 w00 = DescriptorProtos.FileOptions.newBuilder(this.options_);
            w00.f(descriptorProtos$FileOptions0);
            this.options_ = (DescriptorProtos.FileOptions)w00.i();
        }
        this.bitField0_ |= 4;
    }

    private void mergeSourceCodeInfo(DescriptorProtos.SourceCodeInfo descriptorProtos$SourceCodeInfo0) {
        descriptorProtos$SourceCodeInfo0.getClass();
        if(this.sourceCodeInfo_ == null || this.sourceCodeInfo_ == DescriptorProtos.SourceCodeInfo.getDefaultInstance()) {
            this.sourceCodeInfo_ = descriptorProtos$SourceCodeInfo0;
        }
        else {
            O0 o00 = DescriptorProtos.SourceCodeInfo.newBuilder(this.sourceCodeInfo_);
            o00.f(descriptorProtos$SourceCodeInfo0);
            this.sourceCodeInfo_ = (DescriptorProtos.SourceCodeInfo)o00.i();
        }
        this.bitField0_ |= 8;
    }

    public static t0 newBuilder() {
        return (t0)DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE.createBuilder();
    }

    public static t0 newBuilder(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        return (t0)DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE.createBuilder(descriptorProtos$FileDescriptorProto0);
    }

    public static DescriptorProtos.FileDescriptorProto parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.FileDescriptorProto)A1.parseDelimitedFrom(DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.FileDescriptorProto parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.FileDescriptorProto)A1.parseDelimitedFrom(DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.FileDescriptorProto parseFrom(o o0) {
        return (DescriptorProtos.FileDescriptorProto)A1.parseFrom(DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.FileDescriptorProto parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.FileDescriptorProto)A1.parseFrom(DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.FileDescriptorProto parseFrom(t t0) {
        return (DescriptorProtos.FileDescriptorProto)A1.parseFrom(DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.FileDescriptorProto parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.FileDescriptorProto)A1.parseFrom(DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.FileDescriptorProto parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.FileDescriptorProto)A1.parseFrom(DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.FileDescriptorProto parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.FileDescriptorProto)A1.parseFrom(DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.FileDescriptorProto parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.FileDescriptorProto)A1.parseFrom(DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.FileDescriptorProto parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.FileDescriptorProto)A1.parseFrom(DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.FileDescriptorProto parseFrom(byte[] arr_b) {
        return (DescriptorProtos.FileDescriptorProto)A1.parseFrom(DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.FileDescriptorProto parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.FileDescriptorProto)A1.parseFrom(DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.FileDescriptorProto.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeEnumType(int v) {
        this.ensureEnumTypeIsMutable();
        this.enumType_.remove(v);
    }

    private void removeExtension(int v) {
        this.ensureExtensionIsMutable();
        this.extension_.remove(v);
    }

    private void removeMessageType(int v) {
        this.ensureMessageTypeIsMutable();
        this.messageType_.remove(v);
    }

    private void removeService(int v) {
        this.ensureServiceIsMutable();
        this.service_.remove(v);
    }

    private void setDependency(int v, String s) {
        s.getClass();
        this.ensureDependencyIsMutable();
        this.dependency_.set(v, s);
    }

    private void setEdition(F f0) {
        this.edition_ = f0.a;
        this.bitField0_ |= 0x20;
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

    private void setMessageType(int v, DescriptorProtos.DescriptorProto descriptorProtos$DescriptorProto0) {
        descriptorProtos$DescriptorProto0.getClass();
        this.ensureMessageTypeIsMutable();
        this.messageType_.set(v, descriptorProtos$DescriptorProto0);
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

    private void setOptionDependency(int v, String s) {
        s.getClass();
        this.ensureOptionDependencyIsMutable();
        this.optionDependency_.set(v, s);
    }

    private void setOptions(DescriptorProtos.FileOptions descriptorProtos$FileOptions0) {
        descriptorProtos$FileOptions0.getClass();
        this.options_ = descriptorProtos$FileOptions0;
        this.bitField0_ |= 4;
    }

    private void setPackage(String s) {
        s.getClass();
        this.bitField0_ |= 2;
        this.package_ = s;
    }

    private void setPackageBytes(o o0) {
        this.package_ = o0.p();
        this.bitField0_ |= 2;
    }

    private void setPublicDependency(int v, int v1) {
        this.ensurePublicDependencyIsMutable();
        ((D1)this.publicDependency_).i(v, v1);
    }

    private void setService(int v, DescriptorProtos.ServiceDescriptorProto descriptorProtos$ServiceDescriptorProto0) {
        descriptorProtos$ServiceDescriptorProto0.getClass();
        this.ensureServiceIsMutable();
        this.service_.set(v, descriptorProtos$ServiceDescriptorProto0);
    }

    private void setSourceCodeInfo(DescriptorProtos.SourceCodeInfo descriptorProtos$SourceCodeInfo0) {
        descriptorProtos$SourceCodeInfo0.getClass();
        this.sourceCodeInfo_ = descriptorProtos$SourceCodeInfo0;
        this.bitField0_ |= 8;
    }

    private void setSyntax(String s) {
        s.getClass();
        this.bitField0_ |= 16;
        this.syntax_ = s;
    }

    private void setSyntaxBytes(o o0) {
        this.syntax_ = o0.p();
        this.bitField0_ |= 16;
    }

    private void setWeakDependency(int v, int v1) {
        this.ensureWeakDependencyIsMutable();
        ((D1)this.weakDependency_).i(v, v1);
    }
}

