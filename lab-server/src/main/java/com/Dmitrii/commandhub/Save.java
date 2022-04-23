package com.Dmitrii.commandhub;

import com.Dmitrii.common.parserhub.JsonParser;
import com.Dmitrii.common.parserhub.Parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Save extends Command {

    @Override
    public Object execute(List<Object> args) {
        Parser parser = new JsonParser();
        File file = new File("/Users/ITMO/Downloads/lab5-lab6/lab-server/src/main/java/com/Dmitrii/data.json");
        try {
            parser.writeClasses(file, CommandHandler.getCollection().getCollection());
        } catch (IOException e) {
            return new String("Файла не существует");
        }
        return new String("Коллекция успешно сохранена");
    }
}
