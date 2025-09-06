package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Any extends A1 implements m2 {
    private static final Any DEFAULT_INSTANCE = null;
    private static volatile z2 PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private String typeUrl_;
    private o value_;

    static {
        Any any0 = new Any();
        Any.DEFAULT_INSTANCE = any0;
        A1.registerDefaultInstance(Any.class, any0);
    }

    private Any() {
        this.typeUrl_ = "";
        this.value_ = o.b;
    }

    public static void access$100(Any any0, String s) {
        any0.setTypeUrl(s);
    }

    public static void access$200(Any any0) {
        any0.clearTypeUrl();
    }

    public static void access$300(Any any0, o o0) {
        any0.setTypeUrlBytes(o0);
    }

    public static void access$400(Any any0, o o0) {
        any0.setValue(o0);
    }

    public static void access$500(Any any0) {
        any0.clearValue();
    }

    private void clearTypeUrl() {
        this.typeUrl_ = "";
    }

    private void clearValue() {
        this.value_ = Any.getDefaultInstance().getValue();
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(Any.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\n", new Object[]{"typeUrl_", "value_"});
            }
            case 3: {
                return new Any();
            }
            case 4: {
                return new e(Any.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return Any.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = Any.PARSER;
                if(z20 == null) {
                    Class class0 = Any.class;
                    synchronized(class0) {
                        z2 z21 = Any.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            Any.PARSER = z21;
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

    public static Any getDefaultInstance() {
        return Any.DEFAULT_INSTANCE;
    }

    public String getTypeUrl() [...] // 潜在的解密器

    public o getTypeUrlBytes() {
        return o.e(this.typeUrl_);
    }

    public o getValue() {
        return this.value_;
    }

    public static e newBuilder() {
        return (e)Any.DEFAULT_INSTANCE.createBuilder();
    }

    public static e newBuilder(Any any0) {
        return (e)Any.DEFAULT_INSTANCE.createBuilder(any0);
    }

    public static Any parseDelimitedFrom(InputStream inputStream0) {
        return (Any)A1.parseDelimitedFrom(Any.DEFAULT_INSTANCE, inputStream0);
    }

    public static Any parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (Any)A1.parseDelimitedFrom(Any.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Any parseFrom(o o0) {
        return (Any)A1.parseFrom(Any.DEFAULT_INSTANCE, o0);
    }

    public static Any parseFrom(o o0, g1 g10) {
        return (Any)A1.parseFrom(Any.DEFAULT_INSTANCE, o0, g10);
    }

    public static Any parseFrom(t t0) {
        return (Any)A1.parseFrom(Any.DEFAULT_INSTANCE, t0);
    }

    public static Any parseFrom(t t0, g1 g10) {
        return (Any)A1.parseFrom(Any.DEFAULT_INSTANCE, t0, g10);
    }

    public static Any parseFrom(InputStream inputStream0) {
        return (Any)A1.parseFrom(Any.DEFAULT_INSTANCE, inputStream0);
    }

    public static Any parseFrom(InputStream inputStream0, g1 g10) {
        return (Any)A1.parseFrom(Any.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Any parseFrom(ByteBuffer byteBuffer0) {
        return (Any)A1.parseFrom(Any.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static Any parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (Any)A1.parseFrom(Any.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static Any parseFrom(byte[] arr_b) {
        return (Any)A1.parseFrom(Any.DEFAULT_INSTANCE, arr_b);
    }

    public static Any parseFrom(byte[] arr_b, g1 g10) {
        return (Any)A1.parseFrom(Any.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return Any.DEFAULT_INSTANCE.getParserForType();
    }

    private void setTypeUrl(String s) {
        s.getClass();
        this.typeUrl_ = s;
    }

    private void setTypeUrlBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.typeUrl_ = o0.p();
    }

    private void setValue(o o0) {
        o0.getClass();
        this.value_ = o0;
    }
}

