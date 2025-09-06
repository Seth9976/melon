package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class BoolValue extends A1 implements m2 {
    private static final BoolValue DEFAULT_INSTANCE = null;
    private static volatile z2 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private boolean value_;

    static {
        BoolValue boolValue0 = new BoolValue();
        BoolValue.DEFAULT_INSTANCE = boolValue0;
        A1.registerDefaultInstance(BoolValue.class, boolValue0);
    }

    public static void access$200(BoolValue boolValue0) {
        boolValue0.clearValue();
    }

    private void clearValue() {
        this.value_ = false;
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(BoolValue.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"value_"});
            }
            case 3: {
                return new BoolValue();
            }
            case 4: {
                return new i(BoolValue.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return BoolValue.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = BoolValue.PARSER;
                if(z20 == null) {
                    Class class0 = BoolValue.class;
                    synchronized(class0) {
                        z2 z21 = BoolValue.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            BoolValue.PARSER = z21;
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

    public static BoolValue getDefaultInstance() {
        return BoolValue.DEFAULT_INSTANCE;
    }

    public boolean getValue() {
        return this.value_;
    }

    public static i newBuilder() {
        return (i)BoolValue.DEFAULT_INSTANCE.createBuilder();
    }

    public static i newBuilder(BoolValue boolValue0) {
        return (i)BoolValue.DEFAULT_INSTANCE.createBuilder(boolValue0);
    }

    public static BoolValue of(boolean z) {
        i i0 = BoolValue.newBuilder();
        i0.d();
        ((BoolValue)i0.b).setValue(z);
        return (BoolValue)i0.a();
    }

    public static BoolValue parseDelimitedFrom(InputStream inputStream0) {
        return (BoolValue)A1.parseDelimitedFrom(BoolValue.DEFAULT_INSTANCE, inputStream0);
    }

    public static BoolValue parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (BoolValue)A1.parseDelimitedFrom(BoolValue.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static BoolValue parseFrom(o o0) {
        return (BoolValue)A1.parseFrom(BoolValue.DEFAULT_INSTANCE, o0);
    }

    public static BoolValue parseFrom(o o0, g1 g10) {
        return (BoolValue)A1.parseFrom(BoolValue.DEFAULT_INSTANCE, o0, g10);
    }

    public static BoolValue parseFrom(t t0) {
        return (BoolValue)A1.parseFrom(BoolValue.DEFAULT_INSTANCE, t0);
    }

    public static BoolValue parseFrom(t t0, g1 g10) {
        return (BoolValue)A1.parseFrom(BoolValue.DEFAULT_INSTANCE, t0, g10);
    }

    public static BoolValue parseFrom(InputStream inputStream0) {
        return (BoolValue)A1.parseFrom(BoolValue.DEFAULT_INSTANCE, inputStream0);
    }

    public static BoolValue parseFrom(InputStream inputStream0, g1 g10) {
        return (BoolValue)A1.parseFrom(BoolValue.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static BoolValue parseFrom(ByteBuffer byteBuffer0) {
        return (BoolValue)A1.parseFrom(BoolValue.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static BoolValue parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (BoolValue)A1.parseFrom(BoolValue.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static BoolValue parseFrom(byte[] arr_b) {
        return (BoolValue)A1.parseFrom(BoolValue.DEFAULT_INSTANCE, arr_b);
    }

    public static BoolValue parseFrom(byte[] arr_b, g1 g10) {
        return (BoolValue)A1.parseFrom(BoolValue.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return BoolValue.DEFAULT_INSTANCE.getParserForType();
    }

    private void setValue(boolean z) {
        this.value_ = z;
    }
}

