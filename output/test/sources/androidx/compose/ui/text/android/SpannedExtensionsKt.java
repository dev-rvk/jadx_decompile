package androidx.compose.ui.text.android;

import android.text.Spanned;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpannedExtensions.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¨\u0006\b"}, d2 = {"hasSpan", "", "Landroid/text/Spanned;", "clazz", "Ljava/lang/Class;", "startInclusive", "", "endExclusive", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SpannedExtensionsKt {
    public static final boolean hasSpan(Spanned $this$hasSpan, Class<?> clazz) {
        Intrinsics.checkNotNullParameter($this$hasSpan, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return $this$hasSpan.nextSpanTransition(-1, $this$hasSpan.length(), clazz) != $this$hasSpan.length();
    }

    public static final boolean hasSpan(Spanned $this$hasSpan, Class<?> clazz, int startInclusive, int endExclusive) {
        Intrinsics.checkNotNullParameter($this$hasSpan, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return $this$hasSpan.nextSpanTransition(startInclusive + (-1), endExclusive, clazz) != endExclusive;
    }
}
