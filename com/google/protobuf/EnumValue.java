package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class EnumValue extends A1 implements c1 {
    private static final EnumValue DEFAULT_INSTANCE = null;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile z2 PARSER;
    private String name_;
    private int number_;
    private O1 options_;

    static {
        EnumValue enumValue0 = new EnumValue();
        EnumValue.DEFAULT_INSTANCE = enumValue0;
        A1.registerDefaultInstance(EnumValue.class, enumValue0);
    }

    private EnumValue() {
        this.name_ = "";
        this.options_ = A1.emptyProtobufList();
    }

    public static void access$100(EnumValue enumValue0, String s) {
        enumValue0.setName(s);
    }

    public static void access$1000(EnumValue enumValue0) {
        enumValue0.clearOptions();
    }

    public static void access$1100(EnumValue enumValue0, int v) {
        enumValue0.removeOptions(v);
    }

    public static void access$200(EnumValue enumValue0) {
        enumValue0.clearName();
    }

    public static void access$300(EnumValue enumValue0, o o0) {
        enumValue0.setNameBytes(o0);
    }

    public static void access$400(EnumValue enumValue0, int v) {
        enumValue0.setNumber(v);
    }

    public static void access$500(EnumValue enumValue0) {
        enumValue0.clearNumber();
    }

    public static void access$600(EnumValue enumValue0, int v, Option option0) {
        enumValue0.setOptions(v, option0);
    }

    public static void access$700(EnumValue enumValue0, Option option0) {
        enumValue0.addOptions(option0);
    }

    public static void access$800(EnumValue enumValue0, int v, Option option0) {
        enumValue0.addOptions(v, option0);
    }

    public static void access$900(EnumValue enumValue0, Iterable iterable0) {
        enumValue0.addAllOptions(iterable0);
    }

    private void addAllOptions(Iterable iterable0) {
        this.ensureOptionsIsMutable();
        b.addAll(iterable0, this.options_);
    }

    private void addOptions(int v, Option option0) {
        option0.getClass();
        this.ensureOptionsIsMutable();
        this.options_.add(v, option0);
    }

    private void addOptions(Option option0) {
        option0.getClass();
        this.ensureOptionsIsMutable();
        this.options_.add(option0);
    }

    private void clearName() {
        this.name_ = "";
    }

    private void clearNumber() {
        this.number_ = 0;
    }

    private void clearOptions() {
        this.options_ = A1.emptyProtobufList();
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(EnumValue.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u0004\u0003\u001B", new Object[]{"name_", "number_", "options_", Option.class});
            }
            case 3: {
                return new EnumValue();
            }
            case 4: {
                return new b1(EnumValue.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return EnumValue.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = EnumValue.PARSER;
                if(z20 == null) {
                    Class class0 = EnumValue.class;
                    synchronized(class0) {
                        z2 z21 = EnumValue.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            EnumValue.PARSER = z21;
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

    private void ensureOptionsIsMutable() {
        O1 o10 = this.options_;
        if(!((c)o10).a) {
            this.options_ = A1.mutableCopy(o10);
        }
    }

    public static EnumValue getDefaultInstance() {
        return EnumValue.DEFAULT_INSTANCE;
    }

    public String getName() [...] // 潜在的解密器

    public o getNameBytes() {
        return o.e(this.name_);
    }

    public int getNumber() {
        return this.number_;
    }

    public Option getOptions(int v) {
        return (Option)this.options_.get(v);
    }

    public int getOptionsCount() {
        return this.options_.size();
    }

    public List getOptionsList() {
        return this.options_;
    }

    public y2 getOptionsOrBuilder(int v) {
        return (y2)this.options_.get(v);
    }

    public List getOptionsOrBuilderList() {
        return this.options_;
    }

    public static b1 newBuilder() {
        return (b1)EnumValue.DEFAULT_INSTANCE.createBuilder();
    }

    public static b1 newBuilder(EnumValue enumValue0) {
        return (b1)EnumValue.DEFAULT_INSTANCE.createBuilder(enumValue0);
    }

    public static EnumValue parseDelimitedFrom(InputStream inputStream0) {
        return (EnumValue)A1.parseDelimitedFrom(EnumValue.DEFAULT_INSTANCE, inputStream0);
    }

    public static EnumValue parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (EnumValue)A1.parseDelimitedFrom(EnumValue.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static EnumValue parseFrom(o o0) {
        return (EnumValue)A1.parseFrom(EnumValue.DEFAULT_INSTANCE, o0);
    }

    public static EnumValue parseFrom(o o0, g1 g10) {
        return (EnumValue)A1.parseFrom(EnumValue.DEFAULT_INSTANCE, o0, g10);
    }

    public static EnumValue parseFrom(t t0) {
        return (EnumValue)A1.parseFrom(EnumValue.DEFAULT_INSTANCE, t0);
    }

    public static EnumValue parseFrom(t t0, g1 g10) {
        return (EnumValue)A1.parseFrom(EnumValue.DEFAULT_INSTANCE, t0, g10);
    }

    public static EnumValue parseFrom(InputStream inputStream0) {
        return (EnumValue)A1.parseFrom(EnumValue.DEFAULT_INSTANCE, inputStream0);
    }

    public static EnumValue parseFrom(InputStream inputStream0, g1 g10) {
        return (EnumValue)A1.parseFrom(EnumValue.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static EnumValue parseFrom(ByteBuffer byteBuffer0) {
        return (EnumValue)A1.parseFrom(EnumValue.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static EnumValue parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (EnumValue)A1.parseFrom(EnumValue.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static EnumValue parseFrom(byte[] arr_b) {
        return (EnumValue)A1.parseFrom(EnumValue.DEFAULT_INSTANCE, arr_b);
    }

    public static EnumValue parseFrom(byte[] arr_b, g1 g10) {
        return (EnumValue)A1.parseFrom(EnumValue.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return EnumValue.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeOptions(int v) {
        this.ensureOptionsIsMutable();
        this.options_.remove(v);
    }

    private void setName(String s) {
        s.getClass();
        this.name_ = s;
    }

    private void setNameBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.name_ = o0.p();
    }

    private void setNumber(int v) {
        this.number_ = v;
    }

    private void setOptions(int v, Option option0) {
        option0.getClass();
        this.ensureOptionsIsMutable();
        this.options_.set(v, option0);
    }
}

