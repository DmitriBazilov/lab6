package com.Dmitrii.commandhub;

import com.Dmitrii.common.parserhub.JsonParser;
import com.Dmitrii.common.parserhub.Parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Save extends Command {

    public Save(String name, String description) {
        super(name, description);
    }

    @Override
    public Object execute(List<Object> args) {
        Parser parser = new JsonParser();
        File file = new File("C:\\Users\\R355-w-9-stud\\Downloads\\Новая папка\\lab6-main\\lab6-main\\lab-server\\src\\main\\java\\com\\Dmitrii\\data.json");
        try {
            parser.writeClasses(file, CommandHandler.getCollection().getCollection());
        } catch (IOException e) {
            return new String("Файла не существует");
        }
        return new String("Коллекция успешно сохранена");
    }
}
