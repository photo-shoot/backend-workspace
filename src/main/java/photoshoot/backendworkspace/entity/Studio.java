package photoshoot.backendworkspace.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("Studio")
public class Studio extends Store{
    @Column(name = "address")
    private String address;
    @Column(name = "spot")
    private String spot;
    @Column(name = "minute_from_spot")
    private Integer minuteFromSpot;
}
