package urfu.core.commands;

import urfu.core.commands.init.CommandInitializer;
import urfu.core.commands.init.ICommand;

import java.util.LinkedHashMap;

public class HelpCommand implements ICommand
{
    @Override
    public void execute(String[] args)
    {
        LinkedHashMap<String, ICommand> COMMANDS = CommandInitializer.getAvailableCommands();

        if (args.length != 2 || !COMMANDS.containsKey(args[1])) {
            for (ICommand command : COMMANDS.values()) {
                System.out.println("> " + command.getUsageFormat() + command.getInfo());
            }

            return;
        }

        ICommand selectedCommand = COMMANDS.get(args[1]);

        System.out.println("> " + selectedCommand.getUsageFormat() + selectedCommand.getInfo());
    }

    @Override
    public String getUsageFormat()
    {
        return "help [command]";
    }

    @Override
    public String getInfo()
    {

        return """
                                
                Выводит информацию обо всех доступных командах
                При использовании опционального ввода конкретной команды
                можно получить информацию о ней
                """;
    }
}
