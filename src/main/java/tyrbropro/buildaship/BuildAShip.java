package tyrbropro.buildaship;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.bukkit.plugin.java.JavaPlugin;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tyrbropro.buildaship.mysql.PlayerService;
import tyrbropro.buildaship.register.CommandService;
import tyrbropro.buildaship.register.CommandServiceImpl;
import tyrbropro.buildaship.register.ListenerService;
import tyrbropro.buildaship.register.ListenerServiceImpl;

@FieldDefaults(level = AccessLevel.PRIVATE)
public final class BuildAShip extends JavaPlugin {

    static BuildAShip plugin;

    //    static ConfigurableApplicationContext context;
    static ClassPathXmlApplicationContext context;
    PlayerService playerService;

    @Override
    public void onEnable() {
        System.out.println("TTEEEEEEEEEEEEEEESTTTEEEEEEEEEEEEEEESTTTEEEEEEEEEEEEEEESTTTEEEEEEEEEEEEEEESTTTEEEEEEEEEEEEEEEST");
        plugin = this;
        System.out.println("TTEEEEEEEEEEEEEEESTTTEEEEEEEEEEEEEEESTTTEEEEEEEEEEEEEEESTTTEEEEEEEEEEEEEEESTTTEEEEEEEEEEEEEEEST");

//        context = new AnnotationConfigApplicationContext(MyConfig.class);
        context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("TTEEEEEEEEEEEEEEESTTTEEEEEEEEEEEEEEESTTTEEEEEEEEEEEEEEESTTTEEEEEEEEEEEEEEESTTTEEEEEEEEEEEEEEEST");

        playerService = context.getBean(PlayerService.class);
        System.out.println("TTEEEEEEEEEEEEEEESTTTEEEEEEEEEEEEEEESTTTEEEEEEEEEEEEEEESTTTEEEEEEEEEEEEEEESTTTEEEEEEEEEEEEEEEST");

        if (playerService == null) {
            System.out.println("PlayerService is not initialized correctly");
        } else {
            System.out.println("PlayerService is successfully initialized");
        }

        ListenerService listenerService = context.getBean(ListenerServiceImpl.class);
        listenerService.scanPackages(this.getClass().getPackage().getName());

        CommandService commandService = context.getBean(CommandServiceImpl.class);
        commandService.scanPackage(this.getClass().getPackage().getName());
    }

    @Override
    public void onDisable() {

        if (playerService != null) {
            playerService.saveAllPlayers();
        }

        if (context != null) {
            context.close();
        }
    }

    public static BuildAShip getPlugin() {
        return plugin;
    }

    public static ConfigurableApplicationContext getContext() {
        return context;
    }
}
