package urfu.core.commands.init;

public class DefaultCommand implements ICommand {
  final int minArgs;

  public DefaultCommand(int minArgs) {
    this.minArgs = minArgs;
  }

  public final int getMinArgs() {
    return this.minArgs;
  }

  public final void safeArgsExecute(String[] args) {
    String commandName = args[0];

    if (args.length - 1 < this.minArgs) {
      System.out.printf(
          "Команде %s требуется минимум %d аргумент(-а)\n", commandName, getMinArgs());
      System.out.printf("Для получения справки используйте: help %s\n\n", commandName);

      return;
    }

    this.execute(args);
  }

  public void execute(String[] args) {
    System.out.printf("Вызван метод execute() класса %s\n", this.getClass().getSimpleName());
  }

  public String getUsageFormat() {
    return "exampleCommand [args]";
  }

  public String getInfo() {
    StringBuilder sb = new StringBuilder();

    sb.append("\n").append("Описание команды").append("\n");

    return sb.toString();
  }
}
