package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class Api extends A1 implements m2 {
    private static final Api DEFAULT_INSTANCE = null;
    public static final int METHODS_FIELD_NUMBER = 2;
    public static final int MIXINS_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile z2 PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    public static final int VERSION_FIELD_NUMBER = 4;
    private int bitField0_;
    private O1 methods_;
    private O1 mixins_;
    private String name_;
    private O1 options_;
    private SourceContext sourceContext_;
    private int syntax_;
    private String version_;

    static {
        Api api0 = new Api();
        Api.DEFAULT_INSTANCE = api0;
        A1.registerDefaultInstance(Api.class, api0);
    }

    private Api() {
        this.name_ = "";
        this.methods_ = A1.emptyProtobufList();
        this.options_ = A1.emptyProtobufList();
        this.version_ = "";
        this.mixins_ = A1.emptyProtobufList();
    }

    public static void access$100(Api api0, String s) {
        api0.setName(s);
    }

    public static void access$1000(Api api0, int v, Option option0) {
        api0.setOptions(v, option0);
    }

    public static void access$1100(Api api0, Option option0) {
        api0.addOptions(option0);
    }

    public static void access$1200(Api api0, int v, Option option0) {
        api0.addOptions(v, option0);
    }

    public static void access$1300(Api api0, Iterable iterable0) {
        api0.addAllOptions(iterable0);
    }

    public static void access$1400(Api api0) {
        api0.clearOptions();
    }

    public static void access$1500(Api api0, int v) {
        api0.removeOptions(v);
    }

    public static void access$1600(Api api0, String s) {
        api0.setVersion(s);
    }

    public static void access$1700(Api api0) {
        api0.clearVersion();
    }

    public static void access$1800(Api api0, o o0) {
        api0.setVersionBytes(o0);
    }

    public static void access$1900(Api api0, SourceContext sourceContext0) {
        api0.setSourceContext(sourceContext0);
    }

    public static void access$200(Api api0) {
        api0.clearName();
    }

    public static void access$2000(Api api0, SourceContext sourceContext0) {
        api0.mergeSourceContext(sourceContext0);
    }

    public static void access$2100(Api api0) {
        api0.clearSourceContext();
    }

    public static void access$2200(Api api0, int v, Mixin mixin0) {
        api0.setMixins(v, mixin0);
    }

    public static void access$2300(Api api0, Mixin mixin0) {
        api0.addMixins(mixin0);
    }

    public static void access$2400(Api api0, int v, Mixin mixin0) {
        api0.addMixins(v, mixin0);
    }

    public static void access$2500(Api api0, Iterable iterable0) {
        api0.addAllMixins(iterable0);
    }

    public static void access$2600(Api api0) {
        api0.clearMixins();
    }

    public static void access$2700(Api api0, int v) {
        api0.removeMixins(v);
    }

    public static void access$2800(Api api0, int v) {
        api0.setSyntaxValue(v);
    }

    public static void access$2900(Api api0, M2 m20) {
        api0.setSyntax(m20);
    }

    public static void access$300(Api api0, o o0) {
        api0.setNameBytes(o0);
    }

    public static void access$3000(Api api0) {
        api0.clearSyntax();
    }

    public static void access$400(Api api0, int v, Method method0) {
        api0.setMethods(v, method0);
    }

    public static void access$500(Api api0, Method method0) {
        api0.addMethods(method0);
    }

    public static void access$600(Api api0, int v, Method method0) {
        api0.addMethods(v, method0);
    }

    public static void access$700(Api api0, Iterable iterable0) {
        api0.addAllMethods(iterable0);
    }

    public static void access$800(Api api0) {
        api0.clearMethods();
    }

    public static void access$900(Api api0, int v) {
        api0.removeMethods(v);
    }

    private void addAllMethods(Iterable iterable0) {
        this.ensureMethodsIsMutable();
        b.addAll(iterable0, this.methods_);
    }

    private void addAllMixins(Iterable iterable0) {
        this.ensureMixinsIsMutable();
        b.addAll(iterable0, this.mixins_);
    }

    private void addAllOptions(Iterable iterable0) {
        this.ensureOptionsIsMutable();
        b.addAll(iterable0, this.options_);
    }

    private void addMethods(int v, Method method0) {
        method0.getClass();
        this.ensureMethodsIsMutable();
        this.methods_.add(v, method0);
    }

    private void addMethods(Method method0) {
        method0.getClass();
        this.ensureMethodsIsMutable();
        this.methods_.add(method0);
    }

    private void addMixins(int v, Mixin mixin0) {
        mixin0.getClass();
        this.ensureMixinsIsMutable();
        this.mixins_.add(v, mixin0);
    }

    private void addMixins(Mixin mixin0) {
        mixin0.getClass();
        this.ensureMixinsIsMutable();
        this.mixins_.add(mixin0);
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

    private void clearMethods() {
        this.methods_ = A1.emptyProtobufList();
    }

    private void clearMixins() {
        this.mixins_ = A1.emptyProtobufList();
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

    private void clearVersion() {
        this.version_ = "";
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        z2 z21;
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(Api.DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0003\u0000\u0001Ȉ\u0002\u001B\u0003\u001B\u0004Ȉ\u0005ဉ\u0000\u0006\u001B\u0007\f", new Object[]{"bitField0_", "name_", "methods_", Method.class, "options_", Option.class, "version_", "sourceContext_", "mixins_", Mixin.class, "syntax_"});
            }
            case 3: {
                return new Api();
            }
            case 4: {
                return new f(Api.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return Api.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = Api.PARSER;
                if(z20 == null) {
                    synchronized(Api.class) {
                        z21 = Api.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            Api.PARSER = z21;
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

    private void ensureMethodsIsMutable() {
        O1 o10 = this.methods_;
        if(!((c)o10).a) {
            this.methods_ = A1.mutableCopy(o10);
        }
    }

    private void ensureMixinsIsMutable() {
        O1 o10 = this.mixins_;
        if(!((c)o10).a) {
            this.mixins_ = A1.mutableCopy(o10);
        }
    }

    private void ensureOptionsIsMutable() {
        O1 o10 = this.options_;
        if(!((c)o10).a) {
            this.options_ = A1.mutableCopy(o10);
        }
    }

    public static Api getDefaultInstance() {
        return Api.DEFAULT_INSTANCE;
    }

    public Method getMethods(int v) {
        return (Method)this.methods_.get(v);
    }

    public int getMethodsCount() {
        return this.methods_.size();
    }

    public List getMethodsList() {
        return this.methods_;
    }

    public r2 getMethodsOrBuilder(int v) {
        return (r2)this.methods_.get(v);
    }

    public List getMethodsOrBuilderList() {
        return this.methods_;
    }

    public Mixin getMixins(int v) {
        return (Mixin)this.mixins_.get(v);
    }

    public int getMixinsCount() {
        return this.mixins_.size();
    }

    public List getMixinsList() {
        return this.mixins_;
    }

    public t2 getMixinsOrBuilder(int v) {
        return (t2)this.mixins_.get(v);
    }

    public List getMixinsOrBuilderList() {
        return this.mixins_;
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

    public String getVersion() [...] // 潜在的解密器

    public o getVersionBytes() {
        return o.e(this.version_);
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

    public static f newBuilder() {
        return (f)Api.DEFAULT_INSTANCE.createBuilder();
    }

    public static f newBuilder(Api api0) {
        return (f)Api.DEFAULT_INSTANCE.createBuilder(api0);
    }

    public static Api parseDelimitedFrom(InputStream inputStream0) {
        return (Api)A1.parseDelimitedFrom(Api.DEFAULT_INSTANCE, inputStream0);
    }

    public static Api parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (Api)A1.parseDelimitedFrom(Api.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Api parseFrom(o o0) {
        return (Api)A1.parseFrom(Api.DEFAULT_INSTANCE, o0);
    }

    public static Api parseFrom(o o0, g1 g10) {
        return (Api)A1.parseFrom(Api.DEFAULT_INSTANCE, o0, g10);
    }

    public static Api parseFrom(t t0) {
        return (Api)A1.parseFrom(Api.DEFAULT_INSTANCE, t0);
    }

    public static Api parseFrom(t t0, g1 g10) {
        return (Api)A1.parseFrom(Api.DEFAULT_INSTANCE, t0, g10);
    }

    public static Api parseFrom(InputStream inputStream0) {
        return (Api)A1.parseFrom(Api.DEFAULT_INSTANCE, inputStream0);
    }

    public static Api parseFrom(InputStream inputStream0, g1 g10) {
        return (Api)A1.parseFrom(Api.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Api parseFrom(ByteBuffer byteBuffer0) {
        return (Api)A1.parseFrom(Api.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static Api parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (Api)A1.parseFrom(Api.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static Api parseFrom(byte[] arr_b) {
        return (Api)A1.parseFrom(Api.DEFAULT_INSTANCE, arr_b);
    }

    public static Api parseFrom(byte[] arr_b, g1 g10) {
        return (Api)A1.parseFrom(Api.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return Api.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMethods(int v) {
        this.ensureMethodsIsMutable();
        this.methods_.remove(v);
    }

    private void removeMixins(int v) {
        this.ensureMixinsIsMutable();
        this.mixins_.remove(v);
    }

    private void removeOptions(int v) {
        this.ensureOptionsIsMutable();
        this.options_.remove(v);
    }

    private void setMethods(int v, Method method0) {
        method0.getClass();
        this.ensureMethodsIsMutable();
        this.methods_.set(v, method0);
    }

    private void setMixins(int v, Mixin mixin0) {
        mixin0.getClass();
        this.ensureMixinsIsMutable();
        this.mixins_.set(v, mixin0);
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

    private void setVersion(String s) {
        s.getClass();
        this.version_ = s;
    }

    private void setVersionBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.version_ = o0.p();
    }
}

