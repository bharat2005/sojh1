package com.bharat.sojh1.data

import com.bharat.sojh1.model.OnboardingItem
import com.bharat.sojh1.R

val onBoardingItems = listOf<OnboardingItem>(
    OnboardingItem(
        R.drawable.auth,
        "Secure Login and Profile",
        "Create your profile and securely log in to access personalized learning content tailored to your pace and language."
    ),
    OnboardingItem(
        R.drawable.video,
        "Learn Through Interactive Videos",
        "Access structured lessons, offline notes, practice tests, and customizable video settings to study anytime, even without internet."
    ),
    OnboardingItem(
        R.drawable.progress,
        "Track Your Learning Progress",
        "Monitor completed lessons, practice results, and test scores to stay motivated and understand your growth over time."
    ),
    OnboardingItem(
        R.drawable.ai,
        "AI Learning Assistant",
        "Get instant help with lessons and practice through our AI assistant, available anytime to clarify doubts and guide learning."
    ),
    OnboardingItem(
        R.drawable.community,
        "Community Peer Support",
        "Connect with peers in Q&A forums, ask questions, and collaborate to solve problems together, making learning more interactive."
    ),

)