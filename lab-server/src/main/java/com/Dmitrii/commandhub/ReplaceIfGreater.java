package com.Dmitrii.commandhub;

import com.Dmitrii.common.networkhub.Response;
import com.Dmitrii.common.worker.Worker;

import java.util.List;

public class ReplaceIfGreater extends Command {

    public ReplaceIfGreater(CommandHandler handler, String name, String description) {
        super(handler, name, description);
    }

    @Override
    public Object execute(List<Object> args) {
        Worker worker = (Worker) args.get(0);
        short returnCode = getHandler().getCollection().replaceIfGreater(worker);
        return returnCode <= 0 ? (returnCode == -1 ? new Response("Нет раба по заданному ключу") : new Response("Новый раб меньше заданного")) : new Response("Замена произошла успешно");
    }
}
