package t7;

import android.util.Base64;
import android.util.JsonWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import r7.b;
import r7.c;
import r7.d;
import r7.f;
import r7.g;

public final class e implements r7.e, g {
    public final boolean a;
    public final JsonWriter b;
    public final Map c;
    public final Map d;
    public final d e;
    public final boolean f;

    public e(Writer writer0, HashMap hashMap0, HashMap hashMap1, a a0, boolean z) {
        this.a = true;
        this.b = new JsonWriter(writer0);
        this.c = hashMap0;
        this.d = hashMap1;
        this.e = a0;
        this.f = z;
    }

    @Override  // r7.e
    public final r7.e a(c c0, Object object0) {
        this.i(object0, c0.a);
        return this;
    }

    @Override  // r7.e
    public final r7.e b(c c0, boolean z) {
        this.j();
        this.b.name(c0.a);
        this.j();
        this.b.value(z);
        return this;
    }

    @Override  // r7.g
    public final g c(String s) {
        this.j();
        this.b.value(s);
        return this;
    }

    @Override  // r7.e
    public final r7.e d(c c0, double f) {
        this.j();
        this.b.name(c0.a);
        this.j();
        this.b.value(f);
        return this;
    }

    @Override  // r7.e
    public final r7.e e(c c0, long v) {
        this.j();
        this.b.name(c0.a);
        this.j();
        this.b.value(v);
        return this;
    }

    @Override  // r7.e
    public final r7.e f(c c0, int v) {
        this.j();
        this.b.name(c0.a);
        this.j();
        this.b.value(((long)v));
        return this;
    }

    @Override  // r7.g
    public final g g(boolean z) {
        this.j();
        this.b.value(z);
        return this;
    }

    public final e h(Object object0) {
        JsonWriter jsonWriter0 = this.b;
        if(object0 == null) {
            jsonWriter0.nullValue();
            return this;
        }
        if(object0 instanceof Number) {
            jsonWriter0.value(((Number)object0));
            return this;
        }
        if(object0.getClass().isArray()) {
            if(object0 instanceof byte[]) {
                this.j();
                jsonWriter0.value(Base64.encodeToString(((byte[])object0), 2));
                return this;
            }
            jsonWriter0.beginArray();
            int v = 0;
            if(object0 instanceof int[]) {
                while(v < ((int[])object0).length) {
                    jsonWriter0.value(((long)((int[])object0)[v]));
                    ++v;
                }
            }
            else if(object0 instanceof long[]) {
                while(v < ((long[])object0).length) {
                    long v1 = ((long[])object0)[v];
                    this.j();
                    jsonWriter0.value(v1);
                    ++v;
                }
            }
            else if(object0 instanceof double[]) {
                while(v < ((double[])object0).length) {
                    jsonWriter0.value(((double[])object0)[v]);
                    ++v;
                }
            }
            else if(object0 instanceof boolean[]) {
                while(v < ((boolean[])object0).length) {
                    jsonWriter0.value(((boolean[])object0)[v]);
                    ++v;
                }
            }
            else if(object0 instanceof Number[]) {
                while(v < ((Number[])object0).length) {
                    this.h(((Number[])object0)[v]);
                    ++v;
                }
            }
            else {
                while(v < ((Object[])object0).length) {
                    this.h(((Object[])object0)[v]);
                    ++v;
                }
            }
            jsonWriter0.endArray();
            return this;
        }
        if(object0 instanceof Collection) {
            jsonWriter0.beginArray();
            for(Object object1: ((Collection)object0)) {
                this.h(object1);
            }
            jsonWriter0.endArray();
            return this;
        }
        if(object0 instanceof Map) {
            jsonWriter0.beginObject();
            for(Object object2: ((Map)object0).entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object2;
                Object object3 = map$Entry0.getKey();
                try {
                    this.i(map$Entry0.getValue(), ((String)object3));
                }
                catch(ClassCastException classCastException0) {
                    throw new b(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", object3, object3.getClass()), classCastException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
                }
            }
            jsonWriter0.endObject();
            return this;
        }
        Class class0 = object0.getClass();
        d d0 = (d)this.c.get(class0);
        if(d0 != null) {
            jsonWriter0.beginObject();
            d0.a(object0, this);
            jsonWriter0.endObject();
            return this;
        }
        Class class1 = object0.getClass();
        f f0 = (f)this.d.get(class1);
        if(f0 != null) {
            f0.a(object0, this);
            return this;
        }
        if(object0 instanceof Enum) {
            if(object0 instanceof t7.f) {
                int v2 = ((t7.f)object0).a();
                this.j();
                jsonWriter0.value(((long)v2));
                return this;
            }
            this.j();
            jsonWriter0.value(((Enum)object0).name());
            return this;
        }
        jsonWriter0.beginObject();
        this.e.a(object0, this);
        jsonWriter0.endObject();
        return this;
    }

    public final e i(Object object0, String s) {
        JsonWriter jsonWriter0 = this.b;
        if(this.f) {
            if(object0 == null) {
                return this;
            }
            this.j();
            jsonWriter0.name(s);
            this.h(object0);
            return this;
        }
        this.j();
        jsonWriter0.name(s);
        if(object0 == null) {
            jsonWriter0.nullValue();
            return this;
        }
        this.h(object0);
        return this;
    }

    public final void j() {
        if(!this.a) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
    }
}

