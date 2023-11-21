package homework.onlineStore.model;

import homework.onlineStore.model.enums.ProductType;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {

    private String id;
    private String name;
    private String description;
    private int stockQty;
    private double price;
    private ProductType productType;
    private boolean isRemoved = false;

    public Product(String id, String name, String description, int stockQty, double price, ProductType productType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stockQty = stockQty;
        this.price = price;
        this.productType = productType;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved(boolean removed) {
        isRemoved = removed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (stockQty != product.stockQty) return false;
        if (Double.compare(price, product.price) != 0) return false;
        if (isRemoved != product.isRemoved) return false;
        if (!Objects.equals(id, product.id)) return false;
        if (!Objects.equals(name, product.name)) return false;
        if (!Objects.equals(description, product.description)) return false;
        return productType == product.productType;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + stockQty;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 31 * result + (isRemoved ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", stockQty=" + stockQty +
                ", price=" + price +
                ", productType=" + productType +
                '}';
    }
}
