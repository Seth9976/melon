package kotlinx.serialization.descriptors;

import Sf.b;
import Vc.B;
import b9.a;
import d3.g;
import ie.j;
import ie.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jd.e3;
import je.A;
import je.C;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.internal.CachedNames;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001B\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0010\f\u001A\u00020\u000B\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u0003H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u001D\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00150\t2\u0006\u0010\u000F\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u000F\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u001A\u0010\u001F\u001A\u00020\u001A2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001DH\u0096\u0002\u00A2\u0006\u0004\b\u001F\u0010 J\u000F\u0010!\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010#\u001A\u00020\u0003H\u0016\u00A2\u0006\u0004\b#\u0010$R\u001A\u0010\u0004\u001A\u00020\u00038\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0004\u0010%\u001A\u0004\b&\u0010$R\u001A\u0010\u0006\u001A\u00020\u00058\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0006\u0010\'\u001A\u0004\b(\u0010)R\u001A\u0010\b\u001A\u00020\u00078\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\b\u0010*\u001A\u0004\b+\u0010\"R \u0010,\u001A\b\u0012\u0004\u0012\u00020\u00150\t8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b,\u0010-\u001A\u0004\b.\u0010/R \u00101\u001A\b\u0012\u0004\u0012\u00020\u0003008\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b1\u00102\u001A\u0004\b3\u00104R\u001A\u00106\u001A\b\u0012\u0004\u0012\u00020\u0003058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b6\u00107R\u001A\u00108\u001A\b\u0012\u0004\u0012\u00020\u0001058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b8\u00109R \u0010:\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\t058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010=\u001A\u00020<8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b=\u0010>R \u0010@\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070?8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b@\u0010AR\u001A\u0010B\u001A\b\u0012\u0004\u0012\u00020\u0001058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bB\u00109R\u001B\u0010F\u001A\u00020\u00078BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bC\u0010D\u001A\u0004\bE\u0010\"\u00A8\u0006G"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptorImpl;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "", "serialName", "Lkotlinx/serialization/descriptors/SerialKind;", "kind", "", "elementsCount", "", "typeParameters", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "builder", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;ILjava/util/List;Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;)V", "index", "getElementName", "(I)Ljava/lang/String;", "name", "getElementIndex", "(Ljava/lang/String;)I", "", "getElementAnnotations", "(I)Ljava/util/List;", "getElementDescriptor", "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "isElementOptional", "(I)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getSerialName", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "I", "getElementsCount", "annotations", "Ljava/util/List;", "getAnnotations", "()Ljava/util/List;", "", "serialNames", "Ljava/util/Set;", "getSerialNames", "()Ljava/util/Set;", "", "elementNames", "[Ljava/lang/String;", "elementDescriptors", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementAnnotations", "[Ljava/util/List;", "", "elementOptionality", "[Z", "", "name2Index", "Ljava/util/Map;", "typeParametersDescriptors", "_hashCode$delegate", "Lie/j;", "get_hashCode", "_hashCode", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class SerialDescriptorImpl implements SerialDescriptor, CachedNames {
    @NotNull
    private final j _hashCode$delegate;
    @NotNull
    private final List annotations;
    @NotNull
    private final List[] elementAnnotations;
    @NotNull
    private final SerialDescriptor[] elementDescriptors;
    @NotNull
    private final String[] elementNames;
    @NotNull
    private final boolean[] elementOptionality;
    private final int elementsCount;
    @NotNull
    private final SerialKind kind;
    @NotNull
    private final Map name2Index;
    @NotNull
    private final String serialName;
    @NotNull
    private final Set serialNames;
    @NotNull
    private final SerialDescriptor[] typeParametersDescriptors;

    public SerialDescriptorImpl(@NotNull String s, @NotNull SerialKind serialKind0, int v, @NotNull List list0, @NotNull ClassSerialDescriptorBuilder classSerialDescriptorBuilder0) {
        q.g(s, "serialName");
        q.g(serialKind0, "kind");
        q.g(list0, "typeParameters");
        q.g(classSerialDescriptorBuilder0, "builder");
        super();
        this.serialName = s;
        this.kind = serialKind0;
        this.elementsCount = v;
        this.annotations = classSerialDescriptorBuilder0.getAnnotations();
        this.serialNames = p.N0(classSerialDescriptorBuilder0.getElementNames$kotlinx_serialization_core());
        int v1 = 0;
        this.elementNames = (String[])classSerialDescriptorBuilder0.getElementNames$kotlinx_serialization_core().toArray(new String[0]);
        this.elementDescriptors = Platform_commonKt.compactArray(classSerialDescriptorBuilder0.getElementDescriptors$kotlinx_serialization_core());
        this.elementAnnotations = (List[])classSerialDescriptorBuilder0.getElementAnnotations$kotlinx_serialization_core().toArray(new List[0]);
        Collection collection0 = classSerialDescriptorBuilder0.getElementOptionality$kotlinx_serialization_core();
        q.g(collection0, "<this>");
        boolean[] arr_z = new boolean[collection0.size()];
        for(Object object0: collection0) {
            arr_z[v1] = ((Boolean)object0).booleanValue();
            ++v1;
        }
        this.elementOptionality = arr_z;
        q.g(this.elementNames, "<this>");
        Sf.p p0 = new Sf.p(new e3(this.elementNames, 1), 2);
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, p0));
        Iterator iterator1 = p0.iterator();
        while(((b)iterator1).b.hasNext()) {
            A a0 = (A)((b)iterator1).next();
            arrayList0.add(new m(a0.b, a0.a));
        }
        this.name2Index = C.Y(arrayList0);
        this.typeParametersDescriptors = Platform_commonKt.compactArray(list0);
        this._hashCode$delegate = g.Q(new a(this, 15));
    }

    private static final int _hashCode_delegate$lambda$1(SerialDescriptorImpl serialDescriptorImpl0) {
        return PluginGeneratedSerialDescriptorKt.hashCodeImpl(serialDescriptorImpl0, serialDescriptorImpl0.typeParametersDescriptors);
    }

    public static int a(SerialDescriptorImpl serialDescriptorImpl0) {
        return SerialDescriptorImpl._hashCode_delegate$lambda$1(serialDescriptorImpl0);
    }

    public static CharSequence b(SerialDescriptorImpl serialDescriptorImpl0, int v) {
        return SerialDescriptorImpl.toString$lambda$3(serialDescriptorImpl0, v);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof SerialDescriptorImpl)) {
            return false;
        }
        if(!q.b(this.getSerialName(), ((SerialDescriptor)object0).getSerialName())) {
            return false;
        }
        if(!Arrays.equals(this.typeParametersDescriptors, ((SerialDescriptorImpl)object0).typeParametersDescriptors)) {
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
        return this.annotations;
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public List getElementAnnotations(int v) {
        return this.elementAnnotations[v];
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public SerialDescriptor getElementDescriptor(int v) {
        return this.elementDescriptors[v];
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementIndex(@NotNull String s) {
        q.g(s, "name");
        Integer integer0 = (Integer)this.name2Index.get(s);
        return integer0 == null ? -3 : ((int)integer0);
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String getElementName(int v) {
        return this.elementNames[v];
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementsCount() {
        return this.elementsCount;
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public SerialKind getKind() {
        return this.kind;
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String getSerialName() {
        return this.serialName;
    }

    @Override  // kotlinx.serialization.internal.CachedNames
    @NotNull
    public Set getSerialNames() {
        return this.serialNames;
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
        return this.elementOptionality[v];
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return false;
    }

    @Override  // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isNullable() {
        return false;
    }

    @Override
    @NotNull
    public String toString() {
        return p.q0(P4.a.K(0, this.getElementsCount()), ", ", this.getSerialName() + '(', ")", new B(this, 18), 24);
    }

    private static final CharSequence toString$lambda$3(SerialDescriptorImpl serialDescriptorImpl0, int v) {
        return serialDescriptorImpl0.getElementName(v) + ": " + serialDescriptorImpl0.getElementDescriptor(v).getSerialName();
    }
}

