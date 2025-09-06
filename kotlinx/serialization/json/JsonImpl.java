package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.json.internal.PolymorphismValidator;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lkotlinx/serialization/json/JsonImpl;", "Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Lkotlinx/serialization/modules/SerializersModule;", "module", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/modules/SerializersModule;)V", "Lie/H;", "validateConfiguration", "()V", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
final class JsonImpl extends Json {
    public JsonImpl(@NotNull JsonConfiguration jsonConfiguration0, @NotNull SerializersModule serializersModule0) {
        q.g(jsonConfiguration0, "configuration");
        q.g(serializersModule0, "module");
        super(jsonConfiguration0, serializersModule0, null);
        this.validateConfiguration();
    }

    private final void validateConfiguration() {
        if(q.b(this.getSerializersModule(), SerializersModuleBuildersKt.EmptySerializersModule())) {
            return;
        }
        this.getSerializersModule().dumpTo(new PolymorphismValidator(this.getConfiguration().getUseArrayPolymorphism(), this.getConfiguration().getClassDiscriminator()));
    }
}

