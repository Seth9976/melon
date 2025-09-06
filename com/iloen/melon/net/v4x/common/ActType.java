package com.iloen.melon.net.v4x.common;

public enum ActType {
    LIKE("N20001"),
    INQUIRY("N20002"),
    RECOMMAND("N20003"),
    FAN("N20004");

    public String value;

    private static ActType[] $values() [...] // Inlined contents

    private ActType(String s1) {
        this.value = s1;
    }
}

