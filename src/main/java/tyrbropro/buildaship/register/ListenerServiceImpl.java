package tyrbropro.buildaship.register;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.reflections.Reflections;
import org.springframework.stereotype.Service;
import tyrbropro.buildaship.BuildAShip;

@Service
public class ListenerServiceImpl implements ListenerService {

    @Override
    public void scanPackages(String packageName) {
        new Reflections(packageName)
                .getSubTypesOf(Listener.class)
                .forEach(clazz -> {
                    try {
                        Listener listener = BuildAShip.getContext().getBean(clazz);
                        System.out.println(listener + " KAK TO TAK");
                        this.registerListener(listener);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    @Override
    public void registerListener(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, BuildAShip.getPlugin());
    }
}
