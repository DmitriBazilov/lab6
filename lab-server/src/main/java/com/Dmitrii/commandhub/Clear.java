package com.Dmitrii.commandhub;

import com.Dmitrii.common.networkhub.Response;

import java.util.List;

public class Clear extends Command {

    public Clear(String name, String description) {
        super(name, description);
    }

    @Override
    public Object execute(List<Object> args) {
        return CommandHandler.getCollection().clear() == 1 ? new Response("Коллекция успешно очищена") : new Response("Ошибка при очистке коллекции");
    }
}
