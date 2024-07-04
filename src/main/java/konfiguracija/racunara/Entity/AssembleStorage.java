package konfiguracija.racunara.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "assemble_storage")
public class AssembleStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "assemble_id")
    private Assemble assemble;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;


    public AssembleStorage() {
    }

    public AssembleStorage(Assemble assemble, Storage storage) {
        this.assemble = assemble;
        this.storage = storage;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Assemble getAssemble() {
        return assemble;
    }

    public void setAssemble(Assemble assemble) {
        this.assemble = assemble;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
