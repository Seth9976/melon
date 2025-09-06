package com.iloen.melon.net.mcp;

public enum AddOptionServer {
    FIRST("FIRST_OF_LIST"),
    LAST("LAST_OF_LIST"),
    AFTER_CURRENT("AFTER_PLAYING");

    private final String value;

    private static AddOptionServer[] $values() [...] // Inlined contents

    private AddOptionServer(String s1) {
        this.value = s1;
    }

    public String getValue() {
        return this.value;
    }

    public static AddOptionServer lookup(String s) {
        if(s != null) {
            AddOptionServer[] arr_addOptionServer = AddOptionServer.values();
            for(int v = 0; v < arr_addOptionServer.length; ++v) {
                AddOptionServer addOptionServer0 = arr_addOptionServer[v];
                if(s.equals(addOptionServer0.value)) {
                    return addOptionServer0;
                }
            }
        }
        throw new IllegalArgumentException("undefined enum value: " + s);
    }

    @Override
    public String toString() {
        return this.value;
    }
}

