package n1.brightboost.reactive;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;

@ApplicationScoped
public class HelloReactiveService {
    public Uni<String> hello(String name) {
        return Uni.createFrom().item(name).onItem().transform(s -> "hello " + s);
    }

    public Multi<String> multiHello(String name, int nr) {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(3)).onItem().transform(n -> "hello " + name + n).select().first(nr);
    }
}
