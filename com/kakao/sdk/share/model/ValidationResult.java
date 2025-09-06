package com.kakao.sdk.share.model;

import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer.DefaultImpls;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0012\b\u0087\b\u0018\u0000 72\u00020\u0001:\u000287B5\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0004\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\t\u0010\nBU\b\u0017\u0012\u0006\u0010\f\u001A\u00020\u000B\u0012\b\b\u0001\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0001\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0006\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0007\u001A\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\u0004\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\r\u00A2\u0006\u0004\b\t\u0010\u000FJ(\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0010\u001A\u00020\u00002\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u0013H\u00C7\u0001\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001A\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u001C\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001BJ\u0012\u0010\u001D\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001BJ\u0012\u0010\u001E\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u001BJH\u0010\u001F\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00042\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0004H\u00C6\u0001\u00A2\u0006\u0004\b\u001F\u0010 J\u0010\u0010\"\u001A\u00020!H\u00D6\u0001\u00A2\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001A\u00020\u000BH\u00D6\u0001\u00A2\u0006\u0004\b$\u0010%J\u001A\u0010(\u001A\u00020\'2\b\u0010&\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b(\u0010)R \u0010\u0003\u001A\u00020\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0003\u0010*\u0012\u0004\b,\u0010-\u001A\u0004\b+\u0010\u0019R\"\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0005\u0010.\u0012\u0004\b0\u0010-\u001A\u0004\b/\u0010\u001BR \u0010\u0006\u001A\u00020\u00048\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0006\u0010.\u0012\u0004\b2\u0010-\u001A\u0004\b1\u0010\u001BR\"\u0010\u0007\u001A\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0007\u0010.\u0012\u0004\b4\u0010-\u001A\u0004\b3\u0010\u001BR\"\u0010\b\u001A\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\b\u0010.\u0012\u0004\b6\u0010-\u001A\u0004\b5\u0010\u001B\u00A8\u00069"}, d2 = {"Lcom/kakao/sdk/share/model/ValidationResult;", "", "", "templateId", "Lkotlinx/serialization/json/JsonObject;", "templateArgs", "templateMsg", "warningMsg", "argumentMsg", "<init>", "(JLkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJLkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/share/model/ValidationResult;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "component1", "()J", "component2", "()Lkotlinx/serialization/json/JsonObject;", "component3", "component4", "component5", "copy", "(JLkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;)Lcom/kakao/sdk/share/model/ValidationResult;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTemplateId", "getTemplateId$annotations", "()V", "Lkotlinx/serialization/json/JsonObject;", "getTemplateArgs", "getTemplateArgs$annotations", "getTemplateMsg", "getTemplateMsg$annotations", "getWarningMsg", "getWarningMsg$annotations", "getArgumentMsg", "getArgumentMsg$annotations", "Companion", "$serializer", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class ValidationResult {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/share/model/ValidationResult.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/share/model/ValidationResult;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/share/model/ValidationResult;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/share/model/ValidationResult;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer validationResult$$serializer0 = new .serializer();
            .serializer.INSTANCE = validationResult$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.share.model.ValidationResult", validationResult$$serializer0, 5);
            pluginGeneratedSerialDescriptor0.addElement("template_id", false);
            pluginGeneratedSerialDescriptor0.addElement("template_args", false);
            pluginGeneratedSerialDescriptor0.addElement("template_msg", false);
            pluginGeneratedSerialDescriptor0.addElement("warning_msg", false);
            pluginGeneratedSerialDescriptor0.addElement("argument_msg", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            KSerializer kSerializer0 = BuiltinSerializersKt.getNullable(JsonObjectSerializer.INSTANCE);
            KSerializer kSerializer1 = BuiltinSerializersKt.getNullable(JsonObjectSerializer.INSTANCE);
            KSerializer kSerializer2 = BuiltinSerializersKt.getNullable(JsonObjectSerializer.INSTANCE);
            return new KSerializer[]{LongSerializer.INSTANCE, kSerializer0, JsonObjectSerializer.INSTANCE, kSerializer1, kSerializer2};
        }

        @NotNull
        public ValidationResult deserialize(@NotNull Decoder decoder0) {
            int v2;
            Object object5;
            long v1;
            Object object4;
            Object object3;
            Object object1;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            Object object0 = null;
            if(compositeDecoder0.decodeSequentially()) {
                long v = compositeDecoder0.decodeLongElement(serialDescriptor0, 0);
                object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, JsonObjectSerializer.INSTANCE, null);
                Object object2 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 2, JsonObjectSerializer.INSTANCE, null);
                object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, JsonObjectSerializer.INSTANCE, null);
                object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, JsonObjectSerializer.INSTANCE, null);
                v1 = v;
                object5 = object2;
                v2 = 0x1F;
            }
            else {
                int v3 = 0;
                Object object6 = null;
                v1 = 0L;
                object5 = null;
                Object object7 = null;
                boolean z = true;
                while(z) {
                    int v4 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v4) {
                        case -1: {
                            z = false;
                            break;
                        }
                        case 0: {
                            v1 = compositeDecoder0.decodeLongElement(serialDescriptor0, 0);
                            v3 |= 1;
                            break;
                        }
                        case 1: {
                            object0 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, JsonObjectSerializer.INSTANCE, object0);
                            v3 |= 2;
                            break;
                        }
                        case 2: {
                            object5 = compositeDecoder0.decodeSerializableElement(serialDescriptor0, 2, JsonObjectSerializer.INSTANCE, object5);
                            v3 |= 4;
                            break;
                        }
                        case 3: {
                            object7 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, JsonObjectSerializer.INSTANCE, object7);
                            v3 |= 8;
                            break;
                        }
                        case 4: {
                            object6 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, JsonObjectSerializer.INSTANCE, object6);
                            v3 |= 16;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v4);
                        }
                    }
                }
                v2 = v3;
                object1 = object0;
                object3 = object7;
                object4 = object6;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new ValidationResult(v2, v1, ((JsonObject)object1), ((JsonObject)object5), ((JsonObject)object3), ((JsonObject)object4), null);
        }

        @Override  // kotlinx.serialization.DeserializationStrategy
        public Object deserialize(Decoder decoder0) {
            return this.deserialize(decoder0);
        }

        @Override  // kotlinx.serialization.KSerializer
        @NotNull
        public SerialDescriptor getDescriptor() {
            return .serializer.descriptor;
        }

        public void serialize(@NotNull Encoder encoder0, @NotNull ValidationResult validationResult0) {
            q.g(encoder0, "encoder");
            q.g(validationResult0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            ValidationResult.write$Self(validationResult0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((ValidationResult)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/share/model/ValidationResult$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/share/model/ValidationResult;", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final KSerializer serializer() {
            return .serializer.INSTANCE;
        }
    }

    @NotNull
    public static final Companion Companion;
    @Nullable
    private final JsonObject argumentMsg;
    @Nullable
    private final JsonObject templateArgs;
    private final long templateId;
    @NotNull
    private final JsonObject templateMsg;
    @Nullable
    private final JsonObject warningMsg;

    static {
        ValidationResult.Companion = new Companion(null);
    }

    @d
    public ValidationResult(int v, @SerialName("template_id") long v1, @SerialName("template_args") JsonObject jsonObject0, @SerialName("template_msg") JsonObject jsonObject1, @SerialName("warning_msg") JsonObject jsonObject2, @SerialName("argument_msg") JsonObject jsonObject3, SerializationConstructorMarker serializationConstructorMarker0) {
        if(0x1F != (v & 0x1F)) {
            PluginExceptionsKt.throwMissingFieldException(v, 0x1F, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.templateId = v1;
        this.templateArgs = jsonObject0;
        this.templateMsg = jsonObject1;
        this.warningMsg = jsonObject2;
        this.argumentMsg = jsonObject3;
    }

    public ValidationResult(long v, @Nullable JsonObject jsonObject0, @NotNull JsonObject jsonObject1, @Nullable JsonObject jsonObject2, @Nullable JsonObject jsonObject3) {
        q.g(jsonObject1, "templateMsg");
        super();
        this.templateId = v;
        this.templateArgs = jsonObject0;
        this.templateMsg = jsonObject1;
        this.warningMsg = jsonObject2;
        this.argumentMsg = jsonObject3;
    }

    public final long component1() {
        return this.templateId;
    }

    @Nullable
    public final JsonObject component2() {
        return this.templateArgs;
    }

    @NotNull
    public final JsonObject component3() {
        return this.templateMsg;
    }

    @Nullable
    public final JsonObject component4() {
        return this.warningMsg;
    }

    @Nullable
    public final JsonObject component5() {
        return this.argumentMsg;
    }

    @NotNull
    public final ValidationResult copy(long v, @Nullable JsonObject jsonObject0, @NotNull JsonObject jsonObject1, @Nullable JsonObject jsonObject2, @Nullable JsonObject jsonObject3) {
        q.g(jsonObject1, "templateMsg");
        return new ValidationResult(v, jsonObject0, jsonObject1, jsonObject2, jsonObject3);
    }

    public static ValidationResult copy$default(ValidationResult validationResult0, long v, JsonObject jsonObject0, JsonObject jsonObject1, JsonObject jsonObject2, JsonObject jsonObject3, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = validationResult0.templateId;
        }
        if((v1 & 2) != 0) {
            jsonObject0 = validationResult0.templateArgs;
        }
        if((v1 & 4) != 0) {
            jsonObject1 = validationResult0.templateMsg;
        }
        if((v1 & 8) != 0) {
            jsonObject2 = validationResult0.warningMsg;
        }
        if((v1 & 16) != 0) {
            jsonObject3 = validationResult0.argumentMsg;
        }
        return validationResult0.copy(v, jsonObject0, jsonObject1, jsonObject2, jsonObject3);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ValidationResult)) {
            return false;
        }
        if(this.templateId != ((ValidationResult)object0).templateId) {
            return false;
        }
        if(!q.b(this.templateArgs, ((ValidationResult)object0).templateArgs)) {
            return false;
        }
        if(!q.b(this.templateMsg, ((ValidationResult)object0).templateMsg)) {
            return false;
        }
        return q.b(this.warningMsg, ((ValidationResult)object0).warningMsg) ? q.b(this.argumentMsg, ((ValidationResult)object0).argumentMsg) : false;
    }

    @Nullable
    public final JsonObject getArgumentMsg() {
        return this.argumentMsg;
    }

    @SerialName("argument_msg")
    public static void getArgumentMsg$annotations() {
    }

    @Nullable
    public final JsonObject getTemplateArgs() {
        return this.templateArgs;
    }

    @SerialName("template_args")
    public static void getTemplateArgs$annotations() {
    }

    public final long getTemplateId() {
        return this.templateId;
    }

    @SerialName("template_id")
    public static void getTemplateId$annotations() {
    }

    @NotNull
    public final JsonObject getTemplateMsg() {
        return this.templateMsg;
    }

    @SerialName("template_msg")
    public static void getTemplateMsg$annotations() {
    }

    @Nullable
    public final JsonObject getWarningMsg() {
        return this.warningMsg;
    }

    @SerialName("warning_msg")
    public static void getWarningMsg$annotations() {
    }

    @Override
    public int hashCode() {
        int v = Long.hashCode(this.templateId);
        int v1 = 0;
        int v2 = this.templateArgs == null ? 0 : this.templateArgs.hashCode();
        int v3 = this.templateMsg.hashCode();
        int v4 = this.warningMsg == null ? 0 : this.warningMsg.hashCode();
        JsonObject jsonObject0 = this.argumentMsg;
        if(jsonObject0 != null) {
            v1 = jsonObject0.hashCode();
        }
        return ((v3 + (v * 0x1F + v2) * 0x1F) * 0x1F + v4) * 0x1F + v1;
    }

    @Override
    @NotNull
    public String toString() {
        return "ValidationResult(templateId=" + this.templateId + ", templateArgs=" + this.templateArgs + ", templateMsg=" + this.templateMsg + ", warningMsg=" + this.warningMsg + ", argumentMsg=" + this.argumentMsg + ")";
    }

    public static final void write$Self(@NotNull ValidationResult validationResult0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(validationResult0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeLongElement(serialDescriptor0, 0, validationResult0.templateId);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 1, JsonObjectSerializer.INSTANCE, validationResult0.templateArgs);
        compositeEncoder0.encodeSerializableElement(serialDescriptor0, 2, JsonObjectSerializer.INSTANCE, validationResult0.templateMsg);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, JsonObjectSerializer.INSTANCE, validationResult0.warningMsg);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 4, JsonObjectSerializer.INSTANCE, validationResult0.argumentMsg);
    }
}

