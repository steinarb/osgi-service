/*
 * Copyright 2019-2021 Steinar Bang
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
        int id = 42;
        String rolename = "admin";
        String description = "This is an administrator";
        Role bean = Role.with().id(id).rolename(rolename).description(description).build();
        assertEquals(id, bean.getId());
        assertEquals(rolename, bean.getRolename());
        assertEquals(description, bean.getDescription());
    }

    @Test
    void testCopy() {
        int id = 42;
        String rolename = "admin";
        String description = "This is an administrator";
        Role bean = Role.with().id(id).rolename(rolename).description(description).build();
        Role copy = Role.with(bean).build();
        assertEquals(id, copy.getId());
        assertEquals(rolename, copy.getRolename());
        assertEquals(description, copy.getDescription());
    }

    @Test
    void testNoArgsConstructor() {
        int id = -1;
        Role bean = Role.with().build();
        assertEquals(id, bean.getId());
        assertNull(bean.getRolename());
        assertNull(bean.getDescription());
    }

}
