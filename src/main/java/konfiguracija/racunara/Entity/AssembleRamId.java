package konfiguracija.racunara.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
//gotovo ?
@Embeddable
public class AssembleRamId implements Serializable {
    @Column(name = "assemble_id")
    private Long assembleId;

    @Column(name = "ram_id")
    private Long ramId;

    public AssembleRamId() {
    }

    public AssembleRamId(Long assembleId, Long ramId) {
        this.assembleId = assembleId;
        this.ramId = ramId;
    }

    public Long getAssembleId() {
        return assembleId;
    }

    public void setAssembleId(Long assembleId) {
        this.assembleId = assembleId;
    }

    public Long getRamId() {
        return ramId;
    }

    public void setRamId(Long ramId) {
        this.ramId = ramId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssembleRamId that = (AssembleRamId) o;
        return Objects.equals(assembleId, that.assembleId) && Objects.equals(ramId, that.ramId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assembleId, ramId);
    }
}
