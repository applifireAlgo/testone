package com.shopping.app.shared.shoppingcontext.onlineshopping;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemTemplate {

    @Min(0)
    @Max(65535)
    private String itemId;

    @Min(0)
    @Max(65535)
    private String itemName;

    @Min(0)
    @Max(65535)
    private String itemIcon;

    @Min(0)
    @Max(65535)
    private String itemPrice;

    @Min(-2147483648L)
    @Max(2147483647)
    private Integer itemQuantity;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String _itemId) {
        this.itemId = _itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String _itemName) {
        this.itemName = _itemName;
    }

    public String getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(String _itemIcon) {
        this.itemIcon = _itemIcon;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String _itemPrice) {
        this.itemPrice = _itemPrice;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer _itemQuantity) {
        this.itemQuantity = _itemQuantity;
    }
}
