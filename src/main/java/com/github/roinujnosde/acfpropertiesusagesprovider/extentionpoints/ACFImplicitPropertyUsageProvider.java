package com.github.roinujnosde.acfpropertiesusagesprovider.extentionpoints;

import com.intellij.codeInspection.unused.ImplicitPropertyUsageProvider;
import com.intellij.lang.properties.psi.Property;
import org.jetbrains.annotations.NotNull;

public class ACFImplicitPropertyUsageProvider extends ImplicitPropertyUsageProvider {


    @Override
    protected boolean isUsed(@NotNull Property property) {
        String key = property.getKey();
        if (key == null) {
            return false;
        }
        return key.startsWith("command.description") || key.endsWith(".command");
//        Project project = property.getProject();
//        Collection<VirtualFile> files = FilenameIndex.getAllFilesByExt(project, "java");
//        for (VirtualFile file : files) {
//            PsiFile psiFile = PsiManager.getInstance(project).findFile(file);
//            if (psiFile != null) {
//                for (PsiElement child : psiFile.getChildren()) {
//                    if (child.getNode().getElementType().equals(JavaTokenType.STRING_LITERAL)) {
//                        String text = child.getText();
//                        if (text.contains(key)) {
//                            return true;
//                        }
//                    }
//                }
//            }
//        }
//        return false;
    }
}
