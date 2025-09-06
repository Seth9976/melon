package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DescriptorProtos.FieldDescriptorProto extends A1 implements k0 {
    private static final DescriptorProtos.FieldDescriptorProto DEFAULT_INSTANCE = null;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
    public static final int EXTENDEE_FIELD_NUMBER = 2;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int LABEL_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 9;
    public static final int OPTIONS_FIELD_NUMBER = 8;
    private static volatile z2 PARSER = null;
    public static final int PROTO3_OPTIONAL_FIELD_NUMBER = 17;
    public static final int TYPE_FIELD_NUMBER = 5;
    public static final int TYPE_NAME_FIELD_NUMBER = 6;
    private int bitField0_;
    private String defaultValue_;
    private String extendee_;
    private String jsonName_;
    private int label_;
    private byte memoizedIsInitialized;
    private String name_;
    private int number_;
    private int oneofIndex_;
    private DescriptorProtos.FieldOptions options_;
    private boolean proto3Optional_;
    private String typeName_;
    private int type_;

    static {
        DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0 = new DescriptorProtos.FieldDescriptorProto();
        DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE = descriptorProtos$FieldDescriptorProto0;
        A1.registerDefaultInstance(DescriptorProtos.FieldDescriptorProto.class, descriptorProtos$FieldDescriptorProto0);
    }

    private DescriptorProtos.FieldDescriptorProto() {
        this.memoizedIsInitialized = 2;
        this.name_ = "";
        this.label_ = 1;
        this.type_ = 1;
        this.typeName_ = "";
        this.extendee_ = "";
        this.defaultValue_ = "";
        this.jsonName_ = "";
    }

    public static void access$17500(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0, String s) {
        descriptorProtos$FieldDescriptorProto0.setName(s);
    }

    public static void access$17600(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FieldDescriptorProto0.clearName();
    }

    public static void access$17700(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0, o o0) {
        descriptorProtos$FieldDescriptorProto0.setNameBytes(o0);
    }

    public static void access$17800(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0, int v) {
        descriptorProtos$FieldDescriptorProto0.setNumber(v);
    }

    public static void access$17900(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FieldDescriptorProto0.clearNumber();
    }

    public static void access$18000(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0, i0 i00) {
        descriptorProtos$FieldDescriptorProto0.setLabel(i00);
    }

    public static void access$18100(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FieldDescriptorProto0.clearLabel();
    }

    public static void access$18200(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0, j0 j00) {
        descriptorProtos$FieldDescriptorProto0.setType(j00);
    }

    public static void access$18300(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FieldDescriptorProto0.clearType();
    }

    public static void access$18400(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0, String s) {
        descriptorProtos$FieldDescriptorProto0.setTypeName(s);
    }

    public static void access$18500(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FieldDescriptorProto0.clearTypeName();
    }

    public static void access$18600(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0, o o0) {
        descriptorProtos$FieldDescriptorProto0.setTypeNameBytes(o0);
    }

    public static void access$18700(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0, String s) {
        descriptorProtos$FieldDescriptorProto0.setExtendee(s);
    }

    public static void access$18800(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FieldDescriptorProto0.clearExtendee();
    }

    public static void access$18900(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0, o o0) {
        descriptorProtos$FieldDescriptorProto0.setExtendeeBytes(o0);
    }

    public static void access$19000(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0, String s) {
        descriptorProtos$FieldDescriptorProto0.setDefaultValue(s);
    }

    public static void access$19100(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FieldDescriptorProto0.clearDefaultValue();
    }

    public static void access$19200(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0, o o0) {
        descriptorProtos$FieldDescriptorProto0.setDefaultValueBytes(o0);
    }

    public static void access$19300(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0, int v) {
        descriptorProtos$FieldDescriptorProto0.setOneofIndex(v);
    }

    public static void access$19400(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FieldDescriptorProto0.clearOneofIndex();
    }

    public static void access$19500(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0, String s) {
        descriptorProtos$FieldDescriptorProto0.setJsonName(s);
    }

    public static void access$19600(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FieldDescriptorProto0.clearJsonName();
    }

    public static void access$19700(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0, o o0) {
        descriptorProtos$FieldDescriptorProto0.setJsonNameBytes(o0);
    }

    public static void access$19800(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0, DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        descriptorProtos$FieldDescriptorProto0.setOptions(descriptorProtos$FieldOptions0);
    }

    public static void access$19900(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0, DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        descriptorProtos$FieldDescriptorProto0.mergeOptions(descriptorProtos$FieldOptions0);
    }

    public static void access$20000(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FieldDescriptorProto0.clearOptions();
    }

    public static void access$20100(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0, boolean z) {
        descriptorProtos$FieldDescriptorProto0.setProto3Optional(z);
    }

    public static void access$20200(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        descriptorProtos$FieldDescriptorProto0.clearProto3Optional();
    }

    private void clearDefaultValue() {
        this.bitField0_ &= -65;
        this.defaultValue_ = "";
    }

    private void clearExtendee() {
        this.bitField0_ &= -33;
        this.extendee_ = "";
    }

    private void clearJsonName() {
        this.bitField0_ &= 0xFFFFFEFF;
        this.jsonName_ = "";
    }

    private void clearLabel() {
        this.bitField0_ &= -5;
        this.label_ = 1;
    }

    private void clearName() {
        this.bitField0_ &= -2;
        this.name_ = "";
    }

    private void clearNumber() {
        this.bitField0_ &= -3;
        this.number_ = 0;
    }

    private void clearOneofIndex() {
        this.bitField0_ &= 0xFFFFFF7F;
        this.oneofIndex_ = 0;
    }

    private void clearOptions() {
        this.options_ = null;
        this.bitField0_ &= 0xFFFFFDFF;
    }

    private void clearProto3Optional() {
        this.bitField0_ &= 0xFFFFFBFF;
        this.proto3Optional_ = false;
    }

    private void clearType() {
        this.bitField0_ &= -9;
        this.type_ = 1;
    }

    private void clearTypeName() {
        this.bitField0_ &= -17;
        this.typeName_ = "";
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
                return A1.newMessageInfo(DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE, "\u0001\u000B\u0000\u0001\u0001\u0011\u000B\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0005\u0003င\u0001\u0004᠌\u0002\u0005᠌\u0003\u0006ဈ\u0004\u0007ဈ\u0006\bᐉ\t\tင\u0007\nဈ\b\u0011ဇ\n", new Object[]{"bitField0_", "name_", "extendee_", "number_", "label_", E.k, "type_", E.l, "typeName_", "defaultValue_", "options_", "oneofIndex_", "jsonName_", "proto3Optional_"});
            }
            case 3: {
                return new DescriptorProtos.FieldDescriptorProto();
            }
            case 4: {
                return new h0(DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.FieldDescriptorProto.PARSER;
                if(z20 == null) {
                    Class class0 = DescriptorProtos.FieldDescriptorProto.class;
                    synchronized(class0) {
                        z2 z21 = DescriptorProtos.FieldDescriptorProto.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.FieldDescriptorProto.PARSER = z21;
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

    public static DescriptorProtos.FieldDescriptorProto getDefaultInstance() {
        return DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE;
    }

    public String getDefaultValue() [...] // 潜在的解密器

    public o getDefaultValueBytes() {
        return o.e(this.defaultValue_);
    }

    public String getExtendee() [...] // 潜在的解密器

    public o getExtendeeBytes() {
        return o.e(this.extendee_);
    }

    public String getJsonName() [...] // 潜在的解密器

    public o getJsonNameBytes() {
        return o.e(this.jsonName_);
    }

    public i0 getLabel() {
        i0 i00 = i0.b(this.label_);
        return i00 == null ? i0.b : i00;
    }

    public String getName() [...] // 潜在的解密器

    public o getNameBytes() {
        return o.e(this.name_);
    }

    public int getNumber() {
        return this.number_;
    }

    public int getOneofIndex() {
        return this.oneofIndex_;
    }

    public DescriptorProtos.FieldOptions getOptions() {
        return this.options_ == null ? DescriptorProtos.FieldOptions.getDefaultInstance() : this.options_;
    }

    public boolean getProto3Optional() {
        return this.proto3Optional_;
    }

    public j0 getType() {
        j0 j00 = j0.b(this.type_);
        return j00 == null ? j0.b : j00;
    }

    public String getTypeName() [...] // 潜在的解密器

    public o getTypeNameBytes() {
        return o.e(this.typeName_);
    }

    public boolean hasDefaultValue() {
        return (this.bitField0_ & 0x40) != 0;
    }

    public boolean hasExtendee() {
        return (this.bitField0_ & 0x20) != 0;
    }

    public boolean hasJsonName() {
        return (this.bitField0_ & 0x100) != 0;
    }

    public boolean hasLabel() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasNumber() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasOneofIndex() {
        return (this.bitField0_ & 0x80) != 0;
    }

    public boolean hasOptions() {
        return (this.bitField0_ & 0x200) != 0;
    }

    public boolean hasProto3Optional() {
        return (this.bitField0_ & 0x400) != 0;
    }

    public boolean hasType() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasTypeName() {
        return (this.bitField0_ & 16) != 0;
    }

    private void mergeOptions(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        descriptorProtos$FieldOptions0.getClass();
        if(this.options_ == null || this.options_ == DescriptorProtos.FieldOptions.getDefaultInstance()) {
            this.options_ = descriptorProtos$FieldOptions0;
        }
        else {
            l0 l00 = DescriptorProtos.FieldOptions.newBuilder(this.options_);
            l00.f(descriptorProtos$FieldOptions0);
            this.options_ = (DescriptorProtos.FieldOptions)l00.i();
        }
        this.bitField0_ |= 0x200;
    }

    public static h0 newBuilder() {
        return (h0)DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE.createBuilder();
    }

    public static h0 newBuilder(DescriptorProtos.FieldDescriptorProto descriptorProtos$FieldDescriptorProto0) {
        return (h0)DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE.createBuilder(descriptorProtos$FieldDescriptorProto0);
    }

    public static DescriptorProtos.FieldDescriptorProto parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.FieldDescriptorProto)A1.parseDelimitedFrom(DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.FieldDescriptorProto parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.FieldDescriptorProto)A1.parseDelimitedFrom(DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.FieldDescriptorProto parseFrom(o o0) {
        return (DescriptorProtos.FieldDescriptorProto)A1.parseFrom(DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.FieldDescriptorProto parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.FieldDescriptorProto)A1.parseFrom(DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.FieldDescriptorProto parseFrom(t t0) {
        return (DescriptorProtos.FieldDescriptorProto)A1.parseFrom(DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.FieldDescriptorProto parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.FieldDescriptorProto)A1.parseFrom(DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.FieldDescriptorProto parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.FieldDescriptorProto)A1.parseFrom(DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.FieldDescriptorProto parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.FieldDescriptorProto)A1.parseFrom(DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.FieldDescriptorProto parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.FieldDescriptorProto)A1.parseFrom(DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.FieldDescriptorProto parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.FieldDescriptorProto)A1.parseFrom(DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.FieldDescriptorProto parseFrom(byte[] arr_b) {
        return (DescriptorProtos.FieldDescriptorProto)A1.parseFrom(DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.FieldDescriptorProto parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.FieldDescriptorProto)A1.parseFrom(DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.FieldDescriptorProto.DEFAULT_INSTANCE.getParserForType();
    }

    private void setDefaultValue(String s) {
        s.getClass();
        this.bitField0_ |= 0x40;
        this.defaultValue_ = s;
    }

    private void setDefaultValueBytes(o o0) {
        this.defaultValue_ = o0.p();
        this.bitField0_ |= 0x40;
    }

    private void setExtendee(String s) {
        s.getClass();
        this.bitField0_ |= 0x20;
        this.extendee_ = s;
    }

    private void setExtendeeBytes(o o0) {
        this.extendee_ = o0.p();
        this.bitField0_ |= 0x20;
    }

    private void setJsonName(String s) {
        s.getClass();
        this.bitField0_ |= 0x100;
        this.jsonName_ = s;
    }

    private void setJsonNameBytes(o o0) {
        this.jsonName_ = o0.p();
        this.bitField0_ |= 0x100;
    }

    private void setLabel(i0 i00) {
        this.label_ = i00.a;
        this.bitField0_ |= 4;
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

    private void setOneofIndex(int v) {
        this.bitField0_ |= 0x80;
        this.oneofIndex_ = v;
    }

    private void setOptions(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        descriptorProtos$FieldOptions0.getClass();
        this.options_ = descriptorProtos$FieldOptions0;
        this.bitField0_ |= 0x200;
    }

    private void setProto3Optional(boolean z) {
        this.bitField0_ |= 0x400;
        this.proto3Optional_ = z;
    }

    private void setType(j0 j00) {
        this.type_ = j00.a;
        this.bitField0_ |= 8;
    }

    private void setTypeName(String s) {
        s.getClass();
        this.bitField0_ |= 16;
        this.typeName_ = s;
    }

    private void setTypeNameBytes(o o0) {
        this.typeName_ = o0.p();
        this.bitField0_ |= 16;
    }
}

