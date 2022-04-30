package com.Dmitrii.commandhub;

import com.Dmitrii.common.networkhub.Response;
import com.Dmitrii.common.worker.Worker;

import java.util.Collection;
import java.util.List;

public class Show extends Command {

    public Show(CommandHandler handler, String name, String description) {
        super(handler, name, description);
    }

    @Override
    public Object execute(List<Object> args) {
        String workers = getHandler().getCollection().show();
        return new Response(workers.isEmpty() ? "Коллекция пуста" : workers);
    }
}
