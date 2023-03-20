package pers.felix.mybatisdaoproxy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Felix Lee
 * @date 2022/5/22 14:17
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
    private String roleCategory;
}

