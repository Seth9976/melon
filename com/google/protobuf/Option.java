package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Option extends A1 implements y2 {
    private static final Option DEFAULT_INSTANCE = null;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile z2 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int bitField0_;
    private String name_;
    private Any value_;

    static {
        Option option0 = new Option();
        Option.DEFAULT_INSTANCE = option0;
        A1.registerDefaultInstance(Option.class, option0);
    }

    private Option() {
        this.name_ = "";
    }

    public static void access$100(Option option0, String s) {
        option0.setName(s);
    }

    public static void access$200(Option option0) {
        option0.clearName();
    }

    public static void access$300(Option option0, o o0) {
        option0.setNameBytes(o0);
    }

    public static void access$400(Option option0, Any any0) {
        option0.setValue(any0);
    }

    public static void access$500(Option option0, Any any0) {
        option0.mergeValue(any0);
    }

    public static void access$600(Option option0) {
        option0.clearValue();
    }

    private void clearName() {
        this.name_ = "";
    }

    private void clearValue() {
        this.value_ = null;
        this.bitField0_ &= -2;
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(Option.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "name_", "value_"});
            }
            case 3: {
                return new Option();
            }
            case 4: {
                return new x2(Option.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return Option.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = Option.PARSER;
                if(z20 == null) {
                    Class class0 = Option.class;
                    synchronized(class0) {
                        z2 z21 = Option.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            Option.PARSER = z21;
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

    public static Option getDefaultInstance() {
        return Option.DEFAULT_INSTANCE;
    }

    public String getName() [...] // 潜在的解密器

    public o getNameBytes() {
        return o.e(this.name_);
    }

    public Any getValue() {
        return this.value_ == null ? Any.getDefaultInstance() : this.value_;
    }

    public boolean hasValue() {
        return (this.bitField0_ & 1) != 0;
    }

    private void mergeValue(Any any0) {
        any0.getClass();
        if(this.value_ == null || this.value_ == Any.getDefaultInstance()) {
            this.value_ = any0;
        }
        else {
            e e0 = Any.newBuilder(this.value_);
            e0.f(any0);
            this.value_ = (Any)e0.b();
        }
        this.bitField0_ |= 1;
    }

    public static x2 newBuilder() {
        return (x2)Option.DEFAULT_INSTANCE.createBuilder();
    }

    public static x2 newBuilder(Option option0) {
        return (x2)Option.DEFAULT_INSTANCE.createBuilder(option0);
    }

    public static Option parseDelimitedFrom(InputStream inputStream0) {
        return (Option)A1.parseDelimitedFrom(Option.DEFAULT_INSTANCE, inputStream0);
    }

    public static Option parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (Option)A1.parseDelimitedFrom(Option.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Option parseFrom(o o0) {
        return (Option)A1.parseFrom(Option.DEFAULT_INSTANCE, o0);
    }

    public static Option parseFrom(o o0, g1 g10) {
        return (Option)A1.parseFrom(Option.DEFAULT_INSTANCE, o0, g10);
    }

    public static Option parseFrom(t t0) {
        return (Option)A1.parseFrom(Option.DEFAULT_INSTANCE, t0);
    }

    public static Option parseFrom(t t0, g1 g10) {
        return (Option)A1.parseFrom(Option.DEFAULT_INSTANCE, t0, g10);
    }

    public static Option parseFrom(InputStream inputStream0) {
        return (Option)A1.parseFrom(Option.DEFAULT_INSTANCE, inputStream0);
    }

    public static Option parseFrom(InputStream inputStream0, g1 g10) {
        return (Option)A1.parseFrom(Option.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Option parseFrom(ByteBuffer byteBuffer0) {
        return (Option)A1.parseFrom(Option.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static Option parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (Option)A1.parseFrom(Option.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static Option parseFrom(byte[] arr_b) {
        return (Option)A1.parseFrom(Option.DEFAULT_INSTANCE, arr_b);
    }

    public static Option parseFrom(byte[] arr_b, g1 g10) {
        return (Option)A1.parseFrom(Option.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return Option.DEFAULT_INSTANCE.getParserForType();
    }

    private void setName(String s) {
        s.getClass();
        this.name_ = s;
    }

    private void setNameBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.name_ = o0.p();
    }

    private void setValue(Any any0) {
        any0.getClass();
        this.value_ = any0;
        this.bitField0_ |= 1;
    }
}

