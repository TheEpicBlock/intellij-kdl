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

public class KdlNodePropOrArgImpl extends ASTWrapperPsiElement implements KdlNodePropOrArg {

  public KdlNodePropOrArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KdlVisitor visitor) {
    visitor.visitNodePropOrArg(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KdlVisitor) accept((KdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<KdlNodeSpace> getNodeSpaceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KdlNodeSpace.class);
  }

  @Override
  @Nullable
  public KdlProp getProp() {
    return findChildByClass(KdlProp.class);
  }

  @Override
  @Nullable
  public KdlValue getValue() {
    return findChildByClass(KdlValue.class);
  }

}
