package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class StringValue extends A1 implements m2 {
    private static final StringValue DEFAULT_INSTANCE = null;
    private static volatile z2 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private String value_;

    static {
        StringValue stringValue0 = new StringValue();
        StringValue.DEFAULT_INSTANCE = stringValue0;
        A1.registerDefaultInstance(StringValue.class, stringValue0);
    }

    private StringValue() {
        this.value_ = "";
    }

    public static void access$200(StringValue stringValue0) {
        stringValue0.clearValue();
    }

    public static void access$300(StringValue stringValue0, o o0) {
        stringValue0.setValueBytes(o0);
    }

    private void clearValue() {
        this.value_ = "";
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(StringValue.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"value_"});
            }
            case 3: {
                return new StringValue();
            }
            case 4: {
                return new J2(StringValue.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return StringValue.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = StringValue.PARSER;
                if(z20 == null) {
                    Class class0 = StringValue.class;
                    synchronized(class0) {
                        z2 z21 = StringValue.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            StringValue.PARSER = z21;
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

    public static StringValue getDefaultInstance() {
        return StringValue.DEFAULT_INSTANCE;
    }

    public String getValue() [...] // 潜在的解密器

    public o getValueBytes() {
        return o.e(this.value_);
    }

    public static J2 newBuilder() {
        return (J2)StringValue.DEFAULT_INSTANCE.createBuilder();
    }

    public static J2 newBuilder(StringValue stringValue0) {
        return (J2)StringValue.DEFAULT_INSTANCE.createBuilder(stringValue0);
    }

    public static StringValue of(String s) {
        J2 j20 = StringValue.newBuilder();
        j20.d();
        ((StringValue)j20.b).setValue(s);
        return (StringValue)j20.a();
    }

    public static StringValue parseDelimitedFrom(InputStream inputStream0) {
        return (StringValue)A1.parseDelimitedFrom(StringValue.DEFAULT_INSTANCE, inputStream0);
    }

    public static StringValue parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (StringValue)A1.parseDelimitedFrom(StringValue.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static StringValue parseFrom(o o0) {
        return (StringValue)A1.parseFrom(StringValue.DEFAULT_INSTANCE, o0);
    }

    public static StringValue parseFrom(o o0, g1 g10) {
        return (StringValue)A1.parseFrom(StringValue.DEFAULT_INSTANCE, o0, g10);
    }

    public static StringValue parseFrom(t t0) {
        return (StringValue)A1.parseFrom(StringValue.DEFAULT_INSTANCE, t0);
    }

    public static StringValue parseFrom(t t0, g1 g10) {
        return (StringValue)A1.parseFrom(StringValue.DEFAULT_INSTANCE, t0, g10);
    }

    public static StringValue parseFrom(InputStream inputStream0) {
        return (StringValue)A1.parseFrom(StringValue.DEFAULT_INSTANCE, inputStream0);
    }

    public static StringValue parseFrom(InputStream inputStream0, g1 g10) {
        return (StringValue)A1.parseFrom(StringValue.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static StringValue parseFrom(ByteBuffer byteBuffer0) {
        return (StringValue)A1.parseFrom(StringValue.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static StringValue parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (StringValue)A1.parseFrom(StringValue.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static StringValue parseFrom(byte[] arr_b) {
        return (StringValue)A1.parseFrom(StringValue.DEFAULT_INSTANCE, arr_b);
    }

    public static StringValue parseFrom(byte[] arr_b, g1 g10) {
        return (StringValue)A1.parseFrom(StringValue.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return StringValue.DEFAULT_INSTANCE.getParserForType();
    }

    private void setValue(String s) {
        s.getClass();
        this.value_ = s;
    }

    private void setValueBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.value_ = o0.p();
    }
}

