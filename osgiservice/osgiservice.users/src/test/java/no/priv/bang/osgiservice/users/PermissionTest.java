/*
 * Copyright 2019-2024 Steinar Bang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations
 * under the License.
 */
package no.priv.bang.osgiservice.users;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PermissionTest {

    @Test
    void testCreate() {
        var id = 365;
        var permissionname = "user_admin_write";
        var description = "Allow updating user data";
        var bean = Permission.with()
            .id(id)
            .permissionname(permissionname)
            .description(description)
            .build();
        assertEquals(id, bean.id());
        assertEquals(permissionname, bean.permissionname());
        assertEquals(description, bean.description());
    }

    @Test
    void testCopy() {
        var id = 365;
        var permissionname = "user_admin_write";
        var description = "Allow updating user data";
        var bean = Permission.with()
            .id(id)
            .permissionname(permissionname)
            .description(description)
            .build();
        var copy = Permission.with(bean).build();
        assertEquals(id, copy.id());
        assertEquals(permissionname, copy.permissionname());
        assertEquals(description, copy.description());
    }

    @Test
    void testNoArgsConstructor() {
        var id = -1;
        var bean = Permission.with().build();
        assertEquals(id, bean.id());
        assertNull(bean.permissionname());
        assertNull(bean.description());
    }

}
