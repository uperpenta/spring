package com.example.entity;

public class Member {
    private int Id;
    private long LEI;
    private String LegalName;
    private String Description;
    private String Adress;
    
    public Member(int id, long lEI, String legalName, String description, String adress) {
        Id = id;
        LEI = lEI;
        LegalName = legalName;
        Description = description;
        Adress = adress;
    }

    public int getId() {
        return Id;
    }

    public long getLEI() {
        return LEI;
    }

    public String getLegalName() {
        return LegalName;
    }

    public String getDescription() {
        return Description;
    }

    public String getAdress() {
        return Adress;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setLEI(long lEI) {
        LEI = lEI;
    }

    public void setLegalName(String legalName) {
        LegalName = legalName;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Id;
        result = prime * result + (int) (LEI ^ (LEI >>> 32));
        result = prime * result + ((LegalName == null) ? 0 : LegalName.hashCode());
        result = prime * result + ((Description == null) ? 0 : Description.hashCode());
        result = prime * result + ((Adress == null) ? 0 : Adress.hashCode());
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
        Member other = (Member) obj;
        if (Id != other.Id)
            return false;
        if (LEI != other.LEI)
            return false;
        if (LegalName == null) {
            if (other.LegalName != null)
                return false;
        } else if (!LegalName.equals(other.LegalName))
            return false;
        if (Description == null) {
            if (other.Description != null)
                return false;
        } else if (!Description.equals(other.Description))
            return false;
        if (Adress == null) {
            if (other.Adress != null)
                return false;
        } else if (!Adress.equals(other.Adress))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Member [Id=" + Id + ", LEI=" + LEI + ", LegalName=" + LegalName + ", Description=" + Description
                + ", Adress=" + Adress + "]";
    }

    
    
}
