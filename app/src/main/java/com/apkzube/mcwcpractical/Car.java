package com.apkzube.mcwcpractical;

public class Car {
    String carModelName,launchDate,companyName,carColors;
    int carImg;



    public Car(String companyName, String carModelName, int carImg, String carColors,String launchDate) {
        this.carModelName = carModelName;
        this.companyName = companyName;
        this.carImg = carImg;
        this.carColors=carColors;
        this.carModelName = carModelName;
        this.launchDate=launchDate;

    }


    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCarImg() {
        return carImg;
    }

    public void setCarImg(int carImg) {
        this.carImg = carImg;
    }

    public String getCarColors() {
        return carColors;
    }

    public void setCarColors(String carColors) {
        this.carColors = carColors;
    }

}
