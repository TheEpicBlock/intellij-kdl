package nl.theepicblock.intellijkdl.typing;

import com.intellij.formatting.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import nl.theepicblock.intellijkdl.KdlLanguage;
import nl.theepicblock.intellijkdl.psi.KdlTypes;
import org.jetbrains.annotations.NotNull;

public class KdlFormattingModelBuilder implements FormattingModelBuilder {
    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        CommonCodeStyleSettings commonSettings = settings.getCommonSettings(KdlLanguage.INSTANCE.getID());

        int spacesBeforeBracket = commonSettings.SPACE_BEFORE_CLASS_LBRACE ? 1 : 0;
        return new SpacingBuilder(settings, KdlLanguage.INSTANCE)
                .withinPair(KdlTypes.STARTNODE, KdlTypes.ENDNODE).spaceIf(commonSettings.SPACE_WITHIN_BRACKETS, true)
                .before(KdlTypes.STARTNODE).spacing(spacesBeforeBracket, spacesBeforeBracket, 0, false, 0)
                .before(KdlTypes.IDENTIFIER)
                .none();
    }

    @Override
    public @NotNull FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        final CodeStyleSettings codeStyleSettings = formattingContext.getCodeStyleSettings();
        return FormattingModelProvider
                .createFormattingModelForPsiFile(formattingContext.getContainingFile(),
                        new KdlBlock(formattingContext.getNode(),
                                Wrap.createWrap(WrapType.NONE, false),
                                Alignment.createAlignment(),
                                createSpaceBuilder(codeStyleSettings),
                                Indent.getSmartIndent(Indent.Type.CONTINUATION)),
                        codeStyleSettings);
    }
}
