package org.zerock.b01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;



@Entity
@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity {
    @Id
    @Column(length = 50, nullable = false)
    private String memberId;
    @Column(length = 50, nullable = false)
    private String memberPw;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String phone;
    @Column(length = 50, nullable = false)
    private String email1;
    @Column(length = 50, nullable = false)
    private String email2;
    @Column(length = 10)
    private String gender;
    private boolean agree;
}
