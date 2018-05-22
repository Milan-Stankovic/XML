package XmlWeb.model;


import XmlWeb.model.Enums.StatusKorisnika;
import XmlWeb.model.Enums.Role;

import javax.persistence.*;
import java.util.List;

@Entity
public class Korisnik {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private boolean aktiviran;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private StatusKorisnika statusNaloga;

    private String email;

    private String pib;

    @OneToMany
    private List<Smestaj> izdaje;

    @OneToMany
    private List<Rezervacija> rezervacije;

    public Korisnik() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAktiviran() {
        return aktiviran;
    }

    public void setAktiviran(boolean aktiviran) {
        this.aktiviran = aktiviran;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public StatusKorisnika getStatusNaloga() {
        return statusNaloga;
    }

    public void setStatusNaloga(StatusKorisnika statusNaloga) {
        this.statusNaloga = statusNaloga;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String adresa) {
        this.email = adresa;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public List<Smestaj> getIzdaje() {
        return izdaje;
    }

    public void setIzdaje(List<Smestaj> izdaje) {
        this.izdaje = izdaje;
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }
}
