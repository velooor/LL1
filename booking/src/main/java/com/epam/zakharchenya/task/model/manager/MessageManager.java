package com.epam.zakharchenya.task.model.manager;

import java.util.ResourceBundle;

public class MessageManager extends Manager {
    private MessageManager() {
        resourceBundle = ResourceBundle.getBundle("properties.messages");
    }


}
