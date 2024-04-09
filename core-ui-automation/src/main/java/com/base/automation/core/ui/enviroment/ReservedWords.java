package com.base.automation.core.ui.enviroment;

enum ReservedWords {
    ENVIRONMENT_PATH("src/test/resources/Environment.json");

    private final String word;

    /**
     * Initializes Reserved Words enum.
     *
     * @param word original word.
     */
    ReservedWords(final String word) {
        this.word = word;
    }

    /**
     * Gets the enum word value.
     *
     * @return original word.
     */
    public String val() {
        return word;
    }
}
