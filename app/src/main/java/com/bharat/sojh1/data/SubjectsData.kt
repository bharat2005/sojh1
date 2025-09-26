package com.bharat.sojh1.data

import com.bharat.sojh1.R
import com.bharat.sojh1.model.Chapter
import com.bharat.sojh1.model.Subject
import com.bharat.sojh1.ui.theme.English
import com.bharat.sojh1.ui.theme.Hindi
import com.bharat.sojh1.ui.theme.Maths
import com.bharat.sojh1.ui.theme.Punjabi
import com.bharat.sojh1.ui.theme.Science
import com.bharat.sojh1.ui.theme.SocialScience

val subjectsDataList = listOf<Subject>(
    Subject(
        subjectTitle = "Mathematics",
        backgroundImageRes = R.drawable.maths,
        subjectId = "maths",
        subjectColor = Maths,
        totalChapter = listOf(
            Chapter("Real Numbers", R.drawable.chapter1),
            Chapter("Polynomials", R.drawable.chapter2),
            Chapter("Pair of Linear Equations in Two Variables", R.drawable.chapter3),
            Chapter("Quadratic Equations", R.drawable.chapter2),
            Chapter("Arithmetic Progressions", R.drawable.chapter1),
            Chapter("Triangles", R.drawable.chapter3),
            Chapter("Coordinate Geometry", R.drawable.chapter1),
            Chapter("Introduction to Trigonometry", R.drawable.chapter2),
            Chapter("Some Applications of Trigonometry", R.drawable.chapter3),
            Chapter("Circles", R.drawable.chapter2),
            Chapter("Constructions", R.drawable.chapter1),
            Chapter("Areas Related to Circles", R.drawable.chapter3),
            Chapter("Surface Areas and Volumes", R.drawable.chapter2),
            Chapter("Statistics", R.drawable.chapter1),
            Chapter("Probability", R.drawable.chapter3)
        )
    ),
    Subject(
        subjectTitle = "Science",
        backgroundImageRes = R.drawable.science,
        subjectId = "science",
        subjectColor = Science,
        totalChapter = listOf(
            Chapter("Chemical Reactions and Equations", R.drawable.chapter3),
            Chapter("Acids, Bases and Salts", R.drawable.chapter1),
            Chapter("Metals and Non-metals", R.drawable.chapter2),
            Chapter("Carbon and Its Compounds", R.drawable.chapter3),
            Chapter("Periodic Classification of Elements", R.drawable.chapter1),
            Chapter("Life Processes", R.drawable.chapter2),
            Chapter("Control and Coordination", R.drawable.chapter3),
            Chapter("How do Organisms Reproduce?", R.drawable.chapter1),
            Chapter("Heredity and Evolution", R.drawable.chapter2),
            Chapter("Light — Reflection and Refraction", R.drawable.chapter3),
            Chapter("The Human Eye and The Colourful World", R.drawable.chapter1),
            Chapter("Electricity", R.drawable.chapter2),
            Chapter("Magnetic Effects of Electric Current", R.drawable.chapter3),
            Chapter("Sources of Energy", R.drawable.chapter1),
            Chapter("Our Environment", R.drawable.chapter2),
            Chapter("Sustainable Management of Natural Resources", R.drawable.chapter3)
        )
    ),
    Subject(
        subjectTitle = "Social Science",
        backgroundImageRes = R.drawable.social_science,
        subjectId = "social_science",
        subjectColor = SocialScience,
        totalChapter = listOf(
            Chapter("India and the Contemporary World – II", R.drawable.chapter1),
            Chapter("Contemporary India – II", R.drawable.chapter3),
            Chapter("Democratic Politics – II", R.drawable.chapter2),
            Chapter("Understanding Economic Development", R.drawable.chapter1)
        )
    ),
    Subject(
        subjectTitle = "English",
        backgroundImageRes = R.drawable.english,
        subjectId = "english",
        subjectColor = English,
        totalChapter = listOf(
            Chapter("The Happy Prince", R.drawable.chapter2),
            Chapter("Where is Science Taking Us?", R.drawable.chapter1),
            Chapter("Secret of Happiness", R.drawable.chapter3),
            Chapter("A Gift for Christmas", R.drawable.chapter2),
            Chapter("Some Glimpses of Ancient Indian Thought and Practices", R.drawable.chapter1),
            Chapter("The Home – Coming", R.drawable.chapter3),
            Chapter("The Making of the Earth", R.drawable.chapter2)
        )
    ),
    Subject(
        subjectTitle = "Punjabi",
        backgroundImageRes = R.drawable.punjabi,
        subjectId = "punjabi",
        subjectColor = Punjabi,
        totalChapter = listOf(
            Chapter("ਪੰਜਾਬੀ ਸਾਹਿਤ ਦਾ ਇਤਿਹਾਸ", R.drawable.chapter3),
            Chapter("ਪੰਜਾਬੀ ਲੋਕ ਸਾਹਿਤ", R.drawable.chapter1),
            Chapter("ਪੰਜਾਬੀ ਨਾਟਕ ਅਤੇ ਸਿਨੇਮਾ", R.drawable.chapter2),
            Chapter("ਪੰਜਾਬੀ ਕਵਿਤਾ", R.drawable.chapter3)
        )
    ),
    Subject(
        subjectTitle = "Hindi",
        backgroundImageRes = R.drawable.hindi,
        subjectId = "hindi",
        subjectColor = Hindi,
        totalChapter = listOf(
            Chapter("हिंदी कविता", R.drawable.chapter1),
            Chapter("हिंदी गद्य", R.drawable.chapter2),
            Chapter("हिंदी निबंध", R.drawable.chapter3),
            Chapter("हिंदी नाटक", R.drawable.chapter1)
        )
    )
)



