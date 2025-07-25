/*
 * Copyright 2025 Steinar Bang
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

public record UserManagementConfig(int excessiveFailedLoginLimit) {

    public static Builder with() {
        return new Builder();
    }

    public static Builder with(UserManagementConfig config) {
        var builder = new Builder();
        builder.excessiveFailedLoginLimit = config.excessiveFailedLoginLimit();
        return builder;
    }

    public static class Builder {

        private int excessiveFailedLoginLimit;

        public Builder excessiveFailedLoginLimit(int excessiveFailedLoginLimit) {
            this.excessiveFailedLoginLimit = excessiveFailedLoginLimit;
            return this;
        }

        public UserManagementConfig build() {
            return new UserManagementConfig(excessiveFailedLoginLimit);
        }

    }

}
