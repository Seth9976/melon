package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class Enum extends A1 implements m2 {
    private static final Enum DEFAULT_INSTANCE = null;
    public static final int EDITION_FIELD_NUMBER = 6;
    public static final int ENUMVALUE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile z2 PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 5;
    private int bitField0_;
    private String edition_;
    private O1 enumvalue_;
    private String name_;
    private O1 options_;
    private SourceContext sourceContext_;
    private int syntax_;

    static {
        Enum enum0 = new Enum();
        Enum.DEFAULT_INSTANCE = enum0;
        A1.registerDefaultInstance(Enum.class, enum0);
    }

    private Enum() {
        this.name_ = "";
        this.enumvalue_ = A1.emptyProtobufList();
        this.options_ = A1.emptyProtobufList();
        this.edition_ = "";
    }

    public static void access$100(Enum enum0, String s) {
        enum0.setName(s);
    }

    public static void access$1000(Enum enum0, int v, Option option0) {
        enum0.setOptions(v, option0);
    }

    public static void access$1100(Enum enum0, Option option0) {
        enum0.addOptions(option0);
    }

    public static void access$1200(Enum enum0, int v, Option option0) {
        enum0.addOptions(v, option0);
    }

    public static void access$1300(Enum enum0, Iterable iterable0) {
        enum0.addAllOptions(iterable0);
    }

    public static void access$1400(Enum enum0) {
        enum0.clearOptions();
    }

    public static void access$1500(Enum enum0, int v) {
        enum0.removeOptions(v);
    }

    public static void access$1600(Enum enum0, SourceContext sourceContext0) {
        enum0.setSourceContext(sourceContext0);
    }

    public static void access$1700(Enum enum0, SourceContext sourceContext0) {
        enum0.mergeSourceContext(sourceContext0);
    }

    public static void access$1800(Enum enum0) {
        enum0.clearSourceContext();
    }

    public static void access$1900(Enum enum0, int v) {
        enum0.setSyntaxValue(v);
    }

    public static void access$200(Enum enum0) {
        enum0.clearName();
    }

    public static void access$2000(Enum enum0, M2 m20) {
        enum0.setSyntax(m20);
    }

    public static void access$2100(Enum enum0) {
        enum0.clearSyntax();
    }

    public static void access$2200(Enum enum0, String s) {
        enum0.setEdition(s);
    }

    public static void access$2300(Enum enum0) {
        enum0.clearEdition();
    }

    public static void access$2400(Enum enum0, o o0) {
        enum0.setEditionBytes(o0);
    }

    public static void access$300(Enum enum0, o o0) {
        enum0.setNameBytes(o0);
    }

    public static void access$400(Enum enum0, int v, EnumValue enumValue0) {
        enum0.setEnumvalue(v, enumValue0);
    }

    public static void access$500(Enum enum0, EnumValue enumValue0) {
        enum0.addEnumvalue(enumValue0);
    }

    public static void access$600(Enum enum0, int v, EnumValue enumValue0) {
        enum0.addEnumvalue(v, enumValue0);
    }

    public static void access$700(Enum enum0, Iterable iterable0) {
        enum0.addAllEnumvalue(iterable0);
    }

    public static void access$800(Enum enum0) {
        enum0.clearEnumvalue();
    }

    public static void access$900(Enum enum0, int v) {
        enum0.removeEnumvalue(v);
    }

    private void addAllEnumvalue(Iterable iterable0) {
        this.ensureEnumvalueIsMutable();
        b.addAll(iterable0, this.enumvalue_);
    }

    private void addAllOptions(Iterable iterable0) {
        this.ensureOptionsIsMutable();
        b.addAll(iterable0, this.options_);
    }

    private void addEnumvalue(int v, EnumValue enumValue0) {
        enumValue0.getClass();
        this.ensureEnumvalueIsMutable();
        this.enumvalue_.add(v, enumValue0);
    }

    private void addEnumvalue(EnumValue enumValue0) {
        enumValue0.getClass();
        this.ensureEnumvalueIsMutable();
        this.enumvalue_.add(enumValue0);
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

    private void clearEnumvalue() {
        this.enumvalue_ = A1.emptyProtobufList();
    }

    private void clearName() {
        this.name_ = "";
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
                return A1.newMessageInfo(Enum.DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001Ȉ\u0002\u001B\u0003\u001B\u0004ဉ\u0000\u0005\f\u0006Ȉ", new Object[]{"bitField0_", "name_", "enumvalue_", EnumValue.class, "options_", Option.class, "sourceContext_", "syntax_", "edition_"});
            }
            case 3: {
                return new Enum();
            }
            case 4: {
                return new a1(Enum.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return Enum.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = Enum.PARSER;
                if(z20 == null) {
                    synchronized(Enum.class) {
                        z21 = Enum.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            Enum.PARSER = z21;
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

    private void ensureEnumvalueIsMutable() {
        O1 o10 = this.enumvalue_;
        if(!((c)o10).a) {
            this.enumvalue_ = A1.mutableCopy(o10);
        }
    }

    private void ensureOptionsIsMutable() {
        O1 o10 = this.options_;
        if(!((c)o10).a) {
            this.options_ = A1.mutableCopy(o10);
        }
    }

    public static Enum getDefaultInstance() {
        return Enum.DEFAULT_INSTANCE;
    }

    public String getEdition() [...] // 潜在的解密器

    public o getEditionBytes() {
        return o.e(this.edition_);
    }

    public EnumValue getEnumvalue(int v) {
        return (EnumValue)this.enumvalue_.get(v);
    }

    public int getEnumvalueCount() {
        return this.enumvalue_.size();
    }

    public List getEnumvalueList() {
        return this.enumvalue_;
    }

    public c1 getEnumvalueOrBuilder(int v) {
        return (c1)this.enumvalue_.get(v);
    }

    public List getEnumvalueOrBuilderList() {
        return this.enumvalue_;
    }

    public String getName() [...] // 潜在的解密器

    public o getNameBytes() {
        return o.e(this.name_);
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

    public static a1 newBuilder() {
        return (a1)Enum.DEFAULT_INSTANCE.createBuilder();
    }

    public static a1 newBuilder(Enum enum0) {
        return (a1)Enum.DEFAULT_INSTANCE.createBuilder(enum0);
    }

    public static Enum parseDelimitedFrom(InputStream inputStream0) {
        return (Enum)A1.parseDelimitedFrom(Enum.DEFAULT_INSTANCE, inputStream0);
    }

    public static Enum parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (Enum)A1.parseDelimitedFrom(Enum.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Enum parseFrom(o o0) {
        return (Enum)A1.parseFrom(Enum.DEFAULT_INSTANCE, o0);
    }

    public static Enum parseFrom(o o0, g1 g10) {
        return (Enum)A1.parseFrom(Enum.DEFAULT_INSTANCE, o0, g10);
    }

    public static Enum parseFrom(t t0) {
        return (Enum)A1.parseFrom(Enum.DEFAULT_INSTANCE, t0);
    }

    public static Enum parseFrom(t t0, g1 g10) {
        return (Enum)A1.parseFrom(Enum.DEFAULT_INSTANCE, t0, g10);
    }

    public static Enum parseFrom(InputStream inputStream0) {
        return (Enum)A1.parseFrom(Enum.DEFAULT_INSTANCE, inputStream0);
    }

    public static Enum parseFrom(InputStream inputStream0, g1 g10) {
        return (Enum)A1.parseFrom(Enum.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Enum parseFrom(ByteBuffer byteBuffer0) {
        return (Enum)A1.parseFrom(Enum.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static Enum parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (Enum)A1.parseFrom(Enum.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static Enum parseFrom(byte[] arr_b) {
        return (Enum)A1.parseFrom(Enum.DEFAULT_INSTANCE, arr_b);
    }

    public static Enum parseFrom(byte[] arr_b, g1 g10) {
        return (Enum)A1.parseFrom(Enum.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return Enum.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeEnumvalue(int v) {
        this.ensureEnumvalueIsMutable();
        this.enumvalue_.remove(v);
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

    private void setEnumvalue(int v, EnumValue enumValue0) {
        enumValue0.getClass();
        this.ensureEnumvalueIsMutable();
        this.enumvalue_.set(v, enumValue0);
    }

    private void setName(String s) {
        s.getClass();
        this.name_ = s;
    }

    private void setNameBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.name_ = o0.p();
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

