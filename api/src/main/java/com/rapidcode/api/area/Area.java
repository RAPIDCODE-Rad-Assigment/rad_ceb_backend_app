package com.rapidcode.api.area;

import com.rapidcode.api.meter.Meter;
import com.rapidcode.api.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "area", fetch = FetchType.LAZY)
    private List<Meter> meters;

    @ManyToMany(mappedBy = "assignedAreas", fetch = FetchType.LAZY)
    private List<User> assignedUsers;

}

