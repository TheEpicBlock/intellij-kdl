// This is a generated file. Not intended for manual editing.
package nl.theepicblock.intellijkdl.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static nl.theepicblock.intellijkdl.psi.KdlTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import nl.theepicblock.intellijkdl.psi.*;

public class KdlNodesImpl extends ASTWrapperPsiElement implements KdlNodes {

  public KdlNodesImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KdlVisitor visitor) {
    visitor.visitNodes(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KdlVisitor) accept((KdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<KdlLinespace> getLinespaceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KdlLinespace.class);
  }

  @Override
  @NotNull
  public List<KdlNode_> getNode_List() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KdlNode_.class);
  }

}
