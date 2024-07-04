package konfiguracija.racunara.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "assemble_ram")
public class AssembleRam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne

    @JoinColumn(name = "assemble_id")
    private Assemble assemble;

    @ManyToOne

    @JoinColumn(name = "ram_id")
    private RAM ram;

    public AssembleRam(){}
    public AssembleRam(Assemble assemble, RAM ram) {
        this.assemble = assemble;
        this.ram = ram;
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

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }
}
