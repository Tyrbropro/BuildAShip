package tyrbropro.buildaship.register;

import org.bukkit.command.CommandExecutor;

public interface CommandService {
    void scanPackage(String packageName);

    void registerCommand(CommandExecutor command);
}
