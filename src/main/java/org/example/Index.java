package org.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.metrics.annotation.Counted;

@ApplicationScoped
@Path("index")
public class Index {

    @GET
    @Produces({MediaType.TEXT_HTML})
    @Counted(name = "Counters.HTTP_REQUESTS",
            tags = {"Labels.RESOURCE_USERINPUT", "Labels.ACTION_SELECT"},
            absolute = true,
            description = "Counters.HTTP_REQUESTS_DESCRIPTION")
    public Response requestForSMSNumber(
            @QueryParam("tid") String tid) {

        return Response.ok("<html>HELLO</html>", MediaType.TEXT_HTML_TYPE).build();
    }
}