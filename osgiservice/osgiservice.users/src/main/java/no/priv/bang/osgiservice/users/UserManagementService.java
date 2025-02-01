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

import java.util.List;
import java.util.Map;

/**
 * This is an OSGi service that encapsulates user management
 *
 * Implementations of this interface will typically be used to
 * manage users, groups and roles for a software application.
 *
 * The structure of this interface is based on what's convenient
 * for the implementation of a REST API: JSON-friendly beans are
 * both arguments and return values, and update operations returns
 * updated state in a form that is convenient for e.g. updating
 * a redux model in a react/redux frontend.
 */
public interface UserManagementService {

    /**
     * Get a User from a username.
     *
     * Typically called after login to get a {@link User} object
     * for the logged in user
     *
     * @param username the username for the user that is to be retrieved
     * @return a {@link User} object for the user with the username
     */
    User getUser(String username);

    /**
     * Typically called after login to get the list of {@link Role}s for
     * the logged in user
     *
     * @param username the username for the user whose roles should be retrieved
     * @return a list of {@link Role} objects
     */
    List<Role> getRolesForUser(String username);

    /**
     * Typically called after login to get the list of all {@link Permission}s for
     * the logged in user.
     *
     * @param username the username for the user whose permissions should be retrieved
     * @return a list of {@link Permission} objects
     */
    List<Permission> getPermissionsForUser(String username);

    /**
     * Get all users in the database.
     *
     * @return a list of {@link User} objects
     */
    List<User> getUsers();

    /**
     * Update a user in the database.
     * What can be updated, are the username, the email address
     * and the first- and lastnames of the user.
     *
     * @param user The user object to update.  The id property of this object defines what user to update
     * @return The list of users in the database after the update of a user
     */
    List<User> modifyUser(User user);

    /**
     * Change the passwords of a user in the database
     *
     * @param userAndPasswords an object containing a {@link User} used to identify the user the passwords should be changed for and two copies of the new password
     * @return The list of users in the database
     */
    List<User> updatePassword(UserAndPasswords userAndPasswords);

    /**
     * Create a new user in the database.
     *
     * @param newUserWithPasswords an object containing a {@link User} object and two copies of the new password
     * @return The list of users in the database including the newly created user
     */
    List<User> addUser(UserAndPasswords newUserWithPasswords);

    /**
     * Register a failed login for a given username in the database
     *
     * @param username to register a failed login for
     * @return a User object with the numberOfFailedLogins incremented by one
     */
    User loginFailed(String username);

    /**
     * Register a successful login for a User in the database.  The numberOfFailedLogins will be set to 0.
     *
     * @param username to register a successful login for
     * @return a User object with numberOfFailedLogins set to 0
     */
    User successfulLogin(String username);

    /**
     * Set the number of failed logins that will lock the User's account. Default is 3.
     *
     * @param limit the number of failed logins that should lock the account
     * @return the value of number of failed logins to lock the account read back from the database
     */
    int setExcessiveFailedLoginLimit(int limit);

    /**
     * Unlock a locked account for a given username
     *
     * @param username for the account that should be unlocked
     * @return a User object with isLocked set to false and numberOfFailedAccounts set to 0
     */
    List<User> unlockUser(String username);

    /**
     * Check if user account is locked
     *
     * @param username for user to check
     * @return true if user account is locked and false if user account isn't locked
     */
    boolean userIsLocked(String username);

    /**
     * Return the list of roles defined in the database.
     *
     * @return a list of {@link Role} beans
     */
    List<Role> getRoles();

    /**
     * Modify a {@link Role} in the database.
     *
     * @param role the {@link Role} to modify in the database
     * @return the roles in the database containing the modified role
     */
    List<Role> modifyRole(Role role);

    /**
     * Add a {@link Role} to the database.
     *
     * @param newRole the {@link Role} to add
     * @return the roles in the database, including the new role
     */
    List<Role> addRole(Role newRole);

    /**
     * Return the list of roles defined in the database.
     *
     * @return a {@link Permission} objekts
     */
    List<Permission> getPermissions();

    /**
     * Modify a {@link Permission} in the database.
     *
     * @param permission the {@link Permission} object to modify in the database
     * @return the permissions in the database containing the modified permission
     */
    List<Permission> modifyPermission(Permission permission);

    /**
     * Add a {@link Permission} to the database.
     *
     * @param newPermission the {@link Permission} to add to the database
     * @return the permissions in the database including the new permission
     */
    List<Permission> addPermission(Permission newPermission);

    /**
     * Get all {@link User#username()} to {@link Role} mappings in the database.
     *
     * @return a {@link Map} from usernames to lists of roles
     */
    Map<String, List<Role>> getUserRoles();

    /**
     * Add one or more roles to a user.
     *
     * @param userroles contains the {@link User} to add {@link Role}s and the roles to add
     * @return the all username to role mappings with the new roles in place
     */
    Map<String, List<Role>> addUserRoles(UserRoles userroles);

    /**
     * Remove one or more roles from a user
     *
     * @param userroles the {@link User} to remove {@link Role}s from and the roles to remove
     * @return the all username to role mappings with the removed roles gone
     */
    Map<String, List<Role>> removeUserRoles(UserRoles userroles);

    /**
     * Get all role to permission mappings in the database.
     *
     * @return a map from rolenames to list of permissions
     */
    Map<String, List<Permission>> getRolesPermissions();

    /**
     * Add one or more permissions to a role.
     *
     * @param rolepermissions the {@link Role} to add permissions to and the list of {@link Permission}s to add to the role
     * @return all rolename to permission mappings in the database, including the permissions added in this operation
     */
    Map<String, List<Permission>> addRolePermissions(RolePermissions rolepermissions);

    /**
     * Remove one or more permissions from a role.
     *
     * @param rolepermissions the {@link Role} to remove permissions from and the list of {@link Permission}s to remove from the role
     * @return all rolename to permission mappings in the database, not including the permissions removed in this operation
     */
    Map<String, List<Permission>> removeRolePermissions(RolePermissions rolepermissions);

}
