package n1.brighboost;


import javax.persistence.*;

@Entity
@Table(name="SHOPPING_LIST_ITEMS")
public class ShoppingListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "Amount")
    private int amount;

    public ShoppingListItem() {
    }

    public ShoppingListItem(String itemName, int amount) {
        this.itemName = itemName;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
