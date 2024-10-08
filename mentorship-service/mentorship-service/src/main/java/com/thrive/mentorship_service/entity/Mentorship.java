//package com.thrive.mentorship_service.entity;
//
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.Data;
//
//import java.util.Date;
//
//
//@Entity
//@Data
//@Table(name = "mentorship")
//public class Mentorship {
//    private Long Id;
//
//
//    @ManyToOne
//    @JoinColumn(name = "mentorId", nullable = false)
//    private Mentor mentor;
//
//    private Date   startDate;
//    private Date  endDate;
//}


package com.thrive.mentorship_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "mentorship")
public class Mentorship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mentorId", nullable = false)
    private Mentor mentor;

    private Date startDate;
    private Date endDate;
}