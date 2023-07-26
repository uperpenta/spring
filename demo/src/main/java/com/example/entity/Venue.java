package com.example.entity;

public class Venue {
    private int Id;
    private String Name;
    private String City;
    private String Country;
    
    public Venue(int id, String name, String city, String country) {
        Id = id;
        Name = name;
        City = city;
        Country = country;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Id;
        result = prime * result + ((Name == null) ? 0 : Name.hashCode());
        result = prime * result + ((City == null) ? 0 : City.hashCode());
        result = prime * result + ((Country == null) ? 0 : Country.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Venue other = (Venue) obj;
        if (Id != other.Id)
            return false;
        if (Name == null) {
            if (other.Name != null)
                return false;
        } else if (!Name.equals(other.Name))
            return false;
        if (City == null) {
            if (other.City != null)
                return false;
        } else if (!City.equals(other.City))
            return false;
        if (Country == null) {
            if (other.Country != null)
                return false;
        } else if (!Country.equals(other.Country))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Venue [Id=" + Id + ", Name=" + Name + ", City=" + City + ", Country=" + Country + "]";
    }

    
    

}
