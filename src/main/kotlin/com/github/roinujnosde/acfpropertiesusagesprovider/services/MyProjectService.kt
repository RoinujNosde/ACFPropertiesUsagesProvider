package com.github.roinujnosde.acfpropertiesusagesprovider.services

import com.intellij.openapi.project.Project
import com.github.roinujnosde.acfpropertiesusagesprovider.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
