package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectableModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Focusable.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0001\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0006H\u0007\u001a \u0010\u0007\u001a\u00020\u0006*\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u001e\u0010\f\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0000\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"FocusableInNonTouchModeElement", "androidx/compose/foundation/FocusableKt$FocusableInNonTouchModeElement$1", "Landroidx/compose/foundation/FocusableKt$FocusableInNonTouchModeElement$1;", "focusGroupInspectorInfo", "Landroidx/compose/ui/platform/InspectableModifier;", "focusGroup", "Landroidx/compose/ui/Modifier;", "focusable", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "focusableInNonTouchMode", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FocusableKt {
    private static final FocusableKt$FocusableInNonTouchModeElement$1 FocusableInNonTouchModeElement;
    private static final InspectableModifier focusGroupInspectorInfo;

    public static /* synthetic */ Modifier focusable$default(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            mutableInteractionSource = null;
        }
        return focusable(modifier, z, mutableInteractionSource);
    }

    public static final Modifier focusable(Modifier $this$focusable, boolean enabled, MutableInteractionSource interactionSource) {
        Modifier.Companion companion;
        Intrinsics.checkNotNullParameter($this$focusable, "<this>");
        if (enabled) {
            companion = FocusModifierKt.focusTarget(new FocusableElement(interactionSource));
        } else {
            companion = Modifier.INSTANCE;
        }
        return $this$focusable.then(companion);
    }

    public static final Modifier focusGroup(Modifier $this$focusGroup) {
        Intrinsics.checkNotNullParameter($this$focusGroup, "<this>");
        return FocusModifierKt.focusTarget(FocusPropertiesKt.focusProperties($this$focusGroup.then(focusGroupInspectorInfo), new Function1<FocusProperties, Unit>() { // from class: androidx.compose.foundation.FocusableKt$focusGroup$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FocusProperties focusProperties) {
                invoke2(focusProperties);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FocusProperties focusProperties) {
                Intrinsics.checkNotNullParameter(focusProperties, "$this$focusProperties");
                focusProperties.setCanFocus(false);
            }
        }));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.foundation.FocusableKt$FocusableInNonTouchModeElement$1] */
    static {
        focusGroupInspectorInfo = new InspectableModifier(InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.FocusableKt$special$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("focusGroup");
            }
        } : InspectableValueKt.getNoInspectorInfo());
        FocusableInNonTouchModeElement = new ModifierNodeElement<FocusableInNonTouchMode>() { // from class: androidx.compose.foundation.FocusableKt$FocusableInNonTouchModeElement$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.compose.ui.node.ModifierNodeElement
            public FocusableInNonTouchMode create() {
                return new FocusableInNonTouchMode();
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public void update(FocusableInNonTouchMode node) {
                Intrinsics.checkNotNullParameter(node, "node");
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public int hashCode() {
                return System.identityHashCode(this);
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public boolean equals(Object other) {
                return this == other;
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
                Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
                $this$inspectableProperties.setName("focusableInNonTouchMode");
            }
        };
    }

    public static final Modifier focusableInNonTouchMode(Modifier $this$focusableInNonTouchMode, final boolean enabled, final MutableInteractionSource interactionSource) {
        Intrinsics.checkNotNullParameter($this$focusableInNonTouchMode, "<this>");
        Function1 inspectorInfo$iv = new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.FocusableKt$focusableInNonTouchMode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectable) {
                Intrinsics.checkNotNullParameter(inspectable, "$this$inspectable");
                inspectable.setName("focusableInNonTouchMode");
                inspectable.getProperties().set("enabled", Boolean.valueOf(enabled));
                inspectable.getProperties().set("interactionSource", interactionSource);
            }
        };
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier $this$focusableInNonTouchMode_u24lambda_u241 = focusable(Modifier.INSTANCE.then(FocusableInNonTouchModeElement), enabled, interactionSource);
        return InspectableValueKt.inspectableWrapper($this$focusableInNonTouchMode, inspectorInfo$iv, $this$focusableInNonTouchMode_u24lambda_u241);
    }
}
