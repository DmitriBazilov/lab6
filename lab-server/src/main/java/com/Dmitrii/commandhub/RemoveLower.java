package com.Dmitrii.commandhub;

import com.Dmitrii.common.networkhub.Response;
import com.Dmitrii.common.worker.Worker;

import java.util.List;

public class RemoveLower extends Command {

    public RemoveLower(CommandHandler handler, String name, String description) {
        super(handler, name, description);
    }

    @Override
    public Object execute(List<Object> args) {
        Worker worker = (Worker) args.get(0);
        int result = getHandler().getCollection().removeLower(worker);
        return new Response("Из коллекции удалено " + result + " рабов");
    }
}
