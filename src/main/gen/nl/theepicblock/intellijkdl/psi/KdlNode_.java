// This is a generated file. Not intended for manual editing.
package nl.theepicblock.intellijkdl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KdlNode_ extends PsiElement {

  @NotNull
  KdlIdentifier getIdentifier();

  @Nullable
  KdlNodeChildren getNodeChildren();

  @NotNull
  List<KdlNodePropOrArg> getNodePropOrArgList();

  @NotNull
  List<KdlNodeSpace> getNodeSpaceList();

  @NotNull
  KdlNodeTerminator getNodeTerminator();

  @Nullable
  KdlType getType();

  @NotNull
  List<KdlWs> getWsList();

}
