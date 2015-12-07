package com.shopping.app.shared.onlineshopping;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import com.shopping.app.shared.EntityAudit;
import javax.persistence.Embedded;
import com.shopping.app.shared.SystemInfo;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_Cart_T")
@Entity
@NamedQueries({ @javax.persistence.NamedQuery(name = "Cart.DefaultFinders", query = "select e from Cart e where e.systemInfo.activeStatus=1 and e.itemId LIKE :itemId and e.itemName LIKE :itemName and e.itemPrice BETWEEN :minitemPrice AND :maxitemPrice and e.itemQuantity BETWEEN :minitemQuantity AND :maxitemQuantity and e.subTotal BETWEEN :minsubTotal AND :maxsubTotal"), @javax.persistence.NamedQuery(name = "Cart.findByItemId", query = "select e from Cart e where e.systemInfo.activeStatus=1 and e.itemId=:itemId"), @javax.persistence.NamedQuery(name = "Cart.findByUserId", query = "select e from Cart e where e.systemInfo.activeStatus=1 and e.userId=:userId"), @javax.persistence.NamedQuery(name = "Cart.findById", query = "select e from Cart e where e.systemInfo.activeStatus=1 and e.cartId =:cartId") })
public class Cart implements Serializable, CommonEntityInterface, Comparator<Cart> {

    @Column(name = "itemName")
    @JsonProperty("itemName")
    @Size(min = 0, max = 256)
    private String itemName;

    @Column(name = "itemPrice")
    @JsonProperty("itemPrice")
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double itemPrice;

    @Column(name = "itemQuantity")
    @JsonProperty("itemQuantity")
    @NotNull
    @Min(-2147483648L)
    @Max(2147483647)
    private Integer itemQuantity;

    @Column(name = "subTotal")
    @JsonProperty("subTotal")
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double subTotal;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "cartId")
    @JsonProperty("cartId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String cartId;

    @Column(name = "itemId")
    @JsonProperty("itemId")
    private String itemId;

    @Column(name = "userId")
    @JsonProperty("userId")
    private String userId;

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> entityValidator;

    @Version
    @Column(name = "versionId")
    @JsonProperty("versionId")
    private int versionId;

    @Embedded
    @JsonIgnore
    private EntityAudit entityAudit = new EntityAudit();

    @Embedded
    private SystemInfo systemInfo = new SystemInfo();

    @Transient
    private String primaryDisplay;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String _itemName) {
        this.itemName = _itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double _itemPrice) {
        this.itemPrice = _itemPrice;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer _itemQuantity) {
        if (_itemQuantity != null) {
            this.itemQuantity = _itemQuantity;
        }
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double _subTotal) {
        this.subTotal = _subTotal;
    }

    public String getPrimaryKey() {
        return cartId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return cartId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String _cartId) {
        this.cartId = _cartId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String _itemId) {
        this.itemId = _itemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String _userId) {
        this.userId = _userId;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int _versionId) {
        this.versionId = _versionId;
    }

    public void setPrimaryDisplay(String _primaryDisplay) {
        this.primaryDisplay = _primaryDisplay;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo _systemInfo) {
        this.systemInfo = _systemInfo;
    }

    @JsonIgnore
    public boolean isHardDelete() {
        if (this.systemInfo == null) {
            this.systemInfo = new SystemInfo();
        }
        if (this.systemInfo.getActiveStatus() == -1) {
            return true;
        } else {
            return false;
        }
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SpartanConstraintViolationException, SpartanIncorrectDataException {
        boolean isValid = false;
        if (this.entityValidator != null) {
            isValid = this.entityValidator.validateEntity(this);
        } else {
            throw new SpartanIncorrectDataException("Entity validator is not set");
        }
        return isValid;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.entityValidator = _validateFactory;
    }

    @Override
    public void setEntityAudit(int customerId, String userId, RECORD_TYPE recordType) {
        System.out.println("Setting logged in user info for " + recordType);
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (recordType == RECORD_TYPE.ADD) {
            this.entityAudit.setCreatedBy(userId);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
        setSystemInformation(recordType);
    }

    @Override
    public void setEntityAudit(int customerId, String userId) {
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (getPrimaryKey() == null) {
            this.entityAudit.setCreatedBy(userId);
            this.systemInfo.setActiveStatus(1);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
    }

    @JsonIgnore
    public String getLoggedInUserInfo() {
        String auditInfo = "";
        if (this.entityAudit != null) {
            auditInfo = entityAudit.toString();
        }
        return auditInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemInformation(RECORD_TYPE recordType) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        if (recordType == RECORD_TYPE.DELETE) {
            this.systemInfo.setActiveStatus(0);
        } else {
            this.systemInfo.setActiveStatus(1);
        }
    }

    @JsonIgnore
    public void setSystemInformation(Integer activeStatus) {
        this.systemInfo.setActiveStatus(activeStatus);
    }

    @JsonIgnore
    public String getSystemInformation() {
        String systemInfo = "";
        if (this.systemInfo != null) {
            systemInfo = systemInfo.toString();
        }
        return systemInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemTxnCode(Integer transactionAccessCode) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        this.systemInfo.setTxnAccessCode(transactionAccessCode);
    }

    @Override
    public int compare(Cart object1, Cart object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (cartId == null) {
            return super.hashCode();
        } else {
            return cartId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.shopping.app.shared.onlineshopping.Cart other = (com.shopping.app.shared.onlineshopping.Cart) obj;
            if (cartId == null) {
                return false;
            } else if (!cartId.equals(other.cartId)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }
}
