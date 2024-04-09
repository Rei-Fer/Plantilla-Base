package com.base.automation.core.ui.browsers;

public interface Browser<T> {
    /**
     * Gets a Web Driver instance of a specific browser.
     *
     * @return Web Driver instance.
     */
    T getDriver();
}
