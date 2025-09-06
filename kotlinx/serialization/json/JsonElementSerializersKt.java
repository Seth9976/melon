package kotlinx.serialization.json;

import H0.b;
import d3.g;
import ie.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor.DefaultImpls;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import we.a;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0017\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001A\u0017\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\u0003\u0010\u0007\u001A\u0013\u0010\t\u001A\u00020\b*\u00020\u0005H\u0000¢\u0006\u0004\b\t\u0010\n\u001A\u0013\u0010\f\u001A\u00020\u000B*\u00020\u0000H\u0000¢\u0006\u0004\b\f\u0010\r\u001A\u001D\u0010\u0011\u001A\u00020\u000F2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EH\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/serialization/encoding/Encoder;", "encoder", "Lie/H;", "verify", "(Lkotlinx/serialization/encoding/Encoder;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "(Lkotlinx/serialization/encoding/Decoder;)V", "Lkotlinx/serialization/json/JsonDecoder;", "asJsonDecoder", "(Lkotlinx/serialization/encoding/Decoder;)Lkotlinx/serialization/json/JsonDecoder;", "Lkotlinx/serialization/json/JsonEncoder;", "asJsonEncoder", "(Lkotlinx/serialization/encoding/Encoder;)Lkotlinx/serialization/json/JsonEncoder;", "Lkotlin/Function0;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "deferred", "defer", "(Lwe/a;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class JsonElementSerializersKt {
    @NotNull
    public static final JsonDecoder asJsonDecoder(@NotNull Decoder decoder0) {
        q.g(decoder0, "<this>");
        JsonDecoder jsonDecoder0 = decoder0 instanceof JsonDecoder ? ((JsonDecoder)decoder0) : null;
        if(jsonDecoder0 != null) {
            return jsonDecoder0;
        }
        StringBuilder stringBuilder0 = new StringBuilder("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got ");
        Class class0 = decoder0.getClass();
        throw new IllegalStateException(b.l(I.a, class0, stringBuilder0));
    }

    @NotNull
    public static final JsonEncoder asJsonEncoder(@NotNull Encoder encoder0) {
        q.g(encoder0, "<this>");
        JsonEncoder jsonEncoder0 = encoder0 instanceof JsonEncoder ? ((JsonEncoder)encoder0) : null;
        if(jsonEncoder0 != null) {
            return jsonEncoder0;
        }
        StringBuilder stringBuilder0 = new StringBuilder("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got ");
        Class class0 = encoder0.getClass();
        throw new IllegalStateException(b.l(I.a, class0, stringBuilder0));
    }

    private static final SerialDescriptor defer(a a0) {
        return new SerialDescriptor() {
            private final j original$delegate;

            {
                a a0 = a0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.original$delegate = g.Q(a0);
            }

            @Override  // kotlinx.serialization.descriptors.SerialDescriptor
            public List getAnnotations() {
                return DefaultImpls.getAnnotations(this);
            }

            @Override  // kotlinx.serialization.descriptors.SerialDescriptor
            public List getElementAnnotations(int v) {
                return this.getOriginal().getElementAnnotations(v);
            }

            @Override  // kotlinx.serialization.descriptors.SerialDescriptor
            public SerialDescriptor getElementDescriptor(int v) {
                return this.getOriginal().getElementDescriptor(v);
            }

            @Override  // kotlinx.serialization.descriptors.SerialDescriptor
            public int getElementIndex(String s) {
                q.g(s, "name");
                return this.getOriginal().getElementIndex(s);
            }

            @Override  // kotlinx.serialization.descriptors.SerialDescriptor
            public String getElementName(int v) {
                return this.getOriginal().getElementName(v);
            }

            @Override  // kotlinx.serialization.descriptors.SerialDescriptor
            public int getElementsCount() {
                return this.getOriginal().getElementsCount();
            }

            @Override  // kotlinx.serialization.descriptors.SerialDescriptor
            public SerialKind getKind() {
                return this.getOriginal().getKind();
            }

            private final SerialDescriptor getOriginal() {
                return (SerialDescriptor)this.original$delegate.getValue();
            }

            @Override  // kotlinx.serialization.descriptors.SerialDescriptor
            public String getSerialName() {
                return this.getOriginal().getSerialName();
            }

            @Override  // kotlinx.serialization.descriptors.SerialDescriptor
            public boolean isElementOptional(int v) {
                return this.getOriginal().isElementOptional(v);
            }

            @Override  // kotlinx.serialization.descriptors.SerialDescriptor
            public boolean isInline() {
                return false;
            }

            @Override  // kotlinx.serialization.descriptors.SerialDescriptor
            public boolean isNullable() {
                return false;
            }
        };
    }

    private static final void verify(Decoder decoder0) {
        JsonElementSerializersKt.asJsonDecoder(decoder0);
    }

    private static final void verify(Encoder encoder0) {
        JsonElementSerializersKt.asJsonEncoder(encoder0);
    }
}

