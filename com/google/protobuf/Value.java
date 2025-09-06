package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Value extends A1 implements e3 {
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    private static final Value DEFAULT_INSTANCE = null;
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
    private static volatile z2 PARSER = null;
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    private int kindCase_;
    private Object kind_;

    static {
        Value value0 = new Value();
        Value.DEFAULT_INSTANCE = value0;
        A1.registerDefaultInstance(Value.class, value0);
    }

    private Value() {
        this.kindCase_ = 0;
    }

    public static void access$100(Value value0) {
        value0.clearKind();
    }

    public static void access$1000(Value value0, boolean z) {
        value0.setBoolValue(z);
    }

    public static void access$1100(Value value0) {
        value0.clearBoolValue();
    }

    public static void access$1200(Value value0, Struct struct0) {
        value0.setStructValue(struct0);
    }

    public static void access$1300(Value value0, Struct struct0) {
        value0.mergeStructValue(struct0);
    }

    public static void access$1400(Value value0) {
        value0.clearStructValue();
    }

    public static void access$1500(Value value0, ListValue listValue0) {
        value0.setListValue(listValue0);
    }

    public static void access$1600(Value value0, ListValue listValue0) {
        value0.mergeListValue(listValue0);
    }

    public static void access$1700(Value value0) {
        value0.clearListValue();
    }

    public static void access$200(Value value0, int v) {
        value0.setNullValueValue(v);
    }

    public static void access$300(Value value0, w2 w20) {
        value0.setNullValue(w20);
    }

    public static void access$400(Value value0) {
        value0.clearNullValue();
    }

    public static void access$500(Value value0, double f) {
        value0.setNumberValue(f);
    }

    public static void access$600(Value value0) {
        value0.clearNumberValue();
    }

    public static void access$700(Value value0, String s) {
        value0.setStringValue(s);
    }

    public static void access$800(Value value0) {
        value0.clearStringValue();
    }

    public static void access$900(Value value0, o o0) {
        value0.setStringValueBytes(o0);
    }

    private void clearBoolValue() {
        if(this.kindCase_ == 4) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    private void clearKind() {
        this.kindCase_ = 0;
        this.kind_ = null;
    }

    private void clearListValue() {
        if(this.kindCase_ == 6) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    private void clearNullValue() {
        if(this.kindCase_ == 1) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    private void clearNumberValue() {
        if(this.kindCase_ == 2) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    private void clearStringValue() {
        if(this.kindCase_ == 3) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    private void clearStructValue() {
        if(this.kindCase_ == 5) {
            this.kindCase_ = 0;
            this.kind_ = null;
        }
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(Value.DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001?\u0000\u00023\u0000\u0003Ȼ\u0000\u0004:\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"kind_", "kindCase_", Struct.class, ListValue.class});
            }
            case 3: {
                return new Value();
            }
            case 4: {
                return new c3(Value.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return Value.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = Value.PARSER;
                if(z20 == null) {
                    Class class0 = Value.class;
                    synchronized(class0) {
                        z2 z21 = Value.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            Value.PARSER = z21;
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

    public boolean getBoolValue() {
        return this.kindCase_ == 4 ? ((Boolean)this.kind_).booleanValue() : false;
    }

    public static Value getDefaultInstance() {
        return Value.DEFAULT_INSTANCE;
    }

    public d3 getKindCase() {
        switch(this.kindCase_) {
            case 0: {
                return d3.g;
            }
            case 1: {
                return d3.a;
            }
            case 2: {
                return d3.b;
            }
            case 3: {
                return d3.c;
            }
            case 4: {
                return d3.d;
            }
            case 5: {
                return d3.e;
            }
            case 6: {
                return d3.f;
            }
            default: {
                return null;
            }
        }
    }

    public ListValue getListValue() {
        return this.kindCase_ == 6 ? ((ListValue)this.kind_) : ListValue.getDefaultInstance();
    }

    public w2 getNullValue() {
        w2 w20 = w2.b;
        if(this.kindCase_ == 1) {
            if(((int)(((Integer)this.kind_))) != 0) {
                w20 = null;
            }
            return w20 == null ? w2.c : w20;
        }
        return w20;
    }

    public int getNullValueValue() {
        return this.kindCase_ == 1 ? ((int)(((Integer)this.kind_))) : 0;
    }

    public double getNumberValue() {
        return this.kindCase_ == 2 ? ((double)(((Double)this.kind_))) : 0.0;
    }

    public String getStringValue() {
        return this.kindCase_ == 3 ? ((String)this.kind_) : "";
    }

    public o getStringValueBytes() {
        return this.kindCase_ == 3 ? o.e(((String)this.kind_)) : o.e("");
    }

    public Struct getStructValue() {
        return this.kindCase_ == 5 ? ((Struct)this.kind_) : Struct.getDefaultInstance();
    }

    public boolean hasBoolValue() {
        return this.kindCase_ == 4;
    }

    public boolean hasListValue() {
        return this.kindCase_ == 6;
    }

    public boolean hasNullValue() {
        return this.kindCase_ == 1;
    }

    public boolean hasNumberValue() {
        return this.kindCase_ == 2;
    }

    public boolean hasStringValue() {
        return this.kindCase_ == 3;
    }

    public boolean hasStructValue() {
        return this.kindCase_ == 5;
    }

    private void mergeListValue(ListValue listValue0) {
        listValue0.getClass();
        if(this.kindCase_ != 6 || this.kind_ == ListValue.getDefaultInstance()) {
            this.kind_ = listValue0;
        }
        else {
            b2 b20 = ListValue.newBuilder(((ListValue)this.kind_));
            b20.f(listValue0);
            this.kind_ = b20.b();
        }
        this.kindCase_ = 6;
    }

    private void mergeStructValue(Struct struct0) {
        struct0.getClass();
        if(this.kindCase_ != 5 || this.kind_ == Struct.getDefaultInstance()) {
            this.kind_ = struct0;
        }
        else {
            K2 k20 = Struct.newBuilder(((Struct)this.kind_));
            k20.f(struct0);
            this.kind_ = k20.b();
        }
        this.kindCase_ = 5;
    }

    public static c3 newBuilder() {
        return (c3)Value.DEFAULT_INSTANCE.createBuilder();
    }

    public static c3 newBuilder(Value value0) {
        return (c3)Value.DEFAULT_INSTANCE.createBuilder(value0);
    }

    public static Value parseDelimitedFrom(InputStream inputStream0) {
        return (Value)A1.parseDelimitedFrom(Value.DEFAULT_INSTANCE, inputStream0);
    }

    public static Value parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (Value)A1.parseDelimitedFrom(Value.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Value parseFrom(o o0) {
        return (Value)A1.parseFrom(Value.DEFAULT_INSTANCE, o0);
    }

    public static Value parseFrom(o o0, g1 g10) {
        return (Value)A1.parseFrom(Value.DEFAULT_INSTANCE, o0, g10);
    }

    public static Value parseFrom(t t0) {
        return (Value)A1.parseFrom(Value.DEFAULT_INSTANCE, t0);
    }

    public static Value parseFrom(t t0, g1 g10) {
        return (Value)A1.parseFrom(Value.DEFAULT_INSTANCE, t0, g10);
    }

    public static Value parseFrom(InputStream inputStream0) {
        return (Value)A1.parseFrom(Value.DEFAULT_INSTANCE, inputStream0);
    }

    public static Value parseFrom(InputStream inputStream0, g1 g10) {
        return (Value)A1.parseFrom(Value.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Value parseFrom(ByteBuffer byteBuffer0) {
        return (Value)A1.parseFrom(Value.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static Value parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (Value)A1.parseFrom(Value.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static Value parseFrom(byte[] arr_b) {
        return (Value)A1.parseFrom(Value.DEFAULT_INSTANCE, arr_b);
    }

    public static Value parseFrom(byte[] arr_b, g1 g10) {
        return (Value)A1.parseFrom(Value.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return Value.DEFAULT_INSTANCE.getParserForType();
    }

    private void setBoolValue(boolean z) {
        this.kindCase_ = 4;
        this.kind_ = Boolean.valueOf(z);
    }

    private void setListValue(ListValue listValue0) {
        listValue0.getClass();
        this.kind_ = listValue0;
        this.kindCase_ = 6;
    }

    private void setNullValue(w2 w20) {
        this.kind_ = w20.a();
        this.kindCase_ = 1;
    }

    private void setNullValueValue(int v) {
        this.kindCase_ = 1;
        this.kind_ = v;
    }

    private void setNumberValue(double f) {
        this.kindCase_ = 2;
        this.kind_ = f;
    }

    private void setStringValue(String s) {
        s.getClass();
        this.kindCase_ = 3;
        this.kind_ = s;
    }

    private void setStringValueBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.kind_ = o0.p();
        this.kindCase_ = 3;
    }

    private void setStructValue(Struct struct0) {
        struct0.getClass();
        this.kind_ = struct0;
        this.kindCase_ = 5;
    }
}

