package photoshoot.backendworkspace.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long categoryId;

    private String name;

    @ManyToMany(mappedBy = "categoryList")
    private List<Store> storeList;

}
