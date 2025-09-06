package co.ab180.airbridge.internal.network.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000E\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lco/ab180/airbridge/internal/network/model/b;", "", "", "type", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public enum b {
    USER("user"),
    SDK("sdk"),
    WEB_SDK("websdk");

    @NotNull
    private final String e;

    private b(String s1) {
        this.e = s1;
    }

    @NotNull
    public final String a() {
        return this.e;
    }
}

