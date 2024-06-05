package br.com.ramengo.api.shared;

public class BrothsDTO {

    private Long id;
    private String imageInactive;
    private String imageActive;
    private String name;
    private String description;
    private Double price;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImageInactive() {
        return imageInactive;
    }
    public void setImageInactive(String imageInactive) {
        this.imageInactive = imageInactive;
    }
    public String getImageActive() {
        return imageActive;
    }
    public void setImageActive(String imageActive) {
        this.imageActive = imageActive;
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
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

}
