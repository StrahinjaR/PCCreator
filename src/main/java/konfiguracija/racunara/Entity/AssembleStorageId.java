package konfiguracija.racunara.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AssembleStorageId implements Serializable {

    @Column(name = "assemble_id")
    private Long assembleId;

    @Column(name = "storage_id")
    private Long storageId;

    // Constructors, getters, setters, hashCode, and equals
    public AssembleStorageId() {
    }

    public AssembleStorageId(Long assembleId, Long storageId) {
        this.assembleId = assembleId;
        this.storageId = storageId;
    }

    public Long getAssembleId() {
        return assembleId;
    }

    public void setAssembleId(Long assembleId) {
        this.assembleId = assembleId;
    }

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssembleStorageId that = (AssembleStorageId) o;
        return Objects.equals(assembleId, that.assembleId) && Objects.equals(storageId, that.storageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assembleId, storageId);
    }
}
