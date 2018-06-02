package models;

import java.util.Comparator;

public class Author {
    private int id;
    private String lastname;
    private String firstname;
    private String country;

    public static Comparator<Author> NAME_CMP = new Comparator<Author>() { //sortiert nach Attribut lastname
        public int compare(Author a1, Author a2) {
            return a1.lastname.compareTo(a2.lastname);
        }
    };

    public Author(int id, String lastname, String firstname, String country) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.country = country;
    }

    public int getId() {

        return id;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String toString() {

        return id + " " + lastname + " " + firstname + " (" + country + ")";
    }

    public int hashCode() {

        return id;
    }

    //für equals relevante Attribute: id (einziges Attribut)
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Author other = (Author) obj;
        return (id == other.id);
    }
}
