package rob.digital.footballtippingapp.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Builder
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Name;
    private Integer win;
    private Integer draw;
    private Integer loss;
    private Integer goalsScored;
    private Integer goalsLost;
    private Integer points;
    private String belongsToGroup;
    private String countryCode;
    private Integer positionInTable;
}
