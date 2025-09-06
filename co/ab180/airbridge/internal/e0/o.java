package co.ab180.airbridge.internal.e0;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000BJ!\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0006\u0010\t¨\u0006\f"}, d2 = {"Lco/ab180/airbridge/internal/e0/o;", "Lorg/json/JSONObject;", "", "name", "", "value", "put", "(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;", "", "(Ljava/lang/String;D)Lorg/json/JSONObject;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class o extends JSONObject {
    @Override  // org.json.JSONObject
    @NotNull
    public JSONObject put(@NotNull String s, double f) {
        return !Double.isInfinite(f) && !Double.isNaN(f) ? super.put(s, f) : this;
    }

    @Override  // org.json.JSONObject
    @NotNull
    public JSONObject put(@NotNull String s, @Nullable Object object0) {
        if(object0 instanceof Float) {
            float f = ((Number)object0).floatValue();
            if(Float.isInfinite(f) || Float.isNaN(f)) {
                return this;
            }
        }
        else if(object0 instanceof Number) {
            double f1 = ((Number)object0).doubleValue();
            if(Double.isInfinite(f1) || Double.isNaN(f1)) {
                return this;
            }
        }
        return super.put(s, object0);
    }
}

