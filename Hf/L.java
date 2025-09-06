package hf;

import D2.E0;
import d5.c;
import java.util.LinkedHashMap;

public abstract class l {
    public static final d a;
    public static final d b;
    public static final d c;
    public static final LinkedHashMap d;

    static {
        l.a = new d(g.b, false);
        l.b = new d(g.c, false);
        l.c = new d(g.c, true);
        E0 e00 = new E0(3);
        new c(e00, "java/util/Iterator").b("forEachRemaining", new i("java/util/function/Consumer", 0), null);
        new c(e00, "java/lang/Iterable").b("spliterator", new n(4), null);
        c c0 = new c(e00, "java/util/Collection");
        c0.b("removeIf", new i("java/util/function/Predicate", 17), null);
        c0.b("stream", new i("java/util/stream/Stream", 26), null);
        c0.b("parallelStream", new k("java/util/stream/Stream", 1), null);
        c c1 = new c(e00, "java/util/List");
        c1.b("replaceAll", new k("java/util/function/UnaryOperator", 2), null);
        c1.b("addFirst", new k("java/lang/Object", 3), "2.1");
        c1.b("addLast", new k("java/lang/Object", 4), "2.1");
        c1.b("removeFirst", new k("java/lang/Object", 5), "2.1");
        c1.b("removeLast", new k("java/lang/Object", 6), "2.1");
        c c2 = new c(e00, "java/util/LinkedList");
        c2.b("addFirst", new i("java/lang/Object", 1), "2.1");
        c2.b("addLast", new i("java/lang/Object", 2), "2.1");
        c2.b("removeFirst", new i("java/lang/Object", 3), "2.1");
        c2.b("removeLast", new i("java/lang/Object", 4), "2.1");
        c c3 = new c(e00, "java/util/LinkedHashSet");
        c3.b("addFirst", new i("java/lang/Object", 5), "2.2");
        c3.b("addLast", new i("java/lang/Object", 6), "2.2");
        c3.b("removeFirst", new i("java/lang/Object", 7), "2.2");
        c3.b("removeLast", new i("java/lang/Object", 8), "2.2");
        c3.b("getFirst", new i("java/lang/Object", 9), "2.2");
        c3.b("getLast", new i("java/lang/Object", 10), "2.2");
        c c4 = new c(e00, "java/util/Map");
        c4.b("forEach", new i("java/util/function/BiConsumer", 11), null);
        c4.b("putIfAbsent", new i("java/lang/Object", 12), null);
        c4.b("replace", new i("java/lang/Object", 13), null);
        c4.b("replace", new i("java/lang/Object", 14), null);
        c4.b("replaceAll", new i("java/util/function/BiFunction", 15), null);
        c4.b("compute", new j("java/lang/Object", "java/util/function/BiFunction", 0), null);
        c4.b("computeIfAbsent", new j("java/lang/Object", "java/util/function/Function", 1), null);
        c4.b("computeIfPresent", new j("java/lang/Object", "java/util/function/BiFunction", 2), null);
        c4.b("merge", new j("java/lang/Object", "java/util/function/BiFunction", 3), null);
        c c5 = new c(e00, "java/util/LinkedHashMap");
        c5.b("putFirst", new i("java/lang/Object", 16), "2.2");
        c5.b("putLast", new i("java/lang/Object", 18), "2.2");
        c c6 = new c(e00, "java/util/Optional");
        c6.b("empty", new i("java/util/Optional", 19), null);
        c6.b("of", new j("java/lang/Object", "java/util/Optional", 4), null);
        c6.b("ofNullable", new j("java/lang/Object", "java/util/Optional", 5), null);
        c6.b("get", new i("java/lang/Object", 20), null);
        c6.b("ifPresent", new i("java/util/function/Consumer", 21), null);
        new c(e00, "java/lang/ref/Reference").b("get", new i("java/lang/Object", 22), null);
        new c(e00, "java/util/function/Predicate").b("test", new i("java/lang/Object", 23), null);
        new c(e00, "java/util/function/BiPredicate").b("test", new i("java/lang/Object", 24), null);
        new c(e00, "java/util/function/Consumer").b("accept", new i("java/lang/Object", 25), null);
        new c(e00, "java/util/function/BiConsumer").b("accept", new i("java/lang/Object", 27), null);
        new c(e00, "java/util/function/Function").b("apply", new i("java/lang/Object", 28), null);
        new c(e00, "java/util/function/BiFunction").b("apply", new i("java/lang/Object", 29), null);
        new c(e00, "java/util/function/Supplier").b("get", new k("java/lang/Object", 0), null);
        l.d = e00.a;
    }
}

