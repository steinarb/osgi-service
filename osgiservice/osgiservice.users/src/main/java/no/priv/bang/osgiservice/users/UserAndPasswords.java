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

/**
 * Bean used in password related {@link UserManagementService} operations.
 * This bean contains a {@link User} object as well as two string objects
 * holding two copies of a password.
 */
public record UserAndPasswords(User user, String password1, String password2, boolean passwordsNotIdentical) {

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private User user;
        private String password1;
        private String password2;
        private boolean passwordsNotIdentical;

        private Builder() {}

        public UserAndPasswords build() {
            return new UserAndPasswords(this.user, this.password1, this.password2, this.passwordsNotIdentical);
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder password1(String password1) {
            this.password1 = password1;
            return this;
        }

        public Builder password2(String password2) {
            this.password2 = password2;
            return this;
        }

        public Builder passwordsNotIdentical(boolean passwordsNotIdentical) {
            this.passwordsNotIdentical = passwordsNotIdentical;
            return this;
        }
    }

}
