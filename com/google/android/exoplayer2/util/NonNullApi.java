package com.google.android.exoplayer2.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;
import kotlin.annotations.jvm.MigrationStatus;
import kotlin.annotations.jvm.UnderMigration;

@Retention(RetentionPolicy.CLASS)
@Nonnull
@TypeQualifierDefault({ElementType.TYPE_USE})
@UnderMigration(status = MigrationStatus.STRICT)
public @interface NonNullApi {
}

