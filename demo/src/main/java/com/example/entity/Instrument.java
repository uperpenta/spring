package com.example.entity;

import java.sql.Date;

public class Instrument {
    private int Id;
    private String ISIN;
    private String Currency;
    private String Type;
    private String Description;
    private Date EffectiveDate;
    private String Status;

    public Instrument(int id, String iSIN, String currency, String type, String description, Date effectiveDate,
            String status) {
        Id = id;
        ISIN = iSIN;
        Currency = currency;
        Type = type;
        Description = description;
        EffectiveDate = effectiveDate;
        Status = status;
    }

  

public int getId() {
    return Id;
}

public void setId(int id) {
    Id = id;
}

public String getISIN() {
    return ISIN;
}

public void setISIN(String iSIN) {
    ISIN = iSIN;
}

public String getCurrency() {
    return Currency;
}

public void setCurrency(String currency) {
    Currency = currency;
}

public String getType() {
    return Type;
}

public void setType(String type) {
    Type = type;
}

public String getDescription() {
    return Description;
}

public void setDescription(String description) {
    Description = description;
}

public Date getEffectiveDate() {
    return EffectiveDate;
}

public void setEffectiveDate(Date effectiveDate) {
    EffectiveDate = effectiveDate;
}

public String getStatus() {
    return Status;
}

public void setStatus(String status) {
    Status = status;
}



@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Id;
    result = prime * result + ((ISIN == null) ? 0 : ISIN.hashCode());
    result = prime * result + ((Currency == null) ? 0 : Currency.hashCode());
    result = prime * result + ((Type == null) ? 0 : Type.hashCode());
    result = prime * result + ((Description == null) ? 0 : Description.hashCode());
    result = prime * result + ((EffectiveDate == null) ? 0 : EffectiveDate.hashCode());
    result = prime * result + ((Status == null) ? 0 : Status.hashCode());
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
    Instrument other = (Instrument) obj;
    if (Id != other.Id)
        return false;
    if (ISIN == null) {
        if (other.ISIN != null)
            return false;
    } else if (!ISIN.equals(other.ISIN))
        return false;
    if (Currency == null) {
        if (other.Currency != null)
            return false;
    } else if (!Currency.equals(other.Currency))
        return false;
    if (Type == null) {
        if (other.Type != null)
            return false;
    } else if (!Type.equals(other.Type))
        return false;
    if (Description == null) {
        if (other.Description != null)
            return false;
    } else if (!Description.equals(other.Description))
        return false;
    if (EffectiveDate == null) {
        if (other.EffectiveDate != null)
            return false;
    } else if (!EffectiveDate.equals(other.EffectiveDate))
        return false;
    if (Status == null) {
        if (other.Status != null)
            return false;
    } else if (!Status.equals(other.Status))
        return false;
    return true;
}



@Override
public String toString() {
    return "Instrument [Id=" + Id + ", ISIN=" + ISIN + ", Currency=" + Currency + ", Type=" + Type + ", Description="
            + Description + ", EffectiveDate=" + EffectiveDate + ", Status=" + Status + "]";
}  




}
