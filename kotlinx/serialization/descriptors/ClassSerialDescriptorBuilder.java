package kotlinx.serialization.descriptors;

import com.iloen.melon.utils.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001B\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J7\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0006\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u00072\u000E\b\u0002\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\r\u001A\u00020\f¢\u0006\u0004\b\u000F\u0010\u0010R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013R.\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000E¢\u0006\u0018\n\u0004\b\u000B\u0010\u0014\u0012\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00020\u001B8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001C\u0010\u0014\u001A\u0004\b\u001D\u0010\u0016R\u001A\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u00020\u001E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001F\u0010 R \u0010!\u001A\b\u0012\u0004\u0012\u00020\u00070\u001B8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010\u0014\u001A\u0004\b\"\u0010\u0016R&\u0010#\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u001B8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010\u0014\u001A\u0004\b$\u0010\u0016R \u0010%\u001A\b\u0012\u0004\u0012\u00020\f0\u001B8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b%\u0010\u0014\u001A\u0004\b&\u0010\u0016¨\u0006\'"}, d2 = {"Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "", "", "serialName", "<init>", "(Ljava/lang/String;)V", "elementName", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "", "annotations", "", "isOptional", "Lie/H;", "element", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;Ljava/util/List;Z)V", "Ljava/lang/String;", "getSerialName", "()Ljava/lang/String;", "Ljava/util/List;", "getAnnotations", "()Ljava/util/List;", "setAnnotations", "(Ljava/util/List;)V", "getAnnotations$annotations", "()V", "", "elementNames", "getElementNames$kotlinx_serialization_core", "", "uniqueNames", "Ljava/util/Set;", "elementDescriptors", "getElementDescriptors$kotlinx_serialization_core", "elementAnnotations", "getElementAnnotations$kotlinx_serialization_core", "elementOptionality", "getElementOptionality$kotlinx_serialization_core", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class ClassSerialDescriptorBuilder {
    @NotNull
    private List annotations;
    @NotNull
    private final List elementAnnotations;
    @NotNull
    private final List elementDescriptors;
    @NotNull
    private final List elementNames;
    @NotNull
    private final List elementOptionality;
    @NotNull
    private final String serialName;
    @NotNull
    private final Set uniqueNames;

    public ClassSerialDescriptorBuilder(@NotNull String s) {
        q.g(s, "serialName");
        super();
        this.serialName = s;
        this.annotations = w.a;
        this.elementNames = new ArrayList();
        this.uniqueNames = new HashSet();
        this.elementDescriptors = new ArrayList();
        this.elementAnnotations = new ArrayList();
        this.elementOptionality = new ArrayList();
    }

    public final void element(@NotNull String s, @NotNull SerialDescriptor serialDescriptor0, @NotNull List list0, boolean z) {
        q.g(s, "elementName");
        q.g(serialDescriptor0, "descriptor");
        q.g(list0, "annotations");
        if(this.uniqueNames.add(s)) {
            this.elementNames.add(s);
            this.elementDescriptors.add(serialDescriptor0);
            this.elementAnnotations.add(list0);
            this.elementOptionality.add(Boolean.valueOf(z));
            return;
        }
        StringBuilder stringBuilder0 = a.n("Element with name \'", s, "\' is already registered in ");
        stringBuilder0.append(this.serialName);
        throw new IllegalArgumentException(stringBuilder0.toString().toString());
    }

    public static void element$default(ClassSerialDescriptorBuilder classSerialDescriptorBuilder0, String s, SerialDescriptor serialDescriptor0, List list0, boolean z, int v, Object object0) {
        if((v & 4) != 0) {
            list0 = w.a;
        }
        if((v & 8) != 0) {
            z = false;
        }
        classSerialDescriptorBuilder0.element(s, serialDescriptor0, list0, z);
    }

    @NotNull
    public final List getAnnotations() {
        return this.annotations;
    }

    @NotNull
    public final List getElementAnnotations$kotlinx_serialization_core() {
        return this.elementAnnotations;
    }

    @NotNull
    public final List getElementDescriptors$kotlinx_serialization_core() {
        return this.elementDescriptors;
    }

    @NotNull
    public final List getElementNames$kotlinx_serialization_core() {
        return this.elementNames;
    }

    @NotNull
    public final List getElementOptionality$kotlinx_serialization_core() {
        return this.elementOptionality;
    }

    public final void setAnnotations(@NotNull List list0) {
        q.g(list0, "<set-?>");
        this.annotations = list0;
    }
}

