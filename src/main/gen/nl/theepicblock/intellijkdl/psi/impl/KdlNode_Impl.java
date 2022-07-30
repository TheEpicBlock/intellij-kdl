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

public class KdlNode_Impl extends ASTWrapperPsiElement implements KdlNode_ {

  public KdlNode_Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KdlVisitor visitor) {
    visitor.visitNode_(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KdlVisitor) accept((KdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public KdlIdentifier getIdentifier() {
    return findNotNullChildByClass(KdlIdentifier.class);
  }

  @Override
  @Nullable
  public KdlNodeChildren getNodeChildren() {
    return findChildByClass(KdlNodeChildren.class);
  }

  @Override
  @NotNull
  public List<KdlNodePropOrArg> getNodePropOrArgList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KdlNodePropOrArg.class);
  }

  @Override
  @NotNull
  public List<KdlNodeSpace> getNodeSpaceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KdlNodeSpace.class);
  }

  @Override
  @NotNull
  public KdlNodeTerminator getNodeTerminator() {
    return findNotNullChildByClass(KdlNodeTerminator.class);
  }

  @Override
  @Nullable
  public KdlType getType() {
    return findChildByClass(KdlType.class);
  }

  @Override
  @NotNull
  public List<KdlWs> getWsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KdlWs.class);
  }

}
