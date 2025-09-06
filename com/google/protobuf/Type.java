package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class Type extends A1 implements m2 {
    private static final Type DEFAULT_INSTANCE = null;
    public static final int EDITION_FIELD_NUMBER = 7;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ONEOFS_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    private static volatile z2 PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 6;
    private int bitField0_;
    private String edition_;
    private O1 fields_;
    private String name_;
    private O1 oneofs_;
    private O1 options_;
    private SourceContext sourceContext_;
    private int syntax_;

    static {
        Type type0 = new Type();
        Type.DEFAULT_INSTANCE = type0;
        A1.registerDefaultInstance(Type.class, type0);
    }

    private Type() {
        this.name_ = "";
        this.fields_ = A1.emptyProtobufList();
        this.oneofs_ = A1.emptyProtobufList();
        this.options_ = A1.emptyProtobufList();
        this.edition_ = "";
    }

    public static void access$100(Type type0, String s) {
        type0.setName(s);
    }

    public static void access$1000(Type type0, int v, String s) {
        type0.setOneofs(v, s);
    }

    public static void access$1100(Type type0, String s) {
        type0.addOneofs(s);
    }

    public static void access$1200(Type type0, Iterable iterable0) {
        type0.addAllOneofs(iterable0);
    }

    public static void access$1300(Type type0) {
        type0.clearOneofs();
    }

    public static void access$1400(Type type0, o o0) {
        type0.addOneofsBytes(o0);
    }

    public static void access$1500(Type type0, int v, Option option0) {
        type0.setOptions(v, option0);
    }

    public static void access$1600(Type type0, Option option0) {
        type0.addOptions(option0);
    }

    public static void access$1700(Type type0, int v, Option option0) {
        type0.addOptions(v, option0);
    }

    public static void access$1800(Type type0, Iterable iterable0) {
        type0.addAllOptions(iterable0);
    }

    public static void access$1900(Type type0) {
        type0.clearOptions();
    }

    public static void access$200(Type type0) {
        type0.clearName();
    }

    public static void access$2000(Type type0, int v) {
        type0.removeOptions(v);
    }

    public static void access$2100(Type type0, SourceContext sourceContext0) {
        type0.setSourceContext(sourceContext0);
    }

    public static void access$2200(Type type0, SourceContext sourceContext0) {
        type0.mergeSourceContext(sourceContext0);
    }

    public static void access$2300(Type type0) {
        type0.clearSourceContext();
    }

    public static void access$2400(Type type0, int v) {
        type0.setSyntaxValue(v);
    }

    public static void access$2500(Type type0, M2 m20) {
        type0.setSyntax(m20);
    }

    public static void access$2600(Type type0) {
        type0.clearSyntax();
    }

    public static void access$2700(Type type0, String s) {
        type0.setEdition(s);
    }

    public static void access$2800(Type type0) {
        type0.clearEdition();
    }

    public static void access$2900(Type type0, o o0) {
        type0.setEditionBytes(o0);
    }

    public static void access$300(Type type0, o o0) {
        type0.setNameBytes(o0);
    }

    public static void access$400(Type type0, int v, Field field0) {
        type0.setFields(v, field0);
    }

    public static void access$500(Type type0, Field field0) {
        type0.addFields(field0);
    }

    public static void access$600(Type type0, int v, Field field0) {
        type0.addFields(v, field0);
    }

    public static void access$700(Type type0, Iterable iterable0) {
        type0.addAllFields(iterable0);
    }

    public static void access$800(Type type0) {
        type0.clearFields();
    }

    public static void access$900(Type type0, int v) {
        type0.removeFields(v);
    }

    private void addAllFields(Iterable iterable0) {
        this.ensureFieldsIsMutable();
        b.addAll(iterable0, this.fields_);
    }

    private void addAllOneofs(Iterable iterable0) {
        this.ensureOneofsIsMutable();
        b.addAll(iterable0, this.oneofs_);
    }

    private void addAllOptions(Iterable iterable0) {
        this.ensureOptionsIsMutable();
        b.addAll(iterable0, this.options_);
    }

    private void addFields(int v, Field field0) {
        field0.getClass();
        this.ensureFieldsIsMutable();
        this.fields_.add(v, field0);
    }

    private void addFields(Field field0) {
        field0.getClass();
        this.ensureFieldsIsMutable();
        this.fields_.add(field0);
    }

    private void addOneofs(String s) {
        s.getClass();
        this.ensureOneofsIsMutable();
        this.oneofs_.add(s);
    }

    private void addOneofsBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.ensureOneofsIsMutable();
        this.oneofs_.add(o0.p());
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

    private void clearEdition() {
        this.edition_ = "";
    }

    private void clearFields() {
        this.fields_ = A1.emptyProtobufList();
    }

    private void clearName() {
        this.name_ = "";
    }

    private void clearOneofs() {
        this.oneofs_ = A1.emptyProtobufList();
    }

    private void clearOptions() {
        this.options_ = A1.emptyProtobufList();
    }

    private void clearSourceContext() {
        this.sourceContext_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSyntax() {
        this.syntax_ = 0;
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        z2 z21;
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(Type.DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0003\u0000\u0001Ȉ\u0002\u001B\u0003Ț\u0004\u001B\u0005ဉ\u0000\u0006\f\u0007Ȉ", new Object[]{"bitField0_", "name_", "fields_", Field.class, "oneofs_", "options_", Option.class, "sourceContext_", "syntax_", "edition_"});
            }
            case 3: {
                return new Type();
            }
            case 4: {
                return new O2(Type.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return Type.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = Type.PARSER;
                if(z20 == null) {
                    synchronized(Type.class) {
                        z21 = Type.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            Type.PARSER = z21;
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

    private void ensureFieldsIsMutable() {
        O1 o10 = this.fields_;
        if(!((c)o10).a) {
            this.fields_ = A1.mutableCopy(o10);
        }
    }

    private void ensureOneofsIsMutable() {
        O1 o10 = this.oneofs_;
        if(!((c)o10).a) {
            this.oneofs_ = A1.mutableCopy(o10);
        }
    }

    private void ensureOptionsIsMutable() {
        O1 o10 = this.options_;
        if(!((c)o10).a) {
            this.options_ = A1.mutableCopy(o10);
        }
    }

    public static Type getDefaultInstance() {
        return Type.DEFAULT_INSTANCE;
    }

    public String getEdition() [...] // 潜在的解密器

    public o getEditionBytes() {
        return o.e(this.edition_);
    }

    public Field getFields(int v) {
        return (Field)this.fields_.get(v);
    }

    public int getFieldsCount() {
        return this.fields_.size();
    }

    public List getFieldsList() {
        return this.fields_;
    }

    public n1 getFieldsOrBuilder(int v) {
        return (n1)this.fields_.get(v);
    }

    public List getFieldsOrBuilderList() {
        return this.fields_;
    }

    public String getName() [...] // 潜在的解密器

    public o getNameBytes() {
        return o.e(this.name_);
    }

    public String getOneofs(int v) {
        return (String)this.oneofs_.get(v);
    }

    public o getOneofsBytes(int v) {
        return o.e(((String)this.oneofs_.get(v)));
    }

    public int getOneofsCount() {
        return this.oneofs_.size();
    }

    public List getOneofsList() {
        return this.oneofs_;
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

    public SourceContext getSourceContext() {
        return this.sourceContext_ == null ? SourceContext.getDefaultInstance() : this.sourceContext_;
    }

    public M2 getSyntax() {
        M2 m20 = M2.b(this.syntax_);
        return m20 == null ? M2.e : m20;
    }

    public int getSyntaxValue() {
        return this.syntax_;
    }

    public boolean hasSourceContext() {
        return (this.bitField0_ & 1) != 0;
    }

    private void mergeSourceContext(SourceContext sourceContext0) {
        sourceContext0.getClass();
        if(this.sourceContext_ == null || this.sourceContext_ == SourceContext.getDefaultInstance()) {
            this.sourceContext_ = sourceContext0;
        }
        else {
            I2 i20 = SourceContext.newBuilder(this.sourceContext_);
            i20.f(sourceContext0);
            this.sourceContext_ = (SourceContext)i20.b();
        }
        this.bitField0_ |= 1;
    }

    public static O2 newBuilder() {
        return (O2)Type.DEFAULT_INSTANCE.createBuilder();
    }

    public static O2 newBuilder(Type type0) {
        return (O2)Type.DEFAULT_INSTANCE.createBuilder(type0);
    }

    public static Type parseDelimitedFrom(InputStream inputStream0) {
        return (Type)A1.parseDelimitedFrom(Type.DEFAULT_INSTANCE, inputStream0);
    }

    public static Type parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (Type)A1.parseDelimitedFrom(Type.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Type parseFrom(o o0) {
        return (Type)A1.parseFrom(Type.DEFAULT_INSTANCE, o0);
    }

    public static Type parseFrom(o o0, g1 g10) {
        return (Type)A1.parseFrom(Type.DEFAULT_INSTANCE, o0, g10);
    }

    public static Type parseFrom(t t0) {
        return (Type)A1.parseFrom(Type.DEFAULT_INSTANCE, t0);
    }

    public static Type parseFrom(t t0, g1 g10) {
        return (Type)A1.parseFrom(Type.DEFAULT_INSTANCE, t0, g10);
    }

    public static Type parseFrom(InputStream inputStream0) {
        return (Type)A1.parseFrom(Type.DEFAULT_INSTANCE, inputStream0);
    }

    public static Type parseFrom(InputStream inputStream0, g1 g10) {
        return (Type)A1.parseFrom(Type.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Type parseFrom(ByteBuffer byteBuffer0) {
        return (Type)A1.parseFrom(Type.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static Type parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (Type)A1.parseFrom(Type.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static Type parseFrom(byte[] arr_b) {
        return (Type)A1.parseFrom(Type.DEFAULT_INSTANCE, arr_b);
    }

    public static Type parseFrom(byte[] arr_b, g1 g10) {
        return (Type)A1.parseFrom(Type.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return Type.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeFields(int v) {
        this.ensureFieldsIsMutable();
        this.fields_.remove(v);
    }

    private void removeOptions(int v) {
        this.ensureOptionsIsMutable();
        this.options_.remove(v);
    }

    private void setEdition(String s) {
        s.getClass();
        this.edition_ = s;
    }

    private void setEditionBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.edition_ = o0.p();
    }

    private void setFields(int v, Field field0) {
        field0.getClass();
        this.ensureFieldsIsMutable();
        this.fields_.set(v, field0);
    }

    private void setName(String s) {
        s.getClass();
        this.name_ = s;
    }

    private void setNameBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.name_ = o0.p();
    }

    private void setOneofs(int v, String s) {
        s.getClass();
        this.ensureOneofsIsMutable();
        this.oneofs_.set(v, s);
    }

    private void setOptions(int v, Option option0) {
        option0.getClass();
        this.ensureOptionsIsMutable();
        this.options_.set(v, option0);
    }

    private void setSourceContext(SourceContext sourceContext0) {
        sourceContext0.getClass();
        this.sourceContext_ = sourceContext0;
        this.bitField0_ |= 1;
    }

    private void setSyntax(M2 m20) {
        this.syntax_ = m20.a();
    }

    private void setSyntaxValue(int v) {
        this.syntax_ = v;
    }
}

