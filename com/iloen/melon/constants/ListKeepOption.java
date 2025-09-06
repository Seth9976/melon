package com.iloen.melon.constants;

public enum ListKeepOption {
    KEEP("oldlist_keep"),
    DELETE("oldlist_delete");

    public final String a;

    public ListKeepOption(String s1) {
        this.a = s1;
    }

    @Override
    public final String toString() {
        return this.a;
    }
}

