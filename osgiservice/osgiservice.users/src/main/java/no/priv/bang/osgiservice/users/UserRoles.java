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

import java.util.List;

public record UserRoles(User user, List<Role> roles) {

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private User user;
        private List<Role> roles;

        private Builder() {}

        public UserRoles build() {
            return new UserRoles(this.user, this.roles);
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder roles(List<Role> roles) {
            this.roles = roles;
            return this;
        }
    }
}
