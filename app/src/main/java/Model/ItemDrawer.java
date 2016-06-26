package Model;

/**
 * Created by Yasmeen Siam on 25/06/2016.
 */
public class ItemDrawer {
    private String ItemName;
    private int Icon;
    private int Nam_Item;

    public ItemDrawer(String itemName, int icon, int nam_Item) {
        ItemName = itemName;
        Icon = icon;
        Nam_Item = nam_Item;
    }

    public String getItemName() {
        return ItemName;
    }

    public int getIcon() {
        return Icon;
    }

    public int getNam_Item() {
        return Nam_Item;
    }
}
