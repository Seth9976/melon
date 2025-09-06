package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001B\n\u0002\b\u0004\u001A;\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0003\u001A\u00020\u00022\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\b\u001Aa\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0003\u001A\u00020\u00022\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u00042\u000E\u0010\t\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u0014\u0010\u000B\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00040\u0004H\u0001¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"", "T", "", "serialName", "", "values", "Lkotlinx/serialization/KSerializer;", "createSimpleEnumSerializer", "(Ljava/lang/String;[Ljava/lang/Enum;)Lkotlinx/serialization/KSerializer;", "names", "", "annotations", "createMarkedEnumSerializer", "(Ljava/lang/String;[Ljava/lang/Enum;[Ljava/lang/String;[[Ljava/lang/annotation/Annotation;)Lkotlinx/serialization/KSerializer;", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class EnumsKt {
    @NotNull
    public static final KSerializer createMarkedEnumSerializer(@NotNull String s, @NotNull Enum[] arr_enum, @NotNull String[] arr_s, @NotNull Annotation[][] arr2_annotation) {
        q.g(s, "serialName");
        q.g(arr_enum, "values");
        q.g(arr_s, "names");
        q.g(arr2_annotation, "annotations");
        EnumDescriptor enumDescriptor0 = new EnumDescriptor(s, arr_enum.length);
        int v = 0;
        for(int v1 = 0; v < arr_enum.length; ++v1) {
            Enum enum0 = arr_enum[v];
            String s1 = (String)n.n0(v1, arr_s);
            if(s1 == null) {
                s1 = enum0.name();
            }
            PluginGeneratedSerialDescriptor.addElement$default(enumDescriptor0, s1, false, 2, null);
            Annotation[] arr_annotation = (Annotation[])n.n0(v1, arr2_annotation);
            if(arr_annotation != null) {
                int v2 = arr_annotation.length;
                for(int v3 = 0; v3 < v2; ++v3) {
                    enumDescriptor0.pushAnnotation(arr_annotation[v3]);
                }
            }
            ++v;
        }
        return new EnumSerializer(s, arr_enum, enumDescriptor0);
    }

    @NotNull
    public static final KSerializer createSimpleEnumSerializer(@NotNull String s, @NotNull Enum[] arr_enum) {
        q.g(s, "serialName");
        q.g(arr_enum, "values");
        return new EnumSerializer(s, arr_enum);
    }
}

