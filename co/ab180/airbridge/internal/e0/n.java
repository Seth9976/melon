package co.ab180.airbridge.internal.e0;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0004\u001A\u00020\u00012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0004\u0010\u0007¨\u0006\n"}, d2 = {"Lco/ab180/airbridge/internal/e0/n;", "Lorg/json/JSONArray;", "", "value", "put", "(Ljava/lang/Object;)Lorg/json/JSONArray;", "", "(D)Lorg/json/JSONArray;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class n extends JSONArray {
    @Override  // org.json.JSONArray
    @NotNull
    public JSONArray put(double f) {
        return !Double.isInfinite(f) && !Double.isNaN(f) ? super.put(f) : this;
    }

    @Override  // org.json.JSONArray
    @NotNull
    public JSONArray put(@Nullable Object object0) {
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
        return super.put(object0);
    }
}

