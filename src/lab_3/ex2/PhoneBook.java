package lab_3.ex2;

import java.util.Objects;

public final class PhoneBook implements Comparable<PhoneBook> {
    private String lastname;
    private String firstname;
    private String fathersname;
    private String address;
    private int phoneNumber;

    public PhoneBook(String lastname, String firstname, String fathersname,
                     String address, int phoneNumber) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.fathersname = fathersname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFathersname() {
        return fathersname;
    }

    public void setFathersname(String fathersname) {
        this.fathersname = fathersname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %d", getLastname(), getFirstname(), getFathersname(),
                getAddress(), getPhoneNumber());
    }

    public String printView() {
        return String.format("%s %s %s, адреса: %s, телефон: %d", getLastname(), getFirstname(),
                getFathersname(), getAddress(), getPhoneNumber());
    }

    @Override
    public int compareTo(PhoneBook o) {
        return this.phoneNumber - o.phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PhoneBook phoneBook = (PhoneBook) o;
        return phoneNumber == phoneBook.phoneNumber
                && lastname.equals(phoneBook.lastname)
                && firstname.equals(phoneBook.firstname)
                && fathersname.equals(phoneBook.fathersname)
                && address.equals(phoneBook.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastname, firstname, fathersname, address, phoneNumber);
    }
}
