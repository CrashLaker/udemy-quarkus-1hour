package n1.brighboost;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("shoppingList")
@Consumes("application/json")
@Produces("application/json")
@Transactional
public class ShoppingListResource {

    @Inject
    private ShoppingListDAO shoppingListDAO;

    // get
    @GET
    @Path("{id}")
    public ShoppingListItem getShoppingListItem(@PathParam("id") Integer id){
       return shoppingListDAO.getShoppingListItem(id);
    }

    // post
    @POST
    public Response postShoppingListItem(@QueryParam("itemName") String itemName, @QueryParam("amount") int amount){
        shoppingListDAO.storeShoppingListItem(itemName, amount);
        return Response.ok().build();
    }

    // put
    @PUT
    public Response putShoppingListItem(@QueryParam("id") Integer id,
                                        @QueryParam("itemName") String itemName,
                                        @QueryParam("amount") int amount){
        if (id != null){
            shoppingListDAO.updateShoppingListItem(id, itemName, amount);
        }
        shoppingListDAO.storeShoppingListItem(itemName, amount);
        return Response.ok().build();
    }

    // patch
    @PATCH
    public Response patchShoppingListItem(@QueryParam("id") Integer id,
                                          @QueryParam("itemName") String itemName,
                                          @QueryParam("amount") int amount){
        if (id != null){
            shoppingListDAO.updateShoppingListItem(id, itemName, amount);
            return Response.ok().build();
        }
        return Response.notModified().build();
    }

    // delete
    @DELETE
    @Path("{id}")
    public Response deleteShoppingListItem(@PathParam("id") Integer id){
        boolean deleteSuccess = shoppingListDAO.deleteShoppingListItem(id);
        return deleteSuccess ? Response.ok().build() : Response.notModified().build();
    }

}
