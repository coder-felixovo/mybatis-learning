package pers.felix.mybatisfirst;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@author Felix Lee
 *@date 2023-03-19 19:57:19
 *@description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private String roleId;
    private String roleName;
    private String roleAddr;
    private String roleLevel;
    private String roleCategory;
}
