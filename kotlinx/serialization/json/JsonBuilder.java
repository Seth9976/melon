package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0011\n\u0002\u0010\u000E\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u001F\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\t\u001A\u00020\u0006H\u0000\u00A2\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000B\u001A\u00020\n8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\"\u0010\u0011\u001A\u00020\n8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001A\u0004\b\u0012\u0010\u000E\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0014\u001A\u00020\n8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0014\u0010\f\u001A\u0004\b\u0015\u0010\u000E\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0017\u001A\u00020\n8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0017\u0010\f\u001A\u0004\b\u0017\u0010\u000E\"\u0004\b\u0018\u0010\u0010R\"\u0010\u0019\u001A\u00020\n8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0019\u0010\f\u001A\u0004\b\u001A\u0010\u000E\"\u0004\b\u001B\u0010\u0010R(\u0010\u001D\u001A\u00020\u001C8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0018\n\u0004\b\u001D\u0010\u001E\u0012\u0004\b#\u0010$\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R\"\u0010%\u001A\u00020\n8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b%\u0010\f\u001A\u0004\b&\u0010\u000E\"\u0004\b\'\u0010\u0010R\"\u0010(\u001A\u00020\u001C8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b(\u0010\u001E\u001A\u0004\b)\u0010 \"\u0004\b*\u0010\"R(\u0010,\u001A\u00020+8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0018\n\u0004\b,\u0010-\u0012\u0004\b2\u0010$\u001A\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001A\u00020\n8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b3\u0010\f\u001A\u0004\b4\u0010\u000E\"\u0004\b5\u0010\u0010R(\u00106\u001A\u00020\n8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0018\n\u0004\b6\u0010\f\u0012\u0004\b9\u0010$\u001A\u0004\b7\u0010\u000E\"\u0004\b8\u0010\u0010R(\u0010:\u001A\u00020\n8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0018\n\u0004\b:\u0010\f\u0012\u0004\b=\u0010$\u001A\u0004\b;\u0010\u000E\"\u0004\b<\u0010\u0010R(\u0010>\u001A\u00020\n8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0018\n\u0004\b>\u0010\f\u0012\u0004\bA\u0010$\u001A\u0004\b?\u0010\u000E\"\u0004\b@\u0010\u0010R\"\u0010B\u001A\u00020\n8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bB\u0010\f\u001A\u0004\bC\u0010\u000E\"\u0004\bD\u0010\u0010R\"\u0010E\u001A\u00020\n8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bE\u0010\f\u001A\u0004\bF\u0010\u000E\"\u0004\bG\u0010\u0010R\"\u0010H\u001A\u00020\n8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bH\u0010\f\u001A\u0004\bI\u0010\u000E\"\u0004\bJ\u0010\u0010R\"\u0010L\u001A\u00020K8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bL\u0010M\u001A\u0004\bN\u0010O\"\u0004\bP\u0010Q\u00A8\u0006R"}, d2 = {"Lkotlinx/serialization/json/JsonBuilder;", "", "Lkotlinx/serialization/json/Json;", "json", "<init>", "(Lkotlinx/serialization/json/Json;)V", "Lkotlinx/serialization/json/JsonConfiguration;", "build$kotlinx_serialization_json", "()Lkotlinx/serialization/json/JsonConfiguration;", "build", "", "encodeDefaults", "Z", "getEncodeDefaults", "()Z", "setEncodeDefaults", "(Z)V", "explicitNulls", "getExplicitNulls", "setExplicitNulls", "ignoreUnknownKeys", "getIgnoreUnknownKeys", "setIgnoreUnknownKeys", "isLenient", "setLenient", "prettyPrint", "getPrettyPrint", "setPrettyPrint", "", "prettyPrintIndent", "Ljava/lang/String;", "getPrettyPrintIndent", "()Ljava/lang/String;", "setPrettyPrintIndent", "(Ljava/lang/String;)V", "getPrettyPrintIndent$annotations", "()V", "coerceInputValues", "getCoerceInputValues", "setCoerceInputValues", "classDiscriminator", "getClassDiscriminator", "setClassDiscriminator", "Lkotlinx/serialization/json/ClassDiscriminatorMode;", "classDiscriminatorMode", "Lkotlinx/serialization/json/ClassDiscriminatorMode;", "getClassDiscriminatorMode", "()Lkotlinx/serialization/json/ClassDiscriminatorMode;", "setClassDiscriminatorMode", "(Lkotlinx/serialization/json/ClassDiscriminatorMode;)V", "getClassDiscriminatorMode$annotations", "useAlternativeNames", "getUseAlternativeNames", "setUseAlternativeNames", "decodeEnumsCaseInsensitive", "getDecodeEnumsCaseInsensitive", "setDecodeEnumsCaseInsensitive", "getDecodeEnumsCaseInsensitive$annotations", "allowTrailingComma", "getAllowTrailingComma", "setAllowTrailingComma", "getAllowTrailingComma$annotations", "allowComments", "getAllowComments", "setAllowComments", "getAllowComments$annotations", "allowSpecialFloatingPointValues", "getAllowSpecialFloatingPointValues", "setAllowSpecialFloatingPointValues", "allowStructuredMapKeys", "getAllowStructuredMapKeys", "setAllowStructuredMapKeys", "useArrayPolymorphism", "getUseArrayPolymorphism", "setUseArrayPolymorphism", "Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "setSerializersModule", "(Lkotlinx/serialization/modules/SerializersModule;)V", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class JsonBuilder {
    private boolean allowComments;
    private boolean allowSpecialFloatingPointValues;
    private boolean allowStructuredMapKeys;
    private boolean allowTrailingComma;
    @NotNull
    private String classDiscriminator;
    @NotNull
    private ClassDiscriminatorMode classDiscriminatorMode;
    private boolean coerceInputValues;
    private boolean decodeEnumsCaseInsensitive;
    private boolean encodeDefaults;
    private boolean explicitNulls;
    private boolean ignoreUnknownKeys;
    private boolean isLenient;
    private boolean prettyPrint;
    @NotNull
    private String prettyPrintIndent;
    @NotNull
    private SerializersModule serializersModule;
    private boolean useAlternativeNames;
    private boolean useArrayPolymorphism;

    public JsonBuilder(@NotNull Json json0) {
        q.g(json0, "json");
        super();
        this.encodeDefaults = json0.getConfiguration().getEncodeDefaults();
        this.explicitNulls = json0.getConfiguration().getExplicitNulls();
        this.ignoreUnknownKeys = json0.getConfiguration().getIgnoreUnknownKeys();
        this.isLenient = json0.getConfiguration().isLenient();
        this.prettyPrint = json0.getConfiguration().getPrettyPrint();
        this.prettyPrintIndent = json0.getConfiguration().getPrettyPrintIndent();
        this.coerceInputValues = json0.getConfiguration().getCoerceInputValues();
        this.classDiscriminator = json0.getConfiguration().getClassDiscriminator();
        this.classDiscriminatorMode = json0.getConfiguration().getClassDiscriminatorMode();
        this.useAlternativeNames = json0.getConfiguration().getUseAlternativeNames();
        this.decodeEnumsCaseInsensitive = json0.getConfiguration().getDecodeEnumsCaseInsensitive();
        this.allowTrailingComma = json0.getConfiguration().getAllowTrailingComma();
        this.allowComments = json0.getConfiguration().getAllowComments();
        this.allowSpecialFloatingPointValues = json0.getConfiguration().getAllowSpecialFloatingPointValues();
        this.allowStructuredMapKeys = json0.getConfiguration().getAllowStructuredMapKeys();
        this.useArrayPolymorphism = json0.getConfiguration().getUseArrayPolymorphism();
        this.serializersModule = json0.getSerializersModule();
    }

    @NotNull
    public final JsonConfiguration build$kotlinx_serialization_json() {
        if(this.useArrayPolymorphism) {
            if(!q.b(this.classDiscriminator, "type")) {
                throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified");
            }
            if(this.classDiscriminatorMode != ClassDiscriminatorMode.POLYMORPHIC) {
                throw new IllegalArgumentException("useArrayPolymorphism option can only be used if classDiscriminatorMode in a default POLYMORPHIC state.");
            }
        }
        if(!this.prettyPrint) {
            if(!q.b(this.prettyPrintIndent, "    ")) {
                throw new IllegalArgumentException("Indent should not be specified when default printing mode is used");
            }
        }
        else if(!q.b(this.prettyPrintIndent, "    ")) {
            String s = this.prettyPrintIndent;
            int v = 0;
            while(v < s.length()) {
                switch(s.charAt(v)) {
                    case 9: 
                    case 10: 
                    case 13: 
                    case 0x20: {
                        ++v;
                        continue;
                    }
                    default: {
                        throw new IllegalArgumentException(("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had " + this.prettyPrintIndent).toString());
                    }
                }
            }
        }
        return new JsonConfiguration(this.encodeDefaults, this.ignoreUnknownKeys, this.isLenient, this.allowStructuredMapKeys, this.prettyPrint, this.explicitNulls, this.prettyPrintIndent, this.coerceInputValues, this.useArrayPolymorphism, this.classDiscriminator, this.allowSpecialFloatingPointValues, this.useAlternativeNames, null, this.decodeEnumsCaseInsensitive, this.allowTrailingComma, this.allowComments, this.classDiscriminatorMode);
    }

    @NotNull
    public final SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    public final void setAllowStructuredMapKeys(boolean z) {
        this.allowStructuredMapKeys = z;
    }

    public final void setCoerceInputValues(boolean z) {
        this.coerceInputValues = z;
    }

    public final void setExplicitNulls(boolean z) {
        this.explicitNulls = z;
    }

    public final void setIgnoreUnknownKeys(boolean z) {
        this.ignoreUnknownKeys = z;
    }

    public final void setLenient(boolean z) {
        this.isLenient = z;
    }

    public final void setSerializersModule(@NotNull SerializersModule serializersModule0) {
        q.g(serializersModule0, "<set-?>");
        this.serializersModule = serializersModule0;
    }
}

