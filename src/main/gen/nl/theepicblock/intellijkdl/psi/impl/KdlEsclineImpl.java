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

public class KdlEsclineImpl extends ASTWrapperPsiElement implements KdlEscline {

  public KdlEsclineImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KdlVisitor visitor) {
    visitor.visitEscline(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KdlVisitor) accept((KdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<KdlWs> getWsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KdlWs.class);
  }

}
