package com.cmplxsoftsys.team3.financeapplication.modeltests;

import static org.assertj.core.api.Assertions.assertThat;

import com.cmplxsoftsys.team3.financeapplication.model.ERole;
import com.cmplxsoftsys.team3.financeapplication.model.Role;

import org.junit.jupiter.api.Test;

public class RoleTests {

    private ERole testRole = ERole.ROLE_MODERATOR;
    
    
    @Test
    public void objectCanBeInstantiated() {
        Role testInstance = new Role(testRole);
        assertThat(testInstance).isNotNull();
    }


    @Test
    public void roleAttributesCanCorrectlyBeRetrievedViaGets() throws Exception {
        Role testInstance = new Role(testRole);
        assertThat(testInstance.getName()).isEqualTo(testRole);
    }
 
    
    @Test
    public void roleAttributesCanCorrectlyBeChangedViaSets() throws Exception {
        Role testInstance = new Role(testRole);
        testInstance.setName(ERole.ROLE_USER);
        assertThat(testInstance.getName()).isNotEqualTo(testRole);
    }
}
