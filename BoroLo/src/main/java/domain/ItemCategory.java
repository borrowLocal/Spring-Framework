package domain;

public class ItemCategory {
    private Integer category_id;
    private String category_name;
    private String sort;

    public Integer getCategory_id() { return category_id; }
    public void setCategory_id(Integer category_id) { this.category_id = category_id; }

    public String getCategory_name() { return category_name; }
    public void setCategory_name(String category_name) { this.category_name = category_name; }

    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}