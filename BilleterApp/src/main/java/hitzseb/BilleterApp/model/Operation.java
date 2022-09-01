package hitzseb.BilleterApp.model;

import com.fasterxml.jackson.annotation.JsonView;
import hitzseb.BilleterApp.util.Type;
import hitzseb.BilleterApp.util.Views;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "operations")
@Data
public class Operation {
    @JsonView(Views.Public.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonView(Views.Public.class)
    private String description;
    @JsonView(Views.Public.class)
    private Float amount;
    @JsonView(Views.Public.class)
    @Enumerated(EnumType.STRING)
    private Type type;
    @JsonView(Views.Public.class)
    @OneToOne
    private Category category;
    @JsonView(Views.Public.class)
    private String date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
