package com.krydb.model;

public class UrlPO {
    private long ident;
    private String address;
    private String created;
    private String status;
    private String updated;

    public UrlPO(long ident, String address, String created, String status, String updated) {
        this.ident = ident;
        this.address = address;
        this.created = created;
        this.status = status;
        this.updated = updated;
    }

    public long getIdent() {
        return this.ident;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCreated() {
        return this.created;
    }

    public String getStatus() {
        return this.status;
    }

    public String getUpdated() {
        return this.updated;
    }

    public String getString() {
        return String.format("%d,%s,%s,%s,%s", this.getIdent(), this.getAddress(), this.getCreated(), this.getStatus(), this.getUpdated());
    }
}
