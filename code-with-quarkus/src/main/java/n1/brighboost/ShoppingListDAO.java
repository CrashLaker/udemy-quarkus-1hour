package n1.brighboost;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class ShoppingListDAO {

    @Inject
    private EntityManager entityManager;

    public ShoppingListItem getShoppingListItem(Integer id){
        return entityManager.find(ShoppingListItem.class, id);
    }

    public void storeShoppingListItem(String itemName, int amount){
        ShoppingListItem sli = new ShoppingListItem(itemName, amount);
        entityManager.persist(sli);
    }

    public void replaceShoppingListItem(Integer id, String itemName, int amount){
        ShoppingListItem sli = entityManager.find(ShoppingListItem.class, id);
        sli.setItemName(itemName);
        sli.setAmount(amount);
        entityManager.persist(sli);
    }

    public void updateShoppingListItem(Integer id, String itemName, Integer amount){
        ShoppingListItem sli = entityManager.find(ShoppingListItem.class, id);
        if (amount != null && sli.getAmount() != amount){
            sli.setAmount(amount);
        }
        if (itemName != null && !sli.getItemName().equals(itemName)){
            sli.setItemName(itemName);
        }
        entityManager.persist(sli);
    }

    public boolean deleteShoppingListItem(Integer id){
        ShoppingListItem sli = entityManager.find(ShoppingListItem.class, id);
        if (sli == null){
            return false;
        }
        entityManager.remove(sli);
        return true;
    }
}
