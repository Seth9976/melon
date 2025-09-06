package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

public final class Struct extends A1 implements m2 {
    private static final Struct DEFAULT_INSTANCE = null;
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static volatile z2 PARSER;
    private g2 fields_;

    static {
        Struct struct0 = new Struct();
        Struct.DEFAULT_INSTANCE = struct0;
        A1.registerDefaultInstance(Struct.class, struct0);
    }

    private Struct() {
        this.fields_ = g2.b;
    }

    public static Map access$100(Struct struct0) {
        return struct0.getMutableFieldsMap();
    }

    public boolean containsFields(String s) {
        s.getClass();
        return this.internalGetFields().containsKey(s);
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(Struct.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"fields_", L2.a});
            }
            case 3: {
                return new Struct();
            }
            case 4: {
                return new K2(Struct.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return Struct.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = Struct.PARSER;
                if(z20 == null) {
                    Class class0 = Struct.class;
                    synchronized(class0) {
                        z2 z21 = Struct.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            Struct.PARSER = z21;
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

    public static Struct getDefaultInstance() {
        return Struct.DEFAULT_INSTANCE;
    }

    @Deprecated
    public Map getFields() {
        return this.getFieldsMap();
    }

    public int getFieldsCount() {
        return this.internalGetFields().size();
    }

    public Map getFieldsMap() {
        return Collections.unmodifiableMap(this.internalGetFields());
    }

    public Value getFieldsOrDefault(String s, Value value0) {
        s.getClass();
        g2 g20 = this.internalGetFields();
        return g20.containsKey(s) ? ((Value)g20.get(s)) : value0;
    }

    public Value getFieldsOrThrow(String s) {
        s.getClass();
        g2 g20 = this.internalGetFields();
        if(!g20.containsKey(s)) {
            throw new IllegalArgumentException();
        }
        return (Value)g20.get(s);
    }

    private Map getMutableFieldsMap() {
        return this.internalGetMutableFields();
    }

    private g2 internalGetFields() {
        return this.fields_;
    }

    private g2 internalGetMutableFields() {
        g2 g20 = this.fields_;
        if(!g20.a) {
            this.fields_ = g20.c();
        }
        return this.fields_;
    }

    public static K2 newBuilder() {
        return (K2)Struct.DEFAULT_INSTANCE.createBuilder();
    }

    public static K2 newBuilder(Struct struct0) {
        return (K2)Struct.DEFAULT_INSTANCE.createBuilder(struct0);
    }

    public static Struct parseDelimitedFrom(InputStream inputStream0) {
        return (Struct)A1.parseDelimitedFrom(Struct.DEFAULT_INSTANCE, inputStream0);
    }

    public static Struct parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (Struct)A1.parseDelimitedFrom(Struct.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Struct parseFrom(o o0) {
        return (Struct)A1.parseFrom(Struct.DEFAULT_INSTANCE, o0);
    }

    public static Struct parseFrom(o o0, g1 g10) {
        return (Struct)A1.parseFrom(Struct.DEFAULT_INSTANCE, o0, g10);
    }

    public static Struct parseFrom(t t0) {
        return (Struct)A1.parseFrom(Struct.DEFAULT_INSTANCE, t0);
    }

    public static Struct parseFrom(t t0, g1 g10) {
        return (Struct)A1.parseFrom(Struct.DEFAULT_INSTANCE, t0, g10);
    }

    public static Struct parseFrom(InputStream inputStream0) {
        return (Struct)A1.parseFrom(Struct.DEFAULT_INSTANCE, inputStream0);
    }

    public static Struct parseFrom(InputStream inputStream0, g1 g10) {
        return (Struct)A1.parseFrom(Struct.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Struct parseFrom(ByteBuffer byteBuffer0) {
        return (Struct)A1.parseFrom(Struct.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static Struct parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (Struct)A1.parseFrom(Struct.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static Struct parseFrom(byte[] arr_b) {
        return (Struct)A1.parseFrom(Struct.DEFAULT_INSTANCE, arr_b);
    }

    public static Struct parseFrom(byte[] arr_b, g1 g10) {
        return (Struct)A1.parseFrom(Struct.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return Struct.DEFAULT_INSTANCE.getParserForType();
    }
}

