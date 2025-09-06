package com.iloen.melon.types;

@Deprecated(since = "use MelonBottomSheetItem instead")
public class ContextItemInfo {
    public static class Params {
        public String a;

    }

    public ContextItemType a;
    public boolean b;
    public final Params c;

    public ContextItemInfo() {
        this.a = null;
        this.b = true;
        this.c = new Params();
    }

    public static ContextItemInfo a(ContextItemType contextItemType0) {
        ContextItemInfo contextItemInfo0 = new ContextItemInfo();
        if(contextItemType0 != null) {
            contextItemInfo0.a = contextItemType0;
        }
        return contextItemInfo0;
    }

    public final void b(Params contextItemInfo$Params0) {
        this.c.getClass();
        this.c.a = contextItemInfo$Params0.a;
    }
}

