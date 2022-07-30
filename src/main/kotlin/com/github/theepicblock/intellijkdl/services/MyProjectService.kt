package com.github.theepicblock.intellijkdl.services

import com.intellij.openapi.project.Project
import com.github.theepicblock.intellijkdl.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
