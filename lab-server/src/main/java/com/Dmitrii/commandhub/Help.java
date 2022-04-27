package com.Dmitrii.commandhub;

import com.Dmitrii.common.networkhub.Response;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Help extends Command{

    public Help(String name, String description) {
        super(name, description);
    }

    @Override
    public Object execute(List<Object> args) {
        Map<String, Command> commands = CommandHandler.getCommands();
        Collection<Command> c = commands.values();
        StringBuilder responseMessage = new StringBuilder();
        for (Command command : c) {
            responseMessage.append(command.getName())
                    .append(": ")
                    .append(command.getDescription())
                    .append(System.lineSeparator());
        }
        return new Response(responseMessage.toString());
    }
}
