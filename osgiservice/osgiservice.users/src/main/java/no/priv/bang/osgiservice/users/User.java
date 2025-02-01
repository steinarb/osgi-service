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

/**
 * Bean used to in {@link UserManagementService} operations to represent a user in the database.
 */
public record User (
    int userid,
    String username,
    String email,
    String firstname,
    String lastname,
    int numberOfFailedLogins,
    boolean isLocked)
{

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
        builder.numberOfFailedLogins = user.numberOfFailedLogins;
        builder.isLocked = user.isLocked;
        return builder;
    }

    public static class Builder {
        private int userid = -1;
        private String username;
        private String email;
        private String firstname;
        private String lastname;
        private int numberOfFailedLogins;
        private boolean isLocked;

        private Builder() {}

        public User build() {
            return new User(userid, username, email, firstname, lastname, numberOfFailedLogins, isLocked);
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

        public Builder numberOfFailedLogins(int failedLogins) {
            this.numberOfFailedLogins = failedLogins;
            return this;
        }

        public Builder isLocked(boolean isLocked) {
            this.isLocked = isLocked;
            return this;
        }
    }
}
