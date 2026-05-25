package com.example.demo.team13.Team13Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "team13_admin_tbl")
public class Team13Admin {
    @Id
    @NotBlank(message="IDを入力してください")
    @Column(name = "KANRI_ID")
    private String kanriId;

    @Column(name = "KANRI_NM")
    private String kanriNm;
    
    @NotBlank(message="パスワードを入力してください")
    @Column(name = "KANRI_PASS")
    private String kanriPass;
}
//CREATE TABLE team13_admin_tbl(
//		KANRI_ID CHAR(5),
//		KANRI_NM VARCHAR(30) NOT NULL,
//		KANRI_PASS VARCHAR2(30) NOT NULL,
//		PRIMARY KEY(KANRI_ID)
//	);