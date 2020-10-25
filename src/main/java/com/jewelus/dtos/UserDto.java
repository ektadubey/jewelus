package com.jewelus.dtos;

import lombok.Data;

@Data
public class UserDto {
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;
    private boolean active;
    private String role;

    public UserDto(String email, String name, String password, String phone,
                   String address, String role, boolean active){
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.active = active;
        this.role = role;
    }

    private UserDto(UserBuilder userBuilder){
        this.email = userBuilder.email;
        this.password = userBuilder.password;
        this.name = userBuilder.name;
        this.phone = userBuilder.phone;
        this.address = userBuilder.address;
        this.active = userBuilder.active;
        this.role = userBuilder.role;
    }

    public static class UserBuilder{
        private String email;
        private String password;
        private String name;
        private String phone;
        private String address;
        private boolean active;
        private String role;

        public UserBuilder withEmail(String email){
            this.email = email;
            return this;
        }

        public UserBuilder withPassword(String password){
            this.password = password;
            return this;
        }

        public UserBuilder withName(String name){
            this.name = name;
            return this;
        }

        public UserBuilder withPhone(String phone){
            this.phone = phone;
            return this;
        }

        public UserBuilder withAddress(String address){
            this.address = address;
            return this;
        }

        public UserBuilder isActive(boolean active){
            this.active = active;
            return this;
        }

        public UserBuilder withRole(String role){
            this.role = role;
            return this;
        }

        public UserDto build(){
            return new UserDto(this);
        }

    }
}
