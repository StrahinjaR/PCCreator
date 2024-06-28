package konfiguracija.racunara.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "assemble_ram")
public class AssembleRam {
    @EmbeddedId
    private AssembleRamId id=new AssembleRamId();

    @ManyToOne
    @MapsId("assembleId")
    @JoinColumn(name = "assemble_id")
    private Assemble assemble;

    @ManyToOne
    @MapsId("ramId")
    @JoinColumn(name = "ram_id")
    private RAM ram;

    public AssembleRam(){}
    public AssembleRam(Assemble assemble, RAM ram) {
        this.id = new AssembleRamId((Long) assemble.getId(), (Long) ram.getId());
        this.assemble = assemble;
        this.ram = ram;
    }

    public AssembleRamId getId() {
        return id;
    }

    public void setId(AssembleRamId id) {
        this.id = id;
    }

    public Assemble getAssemble() {
        return assemble;
    }

    public void setAssemble(Assemble assemble) {
        this.assemble = assemble;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }
}
