package com.zminder.wms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private Integer id;
    private String menuCode;
    private String menuName;
    private String menuLevel;
    private String menuParentCode;
    private String menuIndex;
    private String menuRight;//记录允许查看当前菜单的最低权限（roleId最大）
    private String menuIcon;
    private String menuComponent;
}
