package com.base.automation.core.ui.webdrivers;

public interface StrategyGetter<T>{
    /**
     * Performs step and return generic value.
     *
     * @return generic type.
     */
    T performStep();
}
