package com.food.foodies.responseclasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestaurantsResponse {

    @SerializedName("businesses")
    @Expose
    private List<Business> businesses = null;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("region")
    @Expose
    private Region region;

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public static class Business {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("alias")
        @Expose
        private String alias;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("image_url")
        @Expose
        private String imageUrl;
        @SerializedName("is_closed")
        @Expose
        private Boolean isClosed;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("review_count")
        @Expose
        private Integer reviewCount;
        @SerializedName("categories")
        @Expose
        private List<Category> categories = null;
        @SerializedName("rating")
        @Expose
        private Double rating;
        @SerializedName("coordinates")
        @Expose
        private Coordinates coordinates;
        @SerializedName("transactions")
        @Expose
        private List<Object> transactions = null;
        @SerializedName("price")
        @Expose
        private String price;
        @SerializedName("location")
        @Expose
        private Location location;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("display_phone")
        @Expose
        private String displayPhone;
        @SerializedName("distance")
        @Expose
        private Double distance;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Boolean getIsClosed() {
            return isClosed;
        }

        public void setIsClosed(Boolean isClosed) {
            this.isClosed = isClosed;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getReviewCount() {
            return reviewCount;
        }

        public void setReviewCount(Integer reviewCount) {
            this.reviewCount = reviewCount;
        }

        public List<Category> getCategories() {
            return categories;
        }

        public void setCategories(List<Category> categories) {
            this.categories = categories;
        }

        public Double getRating() {
            return rating;
        }

        public void setRating(Double rating) {
            this.rating = rating;
        }

        public Coordinates getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(Coordinates coordinates) {
            this.coordinates = coordinates;
        }

        public List<Object> getTransactions() {
            return transactions;
        }

        public void setTransactions(List<Object> transactions) {
            this.transactions = transactions;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getDisplayPhone() {
            return displayPhone;
        }

        public void setDisplayPhone(String displayPhone) {
            this.displayPhone = displayPhone;
        }

        public Double getDistance() {
            return distance;
        }

        public void setDistance(Double distance) {
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Business{" +
                    "id='" + id + '\'' +
                    ", alias='" + alias + '\'' +
                    ", name='" + name + '\'' +
                    ", imageUrl='" + imageUrl + '\'' +
                    ", isClosed=" + isClosed +
                    ", url='" + url + '\'' +
                    ", reviewCount=" + reviewCount +
                    ", categories=" + categories +
                    ", rating=" + rating +
                    ", coordinates=" + coordinates +
                    ", transactions=" + transactions +
                    ", price='" + price + '\'' +
                    ", location=" + location +
                    ", phone='" + phone + '\'' +
                    ", displayPhone='" + displayPhone + '\'' +
                    ", distance=" + distance +
                    '}';
        }
    }

    public static class Region {
        @SerializedName("center")
        @Expose
        private Center center;

        public Center getCenter() {
            return center;
        }

        public void setCenter(Center center) {
            this.center = center;
        }

        @Override
        public String toString() {
            return "Region{" +
                    "center=" + center +
                    '}';
        }
    }

    public static class Center {
        @SerializedName("longitude")
        @Expose
        private Double longitude;
        @SerializedName("latitude")
        @Expose
        private Double latitude;

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }
    }

    public static class Coordinates {
        @SerializedName("latitude")
        @Expose
        private Double latitude;
        @SerializedName("longitude")
        @Expose
        private Double longitude;

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        @Override
        public String toString() {
            return "Coordinates{" +
                    "latitude=" + latitude +
                    ", longitude=" + longitude +
                    '}';
        }
    }

    public static class Location {
        @SerializedName("address1")
        @Expose
        private String address1;
        @SerializedName("address2")
        @Expose
        private String address2;
        @SerializedName("address3")
        @Expose
        private String address3;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("zip_code")
        @Expose
        private String zipCode;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("display_address")
        @Expose
        private List<String> displayAddress = null;

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getAddress3() {
            return address3;
        }

        public void setAddress3(String address3) {
            this.address3 = address3;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public List<String> getDisplayAddress() {
            return displayAddress;
        }

        public void setDisplayAddress(List<String> displayAddress) {
            this.displayAddress = displayAddress;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "address1='" + address1 + '\'' +
                    ", address2='" + address2 + '\'' +
                    ", address3='" + address3 + '\'' +
                    ", city='" + city + '\'' +
                    ", zipCode='" + zipCode + '\'' +
                    ", country='" + country + '\'' +
                    ", state='" + state + '\'' +
                    ", displayAddress=" + displayAddress +
                    '}';
        }
    }
    public static class Category {

        @SerializedName("alias")
        @Expose
        private String alias;
        @SerializedName("title")
        @Expose
        private String title;

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "Category{" +
                    "alias='" + alias + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "RestaurantsResponse{" +
                "businesses=" + businesses +
                ", total=" + total +
                ", region=" + region +
                '}';
    }
}


