package com.example.mmanoghna.juicebergserver.Model;

/**
 * Created by m.manoghna on 1/18/2018.
 */

public class Food {
    private String Name, Price, MenuId,Description,Discount,Image;

    public Food() {
    }

    public Food(String name, String price, String menuId, String description, String discount, String image) {
        Name= name;
        Price= price;
        MenuId = menuId;
        Description = description;
        Discount = discount;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}