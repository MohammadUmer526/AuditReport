package com.example.auditreport;

public class NCList {

    private String nc_summ = "";
    private String type = "";
    private String owner = "";

    public void setNc_summ(String nc_Summ) {
        this.nc_summ = nc_Summ;
    }

    public String getNc_summ() {
        return nc_summ;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }
}
