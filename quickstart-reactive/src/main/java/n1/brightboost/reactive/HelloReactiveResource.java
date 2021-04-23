package n1.brightboost.reactive;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.reactive.RestSseElementType;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloreactive")
public class HelloReactiveResource {

    @Inject
    HelloReactiveService helloReactiveService;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{name}")
    public Uni<String> hello(String name) {
        return helloReactiveService.hello(name);
    }


    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @RestSseElementType(MediaType.TEXT_PLAIN)
    @Path("/{name}/{nr}")
    public Multi<String> multiHello(String name, int nr) {
        return helloReactiveService.multiHello(name, nr);
    }
}