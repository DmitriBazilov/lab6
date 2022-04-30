package com.Dmitrii.commandhub;

import com.Dmitrii.common.networkhub.Response;
import com.Dmitrii.common.worker.Worker;

import java.util.List;

public class UpdateId extends Command {

    public UpdateId(CommandHandler handler, String name, String description) {
        super(handler, name, description);
    }

    @Override
    public Object execute(List<Object> args) {
        Integer workerId = (Integer) args.get(0);
        Worker worker = (Worker) args.get(1);
        worker.setId(workerId);
        short returnCode = getHandler().getCollection().updateId(workerId, worker);
        return returnCode == 1 ? new Response("Рабочий успешно заменен") : new Response("Рабочего с таким Id не сущетсвует");
    }
}
