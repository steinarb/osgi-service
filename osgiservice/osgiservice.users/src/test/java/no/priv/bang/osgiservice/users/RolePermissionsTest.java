package no.priv.bang.osgiservice.users;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class RolePermissionsTest {

    @Test
    void testCreate() {
        var role = Role.with().id(42).rolename("admin").description("Adminstrate stuff").build();
        var permissions = Arrays.asList(Permission.with().id(36).permissionname("adminapiwrite").description("PUT and POST and DELETE to the admin REST API").build());
        var bean = RolePermissions.with().role(role).permissions(permissions).build();
        assertEquals(role, bean.getRole());
        assertEquals(permissions.get(0), bean.getPermissions().get(0));
    }

    @Test
    void testNoargsConstructor() {
        var bean = RolePermissions.with().build();
        assertNull(bean.getRole());
        assertNull(bean.getPermissions());
    }

}
