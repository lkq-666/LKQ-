package com.lkq.lkqcrm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptRole extends BaseEntity{
    private Integer deptId;
    private Integer roleId;
}
