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

import no.priv.bang.beans.immutable.Immutable;

/**
 * Bean used to in {@link UserManagementService} operations to represent a user in the database.
 */
public class User extends Immutable { // NOSONAR Immutable handles added fields

    private int userid;
    private String username;
    private String email;
    private String firstname;
    private String lastname;

    private User() {}

    public int getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public static Builder with() {
        return new Builder();
    }

    public static Builder with(User user) {
        var builder = new Builder();
        builder.userid = user.userid;
        builder.username = user.username;
        builder.email = user.email;
        builder.firstname = user.firstname;
        builder.lastname = user.lastname;
        return builder;
    }

    public static class Builder {
        private int userid = -1;
        private String username;
        private String email;
        private String firstname;
        private String lastname;

        private Builder() {}

        public User build() {
            var user = new User();
            user.userid = this.userid;
            user.username = this.username;
            user.email = this.email;
            user.firstname = this.firstname;
            user.lastname = this.lastname;
            return user;
        }

        public Builder userid(int userid) {
            this.userid = userid;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }
    }
}
