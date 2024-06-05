package br.com.ramengo.api.view.model;

public class OrderRequest {

    private Integer brothId;
    private Integer proteinId;

    public Integer getBrothId() {
        return brothId;
    }
    public void setBrothId(Integer brothId) {
        this.brothId = brothId;
    }
    public Integer getProteinId() {
        return proteinId;
    }
    public void setProteinId(Integer proteinId) {
        this.proteinId = proteinId;
    }
}
