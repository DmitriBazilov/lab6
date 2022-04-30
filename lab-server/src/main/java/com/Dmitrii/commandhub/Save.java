package com.Dmitrii.commandhub;

import com.Dmitrii.common.parserhub.JsonParser;
import com.Dmitrii.common.parserhub.Parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Save extends Command {

    public Save(CommandHandler handler, String name, String description) {
        super(handler, name, description);
    }

    @Override
    public Object execute(List<Object> args) {
        Parser parser = new JsonParser();
        File file = new File("/home/dmitrii/Документы/Programming_univer/lab6/lab6/lab-server/src/main/java/com/Dmitrii/data.json");
        try {
            parser.writeClasses(file, getHandler().getCollection().getCollection());
        } catch (IOException e) {
            return new String("Файла не существует");
        }
        return new String("Коллекция успешно сохранена");
    }
}
