import java.io.Serializable;

public class Tenant implements Comparable<Tenant>, Serializable {
    private String name;
    private String apartmentNumber;

    public Tenant() {

    }

    public Tenant(String name, String apartmentNumber) {
        this.name = name;
        this.apartmentNumber = apartmentNumber;
    }

    public String getName() {
        return name;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public int compareTo(Tenant tenant) {
        if (apartmentNumber.equals(tenant.apartmentNumber)) {
            return 0;
        }
        else if (apartmentNumber.compareTo(tenant.apartmentNumber) > 0) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
