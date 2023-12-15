package rob.digital.footballtippingapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime matchDatetime;
    private String stadium;
    private String city;
    private String stage;
    private Integer goalsHomeTeam;
    private Integer goalsAwayTeam;

    @Enumerated(EnumType.STRING)
    private GameStatus status;

    @OneToOne
    @JoinColumn(name = "homeTeam_id", referencedColumnName = "id")
    private Team homeTeam;

    @OneToOne
    @JoinColumn(name = "awayTeam_id", referencedColumnName = "id")
    private Team awayTeam;


}
