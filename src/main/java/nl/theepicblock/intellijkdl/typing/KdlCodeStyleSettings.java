package nl.theepicblock.intellijkdl.typing;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class KdlCodeStyleSettings extends CustomCodeStyleSettings {
    protected KdlCodeStyleSettings(CodeStyleSettings container) {
        super("KdlCodeStyleSettings", container);
    }
}
