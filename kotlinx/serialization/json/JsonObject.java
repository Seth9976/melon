package kotlinx.serialization.json;

import ed.s;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.internal.StringOpsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xe.a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\u001E\n\u0002\b\u0004\b\u0007\u0018\u0000 \"2\u00020\u00012\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\u0001\"B\u001B\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000B\u001A\u00020\fH\u0016J\b\u0010\r\u001A\u00020\u0003H\u0016J\u0011\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\u0003H\u0096\u0001J\u0011\u0010\u0010\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\u0001H\u0096\u0001J\u0013\u0010\u0012\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u000F\u001A\u00020\u0003H\u0096\u0003J\t\u0010\u0013\u001A\u00020\bH\u0096\u0001R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0014\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00160\u0015X\u0096\u0005¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00030\u0015X\u0096\u0005¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u0018R\u0012\u0010\u001B\u001A\u00020\fX\u0096\u0005¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u0018\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00010\u001FX\u0096\u0005¢\u0006\u0006\u001A\u0004\b \u0010!¨\u0006#"}, d2 = {"Lkotlinx/serialization/json/JsonObject;", "Lkotlinx/serialization/json/JsonElement;", "", "", "content", "<init>", "(Ljava/util/Map;)V", "equals", "", "other", "", "hashCode", "", "toString", "containsKey", "key", "containsValue", "value", "get", "isEmpty", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "Companion", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
@Serializable(with = JsonObjectSerializer.class)
public final class JsonObject extends JsonElement implements Map, a {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkotlinx/serialization/json/JsonObject$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonObject;", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final KSerializer serializer() {
            return JsonObjectSerializer.INSTANCE;
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Map content;

    static {
        JsonObject.Companion = new Companion(null);
    }

    public JsonObject(@NotNull Map map0) {
        q.g(map0, "content");
        super(null);
        this.content = map0;
    }

    public static CharSequence a(Map.Entry map$Entry0) {
        return JsonObject.toString$lambda$1(map$Entry0);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public Object compute(Object object0, BiFunction biFunction0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public Object computeIfAbsent(Object object0, Function function0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public Object computeIfPresent(Object object0, BiFunction biFunction0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean containsKey(Object object0) {
        return object0 instanceof String ? this.containsKey(((String)object0)) : false;
    }

    public boolean containsKey(@NotNull String s) {
        q.g(s, "key");
        return this.content.containsKey(s);
    }

    @Override
    public final boolean containsValue(Object object0) {
        return object0 instanceof JsonElement ? this.containsValue(((JsonElement)object0)) : false;
    }

    public boolean containsValue(@NotNull JsonElement jsonElement0) {
        q.g(jsonElement0, "value");
        return this.content.containsValue(jsonElement0);
    }

    @Override
    public final Set entrySet() {
        return this.getEntries();
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        return q.b(this.content, object0);
    }

    @Override
    public final Object get(Object object0) {
        return !(object0 instanceof String) ? null : this.get(((String)object0));
    }

    @Nullable
    public JsonElement get(@NotNull String s) {
        q.g(s, "key");
        return (JsonElement)this.content.get(s);
    }

    @NotNull
    public Set getEntries() {
        return this.content.entrySet();
    }

    @NotNull
    public Set getKeys() {
        return this.content.keySet();
    }

    public int getSize() {
        return this.content.size();
    }

    @NotNull
    public Collection getValues() {
        return this.content.values();
    }

    @Override
    public int hashCode() {
        return this.content.hashCode();
    }

    @Override
    public boolean isEmpty() {
        return this.content.isEmpty();
    }

    @Override
    public final Set keySet() {
        return this.getKeys();
    }

    @Override
    public Object merge(Object object0, Object object1, BiFunction biFunction0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public Object put(Object object0, Object object1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void putAll(Map map0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public Object putIfAbsent(Object object0, Object object1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public Object remove(Object object0) {
        return this.remove(object0);
    }

    public JsonElement remove(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean remove(Object object0, Object object1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public Object replace(Object object0, Object object1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean replace(Object object0, Object object1, Object object2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void replaceAll(BiFunction biFunction0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final int size() {
        return this.getSize();
    }

    @Override
    @NotNull
    public String toString() {
        return p.q0(this.content.entrySet(), ",", "{", "}", new s(3), 24);
    }

    private static final CharSequence toString$lambda$1(Map.Entry map$Entry0) {
        q.g(map$Entry0, "<destruct>");
        String s = (String)map$Entry0.getKey();
        JsonElement jsonElement0 = (JsonElement)map$Entry0.getValue();
        StringBuilder stringBuilder0 = new StringBuilder();
        StringOpsKt.printQuoted(stringBuilder0, s);
        stringBuilder0.append(':');
        stringBuilder0.append(jsonElement0);
        CharSequence charSequence0 = stringBuilder0.toString();
        q.f(charSequence0, "toString(...)");
        return charSequence0;
    }

    @Override
    public final Collection values() {
        return this.getValues();
    }
}

