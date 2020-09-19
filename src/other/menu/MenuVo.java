package other.menu;

import java.util.List;

/**
 * 菜品的vo类
 */
public class MenuVo {
    private Long id;
    private Long parentId;
    private String name;
    private List<Menu> childList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Menu> getChildList() {
        return childList;
    }

    public void setChildList(List<Menu> childList) {
        this.childList = childList;
    }

    /**
     * 构建menuList的关系
     *
     * @param menuList 原始的menuList
     * @return
     */
    public static List<MenuVo> buildTree(List<Menu> menuList) {
        for (Menu item : menuList) {
             Long parentId = item.getParentId();
//             if()
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
