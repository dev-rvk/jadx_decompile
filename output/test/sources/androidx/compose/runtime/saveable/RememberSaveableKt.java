package androidx.compose.runtime.saveable;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* compiled from: RememberSaveable.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0002\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0004\b\u0000\u0010\u00052\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u0002H\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u0003H\u0002\u001aa\u0010\b\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\n\"\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ag\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\n\"\u0004\u0018\u00010\u00062\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\u000fH\u0007¢\u0006\u0002\u0010\u0012\u001a\u0016\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"MaxSupportedRadix", "", "mutableStateSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/runtime/MutableState;", "T", "", "inner", "rememberSaveable", "inputs", "", "saver", "key", "", "init", "Lkotlin/Function0;", "([Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Ljava/lang/Object;", "stateSaver", "([Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/MutableState;", "requireCanBeSaved", "", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "value", "runtime-saveable_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RememberSaveableKt {
    private static final int MaxSupportedRadix = 36;

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: rememberSaveable, reason: collision with other method in class */
    public static final <T> T m2596rememberSaveable(Object[] inputs, Saver<T, ? extends Object> saver, String key, Function0<? extends T> init, Composer $composer, int $changed, int i) {
        String key2;
        final String finalKey;
        T restore;
        Object it;
        Intrinsics.checkNotNullParameter(inputs, "inputs");
        Intrinsics.checkNotNullParameter(init, "init");
        $composer.startReplaceableGroup(441892779);
        ComposerKt.sourceInformation($composer, "C(rememberSaveable)P(1,3,2)80@3500L7,82@3597L244,95@4209L27,96@4262L27,98@4299L441:RememberSaveable.kt#r2ddri");
        Saver saver2 = (i & 2) != 0 ? SaverKt.autoSaver() : saver;
        if ((i & 4) == 0) {
            key2 = key;
        } else {
            key2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(441892779, $changed, -1, "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:65)");
        }
        $composer.startReplaceableGroup(1059366469);
        ComposerKt.sourceInformation($composer, "*75@3334L23");
        String str = key2;
        if (!(str == null || str.length() == 0)) {
            finalKey = key2;
        } else {
            finalKey = Integer.toString(ComposablesKt.getCurrentCompositeKeyHash($composer, 0), CharsKt.checkRadix(MaxSupportedRadix));
            Intrinsics.checkNotNullExpressionValue(finalKey, "toString(this, checkRadix(radix))");
        }
        $composer.endReplaceableGroup();
        Intrinsics.checkNotNull(saver2, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable, kotlin.Any>");
        ProvidableCompositionLocal<SaveableStateRegistry> localSaveableStateRegistry = SaveableStateRegistryKt.getLocalSaveableStateRegistry();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localSaveableStateRegistry);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final SaveableStateRegistry registry = (SaveableStateRegistry) consume;
        Object[] keys$iv = Arrays.copyOf(inputs, inputs.length);
        $composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= $composer.changed(key$iv);
        }
        Object rememberedValue = $composer.rememberedValue();
        if (invalid$iv || rememberedValue == Composer.INSTANCE.getEmpty()) {
            restore = (registry == null || (it = registry.consumeRestored(finalKey)) == null) ? null : saver2.restore(it);
            if (restore == null) {
                restore = init.invoke();
            }
            $composer.updateRememberedValue(restore);
        } else {
            restore = rememberedValue;
        }
        $composer.endReplaceableGroup();
        if (registry != null) {
            final State saverState = SnapshotStateKt.rememberUpdatedState(saver2, $composer, 0);
            final State valueState = SnapshotStateKt.rememberUpdatedState(restore, $composer, 0);
            EffectsKt.DisposableEffect(registry, finalKey, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    final State<Saver<T, Object>> state = saverState;
                    final State<T> state2 = valueState;
                    final SaveableStateRegistry saveableStateRegistry = SaveableStateRegistry.this;
                    Function0 valueProvider = new Function0<Object>() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1$valueProvider$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Object value = state.getValue();
                            State<T> state3 = state2;
                            final SaveableStateRegistry saveableStateRegistry2 = saveableStateRegistry;
                            Saver $this$invoke_u24lambda_u240 = (Saver) value;
                            return $this$invoke_u24lambda_u240.save(new SaverScope() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1$valueProvider$1$1$1
                                @Override // androidx.compose.runtime.saveable.SaverScope
                                public final boolean canBeSaved(Object it2) {
                                    Intrinsics.checkNotNullParameter(it2, "it");
                                    return SaveableStateRegistry.this.canBeSaved(it2);
                                }
                            }, state3.getValue());
                        }
                    };
                    RememberSaveableKt.requireCanBeSaved(SaveableStateRegistry.this, valueProvider.invoke());
                    final SaveableStateRegistry.Entry entry = SaveableStateRegistry.this.registerProvider(finalKey, valueProvider);
                    return new DisposableEffectResult() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            SaveableStateRegistry.Entry.this.unregister();
                        }
                    };
                }
            }, $composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return restore;
    }

    public static final <T> MutableState<T> rememberSaveable(Object[] inputs, Saver<T, ? extends Object> stateSaver, String key, Function0<? extends MutableState<T>> init, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(inputs, "inputs");
        Intrinsics.checkNotNullParameter(stateSaver, "stateSaver");
        Intrinsics.checkNotNullParameter(init, "init");
        $composer.startReplaceableGroup(-202053668);
        ComposerKt.sourceInformation($composer, "C(rememberSaveable)P(1,3,2)141@6040L106:RememberSaveable.kt#r2ddri");
        if ((i & 4) != 0) {
            key = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-202053668, $changed, -1, "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:136)");
        }
        MutableState<T> mutableState = (MutableState) m2596rememberSaveable(Arrays.copyOf(inputs, inputs.length), mutableStateSaver(stateSaver), key, (Function0) init, $composer, ($changed & 896) | 8 | ($changed & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return mutableState;
    }

    private static final <T> Saver<MutableState<T>, MutableState<Object>> mutableStateSaver(final Saver<T, ? extends Object> saver) {
        Intrinsics.checkNotNull(saver, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver, kotlin.Any>");
        Saver $this$mutableStateSaver_u24lambda_u242 = SaverKt.Saver(new Function2<SaverScope, MutableState<T>, MutableState<Object>>() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$mutableStateSaver$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final MutableState<Object> invoke(SaverScope Saver, MutableState<T> state) {
                Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                Intrinsics.checkNotNullParameter(state, "state");
                if (!(state instanceof SnapshotMutableState)) {
                    throw new IllegalArgumentException("If you use a custom MutableState implementation you have to write a custom Saver and pass it as a saver param to rememberSaveable()".toString());
                }
                Object save = saver.save(Saver, state.getValue());
                SnapshotMutationPolicy<T> policy = ((SnapshotMutableState) state).getPolicy();
                Intrinsics.checkNotNull(policy, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<kotlin.Any?>");
                return SnapshotStateKt.mutableStateOf(save, policy);
            }
        }, new Function1<MutableState<Object>, MutableState<T>>() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$mutableStateSaver$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final MutableState<T> invoke(MutableState<Object> it) {
                T t;
                Intrinsics.checkNotNullParameter(it, "it");
                if (!(it instanceof SnapshotMutableState)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                if (it.getValue() != null) {
                    Saver<T, Object> saver2 = saver;
                    Object value = it.getValue();
                    Intrinsics.checkNotNull(value);
                    t = saver2.restore(value);
                } else {
                    t = null;
                }
                SnapshotMutationPolicy<T> policy = ((SnapshotMutableState) it).getPolicy();
                Intrinsics.checkNotNull(policy, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver$lambda$2?>");
                MutableState<T> mutableStateOf = SnapshotStateKt.mutableStateOf(t, policy);
                Intrinsics.checkNotNull(mutableStateOf, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver$lambda$2>");
                return mutableStateOf;
            }
        });
        return $this$mutableStateSaver_u24lambda_u242;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requireCanBeSaved(SaveableStateRegistry $this$requireCanBeSaved, Object value) {
        String str;
        if (value != null && !$this$requireCanBeSaved.canBeSaved(value)) {
            if (value instanceof SnapshotMutableState) {
                if (((SnapshotMutableState) value).getPolicy() != SnapshotStateKt.neverEqualPolicy() && ((SnapshotMutableState) value).getPolicy() != SnapshotStateKt.structuralEqualityPolicy() && ((SnapshotMutableState) value).getPolicy() != SnapshotStateKt.referentialEqualityPolicy()) {
                    str = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
                } else {
                    str = "MutableState containing " + ((SnapshotMutableState) value).getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
                }
            } else {
                str = value + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
            }
            throw new IllegalArgumentException(str);
        }
    }
}
