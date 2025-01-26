/**
 * Dominick Vician, CEN-3024C-24204, January 20th, 2025
 * Patron
 * This class contains all the information that is relevant to a specific patron,
 * an ID number, a Name, an Address, and how much they owe in Overdue fines,
 * as well as the methods required to set and access that information.
 */

public class Patron {
    private String id;
    private String name;
    private String address;
    private float overdueFine;

    /**
     * method: Patron (Constructor)
     * parameters: String id, String name, String address, float, overdueFine
     * return: None
     * purpose: Initializes a new Patron object with the provided id, name, address, and overdue fine amount.
     */
    public Patron(String id, String name, String address, float overdueFine) {
        setId(id);
        setName(name);
        setAddress(address);
        setOverdueFine(overdueFine);
    }

    /**
     * method: setId
     * parameters: String id
     * return: None
     * purpose: Sets the ID for the patron.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * method: setName
     * parameters: String name
     * return: None
     * purpose: Sets the name for the patron.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method: setAddress
     * parameters: String address
     * return: None
     * purpose: Sets the address for the patron.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * method: setOverdueFine
     * parameters: float, overdueFine
     * return: None
     * purpose: Sets the overdue fine amount for the patron.
     */
    public void setOverdueFine(float overdueFine) {
        this.overdueFine = overdueFine;
    }

    /**
     * method: getId
     * parameters: None
     * return: String
     * purpose: Retrieves the ID of the patron.
     */
    public String getId() {
        return id;
    }

    /**
     * method: getName
     * parameters: None
     * return: String
     * purpose: Retrieves the name of the patron.
     */
    public String getName() {
        return name;
    }

    /**
     * method: getAddress
     * parameters: None
     * return: String
     * purpose: Retrieves the address of the patron.
     */
    public String getAddress() {
        return address;
    }

    /**
     * method: getOverdueFine
     * parameters: None
     * return: float
     * purpose: Retrieves the overdue fine amount for the patron.
     */
    public float getOverdueFine() {
        return overdueFine;
    }

    /**
     * method: toString
     * parameters: None
     * return: String
     * purpose: Overrides the default toString to return a string representation of the Patron object
     * in the format "id-name-address-overdueFine".
     */
    @Override
    public String toString() {
        return String.format("%s-%s-%s-%.2f",
                id, name, address, overdueFine);
    }
}