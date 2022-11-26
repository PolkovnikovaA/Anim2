package com.example.anim;

import android.os.Parcel;
import android.os.Parcelable;

public class MaskK implements Parcelable {

    private int ID;
    private String Breed;
    private String Country;
    private String Image;
    private String Lifespan;
    private String Size;
    private String Weight;
    private String Wool_type;
    private String Lifestyle;
    private String Growth;
    private String Origin;
    private String Character;
    private String Health;
    private String Care;
    private String Price;

    protected MaskK(Parcel in) {
        ID = in.readInt();
        Breed = in.readString();
        Country = in.readString();
        Image = in.readString();
        Lifespan = in.readString();
        Size = in.readString();
        Weight = in.readString();
        Wool_type = in.readString();
        Lifestyle = in.readString();
        Growth = in.readString();
        Origin = in.readString();
        Character = in.readString();
        Health = in.readString();
        Care = in.readString();
        Price = in.readString();
    }

    public static final Creator<MaskK> CREATOR = new Creator<MaskK>() {
        @Override
        public MaskK createFromParcel(Parcel in) {
            return new MaskK(in);
        }

        @Override
        public MaskK[] newArray(int size) {
            return new MaskK[size];
        }
    };

    public MaskK(int ID, String breed, String country, String image, String lifespan,
                 String size, String weight, String wool_type, String lifestyle,
                 String growth, String origin, String character, String health, String care,
                 String price) {
        this.ID = ID;
        Breed = breed;
        Country = country;
        Image = image;
        Lifespan = lifespan;
        Size = size;
        Weight = weight;
        Wool_type = wool_type;
        Lifestyle = lifestyle;
        Growth = growth;
        Origin = origin;
        Character = character;
        Health = health;
        Care = care;
        Price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(ID);
        parcel.writeString(Breed);
        parcel.writeString(Country);
        parcel.writeString(Image);
        parcel.writeString(Lifespan);
        parcel.writeString(Size);
        parcel.writeString(Weight);
        parcel.writeString(Wool_type);
        parcel.writeString(Lifestyle);
        parcel.writeString(Growth);
        parcel.writeString(Origin);
        parcel.writeString(Character);
        parcel.writeString(Health);
        parcel.writeString(Care);
        parcel.writeString(Price);
    }

    public int getID() {
        return ID;
    }

    public String getBreed() {
        return Breed;
    }

    public String getCountry() {
        return Country;
    }

    public String getImage() {
        return Image;
    }

    public String getLifespan() {
        return Lifespan;
    }

    public String getSize() {
        return Size;
    }

    public String getWeight() {
        return Weight;
    }

    public String getWool_type() {
        return Wool_type;
    }

    public String getLifestyle() {
        return Lifestyle;
    }

    public String getGrowth() {
        return Growth;
    }

    public String getOrigin() {
        return Origin;
    }

    public String getCharacter() {
        return Character;
    }

    public String getHealth() {
        return Health;
    }

    public String getCare() {
        return Care;
    }

    public String getPrice() {
        return Price;
    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public void setBreed(String breed) {
        Breed = breed;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setLifespan(String lifespan) {
        Lifespan = lifespan;
    }

    public void setSize(String size) {
        Size = size;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public void setWool_type(String wool_type) {
        Wool_type = wool_type;
    }

    public void setLifestyle(String lifestyle) {
        Lifestyle = lifestyle;
    }

    public void setGrowth(String growth) {
        Growth = growth;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public void setCharacter(String character) {
        Character = character;
    }

    public void setHealth(String health) {
        Health = health;
    }

    public void setCare(String care) {
        Care = care;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
