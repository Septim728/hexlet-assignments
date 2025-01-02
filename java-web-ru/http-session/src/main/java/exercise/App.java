package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import org.eclipse.jetty.server.Authentication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();
    private static  int page;
    private static int per;

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

       app.get("/users", ctx -> {
          page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
          per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);

          var offset = (page - 1) * per;
          List<Map<String, String>> sliceOfUsers = USERS.subList(offset, offset + per);
          ctx.json(sliceOfUsers);
       });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
