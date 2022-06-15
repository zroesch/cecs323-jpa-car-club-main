package csulb.cecs323.model;

import javax.persistence.*;

/**
 * Individual, physical automobiles that someone can drive on land to transport one or more passengers
 * and a limited amount of cargo around.  Cars have four wheels and usually travel on paved roads.
 */
@Entity
public class Cars {
    /** The unique ID of the vehicle.  Limited to 17 characters. */
    @Id
    @Column(nullable = false, length = 17)
    private String VIN;

    /** The name of the corporation which manufactured the vehicle.  Limited to 40 characters. */
    @Column(nullable = false, length = 40)
    private String manufacturer;

    /** The popular name of the vehicle, like the Prius for Toyota.  Limited to 20 characters. */
    @Column(nullable = false, length = 20)
    private String model;

    /** The year that the vehicle was manufactured.  For now, do not worry about validating this #. */

    private int car_year;


    /** "Role name" the owner_id in Owners to owner_id in Cars */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owners owner_id;

    // role name auto_body_styles attribute name
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name")
    private auto_body_styles auto_body_style_name;

    public Cars(String VIN, String man, String mod, int year, Owners owner){
        super();
        this.VIN = VIN;
        this.manufacturer = man;
        this.model = mod;
        this.car_year = year;
        this.owner_id = owner;
    }

    public Cars(){}

    @Override
    public String toString () {
        return "Cars - VIN: " + this.VIN + " Manufacturer: " + this.manufacturer +
                " Model: " + this.model + " year: " + this.car_year;
    }


}
