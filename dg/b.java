package dg;

import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import we.a;

public final class b implements a {
    public final int a;
    public final PluginGeneratedSerialDescriptor b;

    public b(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0, int v) {
        this.a = v;
        this.b = pluginGeneratedSerialDescriptor0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return PluginGeneratedSerialDescriptor.d(this.b);
            }
            case 1: {
                return PluginGeneratedSerialDescriptor.c(this.b);
            }
            default: {
                return PluginGeneratedSerialDescriptor.b(this.b);
            }
        }
    }
}

