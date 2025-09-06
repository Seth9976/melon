package co.ab180.airbridge.internal.c0.e.b;

import android.provider.BaseColumns;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0014\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0005\u001A\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001A\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001A\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\u000B\u001A\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\r\u001A\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\u000F\u001A\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000E\u0010\u0004R\u0016\u0010\u0011\u001A\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0013\u001A\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004¨\u0006\u0016"}, d2 = {"Lco/ab180/airbridge/internal/c0/e/b/a;", "Landroid/provider/BaseColumns;", "", "d", "Ljava/lang/String;", "COLUMN_NAME_TYPE", "g", "COLUMN_SECRET_ID", "c", "COLUMN_NAME_CREATED_AT", "e", "COLUMN_NAME_BODY", "h", "COLUMN_SIGNATURE", "a", "TABLE_NAME", "b", "COLUMN_NAME_UUID", "f", "COLUMN_NAME_SIZE", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class a implements BaseColumns {
    @NotNull
    public static final String a = "event";
    @NotNull
    public static final String b = "uuid";
    @NotNull
    public static final String c = "created_at";
    @NotNull
    public static final String d = "type";
    @NotNull
    public static final String e = "body";
    @NotNull
    public static final String f = "size";
    @NotNull
    public static final String g = "secret_id";
    @NotNull
    public static final String h = "signature";
    @NotNull
    public static final a i;

    static {
        a.i = new a();
    }
}

