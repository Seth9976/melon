package kotlinx.serialization.modules;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u00052\u0010\u0010\u0006\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0007H¦\u0002\u0082\u0001\u0002\n\u000B¨\u0006\f"}, d2 = {"Lkotlinx/serialization/modules/ContextualProvider;", "", "<init>", "()V", "invoke", "Lkotlinx/serialization/KSerializer;", "typeArgumentsSerializers", "", "Argless", "WithTypeArguments", "Lkotlinx/serialization/modules/ContextualProvider$Argless;", "Lkotlinx/serialization/modules/ContextualProvider$WithTypeArguments;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class ContextualProvider {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\b\u001A\u0006\u0012\u0002\b\u00030\u00032\u0010\u0010\t\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\nH\u0096\u0002J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0096\u0002J\b\u0010\u000F\u001A\u00020\u0010H\u0016R\u0015\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkotlinx/serialization/modules/ContextualProvider$Argless;", "Lkotlinx/serialization/modules/ContextualProvider;", "serializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "getSerializer", "()Lkotlinx/serialization/KSerializer;", "invoke", "typeArgumentsSerializers", "", "equals", "", "other", "", "hashCode", "", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
    public static final class Argless extends ContextualProvider {
        @NotNull
        private final KSerializer serializer;

        public Argless(@NotNull KSerializer kSerializer0) {
            q.g(kSerializer0, "serializer");
            super(null);
            this.serializer = kSerializer0;
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return object0 instanceof Argless && q.b(((Argless)object0).serializer, this.serializer);
        }

        @NotNull
        public final KSerializer getSerializer() {
            return this.serializer;
        }

        @Override
        public int hashCode() {
            return this.serializer.hashCode();
        }

        @Override  // kotlinx.serialization.modules.ContextualProvider
        @NotNull
        public KSerializer invoke(@NotNull List list0) {
            q.g(list0, "typeArgumentsSerializers");
            return this.serializer;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B)\u0012 \u0010\u0005\u001A\u001C\u0012\u000E\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\t\u001A\u0006\u0012\u0002\b\u00030\u00042\u0010\u0010\b\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003H\u0096\u0002¢\u0006\u0004\b\t\u0010\nR1\u0010\u0005\u001A\u001C\u0012\u000E\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000B\u001A\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lkotlinx/serialization/modules/ContextualProvider$WithTypeArguments;", "Lkotlinx/serialization/modules/ContextualProvider;", "Lkotlin/Function1;", "", "Lkotlinx/serialization/KSerializer;", "provider", "<init>", "(Lwe/k;)V", "typeArgumentsSerializers", "invoke", "(Ljava/util/List;)Lkotlinx/serialization/KSerializer;", "Lwe/k;", "getProvider", "()Lwe/k;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
    public static final class WithTypeArguments extends ContextualProvider {
        @NotNull
        private final k provider;

        public WithTypeArguments(@NotNull k k0) {
            q.g(k0, "provider");
            super(null);
            this.provider = k0;
        }

        @NotNull
        public final k getProvider() {
            return this.provider;
        }

        @Override  // kotlinx.serialization.modules.ContextualProvider
        @NotNull
        public KSerializer invoke(@NotNull List list0) {
            q.g(list0, "typeArgumentsSerializers");
            return (KSerializer)this.provider.invoke(list0);
        }
    }

    private ContextualProvider() {
    }

    public ContextualProvider(DefaultConstructorMarker defaultConstructorMarker0) {
    }

    @NotNull
    public abstract KSerializer invoke(@NotNull List arg1);
}

