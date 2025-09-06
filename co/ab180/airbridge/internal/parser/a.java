package co.ab180.airbridge.internal.parser;

import co.ab180.airbridge.internal.parser.e.y;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u000E\u0010\u000F\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000E¢\u0006\u0004\b\u0010\u0010\u0011R\u001C\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\t\u001A\u00020\u00068F@\u0006¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0019\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00010\u00028F@\u0006¢\u0006\u0006\u001A\u0004\b\u0003\u0010\nR\u0016\u0010\r\u001A\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\f¨\u0006\u0012"}, d2 = {"Lco/ab180/airbridge/internal/parser/a;", "", "Lco/ab180/airbridge/internal/parser/e/y;", "b", "Lco/ab180/airbridge/internal/parser/e/y;", "_rule", "", "a", "()Ljava/lang/String;", "name", "()Lco/ab180/airbridge/internal/parser/e/y;", "rule", "Ljava/lang/String;", "_name", "Ljava/lang/Class;", "clazz", "<init>", "(Ljava/lang/Class;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class a {
    private final String a;
    private final y b;

    public a(@NotNull Class class0) {
        this.a = class0.getName();
        Class class1 = RuleWith.class;
        if(!class0.isAnnotationPresent(class1)) {
            throw new IllegalAccessException();
        }
        RuleWith ruleWith0 = (RuleWith)class0.getAnnotation(class1);
        if(ruleWith0 != null) {
            Class class2 = ruleWith0.value();
            if(class2 != null) {
                y y0 = (y)class2.newInstance();
                if(y0 != null) {
                    this.b = y0;
                    LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                    Field[] arr_field = class0.getDeclaredFields();
                    for(int v = 0; v < arr_field.length; ++v) {
                        Field field0 = arr_field[v];
                        Class class3 = d.class;
                        if(field0.isAnnotationPresent(class3)) {
                            d d0 = (d)field0.getAnnotation(class3);
                            if(d0 != null) {
                                linkedHashMap0.put(field0.getName(), d0.value());
                            }
                        }
                    }
                    this.b.a(linkedHashMap0);
                    return;
                }
            }
        }
        throw new IllegalAccessException();
    }

    @NotNull
    public final String a() {
        return this.a;
    }

    @NotNull
    public final y b() {
        return this.b;
    }
}

