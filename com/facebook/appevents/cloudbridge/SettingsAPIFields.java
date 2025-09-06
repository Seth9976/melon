package com.facebook.appevents.cloudbridge;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000B"}, d2 = {"Lcom/facebook/appevents/cloudbridge/SettingsAPIFields;", "", "rawValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "URL", "ENABLED", "DATASETID", "ACCESSKEY", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public enum SettingsAPIFields {
    URL("endpoint"),
    ENABLED("is_enabled"),
    DATASETID("dataset_id"),
    ACCESSKEY("access_key");

    @NotNull
    private final String rawValue;

    private static final SettingsAPIFields[] $values() [...] // Inlined contents

    private SettingsAPIFields(String s1) {
        this.rawValue = s1;
    }

    @NotNull
    public final String getRawValue() {
        return this.rawValue;
    }
}

