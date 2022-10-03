/*
 * Copyright 2022 Steinar Bang
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

class UsersExceptionTest {

    @Test
    void testCreateWithException() {
        String message = "Caught exception";
        NullPointerException inner = new NullPointerException();
        var exception = new UsersException(message, inner);
        assertEquals(message, exception.getMessage());
        assertEquals(inner, exception.getCause());
    }

    @Test
    void testCreateWithMessage() {
        String message = "Caught exception";
        var exception = new UsersException(message);
        assertEquals(message, exception.getMessage());
    }

}
