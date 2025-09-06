package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\'\u0018\u00002\u00020\u0001B\u00B5\u0001\b\u0000\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0002\u0012\b\b\u0002\u0010\b\u001A\u00020\u0002\u0012\b\b\u0002\u0010\n\u001A\u00020\t\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0002\u0012\b\b\u0002\u0010\f\u001A\u00020\u0002\u0012\b\b\u0002\u0010\r\u001A\u00020\t\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001A\u00020\u0015\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u0019\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AR\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010\u001B\u001A\u0004\b\u001C\u0010\u001DR\u0017\u0010\u0004\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010\u001B\u001A\u0004\b\u001E\u0010\u001DR\u0017\u0010\u0005\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010\u001B\u001A\u0004\b\u0005\u0010\u001DR\u0017\u0010\u0006\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010\u001B\u001A\u0004\b\u001F\u0010\u001DR\u0017\u0010\u0007\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010\u001B\u001A\u0004\b \u0010\u001DR\u0017\u0010\b\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\b\u0010\u001B\u001A\u0004\b!\u0010\u001DR \u0010\n\u001A\u00020\t8\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\n\u0010\"\u0012\u0004\b$\u0010%\u001A\u0004\b#\u0010\u001AR\u0017\u0010\u000B\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u000B\u0010\u001B\u001A\u0004\b&\u0010\u001DR\u0017\u0010\f\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\f\u0010\u001B\u001A\u0004\b\'\u0010\u001DR\u0017\u0010\r\u001A\u00020\t8\u0006\u00A2\u0006\f\n\u0004\b\r\u0010\"\u001A\u0004\b(\u0010\u001AR\u0017\u0010\u000E\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u000E\u0010\u001B\u001A\u0004\b)\u0010\u001DR\u0017\u0010\u000F\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u000F\u0010\u001B\u001A\u0004\b*\u0010\u001DR \u0010\u0012\u001A\u00020\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0012\u0010\u001B\u0012\u0004\b,\u0010%\u001A\u0004\b+\u0010\u001DR \u0010\u0013\u001A\u00020\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0013\u0010\u001B\u0012\u0004\b.\u0010%\u001A\u0004\b-\u0010\u001DR \u0010\u0014\u001A\u00020\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0014\u0010\u001B\u0012\u0004\b0\u0010%\u001A\u0004\b/\u0010\u001DR0\u0010\u0016\u001A\u00020\u00152\u0006\u00101\u001A\u00020\u00158\u0006@GX\u0087\u000E\u00A2\u0006\u0018\n\u0004\b\u0016\u00102\u0012\u0004\b7\u0010%\u001A\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\u0011\u001A\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0011\u00108\u0012\u0004\b;\u0010%\u001A\u0004\b9\u0010:\u00A8\u0006<"}, d2 = {"Lkotlinx/serialization/json/JsonConfiguration;", "", "", "encodeDefaults", "ignoreUnknownKeys", "isLenient", "allowStructuredMapKeys", "prettyPrint", "explicitNulls", "", "prettyPrintIndent", "coerceInputValues", "useArrayPolymorphism", "classDiscriminator", "allowSpecialFloatingPointValues", "useAlternativeNames", "Lkotlinx/serialization/json/JsonNamingStrategy;", "namingStrategy", "decodeEnumsCaseInsensitive", "allowTrailingComma", "allowComments", "Lkotlinx/serialization/json/ClassDiscriminatorMode;", "classDiscriminatorMode", "<init>", "(ZZZZZZLjava/lang/String;ZZLjava/lang/String;ZZLkotlinx/serialization/json/JsonNamingStrategy;ZZZLkotlinx/serialization/json/ClassDiscriminatorMode;)V", "toString", "()Ljava/lang/String;", "Z", "getEncodeDefaults", "()Z", "getIgnoreUnknownKeys", "getAllowStructuredMapKeys", "getPrettyPrint", "getExplicitNulls", "Ljava/lang/String;", "getPrettyPrintIndent", "getPrettyPrintIndent$annotations", "()V", "getCoerceInputValues", "getUseArrayPolymorphism", "getClassDiscriminator", "getAllowSpecialFloatingPointValues", "getUseAlternativeNames", "getDecodeEnumsCaseInsensitive", "getDecodeEnumsCaseInsensitive$annotations", "getAllowTrailingComma", "getAllowTrailingComma$annotations", "getAllowComments", "getAllowComments$annotations", "value", "Lkotlinx/serialization/json/ClassDiscriminatorMode;", "getClassDiscriminatorMode", "()Lkotlinx/serialization/json/ClassDiscriminatorMode;", "setClassDiscriminatorMode", "(Lkotlinx/serialization/json/ClassDiscriminatorMode;)V", "getClassDiscriminatorMode$annotations", "Lkotlinx/serialization/json/JsonNamingStrategy;", "getNamingStrategy", "()Lkotlinx/serialization/json/JsonNamingStrategy;", "getNamingStrategy$annotations", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class JsonConfiguration {
    private final boolean allowComments;
    private final boolean allowSpecialFloatingPointValues;
    private final boolean allowStructuredMapKeys;
    private final boolean allowTrailingComma;
    @NotNull
    private final String classDiscriminator;
    @NotNull
    private ClassDiscriminatorMode classDiscriminatorMode;
    private final boolean coerceInputValues;
    private final boolean decodeEnumsCaseInsensitive;
    private final boolean encodeDefaults;
    private final boolean explicitNulls;
    private final boolean ignoreUnknownKeys;
    private final boolean isLenient;
    private final boolean prettyPrint;
    @NotNull
    private final String prettyPrintIndent;
    private final boolean useAlternativeNames;
    private final boolean useArrayPolymorphism;

    public JsonConfiguration(boolean z, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5, @NotNull String s, boolean z6, boolean z7, @NotNull String s1, boolean z8, boolean z9, @Nullable JsonNamingStrategy jsonNamingStrategy0, boolean z10, boolean z11, boolean z12, @NotNull ClassDiscriminatorMode classDiscriminatorMode0) {
        q.g(s, "prettyPrintIndent");
        q.g(s1, "classDiscriminator");
        q.g(classDiscriminatorMode0, "classDiscriminatorMode");
        super();
        this.encodeDefaults = z;
        this.ignoreUnknownKeys = z1;
        this.isLenient = z2;
        this.allowStructuredMapKeys = z3;
        this.prettyPrint = z4;
        this.explicitNulls = z5;
        this.prettyPrintIndent = s;
        this.coerceInputValues = z6;
        this.useArrayPolymorphism = z7;
        this.classDiscriminator = s1;
        this.allowSpecialFloatingPointValues = z8;
        this.useAlternativeNames = z9;
        this.decodeEnumsCaseInsensitive = z10;
        this.allowTrailingComma = z11;
        this.allowComments = z12;
        this.classDiscriminatorMode = classDiscriminatorMode0;
    }

    public JsonConfiguration(boolean z, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5, String s, boolean z6, boolean z7, String s1, boolean z8, boolean z9, JsonNamingStrategy jsonNamingStrategy0, boolean z10, boolean z11, boolean z12, ClassDiscriminatorMode classDiscriminatorMode0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        this(((v & 1) == 0 ? z : false), ((v & 2) == 0 ? z1 : false), ((v & 4) == 0 ? z2 : false), ((v & 8) == 0 ? z3 : false), ((v & 16) == 0 ? z4 : false), ((v & 0x20) == 0 ? z5 : true), ((v & 0x40) == 0 ? s : "    "), ((v & 0x80) == 0 ? z6 : false), ((v & 0x100) == 0 ? z7 : false), ((v & 0x200) == 0 ? s1 : "type"), ((v & 0x400) == 0 ? z8 : false), ((v & 0x800) == 0 ? z9 : true), ((v & 0x1000) == 0 ? jsonNamingStrategy0 : null), ((v & 0x2000) == 0 ? z10 : false), ((v & 0x4000) == 0 ? z11 : false), ((v & 0x8000) == 0 ? z12 : false), ((v & 0x10000) == 0 ? classDiscriminatorMode0 : ClassDiscriminatorMode.POLYMORPHIC));
    }

    public final boolean getAllowComments() {
        return this.allowComments;
    }

    public final boolean getAllowSpecialFloatingPointValues() {
        return this.allowSpecialFloatingPointValues;
    }

    public final boolean getAllowStructuredMapKeys() {
        return this.allowStructuredMapKeys;
    }

    public final boolean getAllowTrailingComma() {
        return this.allowTrailingComma;
    }

    @NotNull
    public final String getClassDiscriminator() {
        return this.classDiscriminator;
    }

    @NotNull
    public final ClassDiscriminatorMode getClassDiscriminatorMode() {
        return this.classDiscriminatorMode;
    }

    public final boolean getCoerceInputValues() {
        return this.coerceInputValues;
    }

    public final boolean getDecodeEnumsCaseInsensitive() {
        return this.decodeEnumsCaseInsensitive;
    }

    public final boolean getEncodeDefaults() {
        return this.encodeDefaults;
    }

    public final boolean getExplicitNulls() {
        return this.explicitNulls;
    }

    public final boolean getIgnoreUnknownKeys() {
        return this.ignoreUnknownKeys;
    }

    @Nullable
    public final JsonNamingStrategy getNamingStrategy() [...] // Inlined contents

    public final boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    @NotNull
    public final String getPrettyPrintIndent() {
        return this.prettyPrintIndent;
    }

    public final boolean getUseAlternativeNames() {
        return this.useAlternativeNames;
    }

    public final boolean getUseArrayPolymorphism() {
        return this.useArrayPolymorphism;
    }

    public final boolean isLenient() {
        return this.isLenient;
    }

    @Override
    @NotNull
    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.encodeDefaults + ", ignoreUnknownKeys=" + this.ignoreUnknownKeys + ", isLenient=" + this.isLenient + ", allowStructuredMapKeys=" + this.allowStructuredMapKeys + ", prettyPrint=" + this.prettyPrint + ", explicitNulls=" + this.explicitNulls + ", prettyPrintIndent=\'" + this.prettyPrintIndent + "\', coerceInputValues=" + this.coerceInputValues + ", useArrayPolymorphism=" + this.useArrayPolymorphism + ", classDiscriminator=\'" + this.classDiscriminator + "\', allowSpecialFloatingPointValues=" + this.allowSpecialFloatingPointValues + ", useAlternativeNames=" + this.useAlternativeNames + ", namingStrategy=null, decodeEnumsCaseInsensitive=" + this.decodeEnumsCaseInsensitive + ", allowTrailingComma=" + this.allowTrailingComma + ", allowComments=" + this.allowComments + ", classDiscriminatorMode=" + this.classDiscriminatorMode + ')';
    }
}

