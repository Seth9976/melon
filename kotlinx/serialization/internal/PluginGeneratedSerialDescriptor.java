package kotlinx.serialization.internal;

import P4.a;
import d3.g;
import dd.z;
import dg.b;
import ie.j;
import ie.k;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import je.p;
import je.w;
import je.x;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind.CLASS;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001B\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0004\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\'\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007\u00A2\u0006\u0004\b\t\u0010\nJ\u001B\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u000BH\u0002\u00A2\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001A\u00020\u00012\u0006\u0010\u0018\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001B\u001A\u00020\u000F2\u0006\u0010\u0018\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u001D\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00140\u001D2\u0006\u0010\u0018\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0017\u0010 \u001A\u00020\u00032\u0006\u0010\u0018\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b \u0010!J\u0017\u0010\"\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u0003H\u0016\u00A2\u0006\u0004\b\"\u0010#J\u001A\u0010&\u001A\u00020\u000F2\b\u0010%\u001A\u0004\u0018\u00010$H\u0096\u0002\u00A2\u0006\u0004\b&\u0010\'J\u000F\u0010(\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b(\u0010)J\u000F\u0010*\u001A\u00020\u0003H\u0016\u00A2\u0006\u0004\b*\u0010+R\u001A\u0010\u0004\u001A\u00020\u00038\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0004\u0010,\u001A\u0004\b-\u0010+R\u001A\u0010\u0006\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u00058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0006\u0010.R\u0017\u0010\b\u001A\u00020\u00078\u0006\u00A2\u0006\f\n\u0004\b\b\u0010/\u001A\u0004\b0\u0010)R\u0016\u00101\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b1\u0010/R\u001A\u00103\u001A\b\u0012\u0004\u0012\u00020\u0003028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b3\u00104R\"\u00106\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u000105028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b6\u00107R\u001E\u00108\u001A\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001A\u00020:8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b;\u0010<R\"\u0010=\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u000B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010>R%\u0010D\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?028BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b@\u0010A\u001A\u0004\bB\u0010CR!\u0010H\u001A\b\u0012\u0004\u0012\u00020\u0001028@X\u0080\u0084\u0002\u00A2\u0006\f\n\u0004\bE\u0010A\u001A\u0004\bF\u0010GR\u001B\u0010K\u001A\u00020\u00078BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bI\u0010A\u001A\u0004\bJ\u0010)R\u0014\u0010O\u001A\u00020L8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bM\u0010NR\u001A\u0010R\u001A\b\u0012\u0004\u0012\u00020\u00140\u001D8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bP\u0010QR\u001A\u0010V\u001A\b\u0012\u0004\u0012\u00020\u00030S8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bT\u0010U\u00A8\u0006W"}, d2 = {"Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "", "serialName", "Lkotlinx/serialization/internal/GeneratedSerializer;", "generatedSerializer", "", "elementsCount", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;I)V", "", "buildIndices", "()Ljava/util/Map;", "name", "", "isOptional", "Lie/H;", "addElement", "(Ljava/lang/String;Z)V", "", "annotation", "pushAnnotation", "(Ljava/lang/annotation/Annotation;)V", "index", "getElementDescriptor", "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "isElementOptional", "(I)Z", "", "getElementAnnotations", "(I)Ljava/util/List;", "getElementName", "(I)Ljava/lang/String;", "getElementIndex", "(Ljava/lang/String;)I", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getSerialName", "Lkotlinx/serialization/internal/GeneratedSerializer;", "I", "getElementsCount", "added", "", "names", "[Ljava/lang/String;", "", "propertiesAnnotations", "[Ljava/util/List;", "classAnnotations", "Ljava/util/List;", "", "elementsOptionality", "[Z", "indices", "Ljava/util/Map;", "Lkotlinx/serialization/KSerializer;", "childSerializers$delegate", "Lie/j;", "getChildSerializers", "()[Lkotlinx/serialization/KSerializer;", "childSerializers", "typeParameterDescriptors$delegate", "getTypeParameterDescriptors$kotlinx_serialization_core", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParameterDescriptors", "_hashCode$delegate", "get_hashCode", "_hashCode", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "getAnnotations", "()Ljava/util/List;", "annotations", "", "getSerialNames", "()Ljava/util/Set;", "serialNames", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public class PluginGeneratedSerialDescriptor implements SerialDescriptor, CachedNames {
    @NotNull
    private final j _hashCode$delegate;
    private int added;
    @NotNull
    private final j childSerializers$delegate;
    @Nullable
    private List classAnnotations;
    private final int elementsCount;
    @NotNull
    private final boolean[] elementsOptionality;
    @Nullable
    private final GeneratedSerializer generatedSerializer;
    @NotNull
    private Map indices;
    @NotNull
    private final String[] names;
    @NotNull
    private final List[] propertiesAnnotations;
    @NotNull
    private final String serialName;
    @NotNull
    private final j typeParameterDescriptors$delegate;

    public PluginGeneratedSerialDescriptor(@NotNull String s, @Nullable GeneratedSerializer generatedSerializer0, int v) {
        q.g(s, "serialName");
        super();
        this.serialName = s;
        this.generatedSerializer = generatedSerializer0;
        this.elementsCount = v;
        this.added = -1;
        String[] arr_s = new String[v];
        for(int v1 = 0; v1 < v; ++v1) {
            arr_s[v1] = "[UNINITIALIZED]";
        }
        this.names = arr_s;
        this.propertiesAnnotations = new List[this.elementsCount];
        this.elementsOptionality = new boolean[this.elementsCount];
        this.indices = x.a;
        b b0 = new b(this, 0);
        this.childSerializers$delegate = g.P(k.b, b0);
        b b1 = new b(this, 1);
        this.typeParameterDescriptors$delegate = g.P(k.b, b1);
        b b2 = new b(this, 2);
        this._hashCode$delegate = g.P(k.b, b2);
    }

    public PluginGeneratedSerialDescriptor(String s, GeneratedSerializer generatedSerializer0, int v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            generatedSerializer0 = null;
        }
        this(s, generatedSerializer0, v);
    }

    private static final int _hashCode_delegate$lambda$3(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0) {
        return PluginGeneratedSerialDescriptorKt.hashCodeImpl(pluginGeneratedSerialDescriptor0, pluginGeneratedSerialDescriptor0.getTypeParameterDescriptors$kotlinx_serialization_core());
    }

    public static CharSequence a(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0, int v) {
        return PluginGeneratedSerialDescriptor.toString$lambda$6(pluginGeneratedSerialDescriptor0, v);
    }

    public final void addElement(@NotNull String s, boolean z) {
        q.g(s, "name");
        int v = this.added + 1;
        this.added = v;
        this.names[v] = s;
        this.elementsOptionality[v] = z;
        this.propertiesAnnotations[v] = null;
        if(v == this.elementsCount - 1) {
            this.indices = this.buildIndices();
        }
    }

    public static void addElement$default(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0, String s, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
        }
        if((v & 2) != 0) {
            z = false;
        }
        pluginGeneratedSerialDescriptor0.addElement(s, z);
    }

    public static int b(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0) {
        return PluginGeneratedSerialDescriptor._hashCode_delegate$lambda$3(pluginGeneratedSerialDescriptor0);
    }

    private final Map buildIndices() {
        Map map0 = new HashMap();
        for(int v = 0; v < this.names.length; ++v) {
            map0.put(this.names[v], v);
        }
        return map0;
    }

    public static SerialDescriptor[] c(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0) {
        return PluginGeneratedSerialDescriptor.typeParameterDescriptors_delegate$lambda$2(pluginGeneratedSerialDescriptor0);
    }

    private static final KSerializer[] childSerializers_delegate$lambda$0(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0) {
        GeneratedSerializer generatedSerializer0 = pluginGeneratedSerialDescriptor0.generatedSerializer;
        if(generatedSerializer0 != null) {
            KSerializer[] arr_kSerializer = generatedSerializer0.childSerializers();
            return arr_kSerializer == null ? PluginHelperInterfacesKt.EMPTY_SERIALIZER_ARRAY : arr_kSerializer;
        }
        return PluginHelperInterfacesKt.EMPTY_SERIALIZER_ARRAY;
    }

    public static KSerializer[] d(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0) {
        return PluginGeneratedSerialDescriptor.childSerializers_delegate$lambda$0(pluginGeneratedSerialDescriptor0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PluginGeneratedSerialDescriptor)) {
            return false;
        }
        if(!q.b(this.getSerialName(), ((SerialDescriptor)object0).getSerialName())) {
            return false;
        }
        if(!Arrays.equals(this.getTypeParameterDescriptors$kotlinx_serialization_core(), ((PluginGeneratedSerialDescriptor)object0).getTypeParameterDescriptors$kotlinx_serialization_core())) {
            return false;
        }
        if(this.getElementsCount() != ((SerialDescriptor)object0).getElementsCount()) {
            return false;
        }
        int v = this.getElementsCount();
        for(int v1 = 0; v1 < v; ++v1) {
            if(!q.b(this.getElementDescriptor(v1).getSerialName(), ((SerialDescriptor)object0).getElementDescriptor(v1).getSerialName())) {
                return false;
            }
            if(!q.b(this.getElementDescriptor(v1).getKind(), ((SerialDescriptor)object0).getElementDescriptor(v1).getKind())) {
                return false;
            }
        }
        return true;
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List getAnnotations() {
        List list0 = this.classAnnotations;
        return list0 == null ? w.a : list0;
    }

    private final KSerializer[] getChildSerializers() {
        return (KSerializer[])this.childSerializers$delegate.getValue();
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List getElementAnnotations(int v) {
        List list0 = this.propertiesAnnotations[v];
        return list0 == null ? w.a : list0;
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public SerialDescriptor getElementDescriptor(int v) {
        return this.getChildSerializers()[v].getDescriptor();
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementIndex(@NotNull String s) {
        q.g(s, "name");
        Integer integer0 = (Integer)this.indices.get(s);
        return integer0 == null ? -3 : ((int)integer0);
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String getElementName(int v) {
        return this.names[v];
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementsCount() {
        return this.elementsCount;
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public SerialKind getKind() {
        return CLASS.INSTANCE;
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String getSerialName() {
        return this.serialName;
    }

    @Override  // kotlinx.serialization.internal.CachedNames
    @NotNull
    public Set getSerialNames() {
        return this.indices.keySet();
    }

    @NotNull
    public final SerialDescriptor[] getTypeParameterDescriptors$kotlinx_serialization_core() {
        return (SerialDescriptor[])this.typeParameterDescriptors$delegate.getValue();
    }

    private final int get_hashCode() {
        return ((Number)this._hashCode$delegate.getValue()).intValue();
    }

    @Override
    public int hashCode() {
        return this.get_hashCode();
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isElementOptional(int v) {
        return this.elementsOptionality[v];
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return false;
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isNullable() {
        return false;
    }

    public final void pushAnnotation(@NotNull Annotation annotation0) {
        q.g(annotation0, "annotation");
        List list0 = this.propertiesAnnotations[this.added];
        if(list0 == null) {
            list0 = new ArrayList(1);
            this.propertiesAnnotations[this.added] = list0;
        }
        list0.add(annotation0);
    }

    @Override
    @NotNull
    public String toString() {
        return p.q0(a.K(0, this.elementsCount), ", ", this.getSerialName() + '(', ")", new z(this, 8), 24);
    }

    private static final CharSequence toString$lambda$6(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0, int v) {
        return pluginGeneratedSerialDescriptor0.getElementName(v) + ": " + pluginGeneratedSerialDescriptor0.getElementDescriptor(v).getSerialName();
    }

    private static final SerialDescriptor[] typeParameterDescriptors_delegate$lambda$2(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0) {
        GeneratedSerializer generatedSerializer0 = pluginGeneratedSerialDescriptor0.generatedSerializer;
        if(generatedSerializer0 != null) {
            KSerializer[] arr_kSerializer = generatedSerializer0.typeParametersSerializers();
            if(arr_kSerializer != null) {
                ArrayList arrayList0 = new ArrayList(arr_kSerializer.length);
                for(int v = 0; v < arr_kSerializer.length; ++v) {
                    arrayList0.add(arr_kSerializer[v].getDescriptor());
                }
                return Platform_commonKt.compactArray(arrayList0);
            }
            return Platform_commonKt.compactArray(null);
        }
        return Platform_commonKt.compactArray(null);
    }
}

