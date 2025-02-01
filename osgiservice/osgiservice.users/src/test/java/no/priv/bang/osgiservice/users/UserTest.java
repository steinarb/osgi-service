/*
 * Copyright 2019-2025 Steinar Bang
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

class UserTest {

    @Test
    void testCreate() {
        var userid = 42;
        var username = "jdoe";
        var email = "jdoe31@gmail.com";
        var firstname = "John";
        var lastname = "Doe";
        var numberOfFailedLogins = 4;
        var isLocked = true;
        var user = User.with()
            .userid(userid)
            .username(username)
            .email(email)
            .firstname(firstname)
            .lastname(lastname)
            .numberOfFailedLogins(numberOfFailedLogins)
            .isLocked(isLocked)
            .build();
        assertEquals(userid, user.userid());
        assertEquals(username, user.username());
        assertEquals(email, user.email());
        assertEquals(firstname, user.firstname());
        assertEquals(lastname, user.lastname());
        assertEquals(numberOfFailedLogins, user.numberOfFailedLogins());
        assertEquals(isLocked, user.isLocked());
    }

    @Test
    void testCopy() {
        var userid = 42;
        var username = "jdoe";
        var email = "jdoe31@gmail.com";
        var firstname = "John";
        var lastname = "Doe";
        var numberOfFailedLogins = 4;
        var isLocked = true;
        var user = User.with()
            .userid(userid)
            .username(username)
            .email(email)
            .firstname(firstname)
            .lastname(lastname)
            .numberOfFailedLogins(numberOfFailedLogins)
            .isLocked(isLocked)
            .build();
        var copy = User.with(user).build();
        assertEquals(userid, copy.userid());
        assertEquals(username, copy.username());
        assertEquals(email, copy.email());
        assertEquals(firstname, copy.firstname());
        assertEquals(lastname, copy.lastname());
        assertEquals(numberOfFailedLogins, copy.numberOfFailedLogins());
        assertEquals(isLocked, copy.isLocked());
    }

    @Test
    void testCreateNoargs() {
        var user = User.with().build();
        assertEquals(-1, user.userid());
        assertNull(user.username());
        assertNull(user.email());
        assertNull(user.firstname());
        assertNull(user.lastname());
        assertEquals(0, user.numberOfFailedLogins());
        assertEquals(false, user.isLocked());
    }

}
