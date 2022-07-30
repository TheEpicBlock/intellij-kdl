package nl.theepicblock.intellijkdl.services

import com.intellij.openapi.project.Project
import nl.theepicblock.intellijkdl.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
