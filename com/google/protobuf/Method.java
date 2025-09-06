package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class Method extends A1 implements r2 {
    private static final Method DEFAULT_INSTANCE = null;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 6;
    private static volatile z2 PARSER = null;
    public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
    public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
    public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    private String name_;
    private O1 options_;
    private boolean requestStreaming_;
    private String requestTypeUrl_;
    private boolean responseStreaming_;
    private String responseTypeUrl_;
    private int syntax_;

    static {
        Method method0 = new Method();
        Method.DEFAULT_INSTANCE = method0;
        A1.registerDefaultInstance(Method.class, method0);
    }

    private Method() {
        this.name_ = "";
        this.requestTypeUrl_ = "";
        this.responseTypeUrl_ = "";
        this.options_ = A1.emptyProtobufList();
    }

    public static void access$100(Method method0, String s) {
        method0.setName(s);
    }

    public static void access$1000(Method method0) {
        method0.clearResponseTypeUrl();
    }

    public static void access$1100(Method method0, o o0) {
        method0.setResponseTypeUrlBytes(o0);
    }

    public static void access$1200(Method method0, boolean z) {
        method0.setResponseStreaming(z);
    }

    public static void access$1300(Method method0) {
        method0.clearResponseStreaming();
    }

    public static void access$1400(Method method0, int v, Option option0) {
        method0.setOptions(v, option0);
    }

    public static void access$1500(Method method0, Option option0) {
        method0.addOptions(option0);
    }

    public static void access$1600(Method method0, int v, Option option0) {
        method0.addOptions(v, option0);
    }

    public static void access$1700(Method method0, Iterable iterable0) {
        method0.addAllOptions(iterable0);
    }

    public static void access$1800(Method method0) {
        method0.clearOptions();
    }

    public static void access$1900(Method method0, int v) {
        method0.removeOptions(v);
    }

    public static void access$200(Method method0) {
        method0.clearName();
    }

    public static void access$2000(Method method0, int v) {
        method0.setSyntaxValue(v);
    }

    public static void access$2100(Method method0, M2 m20) {
        method0.setSyntax(m20);
    }

    public static void access$2200(Method method0) {
        method0.clearSyntax();
    }

    public static void access$300(Method method0, o o0) {
        method0.setNameBytes(o0);
    }

    public static void access$400(Method method0, String s) {
        method0.setRequestTypeUrl(s);
    }

    public static void access$500(Method method0) {
        method0.clearRequestTypeUrl();
    }

    public static void access$600(Method method0, o o0) {
        method0.setRequestTypeUrlBytes(o0);
    }

    public static void access$700(Method method0, boolean z) {
        method0.setRequestStreaming(z);
    }

    public static void access$800(Method method0) {
        method0.clearRequestStreaming();
    }

    public static void access$900(Method method0, String s) {
        method0.setResponseTypeUrl(s);
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

    private void clearName() {
        this.name_ = "";
    }

    private void clearOptions() {
        this.options_ = A1.emptyProtobufList();
    }

    private void clearRequestStreaming() {
        this.requestStreaming_ = false;
    }

    private void clearRequestTypeUrl() {
        this.requestTypeUrl_ = "";
    }

    private void clearResponseStreaming() {
        this.responseStreaming_ = false;
    }

    private void clearResponseTypeUrl() {
        this.responseTypeUrl_ = "";
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
                return A1.newMessageInfo(Method.DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004Ȉ\u0005\u0007\u0006\u001B\u0007\f", new Object[]{"name_", "requestTypeUrl_", "requestStreaming_", "responseTypeUrl_", "responseStreaming_", "options_", Option.class, "syntax_"});
            }
            case 3: {
                return new Method();
            }
            case 4: {
                return new q2(Method.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return Method.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = Method.PARSER;
                if(z20 == null) {
                    synchronized(Method.class) {
                        z21 = Method.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            Method.PARSER = z21;
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

    public static Method getDefaultInstance() {
        return Method.DEFAULT_INSTANCE;
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

    public boolean getRequestStreaming() {
        return this.requestStreaming_;
    }

    public String getRequestTypeUrl() [...] // 潜在的解密器

    public o getRequestTypeUrlBytes() {
        return o.e(this.requestTypeUrl_);
    }

    public boolean getResponseStreaming() {
        return this.responseStreaming_;
    }

    public String getResponseTypeUrl() [...] // 潜在的解密器

    public o getResponseTypeUrlBytes() {
        return o.e(this.responseTypeUrl_);
    }

    public M2 getSyntax() {
        M2 m20 = M2.b(this.syntax_);
        return m20 == null ? M2.e : m20;
    }

    public int getSyntaxValue() {
        return this.syntax_;
    }

    public static q2 newBuilder() {
        return (q2)Method.DEFAULT_INSTANCE.createBuilder();
    }

    public static q2 newBuilder(Method method0) {
        return (q2)Method.DEFAULT_INSTANCE.createBuilder(method0);
    }

    public static Method parseDelimitedFrom(InputStream inputStream0) {
        return (Method)A1.parseDelimitedFrom(Method.DEFAULT_INSTANCE, inputStream0);
    }

    public static Method parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (Method)A1.parseDelimitedFrom(Method.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Method parseFrom(o o0) {
        return (Method)A1.parseFrom(Method.DEFAULT_INSTANCE, o0);
    }

    public static Method parseFrom(o o0, g1 g10) {
        return (Method)A1.parseFrom(Method.DEFAULT_INSTANCE, o0, g10);
    }

    public static Method parseFrom(t t0) {
        return (Method)A1.parseFrom(Method.DEFAULT_INSTANCE, t0);
    }

    public static Method parseFrom(t t0, g1 g10) {
        return (Method)A1.parseFrom(Method.DEFAULT_INSTANCE, t0, g10);
    }

    public static Method parseFrom(InputStream inputStream0) {
        return (Method)A1.parseFrom(Method.DEFAULT_INSTANCE, inputStream0);
    }

    public static Method parseFrom(InputStream inputStream0, g1 g10) {
        return (Method)A1.parseFrom(Method.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Method parseFrom(ByteBuffer byteBuffer0) {
        return (Method)A1.parseFrom(Method.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static Method parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (Method)A1.parseFrom(Method.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static Method parseFrom(byte[] arr_b) {
        return (Method)A1.parseFrom(Method.DEFAULT_INSTANCE, arr_b);
    }

    public static Method parseFrom(byte[] arr_b, g1 g10) {
        return (Method)A1.parseFrom(Method.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return Method.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeOptions(int v) {
        this.ensureOptionsIsMutable();
        this.options_.remove(v);
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

    private void setRequestStreaming(boolean z) {
        this.requestStreaming_ = z;
    }

    private void setRequestTypeUrl(String s) {
        s.getClass();
        this.requestTypeUrl_ = s;
    }

    private void setRequestTypeUrlBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.requestTypeUrl_ = o0.p();
    }

    private void setResponseStreaming(boolean z) {
        this.responseStreaming_ = z;
    }

    private void setResponseTypeUrl(String s) {
        s.getClass();
        this.responseTypeUrl_ = s;
    }

    private void setResponseTypeUrlBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.responseTypeUrl_ = o0.p();
    }

    private void setSyntax(M2 m20) {
        this.syntax_ = m20.a();
    }

    private void setSyntaxValue(int v) {
        this.syntax_ = v;
    }
}

