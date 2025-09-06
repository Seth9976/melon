package Le;

import e.k;
import java.util.Arrays;
import java.util.LinkedHashSet;
import je.I;
import je.u;
import jf.f;
import kotlin.jvm.internal.q;
import yf.c;

public final class r {
    public static final LinkedHashSet a;
    public static final LinkedHashSet b;
    public static final LinkedHashSet c;
    public static final LinkedHashSet d;
    public static final LinkedHashSet e;
    public static final LinkedHashSet f;
    public static final LinkedHashSet g;

    static {
        r.a = I.L(f.g("Collection", new String[]{"toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"}), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        Iterable iterable0 = k.A(new c[]{c.e, c.f});
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        for(Object object0: iterable0) {
            qf.c c0 = ((c)object0).d;
            if(c0 != null) {
                String s = c0.a.f().b();
                q.f(s, "asString(...)");
                u.U(linkedHashSet0, f.f(s, new String[]{((c)object0).b + "Value()" + ((c)object0).c()}));
                continue;
            }
            c.a(15);
            throw null;
        }
        r.b = I.K(I.K(I.K(I.K(I.K(I.K(linkedHashSet0, f.g("List", new String[]{"sort(Ljava/util/Comparator;)V", "reversed()Ljava/util/List;"})), f.f("String", new String[]{"codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;"})), f.f("Double", new String[]{"isInfinite()Z", "isNaN()Z"})), f.f("Float", new String[]{"isInfinite()Z", "isNaN()Z"})), f.f("Enum", new String[]{"getDeclaringClass()Ljava/lang/Class;", "finalize()V"})), f.f("CharSequence", new String[]{"isEmpty()Z"}));
        r.c = f.g("List", new String[]{"getFirst()Ljava/lang/Object;", "getLast()Ljava/lang/Object;"});
        r.d = I.K(I.K(I.K(I.K(I.K(I.K(f.f("CharSequence", new String[]{"codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"}), f.g("Iterator", new String[]{"forEachRemaining(Ljava/util/function/Consumer;)V"})), f.f("Iterable", new String[]{"forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;"})), f.f("Throwable", new String[]{"setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V"})), f.g("Collection", new String[]{"spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z"})), f.g("List", new String[]{"replaceAll(Ljava/util/function/UnaryOperator;)V", "addFirst(Ljava/lang/Object;)V", "addLast(Ljava/lang/Object;)V", "removeFirst()Ljava/lang/Object;", "removeLast()Ljava/lang/Object;"})), f.g("Map", new String[]{"getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"}));
        r.e = I.K(I.K(f.g("Collection", new String[]{"removeIf(Ljava/util/function/Predicate;)Z"}), f.g("List", new String[]{"replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V", "addFirst(Ljava/lang/Object;)V", "addLast(Ljava/lang/Object;)V", "removeFirst()Ljava/lang/Object;", "removeLast()Ljava/lang/Object;"})), f.g("Map", new String[]{"computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"}));
        Iterable iterable1 = k.A(new c[]{c.e, c.g, c.l, c.j, c.g, c.i, c.k, c.h});
        LinkedHashSet linkedHashSet1 = new LinkedHashSet();
        for(Object object1: iterable1) {
            qf.c c1 = ((c)object1).d;
            if(c1 != null) {
                String s1 = c1.a.f().b();
                q.f(s1, "asString(...)");
                String[] arr_s = f.a(new String[]{"Ljava/lang/String;"});
                u.U(linkedHashSet1, f.f(s1, ((String[])Arrays.copyOf(arr_s, arr_s.length))));
                continue;
            }
            c.a(15);
            throw null;
        }
        String[] arr_s1 = f.a(new String[]{"D"});
        LinkedHashSet linkedHashSet2 = I.K(linkedHashSet1, f.f("Float", ((String[])Arrays.copyOf(arr_s1, arr_s1.length))));
        String[] arr_s2 = f.a(new String[]{"[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;"});
        r.f = I.K(linkedHashSet2, f.f("String", ((String[])Arrays.copyOf(arr_s2, arr_s2.length))));
        String[] arr_s3 = f.a(new String[]{"Ljava/lang/String;Ljava/lang/Throwable;ZZ"});
        r.g = f.f("Throwable", ((String[])Arrays.copyOf(arr_s3, arr_s3.length)));
    }
}

