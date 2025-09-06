package kotlinx.serialization.json.internal;

import kotlinx.serialization.json.JsonElement;
import we.k;

public final class a implements k {
    public final AbstractJsonTreeEncoder a;

    public a(AbstractJsonTreeEncoder abstractJsonTreeEncoder0) {
        this.a = abstractJsonTreeEncoder0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return AbstractJsonTreeEncoder.beginStructure$lambda$2(this.a, ((JsonElement)object0));
    }
}

