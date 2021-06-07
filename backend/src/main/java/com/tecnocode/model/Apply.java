package com.tecnocode.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Entity
@Table(name = "apply")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Apply {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "apply_sequence", sequenceName = "apply_sequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vcy_id", referencedColumnName = "vcy_id")
    private Vacancy vacancy;

    @ManyToOne
    @JoinColumn(name = "cdt_id", referencedColumnName = "cdt_id")
    private Candidate candidate;

    @Column(name = "apply_at")
    private LocalDateTime applyAt;

    @Column(name = "vtn_apply")
    private Integer vtn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public LocalDateTime getApplyAt() {
        return applyAt;
    }

    public void setApplyAt(LocalDateTime applyAt) {
        this.applyAt = applyAt;
    }

    public Integer getVtn() {
        return vtn;
    }

    public void setVtn(Integer vtn) {
        this.vtn = vtn;
    }


}