package com.epam.zakharchenya.task.entity;

import java.util.Locale;

/** Entity class, serves for processing relative object Visitor from database.
 * @author Vadim Zakharchenya
 * @version 1.0
 */
public class Visitor {

    private Locale locale;
    private String currentPage;

    public Visitor() {
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

}
