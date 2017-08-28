package com.epam.zakharchenya.task.model.manager;

import java.util.ResourceBundle;

public class ConfigurationManager extends Manager{
    public ConfigurationManager() {
        resourceBundle = ResourceBundle.getBundle("properties.config");
    }
}