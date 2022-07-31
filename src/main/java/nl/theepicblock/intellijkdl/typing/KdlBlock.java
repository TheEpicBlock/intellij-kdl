package nl.theepicblock.intellijkdl.typing;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import nl.theepicblock.intellijkdl.psi.KdlNodeChildren;
import nl.theepicblock.intellijkdl.psi.KdlNode_;
import nl.theepicblock.intellijkdl.psi.KdlNodes;
import nl.theepicblock.intellijkdl.psi.KdlTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class KdlBlock extends AbstractBlock {
    private final SpacingBuilder spacingBuilder;
    private final Indent indent;

    protected KdlBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment, SpacingBuilder spacingBuilder, Indent indent) {
        super(node, wrap, alignment);
        this.spacingBuilder = spacingBuilder;
        this.indent = indent;
    }

    @Override
    protected List<Block> buildChildren() {
        List<Block> blocks = new ArrayList<>();
        ASTNode child = myNode.getFirstChildNode();
        while (child != null) {
//            if (child.getElementType() != KdlTypes.LINESPACE && child.getElementType() != KdlTypes.NODE_SPACE) {
                blocks.add(makeSubBlock(child));
//            }
            child = child.getTreeNext();
        }
        return blocks;
    }

    private Block makeSubBlock(@NotNull ASTNode childNode) {
        Indent indent = Indent.getNoneIndent();
        if (this instanceof KdlNodeChildren) {
            if (childNode instanceof KdlNodes) {
                indent = Indent.getNormalIndent();
            }
        }

        return new KdlBlock(childNode, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(),
                spacingBuilder, indent);
    }

    @Override
    public @Nullable Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return spacingBuilder.getSpacing(this, child1, child2);
    }

    @Override
    public Indent getIndent() {
        return this.indent;
    }

    @Override
    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }
}
