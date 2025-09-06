package kotlinx.serialization.json.internal;

import H0.b;
import Tf.v;
import i.n.i.b.a.s.e.M3;
import ie.A;
import ie.E;
import ie.u;
import ie.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import ye.a;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\b\u0010\u0010\u001A\u00020\rH\u0016J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0016J\b\u0010\u0015\u001A\u00020\u0016H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0017"}, d2 = {"Lkotlinx/serialization/json/internal/JsonDecoderForUnsignedTypes;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "lexer", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "json", "Lkotlinx/serialization/json/Json;", "<init>", "(Lkotlinx/serialization/json/internal/AbstractJsonLexer;Lkotlinx/serialization/json/Json;)V", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "decodeElementIndex", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeInt", "decodeLong", "", "decodeByte", "", "decodeShort", "", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class JsonDecoderForUnsignedTypes extends AbstractDecoder {
    @NotNull
    private final AbstractJsonLexer lexer;
    @NotNull
    private final SerializersModule serializersModule;

    public JsonDecoderForUnsignedTypes(@NotNull AbstractJsonLexer abstractJsonLexer0, @NotNull Json json0) {
        q.g(abstractJsonLexer0, "lexer");
        q.g(json0, "json");
        super();
        this.lexer = abstractJsonLexer0;
        this.serializersModule = json0.getSerializersModule();
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder
    public byte decodeByte() {
        u u0;
        AbstractJsonLexer abstractJsonLexer0 = this.lexer;
        String s = abstractJsonLexer0.consumeStringLenient();
        try {
            q.g(s, "<this>");
            x x0 = a.a0(s);
            if(x0 == null) {
                u0 = null;
            }
            else {
                int v = x0.a;
                u0 = Integer.compareUnsigned(v, 0xFF) <= 0 ? new u(((byte)v)) : null;
            }
            if(u0 != null) {
                return u0.a;
            }
            v.l0(s);
            throw null;
        }
        catch(IllegalArgumentException unused_ex) {
            AbstractJsonLexer.fail$default(abstractJsonLexer0, "Failed to parse type \'UByte\' for input \'" + s + '\'', 0, null, 6, null);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
    }

    @Override  // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "descriptor");
        throw new IllegalStateException("unsupported");
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder
    public int decodeInt() {
        AbstractJsonLexer abstractJsonLexer0 = this.lexer;
        String s = abstractJsonLexer0.consumeStringLenient();
        try {
            q.g(s, "<this>");
            x x0 = a.a0(s);
            if(x0 != null) {
                return x0.a;
            }
            v.l0(s);
            throw null;
        }
        catch(IllegalArgumentException unused_ex) {
            AbstractJsonLexer.fail$default(abstractJsonLexer0, b.c('\'', "Failed to parse type \'UInt\' for input \'", s), 0, null, 6, null);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder
    public long decodeLong() {
        AbstractJsonLexer abstractJsonLexer0 = this.lexer;
        String s = abstractJsonLexer0.consumeStringLenient();
        try {
            q.g(s, "<this>");
            A a0 = a.b0(s);
            if(a0 != null) {
                return a0.a;
            }
            v.l0(s);
            throw null;
        }
        catch(IllegalArgumentException unused_ex) {
            AbstractJsonLexer.fail$default(abstractJsonLexer0, "Failed to parse type \'ULong\' for input \'" + s + '\'', 0, null, 6, null);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
    }

    @Override  // kotlinx.serialization.encoding.AbstractDecoder
    public short decodeShort() {
        E e0;
        AbstractJsonLexer abstractJsonLexer0 = this.lexer;
        String s = abstractJsonLexer0.consumeStringLenient();
        try {
            q.g(s, "<this>");
            x x0 = a.a0(s);
            if(x0 == null) {
                e0 = null;
            }
            else {
                int v = x0.a;
                e0 = Integer.compareUnsigned(v, 0xFFFF) <= 0 ? new E(((short)v)) : null;
            }
            if(e0 != null) {
                return e0.a;
            }
            v.l0(s);
            throw null;
        }
        catch(IllegalArgumentException unused_ex) {
            AbstractJsonLexer.fail$default(abstractJsonLexer0, "Failed to parse type \'UShort\' for input \'" + s + '\'', 0, null, 6, null);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
    }

    @Override  // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    @NotNull
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }
}

