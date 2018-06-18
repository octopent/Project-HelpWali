package mayanksghrathore.example.com.myhelpwali;

public class ListItemModel {

    private String picture_url;
    private String name;
    private String area;
    private String category1,category2;
    private String language1,language2;
    private String description;
    private String salary;
    private String rating;

    public ListItemModel(String picture_url, String name, String area, String category1, String category2, String language1, String language2, String description, String salary, String rating) {
        this.picture_url = picture_url;
        this.name = name;
        this.area = area;
        this.category1 = category1;
        this.category2 = category2;
        this.language1 = language1;
        this.language2 = language2;
        this.description = description;
        this.salary = salary;
        this.rating = rating;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getLanguage1() {
        return language1;
    }

    public void setLanguage1(String language1) {
        this.language1 = language1;
    }

    public String getLanguage2() {
        return language2;
    }

    public void setLanguage2(String language2) {
        this.language2 = language2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

//    private String head, desc, imageUrl , price, category;
//
//    public ListItemModel(String head, String desc, String imageUrl, String price, String Category) {
//        this.head = head;
//        this.desc = desc;
//        this.imageUrl = imageUrl;
//        this.price = price;
//        this.category = category;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public String getHead() {
//        return head;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setHead(String head) {
//        this.head = head;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
//        this.price = price;
//    }
}

