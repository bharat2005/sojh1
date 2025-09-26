package com.bharat.sojh1.features.subject.navigation

object SubjectRoutes {
    const val SUBJECT_GRAPH = "subject_graph"
    const val SUBJECT_SCREEN = "subject_screen/{subjectId}"

    fun createRoute(subjectId: String) = "subject_screen/$subjectId"

    const val BOOKMARK_SCREEN = "bookmark_screen"
}