package com.Dmitrii.commandhub;

import com.Dmitrii.common.networkhub.Response;
import com.Dmitrii.common.worker.Worker;

import java.util.Collection;
import java.util.List;

public class Show extends Command {

    @Override
    public Object execute(List<Object> args) {
        Collection<Worker> collection = CommandHandler.getCollection().getCollection().values();
        String message = "";
        for (Worker w : collection) {
            message += w.toString();
            message += System.lineSeparator();
        }
        return new Response(message);
    }
}
