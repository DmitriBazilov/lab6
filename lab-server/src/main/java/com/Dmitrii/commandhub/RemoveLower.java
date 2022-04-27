package com.Dmitrii.commandhub;

import com.Dmitrii.common.networkhub.Response;
import com.Dmitrii.common.worker.Worker;

import java.util.List;

public class RemoveLower extends Command {

    public RemoveLower(String name, String description) {
        super(name, description);
    }

    @Override
    public Object execute(List<Object> args) {
        Worker worker = (Worker) args.get(0);
        int result = CommandHandler.getCollection().removeLower(worker);
        return new Response("Из коллекции удалено " + result + " рабов");
    }
}
