package com.Dmitrii.commandhub;

import com.Dmitrii.common.networkhub.Response;
import com.Dmitrii.common.worker.Coordinates;

import java.util.List;

public class RemoveLowerKey extends Command {

    public RemoveLowerKey(CommandHandler handler, String name, String description) {
        super(handler, name, description);
    }

    @Override
    public Object execute(List<Object> args) {
        Coordinates key = (Coordinates) args.get(0);
        return new Response("Из коллекции удалено" + getHandler().getCollection().removeLowerKey(key) + " рабов");
    }
}
