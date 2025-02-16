package com.day6.annotation.exerciseProblems;

// LegacyAPI class
class LegacyAPI {

    // Mark oldFeature() as deprecated, indicating it should not be used
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature. It is deprecated.");
    }

    // New method that should be used instead of oldFeature()
    public void newFeature() {
        System.out.println("This is the new feature.");
    }
}

public class DeprecatedProblem {
    public static void main(String[] args) {
        // Create an instance of LegacyAPI
        LegacyAPI api = new LegacyAPI();

        // Call the oldFeature method (this will show a deprecation warning)
        api.oldFeature();  // Warning: The method oldFeature() from the type LegacyAPI is deprecated

        // Call the newFeature method (this will not show a warning)
        api.newFeature();
    }
}
