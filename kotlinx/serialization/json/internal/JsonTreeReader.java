package kotlinx.serialization.json.internal;

import d5.n;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.b;
import ie.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.o;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ \u0010\t\u001A\u00020\b*\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000BH\u0082@¢\u0006\u0004\b\t\u0010\rJ\u000F\u0010\u000E\u001A\u00020\bH\u0002¢\u0006\u0004\b\u000E\u0010\nJ\u0017\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u000FH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\nJ\r\u0010\u0015\u001A\u00020\b¢\u0006\u0004\b\u0015\u0010\nR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001A\u00020\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0016\u0010\u001B\u001A\u00020\u001A8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeReader;", "", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "lexer", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/AbstractJsonLexer;)V", "Lkotlinx/serialization/json/JsonElement;", "readObject", "()Lkotlinx/serialization/json/JsonElement;", "Lie/b;", "Lie/H;", "(Lie/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readArray", "", "isString", "Lkotlinx/serialization/json/JsonPrimitive;", "readValue", "(Z)Lkotlinx/serialization/json/JsonPrimitive;", "readDeepRecursive", "read", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "isLenient", "Z", "trailingCommaAllowed", "", "stackDepth", "I", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class JsonTreeReader {
    private final boolean isLenient;
    @NotNull
    private final AbstractJsonLexer lexer;
    private int stackDepth;
    private final boolean trailingCommaAllowed;

    public JsonTreeReader(@NotNull JsonConfiguration jsonConfiguration0, @NotNull AbstractJsonLexer abstractJsonLexer0) {
        q.g(jsonConfiguration0, "configuration");
        q.g(abstractJsonLexer0, "lexer");
        super();
        this.lexer = abstractJsonLexer0;
        this.isLenient = jsonConfiguration0.isLenient();
        this.trailingCommaAllowed = jsonConfiguration0.getAllowTrailingComma();
    }

    @NotNull
    public final JsonElement read() {
        int v = this.lexer.peekNextToken();
        if(v == 1) {
            return this.readValue(true);
        }
        if(v == 0) {
            return this.readValue(false);
        }
        switch(v) {
            case 6: {
                int v1 = this.stackDepth + 1;
                this.stackDepth = v1;
                JsonElement jsonElement0 = v1 == 200 ? this.readDeepRecursive() : this.readObject();
                --this.stackDepth;
                return jsonElement0;
            }
            case 8: {
                return this.readArray();
            }
            default: {
                AbstractJsonLexer.fail$default(this.lexer, "Cannot read Json element because of unexpected " + AbstractJsonLexerKt.tokenDescription(((byte)v)), 0, null, 6, null);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    private final JsonElement readArray() {
        int v = this.lexer.consumeNextToken();
        if(this.lexer.peekNextToken() != 4) {
            ArrayList arrayList0 = new ArrayList();
            while(this.lexer.canConsumeValue()) {
                arrayList0.add(this.read());
                v = this.lexer.consumeNextToken();
                if(v != 4) {
                    AbstractJsonLexer abstractJsonLexer0 = this.lexer;
                    int v1 = abstractJsonLexer0.currentPosition;
                    if(v != 9) {
                        AbstractJsonLexer.fail$default(abstractJsonLexer0, "Expected end of the array or comma", v1, null, 4, null);
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    if(false) {
                        break;
                    }
                }
            }
            switch(v) {
                case 4: {
                    if(this.trailingCommaAllowed) {
                        this.lexer.consumeNextToken(9);
                        return new JsonArray(arrayList0);
                    }
                    JsonExceptionsKt.invalidTrailingComma(this.lexer, "array");
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                case 8: {
                    this.lexer.consumeNextToken(9);
                    return new JsonArray(arrayList0);
                }
                default: {
                    return new JsonArray(arrayList0);
                }
            }
        }
        AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    private final JsonElement readDeepRecursive() {
        Object object1;
        Object object0;
        kotlinx.serialization.json.internal.JsonTreeReader.readDeepRecursive.1 jsonTreeReader$readDeepRecursive$10 = new o(null) {
            private Object L$0;
            int label;

            {
                JsonTreeReader.this = jsonTreeReader0;
                super(3, continuation0);
            }

            public final Object invoke(b b0, H h0, Continuation continuation0) {
                kotlinx.serialization.json.internal.JsonTreeReader.readDeepRecursive.1 jsonTreeReader$readDeepRecursive$10 = new kotlinx.serialization.json.internal.JsonTreeReader.readDeepRecursive.1(JsonTreeReader.this, continuation0);
                jsonTreeReader$readDeepRecursive$10.L$0 = b0;
                return jsonTreeReader$readDeepRecursive$10.invokeSuspend(H.a);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((b)object0), ((H)object1), ((Continuation)object2));
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        b b0 = (b)this.L$0;
                        int v = JsonTreeReader.this.lexer.peekNextToken();
                        if(v == 1) {
                            return JsonTreeReader.this.readValue(true);
                        }
                        if(v == 0) {
                            return JsonTreeReader.this.readValue(false);
                        }
                        switch(v) {
                            case 6: {
                                this.label = 1;
                                object0 = JsonTreeReader.this.readObject(b0, this);
                                return object0 == a0 ? a0 : ((JsonElement)object0);
                            }
                            case 8: {
                                return JsonTreeReader.this.readArray();
                            }
                            default: {
                                AbstractJsonLexer.fail$default(JsonTreeReader.this.lexer, "Can\'t begin reading element, unexpected token", 0, null, 6, null);
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            }
                        }
                    }
                    case 1: {
                        n.D(object0);
                        return (JsonElement)object0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        };
        c c0 = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        c0.a = jsonTreeReader$readDeepRecursive$10;
        c0.b = c0;
        a a0 = ie.a.a;
        c0.c = a0;
        while(true) {
            object0 = c0.c;
            Continuation continuation0 = c0.b;
            if(continuation0 == null) {
                break;
            }
            if(q.b(a0, object0)) {
                try {
                    o o0 = c0.a;
                    N.e(3, o0);
                    object1 = o0.invoke(c0, H.a, continuation0);
                    if(object1 == a.a) {
                        continue;
                    }
                }
                catch(Throwable throwable0) {
                    continuation0.resumeWith(n.t(throwable0));
                    continue;
                }
                continuation0.resumeWith(object1);
            }
            else {
                c0.c = a0;
                continuation0.resumeWith(object0);
            }
        }
        n.D(object0);
        return (JsonElement)object0;
    }

    private final Object readObject(b b0, Continuation continuation0) {
        JsonTreeReader jsonTreeReader0;
        b b1;
        LinkedHashMap linkedHashMap0;
        int v1;
        kotlinx.serialization.json.internal.JsonTreeReader.readObject.2 jsonTreeReader$readObject$20;
        if(continuation0 instanceof kotlinx.serialization.json.internal.JsonTreeReader.readObject.2) {
            jsonTreeReader$readObject$20 = (kotlinx.serialization.json.internal.JsonTreeReader.readObject.2)continuation0;
            int v = jsonTreeReader$readObject$20.label;
            if((v & 0x80000000) == 0) {
                jsonTreeReader$readObject$20 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.readObject(null, this);
                    }
                };
            }
            else {
                jsonTreeReader$readObject$20.label = v ^ 0x80000000;
            }
        }
        else {
            jsonTreeReader$readObject$20 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.readObject(null, this);
                }
            };
        }
        Object object0 = jsonTreeReader$readObject$20.result;
        a a0 = a.a;
        switch(jsonTreeReader$readObject$20.label) {
            case 0: {
                n.D(object0);
                v1 = this.lexer.consumeNextToken(6);
                if(this.lexer.peekNextToken() != 4) {
                    linkedHashMap0 = new LinkedHashMap();
                    b1 = b0;
                    jsonTreeReader0 = this;
                    goto label_33;
                }
                AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            case 1: {
                String s = (String)jsonTreeReader$readObject$20.L$3;
                linkedHashMap0 = (LinkedHashMap)jsonTreeReader$readObject$20.L$2;
                jsonTreeReader0 = (JsonTreeReader)jsonTreeReader$readObject$20.L$1;
                b1 = (b)jsonTreeReader$readObject$20.L$0;
                n.D(object0);
                linkedHashMap0.put(s, ((JsonElement)object0));
                v1 = jsonTreeReader0.lexer.consumeNextToken();
                if(v1 == 4) {
                label_33:
                    if(jsonTreeReader0.lexer.canConsumeValue()) {
                        String s1 = jsonTreeReader0.isLenient ? jsonTreeReader0.lexer.consumeStringLenient() : jsonTreeReader0.lexer.consumeString();
                        jsonTreeReader0.lexer.consumeNextToken(5);
                        jsonTreeReader$readObject$20.L$0 = b1;
                        jsonTreeReader$readObject$20.L$1 = jsonTreeReader0;
                        jsonTreeReader$readObject$20.L$2 = linkedHashMap0;
                        jsonTreeReader$readObject$20.L$3 = s1;
                        jsonTreeReader$readObject$20.label = 1;
                        ((c)b1).getClass();
                        ((c)b1).b = jsonTreeReader$readObject$20;
                        return a0;
                    }
                }
                else if(v1 != 7) {
                    AbstractJsonLexer.fail$default(jsonTreeReader0.lexer, "Expected end of the object or comma", 0, null, 6, null);
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(v1 == 6) {
            jsonTreeReader0.lexer.consumeNextToken(7);
            return new JsonObject(linkedHashMap0);
        }
        if(v1 == 4) {
            if(jsonTreeReader0.trailingCommaAllowed) {
                jsonTreeReader0.lexer.consumeNextToken(7);
                return new JsonObject(linkedHashMap0);
            }
            JsonExceptionsKt.invalidTrailingComma$default(jsonTreeReader0.lexer, null, 1, null);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return new JsonObject(linkedHashMap0);
    }

    private final JsonElement readObject() {
        int v = this.lexer.consumeNextToken(6);
        if(this.lexer.peekNextToken() != 4) {
            LinkedHashMap linkedHashMap0 = new LinkedHashMap();
            while(this.lexer.canConsumeValue()) {
                String s = this.isLenient ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
                this.lexer.consumeNextToken(5);
                linkedHashMap0.put(s, this.read());
                v = this.lexer.consumeNextToken();
                if(v != 4) {
                    if(v == 7) {
                        break;
                    }
                    AbstractJsonLexer.fail$default(this.lexer, "Expected end of the object or comma", 0, null, 6, null);
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                if(false) {
                    break;
                }
            }
            if(v == 6) {
                this.lexer.consumeNextToken(7);
                return new JsonObject(linkedHashMap0);
            }
            if(v == 4) {
                if(this.trailingCommaAllowed) {
                    this.lexer.consumeNextToken(7);
                    return new JsonObject(linkedHashMap0);
                }
                JsonExceptionsKt.invalidTrailingComma$default(this.lexer, null, 1, null);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            return new JsonObject(linkedHashMap0);
        }
        AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    private final JsonPrimitive readValue(boolean z) {
        String s = this.isLenient || !z ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
        return !z && q.b(s, "null") ? JsonNull.INSTANCE : new JsonLiteral(s, z, null, 4, null);
    }
}

