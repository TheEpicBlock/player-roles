package dev.gegy.roles;

import dev.gegy.roles.override.RoleOverrideMap;

public final class Role implements Comparable<Role> {
    public static final String EVERYONE = "everyone";

    private final String name;
    private final RoleOverrideMap overrides;
    private int level;

    Role(String name, RoleOverrideMap overrides, int level) {
        this.name = name;
        this.overrides = overrides;
        this.level = level;
    }

    public static Role empty(String name) {
        return new Role(name, new RoleOverrideMap(), 0);
    }

    public String getName() {
        return this.name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public RoleOverrideMap getOverrides() {
        return this.overrides;
    }

    @Override
    public int compareTo(Role role) {
        return Integer.compare(role.level, this.level);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;

        if (obj instanceof Role) {
            Role role = (Role) obj;
            return role.name.equalsIgnoreCase(this.name);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return "\"" + this.name + "\" (" + this.level + ")";
    }
}
