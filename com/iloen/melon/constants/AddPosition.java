package com.iloen.melon.constants;

public enum AddPosition {
    FIRST("add_first"),
    LAST("add_last"),
    AFTER_CURRENT("add_after");

    public final String a;

    public AddPosition(String s1) {
        this.a = s1;
    }

    public static AddPosition a(String s) {
        if(s != null) {
            AddPosition[] arr_addPosition = AddPosition.values();
            for(int v = 0; v < arr_addPosition.length; ++v) {
                AddPosition addPosition0 = arr_addPosition[v];
                if(s.equals(addPosition0.a)) {
                    return addPosition0;
                }
            }
        }
        throw new IllegalArgumentException("undefined enum value: " + s);
    }

    @Override
    public final String toString() {
        return this.a;
    }
}

