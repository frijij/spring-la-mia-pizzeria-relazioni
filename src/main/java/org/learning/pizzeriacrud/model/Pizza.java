package org.learning.pizzeriacrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "pizze")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Questo campo non può essere vuoto")
    private String nome;
    @NotBlank(message = "Questo campo non può essere vuoto")
    private String descrizione;
    @Min(1)
    @NotNull(message = "Questo campo non può essere vuoto.")
    private BigDecimal prezzo;
    @NotBlank(message = "Questo campo non può essere vuoto")
    private String urlFoto;

    @OneToMany(mappedBy = "pizza")
    private List<Offerta> offerte;

    public Pizza() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public List<Offerta> getOfferte() {
        return offerte;
    }

    public void setOfferte(List<Offerta> offerte) {
        this.offerte = offerte;
    }
}
