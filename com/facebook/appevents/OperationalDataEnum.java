package com.facebook.appevents;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/OperationalDataEnum;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IAPParameters", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public enum OperationalDataEnum {
    IAPParameters("iap_parameters");

    @NotNull
    private final String value;

    private static final OperationalDataEnum[] $values() [...] // Inlined contents

    private OperationalDataEnum(String s1) {
        this.value = s1;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}

