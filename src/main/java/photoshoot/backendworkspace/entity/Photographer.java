package photoshoot.backendworkspace.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("Photographer")
public class Photographer extends Store{
    @Column(name = "place")
    private String place; // 촬영장소
    @Column(name = "isBusiness_trip")
    private Boolean isBusinessTrip; // 출장 가능 여부
}
