package com.example.shoppingcart.Model;

public class ProductCollection {

    private String Category, CurrencyCode, DateOfSale,Description,DimUnit,MainCategory,Name,ProductId,ProductPicUrl,Status,SupplierName,TaxTarifCode,UoM,WeightUnit;

    private long Depth,Height,Price,Quantity,WeightMeasure,Width;

    public ProductCollection() {

    }

    public ProductCollection(String category, String currencyCode, String dateOfSale, String description, String dimUnit, String mainCategory, String name, String productId, String productPicUrl, String status, String supplierName, String taxTarifCode, String uoM, String weightUnit, long depth, long height, long price, long quantity, long weightMeasure, long width) {
        Category = category;
        CurrencyCode = currencyCode;
        DateOfSale = dateOfSale;
        Description = description;
        DimUnit = dimUnit;
        MainCategory = mainCategory;
        Name = name;
        ProductId = productId;
        ProductPicUrl = productPicUrl;
        Status = status;
        SupplierName = supplierName;
        TaxTarifCode = taxTarifCode;
        UoM = uoM;
        WeightUnit = weightUnit;
        Depth = depth;
        Height = height;
        Price = price;
        Quantity = quantity;
        WeightMeasure = weightMeasure;
        Width = width;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getCurrencyCode() {
        return CurrencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        CurrencyCode = currencyCode;
    }

    public String getDateOfSale() {
        return DateOfSale;
    }

    public void setDateOfSale(String dateOfSale) {
        DateOfSale = dateOfSale;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDimUnit() {
        return DimUnit;
    }

    public void setDimUnit(String dimUnit) {
        DimUnit = dimUnit;
    }

    public String getMainCategory() {
        return MainCategory;
    }

    public void setMainCategory(String mainCategory) {
        MainCategory = mainCategory;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductPicUrl() {
        return ProductPicUrl;
    }

    public void setProductPicUrl(String productPicUrl) {
        ProductPicUrl = productPicUrl;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getTaxTarifCode() {
        return TaxTarifCode;
    }

    public void setTaxTarifCode(String taxTarifCode) {
        TaxTarifCode = taxTarifCode;
    }

    public String getUoM() {
        return UoM;
    }

    public void setUoM(String uoM) {
        UoM = uoM;
    }

    public String getWeightUnit() {
        return WeightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        WeightUnit = weightUnit;
    }

    public long getDepth() {
        return Depth;
    }

    public void setDepth(long depth) {
        Depth = depth;
    }

    public long getHeight() {
        return Height;
    }

    public void setHeight(long height) {
        Height = height;
    }

    public long getPrice() {
        return Price;
    }

    public void setPrice(long price) {
        Price = price;
    }

    public long getQuantity() {
        return Quantity;
    }

    public void setQuantity(long quantity) {
        Quantity = quantity;
    }

    public long getWeightMeasure() {
        return WeightMeasure;
    }

    public void setWeightMeasure(long weightMeasure) {
        WeightMeasure = weightMeasure;
    }

    public long getWidth() {
        return Width;
    }

    public void setWidth(long width) {
        Width = width;
    }
}

