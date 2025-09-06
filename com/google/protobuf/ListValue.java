package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class ListValue extends A1 implements m2 {
    private static final ListValue DEFAULT_INSTANCE = null;
    private static volatile z2 PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private O1 values_;

    static {
        ListValue listValue0 = new ListValue();
        ListValue.DEFAULT_INSTANCE = listValue0;
        A1.registerDefaultInstance(ListValue.class, listValue0);
    }

    private ListValue() {
        this.values_ = A1.emptyProtobufList();
    }

    public static void access$100(ListValue listValue0, int v, Value value0) {
        listValue0.setValues(v, value0);
    }

    public static void access$200(ListValue listValue0, Value value0) {
        listValue0.addValues(value0);
    }

    public static void access$300(ListValue listValue0, int v, Value value0) {
        listValue0.addValues(v, value0);
    }

    public static void access$400(ListValue listValue0, Iterable iterable0) {
        listValue0.addAllValues(iterable0);
    }

    public static void access$500(ListValue listValue0) {
        listValue0.clearValues();
    }

    public static void access$600(ListValue listValue0, int v) {
        listValue0.removeValues(v);
    }

    private void addAllValues(Iterable iterable0) {
        this.ensureValuesIsMutable();
        b.addAll(iterable0, this.values_);
    }

    private void addValues(int v, Value value0) {
        value0.getClass();
        this.ensureValuesIsMutable();
        this.values_.add(v, value0);
    }

    private void addValues(Value value0) {
        value0.getClass();
        this.ensureValuesIsMutable();
        this.values_.add(value0);
    }

    private void clearValues() {
        this.values_ = A1.emptyProtobufList();
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(ListValue.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001B", new Object[]{"values_", Value.class});
            }
            case 3: {
                return new ListValue();
            }
            case 4: {
                return new b2(ListValue.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return ListValue.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = ListValue.PARSER;
                if(z20 == null) {
                    Class class0 = ListValue.class;
                    synchronized(class0) {
                        z2 z21 = ListValue.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            ListValue.PARSER = z21;
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

    private void ensureValuesIsMutable() {
        O1 o10 = this.values_;
        if(!((c)o10).a) {
            this.values_ = A1.mutableCopy(o10);
        }
    }

    public static ListValue getDefaultInstance() {
        return ListValue.DEFAULT_INSTANCE;
    }

    public Value getValues(int v) {
        return (Value)this.values_.get(v);
    }

    public int getValuesCount() {
        return this.values_.size();
    }

    public List getValuesList() {
        return this.values_;
    }

    public e3 getValuesOrBuilder(int v) {
        return (e3)this.values_.get(v);
    }

    public List getValuesOrBuilderList() {
        return this.values_;
    }

    public static b2 newBuilder() {
        return (b2)ListValue.DEFAULT_INSTANCE.createBuilder();
    }

    public static b2 newBuilder(ListValue listValue0) {
        return (b2)ListValue.DEFAULT_INSTANCE.createBuilder(listValue0);
    }

    public static ListValue parseDelimitedFrom(InputStream inputStream0) {
        return (ListValue)A1.parseDelimitedFrom(ListValue.DEFAULT_INSTANCE, inputStream0);
    }

    public static ListValue parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (ListValue)A1.parseDelimitedFrom(ListValue.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static ListValue parseFrom(o o0) {
        return (ListValue)A1.parseFrom(ListValue.DEFAULT_INSTANCE, o0);
    }

    public static ListValue parseFrom(o o0, g1 g10) {
        return (ListValue)A1.parseFrom(ListValue.DEFAULT_INSTANCE, o0, g10);
    }

    public static ListValue parseFrom(t t0) {
        return (ListValue)A1.parseFrom(ListValue.DEFAULT_INSTANCE, t0);
    }

    public static ListValue parseFrom(t t0, g1 g10) {
        return (ListValue)A1.parseFrom(ListValue.DEFAULT_INSTANCE, t0, g10);
    }

    public static ListValue parseFrom(InputStream inputStream0) {
        return (ListValue)A1.parseFrom(ListValue.DEFAULT_INSTANCE, inputStream0);
    }

    public static ListValue parseFrom(InputStream inputStream0, g1 g10) {
        return (ListValue)A1.parseFrom(ListValue.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static ListValue parseFrom(ByteBuffer byteBuffer0) {
        return (ListValue)A1.parseFrom(ListValue.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static ListValue parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (ListValue)A1.parseFrom(ListValue.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static ListValue parseFrom(byte[] arr_b) {
        return (ListValue)A1.parseFrom(ListValue.DEFAULT_INSTANCE, arr_b);
    }

    public static ListValue parseFrom(byte[] arr_b, g1 g10) {
        return (ListValue)A1.parseFrom(ListValue.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return ListValue.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeValues(int v) {
        this.ensureValuesIsMutable();
        this.values_.remove(v);
    }

    private void setValues(int v, Value value0) {
        value0.getClass();
        this.ensureValuesIsMutable();
        this.values_.set(v, value0);
    }
}

