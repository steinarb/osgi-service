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

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class UserRolesTest {

    @Test
    void testCreate() {
        var userid = 42;
        var username = "jdoe";
        var email = "jdoe31@gmail.com";
        var firstname = "John";
        var lastname = "Doe";
        var user = User.with()
            .userid(userid)
            .username(username)
            .email(email)
            .firstname(firstname)
            .lastname(lastname)
            .build();
        var id = 42;
        var rolename = "admin";
        var description = "This is an administrator";
        var role = Role.with().id(id).rolename(rolename).description(description).build();
        var roles = Arrays.asList(role);
        var userroles = UserRoles.with().user(user).roles(roles).build();

        assertEquals(user, userroles.user());
        assertEquals(role, userroles.roles().get(0));
    }

    @Test
    void testNoargsConstructor() {
        var userroles = UserRoles.with().build();

        assertNull(userroles.user());
        assertNull(userroles.roles());
    }

}
