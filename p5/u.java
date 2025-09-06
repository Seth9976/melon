package P5;

import U4.x;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.BufferedReader;
import java.io.IOException;

public final class u {
    public final long a;

    public u(long v) {
        this.a = v;
    }

    public static u a(BufferedReader bufferedReader0) {
        try(JsonReader jsonReader0 = new JsonReader(bufferedReader0)) {
            jsonReader0.beginObject();
            while(true) {
                if(!jsonReader0.hasNext()) {
                    break;
                }
                if(jsonReader0.nextName().equals("nextRequestWaitMillis")) {
                    return jsonReader0.peek() == JsonToken.STRING ? new u(Long.parseLong(jsonReader0.nextString())) : new u(jsonReader0.nextLong());
                }
                jsonReader0.skipValue();
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        }
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this ? true : object0 instanceof u && this.a == ((u)object0).a;
    }

    @Override
    public final int hashCode() {
        return ((int)(this.a >>> 0x20 ^ this.a)) ^ 1000003;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("LogResponse{nextRequestWaitMillis=");
        return x.h(this.a, "}", stringBuilder0);
    }
}

