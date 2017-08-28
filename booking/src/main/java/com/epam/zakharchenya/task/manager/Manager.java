package com.epam.zakharchenya.task.manager;

import java.util.ResourceBundle;

/**
 * Created by Vadzim_Zakharchenya on 08-Aug-17.
 */
public abstract class Manager {
    protected static ResourceBundle resourceBundle;
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}
