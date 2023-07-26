package com.example.entity;

public class Issuer {
    private int Id;
    private long LEI;
    private String LegalName;
    private String Description;

public Issuer(int id, long lEI, String legalName, String description) {
    Id = id;
    LEI = lEI;
    LegalName = legalName;
    Description = description;
}

public int getId() {
    return Id;
}

public void setId(int id) {
    Id = id;
}

public long getLEI() {
    return LEI;
}

public void setLEI(long lEI) {
    LEI = lEI;
}

public String getLegalName() {
    return LegalName;
}

public void setLegalName(String legalName) {
    LegalName = legalName;
}

public String getDescription() {
    return Description;
}

public void setDescription(String description) {
    Description = description;
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Id;
    result = prime * result + (int) (LEI ^ (LEI >>> 32));
    result = prime * result + ((LegalName == null) ? 0 : LegalName.hashCode());
    result = prime * result + ((Description == null) ? 0 : Description.hashCode());
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
    Issuer other = (Issuer) obj;
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
    return true;
}

@Override
public String toString() {
    return "Issuer [Id=" + Id + ", LEI=" + LEI + ", LegalName=" + LegalName + ", Description=" + Description + "]";
}
    


}
