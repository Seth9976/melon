package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class Field extends A1 implements n1 {
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    private static final Field DEFAULT_INSTANCE = null;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    public static final int PACKED_FIELD_NUMBER = 8;
    private static volatile z2 PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    private int cardinality_;
    private String defaultValue_;
    private String jsonName_;
    private int kind_;
    private String name_;
    private int number_;
    private int oneofIndex_;
    private O1 options_;
    private boolean packed_;
    private String typeUrl_;

    static {
        Field field0 = new Field();
        Field.DEFAULT_INSTANCE = field0;
        A1.registerDefaultInstance(Field.class, field0);
    }

    private Field() {
        this.name_ = "";
        this.typeUrl_ = "";
        this.options_ = A1.emptyProtobufList();
        this.jsonName_ = "";
        this.defaultValue_ = "";
    }

    public static void access$100(Field field0, int v) {
        field0.setKindValue(v);
    }

    public static void access$1000(Field field0) {
        field0.clearName();
    }

    public static void access$1100(Field field0, o o0) {
        field0.setNameBytes(o0);
    }

    public static void access$1200(Field field0, String s) {
        field0.setTypeUrl(s);
    }

    public static void access$1300(Field field0) {
        field0.clearTypeUrl();
    }

    public static void access$1400(Field field0, o o0) {
        field0.setTypeUrlBytes(o0);
    }

    public static void access$1500(Field field0, int v) {
        field0.setOneofIndex(v);
    }

    public static void access$1600(Field field0) {
        field0.clearOneofIndex();
    }

    public static void access$1700(Field field0, boolean z) {
        field0.setPacked(z);
    }

    public static void access$1800(Field field0) {
        field0.clearPacked();
    }

    public static void access$1900(Field field0, int v, Option option0) {
        field0.setOptions(v, option0);
    }

    public static void access$200(Field field0, l1 l10) {
        field0.setKind(l10);
    }

    public static void access$2000(Field field0, Option option0) {
        field0.addOptions(option0);
    }

    public static void access$2100(Field field0, int v, Option option0) {
        field0.addOptions(v, option0);
    }

    public static void access$2200(Field field0, Iterable iterable0) {
        field0.addAllOptions(iterable0);
    }

    public static void access$2300(Field field0) {
        field0.clearOptions();
    }

    public static void access$2400(Field field0, int v) {
        field0.removeOptions(v);
    }

    public static void access$2500(Field field0, String s) {
        field0.setJsonName(s);
    }

    public static void access$2600(Field field0) {
        field0.clearJsonName();
    }

    public static void access$2700(Field field0, o o0) {
        field0.setJsonNameBytes(o0);
    }

    public static void access$2800(Field field0, String s) {
        field0.setDefaultValue(s);
    }

    public static void access$2900(Field field0) {
        field0.clearDefaultValue();
    }

    public static void access$300(Field field0) {
        field0.clearKind();
    }

    public static void access$3000(Field field0, o o0) {
        field0.setDefaultValueBytes(o0);
    }

    public static void access$400(Field field0, int v) {
        field0.setCardinalityValue(v);
    }

    public static void access$500(Field field0, k1 k10) {
        field0.setCardinality(k10);
    }

    public static void access$600(Field field0) {
        field0.clearCardinality();
    }

    public static void access$700(Field field0, int v) {
        field0.setNumber(v);
    }

    public static void access$800(Field field0) {
        field0.clearNumber();
    }

    public static void access$900(Field field0, String s) {
        field0.setName(s);
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

    private void clearCardinality() {
        this.cardinality_ = 0;
    }

    private void clearDefaultValue() {
        this.defaultValue_ = "";
    }

    private void clearJsonName() {
        this.jsonName_ = "";
    }

    private void clearKind() {
        this.kind_ = 0;
    }

    private void clearName() {
        this.name_ = "";
    }

    private void clearNumber() {
        this.number_ = 0;
    }

    private void clearOneofIndex() {
        this.oneofIndex_ = 0;
    }

    private void clearOptions() {
        this.options_ = A1.emptyProtobufList();
    }

    private void clearPacked() {
        this.packed_ = false;
    }

    private void clearTypeUrl() {
        this.typeUrl_ = "";
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        z2 z21;
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(Field.DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\u000B\n\u0000\u0001\u0000\u0001\f\u0002\f\u0003\u0004\u0004Ȉ\u0006Ȉ\u0007\u0004\b\u0007\t\u001B\nȈ\u000BȈ", new Object[]{"kind_", "cardinality_", "number_", "name_", "typeUrl_", "oneofIndex_", "packed_", "options_", Option.class, "jsonName_", "defaultValue_"});
            }
            case 3: {
                return new Field();
            }
            case 4: {
                return new j1(Field.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return Field.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = Field.PARSER;
                if(z20 == null) {
                    synchronized(Field.class) {
                        z21 = Field.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            Field.PARSER = z21;
                        }
                    }
                    return z21;
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

    public k1 getCardinality() {
        switch(this.cardinality_) {
            case 0: {
                return k1.b == null ? k1.f : k1.b;
            }
            case 1: {
                return k1.c == null ? k1.f : k1.c;
            }
            case 2: {
                return k1.d == null ? k1.f : k1.d;
            }
            case 3: {
                return k1.e == null ? k1.f : k1.e;
            }
            default: {
                return k1.f;
            }
        }
    }

    public int getCardinalityValue() {
        return this.cardinality_;
    }

    public static Field getDefaultInstance() {
        return Field.DEFAULT_INSTANCE;
    }

    public String getDefaultValue() [...] // 潜在的解密器

    public o getDefaultValueBytes() {
        return o.e(this.defaultValue_);
    }

    public String getJsonName() [...] // 潜在的解密器

    public o getJsonNameBytes() {
        return o.e(this.jsonName_);
    }

    public l1 getKind() {
        switch(this.kind_) {
            case 0: {
                return l1.b == null ? l1.G : l1.b;
            }
            case 1: {
                return l1.c == null ? l1.G : l1.c;
            }
            case 2: {
                return l1.d == null ? l1.G : l1.d;
            }
            case 3: {
                return l1.e == null ? l1.G : l1.e;
            }
            case 4: {
                return l1.f == null ? l1.G : l1.f;
            }
            case 5: {
                return l1.g == null ? l1.G : l1.g;
            }
            case 6: {
                return l1.h == null ? l1.G : l1.h;
            }
            case 7: {
                return l1.i == null ? l1.G : l1.i;
            }
            case 8: {
                return l1.j == null ? l1.G : l1.j;
            }
            case 9: {
                return l1.k == null ? l1.G : l1.k;
            }
            case 10: {
                return l1.l == null ? l1.G : l1.l;
            }
            case 11: {
                return l1.m == null ? l1.G : l1.m;
            }
            case 12: {
                return l1.n == null ? l1.G : l1.n;
            }
            case 13: {
                return l1.o == null ? l1.G : l1.o;
            }
            case 14: {
                return l1.r == null ? l1.G : l1.r;
            }
            case 15: {
                return l1.w == null ? l1.G : l1.w;
            }
            case 16: {
                return l1.B == null ? l1.G : l1.B;
            }
            case 17: {
                return l1.D == null ? l1.G : l1.D;
            }
            case 18: {
                return l1.E == null ? l1.G : l1.E;
            }
            default: {
                return l1.G;
            }
        }
    }

    public int getKindValue() {
        return this.kind_;
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

    public boolean getPacked() {
        return this.packed_;
    }

    public String getTypeUrl() [...] // 潜在的解密器

    public o getTypeUrlBytes() {
        return o.e(this.typeUrl_);
    }

    public static j1 newBuilder() {
        return (j1)Field.DEFAULT_INSTANCE.createBuilder();
    }

    public static j1 newBuilder(Field field0) {
        return (j1)Field.DEFAULT_INSTANCE.createBuilder(field0);
    }

    public static Field parseDelimitedFrom(InputStream inputStream0) {
        return (Field)A1.parseDelimitedFrom(Field.DEFAULT_INSTANCE, inputStream0);
    }

    public static Field parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (Field)A1.parseDelimitedFrom(Field.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Field parseFrom(o o0) {
        return (Field)A1.parseFrom(Field.DEFAULT_INSTANCE, o0);
    }

    public static Field parseFrom(o o0, g1 g10) {
        return (Field)A1.parseFrom(Field.DEFAULT_INSTANCE, o0, g10);
    }

    public static Field parseFrom(t t0) {
        return (Field)A1.parseFrom(Field.DEFAULT_INSTANCE, t0);
    }

    public static Field parseFrom(t t0, g1 g10) {
        return (Field)A1.parseFrom(Field.DEFAULT_INSTANCE, t0, g10);
    }

    public static Field parseFrom(InputStream inputStream0) {
        return (Field)A1.parseFrom(Field.DEFAULT_INSTANCE, inputStream0);
    }

    public static Field parseFrom(InputStream inputStream0, g1 g10) {
        return (Field)A1.parseFrom(Field.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Field parseFrom(ByteBuffer byteBuffer0) {
        return (Field)A1.parseFrom(Field.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static Field parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (Field)A1.parseFrom(Field.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static Field parseFrom(byte[] arr_b) {
        return (Field)A1.parseFrom(Field.DEFAULT_INSTANCE, arr_b);
    }

    public static Field parseFrom(byte[] arr_b, g1 g10) {
        return (Field)A1.parseFrom(Field.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return Field.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeOptions(int v) {
        this.ensureOptionsIsMutable();
        this.options_.remove(v);
    }

    private void setCardinality(k1 k10) {
        this.cardinality_ = k10.a();
    }

    private void setCardinalityValue(int v) {
        this.cardinality_ = v;
    }

    private void setDefaultValue(String s) {
        s.getClass();
        this.defaultValue_ = s;
    }

    private void setDefaultValueBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.defaultValue_ = o0.p();
    }

    private void setJsonName(String s) {
        s.getClass();
        this.jsonName_ = s;
    }

    private void setJsonNameBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.jsonName_ = o0.p();
    }

    private void setKind(l1 l10) {
        this.kind_ = l10.a();
    }

    private void setKindValue(int v) {
        this.kind_ = v;
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

    private void setOneofIndex(int v) {
        this.oneofIndex_ = v;
    }

    private void setOptions(int v, Option option0) {
        option0.getClass();
        this.ensureOptionsIsMutable();
        this.options_.set(v, option0);
    }

    private void setPacked(boolean z) {
        this.packed_ = z;
    }

    private void setTypeUrl(String s) {
        s.getClass();
        this.typeUrl_ = s;
    }

    private void setTypeUrlBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.typeUrl_ = o0.p();
    }
}

