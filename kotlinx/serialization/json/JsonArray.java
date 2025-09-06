package kotlinx.serialization.json;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xe.a;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\b\b\u0007\u0018\u0000 \"2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002:\u0001\"B\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\f\u001A\u00020\rH\u0016J\u0011\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u0001H\u0096\u0003J\u0017\u0010\u0010\u001A\u00020\u00072\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00010\u0012H\u0096\u0001J\u0011\u0010\u0013\u001A\u00020\u00012\u0006\u0010\u0014\u001A\u00020\u000BH\u0096\u0003J\u0011\u0010\u0015\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u0001H\u0096\u0001J\t\u0010\u0016\u001A\u00020\u0007H\u0096\u0001J\u000F\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00010\u0018H\u0096\u0003J\u0011\u0010\u0019\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u0001H\u0096\u0001J\u000F\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00010\u001BH\u0096\u0001J\u0017\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00010\u001B2\u0006\u0010\u0014\u001A\u00020\u000BH\u0096\u0001J\u001F\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001D\u001A\u00020\u000B2\u0006\u0010\u001E\u001A\u00020\u000BH\u0096\u0001R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001F\u001A\u00020\u000BX\u0096\u0005¢\u0006\u0006\u001A\u0004\b \u0010!¨\u0006#"}, d2 = {"Lkotlinx/serialization/json/JsonArray;", "Lkotlinx/serialization/json/JsonElement;", "", "content", "<init>", "(Ljava/util/List;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "contains", "element", "containsAll", "elements", "", "get", "index", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "size", "getSize", "()I", "Companion", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
@Serializable(with = JsonArraySerializer.class)
public final class JsonArray extends JsonElement implements List, a {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkotlinx/serialization/json/JsonArray$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonArray;", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final KSerializer serializer() {
            return JsonArraySerializer.INSTANCE;
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final List content;

    static {
        JsonArray.Companion = new Companion(null);
    }

    public JsonArray(@NotNull List list0) {
        q.g(list0, "content");
        super(null);
        this.content = list0;
    }

    @Override
    public void add(int v, Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean add(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(int v, Collection collection0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection collection0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean contains(Object object0) {
        return object0 instanceof JsonElement ? this.contains(((JsonElement)object0)) : false;
    }

    public boolean contains(@NotNull JsonElement jsonElement0) {
        q.g(jsonElement0, "element");
        return this.content.contains(jsonElement0);
    }

    @Override
    public boolean containsAll(@NotNull Collection collection0) {
        q.g(collection0, "elements");
        return this.content.containsAll(collection0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        return q.b(this.content, object0);
    }

    @Override
    public Object get(int v) {
        return this.get(v);
    }

    @NotNull
    public JsonElement get(int v) {
        return (JsonElement)this.content.get(v);
    }

    public int getSize() {
        return this.content.size();
    }

    @Override
    public int hashCode() {
        return this.content.hashCode();
    }

    @Override
    public final int indexOf(Object object0) {
        return object0 instanceof JsonElement ? this.indexOf(((JsonElement)object0)) : -1;
    }

    public int indexOf(@NotNull JsonElement jsonElement0) {
        q.g(jsonElement0, "element");
        return this.content.indexOf(jsonElement0);
    }

    @Override
    public boolean isEmpty() {
        return this.content.isEmpty();
    }

    @Override
    @NotNull
    public Iterator iterator() {
        return this.content.iterator();
    }

    @Override
    public final int lastIndexOf(Object object0) {
        return object0 instanceof JsonElement ? this.lastIndexOf(((JsonElement)object0)) : -1;
    }

    public int lastIndexOf(@NotNull JsonElement jsonElement0) {
        q.g(jsonElement0, "element");
        return this.content.lastIndexOf(jsonElement0);
    }

    @Override
    @NotNull
    public ListIterator listIterator() {
        return this.content.listIterator();
    }

    @Override
    @NotNull
    public ListIterator listIterator(int v) {
        return this.content.listIterator(v);
    }

    @Override
    public Object remove(int v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean remove(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean removeAll(Collection collection0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void replaceAll(UnaryOperator unaryOperator0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean retainAll(Collection collection0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public Object set(int v, Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final int size() {
        return this.getSize();
    }

    @Override
    public void sort(Comparator comparator0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    @NotNull
    public List subList(int v, int v1) {
        return this.content.subList(v, v1);
    }

    @Override
    public Object[] toArray() {
        return p.a(this);
    }

    @Override
    public Object[] toArray(Object[] arr_object) {
        q.g(arr_object, "array");
        return p.b(this, arr_object);
    }

    @Override
    @NotNull
    public String toString() {
        return je.p.q0(this.content, ",", "[", "]", null, 56);
    }
}

