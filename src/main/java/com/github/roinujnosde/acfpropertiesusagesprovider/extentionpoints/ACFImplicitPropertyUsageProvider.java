package com.github.roinujnosde.acfpropertiesusagesprovider.extentionpoints;

import com.intellij.codeInspection.unused.ImplicitPropertyUsageProvider;
import com.intellij.lang.properties.psi.Property;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FilenameIndex;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class ACFImplicitPropertyUsageProvider extends ImplicitPropertyUsageProvider {


    @Override
    protected boolean isUsed(@NotNull Property property) {
        Project project = property.getProject();
        Collection<VirtualFile> files = FilenameIndex.getAllFilesByExt(project, "java");
        for (VirtualFile file : files) {
            PsiFile psiFile = PsiManager.getInstance(project).findFile(file);
            if (psiFile != null) {
                for (PsiElement child : psiFile.getChildren()) {
                    String text = child.getText();
                    if (text.contains(project.getName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
