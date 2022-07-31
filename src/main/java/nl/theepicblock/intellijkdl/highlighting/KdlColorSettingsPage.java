package nl.theepicblock.intellijkdl.highlighting;

import com.intellij.lang.Language;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.RainbowColorSettingsPage;
import com.intellij.openapi.util.NlsContexts;
import nl.theepicblock.intellijkdl.KdlIcons;
import nl.theepicblock.intellijkdl.KdlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class KdlColorSettingsPage implements RainbowColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Types//Boolean", KdlSyntaxHighlighter.BOOLEAN),
            new AttributesDescriptor("Types//Null", KdlSyntaxHighlighter.NULL),
            new AttributesDescriptor("Types//Number", KdlSyntaxHighlighter.NUMBER),
            new AttributesDescriptor("Types//String", KdlSyntaxHighlighter.STRING),
            new AttributesDescriptor("Structure//Braces", KdlSyntaxHighlighter.BRACE),
            new AttributesDescriptor("Structure//Property seperator", KdlSyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("Structure//Parentheses", KdlSyntaxHighlighter.PARENTHESES),
            new AttributesDescriptor("Structure//Semicolons", KdlSyntaxHighlighter.SEMICOLON),
            new AttributesDescriptor("Property key", KdlSyntaxHighlighter.PROPERTY_KEY),
            new AttributesDescriptor("Type specifier", KdlSyntaxHighlighter.TYPE_SPECIFIER),
            new AttributesDescriptor("Node name", KdlSyntaxHighlighter.NODE_NAME),
            new AttributesDescriptor("Bad value", KdlSyntaxHighlighter.BAD_CHARACTER)
    };

    @Override
    public @Nullable Icon getIcon() {
        return KdlIcons.FILE;
    }

    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return new KdlSyntaxHighlighter();
    }

    @Override
    public @NonNls @NotNull String getDemoText() {
        return "<node>\"parent node\"</node> \"argument\" 123 {\n" +
                "    <node>child</node> <key>a</key>=false <key>b</key>=null <key>\"string\"</key>=(<typeref>type</typeref>)\"string\";\n" +
                "}";
    }

    @Override
    public @Nullable Map<String,TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        Map<String,TextAttributesKey> map = new HashMap<>();
        map.put("key", KdlSyntaxHighlighter.PROPERTY_KEY);
        map.put("typeref", KdlSyntaxHighlighter.TYPE_SPECIFIER);
        map.put("node", KdlSyntaxHighlighter.NODE_NAME);
        return map;
    }


    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @Override
    public @NotNull @NlsContexts.ConfigurableName String getDisplayName() {
        return "Kdl";
    }

    @Override
    public boolean isRainbowType(TextAttributesKey type) {
        return KdlSyntaxHighlighter.NODE_NAME.equals(type) ||
                KdlSyntaxHighlighter.PROPERTY_KEY.equals(type) ||
                KdlSyntaxHighlighter.STRING.equals(type) ||
                KdlSyntaxHighlighter.NUMBER.equals(type) ||
                KdlSyntaxHighlighter.NULL.equals(type) ||
                KdlSyntaxHighlighter.BOOLEAN.equals(type) ||
                KdlSyntaxHighlighter.BRACE.equals(type) ||
                KdlSyntaxHighlighter.PARENTHESES.equals(type);
    }

    @Override
    public @Nullable Language getLanguage() {
        return KdlLanguage.INSTANCE;
    }
}
