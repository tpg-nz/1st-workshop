package co.nz.mycompany.domain;

import java.math.BigDecimal;

public class Product {
    private String guid;
    private String barCode;
    private String name;
    private String description;
    private BigDecimal price;

    public Product(String guid, String barCode, String name, String description, BigDecimal price) {
        this.guid = guid;
        this.barCode = barCode;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}