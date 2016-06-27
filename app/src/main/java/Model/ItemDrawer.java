package Model;

/**
 * Created by Yasmeen Siam on 25/06/2016.
 */
public class ItemDrawer {
    private String ItemName;
    private int Num_Item;

    public ItemDrawer(String itemName, int nam_Item) {
        ItemName = itemName;
        Num_Item = nam_Item;
    }

    public String getItemName() {
        return ItemName;
    }

    public int getNum_Item() {
        return Num_Item;
    }
}
