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

class RoleTest {

    @Test
    void testCreate() {
        var id = 42;
        var rolename = "admin";
        var description = "This is an administrator";
        var bean = Role.with().id(id).rolename(rolename).description(description).build();
        assertEquals(id, bean.getId());
        assertEquals(rolename, bean.getRolename());
        assertEquals(description, bean.getDescription());
    }

    @Test
    void testCopy() {
        var id = 42;
        var rolename = "admin";
        var description = "This is an administrator";
        var bean = Role.with().id(id).rolename(rolename).description(description).build();
        var copy = Role.with(bean).build();
        assertEquals(id, copy.getId());
        assertEquals(rolename, copy.getRolename());
        assertEquals(description, copy.getDescription());
    }

    @Test
    void testNoArgsConstructor() {
        var id = -1;
        var bean = Role.with().build();
        assertEquals(id, bean.getId());
        assertNull(bean.getRolename());
        assertNull(bean.getDescription());
    }

}
