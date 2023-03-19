package pers.felix.mybatisdaotraditionnal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Felix Lee
 * @date 2022/5/5 19:33
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private String roleId;
    private String roleName;
    private String roleAddr;
    private String roleLevel;
}