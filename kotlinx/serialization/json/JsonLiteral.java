package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.internal.StringOpsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0011\u001A\u00020\u000EH\u0016J\u0013\u0010\u0012\u001A\u00020\u00052\b\u0010\u0013\u001A\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\u0014\u001A\u00020\u0015H\u0017R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\nR\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\u00020\u000EX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/json/JsonLiteral;", "Lkotlinx/serialization/json/JsonPrimitive;", "body", "", "isString", "", "coerceToInlineType", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "<init>", "(Ljava/lang/Object;ZLkotlinx/serialization/descriptors/SerialDescriptor;)V", "()Z", "getCoerceToInlineType$kotlinx_serialization_json", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "content", "", "getContent", "()Ljava/lang/String;", "toString", "equals", "other", "hashCode", "", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class JsonLiteral extends JsonPrimitive {
    @Nullable
    private final SerialDescriptor coerceToInlineType;
    @NotNull
    private final String content;
    private final boolean isString;

    public JsonLiteral(@NotNull Object object0, boolean z, @Nullable SerialDescriptor serialDescriptor0) {
        q.g(object0, "body");
        super(null);
        this.isString = z;
        this.coerceToInlineType = serialDescriptor0;
        this.content = object0.toString();
        if(serialDescriptor0 != null && !serialDescriptor0.isInline()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    public JsonLiteral(Object object0, boolean z, SerialDescriptor serialDescriptor0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 4) != 0) {
            serialDescriptor0 = null;
        }
        this(object0, z, serialDescriptor0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return JsonLiteral.class == class0 && this.isString() == ((JsonLiteral)object0).isString() ? q.b(this.getContent(), ((JsonLiteral)object0).getContent()) : false;
        }
        return false;
    }

    @Nullable
    public final SerialDescriptor getCoerceToInlineType$kotlinx_serialization_json() {
        return this.coerceToInlineType;
    }

    @Override  // kotlinx.serialization.json.JsonPrimitive
    @NotNull
    public String getContent() {
        return this.content;
    }

    @Override
    public int hashCode() {
        return this.getContent().hashCode() + Boolean.hashCode(this.isString()) * 0x1F;
    }

    public boolean isString() {
        return this.isString;
    }

    @Override  // kotlinx.serialization.json.JsonPrimitive
    @NotNull
    public String toString() {
        if(this.isString()) {
            StringBuilder stringBuilder0 = new StringBuilder();
            StringOpsKt.printQuoted(stringBuilder0, this.getContent());
            String s = stringBuilder0.toString();
            q.f(s, "toString(...)");
            return s;
        }
        return this.getContent();
    }
}

