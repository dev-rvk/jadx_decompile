package androidx.compose.runtime;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* compiled from: SnapshotLongState.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a#\u0010\u0004\u001a\u00020\u0003*\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0086\n\u001a+\u0010\n\u001a\u00020\u000b*\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n¨\u0006\f"}, d2 = {"mutableLongStateOf", "Landroidx/compose/runtime/MutableLongState;", "value", "", "getValue", "Landroidx/compose/runtime/LongState;", "thisObj", "", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE, xs = "androidx/compose/runtime/SnapshotLongStateKt")
/* loaded from: classes.dex */
final /* synthetic */ class SnapshotLongStateKt__SnapshotLongStateKt {
    public static final MutableLongState mutableLongStateOf(long value) {
        return ActualAndroid_androidKt.createSnapshotMutableLongState(value);
    }

    public static final long getValue(LongState $this$getValue, Object thisObj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter($this$getValue, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        return $this$getValue.getLongValue();
    }

    public static final void setValue(MutableLongState $this$setValue, Object thisObj, KProperty<?> property, long value) {
        Intrinsics.checkNotNullParameter($this$setValue, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        $this$setValue.setLongValue(value);
    }
}
