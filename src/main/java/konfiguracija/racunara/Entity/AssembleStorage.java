package konfiguracija.racunara.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "assemble_storage")
public class AssembleStorage {

    @EmbeddedId
    private AssembleStorageId id = new AssembleStorageId();

    @ManyToOne
    @MapsId("assembleId")
    @JoinColumn(name = "assemble_id")
    private Assemble assemble;

    @ManyToOne
    @MapsId("storageId")
    @JoinColumn(name = "storage_id")
    private Storage storage;

    // Constructors, getters, and setters
    public AssembleStorage() {
    }

    public AssembleStorage(Assemble assemble, Storage storage) {
        this.assemble = assemble;
        this.storage = storage;
        this.id = new AssembleStorageId((Long) assemble.getId(), (Long) storage.getId());
    }

    public AssembleStorageId getId() {
        return id;
    }

    public void setId(AssembleStorageId id) {
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
