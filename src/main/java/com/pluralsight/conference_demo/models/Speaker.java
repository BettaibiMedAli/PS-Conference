package com.pluralsight.conference_demo.models;

import jakarta.persistence.Entity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "speakers")
public class Speaker {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long speaker_id;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    private String title;
    @Column
    private String company;
    @Column
    private String speaker_bio;
    @ManyToMany(mappedBy = "speakers")
    private List<Session> sessions;
    @Lob
    //@Type(type = "org.hibernate.type.BinaryType")
    private byte[] speaker_photo;

    public Speaker(){}
    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public byte[] getSpeaker_photo() {
        return speaker_photo;
    }

    public void setSpeaker_photo(byte[] speaker_photo) {
        this.speaker_photo = speaker_photo;
    }

    public long getSpeaker_id() {
        return speaker_id;
    }

    public void setSpeaker_id(long speaker_id) {
        this.speaker_id = speaker_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpeaker_bio() {
        return speaker_bio;
    }

    public void setSpeaker_bio(String speaker_bio) {
        this.speaker_bio = speaker_bio;
    }
}
