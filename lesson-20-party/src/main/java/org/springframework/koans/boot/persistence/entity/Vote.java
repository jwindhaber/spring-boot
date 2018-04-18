package org.springframework.koans.boot.persistence.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VOTE")
public class Vote {

    private String voteId;
    private String name;
    private Date timestamp;
    private Boolean participate;

    @Id
    @Column(name = "VOTE_ID")
    public String getVoteId() {
        return voteId;
    }

    public void setVoteId(String voteId) {
        this.voteId = voteId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "TIMESTAMP")
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Basic
    @Column(name = "PARTICIPATE")
    public Boolean getParticipate() {
        return participate;
    }

    public void setParticipate(Boolean participate) {
        this.participate = participate;
    }
}
