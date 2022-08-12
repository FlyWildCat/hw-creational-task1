package ru.pda;

import java.util.Optional;
import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) throws IllegalStateException{
        if (!(name == null) && !(name.equals(""))) {
            this.name = name;
            return this;
        } else {
            throw new IllegalStateException("name обязательно для заполнения");
        }
    }
    public PersonBuilder setSurname(String surname) throws IllegalStateException{
        if (surname != null) {
            this.surname = surname;
            return this;
        } else {
            throw new IllegalStateException("surname обязательно для заполнения");
        }
    }
    public PersonBuilder setAge(int age) throws IllegalArgumentException{
        if (age >= 0) {
            this.age = age;
            return this;
        } else {
            throw new IllegalArgumentException("age is only a positive value");
        }
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException{
        if (name == null) {
            throw new IllegalStateException("name обязательно при заполнении");
        } else if (surname == null) {
            throw new IllegalStateException("surname обязательно при заполнении");
        }
        Person p = new Person(name, surname, OptionalInt.empty().orElse(age));
        Optional<String> opt = Optional.ofNullable(address);
        opt.ifPresent(p::setAddress);

        return p;
    }
}